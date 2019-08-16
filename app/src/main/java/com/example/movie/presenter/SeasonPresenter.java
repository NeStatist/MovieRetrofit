package com.example.movie.presenter;

import com.example.movie.callback.SeasonCallback;
import com.example.movie.core.App;
import com.example.movie.model.season.SeasonResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeasonPresenter {

    private SeasonCallback callback;

    public SeasonPresenter(SeasonCallback callback) {
        this.callback = callback;
    }

    public void getSeason(int seasonId) {
        App.getInstance().getApi().getSeason(seasonId).enqueue(new Callback<SeasonResponse>() {
            @Override
            public void onResponse(Call<SeasonResponse> call, Response<SeasonResponse> response) {
                if(response.isSuccessful()) {
                    callback.success(response.body());
                } else {
                    callback.fail(new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Call<SeasonResponse> call, Throwable t) {
                callback.fail(t);
            }
        });
    }
}
