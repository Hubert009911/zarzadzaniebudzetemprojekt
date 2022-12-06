package am.jsl.personalfinances.domain.event;

import am.jsl.personalfinances.domain.BaseEntity;

import java.io.Serializable;

/**
 * Obiekt domeny zdarzeń.
 */
public class Event extends BaseEntity implements Serializable {

	/**
	 * Rodzaj wydarzenia
	 * @see EventType
	 */
	private byte eventType;

	/**
	 * Komunikat o zdarzeniu
	 */
	private String message;

	/**
	 * Identyfikator użytkownika utworzony przez zdarzenie
	 */
	private long performedBy;

	/**
	 *  Konstruuje nowe zdarzenie z podanymi polami.
	 *
	 * @param eventType Typ zdarzenia
	 * @param message Komunikat o wydarzeniu
	 * @param performedBy Nazwa użytkownika, która utworzyła tę wiadomość
	 */
	public Event(EventType eventType, String message, long performedBy) {
		super();
		this.eventType = eventType.getValue();
		this.message = message;
		this.performedBy = performedBy;
	}

	/**
	 * Konstruktor domyślny
	 */
    public Event() {
        super();
    }


	/**
	 * Pobiera typ zdarzenia.
	 *
	 * @return Typ zdarzenia
	 */
	public byte getEventType() {
		return eventType;
	}

	public void setEventType(byte eventType) {
		this.eventType = eventType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getPerformedBy() {
		return performedBy;
	}

	public void setPerformedBy(long performedBy) {
		this.performedBy = performedBy;
	}
}
