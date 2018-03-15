package com.bc291.database.jsons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AggregateRating {

    @SerializedName("@type")
    @Expose
    private String type;
    @SerializedName("ratingValue")
    @Expose
    private String ratingValue;
    @SerializedName("worstRating")
    @Expose
    private String worstRating;
    @SerializedName("bestRating")
    @Expose
    private String bestRating;
    @SerializedName("ratingCount")
    @Expose
    private String ratingCount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(String ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getWorstRating() {
        return worstRating;
    }

    public void setWorstRating(String worstRating) {
        this.worstRating = worstRating;
    }

    public String getBestRating() {
        return bestRating;
    }

    public void setBestRating(String bestRating) {
        this.bestRating = bestRating;
    }

    public String getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(String ratingCount) {
        this.ratingCount = ratingCount;
    }

}