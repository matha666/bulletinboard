package com.example.bulletinboard.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.bulletinboard.mapper.Content", sqlSessionFactoryRef = "contentSqlSessionFactory")
public class DataSource2Config {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.content")
    public DataSourceProperties dataSource2Properties() {
        return new DataSourceProperties();
    }

    @Bean(name = "contentDataSource")
    public DataSource dataSource(@Qualifier("dataSource2Properties") DataSourceProperties dataSource2Properties) {
        return dataSource2Properties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "contentSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("contentDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
    }
}

