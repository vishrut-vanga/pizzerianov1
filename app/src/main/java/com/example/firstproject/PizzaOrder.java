package com.example.firstproject;

import java.util.ArrayList;

import pizza.Pizza;


/**
 * This class is to keep track of the pizzas in one order.
 * An array list of pizzas depict one order with multiple selections.
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 *
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */
public class PizzaOrder {
    private static PizzaOrder instance;
    private ArrayList<Pizza> currentOrder;

    private PizzaOrder() {
        currentOrder = new ArrayList<>();
    }

    public static PizzaOrder getInstance() {
        if (instance == null) {
            instance = new PizzaOrder();
        }
        return instance;
    }

    public ArrayList<Pizza> getCurrentOrder() {
        return currentOrder;
    }

    public void addPizza(Pizza pizza) {
        currentOrder.add(pizza);
    }
}
