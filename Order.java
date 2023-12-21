package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {
    // Define list for any food class
    private List<Food> foods;
    private List<Drink> drinks;

    public Order() {
        this.foods = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }
    // Add any place order to food or drink class list
    public Order(Food food, Drink drink) {
        this();
        addFood(food);
        addDrink(drink);
    }

    // Define getter and Setter
    public void addFood(Food food) {
        foods.add(food);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public List<Food> getFoods() {
        return foods;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    // Give main class total prices selling for view to customer
    public double getPrice() {
        double total = 0;

        
        for (Food food : foods) {
            total += food.getPrice();
        }

        
        for (Drink drink : drinks) {
            total += drink.getPrice();
        }

        return total;
    }
    // We need to override tostring() method because for write customer's order to save in file
    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append("\nOrdered Foods:\n");
        for (Food food : foods) {
            orderDetails.append("- ").append(food.getName()).append("\n");
        }

        orderDetails.append("Ordered Drinks:\n");
        for (Drink drink : drinks) {
            orderDetails.append("- ").append(drink.getName()).append("\n");
        }

        return orderDetails.toString();
    }
}
