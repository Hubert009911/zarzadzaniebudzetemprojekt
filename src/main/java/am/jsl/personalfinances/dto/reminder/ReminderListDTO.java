package am.jsl.personalfinances.dto.reminder;

import java.io.Serializable;

/**
 * ReminderListDTO służy do wyświetlania przypomnień na stronie listy przypomnień.
 */
public class ReminderListDTO extends BaseReminderDTO implements Serializable {

    /**
     * Identyfikator użytkownika
     */
    private long userId;

    /**
     * Jeśli powtórzenie jest prawdziwe, to przypomnienie będzie przetwarzane wielokrotnie przy każdym wykonaniu zadania przypomnienia
     */
    private byte repeat;

    /**
     * Jeśli automatyczne ładowanie jest prawdziwe, transakcja zostanie utworzona automatycznie
     */
    private boolean autoCharge;

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
}
