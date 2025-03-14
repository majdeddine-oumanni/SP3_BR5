package refactor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection con = null;
        String URL = "jdbc:mysql://127.0.0.1:3306/sportflowdb";
        String USER = "root";
        String PASSWORD = "admin0000";
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        return con;
    }
}
