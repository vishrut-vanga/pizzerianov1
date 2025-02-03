package pizza;

/**
 * Factory class for creating New York-style pizzas.
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 *
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */
public class NYPizza implements PizzaFactory {

    /**
     * Creates a New York-style Deluxe pizza.
     * @param size the size of the pizza
     * @return a Deluxe pizza with Brooklyn crust
     */
    @Override
    public Pizza createDeluxe(Size size) {
        Pizza deluxePizza = new Deluxe(size);
        deluxePizza.crust = Crust.BROOKLYN; // Set to New York-style crust for Deluxe
        return deluxePizza;
    }

    /**
     * Creates a New York-style BBQ Chicken pizza.
     * @param size the size of the pizza
     * @return a BBQ Chicken pizza with Thin crust
     */
    @Override
    public Pizza createBBQChicken(Size size) {
        Pizza bbqPizza = new BBQChicken(size);
        bbqPizza.crust = Crust.THIN; // Set to New York-style crust for BBQ Chicken
        return bbqPizza;
    }

    /**
     * Creates a New York-style Meatzza pizza.
     * @param size the size of the pizza
     * @return a Meatzza pizza with Hand-tossed crust
     */
    @Override
    public Pizza createMeatzza(Size size) {
        Pizza meatzzaPizza = new Meatzza(size);
        meatzzaPizza.crust = Crust.HAND_TOSSED; // Set to New York-style crust for Meatzza
        return meatzzaPizza;
    }

    /**
     * Creates a New York-style Build Your Own pizza.
     * @param size the size of the pizza
     * @return a Build Your Own pizza with Hand-tossed crust
     */
    @Override
    public Pizza createBuildYourOwn(Size size) {
        return new BuildYourOwn(Crust.HAND_TOSSED, size); // New York-style crust
    }
}
