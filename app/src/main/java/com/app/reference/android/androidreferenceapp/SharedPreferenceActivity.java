package com.app.reference.android.androidreferenceapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashSet;
import java.util.Set;

public class SharedPreferenceActivity extends AppCompatActivity {

    private EditText spEditText;
    private Button spButton;
    private TextView spTextView;
    private SharedPreferences sharedPreferences;
    private static final String SP_FILE = "spFile";
    String[] messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        initSetup();

        sharedPreferences = getSharedPreferences(SP_FILE, 0);
        if (sharedPreferences.contains("message")) {
            spTextView.setText(sharedPreferences.getString("message", "Not Found"));
        }

        spButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!spEditText.getText().toString().equals("")) {
                    sharedPreferences = getSharedPreferences(SP_FILE, 0);
                    SharedPreferences.Editor spEditor = sharedPreferences.edit();

                    spEditor.putString("message", spEditText.getText().toString());
                    spEditor.commit();
                }
            }
        });
    }

    private void initSetup() {
        spEditText = (EditText) findViewById(R.id.spEditText);
        spButton = (Button) findViewById(R.id.spButton);
        spTextView = (TextView) findViewById(R.id.spTextView);
    }
}
