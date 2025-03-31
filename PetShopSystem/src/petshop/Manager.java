/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petshop;

import petshop.Cashier;

/**
 *
 * @author ywani
 */
public class Manager extends Cashier {
    
    //Constructor
    public Manager(String username, String password){
        super(username, password, "Manager");
    }
    
    @Override
    public void showDashboard() {
        System.out.println("Welcome to the Manager Dashboard, " + getUsername());
    }

    public void createCashierAccount(String username, String password) {
        System.out.println("New cashier account created: " + username);
    }
}
