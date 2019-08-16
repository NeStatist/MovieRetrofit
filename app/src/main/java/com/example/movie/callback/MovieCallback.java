package com.example.movie.callback;

import com.example.movie.model.tvseries.MovieResponse;

import java.util.List;

public interface MovieCallback {
    void success(List<MovieResponse> response);
    void fail(Throwable throwable);
}
