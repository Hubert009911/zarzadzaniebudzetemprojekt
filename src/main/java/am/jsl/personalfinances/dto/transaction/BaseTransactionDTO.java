package am.jsl.personalfinances.dto.transaction;

import am.jsl.personalfinances.domain.transaction.TransactionType;
import am.jsl.personalfinances.dto.DescriptiveDTO;

import java.io.Serializable;
import java.util.Date;

/**
 * BaseTransactionDTO zawiera szczegóły transakcji do przesyłania między warstwami aplikacji.
 * @author hamlet
 */
public class BaseTransactionDTO extends DescriptiveDTO implements Serializable {
    /**
     * Symbol konta w walucie natywnej
     */
    protected String symbol;

    /**
     * Nazwa kategorii tej transakcji
     */
    protected String category;

    /**
     * Ikona kategorii tej transakcji
     */
    protected String categoryIcon;

    /**
     * Kolor kategorii tej transakcji
     */
    protected String categoryColor;

    /**
     * Nazwa kategorii nadrzędnej
     */
    protected String parentCategory;

    /**
     * Ikona kategorii nadrzędnej
     */
    protected String parentCategoryIcon;

    /**
     * Kolor kategorii nadrzędnej
     */
    protected String parentCategoryColor;

    /**
     * Kwota tej transakcji
     */
    protected double amount;

    /**
     * Typ tej transakcji
     */
    protected byte transactionType;

    /**
     * Data tej transakcji
     */
    protected Date transactionDate;

    /**
     * Zwraca wartość true, jeśli typ transakcji if koszt.
     *
     * @return true, jeżeli, typ transakcji, jeśli koszt;
     */
    public boolean isExpense() {
        return transactionType == TransactionType.EXPENSE.getValue();
    }

    /**
     * Zwraca wartość true, jeśli typ transakcji if przychód.
     *
     * @return true if typ transakcji if dochód
     */
    public boolean isIncome() {
        return transactionType == TransactionType.INCOME.getValue();
    }

    /**
     * Zwraca wartość true, jeśli typ transakcji if transfer.
     *
     * @return true if typ transakcji if transfer
     */
    public boolean isTransfer() {
        return transactionType == TransactionType.TRANSFER.getValue();
    }

    /**
     * Zwraca klasę css dla typu transakcji.
     *
     * @return true if typ transakcji if transfer
     */
    public String getTransactionTypeClass() {
        return "trType" + transactionType;
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
     * Getter dla właściwości 'category'.
     *
     * @return Wartość dla właściwości  'category'.
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
     * @return Wartość dla właściwości  'categoryIcon'.
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
     * @return Wartość dla właściwości  'categoryColor'.
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
     * @return Wartość dla właściwości  'parentCategory'.
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
     * @return Wartość dla właściwości  'parentCategoryIcon'.
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
     * @return Wartość dla właściwości  'parentCategoryColor'.
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
     * Getter dla właściwości 'amount'.
     *
     * @return Wartość dla właściwości  'amount'.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Setter dla właściwości 'amount'.
     *
     * @param amount Wartość do ustawienia dla właściwości 'amount'.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Getter dla właściwości 'transactionType'.
     *
     * @return Wartość dla właściwości  'transactionType'.
     */
    public byte getTransactionType() {
        return transactionType;
    }

    /**
     * Setter dla właściwości 'transactionType'.
     *
     * @param transactionType Wartość do ustawienia dla właściwości 'transactionType'.
     */
    public void setTransactionType(byte transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Getter dla właściwości 'transactionDate'.
     *
     * @return Wartość dla właściwości  'transactionDate'.
     */
    public Date getTransactionDate() {
        return transactionDate;
    }

    /**
     * Setter dla właściwości 'transactionDate'.
     *
     * @param transactionDate Wartość do ustawienia dla właściwości 'transactionDate'.
     */
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
