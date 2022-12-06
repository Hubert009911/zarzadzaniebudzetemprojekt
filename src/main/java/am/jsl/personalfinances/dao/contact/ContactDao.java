package am.jsl.personalfinances.dao.contact;

import am.jsl.personalfinances.dao.BaseDao;
import am.jsl.personalfinances.domain.Contact;

/**
 * Interfejs Dao do uzyskiwania dostępu {@link Contact} obiekt domeny.
 */
public interface ContactDao extends BaseDao<Contact> {
    /**
     * Zwraca tytuł kontaktu według jego identyfikatora i identyfikatora użytkownika.
     * @param id Identyfikator kontaktu
     * @param userId identyfikator użytkownika
     * @return tytuł
     */
    String getTitle(long id, long userId);
}
