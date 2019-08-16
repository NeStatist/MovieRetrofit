package com.example.movie.callback;

import com.example.movie.model.season.SeasonResponse;

public interface SeasonCallback {
    void success(SeasonResponse response);
    void fail(Throwable throwable);
}
