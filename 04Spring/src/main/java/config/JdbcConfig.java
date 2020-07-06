package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUser;
    @Value("${jdbc.password}")
    private String jdbcPassword;


    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(@Qualifier("ds") DataSource datasource){
        return new QueryRunner(datasource);
    }

    @Bean(name = "ds")
    public DataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setDriverClass(jdbcDriver);
        source.setJdbcUrl(jdbcUrl);
        source.setUser(jdbcUser);
        source.setPassword(jdbcPassword);
        return source;
    }

    @Bean(name = "ds2")
    public DataSource createDataSource2() throws PropertyVetoException {
        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setDriverClass(jdbcDriver);
        source.setJdbcUrl(jdbcUrl);
        source.setUser(jdbcUser);
        source.setPassword(jdbcPassword);
        return source;
    }
}
