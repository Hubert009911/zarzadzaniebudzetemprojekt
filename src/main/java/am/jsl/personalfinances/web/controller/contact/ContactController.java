package am.jsl.personalfinances.web.controller.contact;

import am.jsl.personalfinances.domain.Contact;
import am.jsl.personalfinances.domain.user.User;
import am.jsl.personalfinances.ex.CannotDeleteException;
import am.jsl.personalfinances.service.contact.ContactService;
import am.jsl.personalfinances.web.controller.BaseController;
import am.jsl.personalfinances.web.util.I18n;
import am.jsl.personalfinances.web.util.WebUtils;
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
import javax.validation.Valid;

import static am.jsl.personalfinances.web.util.WebUtils.CONTACT;
import static am.jsl.personalfinances.web.util.WebUtils.CONTACTS;

/**
 * ContactController definiuje metody funkcjonalności stron kontaktowych
 * takie jak wyszukiwanie, przeglądanie, dodawanie, edytowanie kontaktów.
 */
@Controller
@RequestMapping(value = "/contact")
@Lazy
public class ContactController extends BaseController {
    /**
     * Ścieżki szablonów kontaktów
     */
    public static final String REDIRECT_CONTACT_LIST = "redirect:list";
    public static final String FORWARD_CONTACT_LIST = "contact/contact-list";
    public static final String FORWARD_CONTACT_LOOKUP_LIST = "contact/contact-lookup-result :: contactLookupList";
    public static final String FORWARD_CONTACT_MANAGE = "contact/contact-manage :: contactFormDiv";

    /**
     * The ContactService
     */
    @Autowired
    private transient ContactService contactService;

    /**
     * Wywołany, gdy lista kontaktów została załadowana.
     *
     * @param model Model
     * @return Strona listy kontaktów
     */
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String list(Model model) {
        User user = getUser();
        model.addAttribute(CONTACTS, contactService.list(user.getId()));
        return FORWARD_CONTACT_LIST;
    }

    /**
     * Wywoływane przez ajax metody pobierania opcji wyboru kontaktu.
     *
     * @param model Model
     * @return Szablon Opcje wyboru kontaktu
     */
    @RequestMapping(value = {"/lookup"}, method = RequestMethod.GET)
    public String lookup(Model model) {
        User user = getUser();
        model.addAttribute(CONTACTS, contactService.lookup(user.getId()));
        return FORWARD_CONTACT_LOOKUP_LIST;
    }

    /**
     * Wywoływany, gdy użytkownik kliknie link Dodaj ze strony listy kontaktów.
     *
     * @param model Model
     * @return Szablon Zarządzanie kontaktami
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage(Model model) {
        if (!model.containsAttribute(CONTACT)) {
            model.addAttribute(CONTACT, new Contact());
        }
        return FORWARD_CONTACT_MANAGE;
    }

    /**
     * Wywoływany, gdy użytkownik kliknie link edytuj ze strony listy kontaktów.
     *
     * @param id    Identyfikator kontaktu
     * @param model Model
     * @return Szablon Zarządzanie kontaktami
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage(@RequestParam(value = "id", required = true)
                                   long id, Model model) {
        if (!model.containsAttribute(CONTACT)) {
            User user = getUser();
            Contact contact = contactService.get(id, user.getId());
            model.addAttribute(CONTACT, contact);
        }
        return FORWARD_CONTACT_MANAGE;
    }

    /**
     * Wywoływany, gdy użytkownik kliknie link Zapisz kontakt.
     *
     * @param request       the HttpServletRequest
     * @param contact       Kontakt
     * @param redirectAttrs the RedirectAttributes
     * @return Strona listy kontaktów
     * @throws Exception Jeśli wystąpi wyjątek
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(HttpServletRequest request, @Valid @ModelAttribute Contact contact,
                       RedirectAttributes redirectAttrs) throws Exception {
        User user = getUser();
        contact.setUserId(user.getId());
        String message = "";

        if (contact.getId() == 0) {
            message = i18n.msg(request, I18n.KEY_MESSAGE_SUCCESS_ADD,
                    new Object[]{WebUtils.CONTACT, contact.getName()});
            contactService.create(contact);
        } else {
            message = i18n.msg(request, I18n.KEY_MESSAGE_SUCCESS_UPDATE,
                    new Object[]{WebUtils.CONTACT, contact.getName()});
            contactService.update(contact);
        }

        redirectAttrs.addFlashAttribute(I18n.MESSAGE, message);

        return REDIRECT_CONTACT_LIST;
    }

    /**
     * Wywoływane, gdy użytkownik kliknie link do usunięcia kontaktu.
     *
     * @param request       the HttpServletRequest
     * @param id            Identyfikator kontaktu
     * @param redirectAttrs the RedirectAttributes
     * @return Strona listy kontaktów
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(HttpServletRequest request, @RequestParam(value = "id", required = true) long id,
                         RedirectAttributes redirectAttrs) {
        try {
            if (id != 0) {
                User user = getUser();
                Contact contact = contactService.get(id, user.getId());
                contactService.delete(id, user.getId());

                String message = i18n.msg(request, I18n.KEY_MESSAGE_SUCCESS_DELETE,
                        new Object[]{WebUtils.CONTACT, contact.getName()});
                redirectAttrs.addFlashAttribute(I18n.MESSAGE, message);
            }
        } catch (CannotDeleteException e) {
            String message = i18n.msg(request, I18n.KEY_ERROR_CONTACT_DELETE);
            redirectAttrs.addFlashAttribute(I18n.ERROR, message);
        }

        return REDIRECT_CONTACT_LIST;
    }
}