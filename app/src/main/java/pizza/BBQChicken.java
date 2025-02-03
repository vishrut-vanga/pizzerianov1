package pizza;

import java.util.ArrayList;

/**
 * BBQ Chicken pizza with predefined toppings and price calculation.
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 *
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */
public class BBQChicken extends Pizza {

    /**
     * Constructor for BBQ Chicken pizza.
     * @param size the size of the pizza
     */
    public BBQChicken(Size size) {
        super(Crust.HAND_TOSSED, size); // Default crust is HAND_TOSSED
        toppings = new ArrayList<>(); // Initialize toppings list
        toppings.add(Topping.BBQ_CHICKEN);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.PROVOLONE);
        toppings.add(Topping.CHEDDAR);
    }

    /**
     * Calculates the price of the BBQ Chicken pizza.
     * @return the total price
     */
    @Override
    public double price() {
        double basePrice;
        switch (size) {
            case SMALL:
                basePrice = 13.99;
                break;
            case MEDIUM:
                basePrice = 15.99;
                break;
            case LARGE:
                basePrice = 17.99;
                break;
            default:
                basePrice = 0;
        }
        return basePrice;
    }

    /**
     * Returns a string representation of the BBQ Chicken pizza.
     * @return a string detailing the size, crust, toppings, and price
     */
    @Override
    public String toString() {
        return "BBQ Chicken Pizza [Size: " + size + ", Crust: " + crust + ", Toppings: " + toppings +
                ", Price: $" + String.format("%.2f", price()) + "]";
    }
}
