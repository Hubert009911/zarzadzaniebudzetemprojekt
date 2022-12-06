package am.jsl.personalfinances.service.reminder;

import am.jsl.personalfinances.domain.reminder.Reminder;
import am.jsl.personalfinances.dto.reminder.ReminderDetailsDTO;
import am.jsl.personalfinances.dto.reminder.ReminderListDTO;
import am.jsl.personalfinances.search.ListPaginatedResult;
import am.jsl.personalfinances.search.reminder.ReminderSearchQuery;
import am.jsl.personalfinances.service.BaseService;

import java.time.LocalDateTime;

/**
 * Interfejs usługi, który definiuje wszystkie metody pracy {@link Reminder}
 */
public interface ReminderService extends BaseService<Reminder> {
    /**
     * Pobiera wyniki podzielone na strony dla podanego zapytania wyszukiwania.
     * @param searchQuery zawierające opcje zapytania {@link ReminderSearchQuery}
     * @return the {@link ListPaginatedResult} zawierający stronicowany wynik
     */
    ListPaginatedResult<ReminderListDTO> search(ReminderSearchQuery searchQuery);

    /**
     * Zwraca szczegóły przypomnienia z podanym identyfikatorem i identyfikatorem użytkownika.
     * @param id identyfikator przypomnienia
     * @param userId identyfikator użytkownika
     * @return szczegóły przypomnienia
     */
    ReminderDetailsDTO getDetails(long id, long userId);

    /**
     * Zwraca następny termin dla podanej daty przypomnienia i opcję powtórzenia.
     * @param reminderDate datę przypomnienia
     * @param repeat the {@link am.jsl.personalfinances.domain.reminder.ReminderRepeat} option
     * @return następny termin
     */
    LocalDateTime getDueDate(LocalDateTime reminderDate, byte repeat);

    /**
     * Przetwarza przypomnienia z wygasłymi terminami.
     * Wybiera wygasłe przypomnienia dla wszystkich aktywnych użytkowników i
     * generuje reprezentację html terminowych przypomnień w folderach użytkownika.
     * Odpowiednia transakcja zostanie wygenerowana na podstawie konfiguracji przypomnienia.
     */
    void processDueReminders();
}
