package app.data;

import java.sql.*;

public class DataAccess {

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306",
                "root",
                "AbbeyRoad69"
        );

        return connection;
    }
}
