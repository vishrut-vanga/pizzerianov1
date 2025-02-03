package com.example.firstproject;


import static pizza.Size.LARGE;
import static pizza.Size.MEDIUM;
import static pizza.Size.SMALL;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import pizza.ChicagoPizza;
import pizza.NYPizza;
import pizza.Pizza;
import pizza.Size;

/**
 * This is the class that lets the user create a pizza that is not
 * build your own. The size, crust, and type are all used to create
 * a specific pizza of the user's choice. Radio groups are used
 * as well as alert dialogs to inform the user of the required
 * parameters to make the pizza.
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 *
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */

public class SecondActivity extends AppCompatActivity {

    private SimpleStringAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String> items = new ArrayList<>();
        items.add("Meatzza - Toppings: Sausage, pepperoni, beef, ham");
        items.add("BBQ Chicken - Toppings: BBQ Chicken, green pepper, provolone, cheddar");
        items.add("Deluxe - Toppings: Sausage, pepperoni, green pepper, onion, mushroom");
        adapter = new SimpleStringAdapter(items);
        recyclerView.setAdapter(adapter);
        RadioGroup radioGroup = findViewById(R.id.radioGroupForType);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedButton = findViewById(checkedId);
                String selected = selectedButton.getText().toString();
                Toast.makeText(SecondActivity.this, "Selected: "  +selected, Toast.LENGTH_SHORT).show();
            }
        });
        RadioGroup radioGroup1 = findViewById(R.id.radioGroupForCrust);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedButton = findViewById(checkedId);
                String selected = selectedButton.getText().toString();
                Toast.makeText(SecondActivity.this, "Selected: "  +selected, Toast.LENGTH_SHORT).show();
            }
        });
        RadioGroup radioGroup2 = findViewById(R.id.radioGroupForSize);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedButton = findViewById(checkedId);
                String selected = selectedButton.getText().toString();
                Toast.makeText(SecondActivity.this, "Selected: "  + selected, Toast.LENGTH_SHORT).show();
            }
        });
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            finish();
        });
        Button submitButton = findViewById(R.id.button2);
        submitButton.setOnClickListener(v -> {
            int selectedTypeId = radioGroup.getCheckedRadioButtonId();
            int selectedCrustId = radioGroup1.getCheckedRadioButtonId();
            int selectedSizeId = radioGroup2.getCheckedRadioButtonId();
            if (selectedTypeId == -1 || selectedCrustId == -1 || selectedSizeId == -1) {
                showAlertDialog();
            } else {
                RadioButton selectedType = findViewById(selectedTypeId);
                RadioButton selectedCrust = findViewById(selectedCrustId);
                RadioButton selectedSize = findViewById(selectedSizeId);
                String type = selectedType.getText().toString();
                String crust = selectedCrust.getText().toString();
                String size = selectedSize.getText().toString();
                Pizza pizza = null;
                Size s = null;
                if(crust.equals("NY Style Crust")){
                    switch (size){
                        case "Small":
                            s = SMALL;
                            break;
                        case "medium":
                            s = MEDIUM;
                            break;
                        case "Large":
                            s = LARGE;
                            break;
                        default:
                            showAlertDialog();
                    }
                    NYPizza nyPizza = new NYPizza();
                    switch (type){
                        case "Meatzza":
                            pizza = nyPizza.createMeatzza(s);
                            break;
                        case "BBQ Chicken":
                            pizza = nyPizza.createBBQChicken(s);
                            break;
                        case "Deluxe":
                            pizza = nyPizza.createDeluxe(s);
                            break;
                        default:
                            showAlertDialog();
                    }
                }else{
                    switch (size){
                        case "Small":
                            s = SMALL;
                            break;
                        case "medium":
                            s = MEDIUM;
                            break;
                        case "Large":
                            s = LARGE;
                            break;
                        default:
                            showAlertDialog();
                    }
                    ChicagoPizza chicagoPizza = new ChicagoPizza();
                    switch (type){
                        case "Meatzza":
                            pizza = chicagoPizza.createMeatzza(s);
                            break;
                        case "BBQ Chicken":
                            pizza = chicagoPizza.createBBQChicken(s);
                            break;
                        case "Deluxe":
                            pizza = chicagoPizza.createDeluxe(s);
                            break;
                        default:
                            showAlertDialog();
                    }
                }
                // Show confirmation
                //Have to somehow add this one pizza into the current order
                Toast.makeText(this, "Pizza Created: " + pizza, Toast.LENGTH_LONG).show();
                PizzaOrder.getInstance().addPizza(pizza);
            }
        });
    }
    // Method to show AlertDialog
    private void showAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Incomplete Selection")
                .setMessage("Please select an option for Type, Crust, and Size before submitting.")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
