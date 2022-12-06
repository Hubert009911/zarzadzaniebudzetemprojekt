package am.jsl.personalfinances.dto.reminder;

import am.jsl.personalfinances.domain.reminder.Reminder;
import am.jsl.personalfinances.domain.reminder.ReminderRepeat;
import am.jsl.personalfinances.domain.reminder.ReminderStatus;
import am.jsl.personalfinances.domain.reminder.ReminderTransfer;
import am.jsl.personalfinances.domain.transaction.TransactionType;
import am.jsl.personalfinances.util.DateUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ReminderDTO służy do tworzenia i aktualizowania przypomnień z Internetu.
 */
public class ReminderDTO implements Serializable {

    /**
     * Identyfikator wewnętrzny
     */
    private long id;

    /**
     * Nazwa przypomnienia
     */
    private String name;

    /**
     * Opis
     */
    private String description;

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
     * Stan przypomnienia
     */
    private byte status;

    /**
     * Typ transakcji przypomnienia (koszt, dochód, przelew)
     */
    private byte transactionType;

    /**
     * Termin upomnienia
     */
    private String dueDate;

    /**
     * Identyfikator kontaktu przypomnienia
     */
    private long contactId;

    /**
     * Kurs waluty, który jest używany podczas obliczania convertedAmount
     */
    private double exchangeRate;

    /**
     * Identyfikator konta docelowego dla typu przelewu
     */
    private long targetAccountId;

    /**
     * Przeliczona kwota
     */
    private double convertedAmount;

    /**
     * Jeśli automatyczne ładowanie jest prawdziwe, transakcja zostanie utworzona automatycznie
     */
    private boolean autoCharge = false;

    /**
     * Jeśli powtórzenie jest prawdziwe, to przypomnienie będzie przetwarzane wielokrotnie przy każdym wykonaniu zadania przypomnienia
     */
    private byte repeat;

    /**
     * Identyfikator użytkownika
     */
    private long userId;

    /**
     * Konstruktor domyślny
     */
    public ReminderDTO() {
        super();
    }

    /**
     * Konstruuje nowy ReminderDTO z podanymi polami.
     *
     * @param accountId       identyfikator konta
     * @param transactionType Typ transakcji
     * @param dueDate         termin płatności
     * @param userId          identyfikator użytkownika
     */
    public ReminderDTO(long accountId, byte transactionType, LocalDateTime dueDate, long userId) {
        super();
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.dueDate = DateUtils.format(dueDate);
        this.userId = userId;
        this.status = ReminderStatus.ACTIVE.getValue();
        this.repeat = ReminderRepeat.NONE.getValue();
    }

    /**
     * Zwraca wartość true, jeśli typem transakcji jest transfer.
     *
     * @return true, jeśli typem transakcji jest transfer.
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
     * @param status Wartość do ustawienia dla właściwości 'status'.
     */
    public void setStatus(byte status) {
        this.status = status;
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
     * Gets due local date time.
     *
     * @return the due local date time
     */
    public LocalDateTime getDueLocalDateTime() {
        return DateUtils.parse(dueDate);
    }

    /**
     * Getter dla właściwości 'targetAccountId'.
     *
     * @return Wartość dla właściwości 'targetAccountId'.
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
     * @return Wartość dla właściwości 'convertedAmount'.
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
     * @return Wartość dla właściwości 'userId'.
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Getter dla właściwości 'exchangeRate'.
     *
     * @return Wartość dla właściwości 'exchangeRate'.
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
     * @param autoCharge Wartość do ustawienia dla właściwości 'autoCharge'.
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
     * Getter dla właściwości 'name'.
     *
     * @return Wartość dla właściwości 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter dla właściwości 'name'.
     *
     * @param name Wartość do ustawienia dla właściwości 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Pobiera termin płatności.
     *
     * @return termin płatności
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Ustawia termin płatności.
     *
     * @param dueDate termin płatności
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
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
     * Konwertuje tę obiekt DTO na obiekt domeny przypomnienia.
     *
     * @return Obiekt domeny przypomnienia
     */
    public Reminder toReminder() {
        Reminder reminder = new Reminder();
        reminder.setId(getId());
        reminder.setName(getName());
        reminder.setAccountId(getAccountId());
        reminder.setCategoryId(getCategoryId());
        reminder.setAmount(getAmount());
        reminder.setStatus(getStatus());
        reminder.setTransactionType(getTransactionType());
        reminder.setDueDate(getDueLocalDateTime());
        reminder.setContactId(getContactId());
        reminder.setDescription(getDescription());
        reminder.setRepeat(getRepeat());
        reminder.setAutoCharge(isAutoCharge());

        // Tworzenie szczegółów transferu
        if (reminder.isTransfer()) {
            ReminderTransfer reminderTransfer = new ReminderTransfer();
            reminderTransfer.setReminderId(getId());
            reminderTransfer.setTargetAccountId(getTargetAccountId());
            reminderTransfer.setRate(getExchangeRate());
            reminderTransfer.setConvertedAmount(getConvertedAmount());
            reminder.setReminderTransfer(reminderTransfer);
        }

        return reminder;
    }

    /**
     * Konwertuje obiekt domeny przypomnienia na ReminderDTO.
     *
     * @param reminder Przypomnienie o konwersji
     * @return ReminderDTO
     */
    public static ReminderDTO from(Reminder reminder) {
        ReminderDTO dto = new ReminderDTO();
        dto.setId(reminder.getId());
        dto.setName(reminder.getName());
        dto.setAccountId(reminder.getAccountId());
        dto.setCategoryId(reminder.getCategoryId());
        dto.setAmount(reminder.getAmount());
        dto.setStatus(reminder.getStatus());
        dto.setTransactionType(reminder.getTransactionType());
        dto.setDueDate(DateUtils.format(reminder.getDueDate()));
        dto.setUserId(reminder.getUserId());

        dto.setRepeat(reminder.getRepeat());
        dto.setAutoCharge(reminder.isAutoCharge());
        dto.setContactId(reminder.getContactId());
        dto.setDescription(reminder.getDescription());

        // Szczegóły przelewu
        ReminderTransfer reminderTransfer = reminder.getReminderTransfer();

        if (reminderTransfer != null) {
            dto.setTargetAccountId(reminderTransfer.getTargetAccountId());
            dto.setExchangeRate(reminderTransfer.getRate());
            dto.setConvertedAmount(reminderTransfer.getConvertedAmount());
        }

        return dto;
    }
}
