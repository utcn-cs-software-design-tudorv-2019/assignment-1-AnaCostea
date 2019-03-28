package DataAccess;

import java.sql.*;

public class DataAccess {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/user";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private DataAccess() {}

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void close (Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void close (Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void close (ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
