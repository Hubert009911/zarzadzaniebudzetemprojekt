package am.jsl.personalfinances.dto.transaction;

import am.jsl.personalfinances.domain.transaction.Transaction;
import am.jsl.personalfinances.domain.transaction.TransactionSource;
import am.jsl.personalfinances.domain.transaction.TransactionType;
import am.jsl.personalfinances.domain.transaction.Transfer;
import am.jsl.personalfinances.util.DateUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * TransactionDTO służy do tworzenia i aktualizowania transacion z sieci.
 *
 * @author hamlet
 */
public class TransactionDTO implements Serializable {

    /**
     * Identyfikator wewnętrzny
     */
    private long id;

    /**
     * Opis
     */
    private String description;

    /**
     * Identyfikator konta tej transakcji
     */
    private long accountId;

    /**
     * Identyfikator kategorii
     */
    private long categoryId;

    /**
     * Kwota transakcji
     */
    private double amount;

    /**
     * Status transakcji
     */
    private byte status;

    /**
     * Typ transakcji
     */
    private byte transactionType;

    /**
     * Data transakcji
     */
    private String transactionDate;

    /**
     * Źródło transakcji
     */
    private byte transactionSource = TransactionSource.MANUAL.getValue();

    /**
     * Identyfikator kontaktu
     */
    private long contactId;

    /**
     * Kurs wymiany walut
     */
    private double exchangeRate;

    /**
     * Identyfikator konta docelowego
     */
    private long targetAccountId;

    /**
     * Przeliczona kwota
     */
    private double convertedAmount;

    /**
     * Identyfikator użytkownika
     */
    private long userId;

    /**
     * Konstruktor domyślny
     */
    public TransactionDTO() {
        super();
    }

    /**
     * Konstruuje nowy TransactionDTO z podanymi polami.
     *
     * @param accountId       identyfikator konta
     * @param transactionType Typ transakcji
     * @param transactionDate datę transakcji
     * @param userId          identyfikator użytkownika
     */
    public TransactionDTO(long accountId, byte transactionType, LocalDateTime transactionDate, long userId) {
        super();
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.transactionDate = DateUtils.format(transactionDate);
        this.userId = userId;
    }

    /**
     * Zwraca wartość true, jeśli ta transakcja jest typu przelewu.
     *
     * @return true, jeśli transakcja jest bezpieczniejsza
     */
    public boolean isTransfer() {
        return transactionType == TransactionType.TRANSFER.getValue();
    }

    /**
     * Getter dla właściwości 'id'.
     *
     * @return Wartość dla właściwości 'id'.
     */
    public long getId() {
        return id;
    }

    /**
     * Setter dla właściwości 'id'.
     *
     * @param id Wartość do ustawienia dla właściwości 'id'.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter dla właściwości 'description'.
     *
     * @return Wartość dla właściwości'description'.
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
     * @return Wartość dla właściwości'accountId'.
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
     * Getter dla właściwości 'categoryId'.
     *
     * @return Wartość dla właściwości'categoryId'.
     */
    public long getCategoryId() {
        return categoryId;
    }

    /**
     * Setter dla właściwości 'categoryId'.
     *
     * @param categoryId Wartość do ustawienia dla właściwości 'categoryId'.
     */
    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Getter dla właściwości 'contactId'.
     *
     * @return Wartość dla właściwości'contactId'.
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
     * Getter dla właściwości 'amount'.
     *
     * @return Wartość dla właściwości'amount'.
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
     * Getter dla właściwości 'status'.
     *
     * @return Wartość dla właściwości'status'.
     */
    public byte getStatus() {
        return status;
    }

    /**
     * Setter dla właściwości 'status'.
     *
     * @param status Wartość do ustawienia dla właściwości 'status'.
     */
    public void setStatus(byte status) {
        this.status = status;
    }

    /**
     * Getter dla właściwości 'transactionType'.
     *
     * @return Wartość dla właściwości'transactionType'.
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
     * @return Wartość dla właściwości'transactionDate'.
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
     * Pobiera datę lokalną transakcji.
     *
     * @return Lokalna data transakcji
     */
    public LocalDateTime getTransactionLocalDateTime() {
        return DateUtils.parse(transactionDate);
    }

    /**
     * Getter dla właściwości 'targetAccountId'.
     *
     * @return Wartość dla właściwości'targetAccountId'.
     */
    public long getTargetAccountId() {
        return targetAccountId;
    }

    /**
     * Setter dla właściwości 'targetAccountId'.
     *
     * @param targetAccountId Wartość do ustawienia dla właściwości 'targetAccountId'.
     */
    public void setTargetAccountId(long targetAccountId) {
        this.targetAccountId = targetAccountId;
    }

    /**
     * Getter dla właściwości 'convertedAmount'.
     *
     * @return Wartość dla właściwości'convertedAmount'.
     */
    public double getConvertedAmount() {
        return convertedAmount;
    }

    /**
     * Setter dla właściwości 'convertedAmount'.
     *
     * @param convertedAmount Wartość do ustawienia dla właściwości 'convertedAmount'.
     */
    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    /**
     * Getter dla właściwości 'userId'.
     *
     * @return Wartość dla właściwości'userId'.
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Getter dla właściwości 'exchangeRate'.
     *
     * @return Wartość dla właściwości'exchangeRate'.
     */
    public double getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Setter dla właściwości 'exchangeRate'.
     *
     * @param exchangeRate Wartość do ustawienia dla właściwości 'exchangeRate'.
     */
    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
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
     * Setter dla właściwości 'userId'.
     *
     * @param userId Wartość do ustawienia dla właściwości 'userId'.
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * Konwertuje tę transakcję dto na obiekt domeny transakcji.
     *
     * @return Transakcja
     */
    public Transaction toTransaction() {
        Transaction transaction = new Transaction();
        transaction.setId(getId());
        transaction.setAccountId(getAccountId());
        transaction.setCategoryId(getCategoryId());
        transaction.setAmount(getAmount());
        transaction.setStatus(getStatus());
        transaction.setTransactionType(getTransactionType());
        transaction.setTransactionDate(getTransactionLocalDateTime());
        transaction.setContactId(getContactId());
        transaction.setDescription(getDescription());

        // przelew
        if (isTransfer()) {
            Transfer transfer = new Transfer();
            transfer.setTargetAccountId(getTargetAccountId());
            transfer.setConvertedAmount(getConvertedAmount());
            transfer.setRate(getExchangeRate());
            transaction.setTransfer(transfer);
        }

        return transaction;
    }

    /**
     * Tworzy obiekt DTO transakcji z obiektu domeny transakcji.
     *
     * @param transaction Transakcja
     * @return Transakcja dto
     */
    public static TransactionDTO from(Transaction transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setId(transaction.getId());
        transactionDTO.setAccountId(transaction.getAccountId());
        transactionDTO.setCategoryId(transaction.getCategoryId());
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setStatus(transaction.getStatus());
        transactionDTO.setTransactionType(transaction.getTransactionType());
        transactionDTO.setTransactionDate(DateUtils.format(transaction.getTransactionDate()));
        transactionDTO.setContactId(transaction.getContactId());
        transactionDTO.setUserId(transaction.getUserId());
        transactionDTO.setDescription(transaction.getDescription());

        // przelew
        if (transactionDTO.isTransfer()) {
            Transfer transfer = transaction.getTransfer();
            transactionDTO.setTargetAccountId(transfer.getTargetAccountId());
            transactionDTO.setConvertedAmount(transfer.getConvertedAmount());
            transactionDTO.setExchangeRate(transfer.getRate());
        }

        return transactionDTO;
    }
}
