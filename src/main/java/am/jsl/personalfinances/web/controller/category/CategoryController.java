package am.jsl.personalfinances.web.controller.category;

import am.jsl.personalfinances.domain.Category;
import am.jsl.personalfinances.domain.user.User;
import am.jsl.personalfinances.dto.CategoryDTO;
import am.jsl.personalfinances.ex.CannotDeleteException;
import am.jsl.personalfinances.service.category.CategoryService;
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
import java.util.List;

import static am.jsl.personalfinances.web.util.WebUtils.CATEGORIES;
import static am.jsl.personalfinances.web.util.WebUtils.CATEGORY;

/**
 * Kategoria definiuje metody działania stron kategorii
 * takie jak wyszukiwanie, wyświetlanie, dodawanie, edytowanie kategorii.
 */
@Controller
@RequestMapping(value = "/category")
@Lazy
public class CategoryController extends BaseController {
    /**
     * Ścieżki szablonów kategorii
     */
    public static final String REDIRECT_CATEGORY_LIST = "redirect:list";
    public static final String FORWARD_CATEGORY_LIST = "category/category-list";
    public static final String FORWARD_CATEGORY_MANAGE = "category/category-manage :: categoryFormDiv";
    public static final String FORWARD_CATEGORY_LOOKUP_LIST = "category/category-lookup-result :: categoryLookupList";

    /**
     * The {@link CategoryService}
     */
    @Autowired
    private transient CategoryService categoryService;

    /**
     * Wywoływana po załadowaniu strony listy kategorii.
     *
     * @param model Model
     * @return Lista kategorii
     */
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String list(Model model) {
        User user = getUser();
        List<CategoryDTO> categories = categoryService.getCategories(user.getId());
        model.addAttribute(CATEGORIES, categories);
        return FORWARD_CATEGORY_LIST;
    }

    /**
     *  Wywoływane przez ajax metody pobierania catgory wybierz opcje.
     *
     * @param model Models
     * @return Szablon wyszukiwania kategorii
     */
    @RequestMapping(value = {"/lookup"}, method = RequestMethod.GET)
    public String lookup(Model model) {
        User user = getUser();
        model.addAttribute(CATEGORIES, categoryService.getCategories(user.getId()));
        return FORWARD_CATEGORY_LOOKUP_LIST;
    }

    /**
     * Wywoływany, gdy użytkownik kliknie link dodaj ze strony listy kategorii.
     *
     * @param model Model
     * @return Szablon zarządzania kategorią
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage(Model model) {
        if (!model.containsAttribute(CATEGORY)) {
            User user = getUser();
            List<CategoryDTO> categories = categoryService.lookupParentCategories(user.getId());
            model.addAttribute(CATEGORY, new Category());
            model.addAttribute(CATEGORIES, categories);
        }
        return FORWARD_CATEGORY_MANAGE;
    }

    /**
     * Wywoływany, gdy użytkownik kliknie link edytuj ze strony listy kategorii.
     *
     * @param id    Identyfikator kategorii
     * @param model Model
     * @return Szablon zarządzania kategorią
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage(@RequestParam(value = "id", required = true)
                                   long id, Model model) {
        if (!model.containsAttribute(CATEGORY)) {
            User user = getUser();
            List<CategoryDTO> categories = categoryService.lookupParentCategories(user.getId());
            Category category = categoryService.get(id, user.getId());
            model.addAttribute(CATEGORY, category);
            model.addAttribute(CATEGORIES, categories);
        }
        return FORWARD_CATEGORY_MANAGE;
    }

    /**
     * Wywoływany, gdy użytkownik kliknie przycisk Zapisz na stronie zarządzania kategorią.
     *
     * @param request       the HttpServletRequest
     * @param redirectAttrs the RedirectAttributes
     * @param category      Kategoria
     * @return Lista kategorii
     * @throws Exception Jeśli wystąpi wyjątek
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(HttpServletRequest request, RedirectAttributes redirectAttrs,
                       @ModelAttribute Category category) throws Exception {
        User user = getUser();
        category.setUserId(user.getId());

        if (category.getParentId() == category.getId()) {
            category.setParentId(0);
        }
        String message = "";

        if (category.getId() == 0) { // tworzenie
            categoryService.create(category);
            message = i18n.msg(request, I18n.KEY_MESSAGE_SUCCESS_ADD,
                    new Object[]{WebUtils.CATEGORY, category.getName()});
        } else { // aktualizacja
            message = i18n.msg(request, I18n.KEY_MESSAGE_SUCCESS_UPDATE,
                    new Object[]{WebUtils.CATEGORY, category.getName()});

            categoryService.update(category);
        }
        redirectAttrs.addFlashAttribute(I18n.MESSAGE, message);

        return REDIRECT_CATEGORY_LIST;
    }

    /**
     * Wywoływany, gdy użytkownik kliknie link usuń kategorię.
     *
     * @param request       the HttpServletRequest
     * @param id            Identyfikator kategorii
     * @param redirectAttrs the RedirectAttributes
     * @return Lista kategorii
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(HttpServletRequest request, @RequestParam(value = "id", required = true) long id,
                         RedirectAttributes redirectAttrs) {
        try {
            if (id != 0) {
                User user = getUser();
                Category category = categoryService.get(id, user.getId());
                categoryService.delete(id, user.getId());

                String message = i18n.msg(request, I18n.KEY_MESSAGE_SUCCESS_DELETE,
                        new Object[]{WebUtils.CATEGORY, category.getName()});
                redirectAttrs.addFlashAttribute(I18n.MESSAGE, message);
            }
        } catch (CannotDeleteException e) {
            String message = i18n.msg(request, I18n.KEY_ERROR_CATEGORY_DELETE);
            redirectAttrs.addFlashAttribute(I18n.ERROR, message);
        }

        return REDIRECT_CATEGORY_LIST;
    }
}