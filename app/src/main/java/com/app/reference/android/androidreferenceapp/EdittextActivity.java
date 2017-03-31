package com.app.reference.android.androidreferenceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EdittextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);

        Button buttonMessageEnter = (Button) findViewById(R.id.buttonMessageEnter);
        buttonMessageEnter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText edittextMessage = (EditText) findViewById(R.id.edittextMessage);
                String strMessage = edittextMessage.getText().toString();
                Intent edittextIntent = new Intent(EdittextActivity.this, EdittextDisplayMessage.class);

                edittextIntent.putExtra("EDITTEXT_MESSAGE", strMessage);
                startActivity(edittextIntent);
            }
        });
    }
}
