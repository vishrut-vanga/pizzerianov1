package pizza;

import java.util.ArrayList;

/**
 * Build Your Own pizza with customizable toppings.
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 *
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */
public class BuildYourOwn extends Pizza {

    /**
     * Constructor for Build Your Own pizza.
     * @param crust the crust type
     * @param size the size of the pizza
     */
    public BuildYourOwn(Crust crust, Size size) {
        super(crust, size);
        this.toppings = new ArrayList<>(); // Initialize toppings list
    }

    /**
     * Calculates the price of the Build Your Own pizza.
     * @return the total price
     */
    @Override
    public double price() {
        double basePrice;
        switch (size) {
            case SMALL:
                basePrice = 8.99;
                break;
            case MEDIUM:
                basePrice = 10.99;
                break;
            case LARGE:
                basePrice = 12.99;
                break;
            default:
                basePrice = 0;
        }
        return basePrice + (1.69 * toppings.size());
    }

    /**
     * Adds a topping to the pizza.
     * @param topping the topping to add
     * @return true if the topping was added, false if the maximum number of toppings (7) is already reached
     */
    @Override
    public void addTopping(Topping topping) {
        if (toppings.size() < 7) {
            toppings.add(topping);
        } else {
            System.out.println("Maximum number of toppings reached.");
        }
    }

    /**
     * Returns a string representation of the Build Your Own pizza.
     * @return a string detailing the size, crust, toppings, and price
     */
    @Override
    public String toString() {
        return "Build Your Own Pizza [Size: " + size + ", Crust: " + crust + ", Toppings: " + toppings +
                ", Price: $" + String.format("%.2f", price()) + "]";
    }
}

