package com.example.movie.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.movie.R;
import com.example.movie.adapter.SeriesAdapter;
import com.example.movie.callback.SeasonCallback;
import com.example.movie.model.season.SeasonResponse;
import com.example.movie.presenter.SeasonPresenter;

public class SeasonActivity extends AppCompatActivity implements SeasonCallback, SeriesAdapter.OnSeriesListener {

    private SeasonPresenter presenter;
    private SeriesAdapter adapter;
    private ImageView poster;
    private TextView genre;
    private TextView country;
    private TextView year;
    private TextView imdbRating;
    private TextView kinopoiskRating;
    private TextView description;
    private RecyclerView recyclerView;
    private SeasonResponse suppResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season);

        presenter = new SeasonPresenter(this);
        adapter = new SeriesAdapter(this);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        poster = findViewById(R.id.posterSeason);
        genre = findViewById(R.id.genreSeason);
        country = findViewById(R.id.сountrySeason);
        year = findViewById(R.id.yearSeason);
        imdbRating = findViewById(R.id.imbdSeason);
        kinopoiskRating = findViewById(R.id.kinopoiskSeason);
        description = findViewById(R.id.descriptionSeason);
        recyclerView = findViewById(R.id.recyclerViewSeason);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        presenter.getSeason(getIntent().getIntExtra("seasonNum", 0));
    }

    @Override
    public void onSeriesClick(int id) {
        openPlayerActivity(suppResponse.getPlaylist().get(id).getLink());
    }

    @Override
    public void success(SeasonResponse response) {
        adapter.submitList(response.getPlaylist());
        Glide.with(getApplicationContext()).load(response.getPoster()).into(poster);
        genre.setText("Жанр:  " + response.getGenre().get(0));
        country.setText("Страна: " + response.getCountry().get(0));
        year.setText("Год: " + response.getYear());
        imdbRating.setText("IMDB: " + response.getRating().getImdb().getRatio());
        kinopoiskRating.setText("КиноПоиск: " + response.getRating().getKinopoisk().getRatio());
        description.setText(response.getDescription());
        suppResponse = response;
    }

    @Override
    public void fail(Throwable throwable) {
        Log.e("Response", throwable.toString());
        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
    }

    public void openPlayerActivity(String link) {
        Intent intent = new Intent(SeasonActivity.this, PlayerActivity.class);
        intent.putExtra("series", link);
        startActivity(intent);
    }



}
