package com.example.cinemaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_movie_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        //set the back (up) button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //find all our view components
        ImageView imgView=(ImageView) findViewById(R.id.image);
        TextView title=(TextView) findViewById(R.id.title);
        TextView genre=(TextView) findViewById(R.id.genre);
        TextView desc=(TextView) findViewById(R.id.description);

        //collect our intent and populate our layout
        Intent intent = getIntent();
        String movie_id=intent.getStringExtra("movie_id");
        String movie_title=intent.getStringExtra("movie_title");
        //set elements
        imgView.setImageResource(R.mipmap.ic_launcher);
        title.setText("movie");
        genre.setText("horror");
        desc.setText("desc");

        //set the title of this activity to be the street name
        getSupportActionBar().setTitle(movie_title);
    }
}
