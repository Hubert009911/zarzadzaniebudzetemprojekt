package am.jsl.personalfinances.domain.transaction;

import am.jsl.personalfinances.domain.Descriptive;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Obiekt domeny transakcji.
 */
public class Transaction extends Descriptive implements Serializable {
    /**
     * Identyfikator konta
     */
    private long accountId;

    /**
     * Identyfikator kategorii
     */
    private long categoryId;

    /**
     * Kwota
     */
    private double amount;

    /**
     * Status
     * @see TransactionStatus
     */
    private byte status;

    /**
     * Typ transakcji
     */
    private byte transactionType;

    /**
     * Źródło transakcji
     * @see TransactionSource
     */
    private byte transactionSource = TransactionSource.MANUAL.getValue();

    /**
     * Identyfikator kontaktu
     */
    private long contactId = 0;

    /**
     * Data transakcji
     */
    private LocalDateTime transactionDate;

    /**
     * Szczegóły przelewu dla typu transferu
     * @see Transfer
     */
    private Transfer transfer = null;

    /**
     * Zwraca true, jeśli typ transakcji, jeśli transfer.
     *
     * @return true, jeśli typ transakcji, jeśli transfer
     */
    public boolean isTransferType() {
        return transactionType == TransactionType.TRANSFER.getValue();
    }

    /**
     * Pobranie przelewu.
     *
     * @return przelew
     */
    public Transfer getTransfer() {
        return transfer;
    }

    /**
     * Ustawienie przelewu.
     *
     * @param transfer przelew
     */
    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }

    /**
     * Getter dla właściwości 'accountId'.
     *
     * @return Wartość dla właściwości 'accountId'.
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * Setter dla właściwości  'accountId'.
     *
     * @param accountId Wartość do ustawienia dla właściwości 'accountId'.
     */
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    /**
     * Getter dla właściwości  'categoryId'.
     *
     * @return Wartość dla właściwości 'categoryId'.
     */
    public long getCategoryId() {
        return categoryId;
    }

    /**
     * Setter dla właściwości  'categoryId'.
     *
     * @param categoryId Wartość do ustawienia dla właściwości 'categoryId'.
     */
    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }


    /**
     * Getter dla właściwości  'amount'.
     *
     * @return Wartość dla właściwości 'amount'.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Setter dla właściwości  'amount'.
     *
     * @param amountWartość do ustawienia dla właściwości 'amount'.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Getter dla właściwości  'status'.
     *
     * @return Wartość dla właściwości 'status'.
     */
    public byte getStatus() {
        return status;
    }

    /**
     * Setter dla właściwości  'status'.
     *
     * @param status Wartość do ustawienia dla właściwości 'status'.
     */
    public void setStatus(byte status) {
        this.status = status;
    }

    /**
     * Getter dla właściwości  'transactionType'.
     *
     * @return Wartość dla właściwości 'transactionType'.
     */
    public byte getTransactionType() {
        return transactionType;
    }

    /**
     * Setter dla właściwości  'transactionType'.
     *
     * @param transactionType Wartość do ustawienia dla właściwości 'transactionType'.
     */
    public void setTransactionType(byte transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Getter dla właściwości  'transactionDate'.
     *
     * @return Wartość dla właściwości 'transactionDate'.
     */
    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    /**
     * Setter dla właściwości  'transactionDate'.
     *
     * @param transactionDate Wartość do ustawienia dla właściwości 'transactionDate'.
     */
    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * Pobiera źródło transakcji.
     *
     * @return Źródło transakcji
     */
    public byte getTransactionSource() {
        return transactionSource;
    }

    /**
     * Ustawia źródło transakcji.
     *
     * @param transactionSource Źródło transakcji
     */
    public void setTransactionSource(byte transactionSource) {
        this.transactionSource = transactionSource;
    }

    /**
     * Pobiera identyfikator kontaktu.
     *
     * @return Identyfikator kontaktu
     */
    public long getContactId() {
        return contactId;
    }

    /**
     * Ustawia identyfikator kontaktu.
     *
     * @param contactId Identyfikator kontaktu
     */
    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        final Transaction other = (Transaction) obj;
        return Objects.equals(this.getId(), other.getId());
    }
}
