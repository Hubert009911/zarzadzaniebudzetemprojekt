package am.jsl.personalfinances.config;

import am.jsl.personalfinances.service.databasedump.DatabaseDumpJob;
import am.jsl.personalfinances.service.databasedump.DatabaseDumpService;
import am.jsl.personalfinances.service.reminder.ReminderJob;
import am.jsl.personalfinances.service.reminder.ReminderService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;
import java.util.Map;

/**
 * Konfiguracja root zarządzana przez Spring.
 * Konfiguruje zadania aplikacji i PropertySourcesPlaceholderConfigurer.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"am.jsl.personalfinances"})
public class RootConfig {
    /**
     * Wyrażenie Cron dla zadania zrzutu bazy danych.
     */
    @Value("${personalfinances.db.export.cronExpression}")
    private String dbDumpCronExp;

    /**
     * Wyrażenie Cron do zadania przetwarzania przypomnień.
     */
    @Value("${personalfinances.reminder.cronExpression}")
    private String reminderCronExp;

    /**
     * Usługa zrzutu bazy danych.
     */
    @Autowired
    @Qualifier("databaseDumpService")
    private DatabaseDumpService databaseDumpService;

    /**
     * Usługa przypomnień.
     */
    @Autowired
    @Qualifier("reminderService")
    private ReminderService reminderService;

    /**
     * Tworzy Quartz {@link JobDetail} instancja do wykonywania zadania zrzutu bazy danych.
     * @return JobDetail
     */
    @Bean
    public JobDetail databaseDumpJobDetail() {
        // pass databaseDumpService
        Map<String, Object> jobDataAsMap = new HashMap<>();
        jobDataAsMap.put("databaseDumpService", databaseDumpService);

        return JobBuilder.newJob(DatabaseDumpJob.class).withIdentity("databaseDumpJob")
                .setJobData(new JobDataMap(jobDataAsMap)).storeDurably().build();
    }

    /**
     *  Tworzy za pomocą Quartz {@link Trigger} instancja do planowania databaseDumpJob.
     * @return Trigger
     */
    @Bean
    public Trigger databaseDumpJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(3000).repeatForever();

        return TriggerBuilder.newTrigger().forJob(databaseDumpJobDetail())
                .withIdentity("databaseDumpJobTrigger").withSchedule(scheduleBuilder).build();
    }

    /**
     * Tworzy Quartz {@link JobDetail} Instancja do wykonania zadania przetwarzania przypomnień.
     * @return JobDetail
     */
    @Bean
    public JobDetail reminderJobDetail() {
        // pass reminderService
        Map<String, Object> jobDataAsMap = new HashMap<>();
        jobDataAsMap.put("reminderService", reminderService);

        return JobBuilder.newJob(ReminderJob.class).withIdentity("reminderJob")
                .setJobData(new JobDataMap(jobDataAsMap)).storeDurably().build();
    }

    /**
     * Tworzy z Quartz {@link Trigger} instancja do planowania planowania przypomnieniaJob.
     * @return Trigger
     */
    @Bean
    public Trigger reminderJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(3000).repeatForever();

        return TriggerBuilder.newTrigger().forJob(reminderJobDetail())
                .withIdentity("reminderJobTrigger").withSchedule(scheduleBuilder).build();
    }

    /**
     * Tworzy Springs {@link PropertySourcesPlaceholderConfigurer} do rozwiązywania symboli zastępczych ${...}
     * wewnątrz Spring bean definitions.
     *
     * @return PropertySourcesPlaceholderConfigurer
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}