package com.example.cinemaapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
        MyAdapter adapter=new MyAdapter(this, movies);
        list.setAdapter(adapter);
    }

    class MyAdapter extends ArrayAdapter<String>{
        private final Context context;
        private final String[] values;

        public MyAdapter(Context context, String[] values) {
            super(context, -1, values);
            this.context = context;
            this.values = values;
        }


        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View item=inflater.inflate(R.layout.movie_item, parent, false);
            TextView title=(TextView) item.findViewById(R.id.txtMovieName);
            ImageView imageView=(ImageView) item.findViewById(R.id.imgMovie);
            title.setText(values[position]);
            imageView.setImageResource(R.mipmap.ic_launcher);
            return item;
        }
    }
}
