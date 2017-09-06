package com.app.reference.android.androidreferenceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import Data.DatabaseHandler;
import Models.Contact;

public class SqliteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        DatabaseHandler db = new DatabaseHandler(this);

        // Insert contacts
        Log.d("Insert: ", "Inserting...");
        db.addContact(new Contact("Jonnelin", "(908)-546-8332"));
        db.addContact(new Contact("Jhon", "(908)-361-5261"));

        // Retrieve contacts
        Log.d("Reading: ", "Reading all contacts...");
        List<Contact> contactList = db.getAllContacts();

        for (Contact c : contactList) {
            String log = "ID: " + c.getId() + ", NAME: " + c.getName() + ", PHONE NUMBER: " + c.getPhoneNumber();
            Log.d("Reading", log);
        }
    }
}
