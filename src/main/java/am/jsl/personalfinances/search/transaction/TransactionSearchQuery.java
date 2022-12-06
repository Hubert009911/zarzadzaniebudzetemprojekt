package am.jsl.personalfinances.search.transaction;

import am.jsl.personalfinances.dto.transaction.TransactionListDTO;
import am.jsl.personalfinances.search.Query;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Custom {@link Query} do wyszukiwania elementów {@link TransactionListDTO}
 */
public class TransactionSearchQuery extends Query<TransactionListDTO> implements Serializable {
    private long accountId;
    private long categoryId;
    private short transactionType;
    private short transactionSource;
    private long contact;
    private Date startDate;
    private Date endDate;
    private long userId;
    private String description;

    private boolean calculateTotals = true;

    /**
     * Tworzy nowe zapytanie wyszukiwania transakcji.
     *
     * @param page     strona
     * @param pageSize rozmiar strony
     */
    public TransactionSearchQuery(int page, int pageSize) {
        super(page, pageSize);
    }


    /**
     * Pobiera account id.
     *
     * @return the account id
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * Pobiera account id.
     *
     * @param accountId the account id
     */
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    /**
     * Pobiera category id.
     *
     * @return the category id
     */
    public long getCategoryId() {
        return categoryId;
    }

    /**
     * Pobiera category id.
     *
     * @param categoryId the category id
     */
    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Pobiera transaction type.
     *
     * @return the transaction type
     */
    public short getTransactionType() {
        return transactionType;
    }

    /**
     * Pobiera transaction type.
     *
     * @param transactionType the transaction type
     */
    public void setTransactionType(short transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Pobiera transaction source.
     *
     * @return the transaction source
     */
    public short getTransactionSource() {
        return transactionSource;
    }

    /**
     * Pobiera transaction source.
     *
     * @param transactionSource the transaction source
     */
    public void setTransactionSource(short transactionSource) {
        this.transactionSource = transactionSource;
    }

    /**
     * Pobiera contact.
     *
     * @return the contact
     */
    public long getContact() {
        return contact;
    }

    /**
     * Pobiera contact.
     *
     * @param contact the contact
     */
    public void setContact(long contact) {
        this.contact = contact;
    }

    /**
     * Pobiera start date.
     *
     * @return the start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Pobiera start date.
     *
     * @param startDate the start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Pobiera end date.
     *
     * @return the end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Pobiera end date.
     *
     * @param endDate the end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Pobiera user id.
     *
     * @return the user id
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Pobiera user id.
     *
     * @param userId the user id
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * Pobiera description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Pobiera description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Oblicza sumy boolean.
     *
     * @return the boolean
     */
    public boolean isCalculateTotals() {
        return calculateTotals;
    }

    /**
     * Pobiera calculate totals.
     *
     * @param calculateTotals the calculate totals
     */
    public void setCalculateTotals(boolean calculateTotals) {
        this.calculateTotals = calculateTotals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, categoryId, transactionType, transactionSource, contact, startDate, endDate, userId, description);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final TransactionSearchQuery other = (TransactionSearchQuery) obj;
        return Objects.equals(this.accountId, other.accountId)
                && Objects.equals(this.categoryId, other.categoryId)
                && Objects.equals(this.transactionType, other.transactionType)
                && Objects.equals(this.transactionSource, other.transactionSource)
                && Objects.equals(this.contact, other.contact)
                && Objects.equals(this.startDate, other.startDate)
                && Objects.equals(this.endDate, other.endDate)
                && Objects.equals(this.userId, other.userId)
                && Objects.equals(this.description, other.description);
    }
}
