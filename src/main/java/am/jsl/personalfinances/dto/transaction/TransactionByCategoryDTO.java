package am.jsl.personalfinances.dto.transaction;

import java.io.Serializable;

/**
 * Zawiera transakcje pogrupowane według kategorii i konta.
 */
public class TransactionByCategoryDTO implements Serializable {
    /**
     * Nazwa kategorii
     */
    private String category;

    /**
     * Ikona kategorii
     */
    private String categoryIcon;

    /**
     * Kolor kategorii
     */
    private String categoryColor;

    /**
     * Nazwa kategorii nadrzędnej
     */
    private String parentCategory;

    /**
     * Ikona kategorii nadrzędnej
     */
    private String parentCategoryIcon;

    /**
     * Kolor kategorii nadrzędnej
     */
    private String parentCategoryColor;

    /**
     * Całkowita kwota
     */
    private double total;

    /**
     * Sformatowana łączna kwota
     */
    private String totalStr;

    /**
     * Całkowity procent tej kwoty
     */
    private String percent;

    /**
     * Symbol waluty natywnej
     */
    private String symbol;

    /**
     * Getter dla właściwości 'category'.
     *
     * @return Wartość dla właściwości 'category'.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter dla właściwości 'category'.
     *
     * @param category Wartość do ustawienia dla właściwości 'category'.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Getter dla właściwości 'categoryIcon'.
     *
     * @return Wartość dla właściwości 'categoryIcon'.
     */
    public String getCategoryIcon() {
        return categoryIcon;
    }

    /**
     * Setter dla właściwości 'categoryIcon'.
     *
     * @param categoryIcon Wartość do ustawienia dla właściwości 'categoryIcon'.
     */
    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    /**
     * Getter dla właściwości 'categoryColor'.
     *
     * @return Wartość dla właściwości 'categoryColor'.
     */
    public String getCategoryColor() {
        return categoryColor;
    }

    /**
     * Setter dla właściwości 'categoryColor'.
     *
     * @param categoryColor Wartość do ustawienia dla właściwości 'categoryColor'.
     */
    public void setCategoryColor(String categoryColor) {
        this.categoryColor = categoryColor;
    }

    /**
     * Getter dla właściwości 'parentCategory'.
     *
     * @return Wartość dla właściwości 'parentCategory'.
     */
    public String getParentCategory() {
        return parentCategory;
    }

    /**
     * Setter dla właściwości 'parentCategory'.
     *
     * @param parentCategory Wartość do ustawienia dla właściwości 'parentCategory'.
     */
    public void setParentCategory(String parentCategory) {
        this.parentCategory = parentCategory;
    }

    /**
     * Getter dla właściwości 'parentCategoryIcon'.
     *
     * @return Wartość dla właściwości 'parentCategoryIcon'.
     */
    public String getParentCategoryIcon() {
        return parentCategoryIcon;
    }

    /**
     * Setter dla właściwości 'parentCategoryIcon'.
     *
     * @param parentCategoryIcon Wartość do ustawienia dla właściwości 'parentCategoryIcon'.
     */
    public void setParentCategoryIcon(String parentCategoryIcon) {
        this.parentCategoryIcon = parentCategoryIcon;
    }

    /**
     * Getter dla właściwości 'parentCategoryColor'.
     *
     * @return Wartość dla właściwości 'parentCategoryColor'.
     */
    public String getParentCategoryColor() {
        return parentCategoryColor;
    }

    /**
     * Setter dla właściwości 'parentCategoryColor'.
     *
     * @param parentCategoryColor Wartość do ustawienia dla właściwości 'parentCategoryColor'.
     */
    public void setParentCategoryColor(String parentCategoryColor) {
        this.parentCategoryColor = parentCategoryColor;
    }

    /**
     * Getter dla właściwości 'total'.
     *
     * @return Wartość dla właściwości 'total'.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Setter dla właściwości 'total'.
     *
     * @param total Wartość do ustawienia dla właściwości 'total'.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Getter dla właściwości 'percent'.
     *
     * @return Wartość dla właściwości 'percent'.
     */
    public String getPercent() {
        return percent;
    }

    /**
     * Setter dla właściwości 'percent'.
     *
     * @param percent Wartość do ustawienia dla właściwości 'percent'.
     */
    public void setPercent(String percent) {
        this.percent = percent;
    }

    /**
     * Getter dla właściwości 'symbol'.
     *
     * @return Wartość dla właściwości 'symbol'.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Setter dla właściwości 'symbol'.
     *
     * @param symbol Wartość do ustawienia dla właściwości 'symbol'.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Getter dla właściwości 'totalStr'.
     *
     * @return Wartość dla właściwości 'totalStr'.
     */
    public String getTotalStr() {
        return totalStr;
    }

    /**
     * Setter dla właściwości 'totalStr'.
     *
     * @param totalStr Wartość do ustawienia dla właściwości 'totalStr'.
     */
    public void setTotalStr(String totalStr) {
        this.totalStr = totalStr;
    }
}
