package com.bc291.database.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private long id;
        private String title;
    private String creator;
    private String rating;
    private String genre;
    private String gamePlatform;
    private String imageUrl;
    private long hoursPlayed;
    private double playersRating;

    @Min(0)
    @Max(100)
    private double percentageCompleted;

    public Game() {}

    public Game(String title, String creator, String rating, String genre, String gamePlatform, String imageUrl, long hoursPlayed, double percentageCompleted, double playersRating) {
        this.title = title;
        this.creator = creator;
        this.rating = rating;
        this.genre = genre;
        this.gamePlatform = gamePlatform;
        this.imageUrl=imageUrl;
        this.hoursPlayed=hoursPlayed;
        this.percentageCompleted=percentageCompleted;
        this.playersRating=playersRating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGamePlatform() {
        return gamePlatform;
    }

    public void setGamePlatform(String gamePlatform) {
        this.gamePlatform = gamePlatform;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(long hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }

    public double getPercentageCompleted() {
        return percentageCompleted;
    }

    public void setPercentageCompleted(double percentageCompleted) {
        this.percentageCompleted = percentageCompleted;
    }

    public double getPlayersRating() {
        return playersRating;
    }

    public void setPlayersRating(double playersRating) {
        this.playersRating = playersRating;
    }

    @Override
    public String toString() {
        return getTitle()+" "+getGamePlatform()+" "+ getGenre()+" "+ getRating()+" "+ getTitle();
    }

    @Override
    public int hashCode() {
        return this.gamePlatform.length()*15+this.title.length()*10+4324;
    }

    @Override
    public boolean equals(Object game) {
        Game game2 = (Game) game;

        if(game==null || getClass()!=game.getClass()) return false;
        if(this.gamePlatform.contains(game2.gamePlatform) && this.title.equals(game2.title) && this.creator.contains(game2.creator)) return true;
            else return false;
    }
}
