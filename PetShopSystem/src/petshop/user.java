/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petshop;

/**
 *
 * @author yasas
 */
public abstract class user {
    private String username;
    private String password;
    private String role;
    
    //Constructor
    public user (String username, String password, String role) {
        this.username=username;
        this.password=password;
        this.role=role;
    }
    //getter and setter methods to access the private username and password 
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;   
    } 
    
    public String getRole(){
        return role;
    }
    
    //Adstract method
    public abstract void showDashboard();
    
    public void Logout(){
        System.out.println(username + "has logged out.");
    }
}