package com.hostel9.android.food_emotion;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class FoodActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Bundle bundle = getIntent().getExtras();

        String personName = bundle.getString("PERSON_NAME");

        TextView greetingsTextView = (TextView)findViewById(R.id.greetings_text_view) ;
        greetingsTextView.setText("Hello " +personName + "!");

        final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Select an Emotion");
        categories.add("Angry");
        categories.add("Anxious");
        categories.add("Depressed");
        categories.add("Drowsy");
        categories.add("Hangover");
        categories.add("Happy");
        categories.add("PMS");
        categories.add("Stressed");
        categories.add("Tensed");




        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories){

            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        List<String> food = new ArrayList<String>();
        food.add("");
        food.add("Green Tea");
        food.add("Walnuts, Flax Seeds, Fish");
        food.add("Citrus Fruits, Banana, Broccoli");
        food.add("Coffee, Tea");
        food.add("Fresh Fruit Juice, Dates, Banana");
        food.add("Eat whatever you want");
        food.add("Egg Sandwich, Salads");
        food.add("Dark Chocolate, Hazelnut");
        food.add("Chocolates");

        List<String> effects = new ArrayList<String>();
        effects.add("");
        effects.add("Calm you & helps improve concentration");
        effects.add("Crubs stiffness of bones and joints");
        effects.add("Improves mood");
        effects.add("Improves alertness and relieves fatigue");
        effects.add("Fructose helps break down the toxins");
        effects.add("Please spread Happiness ;)");
        effects.add("Makes one feel good & relaxed");
        effects.add("Lowers the stress hormones cortisol & caecholamine");
        effects.add("Induces pleasant feeling");

        List<String> chemical = new ArrayList<String>();
        chemical.add("");
        chemical.add("Theanine");
        chemical.add("Omega 3 Fatty Acids");
        chemical.add("Folate");
        chemical.add("Caffeine");
        chemical.add("Fructose");
        chemical.add("Dopamine");
        chemical.add("Serotonin");
        chemical.add("Cortisol");
        chemical.add("Andamines");


        // Showing selected spinner item
        if(position > 0){
            // Notify the selected item text
            Toast.makeText
                    (getApplicationContext(), "Selected : " + item, Toast.LENGTH_SHORT)
                    .show();

            TextView foodTextView = (TextView) findViewById(R.id.food_id_text_view);
            TextView effectsTextView = (TextView) findViewById(R.id.effect_id_text_view);
            TextView chemicalTextView = (TextView) findViewById(R.id.chemical_id_text_view);

            String foodItem, effectItem, chemicalItem;
            foodItem = food.get(position);
            effectItem = effects.get(position);
            chemicalItem = chemical.get(position);

            foodTextView.setText(foodItem);

            effectsTextView.setText(effectItem);

            chemicalTextView.setText(chemicalItem);

        }

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

}
