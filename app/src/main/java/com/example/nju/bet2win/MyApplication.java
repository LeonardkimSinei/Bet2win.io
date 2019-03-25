package com.example.nju.bet2win;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by nju on 7/15/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
