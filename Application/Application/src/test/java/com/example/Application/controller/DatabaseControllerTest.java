package com.example.Application.controller;

import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import com.example.Application.controller.DatabaseController;

@Component
@TestPropertySource(locations = "classpath:application-context.xml")
public class DatabaseControllerTest {
    Connection connection;

    @Resource(name = "testDataSource")
    private DataSource dataSource;

    public void connect() throws SQLException {
        connection = dataSource.getConnection();
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
