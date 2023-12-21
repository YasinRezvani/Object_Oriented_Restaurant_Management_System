
package restaurant;

public class Drink {
    // Define enum for type to choose easily
    public enum Type {
        HOT_DRINK,
        ICE_DRINK
    }

    // Define private fields
    private Type type;
    private String name;
    private double price;
    private static int totalSales;

    // Define constructor
    public Drink(Type type, String name, double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    // Getters and setters for private fields
    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static int getTotalSales() {
        return totalSales;
    }

    public static void incrementTotalSales() {
        totalSales++;
    }
}
