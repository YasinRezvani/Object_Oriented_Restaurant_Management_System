package restaurant;

public class Food {
    public enum Type {
        FAST_FOOD,
        IRANIAN_FOOD,
        CHINESE_FOOD
    }

    public enum MealTime {
        BREACK_FAST,
        LUNCH,
        DINNER
    }

    private Type type;
    private String name;
    private double price;
    private MealTime mealTime;
    private static int totalSales;

    public Food(Type type, String name, double price, MealTime mealTime) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.mealTime = mealTime;
    }

        public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public MealTime getMealTime() {
        return mealTime;
    }

    public static int getTotalSales() {
        return totalSales;
    }

    public static void incrementTotalSales() {
        totalSales++;
    }
}
