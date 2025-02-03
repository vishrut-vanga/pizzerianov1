package com.example.firstproject;



import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import pizza.Order;
import pizza.Pizza;

/**
 * This class prints out the pizzas in the current order. The prices and
 * the details of all the pizzas will be displayed in a list view.
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */

public class View extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        ListView plv = findViewById(R.id.pizzaListView);
        PizzaOrder order = PizzaOrder.getInstance();
        ArrayList<Pizza> currentOrder = order.getCurrentOrder();
        ArrayAdapter<Pizza> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, currentOrder);
        plv.setAdapter(adapter);
        Button back = findViewById(R.id.button8);
        //Use this button to submit one whole order
        Button submit = findViewById(R.id.button9);
        back.setOnClickListener(v -> {
            finish();
        });
        submit.setOnClickListener(v -> {
            Order o = new Order();
            for(int i = 0;i < currentOrder.size();i++){
                o.addPizza(currentOrder.get(i));
            }
            OrderView orderView = OrderView.getInstance();
            orderView.addOrder(o);
            currentOrder.clear();
            adapter.notifyDataSetChanged();
        });
    }
}
