//package com.example.readxml;
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("com.teradata.jdbc.TeraDriver");
//        dataSourceBuilder.url("jdbc:teradata://sdt48259.labs.teradata.com/database=tacdb");
//        dataSourceBuilder.username("dbc");
//        dataSourceBuilder.password("dbc");
//        return dataSourceBuilder.build();
//    }
//}