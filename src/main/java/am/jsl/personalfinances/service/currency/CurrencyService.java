package am.jsl.personalfinances.service.currency;

import am.jsl.personalfinances.domain.Currency;
import am.jsl.personalfinances.service.BaseService;

import java.util.List;

/**
 * Interfejs serwisowy, który definiuje wszystkie metody pracy z {@link Currency}
 */
public interface CurrencyService extends BaseService<Currency> {
    /**
     * Zwraca walutę według kodu.
     * @return waluta
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

    /**
     * Zwraca kurs wymiany dla danych walut.
     * @param fromCurrency waluta źródłowa
     * @param toCurrency waluta docelowa
     * @return kurs walutowy
     */
    Double getRate(String fromCurrency, String toCurrency);

    /**
     * Czyści pamięć podręczną stawek.
     */
    void clearRatesCache();
}
