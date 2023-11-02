package Dija.Services.MySQLConnection;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class ExportFile {

  private MySqlConnectionBase connectionBase;

  public ExportFile() {
    connectionBase = new MySqlConnectionBase();
  }

  public void exportToCSV(String filePath) {
    // Export dữ liệu ra CSV
  }

  public void exportToTXT(String filePath, String dbName) {
    try {
      Connection conn = connectionBase.getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM  " + dbName );

      BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
      while (rs.next()) {
        // các cột của database
        String wordTarget = rs.getString("word_target");
        String wordExplain = rs.getString("word_explain");
        String pronunciation = rs.getString("pronunciation");
        String wordType = rs.getString("word_type");

        // Ghi dữ liệu vào file txt theo định dạng mong muốn
        String line = "Word: " + wordTarget + "\nExplanation: " + wordExplain + "\nPronunciation: " + pronunciation + "\nType: " + wordType + "\n";
        writer.write(line);
        writer.newLine();
      }

      writer.close();
      stmt.close();
    } catch (SQLException | IOException e) {
      e.printStackTrace();
    }
  }



  public void exportToXLSX(String filePath) {
    //  Export dữ liệu ra Excel
  }

  public void exportToSQL(String filePath) {
    // Export dữ liệu ra file SQL

  }

  public void exportFile(String filePath, String dbName, String fileExt) {
    switch(fileExt) {
      case "sql":
        exportToSQL(filePath);
        break;
      case "csv":
        exportToCSV(filePath);
        break;
      case "txt":
        exportToTXT(filePath,dbName);
        break;
      case "xlsx":
        exportToXLSX(filePath);
        break;
      default:
        System.out.println("Invalid file extension");
    }
    System.out.println("Data exported successfully to " + filePath);
  }



}