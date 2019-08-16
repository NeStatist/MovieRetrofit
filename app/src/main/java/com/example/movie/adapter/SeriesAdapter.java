package com.example.movie.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.R;
import com.example.movie.model.season.Playlist;

public class SeriesAdapter extends ListAdapter<Playlist, SeriesAdapter.SeriesItemViewHolder> {

    private OnSeriesListener onSeriesGlobalListener;

    public interface OnSeriesListener {
        void onSeriesClick(int id);
    }

    public SeriesAdapter(OnSeriesListener onSeriesGlobalListener) {
        super(Playlist.DIFF_CALLBACK);
        this.onSeriesGlobalListener = onSeriesGlobalListener;
    }

    @NonNull
    @Override
    public SeriesItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_recycler_movie, parent, false);
        return new SeriesItemViewHolder(view, onSeriesGlobalListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesItemViewHolder holder, int position) {
        Playlist data = getItem(position);
        if(data != null) {
            holder.bindTo(data);
        }
    }

    protected static class SeriesItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView series;
        OnSeriesListener onSeriesLocalListener;

        public SeriesItemViewHolder(View itemView, OnSeriesListener onSeriesListener) {
            super(itemView);
            series = itemView.findViewById(R.id.seasonRecycler);

            this.onSeriesLocalListener = onSeriesListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onSeriesLocalListener.onSeriesClick(getAdapterPosition());
        }

        public void bindTo(Playlist data) {
            String info = data.getName() + " " + data.getPerevod();
            series.setText(info);
        }
    }

}
