package am.jsl.personalfinances.domain.reminder;

import am.jsl.personalfinances.domain.Descriptive;
import am.jsl.personalfinances.domain.transaction.TransactionType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Obiekt domeny przypomnienia.
 * Przypomnienia będą przetwarzane przez zadanie przypomnienia na podstawie terminu przypomnienia
 * a transakcje zostaną utworzone na podstawie tej konfiguracji przypomnienia:
 * Konto, kategoria, kwota, typ transakcji, kontakt.
 */
public class Reminder extends Descriptive implements Serializable {

    /**
     * Stan przypomnienia
     * @see ReminderStatus
     */
    private byte status;

    /**
     * Termin upomnienia
     */
    private LocalDateTime dueDate;

    /**
     * Identyfikator konta przypomnienia
     */
    private long accountId;

    /**
     * Identyfikator kategorii przypomnienia
     */
    private long categoryId;

    /**
     * Kwota tego przypomnienia, która zostanie wykorzystana do tworzenia transakcji
     */
    private double amount;

    /**
     * Typ transakcji przypomnienia (koszt, dochód, przelew)
     * @see TransactionType
     */
    private byte transactionType;

    /**
     * Identyfikator kontaktu przypomnienia
     */
    private long contactId;

    /**
     * Jeśli automatyczne ładowanie jest prawdziwe, transakcja zostanie utworzona automatycznie
     */
    private boolean autoCharge;

    /**
     * Jeśli powtórzenie jest prawdziwe, to przypomnienie będzie przetwarzane wielokrotnie przy każdym wykonaniu zadania przypomnienia
     * @see ReminderRepeat
     */
    private byte repeat;

    /**
     * Szczegóły transakcji przelewu
     * @see ReminderTransfer
     */
    private ReminderTransfer reminderTransfer = null;

    /**
     * Zwraca wartość true, jeśli typem transakcji jest transfer.
     *
     * @return true, jeśli typem transakcji jest transfer.
     */
    public boolean isTransfer() {
        return transactionType == TransactionType.TRANSFER.getValue();
    }

    /**
     * Getter dla właściwości 'status'.
     *
     * @return Wartość dla właściwości 'status'.
     */
    public byte getStatus() {
        return status;
    }

    /**
     * Setter dla właściwości 'status'.
     *
     * @param status Wartość do ustawienia dla właściwości'status'.
     */
    public void setStatus(byte status) {
        this.status = status;
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
     * Getter dla właściwości 'categoryId'.
     *
     * @return Wartość dla właściwości 'categoryId'.
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
     * Getter dla właściwości 'amount'.
     *
     * @return Wartość dla właściwości 'amount'.
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
     * @param contactId Wartość do ustawienia dla właściwości  'contactId'.
     */
    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    /**
     * Getter dla właściwości 'autoCharge'.
     *
     * @return Wartość dla właściwości 'autoCharge'.
     */
    public boolean isAutoCharge() {
        return autoCharge;
    }

    /**
     * Setter dla właściwości 'autoCharge'.
     *
     * @param autoCharge Wartość do ustawienia dla właściwości  'autoCharge'.
     */
    public void setAutoCharge(boolean autoCharge) {
        this.autoCharge = autoCharge;
    }

    /**
     * Getter dla właściwości 'repeat'.
     *
     * @return Wartość dla właściwości 'repeat'.
     */
    public byte getRepeat() {
        return repeat;
    }

    /**
     * Setter dla właściwości 'repeat'.
     *
     * @param repeat Wartość do ustawienia dla właściwości 'repeat'.
     */
    public void setRepeat(byte repeat) {
        this.repeat = repeat;
    }

    /**
     * Getter dla właściwości 'dueDate'.
     *
     * @return Wartość dla właściwości 'dueDate'.
     */
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    /**
     * Setter dla właściwości 'dueDate'.
     *
     * @param dueDate Wartość do ustawienia dla właściwości 'dueDate'.
     */
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Pobiera przypomnienie.
     *
     * @return Przeniesienie przypomnienia
     */
    public ReminderTransfer getReminderTransfer() {
        return reminderTransfer;
    }

    /**
     * Ustawia transfer przypomnień.
     *
     * @param reminderTransfer Przeniesienie przypomnienia
     */
    public void setReminderTransfer(ReminderTransfer reminderTransfer) {
        this.reminderTransfer = reminderTransfer;
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
        final Reminder other = (Reminder) obj;
        return Objects.equals(this.getId(), other.getId());
    }
}
