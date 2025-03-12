package refactor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sportflowdb";
        Connection con = DriverManager.getConnection(url,"root","admin0000");
        return con;
    }
}
