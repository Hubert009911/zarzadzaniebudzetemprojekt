package am.jsl.personalfinances.domain.reminder;

import java.io.Serializable;

/**
 * Mapowanie przypomnienia na transakcję.
 */
public class ReminderTransaction implements Serializable {

    /**
     * Identyfikator przypomnienia
     */
    private long reminderId;

    /**
     * Identyfikator transakcji
     */
    private long transactionId;

    /**
     * Getter dla właściwości 'reminderId'.
     *
     * @return Wartość dla właściwości 'reminderId'.
     */
    public long getReminderId() {
        return reminderId;
    }

    /**
     * Setter dla właściwości 'reminderId'.
     *
     * @param reminderId Wartość do ustawienia dla właściwości 'reminderId'.
     */
    public void setReminderId(long reminderId) {
        this.reminderId = reminderId;
    }

    /**
     * Getter dla właściwości 'transactionId'.
     *
     * @return Wartość dla właściwości 'transactionId'.
     */
    public long getTransactionId() {
        return transactionId;
    }

    /**
     * Setter dla właściwości 'transactionId'.
     *
     * @param transactionId Wartość do ustawienia dla właściwości 'transactionId'.
     */
    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }
}
