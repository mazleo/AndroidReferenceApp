package com.app.reference.android.androidreferenceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EdittextDisplayMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext_display_message);

        Intent edittextIntent = getIntent();
        String strMessage = edittextIntent.getStringExtra("EDITTEXT_MESSAGE");

        TextView textviewDisplay = (TextView) findViewById(R.id.textviewDisplay);
        textviewDisplay.setText(strMessage);
    }
}
