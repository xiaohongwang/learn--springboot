package com.springboot.mybatisConfig;
import com.springboot.annotation.Test2Repository;
import com.springboot.annotation.TestRepository;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xiaohong on 2017/11/13.
 */
@Configuration
@AutoConfigureAfter(SqlSessionFactoryConfig.class)
public class MapperScannerConfig {
    private static  final String BASE_PACKAGE = "com.springboot.mapper";
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer1(){
        MapperScannerConfigurer mapperScanner = new MapperScannerConfigurer();
        mapperScanner.setBasePackage(BASE_PACKAGE);
        mapperScanner.setSqlSessionFactoryBeanName("sqlSessionFactory1");
        mapperScanner.setAnnotationClass(TestRepository.class);
        return mapperScanner;
    }

    @Bean
    public MapperScannerConfigurer createMapperScanner2(){
        MapperScannerConfigurer mapperScanner = new MapperScannerConfigurer();
        mapperScanner.setBasePackage(BASE_PACKAGE);
        mapperScanner.setSqlSessionFactoryBeanName("sqlSessionFactory2");
        mapperScanner.setAnnotationClass(Test2Repository.class);
        return mapperScanner;
    }
}
