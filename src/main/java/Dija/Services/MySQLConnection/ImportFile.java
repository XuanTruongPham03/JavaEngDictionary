package Dija.Services.MySQLConnection;

import java.sql.*;
import java.util.Scanner;

public class ImportFile {

  private MySqlConnectionBase connectionBase;

  public ImportFile() {
    this.connectionBase = new MySqlConnectionBase();
  }

  /**
   * Import data from URL.
   *
   * @param url URL to import data from.
   */
  public void importFromUrl(String url) {
    try {
      Connection conn = connectionBase.getConnection();
      Statement stmt = conn.createStatement();
      stmt.execute("SOURCE " + url);
      System.out.println("Imported successfully from URL!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Import data from file.
   *
   * @param filePath File path to import data from.
   */
  public void importFromFile(String filePath) {
    try {
      Connection conn = connectionBase.getConnection();
      Statement stmt = conn.createStatement();
      stmt.execute("SOURCE " + filePath);
      System.out.println("Imported successfully from file!");
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }

  /**
   * Import data from file or URL.
   */
  public void importFile() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter source url/file path: ");
    String source = scanner.nextLine();

    if (source.startsWith("http://") || source.startsWith("https://")) {
      importFromUrl(source);
    } else {
      importFromFile(source); 
    }

    scanner.close();
  }
}
