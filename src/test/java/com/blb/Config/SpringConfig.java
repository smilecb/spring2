package com.blb.Config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan("com.blb")
@PropertySource("jdbc.properties")
public class SpringConfig {
    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${user}")
    private String name;
    @Value("${psaaword}")
    private String password;

    @Bean("jdbcData")
    public DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/one?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUser("root");
        dataSource.setPassword("199866");
        return dataSource;
    }
    @Bean("jdbcData1")
    public DataSource getDataSource1() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(name);
        dataSource.setPassword(password);
        return dataSource;
    }
}
