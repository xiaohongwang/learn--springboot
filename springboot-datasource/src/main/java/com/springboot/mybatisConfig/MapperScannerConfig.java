package com.springboot.mybatisConfig;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xiaohong on 2017/11/13.
 */
@Configuration
public class MapperScannerConfig {
    private static  final String BASE_PACKAGE = "com.springboot.mapper";
    @Bean
    public MapperScannerConfigurer createMapperScanner(){
        MapperScannerConfigurer mapperScanner = new MapperScannerConfigurer();
        mapperScanner.setBasePackage(BASE_PACKAGE);
        mapperScanner.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScanner;
    }
}
