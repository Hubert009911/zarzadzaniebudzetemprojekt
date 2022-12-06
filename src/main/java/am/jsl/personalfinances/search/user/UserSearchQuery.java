package am.jsl.personalfinances.search.user;

import am.jsl.personalfinances.domain.user.User;
import am.jsl.personalfinances.search.Query;

/**
 * Custom {@link Query} do wyszukiwania elementów.  {@link User}
 *
 * @author hamlet
 */
public class UserSearchQuery extends Query<User> {

    /**
     * Tworzy wystąpienie nowego zapytania wyszukiwania użytkownika.
     *
     * @param page     strona
     * @param pageSize rozmiar strony
     */
    public UserSearchQuery(int page, int pageSize) {
        super(page, pageSize);
    }
}
