package am.jsl.personalfinances.search.transaction;

import am.jsl.personalfinances.dto.transaction.TransactionByCategoryDTO;
import am.jsl.personalfinances.search.Query;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Custom {@link Query} do wyszukiwania elementów {@link TransactionByCategoryDTO}
 */
public class TransactionByCategorySearchQuery extends Query<TransactionByCategoryDTO> implements Serializable {
    private long accountId;
    private short transactionType;
    private Date startDate;
    private Date endDate;
    private long userId;

    /**
     * Getter dla właściwości 'accountId'.
     *
     * @return Wartość dla właściwości 'accountId'.
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * Setter dla właściwości 'accountId'.
     *
     * @param accountId Wartość do ustawienia dla właściwości 'accountId'.
     */
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    /**
     * Getter dla właściwości 'transactionType'.
     *
     * @return Wartość dla właściwości 'transactionType'.
     */
    public short getTransactionType() {
        return transactionType;
    }

    /**
     * Setter dla właściwości 'transactionType'.
     *
     * @param transactionType Wartość do ustawienia dla właściwości 'transactionType'.
     */
    public void setTransactionType(short transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Getter dla właściwości 'startDate'.
     *
     * @return Wartość dla właściwości 'startDate'.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Setter dla właściwości 'startDate'.
     *
     * @param startDate Wartość do ustawienia dla właściwości 'startDate'.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Getter dla właściwości 'endDate'.
     *
     * @return Wartość dla właściwości 'endDate'.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Setter dla właściwości 'endDate'.
     *
     * @param endDate Wartość do ustawienia dla właściwości 'endDate'.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Getter dla właściwości 'userId'.
     *
     * @return Wartość dla właściwości 'userId'.
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Setter dla właściwości 'userId'.
     *
     * @param userId Wartość do ustawienia dla właściwości 'userId'.
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, transactionType, startDate, endDate, userId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final TransactionByCategorySearchQuery other = (TransactionByCategorySearchQuery) obj;
        return Objects.equals(this.accountId, other.accountId)
                && Objects.equals(this.transactionType, other.transactionType)
                && Objects.equals(this.startDate, other.startDate)
                && Objects.equals(this.endDate, other.endDate)
                && Objects.equals(this.userId, other.userId);
    }
}
