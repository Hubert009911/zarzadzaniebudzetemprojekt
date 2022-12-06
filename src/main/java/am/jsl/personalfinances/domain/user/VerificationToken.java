package am.jsl.personalfinances.domain.user;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * Token weryfikacyjny jest wysyłany na adres e-mail użytkownika podczas tworzenia użytkowników lub resetowania haseł.
 * Wygaśnie w ciągu 24 godzin po utworzeniu.
 */
public class VerificationToken {

    /**
     * Czas wygaśnięcia tokena weryfikacyjnego (24 godziny)
     */
    private static final int EXPIRATION = 60 * 24;

    /**
     * Identyfikator wewnętrzny
     */
    private long id;

    /**
     * Unikalny, losowo generowany token
     */
    private String token;

    /**
     * Typ tokena (NEW_ACCOUNT, PASSWORD_RESET)
     */
    private byte tokenType;

    /**
     * Identyfikator użytkownika powiązany z tym tokenem weryfikacyjnym
     */
    private long userId;

    /**
     * Data wygaśnięcia tego tokenu weryfikacyjnego
     */
    private Date expiryDate;

    /**
     * Wskazuje, czy ten token weryfikacyjny wygasł
     */
    private boolean expired = false;

    /**
     * Konstruktor domyślny.
     */
    public VerificationToken() {
        super();
    }

    /**
     * Oblicza datę wygaśnięcia od daty bieżącej.
     *
     * @param expiryTimeInMinutes Czas wygaśnięcia w minutach
     * @return Data ważności
     */
    private Date calculateExpiryDate(final int expiryTimeInMinutes) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    /**
     * Ustawia token i oblicza datę wygaśnięcia tego tokenu weryfikacyjnego.
     *
     * @param token Token do ustawienia
     */
    public void updateToken(final String token) {
        this.token = token;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
        this.expired = false;
    }

    /**
     * Getter dla właściwości 'id'.
     *
     * @return Wartość dla właściwości  'id'.
     */
    public long getId() {
        return id;
    }

    /**
     * Setter dla właściwości  'id'.
     *
     * @param id Wartość do ustawienia dla właściwości 'id'.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter dla właściwości  'token'.
     *
     * @return Wartość dla właściwości  'token'.
     */
    public String getToken() {
        return token;
    }

    /**
     * Setter dla właściwości  'token'.
     *
     * @param token Wartość do ustawienia dla właściwości 'token'.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Getter dla właściwości  'tokenType'.
     *
     * @return Wartość dla właściwości  'tokenType'.
     */
    public byte getTokenType() {
        return tokenType;
    }

    /**
     * Setter dla właściwości  'tokenType'.
     *
     * @param tokenType Wartość do ustawienia dla właściwości 'tokenType'.
     */
    public void setTokenType(byte tokenType) {
        this.tokenType = tokenType;
    }

    /**
     * Getter dla właściwości  'userId'.
     *
     * @return Wartość dla właściwości  'userId'.
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Setter dla właściwości  'userId'.
     *
     * @param userId Wartość do ustawienia dla właściwości 'userId'.
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * Getter dla właściwości  'expiryDate'.
     *
     * @return Wartość dla właściwości  'expiryDate'.
     */
    public Date getExpiryDate() {
        return expiryDate;
    }

    /**
     * Setter dla właściwości  'expiryDate'.
     *
     * @param expiryDate Wartość do ustawienia dla właściwości 'expiryDate'.
     */
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Getter dla właściwości  'expired'.
     *
     * @return Wartość dla właściwości  'expired'.
     */
    public boolean isExpired() {
        return expired;
    }

    /**
     * Setter dla właściwości  'expired'.
     *
     * @param expired Wartość do ustawienia dla właściwości 'expired'.
     */
    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, token, tokenType, userId, expiryDate, expired);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final VerificationToken other = (VerificationToken) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.token, other.token)
                && Objects.equals(this.tokenType, other.tokenType)
                && Objects.equals(this.userId, other.userId)
                && Objects.equals(this.expiryDate, other.expiryDate)
                && Objects.equals(this.expired, other.expired);
    }
}
