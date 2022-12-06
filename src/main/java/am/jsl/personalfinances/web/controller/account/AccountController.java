package am.jsl.personalfinances.web.controller.account;

import am.jsl.personalfinances.domain.account.Account;
import am.jsl.personalfinances.domain.user.User;
import am.jsl.personalfinances.dto.account.AccountDTO;
import am.jsl.personalfinances.dto.account.AccountListDTO;
import am.jsl.personalfinances.dto.account.AdjustBalanceDTO;
import am.jsl.personalfinances.ex.CannotDeleteException;
import am.jsl.personalfinances.service.account.AccountService;
import am.jsl.personalfinances.service.currency.CurrencyService;
import am.jsl.personalfinances.web.controller.BaseController;
import am.jsl.personalfinances.web.util.I18n;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

import static am.jsl.personalfinances.web.util.WebUtils.*;

/**
 * AccountController definiuje metody funkcjonalności stron konta
 * takie jak wyszukiwanie, przeglądanie, dodawanie, edytowanie kont.
 */
@Controller
@RequestMapping(value = "/account")
@Lazy
public class AccountController extends BaseController {
    /**
     * Ścieżki szablonów kont
     */
    public static final String REDIRECT_ACCOUNT_LIST = "redirect:list";
    public static final String FORWARD_ACCOUNT_LIST = "account/account-list";
    public static final String FORWARD_ACCOUNT_EDIT = "account/account-edit";
    public static final String FORWARD_ACCOUNT_ADD = "account/account-add";
    public static final String FORWARD_ACCOUNT_LOOKUP_LIST = "account/account-lookup-result :: accountLookupList";

    /**
     * Usługa konta
     */
    @Autowired
    private transient AccountService accountService;

    /**
     * Currency Service
     */
    @Autowired
    private transient CurrencyService currencyService;

    /**
     * Wywoływane, gdy użytkownik otwiera listę kont.
     *
     * @param model Model
     * @return Lista zwrotów kont
     */
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String list(Model model) {
        User user = getUser();
        List<AccountListDTO> accounts = accountService.getAccounts(user.getId());
        model.addAttribute(ACCOUNTS, accounts);
        return FORWARD_ACCOUNT_LIST;
    }

    /**
     * Wywoływane przez ajax metody pobierania opcji wyboru konta.
     *
     * @param model Model
     * @return  Zwracanie szablonu wyszukiwania konta
     */
    @RequestMapping(value = {"/lookup"}, method = RequestMethod.GET)
    public String lookup(Model model) {
        User user = getUser();
        model.addAttribute(ACCOUNTS, accountService.lookup(user.getId()));
        return FORWARD_ACCOUNT_LOOKUP_LIST;
    }

    /**
     * Wywoływane, gdy użytkownik kliknie link Dodaj ze strony listy kont.
     *
     * @param model Model
     * @return Strona Dodawanie konta
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage(Model model) {
        if (!model.containsAttribute(ACCOUNT)) {
            model.addAttribute(ACCOUNT, new AccountDTO());
            model.addAttribute(CURRENCIES, currencyService.list());
        }
        return FORWARD_ACCOUNT_ADD;
    }

    /**
     * Wywołany, gdy użytkownik kliknie link dodaj na stronie dodawania konta.
     *
     * @param request       the HttpServletRequest
     * @param accountDTO    the AccountDTO
     * @param redirectAttrs the RedirectAttributes
     * @return Lista kont
     * @throws Exception Jeśli wystąpi wyjątek
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(HttpServletRequest request, @ModelAttribute AccountDTO accountDTO,
                      RedirectAttributes redirectAttrs) throws Exception {
        Account account = accountDTO.toAccount();
        User user = getUser();
        account.setCreatedAt(LocalDateTime.now());
        account.setUserId(user.getId());
        accountService.create(account);

        String message = i18n.msg(request, I18n.KEY_MESSAGE_SUCCESS_ADD,
                new Object[]{ACCOUNT, account.getName()});
        redirectAttrs.addFlashAttribute(I18n.MESSAGE, message);

        return REDIRECT_ACCOUNT_LIST;
    }

    /**
     * Wywoływane, gdy użytkownik kliknie link edycji na stronie kont.
     *
     * @param id    identyfikator konta
     * @param model Model
     * @return Strona Edytuj konto
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage(@RequestParam(value = "id") long id, Model model) {
        if (!model.containsAttribute(ACCOUNT)) {
            User user = getUser();
            Account account = accountService.get(id, user.getId());
            model.addAttribute(ACCOUNT, AccountDTO.from(account));
            model.addAttribute(CURRENCIES, currencyService.list());
        }
        return FORWARD_ACCOUNT_EDIT;
    }

    /**
     * Wywoływane, gdy użytkownik kliknie link edycji na stronie edytuj konto.
     *
     * @param request       the HttpServletRequest
     * @param accountDTO    the AccountDTO
     * @param redirectAttrs the RedirectAttributes
     * @return Strona listy kont
     * @throws Exception Jeśli wystąpi wyjątek
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(HttpServletRequest request, @ModelAttribute AccountDTO accountDTO,
                       RedirectAttributes redirectAttrs) throws Exception {
        Account account = accountDTO.toAccount();
        User user = getUser();
        account.setUserId(user.getId());

        accountService.update(account);

        String message = i18n.msg(request, I18n.KEY_MESSAGE_SUCCESS_UPDATE,
                new Object[]{ACCOUNT, account.getName()});
        redirectAttrs.addFlashAttribute(I18n.MESSAGE, message);

        return REDIRECT_ACCOUNT_LIST;
    }

    /**
     * Wywoływany, gdy użytkownik kliknie link do usunięcia konta.
     *
     * @param request       the HttpServletRequest
     * @param id            the account id
     * @param redirectAttrs the RedirectAttributes
     * @return Strona listy kont
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(HttpServletRequest request, @RequestParam(value = "id") long id,
                         RedirectAttributes redirectAttrs) {
        try {
            if (id != 0) {
                User user = getUser();
                Account account = accountService.get(id, user.getId());
                accountService.delete(id, user.getId());

                String message = i18n.msg(request, I18n.KEY_MESSAGE_SUCCESS_DELETE,
                        new Object[]{ACCOUNT, account.getName()});
                redirectAttrs.addFlashAttribute(I18n.MESSAGE, message);
            }
        } catch (CannotDeleteException e) {
            String message = i18n.msg(request, I18n.KEY_ERROR_ACCOUNT_DELETE);
            redirectAttrs.addFlashAttribute(I18n.ERROR, message);
        }

        return REDIRECT_ACCOUNT_LIST;
    }

    /**
     * Wywoływany, gdy użytkownik kliknie link zapisz w oknie dialogowym dopasowywania salda.
     *
     * @param adjustBalance the AdjustBalanceDTO
     * @return Strona listy kont
     */
    @RequestMapping(value = "/adjustBalance", method = RequestMethod.POST)
    public String adjustBalance(@ModelAttribute AdjustBalanceDTO adjustBalance) {
        adjustBalance.setUserId(getUser().getId());
        accountService.updateBalance(adjustBalance);

        return REDIRECT_ACCOUNT_LIST;
    }
}