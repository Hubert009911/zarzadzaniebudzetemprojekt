package am.jsl.personalfinances.dto.transaction;

import am.jsl.personalfinances.domain.transaction.Transaction;
import am.jsl.personalfinances.util.DateUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * AddTransactionsDTO jest używany transakcje wsadowe ze strony dodawania transakcji wsadowych.
 */
public class AddTransactionsDTO implements Serializable {

    /**
     * Opis
     */
    private String description;

    /**
     * Identyfikator konta
     */
    private long accountId;

    /**
     * Typ transakcji
     */
    private byte transactionType;

    /**
     * Data transakcji
     */
    private String transactionDate;

    /**
     * Identyfikator kontaktu
     */
    private long contactId;

    /**
     * Identyfikator użytkownika
     */
    private long userId;

    /**
     * Wykaz transakcji, które mają zostać utworzone
     */
    private List<Transaction> transactions = new ArrayList<>();

    /**
     * Konstruktor domyślny
     */
    public AddTransactionsDTO() {
        super();
    }

    /**
     * Tworzy nowy AddTransactionsDTO z podanymi polami.
     *
     * @param accountId       identyfikator konta
     * @param transactionType Typ transakcji
     * @param transactionDate datę transakcji
     * @param userId          identyfikator użytkownika
     */
    public AddTransactionsDTO(long accountId, byte transactionType, LocalDateTime transactionDate, long userId) {
        super();
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.transactionDate = DateUtils.format(transactionDate);
        this.userId = userId;
    }

    /**
     * Getter dla właściwości 'description'.
     *
     * @return Wartość dla właściwości 'description'.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter dla właściwości 'description'.
     *
     * @param description Wartość do ustawienia dla właściwości 'description'.
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @return Wartość dla właściwości 'transactionDate'.
     */
    public String getTransactionDate() {
        return transactionDate;
    }

    /**
     * Setter dla właściwości 'transactionDate'.
     *
     * @param transactionDate Wartość do ustawienia dla właściwości 'transactionDate'.
     */
    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * Getter dla właściwości 'contactId'.
     *
     * @return Wartość dla właściwości 'contactId'.
     */
    public long getContactId() {
        return contactId;
    }

    /**
     * Setter dla właściwości 'contactId'.
     *
     * @param contactId Wartość do ustawienia dla właściwości 'contactId'.
     */
    public void setContactId(long contactId) {
        this.contactId = contactId;
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

    /**
     * Add transaction.
     *
     * @param transaction the transaction
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    /**
     * Getter dla właściwości 'transactions'.
     *
     * @return Wartość dla właściwości 'transactions'.
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * Setter dla właściwości 'transactions'.
     *
     * @param transactions Wartość do ustawienia dla właściwości 'transactions'.
     */
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
