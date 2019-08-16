
package com.example.movie.model.tvseries;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Imdb {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ratio")
    @Expose
    private String ratio;
    @SerializedName("votes_count")
    @Expose
    private String votesCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getVotesCount() {
        return votesCount;
    }

    public void setVotesCount(String votesCount) {
        this.votesCount = votesCount;
    }

}
