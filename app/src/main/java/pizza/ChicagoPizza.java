package pizza;

/**
 * Factory class for creating Chicago-style pizzas.
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 *
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */
public class ChicagoPizza implements PizzaFactory {

    /**
     * Creates a Chicago-style Deluxe pizza.
     * @param size the size of the pizza
     * @return a Deluxe pizza with Deep Dish crust
     */
    @Override
    public Pizza createDeluxe(Size size) {
        Pizza pizza = new Deluxe(size);
        pizza.crust = Crust.DEEP_DISH; // Chicago-specific crust
        return pizza;
    }

    /**
     * Creates a Chicago-style BBQ Chicken pizza.
     * @param size the size of the pizza
     * @return a BBQ Chicken pizza with Pan crust
     */
    @Override
    public Pizza createBBQChicken(Size size) {
        Pizza pizza = new BBQChicken(size);
        pizza.crust = Crust.PAN; // Chicago-specific crust
        return pizza;
    }

    /**
     * Creates a Chicago-style Meatzza pizza.
     * @param size the size of the pizza
     * @return a Meatzza pizza with Stuffed crust
     */
    @Override
    public Pizza createMeatzza(Size size) {
        Pizza pizza = new Meatzza(size);
        pizza.crust = Crust.STUFFED; // Chicago-specific crust
        return pizza;
    }

    /**
     * Creates a Chicago-style Build Your Own pizza.
     * @param size the size of the pizza
     * @return a Build Your Own pizza with Pan crust
     */
    @Override
    public Pizza createBuildYourOwn(Size size) {
        return new BuildYourOwn(Crust.PAN, size); // Chicago-specific crust
    }
}
