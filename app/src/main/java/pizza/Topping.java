package pizza;

/**
 * Enum representing available toppings with descriptions and prices.
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 *
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */
public enum Topping {
    SAUSAGE("Savory sausage", 1.69),
    PEPPERONI("Classic pepperoni", 1.69),
    GREEN_PEPPER("Fresh green peppers", 1.69),
    ONION("Crisp onions", 1.69),
    MUSHROOM("Earthy mushrooms", 1.69),
    BBQ_CHICKEN("Tangy BBQ chicken", 1.99),
    PROVOLONE("Creamy provolone cheese", 1.69),
    CHEDDAR("Sharp cheddar cheese", 1.69),
    BEEF("Juicy beef", 1.69),
    HAM("Tender ham", 1.69),
    EXTRA_CHEESE("Extra cheesy goodness", 1.99);

    private final String description;
    private final double price;

    /**
     * Constructor to associate a description and price with each topping.
     * @param description the description of the topping
     * @param price the price of the topping
     */
    Topping(String description, double price) {
        this.description = description;
        this.price = price;
    }

    /**
     * Gets the description of the topping.
     * @return the topping description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the price of the topping.
     * @return the topping price
     */
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return description + " ($" + String.format("%.2f", price) + ")";
    }
}
