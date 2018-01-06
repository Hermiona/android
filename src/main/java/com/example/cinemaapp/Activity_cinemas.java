package com.example.cinemaapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity_cinemas extends AppCompatActivity  {
    private static final String TAG="com.example.cinemaapp";
    ArrayList<CinemaModel> cinemaList=new ArrayList<>();
    int[] colors = new int[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinemas);
        colors[0] = Color.parseColor("#559966CC");
        colors[1] = Color.parseColor("#55336699");

        cinemaList.add(new CinemaModel(0, "cinema0"));
        cinemaList.add(new CinemaModel(1, "cinema1"));
        cinemaList.add(new CinemaModel(2, "cinema2"));


        //linLayout is a layout for cinema list from activity_cinemas.xml
        LinearLayout linLayout=(LinearLayout) findViewById(R.id.linLayout);
        //create view for each cinema and append this view to linLayout
        LayoutInflater inflater=getLayoutInflater();
        CinemaModel cinema;
        for(int i=0; i<cinemaList.size(); i++){
            cinema=cinemaList.get(i);
            final String cinema_id=String.valueOf(cinema.getId());
            final String cinema_name=cinema.getName();
            View item=inflater.inflate(R.layout.cinema_item, linLayout, false);
            TextView cinemaName=(TextView) item.findViewById(R.id.txtCinemaName);
            TextView cinemaId=(TextView) item.findViewById(R.id.txtCinemaId);
            cinemaName.setText(cinema_name);
            cinemaId.setText(cinema_id);
            item.getLayoutParams().width= LayoutParams.MATCH_PARENT;
            item.setBackgroundColor(colors[i%2]);
            item.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Log.i(TAG, "layout clicked");
                    Intent intent=new Intent(Activity_cinemas.this, Activity_movies.class);
                    intent.putExtra("cinema_id", cinema_id);
                    intent.putExtra("cinema_name", cinema_name);
                    startActivity(intent);
                }
            });
            linLayout.addView(item);
        }
    }


}
