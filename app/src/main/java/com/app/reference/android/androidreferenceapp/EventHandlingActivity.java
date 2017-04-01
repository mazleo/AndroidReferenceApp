package com.app.reference.android.androidreferenceapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EventHandlingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_handling);

        Button buttonEventHandling = (Button) findViewById(R.id.buttonEventHandling);
        buttonEventHandling.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "SHORT CLICK!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        buttonEventHandling.setOnLongClickListener(new Button.OnLongClickListener() {
            public boolean onLongClick(View v) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "LONG CLICK!", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            }
        });
    }
}
