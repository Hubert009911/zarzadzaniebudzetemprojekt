package am.jsl.personalfinances.service.user;

import am.jsl.personalfinances.domain.user.User;
import am.jsl.personalfinances.domain.user.VerificationToken;
import am.jsl.personalfinances.domain.user.VerificationTokenType;
import am.jsl.personalfinances.dto.user.PasswordResetDTO;
import am.jsl.personalfinances.ex.InvalidTokenException;
import am.jsl.personalfinances.ex.UserNotFoundException;
import am.jsl.personalfinances.search.ListPaginatedResult;
import am.jsl.personalfinances.search.user.UserSearchQuery;
import am.jsl.personalfinances.service.BaseService;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.mail.MessagingException;
import java.util.Locale;

/**
 * Interfejs serwisowy, który definiuje wszystkie metody pracy z {@link User}
 */
public interface UserService extends UserDetailsService, BaseService<User> {

    /**
     * Pobiera wyniki użytkowników podzielone na strony dla danego zapytania.
     * @param userSearchQuery the {@link UserSearchQuery} Zawieranie opcji kwerendy
     * @return the {@link ListPaginatedResult} obiekt zawierający wynik stronicowany
     */
	ListPaginatedResult<User> search(UserSearchQuery userSearchQuery);

    /**
     * Ustawia last_login polu z bieżącą datą dla danego identyfikatora użytkownika.
     * @param userId identyfikator użytkownika
     */
	void login(long userId);

	/**
	 * Aktualizuje profil danego użytkownika.
	 * @param user Użytkownik
	 * @throws Exception wyrzuci, jeśli wystąpi wyjątek
	 */
	void updateProfile(User user) throws Exception;

    /**
     * Zwraca użytkownika o podanym identyfikatorze.
     * Będzie rzucać {@link UserNotFoundException}  jeśli użytkownik nie został znaleziony.
     * @param userId identyfikator użytkownika
     * @return Użytkownik
     * @throws UserNotFoundException jeśli użytkownik nie został znaleziony
     */
	User getUser(long userId) throws UserNotFoundException;

    /**
     * Zwraca użytkownika o podanej nazwie użytkownika.
     *  Będzie rzucać {@link UserNotFoundException} jeśli użytkownik nie został znaleziony
     * @param name Nazwa użytkownika
     * @return Użytkownik
     * @throws UserNotFoundException jeśli użytkownik nie został znaleziony
     */
	User getUser(String name) throws UserNotFoundException;

    /**
	 * Szyfruje podane hasło i aktualizacje w użytkowniku.
     * Zmienia hasło użytkownika za pomocą podanego encryptedPassword.
     * @param newPassword Nowe hasło
     * @param id identyfikator użytkownika
     */
	void changePassword(String newPassword, long id);

	/**
	 * Aktualizuje ikonę dla danego użytkownika.
	 * @param user Użytkownik
	 */
    void updateIcon(User user);

	/**
	 * Usuwa użytkownika o podanym identyfikatorze użytkownika.
	 * @param user Użytkownik
	 */
	void deleteUser(User user);

	/**
	 * Generuje i wysyła wiadomość e-mail dotyczącą resetowania hasła na podany adres e-mail i ustawienia regionalne.
	 * @param contextPath Ścieżka kontekstu aplikacji
	 * @param email adres e-mail
	 * @param locale Ustawienia regionalne
	 * @throws MessagingException Jeśli wystąpi błąd
	 */
    void sendPasswordResetMail(String contextPath, String email, Locale locale)
			throws MessagingException;

	/**
	 * Sprawdź, czy dany token jest prawidłowy dla danego użytkownika
	 * i zwraca obiekt VerificationToken.
	 * Zgłosi InvalidTokenException, jeśli token jest nieprawidłowy.
	 * @param userId identyfikator użytkownika
	 * @param token the token
	 * @param tokenType Typ tokenu
	 * @return obiekt VerificationToken
	 * @throws InvalidTokenException jeśli token jest nieprawidłowy.
	 */
	VerificationToken checkToken(long userId, String token, VerificationTokenType tokenType)
			throws InvalidTokenException;

	/**
	 * Zwraca VerificationToken z identyfikatorem użytkownika i tokenType.
	 * @param userId identyfikator użytkownika
	 * @param tokenType Typ tokenu
	 * @return the VerificationToken
	 */
	VerificationToken getToken(long userId, VerificationTokenType tokenType);

	/**
	 * Resetuje hasło użytkownika na podstawie {@link PasswordResetDTO} objekt.
	 * @param passwordResetDTO the PasswordResetDTO
	 * @throws InvalidTokenException Jeśli token jest nieprawidłowy
	 */
    void resetPassword(PasswordResetDTO passwordResetDTO) throws InvalidTokenException;

	/**
	 * Tworzy użytkownika o statusie nieaktywny i wysyła link potwierdzający rejestrację za pomocą linku aktywacyjnego.
	 * @param user Użytkownik
	 * @param locale Ustawienia regionalne
	 * @param contextPath Ścieżka kontekstu aplikacji
	 * @throws Exception Jeśli wystąpi błąd
	 */
    void register(User user, Locale locale, String contextPath) throws Exception;

	/**
	 * Potwierdza rejestrację użytkownika. Jeśli token rejestracyjny jest prawidłowy, ustawia podany status użytkownika na aktywny
	 * i wygasa token weryfikacyjny.
	 * Będzie rzucać {@link InvalidTokenException} Jeśli token jest nieprawidłowy lub wygasł
	 * i {@link UserNotFoundException} jeśli użytkownik nie został znaleziony.
	 * @param userId identyfikator użytkownika
	 * @param token the token
	 * @throws InvalidTokenException  Jeśli token jest nieprawidłowy lub wygasł
	 * @throws UserNotFoundException jeśli użytkownik nie został znaleziony.
	 */
    void confirmRegistration(Long userId, String token) throws InvalidTokenException, UserNotFoundException;
}
