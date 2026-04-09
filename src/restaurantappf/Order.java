/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantappf;

/**
 *
 * @author zainabmohammed
 */
import java.util.*;  // Corrected import statement

/**
 * Order class to handle restaurant orders
 * @author zahraayman
 */
public class Order {
  
    private int id; // Order ID
    private String customerName; // Name of the customer
    private double totalPrice; // Total price of the order

    // Constructor to initialize the order
    public Order(int id, String customerName, double totalPrice) {
        this.id = id;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    // Getter and Setter for order ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for customer name
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // Getter and Setter for total price
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // toString method to display order details
    @Override
    public String toString() {
        return "Order ID: " + id +
               "\nCustomer Name: " + customerName +
               "\nTotal Price: $" + String.format("%.2f", totalPrice);
    }
    }