package am.jsl.personalfinances.search.reminder;

import am.jsl.personalfinances.dto.reminder.ReminderListDTO;
import am.jsl.personalfinances.search.Query;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Custom {@link Query} do wyszukiwania elementów {@link ReminderListDTO} 
 */
public class ReminderSearchQuery extends Query<ReminderListDTO> implements Serializable {
    private short status;
    private long accountId;
    private long categoryId;
    private short transactionType;
    private long contact;
    private Date startDate;
    private Date endDate;
    private long userId;

    /**
     * Tworzy nowe zapytanie wyszukiwania przypomnień.
     *
     * @param page     strona
     * @param pageSize rozmiar strony
     */
    public ReminderSearchQuery(int page, int pageSize) {
        super(page, pageSize);
    }


    /**
     * Pobiera status.
     *
     * @return the status
     */
    public short getStatus() {
        return status;
    }

    /**
     * Ustawia status.
     *
     * @param status the status
     */
    public void setStatus(short status) {
        this.status = status;
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
     * Ustawia  account id.
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
     * Ustawia category id.
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
     * Ustawia transaction type.
     *
     * @param transactionType the transaction type
     */
    public void setTransactionType(short transactionType) {
        this.transactionType = transactionType;
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
     * Ustawia contact.
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
     * Ustawia start date.
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
     * Ustawia end date.
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
     * Ustawia  user id.
     *
     * @param userId the user id
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, accountId, categoryId, transactionType, contact, startDate, endDate, userId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ReminderSearchQuery other = (ReminderSearchQuery) obj;
        return  Objects.equals(this.status, other.status)
                && Objects.equals(this.accountId, other.accountId)
                && Objects.equals(this.categoryId, other.categoryId)
                && Objects.equals(this.transactionType, other.transactionType)
                && Objects.equals(this.contact, other.contact)
                && Objects.equals(this.startDate, other.startDate)
                && Objects.equals(this.endDate, other.endDate)
                && Objects.equals(this.userId, other.userId);
    }
}
