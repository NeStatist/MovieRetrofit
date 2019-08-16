package com.example.movie.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.example.movie.R;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class PlayerActivity extends AppCompatActivity {

    private SimpleExoPlayer player;
    private PlayerView playerView;
    private  Uri uri;
    private boolean startAutoPlay;
    private long startPosition;
    private int startWindow;

    private static final String KEY_POSITION = "position";
    private static final String KEY_AUTO_PLAY = "auto_play";
    private static final String KEY_WINDOW = "window";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);


        player = ExoPlayerFactory.newSimpleInstance(getApplicationContext());

        playerView = findViewById(R.id.playerView);
        playerView.setPlayer(player);

        if (savedInstanceState != null) {

            startWindow = savedInstanceState.getInt(KEY_WINDOW);
            startAutoPlay = savedInstanceState.getBoolean(KEY_AUTO_PLAY);
            startPosition = savedInstanceState.getLong(KEY_POSITION);
        }

        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getApplicationContext(),
                Util.getUserAgent(getApplicationContext(), "Application"));
        uri = Uri.parse(getIntent().getStringExtra("series"));
        MediaSource videoSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uri);
        player.prepare(videoSource);

        boolean haveStartPosition = startWindow != C.INDEX_UNSET;
        if (haveStartPosition) {

            player.seekTo(startWindow, startPosition);

        }
        player.setPlayWhenReady(startAutoPlay);

    }
    private void updateStartPosition() {

        if (player != null) {

            startAutoPlay = player.getPlayWhenReady();
            startWindow = player.getCurrentWindowIndex();
            startPosition = Math.max(0, player.getCurrentPosition());
        }
    }

    private void releasePlayer() {
        if(player != null){
            updateStartPosition();
            player.stop();
            player.release();
            player = null;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        updateStartPosition();
        outState.putBoolean(KEY_AUTO_PLAY, startAutoPlay);
        outState.putInt(KEY_WINDOW, startWindow);
        outState.putLong(KEY_POSITION, startPosition);

    }

    protected void onPause() {
        player.setPlayWhenReady(false);
        super.onPause();
        releasePlayer();

    }

    protected void onResume() {
        player.setPlayWhenReady(true);
        super.onResume();

    }}
