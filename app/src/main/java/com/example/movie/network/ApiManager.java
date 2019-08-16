package com.example.movie.network;

import com.example.movie.model.season.SeasonResponse;
import com.example.movie.model.tvseries.MovieResponse;

import java.util.List;

import retrofit2.Call;

public class ApiManager implements RestApi {

    private RestApi api;

    public ApiManager() {
        api = NetManager.getInstance().getRestApi();
    }

    @Override
    public Call<List<MovieResponse>> getTvSeries(int serialId) {
        return api.getTvSeries(serialId);
    }

    @Override
    public Call<SeasonResponse> getSeason(int seasonId) {
        return api.getSeason(seasonId);
    }
}
