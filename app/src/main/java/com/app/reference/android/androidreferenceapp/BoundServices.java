package com.app.reference.android.androidreferenceapp;

import android.app.Service;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Binder;
import android.os.IBinder;

import java.util.Date;
import java.util.Locale;

public class BoundServices extends Service {

    private final IBinder binder = new LocalBinder();

    public BoundServices() {
    }

    public class LocalBinder extends Binder {
        BoundServices getService() {
            return BoundServices.this;
        }
    }

    public String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss", Locale.US);
        return dateFormat.format(new Date());
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
