package am.jsl.personalfinances.dto.reminder;

import java.io.Serializable;

/**
 * ReminderDetailsDTO służy do przesyłania szczegółowych informacji przypomnienia.
 */
public class ReminderDetailsDTO extends BaseReminderDTO implements Serializable {
    /**
     * Nazwa konta
     */
    private String account;

    /**
     *  Ikona konta
     */
    private String accountIcon;

    /**
     * Kolor konta
     */
    private String accountColor;

    /**
     * Identyfikator kontaktu
     */
    private long contactId = 0;

    /**
     * Nazwa kontaktu
     */
    private String contact;

    /**
     * Identyfikator konta docelowego dla typu przelewu
     */
    private long targetAccountId = 0;

    /**
     * Nazwa konta docelowego dla typu przelewu
     */
    private String targetAccount;

    /**
     * Ikona konta docelowego dla typu przelewu
     */
    private String targetAccountIcon;

    /**
     * Kolor konta docelowego dla typu transferu
     */
    private String targetAccountColor;

    /**
     * Macierzysty symbol waluty konta docelowego dla typu przelewu
     */
    private String targetAccountSymbol;

    /**
     * Kurs waluty, który jest używany podczas obliczania convertedAmount
     */
    private double exchangeRate;

    /**
     * Przeliczona kwota
     */
    private double convertedAmount;

    /**
     * Jeśli automatyczne ładowanie jest prawdziwe, transakcja zostanie utworzona automatycznie
     */
    private boolean autoCharge;

    /**
     * Jeśli powtórzenie jest prawdziwe, to przypomnienie będzie przetwarzane wielokrotnie przy każdym wykonaniu zadania przypomnienia
     */
    private short repeat;

    /**
     * Getter dla właściwości 'account'.
     *
     * @return Wartość dla właściwości 'account'.
     */
    public String getAccount() {
        return account;
    }

    /**
     * Setter dla właściwości 'account'.
     *
     * @param account Wartość do ustawienia dla właściwości 'account'.
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * Getter dla właściwości 'accountIcon'.
     *
     * @return Wartość dla właściwości 'accountIcon'.
     */
    public String getAccountIcon() {
        return accountIcon;
    }

    /**
     * Setter dla właściwości 'accountIcon'.
     *
     * @param accountIcon Wartość do ustawienia dla właściwości 'accountIcon'.
     */
    public void setAccountIcon(String accountIcon) {
        this.accountIcon = accountIcon;
    }

    /**
     * Getter dla właściwości 'accountColor'.
     *
     * @return Wartość dla właściwości 'accountColor'.
     */
    public String getAccountColor() {
        return accountColor;
    }

    /**
     * Setter dla właściwości 'accountColor'.
     *
     * @param accountColor Wartość do ustawienia dla właściwości 'accountColor'.
     */
    public void setAccountColor(String accountColor) {
        this.accountColor = accountColor;
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
     * Getter dla właściwości 'contact'.
     *
     * @return Wartość dla właściwości 'contact'.
     */
    public String getContact() {
        return contact;
    }

    /**
     * Setter dla właściwości 'contact'.
     *
     * @param contact Wartość do ustawienia dla właściwości 'contact'.
     */
    public void setContact(String contact) {
        this.contact = contact;
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
     * Getter dla właściwości 'targetAccount'.
     *
     * @return Wartość dla właściwości 'targetAccount'.
     */
    public String getTargetAccount() {
        return targetAccount;
    }

    /**
     * Setter dla właściwości 'targetAccount'.
     *
     * @param targetAccount Wartość do ustawienia dla właściwości 'targetAccount'.
     */
    public void setTargetAccount(String targetAccount) {
        this.targetAccount = targetAccount;
    }

    /**
     * Getter dla właściwości 'targetAccountIcon'.
     *
     * @return Wartość dla właściwości 'targetAccountIcon'.
     */
    public String getTargetAccountIcon() {
        return targetAccountIcon;
    }

    /**
     * Setter dla właściwości 'targetAccountIcon'.
     *
     * @param targetAccountIcon Wartość do ustawienia dla właściwości 'targetAccountIcon'.
     */
    public void setTargetAccountIcon(String targetAccountIcon) {
        this.targetAccountIcon = targetAccountIcon;
    }

    /**
     * Getter dla właściwości 'targetAccountColor'.
     *
     * @return Wartość dla właściwości 'targetAccountColor'.
     */
    public String getTargetAccountColor() {
        return targetAccountColor;
    }

    /**
     * Setter dla właściwości 'targetAccountColor'.
     *
     * @param targetAccountColor Wartość do ustawienia dla właściwości 'targetAccountColor'.
     */
    public void setTargetAccountColor(String targetAccountColor) {
        this.targetAccountColor = targetAccountColor;
    }

    public String getTargetAccountSymbol() {
        return targetAccountSymbol;
    }

    public void setTargetAccountSymbol(String targetAccountSymbol) {
        this.targetAccountSymbol = targetAccountSymbol;
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
    public short getRepeat() {
        return repeat;
    }

    /**
     * Setter dla właściwości 'repeat'.
     *
     * @param repeat Wartość do ustawienia dla właściwości 'repeat'.
     */
    public void setRepeat(short repeat) {
        this.repeat = repeat;
    }
}
