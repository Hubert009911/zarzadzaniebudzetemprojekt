package am.jsl.personalfinances.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Obiekt domeny, który rozszerza NamedEntity i zawiera pole opisu.
 * Używany jako klasa bazowa dla obiektów wymagających tych właściwości.
 */
public class Descriptive extends NamedEntity implements Serializable {

	/**
	 * Opis
	 */
	protected String description;

	/**
	 * Pobiera opis.
	 *
	 * @return Opis
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Ustawia opis.
	 *
	 * @param description Opis
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + Objects.hash(description);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		if (!super.equals(obj)) {
			return false;
		}
		final Descriptive other = (Descriptive) obj;
		boolean equals = Objects.equals(this.description, other.description);
		return equals;
	}
}
