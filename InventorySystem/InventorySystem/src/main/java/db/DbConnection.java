package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    static String dbUrl = "jdbc:mysql://localhost:3306/inventory";
    static String dbUser = "root";
    static String dbPassword = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }
}
