package am.jsl.personalfinances.web.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Niestandardowy ErrorController do renderowania błędów.
 */
@Controller
public class CustomErrorController implements ErrorController {

    /**
     * Błąd programu obsługi i zwraca widok błędu.
     * @return widok błędów
     */
    @RequestMapping("/error")
    public String handleError() {
        return "error";
    }

    /**
     * Zwraca ścieżkę widoku błędu.
     * @return ścieżka błędu
     */
    public String getErrorPath() {
        return "/error";
    }
}
