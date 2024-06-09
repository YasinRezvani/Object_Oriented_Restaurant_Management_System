package restaurant;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Define list as same as customer manager file to manage customer (add & remove & show)
    private static List<Customer> customers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Menu menu = new Menu();

    // s8how welcome message and introduction of project :)
    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------------------------------------------------------------\n");
        System.out.println("             ******* Welcome to Object Oriented Restaurant Management System Project *******\n");
        System.out.println("                                       Supervisor: Ms. Bahareh Javid");
        System.out.println("                                       Teacher Assistants: Mr. Behnam Saghari, Ms. Asal Salmani ");
        System.out.println("                                       Course: Advanced programming");
        System.out.println("                                       Student: Yasin Rezvani ");
        System.out.println("                                       Date: Fall 2023 \n");
        System.out.println("                                       Shahrood University of Thechnology \n");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        showMenu();
    }

    // Show main to user choose section of program and I use switch case
    private static void showMenu() {
        System.out.println("\n# Please choose your section:\n");
        System.out.println("1- Menu");
        System.out.println("2- Accounting");
        System.out.println("3- Customer");
        System.out.println("4- Exit\n");

        int sectionChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        switch (sectionChoice) {
            case 1:
                handleMenuSection();
                break;
            case 2:
                handleAccountingSection();
                break;
            case 3:
                handleCustomerSection();
                break;
            case 4:
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("               **** Exiting the program, Take care, Goodbye!:) ****");
                System.out.println("-------------------------------------------------------------------------------");
                break;
            default:
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("           **** Invalid choice. Please choose a valid section.****");
                System.out.println("-------------------------------------------------------------------------------");
                showMenu();
        }
    }

    // Handle menu section with switch case ro refer any methods
    private static void handleMenuSection() {
        System.out.println("\n# Please choose your section:\n");
        System.out.println("1- List menu");
        System.out.println("2- Add food");
        System.out.println("3- Add drink");
        System.out.println("4- Remove food");
        System.out.println("5- Remove drink");
        System.out.println("6- Back to main menu\n");

        int menuChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        switch (menuChoice) {
            case 1:
                listMenu();
                break;
            case 2:
                addFood();
                break;
            case 3:
                addDrink();
                break;
            case 4:
                removeFood();
                break;
            case 5:
                removeDrink();
                break;
            case 6:
                showMenu();
                break;
            default:
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("           **** Invalid choice. Please choose a valid section.****");
                System.out.println("-------------------------------------------------------------------------------");
                handleMenuSection();
        }
    }

    private static void listMenu() {
        // Implement list of all menu until added
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("List of all foods:\n");
        for (Food food : menu.getFoods()) {
            System.out.println("Type: " + food.getType()
                    + ", Name: " + food.getName()
                    + ", Price: " + food.getPrice()
                    + ", Meal Time: " + food.getMealTime());
        }

        System.out.println("\nList of all drinks:\n");
        for (Drink drink : menu.getDrinks()) {
            System.out.println("Type: " + drink.getType()
                    + ", Name: " + drink.getName()
                    + ", Price: " + drink.getPrice());
        }
        System.out.println("-------------------------------------------------------------------------------");

        handleMenuSection();  // Back to menu section again to choose option 
    }

    private static void addFood() {
        // Select food type and meal time from user and given name and price
        System.out.print("# Enter the name of the food: ");
        String foodName = scanner.nextLine();

        System.out.println("\nSelect the Food Type:");
        System.out.println("1- FAST_FOOD");
        System.out.println("2- IRANIAN_FOOD");
        System.out.println("3- CHINESE_FOOD");
        System.out.print("# Enter the number for Food Type:");

        int foodTypeChoice = scanner.nextInt();
        scanner.nextLine();

        Food.Type foodType;
        // Select type of food from enum definition 
        switch (foodTypeChoice) {
            case 1:
                foodType = Food.Type.FAST_FOOD;
                break;
            case 2:
                foodType = Food.Type.IRANIAN_FOOD;
                break;
            case 3:
                foodType = Food.Type.CHINESE_FOOD;
                break;
            default:
                // If invalid input set default value to prevent mistake or exception 
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("               **** Invalid choice. Defaulting to FAST_FOOD. ****");
                System.out.println("-------------------------------------------------------------------------------");
                foodType = Food.Type.FAST_FOOD;
                break;
        }

        System.out.print("# Enter the price of the food: ");
        double foodPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("\nSelect the Meal Time:");
        System.out.println("1. BRACK_FAST");
        System.out.println("2. LUNCH");
        System.out.println("3. DINNER");
        System.out.print("# Enter the number for Meal Time: ");

        int mealTimeChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        Food.MealTime mealTime;
        switch (mealTimeChoice) {
            case 1:
                mealTime = Food.MealTime.BREACK_FAST;
                break;
            case 2:
                mealTime = Food.MealTime.LUNCH;
                break;
            case 3:
                mealTime = Food.MealTime.DINNER;
                break;
            default:
                // Exception handling to invalid input from user
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("               **** Invalid choice. Defaulting to BRACK_FAST. ****");
                System.out.println("-------------------------------------------------------------------------------");

                mealTime = Food.MealTime.BREACK_FAST;
                break;
        }

        Food newFood = new Food(foodType, foodName, foodPrice, mealTime);
        menu.addFood(newFood);
        // Get message for user food or drink add successfully
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("                    **** Food added to the menu successfully! ****");
        System.out.println("-------------------------------------------------------------------------------");
        handleMenuSection();  // After adding, go back to the menu section
    }

    // addDrink method same as addFood method just don't have meal time field 
    private static void addDrink() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("# Enter the name of the drink: ");
        String drinkName = scanner.nextLine();

        System.out.print("# Enter the price of the drink: ");
        double drinkPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("\nSelect the Drink Type:");
        System.out.println("1- HOT_DRINK");
        System.out.println("2- ICE_DRINK");
        System.out.print("# Enter the number for Drink Type: ");

        int drinkTypeChoice = scanner.nextInt();
        scanner.nextLine();

        Drink.Type drinkType;
        switch (drinkTypeChoice) {
            case 1:
                drinkType = Drink.Type.HOT_DRINK;
                break;
            case 2:
                drinkType = Drink.Type.ICE_DRINK;
                break;
            default:
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("               **** Invalid choice. Defaulting to HOT_DRINK. ****");
                System.out.println("-------------------------------------------------------------------------------");
                // set default choice to prevent mistakes
                drinkType = Drink.Type.HOT_DRINK;
                break;
        }

        Drink drink = new Drink(drinkType, drinkName, drinkPrice);
        menu.addDrink(drink);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("                    **** Drink added to the menu successfully! ****");
        System.out.println("-------------------------------------------------------------------------------");

        handleMenuSection();
    }

    // Remove method first show list of available food or drink after user type name of food or drink wants  to remove from list menu 
    private static void removeFood() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("List of Foods:\n");
        for (Food food : menu.getFoods()) {
            System.out.println(food.getName());
        }
        System.out.println("-------------------------------------------------------------------------------");

        // given food or drink name from user 
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n# Enter the name of the food to remove: ");
        String foodName = scanner.nextLine();

        // Search choosen food or drink from list of menu with help of for each and .equal() method
        boolean found = false;
        for (Food food : menu.getFoods()) {
            if (food.getName().equals(foodName)) {
                // print message for user 
                menu.removeFood(food);
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("         **** " + foodName + " removed from the menu successfully! ****");
                System.out.println("-------------------------------------------------------------------------------");
                found = true;
                break;
            }
        }
        // If not same or mistake input print foodname variable not found andu try again 
        if (!found) {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("             **** No food found with the name of " + foodName + " ****");
            System.out.println("-------------------------------------------------------------------------------");
        }
        handleMenuSection();
    }

    // removeDrink() same as removeFood() method no different
    private static void removeDrink() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("List of Drinks:\n");
        for (Drink drink : menu.getDrinks()) {
            System.out.println(drink.getName());
        }
        System.out.println("-------------------------------------------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.print("# Enter the name of the drink to remove: ");
        String drinkName = scanner.nextLine();

        boolean found = false;
        for (Drink drink : menu.getDrinks()) {
            if (drink.getName().equals(drinkName)) {

                menu.removeDrink(drink);
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("      **** " + drinkName + " removed from the menu successfuly! ****");
                System.out.println("-------------------------------------------------------------------------------");
                found = true;
                break;
            }

        }

        if (!found) {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("              **** No drink found with the name of " + drinkName + " ****");
            System.out.println("-------------------------------------------------------------------------------");
        }

        handleMenuSection();
    }

    // Handeler of section 2 (accounting) refer to accounting.java class 
    private static void handleAccountingSection() {
        System.out.println("\n# Please choose your section:\n");
        System.out.println("1- Show total selling price");
        System.out.println("2- Generate total selling price bell with custom name");
        System.out.println("3- Back to main menu\n");

        int accountingChoice = scanner.nextInt();
        scanner.nextLine();

        switch (accountingChoice) {
            case 1:
                showTotalSellingPrice();
                break;
            case 2:
                generateTotalSellingPriceBell();
                break;
            case 3:
                showMenu();
                break;
            default:
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("            **** Invalid choice. Please choose a valid command. ****");
                System.out.println("-------------------------------------------------------------------------------");
                handleAccountingSection();
        }
    }

    // Create new instance from accounting class because accounting class just have one object or singleton class and use gettotalsellingprice in accounting method print total to user
    private static void showTotalSellingPrice() {
        Accounting accountingInstance = Accounting.getInstance();
        double totalSellingPrice = accountingInstance.getTotalSellingPrice();
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("                        **** Total Selling Price: " + totalSellingPrice + " ****");
        System.out.println("----------------------------------------------------------------------------------------");

        handleAccountingSection();  // After displaying, go back to the accounting section
    }

    // Same as showTotalSellingPrice() but generate file with printWriter library with custom name  from user
    private static void generateTotalSellingPriceBell() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("# Enter a custom name for the total selling price bell: ");
        String customName = scanner.nextLine();

        Accounting accountingInstance = Accounting.getInstance();
        double totalSellingPrice = accountingInstance.getTotalSellingPrice();

        String fileName = customName + "_TotalSellingPriceBell.txt";
        accountingInstance.generateReceipt(fileName);

        handleAccountingSection();
    }

    // Start customer section along with customer.java class 
    private static void handleCustomerSection() {
        System.out.println("\n# Please choose your section:");
        System.out.println("1- List all customers");
        System.out.println("2- Add customer");
        System.out.println("3- Remove customer");
        System.out.println("4- Order product with customer id");
        System.out.println("5- Show customer info by id");
        System.out.println("6- Generate customer order bell by id");
        System.out.println("7- Back to main menu\n");

        int customerChoice = scanner.nextInt();
        scanner.nextLine();

        switch (customerChoice) {
            case 1:
                listAllCustomers();
                break;
            case 2:
                addCustomer();
                break;
            case 3:
                removeCustomer();
                break;
            case 4:
                orderProductWithCustomerId();
                break;
            case 5:
                showCustomerInfoById();
                break;
            case 6:
                generateCustomerOrderBellById();
                break;
            case 7:
                showMenu();
                break;
            default:
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("            **** Invalid choice. Please choose a valid command. ****");
                System.out.println("-------------------------------------------------------------------------------");
                handleCustomerSection();
        }

    }

    // List of all customer with cutomer list wheather define first of main.java class like customer manager list print with for each to print any sequences
    private static void listAllCustomers() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("List of All Customers:\n");

        if (customers.isEmpty()) {
            System.out.println("**** No customers found. ****");
            System.out.println("-------------------------------------------------------------------------------");
        } else {
            for (Customer customer : customers) {
                System.out.println("Customer ID: " + customer.getId());
                System.out.println("Name: " + customer.getFullName());
                System.out.println("Total Orders: " + customer.getTotalOrders());
                System.out.println("------------------------");
            }
            System.out.println("-------------------------------------------------------------------------------");
        }

        handleCustomerSection();
    }

    // Add new customer to customer list just get first and last name after specify id for each new customer and print id to user to manage the customer easily
    private static void addCustomer() {
        System.out.print("# Enter customer first name: ");
        String firstName = scanner.next();

        System.out.print("# Enter customer last name: ");
        String lastName = scanner.next();

        Customer newCustomer = new Customer(firstName, lastName);
        customers.add(newCustomer);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("                     **** Customer added successfully! ****");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("                       **** Customer ID: " + newCustomer.getId() + " ****");
        System.out.println("-------------------------------------------------------------------------------");

        handleCustomerSection();
    }

    // For remove any customer I use lambda method removeIf() to remove with ease from list if id is equal if not fount print not found cutomer message
    private static void removeCustomer() {

        System.out.print("# Enter the customer ID to remove: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();

        boolean removed = customers.removeIf(customer -> customer.getId() == customerId);

        if (removed) {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("                  **** Customer removed successfully. ****");
            System.out.println("-------------------------------------------------------------------------------");
        } else {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("                 **** Customer not found with ID: " + customerId + " ****");
            System.out.println("-------------------------------------------------------------------------------");
        }

        handleCustomerSection();
    }

    // Get order from customer with customer id after placed order into food or drinks class
    private static void orderProductWithCustomerId() {

        System.out.print("# Enter customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = findCustomerById(customerId);

        if (customer != null) {

            System.out.print("# Enter food name: ");
            String foodName = scanner.next();

            System.out.print("# Enter drink name: ");
            String drinkName = scanner.next();

            // Send data from customer and put data to placedorder method after create receipte file in customer.java 
            Food food = getFoodByName(foodName);
            Drink drink = getDrinkByName(drinkName);

            customer.placeOrder(menu, food, drink);
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("                    **** Order placed successfully! ****");
            System.out.println("-------------------------------------------------------------------------------");
        } else {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("                 **** Customer with ID " + customerId + " not found. ****");
            System.out.println("-------------------------------------------------------------------------------");
        }

        handleCustomerSection();
    }

    // This method help to orderProductWithCustomerId() to find customer with id if available returned but not available return null data
    private static Customer findCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    // This method help to orderProductWithCustomerId() to find given food from user and return food 
    private static Food getFoodByName(String foodName) {
        for (Food food : menu.getFoods()) {
            if (food.getName().equalsIgnoreCase(foodName)) {
                return food;
            }
        }
        return null;
    }

    // Same as getFoodByName but send drinks data 
    private static Drink getDrinkByName(String drinkName) {
        for (Drink drink : menu.getDrinks()) {
            if (drink.getName().equalsIgnoreCase(drinkName)) {
                return drink;
            }
        }
        return null;
    }

    // Find customer with id with help of for each to literate into customer list if equal show customer data
    private static void showCustomerInfoById() {
        System.out.println("# Enter the customer ID:");
        int customerId = scanner.nextInt();
        scanner.nextLine();

        Customer foundCustomer = findCustomerById(customerId);

        if (foundCustomer != null) {
            foundCustomer.viewInfo();
        } else {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("                    **** Customer with ID " + customerId + " not found. ****");
            System.out.println("-------------------------------------------------------------------------------");
        }

        handleCustomerSection();
    }

    // Generate a file name using customer's name after get order from order.class 
    private static void generateCustomerOrderBellById() {
        System.out.print("# Enter Customer ID: ");
        int customerId = scanner.nextInt();

        Customer customer = findCustomerById(customerId);
        if (customer != null) {

            String fileName = customer.getFullName() + "_" + customer.getId() + "_OrderBell.txt";
            List<Order> orders = customer.getOrders();

            // Write order details to the file with writePrinter library 
            try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                for (Order order : orders) {
                    writer.println("Customer: " + customer.getFullName() + "\n");
                    writer.println("Order Details:");
                    writer.println("------------------------------");
                    writer.println(order.toString());
                    writer.println("------------------------------");
                    writer.println("Total Price: " + order.getPrice());
                    writer.println("Date and Time: " + java.time.LocalDateTime.now());
                    writer.println("\n");
                }
                System.out.println("-------------------------------------------------------------------------------------------------------");
                System.out.println("            **** Order bell file generated successfully: " + fileName + " ****");
                System.out.println("-------------------------------------------------------------------------------------------------------");
                // Write exception if file not in correct destination throw exception faild message 
            } catch (IOException e) {
                System.out.println("-------------------------------------------------------------------------------");
                System.err.println("       **** Error generating order bell file: " + e.getMessage() + " ****");
                System.out.println("-------------------------------------------------------------------------------");
            }
            // If customer id not found in customer array list print error to faild find customer 
        } else {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("                  **** Customer with ID " + customerId + " not found. ****");
            System.out.println("-------------------------------------------------------------------------------");
        }

        handleCustomerSection();
    }

}

