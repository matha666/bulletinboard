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
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.bulletinboard.mapper.Title", sqlSessionFactoryRef = "titleSqlSessionFactory")
public class DataSource1Config {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.title")
    public DataSourceProperties dataSource1Properties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "titleDataSource")
    public DataSource dataSource(DataSourceProperties dataSource1Properties) {
        DataSource build = dataSource1Properties.initializeDataSourceBuilder().build();
        return build;
    }

    @Primary
    @Bean(name = "titleSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("titleDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
    }
}
