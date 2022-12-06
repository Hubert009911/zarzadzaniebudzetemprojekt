package am.jsl.personalfinances.service.transaction;

import am.jsl.personalfinances.domain.transaction.Transaction;
import am.jsl.personalfinances.dto.transaction.*;
import am.jsl.personalfinances.search.transaction.TransactionByCategorySearchQuery;
import am.jsl.personalfinances.search.transaction.TransactionSearchQuery;
import am.jsl.personalfinances.service.BaseService;

import java.util.List;

/**
 * interfejs serwisowy, który definiuje wszystkie metody pracy z {@link Transaction}
 */
public interface TransactionService extends BaseService<Transaction> {

    /**
     * Pobiera podzielone na strony wyniki transakcji dla danego zapytania.
     * @param searchQuery the {@link TransactionSearchQuery} Zawieranie opcji kwerendy
     * @return the {@link TransactionSearchResult} zawierające wynik stronicowany
     */
    TransactionSearchResult search(TransactionSearchQuery searchQuery);

    /**
     * Tworzy partię transakcji na podstawie danego AddTransactionsDTO obiektu.
     * @param addTransactionsDTO the AddTransactionsDTO
     * @see AddTransactionsDTO
     */
    void createBatch(AddTransactionsDTO addTransactionsDTO);

    /**
     * Zwraca szczegóły transakcji z podanym identyfikatorem i identyfikatorem użytkownika.
     * @param id identyfikator transakcji
     * @param userId identyfikator użytkownika
     * @return the {@link TransactionDetailsDTO} containing transaction details
     */
    TransactionDetailsDTO getDetails(long id, long userId);

    /**
     * Zwraca transakcje z podanym identyfikatorem przypomnienia i identyfikatorem użytkownika.
     * @param reminderId Identyfikator przypomnienia
     * @param userId identyfikator użytkownika
     * @return the list of {@link TransactionListDTO} items
     */
    List<TransactionListDTO> getReminderTransactions(long reminderId, long userId);

    /**
     * Retrieves paginated result of transactions for the given search query.
     * @param query the {@link TransactionByCategorySearchQuery} query containing search options
     * @return Lista pozycji {@link TransactionByCategoryDTO}
     */
    TransactionByCategoryResultDTO search(TransactionByCategorySearchQuery query);

    /**
     * Zwraca kwotę transakcji z podanym identyfikatorem transakcji i identyfikatorem użytkownika.
     * @param id identyfikator transakcji
     * @param userId identyfikator użytkownika
     * @return kwota
     */
    double getAmount(long id, long userId);
}
