package am.jsl.personalfinances.web.controller;

import am.jsl.personalfinances.domain.user.User;
import am.jsl.personalfinances.log.AppLogger;
import am.jsl.personalfinances.service.user.UserService;
import am.jsl.personalfinances.web.util.I18n;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Klasa bazowa dla wszystkich kontrolerów.
 * Zawiera wspólne pola i metody.
 */
public class BaseController implements Serializable {
    protected static final AppLogger log = new AppLogger(BaseController.class);

    /**
     * Obsługa użytkownika
     */
    @Autowired
    protected transient UserService userService;

    /**
     * Opakowanie komunikatu internacjonalizacji.
     * @see I18n
     */
    @Autowired
    protected I18n i18n;

    /**
     * Zwraca bieżącego użytkownika z Spring Security Context.
     * @return użytkownik
     */
    protected User getUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (user != null && user.getId() == 0) {
            user = (User) userService.loadUserByUsername(user.getLogin());
        }
        return user;
    }

    /**
     * Wyodrębnia i zwraca adres URL aplikacji z żądania.
     * @param request the HttpServletRequest
     * @return adres URL aplikacji
     */
    protected String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

}
