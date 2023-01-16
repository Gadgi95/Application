package com.example.Application;

import java.io.IOException;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        DatabaseController databaseController = new DatabaseController();
        databaseController.insertTask();
        databaseController.geTasks();
    }
}
