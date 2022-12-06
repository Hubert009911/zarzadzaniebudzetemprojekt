package am.jsl.personalfinances.web.dialect;

import org.ocpsoft.prettytime.PrettyTime;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Locale;

/**
 * Formatowanie daty i godziny używane przez Thymeleaf, które używa {@link PrettyTime} biblioteka.
 */
public class PersonalFinancesFormattingUtils {
    private final PrettyTime prettyTime;

    /**
     * Konstruuje nowy PersonalFinancesFormattingUtils dla danej lokalizacji.
     * @param locale the locale
     */
    public PersonalFinancesFormattingUtils(final Locale locale) {
        super();
        this.prettyTime = new PrettyTime(locale);
    }

    /**
     * Formatuje podaną datę za pomocą {@link PrettyTime} biblioteka.
     * @param date Data
     * @return ciąg reprezentujący sformatowaną datę
     */
    public String prettyDate(final Date date) {
        return prettyTime.format(date);
    }

    /**
     * Formatuje podaną sygnaturę czasową za pomocą {@link PrettyTime} biblioteka
     * @param timestamp sygnatura czasowa
     * @return Ciąg reprezentujący sformatowaną sygnaturę czasową
     */
    public String prettyTime(final Timestamp timestamp) {
        return prettyTime.format(timestamp);
    }
}
