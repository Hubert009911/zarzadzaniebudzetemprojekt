package am.jsl.personalfinances.domain;


import java.io.Serializable;
import java.util.Objects;

/**
 * Obiekt domeny kategorii.
 */
public class Category extends Descriptive implements Serializable {
    /**
     * Domyślny kolor kategorii
     */
    public static final String DEFAULT_COLOR= "#a0a0a0";

    /**
     * Ikona tej kategorii
     */
    private String icon;

    /**
     * Kolor tej kategorii
     */
    private String color;

    /**
     * Identyfikator nadrzędny tej kategorii
     */
    private long parentId;

    /**
     * Getter dla właściwości 'icon'.
     *
     * @return Wartość dla właściwości 'icon'.
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Setter dla właściwości 'icon'.
     *
     * @param icon Wartość do ustawienia dla właściwości 'icon'.
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Getter dla właściwości 'color'.
     *
     * @return Wartość dla właściwości 'color'.
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter dla właściwości 'color'.
     *
     * @param color Wartość do ustawienia dla właściwości 'color'.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter dla właściwości 'parentId'.
     *
     * @return Wartość dla właściwości 'parentId'.
     */
    public long getParentId() {
        return parentId;
    }

    /**
     * Setter dla właściwości 'parentId'.
     *
     * @param parentId Wartość do ustawienia dla właściwości 'parentId'.
     */
    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;

        if (o instanceof Category) {
            final Category other = (Category) o;
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
