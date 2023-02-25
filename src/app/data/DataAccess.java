package app.data;

import java.sql.*;

public class DataAccess {

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/coffee_bar_managment",
                "root",
                "AbbeyRoad69"
        );
    }


}
