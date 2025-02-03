package com.example.firstproject;



import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import pizza.Order;


/**
 * The main purpose of this class is to list all of the orders
 * after the List of Orders button is clicked from the main screen.
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 *
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */

public class SubmitActivity extends AppCompatActivity {

    private ArrayList<Order> listoforders = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listorder_view);
        ListView orderlv = findViewById(R.id.orderListView);
        Button backtomain = findViewById(R.id.button10);
        backtomain.setOnClickListener(v -> {
            finish();
        });
        OrderView orders = OrderView.getInstance();
        listoforders = orders.getCurrentList();
        ArrayAdapter<Order> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listoforders);
        orderlv.setAdapter(adapter);
    }
}
