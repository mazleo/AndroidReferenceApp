package com.app.reference.android.androidreferenceapp;

import android.app.admin.SystemUpdatePolicy;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThreadsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threads);

        Button buttonThreads = (Button) findViewById(R.id.buttonThreads);

        buttonThreads.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Thread thread = new Thread();

                Runnable runnableThreads = new Runnable() {
                    @Override
                    public void run() {
                        Context context = getApplicationContext();
                        Toast waitToast = Toast.makeText(context, "Timer finished", Toast.LENGTH_SHORT);
                        // threadStartTimer();
                        waitToast.show();
                    }
                };

                thread.start();
            }
        });
    }

    public void threadStartTimer() {
        long futureTime = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < futureTime) {}
    }
}
