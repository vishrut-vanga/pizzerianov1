package pizza;

import java.util.ArrayList;

/**
 * Class representing an order containing multiple pizzas.
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 *
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */
public class Order {
    private static int orderCounter = 0;
    private int orderNumber;
    private ArrayList<Pizza> pizzas;

    public Order() {
        this.orderNumber = ++orderCounter;
        this.pizzas = new ArrayList<>();
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    public double calculateTotal() {
        double total = 0;
        for (Pizza pizza : pizzas) {
            total += pizza.price();
        }
        return total * 1.06625; // NJ Sales tax 6.625%
    }

    @Override
    public String toString() {
        return "Order #" + orderNumber + " - Total: $" + String.format("%.2f", calculateTotal());
    }
}
