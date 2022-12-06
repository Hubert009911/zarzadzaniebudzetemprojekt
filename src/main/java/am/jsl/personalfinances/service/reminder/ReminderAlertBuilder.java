package am.jsl.personalfinances.service.reminder;

import am.jsl.personalfinances.dto.reminder.ReminderListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;

/**
 * Klasa Helper, która używa Thymeleaf's {@link TemplateEngine} do generowania przypomnień HTML.
 */
@Service
public class ReminderAlertBuilder {
    /**
     * Instancja Thymeleaf's {@link TemplateEngine}
     */
    private TemplateEngine templateEngine;

    /**
     * Konstruuje nowy ReminderAlertBuilder z podanym TemplateEngine
     * @param templateEngine the TemplateEngine
     */
    @Autowired
    public ReminderAlertBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    /**
     * Generuje html z podanej listy przypomnień i zwraca tekst html.
     * @param reminders listę do przypomnień
     * @return tekst html wygenerowanej listy przypomnień
     */
    public String build(List<ReminderListDTO> reminders) {
        Context context = new Context();
        context.setVariable("reminders", reminders);
        return templateEngine.process("reminder/reminder-alert-template", context);
    }
}
