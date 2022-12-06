package am.jsl.personalfinances.web.controller;

import am.jsl.personalfinances.domain.user.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Definiuje metodę pobierania bieżącego użytkownika ze stron.
 */
@ControllerAdvice
public class CurrentUserController extends BaseController {

    /**
     * Rozwiązuje i zwraca bieżącego użytkownika z wiosennego kontekstu zabezpieczeń.
     * @param currentUser Dane użytkownika
     * @return Dane użytkownika
     */
    @ModelAttribute("currentUser")
    public UserDetails getCurrentUser(@AuthenticationPrincipal UserDetails currentUser) {
        User user = (User) currentUser;
        if (user != null && user.getId() == 0) {
            user = (User) userService.loadUserByUsername(user.getLogin());
        }
        return user;
    }
}
