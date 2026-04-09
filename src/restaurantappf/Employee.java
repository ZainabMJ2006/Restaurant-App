/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantappf;

/**
 *
 * @author zainabmohammed
 */
public class Employee {
    private String id; // Unique identifier for the employee
    private String name; // Name of the employee
    private String role; // Role of the employee (e.g., Delivery Driver)

    // Constructor to initialize Employee details
    public Employee(String id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    // Getter for ID
    public String getId() {
        return id;
    }

    // Setter for ID
    public void setId(String id) {
        this.id = id;
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // Setter for Name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for Role
    public String getRole() {
        return role;
    }

    // Setter for Role
    public void setRole(String role) {
        this.role = role;
    }

    // toString method to display employee details
    @Override
    public String toString() {
        return "Employee Details:" +
               "\nID: " + id +
               "\nName: " + name +
               "\nRole: " + role;
    }
}