package com.app.reference.android.androidreferenceapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinnerMainEnter = (Spinner) findViewById(R.id.spinnerRefChoice);
        ArrayAdapter<CharSequence> adapterRefChoice = ArrayAdapter.createFromResource(this, R.array.spinner_ref_choice, android.R.layout.simple_spinner_item);
        adapterRefChoice.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMainEnter.setAdapter(adapterRefChoice);

        Button buttonMainEnter = (Button) findViewById(R.id.buttonMainEnter);
        buttonMainEnter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String strSelectedItem = spinnerMainEnter.getSelectedItem().toString();

                if (strSelectedItem.equals("TextView")) {
                    Intent intentMainAct = new Intent(MainActivity.this, TextviewActivity.class);
                    startActivity(intentMainAct);
                }
                else if (strSelectedItem.equals("EditText")) {
                    Intent intentMainAct = new Intent(MainActivity.this, EdittextActivity.class);
                    startActivity(intentMainAct);
                }
                else if (strSelectedItem.equals("Event Handling")) {
                    Intent intentMainAct = new Intent(MainActivity.this, EventHandlingActivity.class);
                    startActivity(intentMainAct);
                }
                else if (strSelectedItem.equals("Scrolling")) {
                    Intent intentMainAct = new Intent(MainActivity.this, ScrollingActivity.class);
                    startActivity(intentMainAct);
                }
                else if (strSelectedItem.equals("Gestures")) {
                    Intent intentMainAct = new Intent(MainActivity.this, GestureActivity.class);
                    startActivity(intentMainAct);
                }
            }
        });
    }

}
