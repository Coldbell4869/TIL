package soundsystem;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class DataSourceConfig {
    @Value( "${jdbcUrl}" )
    private String jdbcUrl;
    @Value( "${driverClassName}" )
    private String driverClassName;
    @Value( "${username}" )
    private String username;
    @Value( "${password}" )
    private String password;

    @Bean
    public HikariConfig hikariConfig(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(jdbcUrl);
        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        return hikariConfig;
    }

    @Bean
    public DataSource dataSource(HikariConfig hikariConfig){
        return new HikariDataSource(hikariConfig);
    }

}
