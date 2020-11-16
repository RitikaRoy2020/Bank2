package com.Areteans.Bank2.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class PostgresManager {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "12345");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Error connecting to database");
            }
        }
        return connection;
    }
}
