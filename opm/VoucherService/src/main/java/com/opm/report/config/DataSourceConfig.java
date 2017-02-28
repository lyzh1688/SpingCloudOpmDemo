package com.opm.report.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by kfzx-liuyz1 on 2016/11/4.
 */
@Configuration
public class DataSourceConfig {

    @Bean(name="secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix="datasource.secondary")
    public DataSource secondaryDataSource() {
        System.out.println("-------------------- secondaryDataSource init ---------------------");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
