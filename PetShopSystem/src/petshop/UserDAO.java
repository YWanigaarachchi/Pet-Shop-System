/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petshop;
import java.sql.*;

/**
 *
 * @author ywani
 */
public class UserDAO {
    private Connection conn;
    
    public UserDAO(DatabaseConection dbHandler){
        this.conn = dbHandler.getConncetion();
    }
    
    public user authenticate(String username, String password){
        String sql = "SELECT * FROM users WHERE BINARY username=? AND password=?";
        
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            
            
            
            if(rs.next()){
                String role = rs.getString("role");
                
                if(role.equalsIgnoreCase("Manager")){
                    return new Manager(username,password);
                }else if(role.equalsIgnoreCase("Cashier")){
                    return new Cashier(username, password);
                }
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null; //Auth failed
    }   
}

