package am.jsl.personalfinances.dao.transaction;

import am.jsl.personalfinances.dao.BaseDao;
import am.jsl.personalfinances.domain.transaction.Transaction;
import am.jsl.personalfinances.dto.transaction.TransactionByCategoryDTO;
import am.jsl.personalfinances.dto.transaction.TransactionDetailsDTO;
import am.jsl.personalfinances.dto.transaction.TransactionListDTO;
import am.jsl.personalfinances.dto.transaction.TransactionSearchResult;
import am.jsl.personalfinances.search.transaction.TransactionByCategorySearchQuery;
import am.jsl.personalfinances.search.transaction.TransactionSearchQuery;

import java.util.List;

/**
 * Interfejs Dao do uzyskiwania dostępu {@link Transaction} obiekt domeny.
 */
public interface TransactionDao extends BaseDao<Transaction> {
    /**
     * Pobiera podzielone na strony wyniki transakcji dla danego zapytania.
     * @param searchQuery the {@link TransactionSearchQuery} Zawieranie opcji kwerendy
     * @return the {@link TransactionSearchResult} zawierające wynik stronicowany
     */
    TransactionSearchResult search(TransactionSearchQuery searchQuery);

    /**
     * Tworzy podaną listę transakcji.
     * @param transactions Lista transakcji
     */
    void createBatch(List<Transaction> transactions);

    /**
     * Zwraca szczegóły transakcji z podanym identyfikatorem i identyfikatorem użytkownika.
     * @param id identyfikator transakcji
     * @param userId identyfikator użytkownika
     * @return {@link TransactionDetailsDTO} zawierające szczegóły transakcji
     */
    TransactionDetailsDTO getDetails(long id, long userId);

    /**
     * Zwraca transakcje z podanym identyfikatorem przypomnienia i identyfikatorem użytkownika.
     * @param reminderId Identyfikator przypomnienia
     * @param userId identyfikator użytkownika
     * @return wykaz elementów {@link TransactionListDTO}
     */
    List<TransactionListDTO> getReminderTransactions(long reminderId, long userId);

    /**
     * Pobiera podzielone na strony wyniki transakcji dla danego zapytania.
     * @param query the {@link TransactionByCategorySearchQuery} Zapytanie zawierające opcje wyszukiwania
     * @return wykaz elementów {@link TransactionByCategoryDTO}
     */
    List<TransactionByCategoryDTO> search(TransactionByCategorySearchQuery query);

    /**
     * Zwraca kwotę transakcji z podanym identyfikatorem transakcji i identyfikatorem użytkownika.
     * @param id identyfikator transakcji
     * @param userId identyfikator użytkownika
     * @return wartość
     */
    double getAmount(long id, long userId);
}
