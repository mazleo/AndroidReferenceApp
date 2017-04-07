package com.app.reference.android.androidreferenceapp;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class Services extends IntentService {

    private static final String TAG = "com.app.reference.android.androidreferenceapp";
    public Services() {
        super("Services");
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG, "The service has started.");
    }
}
