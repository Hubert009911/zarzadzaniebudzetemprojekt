package am.jsl.personalfinances.web.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Przykładowy konwerter LocalDateTime używany w kontekście Spring .
 */
public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {
    public LocalDateTime convert(String source) {
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        return LocalDateTime.parse(source, formatter);
    }
}