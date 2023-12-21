package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    // Determine list to store any food or drink
    private List<Food> foods;
    private List<Drink> drinks;
}

    // Constructor Menu() class
    public Menu() {
        this.foods = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    // Method to add food to List Food
    public void addFood(Food food) {
        foods.add(food);
    }

    public void removeFood(Food food) {
        foods.remove(food);
    }
    // Method to add food to List Drink
    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void removeDrink(Drink drink) {
        drinks.remove(drink);
    }
    // Getter for any arraylist on List Food
    public List<Food> getFoods() {
        return foods;
    }

    // Getter for any arraylist on List Drink
    public List<Drink> getDrinks() {
        return drinks;
    }
}

