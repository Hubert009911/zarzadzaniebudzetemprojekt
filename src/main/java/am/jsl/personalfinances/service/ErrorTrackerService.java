package am.jsl.personalfinances.service;

/**
 * Interfejs usługi, który definiuje metodę wysyłania szczegółów wyjątku pocztą e-mail.
 */
public interface ErrorTrackerService {

    /**
     * Wysyła e-mailem szczegóły wyjątku.
     * @param e Wyjątek
     */
    void sendError(final Exception e);
}
