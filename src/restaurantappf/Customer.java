/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantappf;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zainabmohammed
 */
public class Customer extends User {
    
    // Constructor to initialize Customer with inherited fields
    public Customer(String name, String contact) {
        super(name, contact); // Call the constructor of the User class
    }

    // toString method to display customer information
    @Override
    public String toString() {
        return "Customer Name: " + getName() + ", Contact: " + getContact();
    }
}