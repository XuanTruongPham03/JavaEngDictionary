package Dija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionBase {
    protected Connection connection;

    public Connection getConnection() {
        return connection;
    }
    
    public MySqlConnectionBase() {
        // Khởi tạo kết nối đến cơ sở dữ liệu MySQL
        String url = "jdbc:mysql://localhost/javaengdictionary";
        String user = "root";
        String password = "";

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Đảm bảo đóng kết nối khi cần thiết
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