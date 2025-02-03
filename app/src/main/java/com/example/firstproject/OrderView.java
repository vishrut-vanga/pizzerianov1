package com.example.firstproject;

import java.util.ArrayList;

import pizza.Order;


/**
 * This is used to create a list of the orders. An order is added each time after
 * the user submits one order after adding all of the pizzas.
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 *
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */
public class OrderView {
    private static OrderView instance;
    private ArrayList<Order> listOfOrders;

    private OrderView() {
        listOfOrders = new ArrayList<>();
    }

    public static OrderView getInstance() {
        if (instance == null) {
            instance = new OrderView();
        }
        return instance;
    }

    public ArrayList<Order> getCurrentList() {
        return listOfOrders;
    }

    public void addOrder(Order order) {
        listOfOrders.add(order);
    }
}
