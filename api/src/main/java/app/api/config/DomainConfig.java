package app.api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("app.api.models")
@EnableJpaRepositories("app.api.repositories")
@EnableTransactionManagement
public class DomainConfig {
}
