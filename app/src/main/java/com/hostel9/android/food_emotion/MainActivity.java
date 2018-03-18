package com.hostel9.android.food_emotion;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        button=(Button)findViewById(R.id.enter_button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText nameEditText = (EditText) findViewById(R.id.name_edit_text);
                String editTextValue = nameEditText.getText().toString();

                if(editTextValue.equals("")){
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter your name";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    Bundle bundle = new Bundle();
                    bundle.putString("PERSON_NAME", editTextValue);
                    Intent i = new Intent(getApplicationContext(), FoodActivity.class);
                    i.putExtras(bundle);
                    startActivity(i);
                }
            }
        });

    }
}
