/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petshop;

/**
 *
 * @author ywani
 */
public class Product {
    private int productId;
    private String name;
    private String category;
    private int quantity;
    private double price;
    
    public Product(int productId, String name, String category, int quantity, double price){
        this.productId = productId;
        this.name=name;
        this.category=category;
        this.quantity = quantity;
        this.price = price;
    }
    
    public int getProductId(){
        return productId;
    }
    
    public String getName(){
        return name;
    }
    
    public String getCategory(){
        return category;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public double getPrice(){
        return price;
    }
}
