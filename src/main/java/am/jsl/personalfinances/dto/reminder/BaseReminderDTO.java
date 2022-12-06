package am.jsl.personalfinances.dto.reminder;

import am.jsl.personalfinances.domain.reminder.ReminderStatus;
import am.jsl.personalfinances.domain.transaction.TransactionType;
import am.jsl.personalfinances.dto.DescriptiveDTO;

import java.io.Serializable;
import java.util.Date;

/**
 * BaseReminderDTO zawiera dane przypominające o przesyłaniu między warstwami aplikacji.
 */
public class BaseReminderDTO extends DescriptiveDTO implements Serializable {
    /**
     * Stan przypomnienia
     */
    protected short status;

    /**
     * Rodzimy symbol waluty tego konta przypominającego
     */
    protected String symbol;

    /**
     * Nazwa kategorii przypomnienia
     */
    protected String category;

    /**
     * Ikona kategorii
     */
    protected String categoryIcon;

    /**
     * Kolor kategorii
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
     * Kwota tego przypomnienia
     */
    protected String parentCategoryColor;

    /**
     * Kwota tego przypomnienia, która zostanie wykorzystana do utworzenia transakcji
     */
    protected double amount;

    /**
     * Rodzaj przypomnienia o transakcji (wydatek, dochód, przelew)
     */
    protected byte transactionType;

    /**
     * Termin przypomnienia
     */
    private Date dueDate;

    /**
     * Zwraca wartość true, jeśli typem transakcji jest wydatek.
     * @return true Jeśli typem transakcji jest wydatek
     */
    public boolean isExpense() {
        return transactionType == TransactionType.EXPENSE.getValue();
    }

    /**
     * Zwraca wartość true, jeśli typem transakcji jest dochód.
     * @return true Jeśli typem transakcji jest dochód
     */
    public boolean isIncome() {
        return transactionType == TransactionType.INCOME.getValue();
    }

    /**
     * Zwraca wartość true, jeśli typem transakcji jest przelew.
     * @return true, jeśli typem transakcji jest przelew
     */
    public boolean isTransfer() {
        return transactionType == TransactionType.TRANSFER.getValue();
    }

    /**
     * Zwraca wartość true, jeśli stan przypomnienia jest aktywny.
     * @return true, jeśli stan przypomnienia jest aktywny
     */
    public boolean isActive() {
        return status == ReminderStatus.ACTIVE.getValue();
    }

    /**
     * Zwraca wartość true, jeśli stan przypomnienia jest wyłączony.
     * @return true, jeśli stan przypomnienia jest wyłączony
     */
    public boolean isDisabled() {
        return status == ReminderStatus.DISABLED.getValue();
    }

    /**
     * Zwraca wartość true, jeśli stan przypomnienia jest zakończony.
     * @return wartość true, jeśli stan przypomnienia został zakończony
     */
    public boolean isDone() {
        return status == ReminderStatus.DONE.getValue();
    }

    /**
     * Zwraca klasę css dla typu transakcji.
     * @return Klasa css dla typu transakcji
     */
    public String getTransactionTypeClass() {
        return "trType" + transactionType;
    }

    /**
     * Zwraca klasę css dla stanu przypomnienia.
     * @return Klasa css dla stanu przypomnienia
     */
    public String getStatusClass() {
        return "remStatus" + status;
    }

    /**
     * Getter dla właściwości 'status'.
     *
     * @return Wartość dla właściwości  'status'.
     */
    public short getStatus() {
        return status;
    }

    /**
     * Setter dla właściwości 'status'.
     *
     * @param status Wartość do ustawienia dla właściwości 'status'.
     */
    public void setStatus(short status) {
        this.status = status;
    }

    /**
     * Getter dla właściwości 'symbol'.
     *
     * @return Wartość dla właściwości  'symbol'.
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
     * Setter Wartość dla właściwości  'category'.
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
     * Setter dla właściwości'categoryIcon'.
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
     * Setter fdla właściwości 'categoryColor'.
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
     * Getter dla właściwości 'dueDate'.
     *
     * @return Wartość dla właściwości 'dueDate'.
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * Setter dla właściwości 'dueDate'.
     *
     * @param dueDate Wartość do ustawienia dla właściwości 'dueDate'.
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
