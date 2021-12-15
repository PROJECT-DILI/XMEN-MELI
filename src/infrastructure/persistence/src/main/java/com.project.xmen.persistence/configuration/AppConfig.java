package com.project.xmen.persistence.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String pass;
    /*@Bean
    public RdsInstanceConfigurer instanceConfigurer() {
        return ()-> {
            TomcatJdbcDataSourceFactory dataSourceFactory =
                    new TomcatJdbcDataSourceFactory();
            dataSourceFactory.setInitialSize(10);
            dataSourceFactory.setValidationQuery("SELECT 1 FROM DUAL");
            return dataSourceFactory;
        };
    }*/

    private JdbcTemplate jdbcTemplate;

    @Bean(name = "dataSource")
    public DataSource dataSource(){
        /*return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.Mysql)
                .addScript("classpath:schema.sql").build();*/
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(user);
        dataSourceBuilder.password(pass);
        return dataSourceBuilder.build();
    }

    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(this.dataSource());
    }

    public void SpringJdbcRepository() {
        this.jdbcTemplate = this.jdbcTemplate();
    }
}
