package com.example.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    // private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=INFO_BOOK;"; Hào
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=INFO_BOOK;";
    private static final String USER = "sa";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}