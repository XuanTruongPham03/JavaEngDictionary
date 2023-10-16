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
    // Export dữ liệu ra TXT
  }

  public void exportToXLSX(String filePath) {
    // Export dữ liệu ra Excel 
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