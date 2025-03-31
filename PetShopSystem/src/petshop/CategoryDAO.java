/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petshop;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ywani
 */
public class CategoryDAO {
    private Connection conn;
    private DatabaseConection dbHandler;
    
    public CategoryDAO(DatabaseConection dbHandler){
        this.conn = dbHandler.getConncetion();
    }
    
    public List<String> getCategories() {
        List<String> categoryList = new ArrayList<>();
        String sql = "SELECT * FROM Category";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                categoryList.add(rs.getString("CategoryName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }
    //give me class diagrams for the above classes in PlantUML code.
    //method to get category by ID
    public int getCategoryId(String categoryName) {
        String sql = "SELECT CategoryID FROM Category WHERE CategoryName = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoryName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("CategoryID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Category not found
    }
}
