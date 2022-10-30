package ru.geekbrains.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {


    public static final String USER_NAME = "usermanager";
    public static final String PASSWORD = "123456";
    public static final String URL = "jdbc:mysql://localhost:3306/ideabaze";
    public static Statement statement;
    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        } catch (SQLException throwable){
            throwable.printStackTrace();
            throw new RuntimeException();
        }
    }

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException throwable){
            throwable.printStackTrace();
            throw new RuntimeException();
        }
    }
    
}
