package com.app.reference.android.androidreferenceapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        final ListView listview = (ListView) findViewById(R.id.listview);
        String[] fruits = {
                "Apples",
                "Oranges",
                "Peaches",
                "Mangos"
        };
        ListAdapter listadapter = new ArrayAdapter<String>(ListviewActivity.this, android.R.layout.simple_list_item_1, fruits);

        listview.setAdapter(listadapter);
        listview.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String strItemClicked = String.valueOf(parent.getItemAtPosition(position));
                    Toast listviewToast = Toast.makeText(ListviewActivity.this, strItemClicked, Toast.LENGTH_SHORT);
                    listviewToast.show();
                }
            }
        );
    }
}
