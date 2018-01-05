package com.example.cinemaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Activity_movies extends AppCompatActivity {
    private static final String TAG="com.example.cinemaapp";
    String[] movies={"movie1", "movie2", "movie3", "movie4", "movie5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        String cinema_id=getIntent().getStringExtra("cinema_id");
        Log.i(TAG,cinema_id);

        ListView list=(ListView) findViewById(R.id.moviesList);

        //create adapter
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.movie_item, movies);

        list.setAdapter(adapter);
    }
}
