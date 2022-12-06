package am.jsl.personalfinances.search;

import am.jsl.personalfinances.dto.event.EventListDTO;

import java.util.Date;

/**
 * Custom {@link Query} do wyszukiwania elementów.{@link EventListDTO}
 */
public class EventSearchQuery extends Query<EventListDTO> {
    private int eventType;
    private long performedBy;
    private Date createdAtStart = null;
    private Date createdAtEnd = null;
    private String message;

    /**
     * Tworzy nowe zapytanie wyszukiwania zdarzeń.
     *
     * @param page     strona
     * @param pageSize rozmiar strony
     */
    public EventSearchQuery(int page, int pageSize) {
        super(page, pageSize);
    }


    /**
     * Pobiera event type.
     *
     * @return the event type
     */
    public int getEventType() {
        return eventType;
    }

    /**
     * Ustawia event type.
     *
     * @param eventType the event type
     */
    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    /**
     * Pobiera performed by.
     *
     * @return the performed by
     */
    public long getPerformedBy() {
        return performedBy;
    }

    /**
     * Ustawia performed by.
     *
     * @param performedBy the performed by
     */
    public void setPerformedBy(long performedBy) {
        this.performedBy = performedBy;
    }

    /**
     * Pobiera created at start.
     *
     * @return the created at start
     */
    public Date getCreatedAtStart() {
        return createdAtStart;
    }

    /**
     * Ustawia created at start.
     *
     * @param createdAtStart the created at start
     */
    public void setCreatedAtStart(Date createdAtStart) {
        this.createdAtStart = createdAtStart;
    }

    /**
     * Pobiera created at end.
     *
     * @return the created at end
     */
    public Date getCreatedAtEnd() {
        return createdAtEnd;
    }

    /**
     * Ustawia created at end.
     *
     * @param createdAtEnd the created at end
     */
    public void setCreatedAtEnd(Date createdAtEnd) {
        this.createdAtEnd = createdAtEnd;
    }

    /**
     * Pobiera message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Ustawia message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
