package lk.ijse.easy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration // Marks this class as a configuration class for Spring
@EnableTransactionManagement // Enables annotation-based transaction management
@EnableJpaRepositories(basePackages = {"lk.ijse.easy.repo"}) // Enables Spring Data JPA repositories
@PropertySource("classpath:application.properties") // Loads properties from application.properties
public class JPAConfig {

    @Autowired
    private Environment env; // Used to read property values from application.properties

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds, JpaVendorAdapter va){
        // Configures the EntityManagerFactory bean
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan(env.getRequiredProperty("pro.entity")); // Package to scan for entity classes
        factoryBean.setDataSource(ds); // Sets the data source
        factoryBean.setJpaVendorAdapter(va); // Sets the JPA vendor adapter (Hibernate)
        return factoryBean;
    }

    @Bean
    public DataSource dataSource(){
        // Configures the DataSource bean using properties from the file
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("pro.driver")); // JDBC driver class
        dataSource.setUrl(env.getRequiredProperty("pro.url")); // JDBC URL
        dataSource.setUsername(env.getRequiredProperty("pro.username")); // DB username
        dataSource.setPassword(env.getRequiredProperty("pro.password")); // DB password
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        // Configures the JPA vendor adapter for Hibernate
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabasePlatform(env.getRequiredProperty("pro.dial")); // Hibernate dialect
        jpaVendorAdapter.setDatabase(Database.MYSQL); // Database type (MySQL)
        jpaVendorAdapter.setGenerateDdl(true); // Generate DDL automatically
        jpaVendorAdapter.setShowSql(true); // Show SQL statements in console
        return jpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        // Configures the transaction manager using JPA
        return new JpaTransactionManager(entityManagerFactory);
    }
}
