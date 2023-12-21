package restaurant;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Accounting {

    // Define instance for sigleton accounting class 
    private static Accounting instance = null;
    private List<String> salesData;
    private double totalSellingPrice;

    // Private constructor to prevent instantiation outside the class (singleton)
    private Accounting() {
        this.salesData = new ArrayList<>();
        this.totalSellingPrice = 0.0;
    }

    // Check if class have instance use static method to get the singleton instance
    public static Accounting getInstance() {
        if (instance == null) {
            instance = new Accounting();
        }
        return instance;
    }

    // Method to record sales data
    public void recordSale(String saleInfo, double price) {
        salesData.add(saleInfo);
        totalSellingPrice += price;
    }

    // Method to generate a receipt file with custom name given from user 
    public void generateReceipt(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            // write sale information to salsedata arraylist
            for (String saleInfo : salesData) {
                writer.println(saleInfo);
            }

            // Define format to correctly write on the file
            writer.println("\n--------------------------");
            writer.println("Total Selling Price: " + totalSellingPrice);

            // Write local time on file with time localdatetime library
            writer.println("Date and Time: " + java.time.LocalDateTime.now());
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            System.out.println("         **** Total selling price bell generated successfully. File name: " + fileName + " ****");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");

            // Exception handling throw exception
        } catch (IOException e) {
            System.out.println("-----------------------------------------------------------------------------------");
            System.err.println("            **** Error generating receipt file: " + e.getMessage() + " ****");
            System.out.println("-----------------------------------------------------------------------------------");
        }
    }

    // Getter for get total selling price to refer main class to calculate total selling entirely
    public double getTotalSellingPrice() {
        return totalSellingPrice;
    }
}
