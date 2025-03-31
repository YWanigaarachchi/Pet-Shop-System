/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petshop;

/**
 *
 * @author ywani
 */
public class Cashier extends user {
    
    //Constructor
    public Cashier(String username, String password){
        super(username,password,"Cashier");
    }
    
    public Cashier (String username, String password, String role){
        super(username,password,role);
    }
    
    @Override
    public void showDashboard(){
        System.out.println("Welcome to the Cashier Dashboard," + getUsername());
    }
    
    public void viewProducts(){
        System.out.println("Display all available products...");
    }
    
    public void searchProuct(String name, String category, double price, int stock){
        System.out.println("Adding product: " + name + "| Category: "+ category + "| Price: $" + price + "| Stock:" + stock);
    }
    public void searchProduct(String category){
        System.out.println("Searching products in category:" + category);
    }
}
