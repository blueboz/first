package cn.boz.springboot.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@Configuration
@EnableConfigurationProperties(BozConfig.class)
public class SpringConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource1")
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.orclds")
    public DataSource oracleDataSource(){
        return DataSourceBuilder.create().build();
    }

   /* @Bean
    public DataSource druidDataSource(){

        return null;
    }*/

}
