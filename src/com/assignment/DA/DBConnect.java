package com.assignment.DA;

import org.mariadb.jdbc.MariaDbConnection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static MariaDbConnection connection;
    private static final String dbAddress = "jdbc:mariadb://localhost:3306/assWEBENT?user=bak&password=password";

    public static MariaDbConnection getConnection(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = (MariaDbConnection) DriverManager.getConnection(dbAddress);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(DBConnect.getConnection().toString());
    }
}
