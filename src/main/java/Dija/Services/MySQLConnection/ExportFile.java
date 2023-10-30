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

  public void exportToTXT(String filePath) {
    try {
      Connection conn = connectionBase.getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM dictionary"); // Tên bảng

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
      System.out.println("Data exported successfully to " + filePath);
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

  public void exportFile() {
    Scanner scanner = new Scanner(System.in);  

    System.out.print("Enter folder path: ");
    String folderPath = scanner.nextLine();

    System.out.print("Enter file extension (sql, csv, txt, xlsx): ");
    String fileExt = scanner.nextLine();

    System.out.print("Enter database name: ");
    String dbName = scanner.nextLine(); 
    String fileName = dbName + "." + fileExt;
    String filePath = folderPath + "\\" + fileName;

    switch(fileExt) {
      case "sql":
        exportToSQL(filePath);
        break;
      case "csv":
        exportToCSV(filePath);
        break;
      case "txt":
        exportToTXT(filePath);
        break;
      case "xlsx":
        exportToXLSX(filePath);
        break;
      default:
        System.out.println("Invalid file extension");
    }

    scanner.close();
  }

}