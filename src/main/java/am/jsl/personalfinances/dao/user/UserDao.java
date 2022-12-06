package am.jsl.personalfinances.dao.user;

import am.jsl.personalfinances.dao.BaseDao;
import am.jsl.personalfinances.domain.user.User;
import am.jsl.personalfinances.domain.user.VerificationToken;
import am.jsl.personalfinances.domain.user.VerificationTokenType;
import am.jsl.personalfinances.ex.UserNotFoundException;
import am.jsl.personalfinances.search.ListPaginatedResult;
import am.jsl.personalfinances.search.user.UserSearchQuery;

/**
 * Interfejs Dao do uzyskiwania dostępu {@link User} obiekt domeny.
 */
public interface UserDao extends BaseDao<User> {
    /**
     * Pobiera wyniki użytkowników podzielone na strony dla danego zapytania.
     * @param userSearchQuery Zawieranie opcji kwerendy {@link UserSearchQuery} 
     * @return the {@link ListPaginatedResult} obiekt zawierający wynik stronicowany
     */
    ListPaginatedResult<User> search(UserSearchQuery userSearchQuery);

    /**
     * Ustawia last_login polu z bieżącą datą dla danego identyfikatora użytkownika.
     * @param userId identyfikator użytkownika
     */
    void login(long userId);

    /**
     * Usuwa użytkownika o podanym identyfikatorze użytkownika.
     * @param id identyfikator użytkownika
     */
    void deleteUser(long id);

    /**
     * Sprawdza, czy istnieje użytkownik z danym loginem i identyfikatorem.
     * @param login login
     * @param id identyfikator użytkownika
     * @return true, jeśli istnieje login użytkownika
     */
    boolean loginExists(String login, long id);

    /**
     * Sprawdza, czy istnieje użytkownik z danym adresem e-mail i identyfikatorem.
     * @param email E-maile
     * @param id identyfikator użytkownika
     * @return true, jeśli istnieje adres e-mail użytkownika
     */
    boolean emailExists(String email, long id);

    /**
     * Tworzy użytkownika z danym użytkownikiem.
     * @param user Użytkownik
     */
    void create(User user);

    /**
     * Aktualizuje użytkownika z danym użytkownikiem.
     * @param user Użytkownik
     */
    void update(User user);

    /**
     * Zwraca użytkownika o podanym identyfikatorze.
     * Rzuci {@link UserNotFoundException} jeśli nie znaleziono użytkownika.
     * @param userId identyfikator użytkownika
     * @return Użytkownik
     * @throws UserNotFoundException jeśli użytkownik nie został znaleziony
     */
    User getUser(long userId) throws UserNotFoundException;

    /**
     * Zmienia hasło użytkownika za pomocą podanego encryptedPassword.
     * @param encryptedPassword zaszyfrowane hasło
     * @param userId identyfikator użytkownika
     */
    void changePassword(String encryptedPassword, long userId);

    /**
     * Zwraca użytkownika o podanej nazwie użytkownika.
     * Rzuci {@link UserNotFoundException} jeśli użytkownik nie został znaleziony.
     * @param username Nazwa użytkownika
     * @return Użytkownik
     * @throws UserNotFoundException jeśli użytkownik nie został znaleziony
     */
    User getUser(String username) throws UserNotFoundException;

    /**
     * Aktualizuje ikonę dla danego użytkownika.
     * @param user Użytkownik
     */
    void updateIcon(User user);

    /**
     * Aktualizuje profil danego użytkownika.
     * @param user Użytkownik
     */
    void updateProfile(User user) throws Exception;

    /**
     * Zwraca użytkownika z podanym adresem e-mail.
     * @param email E-maile
     * @return Użytkownik
     */
    User getUserByEmail(String email);

    /**
     * Tworzy dane {@link VerificationToken}
     * @param verificationToken Token weryfikacyjny
     */
    void createVerificationToken(VerificationToken verificationToken);

    /**
     * Aktualizuje podane {@link VerificationToken}
     * @param verificationToken Token weryfikacyjny
     */
    void updateVerificationToken(VerificationToken verificationToken);

    /**
     * Zwraca VerificationToken z identyfikatorem użytkownika i tokenType.
     * @param userId identyfikator użytkownika
     * @param tokenType Typ tokenu
     * @return Token weryfikacyjny
     */
    VerificationToken getToken(long userId, VerificationTokenType tokenType);
}
