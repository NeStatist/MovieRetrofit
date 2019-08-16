
package com.example.movie.model.season;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Playlist {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("perevod")
    @Expose
    private String perevod;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("subtitles")
    @Expose
    private Object subtitles;

    public static DiffUtil.ItemCallback<Playlist> DIFF_CALLBACK = new DiffUtil.ItemCallback<Playlist>() {
        @Override
        public boolean areItemsTheSame(@NonNull Playlist oldItem, @NonNull Playlist newItem) {
            return oldItem.id.equals(newItem.id);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Playlist oldItem, @NonNull Playlist newItem) {
            return oldItem.equals(newItem);
        }
    };

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        Playlist playlist = (Playlist) obj;
        return playlist.id.equals(this.id) && playlist.name.equals(this.name)
                && playlist.perevod.equals(this.perevod) && playlist.link.equals(this.link)
                && playlist.subtitles.equals(this.subtitles);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerevod() {
        return perevod;
    }

    public void setPerevod(String perevod) {
        this.perevod = perevod;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Object getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(Object subtitles) {
        this.subtitles = subtitles;
    }

}
