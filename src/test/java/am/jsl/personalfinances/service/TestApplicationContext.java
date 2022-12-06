package am.jsl.personalfinances.service;

import am.jsl.personalfinances.config.EhCacheConfig;
import am.jsl.personalfinances.config.SpringMailConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Konfiguracja kontekstu aplikacji sprężynowej do testów junit.
 */
@Configuration
@ComponentScan(basePackages = {"am.jsl.personalfinances.dao", "am.jsl.personalfinances.service"})
@Import({EhCacheConfig.class, SpringMailConfig.class})
@EnableTransactionManagement
@EnableAutoConfiguration
public class TestApplicationContext {

    /**
     * TworzySprings {@link PropertySourcesPlaceholderConfigurer} do rozpoznawania symboli zastępczych ${...}
     * w ramach definicji fasoli jarej.
     *
     * @return the PropertySourcesPlaceholderConfigurer
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * Tworzy {@link PasswordEncoder} poparte przez {@link BCryptPasswordEncoder}.
     *
     * @return the PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
