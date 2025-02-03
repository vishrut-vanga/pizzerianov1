package com.example.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import pizza.Pizza;

/**
 * This is the class that controls what actions are taken in the main page of the app
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 *
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PizzaOrder order = PizzaOrder.getInstance();
        ArrayList<Pizza> currentOrder = order.getCurrentOrder();
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button button1 = findViewById(R.id.button3);
        Button button2 = findViewById(R.id.button);
        Button viewOrder = findViewById(R.id.button6);
        Button listOrderView = findViewById(R.id.button7);
        // Set a click listener
        button1.setOnClickListener(v -> {
            Toast.makeText(this, "Button for clicked!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
        //Click listener for creating your own pizza
        button2.setOnClickListener(v -> {
            Toast.makeText(this, "Build your own pizza", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(intent);
        });
        //Listener to display list of pizzas in current order
        viewOrder.setOnClickListener(v -> {
            if(currentOrder.isEmpty()){
                Toast.makeText(this, "You have to order a pizza first!", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(MainActivity.this, View.class);
                startActivity(intent);
            }
        });
        //Listener to view all of the orders
        listOrderView.setOnClickListener(v -> {
            Toast.makeText(this, "Here is the list of orders right now", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, SubmitActivity.class);
            startActivity(intent);
        });
    }
}