package pizza;

import java.util.ArrayList;

/**
 * Abstract class representing a Pizza with toppings, crust, and size.
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 *
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */
public abstract class Pizza {
    protected ArrayList<Topping> toppings;
    protected Crust crust;
    protected Size size;

    /**
     * Constructor to initialize the Pizza.
     * @param crust the crust of the pizza
     * @param size the size of the pizza
     */
    public Pizza(Crust crust, Size size) {
        this.crust = crust;
        this.size = size;
        this.toppings = new ArrayList<>();
    }

    /**
     * Adds a topping to the pizza.
     * @param topping the topping to add
     */
    public void addTopping(Topping topping) {
        if (toppings.size() < 7) {
            toppings.add(topping);
        }
    }

    /**
     * Abstract method to calculate the price of the pizza.
     * @return the price of the pizza
     */
    public abstract double price();


    // Getters and Setters
    public Crust getCrust() {
        return crust;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder pizzaDetails = new StringBuilder();
        pizzaDetails.append("Size: ").append(size)
                .append(", Crust: ").append(crust)
                .append(", Toppings: ");

        if (toppings != null && !toppings.isEmpty()) {
            for (Topping topping : toppings) {
                pizzaDetails.append(topping).append(", ");
            }
        } else {
            pizzaDetails.append("No toppings");
        }

        return pizzaDetails.toString();
    }


    public ArrayList<Topping> getToppings() {
        return toppings;
    }
}

