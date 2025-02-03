package pizza;

import java.util.ArrayList;

/**
 * Meatzza pizza with predefined toppings and price calculation.
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 *
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */
public class Meatzza extends Pizza {

    /**
     * Constructor for Meatzza pizza.
     * @param size the size of the pizza
     */
    public Meatzza(Size size) {
        super(Crust.HAND_TOSSED, size); // Default crust is HAND_TOSSED
        toppings = new ArrayList<>(); // Initialize toppings list
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.BEEF);
        toppings.add(Topping.HAM);
    }

    /**
     * Calculates the price of the Meatzza pizza.
     * @return the total price
     */
    @Override
    public double price() {
        double basePrice;
        switch (size) {
            case SMALL:
                basePrice = 14.99;
                break;
            case MEDIUM:
                basePrice = 16.99;
                break;
            case LARGE:
                basePrice = 18.99;
                break;
            default:
                basePrice = 0;
        }
        return basePrice;
    }

    /**
     * Returns a string representation of the Meatzza pizza.
     * @return a string detailing the size, crust, toppings, and price
     */
    @Override
    public String toString() {
        return "Meatzza Pizza [Size: " + size + ", Crust: " + crust + ", Toppings: " + toppings +
                ", Price: $" + String.format("%.2f", price()) + "]";
    }
}
