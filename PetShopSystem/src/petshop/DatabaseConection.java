/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petshop;

/**
 *
 * @author ywani
 */
import java.sql.*;

public class DatabaseConection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/petpawshop";
    private static final String USER = "root";
    private static final String PASSWORD = "#Dell123";
    private Connection conn;
    
    public DatabaseConection(){
        
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully");
        } catch (SQLException e) {
            System.err.println("Database connection failed!");
        }
    }
    
    public Connection getConncetion(){
        return conn;
    }
    
    public void closeConnection(){
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing database connection.");
        }
    }
}

