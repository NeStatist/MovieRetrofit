package com.example.movie.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie.R;
import com.example.movie.model.tvseries.MovieResponse;

public class MovieAdapter extends ListAdapter<MovieResponse, MovieAdapter.SeasonsItemViewHolder> {

    private OnSeasonsListener onSeasonsGlobalListener;

    public interface OnSeasonsListener {
        void onSeasonClick(int id);
    }

    public MovieAdapter(OnSeasonsListener onSeasonsGlobalListener) {
        super(MovieResponse.DIFF_CALLBACK);
        this.onSeasonsGlobalListener = onSeasonsGlobalListener;
    }

    @NonNull
    @Override
    public SeasonsItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_recycler_seasons, parent, false);
        return new SeasonsItemViewHolder(view, onSeasonsGlobalListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SeasonsItemViewHolder holder, int position) {
        MovieResponse data = getItem(position);
        if(data != null) {
            holder.bindTo(data);
        }
    }

    protected static class SeasonsItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView poster;
        TextView seasonNum;
        TextView year;
        OnSeasonsListener onSeasonsLocalListener;

        public SeasonsItemViewHolder(View itemView, OnSeasonsListener onSeasonsListener) {
            super(itemView);
            poster = itemView.findViewById(R.id.imageRecyclerMain);
            seasonNum = itemView.findViewById(R.id.numSeasonRecycler);
            year = itemView.findViewById(R.id.yearSeasonRecycler);

            this.onSeasonsLocalListener = onSeasonsListener;
            itemView.setOnClickListener(this);
        }

        public void bindTo(MovieResponse data) {
            Glide.with(itemView.getContext()).load(data.getPoster()).into(poster);
            seasonNum.setText(data.getSeasonNumber());
            year.setText(data.getYear());
        }


        @Override
        public void onClick(View view) {
            onSeasonsLocalListener.onSeasonClick(getAdapterPosition());
        }
    }
}
