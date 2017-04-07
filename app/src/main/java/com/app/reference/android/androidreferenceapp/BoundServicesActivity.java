package com.app.reference.android.androidreferenceapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.reference.android.androidreferenceapp.BoundServices.LocalBinder;

public class BoundServicesActivity extends AppCompatActivity {

    BoundServices boundServices;
    boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_services);

        Button buttonBoundServices = (Button) findViewById(R.id.buttonBoundServices);
        Intent intentBoundServices = new Intent(BoundServicesActivity.this, BoundServices.class);
        bindService(intentBoundServices, serviceConnection, Context.BIND_AUTO_CREATE);

        buttonBoundServices.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String currentTime = boundServices.getCurrentTime();
                TextView textviewBoundServices = (TextView) findViewById(R.id.textviewBoundServices);
                textviewBoundServices.setText(currentTime);
            }
        });
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LocalBinder localBinder = (LocalBinder) service;
            boundServices = localBinder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
}
