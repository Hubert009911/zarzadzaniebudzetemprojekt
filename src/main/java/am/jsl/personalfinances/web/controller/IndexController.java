package am.jsl.personalfinances.web.controller;

import am.jsl.personalfinances.web.util.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Definiuje metody przekierowywania użytkowników na stronę główną lub stronę administratora.
 */
@Controller
public class IndexController {

    /**
     * Mapowanie strony głównej.
     * Ustawia bieżącą nazwę użytkownika w modelu i zwraca stronę główną.
     * @param model Mapa modelu
     * @return Strona główna
     */
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("user", getCurrentUsername());
        return WebUtils.PAGE_HOME;
    }

    /**
     * Mapowanie strony głównej administratora.
     * @param model  Mapa modelu
     * @return Strona główna administratora
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getCurrentUsername());
        return WebUtils.PAGE_ADMIN;
    }

    /**
     * Mapowanie strony odmowy dostępu.
     * @param model Mapa modelu
     * @return Strona odmowy dostępu
     */
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getCurrentUsername());
        return "accessDenied";
    }

    /**
     * Wylogowuje bieżącego użytkownika z Spring Security Context i przekierowuje do strony wylogowania.
     * @param request the HttpServletRequest
     * @param response the HttpServletResponse
     * @return Strona wylogowania
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    /**
     * Zwraca bieżącą nazwę użytkownika z kontekstu zabezpieczeń Springs.
     * @return Bieżąca nazwa użytkownika
     */
    private String getCurrentUsername() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
