package am.jsl.personalfinances.service;

import javax.mail.MessagingException;
import java.util.Locale;

/**
 * Interfejs usługi, który definiuje wszystkie metody wysyłania wiadomości e-mail.
 */
public interface EmailService {
    /**
     * Wyślij wiadomość e-mail dotyczącą resetowania hasła do danego odbiorcyE-mail z linkiem resetowania hasła.
     *
     * @param recipientEmail    Adres e-mail odbiorcy
     * @param resetPasswordLink Link Resetuj hasło
     * @param locale            Ustawienia regionalne
     * @throws MessagingException Jeśli wystąpi błąd
     */
    void sendPasswordResetMail(String recipientEmail, String resetPasswordLink, Locale locale)
            throws MessagingException;

    /**
     * Wyślij e-mail potwierdzający rejestrację do danego odbiorcyE-mail z linkiem potwierdzającym.
     *
     * @param recipientEmail          Adres e-mail odbiorcy
     * @param registrationConfirmLink Link potwierdzający rejestrację
     * @param locale                  Ustawienia regionalne
     * @throws MessagingException Jeśli wystąpi błąd
     */
    void sendRegistrationMail(String recipientEmail, String registrationConfirmLink, Locale locale)
            throws MessagingException;

    /**
     * Wysyła wiadomość e-mail z podanymi parametrami.
     *
     * @param email     adres e-mail
     * @param subject Temat wiadomości e-mail
     * @param emailText Tekst wiadomości e-mail
     * @throws MessagingException Jeśli wystąpi błąd
     */
    void sendEmail(String email, String subject, String emailText)
            throws MessagingException;
}
