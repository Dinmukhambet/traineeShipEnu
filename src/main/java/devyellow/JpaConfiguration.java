package devyellow;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Admin on 21.03.2017.
 */
@Configuration
@EnableJpaRepositories(basePackages = "devyellow.repositories")
@EnableTransactionManagement
public class JpaConfiguration {
}
