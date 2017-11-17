package com.springboot.mybatisConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * Created by xiaohong on 2017/11/14.
 */
@Configuration
public class DataSourceConfig implements TransactionManagementConfigurer {

    @Bean("dataSource1")
    @Qualifier("dataSource1")
    //必须要有一个主数据源，用 @Primary 标志该 Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource1")
    public DataSource createDataSource1(){
        return DataSourceBuilder.create().build();
    }

    @Bean("dataSource2")
    @Qualifier("dataSource2")
    @ConfigurationProperties(prefix = "datasource2")
    public DataSource createDataSource2(){
        return DataSourceBuilder.create().build();
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        DataSourceTransactionManager dtm1 = new DataSourceTransactionManager(createDataSource1());
        DataSourceTransactionManager dtm2 = new DataSourceTransactionManager(createDataSource2());
        ChainedTransactionManager ctm = new ChainedTransactionManager(dtm1, dtm2);
        return ctm;
    }
}
