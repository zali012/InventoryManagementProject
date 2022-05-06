package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    static String dbUrl = "jdbc:mysql://localhost:3306/inventory?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String dbUser = "root";
    static String dbPassword = "root";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }
}
