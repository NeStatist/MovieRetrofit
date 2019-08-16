
package com.example.movie.model.tvseries;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieResponse {

    @SerializedName("poster")
    @Expose
    private String poster;
    @SerializedName("poster_small")
    @Expose
    private String posterSmall;
    @SerializedName("season_number")
    @Expose
    private String seasonNumber;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_original")
    @Expose
    private String nameOriginal;
    @SerializedName("name_alternative")
    @Expose
    private List<String> nameAlternative = null;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("genre")
    @Expose
    private List<String> genre = null;
    @SerializedName("country")
    @Expose
    private List<String> country = null;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("rating")
    @Expose
    private Rating rating;
    @SerializedName("id")
    @Expose
    private Integer id;

    public static DiffUtil.ItemCallback<MovieResponse> DIFF_CALLBACK = new DiffUtil.ItemCallback<MovieResponse>() {
        @Override
        public boolean areItemsTheSame(@NonNull MovieResponse oldItem, @NonNull MovieResponse newItem) {
            return oldItem.id.equals(newItem.id);
        }

        @Override
        public boolean areContentsTheSame(@NonNull MovieResponse oldItem, @NonNull MovieResponse newItem) {
            return oldItem.equals(newItem);
        }
    };

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        MovieResponse response = (MovieResponse) obj;
        return response.poster.equals(this.poster) && response.posterSmall.equals(this.posterSmall)
                && response.seasonNumber.equals(this.seasonNumber) && response.name.equals(this.name)
                && response.nameOriginal.equals(this.nameOriginal) && response.nameAlternative.equals(this.nameAlternative)
                && response.year.equals(this.year) && response.genre.equals(this.genre) && response.country.equals(this.country)
                && response.description.equals(this.description) && response.rating.equals(this.rating) && response.id.equals(this.id);
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPosterSmall() {
        return posterSmall;
    }

    public void setPosterSmall(String posterSmall) {
        this.posterSmall = posterSmall;
    }

    public String getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(String seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOriginal() {
        return nameOriginal;
    }

    public void setNameOriginal(String nameOriginal) {
        this.nameOriginal = nameOriginal;
    }

    public List<String> getNameAlternative() {
        return nameAlternative;
    }

    public void setNameAlternative(List<String> nameAlternative) {
        this.nameAlternative = nameAlternative;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public List<String> getCountry() {
        return country;
    }

    public void setCountry(List<String> country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
