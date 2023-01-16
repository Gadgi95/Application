package com.example.Application.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseController {

    private Connection connection;
    private String url;
    private String username;
    private String password;

    public DatabaseController() throws IOException {
        Properties prop = new Properties();
        InputStream input = DatabaseController.class.getClassLoader().getResourceAsStream("application.properties");
        prop.load(input);
        this.url = prop.getProperty("spring.datasource.url");
        this.username = prop.getProperty("spring.datasource.username");
        this.password = prop.getProperty("spring.datasource.password");
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public void disconnect() throws SQLException {
        connection.close();
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    public int executeUpdate(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(sql);
    }
}