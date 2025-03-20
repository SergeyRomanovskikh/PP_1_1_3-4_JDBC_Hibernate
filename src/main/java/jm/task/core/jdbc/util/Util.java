package jm.task.core.jdbc.util;
import java.sql.*;

public class Util {
    private final static String URL = "jdbc:mysql://localhost:3306/kata_task1";
    private final static String URLFIXED =
            "jdbc:mysql://localhost:3306/kata_task1?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
                    "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    private Connection connection;

    public Util() {
        try {
            connection = DriverManager.getConnection(URLFIXED, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());;
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
