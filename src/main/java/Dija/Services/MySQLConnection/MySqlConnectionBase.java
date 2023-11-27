package Dija.Services.MySQLConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionBase {
    protected Connection connection;

    private final String url = "jdbc:mysql://localhost/javaengdictionary";
    private final String user = "root";
    private final String password = "";

    public Connection getConnection() {
        return connection;
    }
    
    public MySqlConnectionBase() {
        // Init configuration
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Make sure connection was closed
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}