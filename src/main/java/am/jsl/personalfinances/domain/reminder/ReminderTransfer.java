package am.jsl.personalfinances.domain.reminder;

import java.io.Serializable;

/**
 * Obiekt domeny szczegółów transferu.
 */
public class ReminderTransfer implements Serializable {
    /**
     * Identyfikator wewnętrzny
     */
    private long id;

    /**
     * Identyfikator przypomnienia
     */
    private long reminderId;

    /**
     * Identyfikator konta docelowego
     */
    private long targetAccountId = 0;

    /**
     * Przeliczona kwota
     */
    private double convertedAmount = 0;

    /**
     * Kurs waluty, który jest używany podczas obliczania convertedAmount
     */
    private double rate = 0;

    /**
     * Pobiera identyfikator.
     *
     * @return identyfikator
     */
    public long getId() {
        return id;
    }

    /**
     * Ustawia identyfikator.
     *
     * @param id identyfikator
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Pobiera identyfikator przypomnienia.
     *
     * @return Identyfikator przypomnienia
     */
    public long getReminderId() {
        return reminderId;
    }

    /**
     * Ustawia identyfikator przypomnienia.
     *
     * @param reminderId Identyfikator przypomnienia
     */
    public void setReminderId(long reminderId) {
        this.reminderId = reminderId;
    }

    /**
     * Pobiera identyfikator konta docelowego.
     *
     * @return Identyfikator konta docelowego
     */
    public long getTargetAccountId() {
        return targetAccountId;
    }

    /**
     * Ustawia identyfikator konta docelowego.
     *
     * @param targetAccountId Identyfikator konta docelowego
     */
    public void setTargetAccountId(long targetAccountId) {
        this.targetAccountId = targetAccountId;
    }

    /**
     * Pobiera przeliczoną kwotę.
     *
     * @return przeliczona kwota
     */
    public double getConvertedAmount() {
        return convertedAmount;
    }

    /**
     * Ustawia przeliczoną kwotę.
     *
     * @param convertedAmount przeliczona kwota
     */
    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    /**
     * Pobiera stawkę.
     *
     * @return stawka
     */
    public double getRate() {
        return rate;
    }

    /**
     * Ustawia stawkę.
     *
     * @param rate stawka
     */
    public void setRate(double rate) {
        this.rate = rate;
    }
}
