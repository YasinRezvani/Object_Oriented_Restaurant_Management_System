package restaurant;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    // Define totalcustomer to refer id for any new customers
    private static int totalCustomers = 0;
    private int id;
    private String firstName;
    private String lastName;
    private List<Order> orders;

    // Constructor for new customer built and increament id with totalcustomer variable 
    public Customer(String firstName, String lastName) {
        this.id = ++totalCustomers;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = new ArrayList<>();
    }

    // Method to place an order for any new customer with order class 
    public void placeOrder(Menu menu, Food food, Drink drink) {
        Order order = new Order(food, drink);
        orders.add(order);
        double totalPrice = 0;
        totalPrice += order.getPrice();
        Accounting.getInstance().recordSale(getFullName() + " placed an order: \n" + order.toString(), totalPrice);
        createReceipt(order);
    }

    // Method to create a receipt for the customer in any moment customer place order 
    private void createReceipt(Order order) {
        double totalPrice = order.getPrice();
        String receiptContent = "Customer: " + getFullName() + "\n"
                + "Order detailes: \n" + "------------------------------\n" + order.toString() + "\n------------------------------" + "\n"
                + "Total Price: " + totalPrice + "\n"
                + "Date and Time: " + java.time.LocalDateTime.now();

        System.out.println("Receipt created for " + getFullName() + ":\n" + receiptContent);

        // Save receipt to a file with given customer name 
        String fileName = getFullName() + "_Receipt.txt";
        saveToFile(fileName, receiptContent);
    }

    // Give message to user create receipt file successfully or print a exception
    private void saveToFile(String fileName, String content) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(content);
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("            **** Receipt file saved successfully: " + fileName + " ****");
            System.out.println("-------------------------------------------------------------------------------");
        } catch (IOException e) {
            System.out.println("-------------------------------------------------------------------------------");
            System.err.println("          **** Error saving receipt file: " + e.getMessage() + " ****");
            System.out.println("-------------------------------------------------------------------------------");
        }
    }

    // Method to view customer information
    public void viewInfo() {
        System.out.println("Customer Information:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + getFullName());
        System.out.println("Total Orders: " + orders.size());
    }

    // Method to get full name to use any moment for example when create receipt file 
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Get id when use id for print any thing for this customer id 
    public int getId() {
        return id;
    }

    // Getter for total order when view information of customers
    public int getTotalOrders() {
        return orders.size();
    }

    // Getter for display order list of customer
    public List<Order> getOrders() {
        return orders;
    }

    // Method to get total number of customers (not useful just for specify id number)
    public static int getTotalCustomers() {
        return totalCustomers;
    }
}

