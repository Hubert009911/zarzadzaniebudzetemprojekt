package am.jsl.personalfinances.dto.event;

import java.io.Serializable;
import java.util.Date;

/**
 * EventListDTO służy do przekształcania danych zdarzeń do sieci.
 *
 * @author hamlet
 */
public class EventListDTO implements Serializable {

	/**
	 * Identyfikator wewnętrzny.
	 */
	private long id;

	/**
	 * Typ zdarzenia
	 */
	private String eventType;

	/**
	 * Wiadomość
	 */
	private String message;

	/**
	 * Identyfikator użytkownika
	 */
	private String performedBy;

	/**
	 * Identyfikator obiektu docelowego
	 */
	private String performedOn;

	/**
	 * Data utworzenia
	 */
	private Date createdAt = null;

	/**
	 * Pobiera identyfikator.
	 *
	 * @return identyfikator
	 */
	public long getId() {
		return id;
	}

	/**
	 * Ustawia identyfikator.
	 *
	 * @param id identyfikator
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Pobiera typ zdarzenia.
	 *
	 * @return Typ zdarzenia
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * Ustawia typ zdarzenia.
	 *
	 * @param eventType Typ zdarzenia
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * Pobiera wiadomość.
	 *
	 * @return wiadomość.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Ustawia wiadomość.
	 *
	 * @param message wiadomość.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Pobiera wykonywane przez.
	 *
	 * @return wykonywany przez
	 */
	public String getPerformedBy() {
		return performedBy;
	}

	/**
	 * Ustawia wykonywane przez.
	 *
	 * @param performedBy wykonywany przez
	 */
	public void setPerformedBy(String performedBy) {
		this.performedBy = performedBy;
	}

	/**
	 * Pobiera wykonany na.
	 *
	 * @return wykonany na.
	 */
	public String getPerformedOn() {
		return performedOn;
	}

	/**
	 * Ustawia wykonany na.
	 *
	 * @param performedOn wykonany na.
	 */
	public void setPerformedOn(String performedOn) {
		this.performedOn = performedOn;
	}

	/**
	 * Pobiera godzine powstania
	 *
	 * @return godzina powstania
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * Ustawia godzine powstania
	 *
	 * @param createdAt godzina powstania
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
