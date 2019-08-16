package com.example.movie.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.movie.R;
import com.example.movie.adapter.MovieAdapter;
import com.example.movie.callback.MovieCallback;
import com.example.movie.model.tvseries.MovieResponse;
import com.example.movie.presenter.TvSeriesPresenter;

import java.util.List;

public class MovieActivity extends AppCompatActivity implements MovieCallback, MovieAdapter.OnSeasonsListener {

    private TvSeriesPresenter presenter;
    private MovieAdapter movieAdapter;
    private ImageView imageView;
    private TextView imdb;
    private TextView kinopoisk;
    private TextView genre;
    private TextView country;
    private TextView year;
    private TextView seasonsAmount;
    private TextView description;
    private RecyclerView recyclerView;
    private List<MovieResponse> list;
    private String intSeasonAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        presenter = new TvSeriesPresenter(this);
        movieAdapter = new MovieAdapter(this);

        imageView = findViewById(R.id.posterMovie);
        genre = findViewById(R.id.genre);
        country = findViewById(R.id.country);
        year = findViewById(R.id.year);
        seasonsAmount = findViewById(R.id.season);
        imdb = findViewById(R.id.imbd);
        kinopoisk = findViewById(R.id.kinopoisk);
        description = findViewById(R.id.description);
        recyclerView = findViewById(R.id.recyclerViewMain);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(movieAdapter);

        presenter.getTvSeries(9099);
    }

    @Override
    public void onSeasonClick(int id) {
        openSeasonActivity(list.get(id).getId());
    }

    @Override
    public void success(List<MovieResponse> response) {
        movieAdapter.submitList(response);
        Glide.with(getApplicationContext()).load(response.get(0).getPoster()).into(imageView);
        genre.setText("Жанр: " + response.get(0).getGenre().get(0));
        country.setText("Страна: " + response.get(0).getCountry().get(0));
        year.setText("Год: " + response.get(0).getYear());
        seasonsAmount.setText("Сезонов: " + response.get(response.size()-1).getSeasonNumber());
        imdb.setText("IMDB: " + response.get(0).getRating().getImdb().getRatio());
        kinopoisk.setText("КиноПоиск: " + response.get(0).getRating().getKinopoisk().getRatio());
        description.setText("Описание; " + response.get(0).getDescription());
        list = response;
        intSeasonAmount = response.get(response.size()-1).getSeasonNumber();
    }

    @Override
    public void fail(Throwable throwable) {
        Log.e("Response", throwable.toString());
        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
    }

    public void openSeasonActivity(int id) {
        Intent intent = new Intent(MovieActivity.this, SeasonActivity.class);
        intent.putExtra("seasonNum", id);
        intent.putExtra("seasonAmount", intSeasonAmount);
        startActivity(intent);
    }


}
