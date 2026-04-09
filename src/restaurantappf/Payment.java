/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantappf;

import java.util.Scanner;

/**
 *
 * @author zainabmohammed
 */
public class Payment {
    private double amount;
    private String method;

    public Payment(double amount, String method) {
        this.amount = amount;
        this.method = method;
    }

    public boolean process() {
        Scanner scanner = new Scanner(System.in);

        // Automatically enforce card payment if total exceeds 200
        if (amount > 200) {
            System.out.println("Since the total is more than $200, you must pay with a CARD.");
            method = "CARD"; // Force the method to card
        }

        if (method.equalsIgnoreCase("CASH")) {
            System.out.println("Please prepare the exact amount. Payment will be collected on delivery.");
            return true; // Assume cash payment is always valid
        } else if (method.equalsIgnoreCase("CARD")) {
            System.out.println("Enter your card number (numbers only):");
            String cardNumber = scanner.nextLine();

            // Validate card number (only digits)
            while (!cardNumber.matches("\\d+")) {
                System.out.println("Invalid card number. Please enter digits only:");
                cardNumber = scanner.nextLine();
            }

            System.out.println("Enter your CVC (3 digits):");
            String cvc = scanner.nextLine();

            // Validate CVC (exactly 3 digits)
            while (!cvc.matches("\\d{3}")) {
                System.out.println("Invalid CVC. Please enter exactly 3 digits:");
                cvc = scanner.nextLine();
            }

            System.out.println("Card payment processed successfully.");
            return true;
        } else {
            System.out.println("Invalid payment method. Payment failed.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Payment Amount: $" + amount + ", Method: " + method;
    }
}