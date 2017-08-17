package com.app.reference.android.androidreferenceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapters.RecyclerViewAdapter;
import Models.RecyclerViewItem;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<RecyclerViewItem> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter rcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView.LayoutManager rcLayoutManager;

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        rcAdapter = new RecyclerViewAdapter(list);
        rcLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(rcLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(rcAdapter);

        for (int i = 0; i < 10; i++) {
            RecyclerViewItem rcItem = new RecyclerViewItem("Item " + (i + 1), "Description " + (i + 1));
            list.add(rcItem);
        }

        rcAdapter.notifyDataSetChanged();
    }
}
