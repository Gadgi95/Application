package com.example.Application;

import com.example.Application.controller.DatabaseController;
import com.example.Application.repository.datajpa.DataJpaMaterialRepository;

import java.io.IOException;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        DatabaseController databaseController = new DatabaseController();
        databaseController.insertTask();
        databaseController.geTasks();
    }
}
