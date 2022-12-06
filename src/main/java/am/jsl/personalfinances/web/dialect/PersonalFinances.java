package am.jsl.personalfinances.web.dialect;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Locale;

/**
 * PersonalFinances to niestandardowy obiekt wyrażenia Thymeleaf do celów formatowania daty i godziny.
 */
public final class PersonalFinances {
    /**
     * Narzędzia formatujące.
     */
    private PersonalFinancesFormattingUtils formattingUtils;

    /**
     * Tworzy nowe PersonalFinances z podanymi ustawieniami regionalnymi i strefą czasową.
     * @param locale Ustawienia regionalne
     */
    public PersonalFinances(final Locale locale) {
        super();
        this.formattingUtils = new PersonalFinancesFormattingUtils(locale);
    }

    /**
     * Wywoływany przez silnik Thymeleaf do formatowania podanej daty.
     * @param date Data
     * @return ciąg reprezentujący sformatowaną datę
     */
    public String prettyDate(final Date date) {
        return formattingUtils.prettyDate(date);
    }

    /**
     * Wywoływana przez silnik Thymeleaf w celu sformatowania podanego znacznika czasu.
     * @param timestamp znacznik czasu do sformatowania
     * @return ciąg reprezentujący sformatowany znacznik czasu
     */
    public String prettyTime(final Timestamp timestamp) {
        return formattingUtils.prettyTime(timestamp);
    }
}
