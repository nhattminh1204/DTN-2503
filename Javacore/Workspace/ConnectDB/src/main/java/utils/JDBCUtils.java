package utils;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private Connection connection;
    public static Connection getConnection() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("D:\\DTN 2503\\Javacore\\Workspace\\ConnectDB\\src\\main\\resources\\database.properties"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void disconnect() throws SQLException {
        if (connection != null && connection.isClosed()) {
            connection.close();
        }
    }
}
