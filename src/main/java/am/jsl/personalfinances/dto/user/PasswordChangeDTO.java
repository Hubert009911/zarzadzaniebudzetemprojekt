package am.jsl.personalfinances.dto.user;

import java.io.Serializable;

/**
 * PasswordChangeDTO służy do zmiany hasła ze strony profilu użytkownika.
 */
public class PasswordChangeDTO implements Serializable {

    /**
     * Identyfikator użytkownika
     */
    private long id;

    /**
     * Stare hasło
     */
    private String oldPassword;

    /**
     * Nowe hasło
     */
    private String newPassword;

    /**
     * Ponownie wprowadzone nowe hasło
     */
    private String rePassword;

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
     * Getter dla właściwości 'oldPassword'.
     *
     * @return Wartość dla właściwości 'oldPassword'.
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * Setter dla właściwości 'oldPassword'.
     *
     * @param oldPassword Wartość do ustawienia dla właściwości 'oldPassword'.
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    /**
     * Getter dla właściwości 'newPassword'.
     *
     * @return Wartość dla właściwości 'newPassword'.
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * Setter dla właściwości 'newPassword'.
     *
     * @param newPassword Wartość do ustawienia dla właściwości 'newPassword'.
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * Getter dla właściwości 'rePassword'.
     *
     * @return Wartość dla właściwości 'rePassword'.
     */
    public String getRePassword() {
        return rePassword;
    }

    /**
     * Setter dla właściwości 'rePassword'.
     *
     * @param rePassword Wartość do ustawienia dla właściwości 'rePassword'.
     */
    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
