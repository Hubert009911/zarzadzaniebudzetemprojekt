package am.jsl.personalfinances.dto;

import java.util.Objects;

/**
 * BaseDTO jest katalogiem głównym dla klas DTO.
 * Klasy DTO służą do przenoszenia obiektów między warstwami aplikacji.
 */
public class BaseDTO {
    /**
     * Identyfikator wewnętrzny.
     */
    private long id;

    /**
     * Getter dla właściwośći 'id'.
     *
     * @return Wartość dla właściwośći 'id'.
     */
    public long getId() {
        return id;
    }

    /**
     * Setter dla właściwośći 'id'.
     *
     * @param id Wartość do ustawienia dla właściwośći 'id'.
     */
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final BaseDTO other = (BaseDTO) obj;
        return Objects.equals(this.id, other.id);
    }
}
