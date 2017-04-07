package com.app.reference.android.androidreferenceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        Button buttonServices = (Button) findViewById(R.id.buttonServices);

        buttonServices.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentServices = new Intent(ServicesActivity.this, Services.class);
                startService(intentServices);
            }
        });
    }
}
