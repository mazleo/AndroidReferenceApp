package com.app.reference.android.androidreferenceapp;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class OverflowMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overflow_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView textviewOverflowMenu = (TextView) findViewById(R.id.textviewOverflowMenu);
        ConstraintLayout constraintLayoutOverflowMenu = (ConstraintLayout) findViewById(R.id.constraintLayoutOverflowMenu);
        String color = item.toString();

        switch (color) {
            case "Red":
                constraintLayoutOverflowMenu.setBackgroundColor(Color.RED);
                break;
            case "Blue":
                constraintLayoutOverflowMenu.setBackgroundColor(Color.BLUE);
                break;
            case "Green":
                constraintLayoutOverflowMenu.setBackgroundColor(Color.GREEN);
                break;
            default:
                constraintLayoutOverflowMenu.setBackgroundColor(Color.WHITE);
                break;
        }
        textviewOverflowMenu.setText(color);

        return true;
    }
}
