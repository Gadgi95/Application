package com.gadgi95.File.Manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.Objects;
import org.springframework.web.multipart.MultipartFile;

public class FileManager {

  private static final String UPLOAD_DIRECTORY = "./directory";
  private static final String DOWNLOAD_DIRECTORY = "./directory";

  public static void main(String[] args) {
    explore();
  }

  private static void explore() {
    // explore the directory and print the names of files and directories
    File root = new File("./directory");
    explore(root);
  }

  private static void explore(File file) {
    if (file.isDirectory()) {
      System.out.println("Exploring directory: " + file.getName());
      for (File child : Objects.requireNonNull(file.listFiles())) {
        explore(child);
      }
    } else {
      System.out.println("Found file: " + file.getName());
    }
  }

  public static void uploadFile(MultipartFile file) {
    try {
      byte[] bytes = file.getBytes();
      Path path = Paths.get(UPLOAD_DIRECTORY + file.getOriginalFilename());
      Files.write(path, bytes);
      // insert metadata into database
      insertFileData(file.getOriginalFilename());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void insertFileData(String fileName) {
    try (Connection conn = getConnection();
        PreparedStatement insertStmt = conn.prepareStatement(
            "INSERT INTO files(name) VALUES (?)")) {
      insertStmt.setString(1, fileName);
      insertStmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static List<String> searchByName(String name) {
    List<String> fileNames = new ArrayList<>();
    try (Connection conn = getConnection();
        PreparedStatement selectStmt = conn.prepareStatement(
            "SELECT name FROM files WHERE name like ?")) {
      selectStmt.setString(1, "%" + name + "%");
      try (ResultSet resultSet = selectStmt.executeQuery()) {
        while (resultSet.next()) {
          fileNames.add(resultSet.getString(1));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return fileNames;
  }

  public static List<String> searchByContent(String content) {
    List<String> fileNames = new ArrayList<>();
    try (Connection conn = getConnection();
        PreparedStatement selectStmt = conn.prepareStatement(
            "SELECT name FROM files f JOIN file_contents c ON f.id = c.file_id WHERE c.content like ?")) {
      selectStmt.setString(1, "%" + content + "%");
      try (ResultSet resultSet = selectStmt.executeQuery()) {
        while (resultSet.next()) {
          fileNames.add(resultSet.getString(1));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return fileNames;
  }

  public static void downloadFile(String fileName) {
    try (InputStream is = new FileInputStream(new File(UPLOAD_DIRECTORY + fileName));
        OutputStream os = new FileOutputStream(new File(DOWNLOAD_DIRECTORY + fileName))) {
      byte[] buffer = new byte[1024];
      int length;
      while ((length = is.read(buffer)) > 0) {
        os.write(buffer, 0, length);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void deleteFile(String fileName) {
    try (Connection conn = getConnection();
        PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM files WHERE name = ?")) {
      deleteStmt.setString(1, fileName);
      deleteStmt.executeUpdate();
      // delete the file
      Path path = Paths.get(UPLOAD_DIRECTORY + fileName);
      Files.delete(path);
    } catch (SQLException | IOException e) {
      e.printStackTrace();
    }
  }

  private static Connection getConnection() throws SQLException {
    DataBaseConnector connector = new DataBaseConnector();
    return (Connection) connector;


    //TODO: return your connection
    // i.e
    // return DriverManager.getConnection(url, username, password);
  }
}

  /*This code uses Spring's `MultipartFile` to handle file uploads, and uses a database
  (in this case MySQL) to store metadata about the uploaded files. You can use the
  `insertFileData` method to insert metadata such as the file name into the database.
  The `searchByName` method performs a search for files by name, and the `searchByContent`
  method searches for files by content (but only for .txt files) .
  `downloadFile` method allows to download the file from the server to the user's device and
  `deleteFile` allows to delete the file.

  Please note that this code is just an example and will require additional work to integrate with
  your specific application, such as configuring the database connection and handling
  transactions and security. Additionally, you need to make sure that the upload and download
  directories have the right permissions so that the application can read and write to them.

   */