package com.ass.DA;

import com.mysql.jdbc.MySQLConnection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static MySQLConnection connection;
    private static final String dbAddress = "jdbc:mysql://localhost:3306/assWEBENT?user=root&password=rambo";

    public static MySQLConnection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (MySQLConnection) DriverManager.getConnection(dbAddress);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(DBConnect.getConnection().isClosed());
    }
}
