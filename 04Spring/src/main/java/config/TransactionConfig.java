package config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

public class TransactionConfig {
    @Bean(name = "transactionManager")
    public PlatformTransactionManager createTransactionManager(DataSource ds){
        return new DataSourceTransactionManager(ds);
    }
}
