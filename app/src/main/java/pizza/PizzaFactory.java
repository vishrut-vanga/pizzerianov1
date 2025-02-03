package pizza;

/**
 * Factory interface for creating pizzas.
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 *
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */
public interface PizzaFactory {
    Pizza createDeluxe(Size size);
    Pizza createBBQChicken(Size size);
    Pizza createMeatzza(Size size);
    Pizza createBuildYourOwn(Size size);
}
