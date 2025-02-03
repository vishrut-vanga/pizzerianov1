package pizza;

/**
 * Deluxe pizza with specific toppings and price calculation.
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 *
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */
public class Deluxe extends Pizza {

    public Deluxe(Size size) {
        super(Crust.DEEP_DISH, size);  // Chicago-style default
        addTopping(Topping.SAUSAGE);
        addTopping(Topping.PEPPERONI);
        addTopping(Topping.GREEN_PEPPER);
        addTopping(Topping.ONION);
        addTopping(Topping.MUSHROOM);
    }

    @Override
    public double price() {
        switch (getSize()) {
            case SMALL:
                return 16.99;
            case MEDIUM:
                return 18.99;
            case LARGE:
                return 20.99;
            default:
                return 0;
        }
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
