/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantappf;

/**
 *
 * @author zainabmohammed
 */
public class User {
    
     private String name;
    private String contact;

    // Constructor to initialize User
    public User(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for contact
    public String getContact() {
        return contact;
    }

    // Setter for contact
    public void setContact(String contact) {
        this.contact = contact;
    }

    // toString method for general user information
    @Override
    public String toString() {
        return "Name: " + name + ", Contact: " + contact;
    }
}