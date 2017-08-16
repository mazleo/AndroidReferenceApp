package com.app.reference.android.androidreferenceapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {

    private Button alertDialogButton;
    private AlertDialog.Builder alertDialogBuilder;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        alertDialogButton = (Button) findViewById(R.id.alertDialogButton);
        alertDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show dialog
                alertDialogBuilder = new AlertDialog.Builder(AlertDialogActivity.this);

                // Setup title
                alertDialogBuilder.setTitle(R.string.alert_dialog_title);

                // Setup message
                alertDialogBuilder.setMessage(R.string.alert_dialog_message);

                // Set cancelable
                alertDialogBuilder.setCancelable(true);

                // Set positive button
                alertDialogBuilder.setPositiveButton(R.string.alert_dialog_positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = Toast.makeText(AlertDialogActivity.this, "Yes", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                // Set negative button
                alertDialogBuilder.setNegativeButton(R.string.alert_dialog_negative, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = Toast.makeText(AlertDialogActivity.this, "No", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                // Create alert dialog
                alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }
}
