package am.jsl.personalfinances.service.event;

import am.jsl.personalfinances.domain.event.Event;
import am.jsl.personalfinances.domain.event.EventType;
import am.jsl.personalfinances.dto.event.EventListDTO;
import am.jsl.personalfinances.search.EventSearchQuery;
import am.jsl.personalfinances.search.ListPaginatedResult;

/**
 * Interfejs serwisowy, który definiuje wszystkie metody pracy z {@link Event}
 */
public interface EventService {
    /**
     * Zapisuje dane zdarzenie.
     * @param event zdarzenie
     */
    void saveEvent(Event event);

    /**
     * Tworzy zdarzenie z podanymi opcjami.
     * @param eventType Typ zdarzenia
     * @param message wiadomość
     * @param performedBy identyfikator użytkownika
     */
    void saveEvent(EventType eventType, String message, long performedBy);

    /**
     * Pobiera wynik podzielony na strony dla danego zapytania.
     * @param searchQuery the {@link EventSearchQuery} containing query options
     * @return the {@link ListPaginatedResult} result
     */
    ListPaginatedResult<EventListDTO> search(EventSearchQuery searchQuery);
}
