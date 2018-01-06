package com.example.cinemaapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Activity_movies extends AppCompatActivity {

    private static final String TAG="com.example.cinemaapp";
    ArrayList<MovieModel> movies=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        //get sent data
        Intent intent = getIntent();
        String cinema_id=intent.getStringExtra("cinema_id");
        String ciname_name=intent.getStringExtra("cinema_name");
        Log.i(TAG,cinema_id);
        //set the back (up) button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //set the title of this activity to be the street name
        getSupportActionBar().setTitle(ciname_name);

        //populate movies array list
        movies.add(
            new MovieModel(0, "movie0", "http://www.kino.kg/archive/ZOR/MovieBigPoster.jpg")
        );
        movies.add(
                new MovieModel(1, "movie1", "http://www.kino.kg/archive/ZOR/MovieBigPoster.jpg")
        );
        movies.add(
                new MovieModel(2, "movie2", "http://www.kino.kg/archive/ZOR/MovieBigPoster.jpg")
        );

        ListView list=(ListView) findViewById(R.id.moviesList);
        //create adapter
        MyAdapter adapter=new MyAdapter(this, movies);
        list.setAdapter(adapter);
        //add event listener so we can handle clicks
        AdapterView.OnItemClickListener adapterViewListener=new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MovieModel movie=movies.get(position);
                Intent intent=new Intent(Activity_movies.this, Activity_movie_detail.class);
                //send data to Activity_movie_detail
                intent.putExtra("movie_id", String.valueOf(movie.getId()));
                intent.putExtra("movie_title", String.valueOf(movie.getTitle()));

                startActivity(intent);
            }
        };
        //set the listener to the list view
        list.setOnItemClickListener(adapterViewListener);
    }

    class MyAdapter extends ArrayAdapter<MovieModel>{
        private final Context context;
        private final List<MovieModel> movies;

        public MyAdapter(Context context, ArrayList<MovieModel> objects) {
            super(context, -1, objects);
            this.context = context;
            this.movies = objects;
        }

        //called when rendering the list
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            //get the movie we are displaying
            MovieModel movie=movies.get(position);
            //get the inflater and inflate the XML layout for each item
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View item=inflater.inflate(R.layout.movie_item, parent, false);
            TextView title=(TextView) item.findViewById(R.id.txtMovieName);
            ImageView imageView=(ImageView) item.findViewById(R.id.imgMovie);
            title.setText(movie.getTitle());
            imageView.setImageResource(R.mipmap.ic_launcher);
            return item;
        }
    }
}
