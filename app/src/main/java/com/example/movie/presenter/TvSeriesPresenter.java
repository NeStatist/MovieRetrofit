package com.example.movie.presenter;

import com.example.movie.callback.MovieCallback;
import com.example.movie.core.App;
import com.example.movie.model.tvseries.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvSeriesPresenter {
    private MovieCallback callback;

    public TvSeriesPresenter(MovieCallback callback) {
        this.callback = callback;
    }

    public void getTvSeries(int tvSeriesId) {
        App.getInstance().getApi().getTvSeries(tvSeriesId).enqueue(new Callback<List<MovieResponse>>() {
            @Override
            public void onResponse(Call<List<MovieResponse>> call, Response<List<MovieResponse>> response) {
                if(response.isSuccessful()) {
                    callback.success(response.body());
                } else {
                    callback.fail(new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Call<List<MovieResponse>> call, Throwable t) {
                callback.fail(t);
            }
        });

    }
}
