package am.jsl.personalfinances.dto.user;

import java.io.Serializable;

/**
 * PasswordResetDTO służy do resetowania (za pośrednictwem poczty elektronicznej) hasła ze strony logowania.
 */
public class PasswordResetDTO implements Serializable {

    /**
     * Identyfikator użytkownika
     */
    private long userId;

    /**
     * Login użytkownika
     */
    private String login;

    /**
     * Token weryfikacyjny
     */
    private String token;

    /**
     * Nowe hasło
     */
    private String newPassword;

    /**
     * Ponownie wprowadzone nowe hasło
     */
    private String reNewPassword;

    /**
     * Getter dla właściwośći 'userId'.
     *
     * @return Wartość dla właściwośći 'userId'.
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Setter dla właściwośći 'userId'.
     *
     * @param userId Wartość do ustawienia dla właściwośći 'userId'.
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * Getter dla właściwośći 'token'.
     *
     * @return Wartość dla właściwośći 'token'.
     */
    public String getToken() {
        return token;
    }

    /**
     * Setter dla właściwośći 'token'.
     *
     * @param token Wartość do ustawienia dla właściwośći 'token'.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Getter dla właściwośći 'newPassword'.
     *
     * @return Wartość dla właściwośći 'newPassword'.
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * Setter dla właściwośći 'newPassword'.
     *
     * @param newPassword Wartość do ustawienia dla właściwośći 'newPassword'.
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * Getter dla właściwośći 'reNewPassword'.
     *
     * @return Wartość dla właściwośći 'reNewPassword'.
     */
    public String getReNewPassword() {
        return reNewPassword;
    }

    /**
     * Setter dla właściwośći 'reNewPassword'.
     *
     * @param reNewPassword Wartość do ustawienia dla właściwośći 'reNewPassword'.
     */
    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }

    /**
     * Getter dla właściwośći 'login'.
     *
     * @return Wartość dla właściwośći 'login'.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Setter dla właściwośći 'login'.
     *
     * @param login Wartość do ustawienia dla właściwośći 'login'.
     */
    public void setLogin(String login) {
        this.login = login;
    }
}
