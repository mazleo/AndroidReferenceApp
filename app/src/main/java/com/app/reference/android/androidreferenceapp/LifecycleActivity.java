package com.app.reference.android.androidreferenceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LifecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
    }
}
