package am.jsl.personalfinances.service.reminder;

import am.jsl.personalfinances.log.AppLogger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Proste zadanie Quartz, które okresowo przetwarza wygasłe przypomnienia.
 */
@Component
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@Qualifier("reminderJob")
public class ReminderJob extends QuartzJobBean {
    private static final AppLogger log = new AppLogger(ReminderJob.class);

    /**
     * Usługa przypomnienia
     */
    private transient ReminderService reminderService;

    /**
     * Wykonuje rzeczywiste zadanie z podanym pakietem kontekstu.
     * @param context the JobExecutionContext
     * @throws JobExecutionException jeśli wystąpi błąd
     */
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        try {
            SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

            reminderService.processDueReminders();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Ustawia usługę przypomnienia
     * @param reminderService the {@link ReminderService}
     */
    public void setReminderService(ReminderService reminderService) {
        this.reminderService = reminderService;
    }
}
