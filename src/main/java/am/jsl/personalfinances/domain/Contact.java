package am.jsl.personalfinances.domain;

import java.io.Serializable;

/**
 * Obiekt domeny kontaktu.
 */
public class Contact extends Descriptive implements Serializable {

    /**
     * Imię i nazwisko osoby kontaktowej
     */
    private String fullName;

    /**
     * Adres e-mail osoby kontaktowej
     */
    private String email;

    /**
     * Telefon kontaktu
     */
    private String phone;

    /**
     * Getter dla właściwości 'fullName'.
     *
     * @return Wartość dla właściwości  'fullName'.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Setter dla właściwości  'fullName'.
     *
     * @param fullName Wartość do ustawienia dla właściwości 'fullName'.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Getter dla właściwości  'email'.
     *
     * @return Wartość dla właściwości 'email'.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter dla właściwości  'email'.
     *
     * @param email Wartość do ustawienia dla właściwości 'email'.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter dla właściwości  'phone'.
     *
     * @return Wartość dla właściwości 'phone'.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Setter dla właściwości  'phone'.
     *
     * @param phone Wartość do ustawienia dla właściwości 'phone'.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
