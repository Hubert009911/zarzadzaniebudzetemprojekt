package am.jsl.personalfinances.domain;

import java.util.Objects;

/**
 * Obiekt domeny, który rozszerza BaseEntity i zawiera pole nazwy.
 * Używany jako klasa bazowa dla obiektów wymagających tych właściwości.
 */
public class NamedEntity extends BaseEntity {

    /**
     * nazwa
     */
    private String name;

    /**
     * Pobiera nazwe
     *
     * @return nazwa
     */
    public String getName() {
        return name;
    }

    /**
     * Ustawia nazwe
     *
     * @param name nazwa
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;

        if (o instanceof NamedEntity) {
            final NamedEntity other = (NamedEntity) o;
            return Objects.equals(getId(), other.getId())
                    && Objects.equals(getName(), other.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

}
