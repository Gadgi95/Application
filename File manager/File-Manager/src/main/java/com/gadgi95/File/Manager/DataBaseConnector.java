package com.gadgi95.File.Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {

  private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  private static final String DB_URL = "jdbc:mysql://host:port/dbname";
  private static final String USER = "username";
  private static final String PASS = "password";

  private static Connection getConnection() throws SQLException {
    try {
      Class.forName(JDBC_DRIVER);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return DriverManager.getConnection(DB_URL, USER, PASS);
  }

}
