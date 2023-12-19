
package restaurant;

public class Drink {
    public enum Type {
        HOT_DRINK,
        ICE_DRINK
    }

    private Type type;
    private String name;
    private double price;
    private static int totalSales;

    public Drink(Type type, String name, double price) {
        this.type = type;
        this.name = name;
        this.price = price;
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

    public static int getTotalSales() {
        return totalSales;
    }

    public static void incrementTotalSales() {
        totalSales++;
    }
}
