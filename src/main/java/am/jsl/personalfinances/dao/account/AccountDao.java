package am.jsl.personalfinances.dao.account;


import am.jsl.personalfinances.dao.BaseDao;
import am.jsl.personalfinances.domain.account.Account;
import am.jsl.personalfinances.dto.account.AccountListDTO;
import am.jsl.personalfinances.dto.account.AdjustBalanceDTO;

import java.util.List;

/**
 * Interfejs Dao do uzyskiwania dostępu {@link Account} obiekt domeny.
 */
public interface AccountDao extends BaseDao<Account> {

    /**
     * Zwraca wszystkie konta dla danego użytkownika.
     * @param userId identyfikator użytkownika.
     * @return lista kont.
     */
    List<AccountListDTO> getAccounts(long userId);

    /**
     * Zwraca aktywne konta dla danego użytkownika.
     * @param userId identyfikator użytkownika powiązany z kontem.
     * @return lista aktywnych kont.
     */
    List<AccountListDTO> getActiveAccounts(long userId);

    /**
     * Aktualizuje saldo konta na podstawie danego obiektu AdjustBalanceDTO.
     * @param adjustBalance obiekt AdjustBalanceDTO
     * @see AdjustBalanceDTO
     */
    void updateBalance(AdjustBalanceDTO adjustBalance);

    /**
     * Zmniejsza saldo danego konta.
     * @param id identyfikator konta
     * @param userId identyfikator użytkownika powiązany z kontem
     * @param amount kwota do odjęcia od salda
     */
    void decreaseBalance(long id, long userId, double amount);

    /**
     * Zwiększa saldo danego konta.
     * @param id  identyfikator konta
     * @param userId identyfikator użytkownika powiązany z kontem
     * @param amount Kwota do dodania do salda
     */
    void increaseBalance(long id, long userId, double amount);
}
