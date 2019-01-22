package soundsystem;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

// 아래 어노테이션 두줄이 꼭 있어야함..ㅠㅠ
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

/*
jdbcUrl=jdbc:mysql://localhost:3306/freeboard?useUnicode=true&characterEncoding=UTF-8
driverClassName=com.mysql.cj.jdbc.Driver
username=boardadmin
password=admin
 */