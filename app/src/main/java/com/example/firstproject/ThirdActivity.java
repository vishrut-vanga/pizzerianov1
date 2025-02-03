package com.example.firstproject;

import static pizza.Size.LARGE;
import static pizza.Size.MEDIUM;
import static pizza.Size.SMALL;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.databinding.ObservableArrayList;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import java.util.ArrayList;

import pizza.BuildYourOwn;
import pizza.Crust;
import pizza.Pizza;
import pizza.Size;
import pizza.Topping;

/**
 * This is for the user to create a build your own
 * pizza. If more than seven toppings are selected,
 * the pizza will not be created, else the pizza will
 * be created based on the crust and size parameters given.
 */
/**
 * This class is part of the RU Pizzeria project.
 * It was developed by the following authors:
 *
 * Authors:
 *  Tulsi Patel
 *  Vishrut Vanga
 */


public class ThirdActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        RadioGroup rgCrust = findViewById(R.id.radioGroupForbyocrust);
        RadioGroup rgSize = findViewById(R.id.radioGroupForbyosize);
        ListView listView1 = findViewById(R.id.toppingsList);
        // Sample data for ListView
        ObservableArrayList<String> list = new ObservableArrayList<>();
        String[] toppings = {"Sausage", "Pepperoni", "Green Peppers", "Onion",
                "Mushrooms", "BBQ Chicken", "Provolone", "Cheddar", "Beef", "Ham"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_multiple_choice,
                toppings
        );
        listView1.setAdapter(adapter);
        listView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //I have to set an on click listener over here for the topping elements
        rgCrust.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedButton = findViewById(checkedId);
                String selected = selectedButton.getText().toString();}
        });
        rgSize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedButton = findViewById(checkedId);
                String selected1 = selectedButton.getText().toString();}
        });
        Button add = findViewById(R.id.button5);
        add.setOnClickListener(v -> {
            int selectedCrustId = rgCrust.getCheckedRadioButtonId();
            int selectedSizeId = rgSize.getCheckedRadioButtonId();
            if (selectedCrustId == -1 || selectedSizeId == -1) {
                showAlertDialog();
            }else{
                RadioButton selectedSize = findViewById(selectedSizeId);
                RadioButton selectedCrust = findViewById(selectedCrustId);
                String ss = selectedSize.getText().toString();
                String sc = selectedCrust.getText().toString();
                Pizza p;
                Size s = null;
                if(sc.equals("Pan")){
                    switch (ss){
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
                    BuildYourOwn p1 = new BuildYourOwn(Crust.PAN, s);
                    p = p1;
                    //"Sausage", "Pepperoni", "Green Peppers", "Onion",
                    //        "Mushrooms", "BBQ Chicken", "Provolone", "Cheddar", "Beef", "Ham"
                    ArrayList<String> selectedToppings = new ArrayList<>();
                    for (int i = 0; i < listView1.getCount(); i++) {
                        if (listView1.isItemChecked(i)) {
                            // Add selected topping to the list
                            selectedToppings.add((String) listView1.getItemAtPosition(i));
                        }
                    }
                    // Add selected toppings to the pizza
                    //"Sausage", "Pepperoni", "Green Peppers", "Onion",
                    //        "Mushrooms", "BBQ Chicken", "Provolone", "Cheddar", "Beef", "Ham"
                    for (String topping : selectedToppings) {
                        switch (topping){
                            case "Sausage":
                                p.addTopping(Topping.SAUSAGE);
                                break;
                            case "Pepperoni":
                                p.addTopping(Topping.PEPPERONI);
                                break;
                            case "Green Peppers":
                                p.addTopping(Topping.GREEN_PEPPER);
                                break;
                            case "Onion":
                                p.addTopping(Topping.ONION);
                                break;
                            case "Mushrooms":
                                p.addTopping(Topping.MUSHROOM);
                                break;
                            case "BBQ Chicken":
                                p.addTopping(Topping.BBQ_CHICKEN);
                                break;
                            case "Provolone":
                                p.addTopping(Topping.PROVOLONE);
                                break;
                            case "Cheddar":
                                p.addTopping(Topping.CHEDDAR);
                                break;
                            case "Beef":
                                p.addTopping(Topping.BEEF);
                                break;
                            case "Ham":
                                p.addTopping(Topping.HAM);
                                break;
                            default:
                                Toast.makeText(this, "Please enter toppings", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                    Toast.makeText(this, "Pizza Created: " + p, Toast.LENGTH_LONG).show();
                    PizzaOrder.getInstance().addPizza(p);
                }else{
                    switch (ss){
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
                    BuildYourOwn p1 = new BuildYourOwn(Crust.HAND_TOSSED, s);
                    p = p1;
                    ArrayList<String> selectedToppings = new ArrayList<>();
                    for (int i = 0; i < listView1.getCount(); i++) {
                        if (listView1.isItemChecked(i)) {
                            // Add selected topping to the list
                            selectedToppings.add((String) listView1.getItemAtPosition(i));
                        }
                    }
                    // Add selected toppings to the pizza
                    //"Sausage", "Pepperoni", "Green Peppers", "Onion",
                    //        "Mushrooms", "BBQ Chicken", "Provolone", "Cheddar", "Beef", "Ham"
                    for (String topping : selectedToppings) {
                        switch (topping){
                            case "Sausage":
                                p.addTopping(Topping.SAUSAGE);
                                break;
                            case "Pepperoni":
                                p.addTopping(Topping.PEPPERONI);
                                break;
                            case "Green Peppers":
                                p.addTopping(Topping.GREEN_PEPPER);
                                break;
                            case "Onion":
                                p.addTopping(Topping.ONION);
                                break;
                            case "Mushrooms":
                                p.addTopping(Topping.MUSHROOM);
                                break;
                            case "BBQ Chicken":
                                p.addTopping(Topping.BBQ_CHICKEN);
                                break;
                            case "Provolone":
                                p.addTopping(Topping.PROVOLONE);
                                break;
                            case "Cheddar":
                                p.addTopping(Topping.CHEDDAR);
                                break;
                            case "Beef":
                                p.addTopping(Topping.BEEF);
                                break;
                            case "Ham":
                                p.addTopping(Topping.HAM);
                                break;
                            default:
                                Toast.makeText(this, "Please enter toppings", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                    Toast.makeText(this, "Pizza Created: " + p, Toast.LENGTH_LONG).show();
                    PizzaOrder.getInstance().addPizza(p);
                }
            }
            }
        );
        Button back = findViewById(R.id.button4);
        back.setOnClickListener(v -> {
            finish();
        });
    }
    private void showAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Incomplete Selection")
                .setMessage("Please select an option for Crust, and Size before submitting.")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
