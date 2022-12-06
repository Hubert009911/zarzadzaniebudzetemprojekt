package am.jsl.personalfinances.service.account;

import am.jsl.personalfinances.domain.account.Account;
import am.jsl.personalfinances.dto.account.AccountListDTO;
import am.jsl.personalfinances.dto.account.AdjustBalanceDTO;
import am.jsl.personalfinances.service.BaseService;

import java.util.List;

/**
 * Interfejs serwisowy, który definiuje wszystkie metody pracy z {@link Account}
 */
public interface AccountService extends BaseService<Account> {
    /**
     * Zwraca wszystkie konta dla danego użytkownika.
     * @param userId identyfikator użytkownika
     * @return lista kont
     */
    List<AccountListDTO> getAccounts(long userId);

    /**
     * Aktualizuje saldo konta na podstawie danego obiektu AdjustBalanceDTO.
     * @param adjustBalance djustBalanceDTO object
     * @see AdjustBalanceDTO
     */
    void updateBalance(AdjustBalanceDTO adjustBalance);

    /**
     * Zwraca aktywne konta dla danego użytkownika.
     * @param userId identyfikator użytkownika
     * @return Lista aktywnych kont
     */
    List<AccountListDTO> getActiveAccounts(long userId);
}
