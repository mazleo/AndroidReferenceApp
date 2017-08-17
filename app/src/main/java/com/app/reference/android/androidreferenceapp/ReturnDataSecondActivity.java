package com.app.reference.android.androidreferenceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReturnDataSecondActivity extends AppCompatActivity {

    private EditText returnDataMessage;
    private Button returnDataSecondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_data_second);

        returnDataMessage = (EditText) findViewById(R.id.returnDataMessage);
        returnDataSecondButton = (Button) findViewById(R.id.returnDataSecondButton);

        returnDataSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = null;
                Intent intent = null;

                message = returnDataMessage.getText().toString();
                intent = getIntent();

                intent.putExtra("RETURN_DATA_MESSAGE", message);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
