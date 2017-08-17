package com.app.reference.android.androidreferenceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReturnDataActivity extends AppCompatActivity {

    private TextView returnDataText;
    private Button nextActivityButton;
    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_data);

        nextActivityButton = (Button) findViewById(R.id.nextActivityButton);
        nextActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(ReturnDataActivity.this, ReturnDataSecondActivity.class), REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String message = null;

                returnDataText = (TextView) findViewById(R.id.returnDataText);
                message = data.getStringExtra("RETURN_DATA_MESSAGE");

                returnDataText.setText(message);

            }
        }
    }
}
