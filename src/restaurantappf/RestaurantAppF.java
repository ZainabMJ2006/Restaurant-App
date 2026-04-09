/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package restaurantappf;

import java.util.Scanner;
import java.util.*;

/**
 *
 * @author zainabmohammed
 */
public class RestaurantAppF {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Greeting
        System.out.println("Welcome to Restaurant Delivery App");
        System.out.println("We serve [Appetizers], [Pastas], [Pizzas], [Steaks], [Desserts], [Juices], and [Sodas]");

        // to start new order will enter yes 
        System.out.print("\n Would you like to start new order [yes] [no]:");
        String userType = in.next().toUpperCase();

        // Initialize the menu
        Menu.initializeMenu();

        // 
       if (userType.equals("YES")) {
        customerYes(in); // Continue with the program
    } else if (userType.equals("NO")) {
        System.out.println("Thank you! Have a nice day."); // Exit program
    } else {
        System.out.println("Invalid input. Please restart the program."); // Invalid input
    }

    }

    

   private static void customerYes(Scanner in) {
    boolean done = false;
    double totalPrice = 0;

    // Collect customer information
    System.out.print("Enter your name:");
    String customerName = in.next();

    // Validate the contact number
    String contact;
    
   while (true) {
    System.out.print("Enter your contact number (numbers only):");
    contact = in.next();

    boolean isValid = true;
    
    for (int i = 0; i < contact.length(); i++) {
        if (!Character.isDigit(contact.charAt(i))) { // Check if each character is not a digit
            isValid = false;
            break; // Exit the loop if a non-digit character is found
        }
    }

    if (isValid) {
        break; // Exit the validation loop if all characters are digits
    } else {
        System.out.println("Invalid contact number. Please enter numbers only.");
    }
}

    // Customer object
    Customer customer = new Customer(customerName, contact);

    // Order object
    Order order = new Order(1, customerName, totalPrice);

    // variables for delivery employee
    Employee deliveryEmployee = null;
    boolean validArea = false;

    // Loop for entering delivery area until a valid one is chosen
    while (!validArea) {
        System.out.print("From which area are you? (Khobar, Dammam, Qatif): ");
        
        String area = in.next().toLowerCase();

        switch (area) {
            case "khobar":
                deliveryEmployee = new Employee("E123", "Ahmed A", "Delivery Driver");
                validArea = true; // Mark area as valid
                break;

            case "dammam":
                deliveryEmployee = new Employee("A324", "Faris", "Delivery Driver");
                validArea = true; // Mark area as valid
                break;

            case "qatif":
                deliveryEmployee = new Employee("A333", "Ali", "Delivery Driver");
                validArea = true; // Mark area as valid
                break;

            default:
                System.out.println("\n Sorry, we cannot deliver to this area.");
                System.out.print("Do you want to deliver to another area? [YES/NO]");
                String responseForArea = in.next().toUpperCase();
                if (responseForArea.equals("NO")) {
                    return; // Exit the method if the user chooses not to deliver to another area
                }
        }
    }

    System.out.println("\n Welcome, " + customer.getName() + "!");

    // Continue with menu selection
    while (!done) {
        System.out.print("Do you want to see the [FULL] menu or a [SECTION]?");
        String menuChoice = in.next().toUpperCase();

        if (menuChoice.equals("FULL")) {
            Menu.displayFullMenu();
        } else if (menuChoice.equals("SECTION")) {
            boolean validSection = false;
            while (!validSection) {
                System.out.println("Enter the section name");
                System.out.println("\n ###     Name of Sections     ###");
                System.out.print("     || Appetizers ||");
                System.out.print("     ||  Pastas  ||");
                System.out.print("     ||  Pizzas  ||");
                System.out.print("     ||  Steaks ||");
                System.out.print("     ||  Desserts  ||");
                System.out.print("     ||  Juices  ||");
                System.out.println("     ||  Sodas  ||");
                
                System.out.print("\n enter your choose: ");
             
                String section = in.next();
                switch (section.toLowerCase()) {
                    case "appetizers":
                        Menu.displayCategory(Menu.appetizers, "Appetizers");
                        validSection = true;
                        break;
                    case "pastas":
                        Menu.displayCategory(Menu.pastas, "Pastas");
                        validSection = true;
                        break;
                    case "pizzas":
                        Menu.displayCategory(Menu.pizzas, "Pizzas");
                        validSection = true;
                        break;
                    case "steaks":
                        Menu.displayCategory(Menu.steaks, "Steaks");
                        validSection = true;
                        break;
                    case "desserts":
                        Menu.displayCategory(Menu.desserts, "Desserts");
                        validSection = true;
                        break;
                    case "juices":
                        Menu.displayCategory(Menu.juices, "Juices");
                        validSection = true;
                        break;
                    case "sodas":
                        Menu.displayCategory(Menu.sodas, "Sodas");
                        validSection = true;
                        break;
                    default:
                        System.out.println("\n Invalid section. Please try again.");
                }
            }
        } else {
            System.out.println("\n Invalid choice.");
            continue;
        }

        System.out.print("\n Enter the ID of the item you want to order:");
        int itemId = in.nextInt();

        double price = Menu.getItemPriceById(itemId);
        if (price == -1) {
            System.out.println("\n Invalid item ID. Please try again.");
        } else {
            totalPrice += price;
            System.out.println("\n Item added to your order. Current total: $" + totalPrice);
        }

        System.out.print("Are you done ordering? [YES/NO]:");
        done = in.next().equalsIgnoreCase("YES");
    }

    // Update the total price in the Order object
    order.setTotalPrice(totalPrice);

    String paymentMethod;
    
        while (true) {
            System.out.println("\n Will you pay with [CASH] or [CARD]?");
            paymentMethod = in.next().toUpperCase();

            if (paymentMethod.equals("CASH") || paymentMethod.equals("CARD")) {
                break; // Exit the loop if the input is valid
            } else {
                System.out.println("Invalid input. Please enter either 'CASH' or 'CARD'.");
            }
        }

    Payment payment = new Payment(totalPrice, paymentMethod);
    if (payment.process()) {
        System.out.println("\n Payment successful. Your order is being prepared!");

        // Display the delivery employee information after payment
        System.out.println("\n Your order will be delivered by: ");
        System.out.println(deliveryEmployee);

        // Display the order summary
        System.out.println("\n Order Summary:");
        System.out.println(order);
    } else {
        System.out.println("\n Payment failed. Please try again.");
    }

    System.out.println("\n Delivery status: OUT FOR DELIVERY");
}}