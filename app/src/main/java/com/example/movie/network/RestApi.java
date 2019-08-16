package com.example.movie.network;

import com.example.movie.model.season.SeasonResponse;
import com.example.movie.model.tvseries.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApi {

    @GET("/movies/v2/getAll/{id}")
    Call<List<MovieResponse>> getTvSeries(@Path("id") int serialId);

    @GET("/season/v2/{id}")
    Call<SeasonResponse> getSeason(@Path("id") int seasonId);
}
