package am.jsl.personalfinances.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Zawiera informacje o kategorii.
 */
public class CategoryDTO extends DescriptiveDTO implements Serializable {
    /**
     * Ikona kategorii.
     */
    private String icon;

    /**
     * Kolor kategorii.
     */
    private String color;

    /**
     * Identyfikator nadrzędny kategorii.
     */
    private long parentId;

    /**
     * Kategorie podrzędne.
     */
    private List<CategoryDTO> childs;

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

    /**
     * Getter dla właściwości 'childs'.
     *
     * @return Wartość dla właściwości 'childs'.
     */
    public List<CategoryDTO> getChilds() {
        return childs;
    }

    /**
     * Setter dla właściwości 'childs'.
     *
     * @param childs Wartość do ustawienia dla właściwości 'childs'.
     */
    public void setChilds(List<CategoryDTO> childs) {
        this.childs = childs;
    }

    public void addChild(CategoryDTO category) {
        if (childs == null) {
            childs = new ArrayList<>();
        }
        childs.add(category);
    }
}
