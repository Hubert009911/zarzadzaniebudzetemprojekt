package am.jsl.personalfinances.domain;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Obiekt domeny o wspólnych właściwościach.
 * Używany jako klasa bazowa dla obiektów wymagających tych właściwości.
 */
public class BaseEntity implements Serializable {

    /**
     * Identyfikator wewnętrzny. widzi # {@link #getId()} widzi {@link #setId(long)}.
     */
    private long id;
    /**
     * Identyfikator użytkownika.
     */
    protected long userId;
    /**
     * Stworzony o godz.
     */
    protected LocalDateTime createdAt = null;
    /**
     * Zmieniony przez.
     */
    protected long changedBy = 0;
    /**
     * Zmiana o godz.
     */
    protected LocalDateTime changedAt = null;

    /**
     * Pobiera identyfikator.
     *
     * @return identyfikator.
     */
    public long getId() {
        return id;
    }

    /**
     * Ustawia identyfikator.
     *
     * @param id identyfikator.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Pobiera identyfikator użytkownika.
     *
     * @return identyfikator użytkownika
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Ustawia identyfikator użytkownika.
     *
     * @param userId identyfikator użytkownika
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * Pobiera godzine powstania 
     *
     * @return godzine powstania
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Ustawia godzine powstania
     *
     * @param createdAt godzine powstania
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Pobiera zmieniony przez
     *
     * @return zmieniony przez
     */
    public long getChangedBy() {
        return changedBy;
    }

    /**
     * Ustawia zmieniony przez.
     *
     * @param changedBy zmieniony przez
     */
    public void setChangedBy(long changedBy) {
        this.changedBy = changedBy;
    }

    /**
     * Pobiera godzinę zmiany 
     *
     * @return godzinę zmiany 
     */
    public LocalDateTime getChangedAt() {
        return changedAt;
    }

    /**
     * Ustawia godzinę zmiany
     *
     * @param changedAt godzinę zmiany 
     */
    public void setChangedAt(LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }

    @Override
    public String toString() {
        return String.format("%s(id=%d)", this.getClass().getSimpleName(), this.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null)
            return false;

        if (o instanceof BaseEntity) {
            final BaseEntity other = (BaseEntity) o;
            return Objects.equals(getId(), other.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

}
