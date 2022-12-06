package am.jsl.personalfinances.dao.reminder;

import am.jsl.personalfinances.dao.BaseDao;
import am.jsl.personalfinances.domain.reminder.Reminder;
import am.jsl.personalfinances.dto.reminder.ReminderDetailsDTO;
import am.jsl.personalfinances.dto.reminder.ReminderListDTO;
import am.jsl.personalfinances.search.ListPaginatedResult;
import am.jsl.personalfinances.search.reminder.ReminderSearchQuery;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Interfejs Dao do uzyskiwania dostępu {@link Reminder} obiekt domeny.
 */
public interface ReminderDao extends BaseDao<Reminder> {
    /**
     * Pobiera wynik podzielony na strony dla danego zapytania.
     * @param searchQuery the {@link ReminderSearchQuery} Zawieranie opcji kwerendy
     * @return the {@link ListPaginatedResult} zawierające wynik stronicowany
     */
    ListPaginatedResult<ReminderListDTO> search(ReminderSearchQuery searchQuery);

    /**
     * Zwraca szczegóły przypomnienia z podanym identyfikatorem i identyfikatorem użytkownika.
     * @param id Identyfikator przypomnienia
     * @param userId identyfikator użytkownika
     * @return Szczegóły przypomnienia
     */
    ReminderDetailsDTO getDetails(long id, long userId);

    /**
     *  Zwraca przypomnienia o należnych przypomnieniach dla podanego identyfikatora użytkownika.
     * @param userId identyfikator użytkownika
     * @return Lista należnych upomnień
     */
    List<ReminderListDTO> getDueReminders(long userId);

    /**
     * Aktualizuje podaną datę ukończenia danego przypomnienia.
     * @param id Identyfikator przypomnienia
     * @param dueDate termin płatności
     */
    void updateReminderDue(long id, LocalDateTime dueDate);

    /**
     * Tworzy mapowanie przypomnień / transakcji z podanym identyfikatorem przypomnienia i identyfikatorem transakcji.
     * @param reminderId Identyfikator przypomnienia
     * @param transactionId identyfikator transakcji
     */
    void createReminderTransaction(long reminderId, long transactionId);
}
