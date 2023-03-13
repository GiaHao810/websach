package com.example.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlServerConnUtils_SQLJDBC {
    // Connect to SQL Server.
    // (Using JDBC Driver: SQLJDBC)
    public static Connection getConnection() throws ClassNotFoundException, Exception {

        // Note: Change the connection parameters accordingly.
        String hostName = "localhost";
        String sqlInstanceName = "";
        String database = "INFO_BOOK";
        String userName = "sa";
        String password = "123456";

        return getConnection(hostName, sqlInstanceName, database, userName, password);
    }

    // Connect to SQLServer, using SQLJDBC Library.
    private static Connection getConnection(String hostName, //
            String sqlInstanceName, String database, String userName, String password)//
            throws ClassNotFoundException, SQLException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        // Example:
        // jdbc:sqlserver://ServerIp:1433/SQLEXPRESS;databaseName=simplehr
        String connectionURL = "jdbc:sqlserver://" + hostName + ":1433" //
                + ";instance=" + sqlInstanceName + ";databaseName=" + database;

        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }

    public static void main(String[] args) {
        
    }

}
