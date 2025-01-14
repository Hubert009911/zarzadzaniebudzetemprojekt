package am.jsl.personalfinances.security;

import am.jsl.personalfinances.log.AppLogger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Niestandardowy program obsługi wyjątków dla klas {@link AccessDeniedException} 
 * Obsługuje AccessDeniedException i przekazuje do strony błędu.
 */
public class AccessDeniedExceptionHandler implements AccessDeniedHandler {
    private static AppLogger logger = new AppLogger(AccessDeniedExceptionHandler.class);
    
    private String errorPage;
    
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException arg2) throws IOException, ServletException {

        logger.debug(String.format("### AccessDeniedHandler: URL [%s] ", request.getServletPath()));
        logger.debug("### Error page: [" + errorPage + "]");
        request.getRequestDispatcher(errorPage).forward(request, response);
    }

    public String getErrorPage() {
        return errorPage;
    }

    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }
}
