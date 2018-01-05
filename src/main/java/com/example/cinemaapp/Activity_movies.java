package com.example.cinemaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Activity_movies extends AppCompatActivity {
    private static final String TAG="com.example.cinemaapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        String cinema_id=getIntent().getStringExtra("cinema_id");
        Log.i(TAG,cinema_id);
    }
}
