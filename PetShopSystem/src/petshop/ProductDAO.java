/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petshop;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author ywani
 */
public class ProductDAO {
    private Connection conn;

    public ProductDAO(DatabaseConection dbHandler) {
        
        this.conn = dbHandler.getConncetion();
    }
    
     // Method to add a product to the database
    public void addProduct(String name, int categoryId, double price, int stock) {
        String sql = "INSERT INTO Products (name, category_id, price, stock) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, categoryId);
            stmt.setDouble(3, price);
            stmt.setInt(4, stock);
            stmt.executeUpdate();
            System.out.println("Product added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Method to retrieve all products
    public List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT p.ProductId, p.ProductName, c.CategoryName AS category, p.Quantity, p.Price FROM Product p JOIN Category c ON p.CategoryId = c.CategoryID;";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("ProductId"),
                        rs.getString("ProductName"),
                        rs.getString("category"),
                        rs.getInt("Quantity"),
                        rs.getDouble("price")
                );
                productList.add(product);
                
                // public Product(int productId, String name, String category, int quantity, double price){
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
    
    //Method to retrieve products by category
    public List<Product> getProductsByCategory(int categoryId) {
    List<Product> productList = new ArrayList<>();
    String sql = "SELECT p.ProductID, p.ProductName, c.CategoryName AS category, p.Price, p.Quantity " +
                 "FROM Product p JOIN category c ON p.CategoryID = c.CategoryID WHERE p.CategoryID = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, categoryId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
             Product product = new Product(
                        rs.getInt("ProductId"),
                        rs.getString("ProductName"),
                        rs.getString("category"),
                        rs.getInt("Quantity"),
                        rs.getDouble("price")
                );
            productList.add(product);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return productList;
}    
     
}

