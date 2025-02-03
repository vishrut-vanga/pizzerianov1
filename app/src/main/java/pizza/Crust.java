package pizza;

/**
 * Enum representing different types of pizza crust with descriptions.
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 *
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */
public enum Crust {
    DEEP_DISH("Thick and buttery crust, Chicago-style"),
    BROOKLYN("Thin and crispy crust, foldable slices"),
    PAN("Soft and fluffy crust, baked in a pan"),
    THIN("Crispy and light crust, New York-style"),
    STUFFED("Cheese-filled crust for extra indulgence"),
    HAND_TOSSED("Classic crust, hand-stretched for perfect texture");

    private final String description;

    /**
     * Constructor to associate a description with each crust type.
     * @param description the description of the crust
     */
    Crust(String description) {
        this.description = description;
    }

    /**
     * Gets the description of the crust.
     * @return the crust description
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
