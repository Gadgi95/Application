package com.example.Application;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
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

    public void insertTask() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection(url, username, password);
        PreparedStatement prSt = connection.prepareStatement("INSERT INTO User (name, mail, ROLE) VALUES ('John Doe', 'johndoe@example.com', 'admin')");
        prSt.executeUpdate();
    }

    public ArrayList<String> geTasks() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM User";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<String> tasks = new ArrayList<>();
        while (resultSet.next()) {
            tasks.add(resultSet.getString("Name"));
        }
        System.out.println(tasks);
        return tasks;
    }
}
