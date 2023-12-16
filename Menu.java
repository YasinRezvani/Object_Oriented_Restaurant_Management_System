package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Food> foods;
    private List<Drink> drinks;
}


    public Menu() {
        this.foods = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void removeFood(Food food) {
        foods.remove(food);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void removeDrink(Drink drink) {
        drinks.remove(drink);
    }

    public List<Food> getFoods() {
        return foods;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }
}

