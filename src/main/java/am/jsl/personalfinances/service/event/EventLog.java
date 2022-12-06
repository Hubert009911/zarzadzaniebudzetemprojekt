package am.jsl.personalfinances.service.event;

import am.jsl.personalfinances.domain.event.EventType;
import am.jsl.personalfinances.domain.user.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Klasa Singletone do tworzenia zdarzeń.
 */
@Component
public class EventLog implements Serializable, ApplicationContextAware {

    /**
     * instancja EventLog 
     */
    private static EventLog log = null;

    /**
     * ApplicationContext
     */
    private static ApplicationContext context;

    /**
     * EventService
     */
    private EventService eventService;

    /**
     * Private constructor
     */
    private EventLog() {
    }

    /**
     * Zwraca pojedyncze wystąpienie EventLog.
     * @return EventLog
     */
    public static EventLog getInstance() {
        if (log == null) {
            log = new EventLog();
            EventService eventService = (EventService) context.getBean("eventService");
            log.setEventService(eventService);
        }
        return log;
    }

    /**
     * Ustawia kontekst aplikacji.
     * @param ac the ApplicationContext
     * @throws BeansException jeśli są zgłaszane przez metody kontekstu aplikacji
     */
    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        context = ac;
    }

    /**
     * Tworzy zdarzenie z podanymi opcjami.
     * @param eventType EventType
     * @param message Wiadomość
     * @param performedBy identyfikator użytkownika
     */
    public void write(EventType eventType, String message, long performedBy) {
        eventService.saveEvent(eventType, message, performedBy);
    }

    /**
     * Tworzy zdarzenie z podanymi opcjami.
     * @param eventType the EventType
     * @param message Wiadomość
     * @param user Użytkownik
     */
    public void write(EventType eventType, String message, User user) {
        eventService.saveEvent(eventType, message, user.getId());
    }

    /**
     * Tworzy zdarzenie z podanymi opcjami.
     * @param eventType the EventType
     * @param performedBy identyfikator użytkownika
     */
    public void write(EventType eventType, long performedBy) {
        eventService.saveEvent(eventType, "", performedBy);
    }

    /**
     * Tworzy zdarzenie z podanymi opcjami.
     * @param eventType the EventType
     * @param user Użytkownik
     */
    public void write(EventType eventType, User user) {
        eventService.saveEvent(eventType, "", user.getId());
    }

    /**
     * Ustawia the EventService
     * @param eventService the EventService
     */
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
}
