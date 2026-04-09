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
public class Menu {
    
     private int itemId;
    private String name;
    private String description;
    private double price;

    // Lists to hold categorized menu items
    static List<Menu> appetizers = new ArrayList<>();
    static List<Menu> pastas = new ArrayList<>();
    static List<Menu> pizzas = new ArrayList<>();
    static List<Menu> steaks = new ArrayList<>();
    static List<Menu> desserts = new ArrayList<>();
    static List<Menu> juices = new ArrayList<>();
    static List<Menu> sodas = new ArrayList<>();

    // Constructor to initialize a Menu item
    public Menu(int itemId, String name, String description, double price) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Default constructor
    public Menu() {}

    // Getters
    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    // Populate the menu categories with items
    public static void initializeMenu() {
        // Appetizers
        appetizers.add(new Menu(1010, " Sweet Corn Tamale Cakes ", " Topped with Sour Cream, Salsa, Cilantro, Avocado ", 67.99));
        appetizers.add(new Menu(1011, " Buffalo Wings ", " Fried Wings Covered in Hot Sauce and Served with Blue Cheese Dressing ", 70.66));

        // Pastas
        pastas.add(new Menu(1110, " Pasta Da Vinci ", " Classic Italian Pasta with Egg, Cheese, and Bacon ", 84.00));
        pastas.add(new Menu(1111, " Fettuccine Alfredo ", " Sauteed Chicken, Mushrooms and Onions in a Delicious Madeira Sauce Tossed with Penne Pasta ", 110.95));

        // Pizzas
        pizzas.add(new Menu(1210, " Margherita Pizza ", " Mozzarella, Basil and Tomato Sauce ", 80.20));
        pizzas.add(new Menu(1211, " Fresh Basil Pizza ", " With Mozzarella, Fontina, and Parmesan ", 79.33));

        // Steaks
        steaks.add(new Menu(1310, " Chargrilled New York Steak ", " Chargrilled New York Steak ", 163.44));
        steaks.add(new Menu(1311, " Grilled Rib-Eye Steak ", " Served with Mashed Potatoes and Vegetables ", 170.00));

        // Desserts
        desserts.add(new Menu(1410, " Linda’s Fudge Cake ", " Layers of Rich Chocolate Cake and Fudge Frosting ", 44.00));
        desserts.add(new Menu(1411, " Carrot Cake ", " Deliciously Moist Layers of Carrot Cake and Our Famous Cream Cheese Icing ", 49.00));

        // Juices
        juices.add(new Menu(2010, " Orange Juice", "No sugar ", 10.00));
        juices.add(new Menu(2011, " Strawberry Daiquiri", "Fresh Strawberries and Strawberry Puree Blended with Lemon and Lime Syrup ", 24.00));

        // Sodas
        sodas.add(new Menu(2110, " Coca-Cola", "With sugar ", 4.00));
        sodas.add(new Menu(2111, " Pepsi ", " With sugar ", 4.00));
    }

    // Display all items in a category
    public static void displayCategory(List<Menu> category, String categoryName) {
        System.out.println(categoryName + ":");
        for (Menu item : category) {
            System.out.println(item.itemId + ": " + item.name + " - " + item.description + " ($" + item.price + ")");
        }
    }

    // Display the full menu
    public static void displayFullMenu() {
        displayCategory(appetizers, "\n *** Appetizers ***");
        displayCategory(pastas, "\n *** Pastas ***");
        displayCategory(pizzas, "\n *** Pizzas ***");
        displayCategory(steaks, "\n *** Steaks ***");
        displayCategory(desserts, "\n *** Desserts ***");
        displayCategory(juices, "\n *** Juices ***");
        displayCategory(sodas, "\n *** Sodas ***");
    }

    // Get the price of an item by its ID
    public static double getItemPriceById(int itemId) {
        List<List<Menu>> categories = List.of(appetizers, pastas, pizzas, steaks, desserts, juices, sodas);
        for (List<Menu> category : categories) {
            for (Menu item : category) {
                if (item.itemId == itemId) {
                    return item.price;
                }
            }
        }
        return -1; // Invalid item ID
    }
}