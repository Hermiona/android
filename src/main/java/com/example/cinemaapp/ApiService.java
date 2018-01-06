package com.example.cinemaapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ASUS on 06.01.2018.
 */

public interface ApiService {
    @GET("cinemas")
    Call<List<CinemaModel>> getCinemas();

    @GET("films")
    Call<List<MovieModel>> getMovies();

    @GET("film/{id}")
    Call<List<MovieModel>> getMovie(@Path("id") int id);
}
