package am.jsl.personalfinances.dao.currency;

import am.jsl.personalfinances.dao.BaseDao;
import am.jsl.personalfinances.domain.Currency;

import java.util.List;

/**
 * Interfejs Dao do uzyskiwania dostępu {@link Currency} obiekt domeny.
 */
public interface CurrencyDao extends BaseDao<Currency> {
    /**
     * Zwraca walutę według kodu.
     * @return currency
     */
    Currency getByCode(String isoCode);

    /**
     * Zwraca wszystkie waluty.
     * @return Lista walut
     */
    List<Currency> list();

    /**
     * Usuwa walutę z podanym kodem.
     * @param code kod waluty
     */
    void delete(String code);
}
