package am.jsl.personalfinances.web.controller.user;

import am.jsl.personalfinances.domain.event.EventType;
import am.jsl.personalfinances.domain.user.Role;
import am.jsl.personalfinances.domain.user.User;
import am.jsl.personalfinances.dto.user.UserDTO;
import am.jsl.personalfinances.ex.DuplicateEmailException;
import am.jsl.personalfinances.ex.DuplicateUserException;
import am.jsl.personalfinances.ex.UserNotFoundException;
import am.jsl.personalfinances.search.ListPaginatedResult;
import am.jsl.personalfinances.search.PageWrapper;
import am.jsl.personalfinances.search.user.UserSearchQuery;
import am.jsl.personalfinances.service.event.EventLog;
import am.jsl.personalfinances.util.Constants;
import am.jsl.personalfinances.web.controller.BaseController;
import am.jsl.personalfinances.web.form.validator.UserValidator;
import am.jsl.personalfinances.web.util.I18n;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;

import static am.jsl.personalfinances.web.util.WebUtils.ROLES;
import static am.jsl.personalfinances.web.util.WebUtils.USER;

/**
 * UserController definiuje metody dla funkcjonalności stron użytkowników z części administratora:
 * takie jak wyszukiwanie, wyświetlanie, dodawanie, edytowanie użytkowników.
 */
@Controller
@RequestMapping(value = "/user")
@PreAuthorize("hasAuthority('ADMIN')")
@Lazy
public class UserController extends BaseController {
    /**
     * Ścieżki szablonów użytkownika
     */
    public static final String REDIRECT_USER_LIST = "redirect:list";
    public static final String FORWARD_USER_LIST = "system/user/user-list";
    public static final String FORWARD_USER_RESULT_LIST = "system/user/user-list-result :: userResultsList";
    public static final String FORWARD_USER_EDIT = "system/user/user-edit";
    public static final String FORWARD_USER_ADD = "system/user/user-add";
    public static final String REDIRECT_USER_ADD = "redirect:/user/add";
    public static final String FORWARD_USER_VIEW = "system/user/user-view";

    /**
     * Walidator użytkownika
     */
    @Autowired
    private transient UserValidator userFormValidator;

    /**
     * Kontroler domyślny.
     */
    public UserController() {
        super();
    }

    /**
     * Rejestruje moduł sprawdzania poprawności użytkownika.
     *
     * @param binder internetowy segregator danych
     */
    @InitBinder("userDTO")
    public void initUserBinder(WebDataBinder binder) {
        binder.addValidators(userFormValidator);
    }

    /**
     * Wywoływana po otwarciu listy użytkowników.
     *
     * @return lista użytkowników
     */
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String list() {
        return FORWARD_USER_LIST;
    }

    /**
     * Wywoływana metodą ajax do ładowania użytkowników z podanej strony.
     *
     * @param model Model
     * @param page  Strona
     * @return szablon listy użytkowników
     */
    @RequestMapping(value = {"/loadUsers"}, method = RequestMethod.GET)
    public String loadUsers(Model model, @RequestParam int page) {
        UserSearchQuery query = new UserSearchQuery(page, Constants.PAGE_SIZE);
        ListPaginatedResult<User> result = userService.search(query);

        PageWrapper<User> pageWrapper = new PageWrapper<>(result, page, Constants.PAGE_SIZE);
        model.addAttribute(Constants.PAGE, pageWrapper);

        return FORWARD_USER_RESULT_LIST;
    }

    /**
     * Wywoływana, gdy administrator kliknie łącze przeglądania użytkownika.
     *
     * @param request żądanie serwletu HTTP
     * @param id      identyfikator użytkownika
     * @param model   model
     * @return widok szablonu użytkownika
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(HttpServletRequest request, @RequestParam(value = "id", required = true)
            long id, Model model) {
        try {
            if (!model.containsAttribute(USER)) {
                User user = userService.getUser(id);
                model.addAttribute(USER, UserDTO.from(user));
            }
            return FORWARD_USER_VIEW;
        } catch (UserNotFoundException e) {
            i18n.addNotFoundError(request, model, new Object[]{"user id", id});
            return REDIRECT_USER_LIST;
        }
    }

    /**
     * Wywoływana, gdy administrator kliknie łącze dodawania ze strony listy użytkowników.
     *
     * @param model Model
     * @return stronę dodawania użytkownika
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage(Model model) {
        if (!model.containsAttribute(USER)) {
            model.addAttribute(USER, new UserDTO());
            model.addAttribute(ROLES, Role.values());
        }
        return FORWARD_USER_ADD;
    }

    /**
     * Wywoływana, gdy administrator kliknie łącze dodawania ze strony dodawania użytkownika.
     *
     * @param request       żądanie serwletu HTTP
     * @param userDTO       żądanie serwletu HTTP
     * @param result        wiążący wynik
     * @param redirectAttrs atrybuty przekierowania
     * @return stronę użytkownika
     * @throws Exception jeśli wystąpi wyjątek
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(HttpServletRequest request, @Valid @ModelAttribute UserDTO userDTO,
                      BindingResult result, RedirectAttributes redirectAttrs) throws Exception {

        if (result.hasErrors()) {
            redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
            redirectAttrs.addFlashAttribute(USER, userDTO);
            redirectAttrs.addFlashAttribute(ROLES, Role.values());
            return REDIRECT_USER_ADD;
        }

        try {
            User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userDTO.toUser();
            user.setCreatedAt(LocalDateTime.now());
            user.setChangedAt(LocalDateTime.now());
            userService.create(user);

            String message = i18n.msg(request, I18n.KEY_MESSAGE_SUCCESS_ADD,
                    new Object[]{USER, userDTO.getLogin()});
            redirectAttrs.addFlashAttribute(I18n.MESSAGE, message);

            EventLog.getInstance().write(EventType.CREATE_USER, user.toString(), userDetails.getId());
        } catch (DuplicateUserException unf) {
            String message = i18n.msg(request, I18n.KEY_ERROR_DUPLICATE,
                    new Object[]{USER, userDTO.getLogin()});
            redirectAttrs.addFlashAttribute(I18n.ERROR, message);
            return REDIRECT_USER_ADD;
        } catch (DuplicateEmailException ex) {
            String message = i18n.msg(request, I18n.KEY_ERROR_DUPLICATE,
                    new Object[]{USER, userDTO.getEmail()});
            redirectAttrs.addFlashAttribute(I18n.ERROR, message);
            return REDIRECT_USER_ADD;
        }

        return REDIRECT_USER_LIST;
    }

    /**
     * Wywoływana, gdy użytkownik kliknie łącze edycji na stronie z listą użytkowników.
     *
     * @param request the HttpServletRequest
     * @param id      identyfikator użytkownika
     * @param model   Model
     * @return stronę edycji użytkownika
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage(HttpServletRequest request, @RequestParam(value = "id", required = true)
            long id, Model model) {
        try {
            if (!model.containsAttribute(USER)) {
                User user = userService.getUser(id);
                model.addAttribute(USER, UserDTO.from(user));
                model.addAttribute(ROLES, Role.values());
            }
            return FORWARD_USER_EDIT;
        } catch (UserNotFoundException e) {
            i18n.addNotFoundError(request, model, new Object[]{"user id", id});
            return REDIRECT_USER_LIST;
        }
    }

    /**
     * Wywoływana, gdy użytkownik kliknie przycisk zapisu na stronie edycji użytkownika.
     *
     * @param request       the HttpServletRequest
     * @param userDTO       DTO użytkownika
     * @param result        the BindingResult
     * @param redirectAttrs the RedirectAttributes
     * @return Strona edycji użytkownika
     * @throws Exception Jeśli wystąpi wyjątek
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(HttpServletRequest request, @Valid @ModelAttribute UserDTO userDTO,
                       BindingResult result, RedirectAttributes redirectAttrs) throws Exception {
        if (result.hasErrors()) {
            redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
            redirectAttrs.addFlashAttribute(USER, userDTO);
            return "redirect:/user/edit?id=" + userDTO.getId();
        }

        try {
            User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userDTO.toUser();
            user.setChangedAt(LocalDateTime.now());
            user.setChangedBy(userDetails.getId());
            userService.update(user);

            String message = i18n.msg(request, I18n.KEY_MESSAGE_SUCCESS_UPDATE,
                    new Object[]{USER, userDTO.getLogin()});
            redirectAttrs.addFlashAttribute(I18n.MESSAGE, message);

            EventLog.getInstance().write(EventType.UPDATE_USER, user.toString(), userDetails.getId());
        } catch (DuplicateUserException unf) {
            String message = i18n.msg(request, I18n.KEY_ERROR_DUPLICATE,
                    new Object[]{USER, userDTO.getLogin()});
            redirectAttrs.addFlashAttribute(I18n.ERROR, message);
            return "redirect:/user/edit?id=" + userDTO.getId();
        } catch (DuplicateEmailException ex) {
            String message = i18n.msg(request, I18n.KEY_ERROR_DUPLICATE,
                    new Object[]{USER, userDTO.getEmail()});
            redirectAttrs.addFlashAttribute(I18n.ERROR, message);
            return "redirect:/user/edit?id=" + userDTO.getId();
        }

        return REDIRECT_USER_LIST;
    }

    /**
     * Wywoływane, gdy administrator kliknie link do usunięcia użytkownika.
     *
     * @param request       the HttpServletRequest
     * @param id            identyfikator użytkownika
     * @param model         Model
     * @param redirectAttrs the RedirectAttributes
     * @return Lista użytkowników
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(HttpServletRequest request, @RequestParam(value = "id", required = true) long id,
                         Model model, RedirectAttributes redirectAttrs) {

        try {
            if (id != 0) {
                User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                User user = userService.getUser(id);
                userService.deleteUser(user);

                String message = i18n.msg(request, I18n.KEY_MESSAGE_SUCCESS_DELETE,
                        new Object[]{USER, user.getLogin()});
                redirectAttrs.addFlashAttribute(I18n.MESSAGE, message);

                EventLog.getInstance().write(EventType.DELETE_USER, user.toString(), userDetails.getId());
            }
        } catch (UserNotFoundException e) {
            i18n.addNotFoundError(request, model, new Object[]{"user id", id});
        }

        return REDIRECT_USER_LIST;
    }
}