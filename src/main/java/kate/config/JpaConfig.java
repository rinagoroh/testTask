package kate.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import kate.repo.DepartmentRepo;
import kate.repo.LectorRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackageClasses = {DepartmentRepo.class, LectorRepo.class})
@EnableTransactionManagement
@Configuration
public class JpaConfig {

    /** Entity Manager Factory bean. */
    @Bean(name = "entityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("primary");
    }

    /** Entity Manager bean for cooperation with DB. */
    @Bean(name = "entityManager")
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }

    /** Platform Transaction Manager bean for transaction with DB. */
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }
}
