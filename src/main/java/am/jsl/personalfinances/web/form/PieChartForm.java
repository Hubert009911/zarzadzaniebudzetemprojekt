package am.jsl.personalfinances.web.form;

import java.io.Serializable;

/**
 * Formularz PieChartForm służy do wyszukiwania transakcji ze strony wykresu pi.
 */
public class PieChartForm implements Serializable {
    /**
     * Typ transakcji
     */
    private short type;
    /**
     * Konto transakcyjne
     */
    private long account;

    /**
     * Zakres dat transakcji
     */
    private String daterange;

    /**
     * Getter dla właściwości 'type'.
     *
     * @return Wartość dla właściwości'type'.
     */
    public short getType() {
        return type;
    }

    /**
     * Setter dla właściwości'type'.
     *
     * @param type Wartość ustawiona dla właściwości'type'.
     */
    public void setType(short type) {
        this.type = type;
    }

    /**
     * Getter dla właściwości'account'.
     *
     * @return Wartość dla właściwości'account'.
     */
    public long getAccount() {
        return account;
    }

    /**
     * Setter dla właściwości'account'.
     *
     * @param account Wartość ustawiona dla właściwości'account'.
     */
    public void setAccount(long account) {
        this.account = account;
    }

    /**
     * Getter dla właściwości'daterange'.
     *
     * @return Wartość dla właściwości'daterange'.
     */
    public String getDaterange() {
        return daterange;
    }

    /**
     * Setter dla właściwości'daterange'.
     *
     * @param daterange Wartość ustawiona dla właściwości'daterange'.
     */
    public void setDaterange(String daterange) {
        this.daterange = daterange;
    }
}
