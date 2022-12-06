package am.jsl.personalfinances.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Prosty wrapper do logowania slf4j, który pozwoli na łatwe przejście na inny system logowania.
 */
public final class AppLogger {

    /**
     * Prawdziwa instancja rejestratora.
     */
    private final Logger log;

    /**
     * Konstruuje nowy AppLogger dla danej klasy.
     * @param clazz class
     */
    public AppLogger(Class clazz) {
        log = LoggerFactory.getLogger(clazz);
    }

    /**
     * Rejestruje dany wyjątek na poziomie ERROR z podanym komunikatem.
     * @param message Wiadomość
     * @param exception Wyjątek
     */
    public void error(String message, Exception exception) {
        log.error(message, exception);
    }

    /**
     * Rejestruje dany rzut na poziomie ERROR z podanym komunikatem.
     * @param message Wiadomość
     * @param throwable  Throwable
     */
    public void error(String message, Throwable throwable) {
        log.error(message, throwable);
    }

    /**
     * Rejestruje podany komunikat na poziomie ERROR.
     * @param message  Wiadomość
     */
    public void error(String message) {
        log.error(message);
    }

    /**
     * Rejestruje podany komunikat na poziomie DEBUG.
     * @param message Wiadomość
     */
    public void debug(String message) {
        log.debug(message);
    }

    /**
     * Rejestruje komunikat na poziomie DEBUG z podanym formatem i argumentem.
     * @param format Format
     * @param argument Argument
     */
    public void debug(String format, Object argument) {
        log.debug(format, argument);
    }

    /**
     * Rejestruje podaną wiadomość na poziomie INFO.
     * @param message Wiadomość
     */
    public void info(String message) {
        log.info(message);
    }
}
