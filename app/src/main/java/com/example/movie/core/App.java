package com.example.movie.core;

import android.app.Application;

import com.example.movie.network.ApiManager;
import com.example.movie.network.RestApi;

public class App extends Application {
    private RestApi mApi;
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mApi = new ApiManager();
    }

    public RestApi getApi() {
        return mApi;
    }

    public static App getInstance() {
        return instance;
    }
}
