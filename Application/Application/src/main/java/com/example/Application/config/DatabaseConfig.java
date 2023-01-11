package com.example.Application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://gadgi95.beget.tech:3306/gadgi95_applicat?autoReconnect=true&useSSL=false");
    dataSource.setUsername("gadgi95_applicat");
    dataSource.setPassword("Qwerty!23");
    return dataSource;
  }
}