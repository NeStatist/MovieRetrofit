
package com.example.movie.model.tvseries;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("imdb")
    @Expose
    private Imdb imdb;
    @SerializedName("kinopoisk")
    @Expose
    private Kinopoisk kinopoisk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Imdb getImdb() {
        return imdb;
    }

    public void setImdb(Imdb imdb) {
        this.imdb = imdb;
    }

    public Kinopoisk getKinopoisk() {
        return kinopoisk;
    }

    public void setKinopoisk(Kinopoisk kinopoisk) {
        this.kinopoisk = kinopoisk;
    }

}
