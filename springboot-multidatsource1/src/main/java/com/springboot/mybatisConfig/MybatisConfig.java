package com.springboot.mybatisConfig;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by xiaohong on 2017/11/14.
 */
@Configuration
@Import({JdbcConfig.class,JdbcConfig2.class})
@EnableTransactionManagement
public class MybatisConfig {
    private final static Logger logger = LoggerFactory.getLogger(MybatisConfig.class);

    @Resource
    private JdbcConfig jdbcConfig;

    @Resource
    private JdbcConfig2 jdbcConfig2;

    /**
     * 配置dataSource，使用Hikari连接池
     */
    @Bean(destroyMethod = "close")
    @Primary
    public DataSource dataSource1(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(jdbcConfig.getDriverClassName());
        config.setJdbcUrl(jdbcConfig.getUrl());
        config.setUsername(jdbcConfig.getUserName());
        config.setPassword(jdbcConfig.getPassword());
        HikariDataSource ds = new HikariDataSource(config);
        return ds;
    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource2(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(jdbcConfig2.getDriverClassName());
        config.setJdbcUrl(jdbcConfig2.getUrl());
        config.setUsername(jdbcConfig2.getUserName());
        config.setPassword(jdbcConfig2.getPassword());
        HikariDataSource ds = new HikariDataSource(config);
        return ds;
    }

    /**
     * 配置SqlSessionFactory：
     * - 创建SqlSessionFactoryBean，并指定一个dataSource；
     * - 设置这个分页插件：https://github.com/pagehelper/Mybatis-PageHelper；
     * - 指定mapper文件的路径；
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory1() {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource1());
        try {
            //指定mapper xml目录
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory2() {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource2());

        try {
            //指定mapper xml目录
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
