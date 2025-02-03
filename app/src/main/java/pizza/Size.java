package pizza;

/**
 * Enum representing pizza sizes with descriptions.
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 *
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */
public enum Size {
    SMALL("Small (10 inches)"),
    MEDIUM("Medium (12 inches)"),
    LARGE("Large (14 inches)");

    private final String description;

    /**
     * Constructor to associate a description with each size.
     * @param description the description of the size
     */
    Size(String description) {
        this.description = description;
    }

    /**
     * Gets the description of the size.
     * @return the size description
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
