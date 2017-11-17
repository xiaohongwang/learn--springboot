package com.springboot.mybatisConfig;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by xiaohong on 2017/11/13.
 */
@Configuration
@Import(JdbcConfig.class)
public class DataSourceConfig {
    @Resource
    private JdbcConfig jdbcConfig;

    @Bean("dataSource")
    public DataSource createDataSource(){
        try {
            return (DataSource) DataSourceBuilder.create()
                    .type((Class<? extends DataSource>) Class.forName(jdbcConfig.getType()))
                    .driverClassName(jdbcConfig.getDriverClassName())
                    .url(jdbcConfig.getUrl())
                    .username(jdbcConfig.getUserName())
                    .password(jdbcConfig.getPassword()).build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
