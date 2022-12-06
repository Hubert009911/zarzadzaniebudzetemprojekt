package am.jsl.personalfinances.service;

import am.jsl.personalfinances.log.AppLogger;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Wdrożenie usługi {@link ErrorTrackerService}.
 */
@Service
public class ErrorTrackerServiceImpl implements ErrorTrackerService {

    protected static final AppLogger log = new AppLogger(ErrorTrackerServiceImpl.class);

    private static final String DEFAULT_SUBJECT = "Error Tracker";

    @Value("${personalfinances.error_tracker.send.email}")
    private boolean sendEmail;

    @Value("${personalfinances.error_tracker.email}")
    private String trackerEmail;

    @Value("${personalfinances.error_tracker.duplicate.errors.send.interval}")
    private Long duplicatesSendInterval;

    private Map<Integer, LocalDateTime> exceptionCache = new ConcurrentHashMap<>();

    /**
     * Usługa poczty e-mail.
     */
    @Autowired
    private EmailService emailService;

    @Override
    public void sendError(Exception e) {
        if (!sendEmail) {
            log.info("Email send is disabled for error tracker");
            return;
        }

        try {
            LocalDateTime now = LocalDateTime.now();

            // Usuwanie starych wyjątków
            exceptionCache.entrySet().removeIf(entry-> entry.getValue()
                    .plusHours(duplicatesSendInterval).isBefore(now));

            // Sprawdź zduplikowane wyjątki
            String stacktrace = ExceptionUtils.getStackTrace(e);
            int key = stacktrace.hashCode();

            LocalDateTime localDateTime = exceptionCache.get(key);

            if (localDateTime != null) {
                if (!localDateTime.isBefore(now.minusHours(duplicatesSendInterval))) {
                    log.info("Ignored duplicate exception");
                    return;
                }
            }

            exceptionCache.put(key, now);

            // Wyślij szczegóły wyjątku
            StringBuilder emailText = new StringBuilder();

            if (e.getMessage() != null) {
                emailText.append(e.getMessage()).append("\n");
            }
            emailText.append(stacktrace);

            ExecutorService emailExecutor = Executors.newSingleThreadExecutor();
            emailExecutor.execute(() -> {
                try {
                    emailService.sendEmail(trackerEmail, DEFAULT_SUBJECT, emailText.toString());
                } catch (MessagingException e1) {
                    log.error(e1.getMessage(), e1);
                }
            });
            emailExecutor.shutdown();

        } catch (Exception e1) {
            log.error(e1.getMessage(), e1);
        }
    }
}
