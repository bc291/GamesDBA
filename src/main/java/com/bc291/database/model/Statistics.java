package com.bc291.database.model;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Statistics {
    @Id
    @GeneratedValue
    private long id;

    private long totalHoursPlayed;
    private long totalGames;
    private double averagePercentage;
    private String mostTimeSpend;
    private String highestRated;
    private String lowestRated;
    private String getPcGames;
    private String favouriteGames;

    public Statistics() { }


    public Statistics(long totalHoursPlayed, long totalGames, double averagePercentage, String mostTimeSpend, String highestRated, String lowestRated, String getPcGames, String favouriteGames) {
        this.totalHoursPlayed = totalHoursPlayed;
        this.totalGames = totalGames;
        this.averagePercentage = averagePercentage;
        this.mostTimeSpend = mostTimeSpend;
        this.highestRated = highestRated;
        this.lowestRated = lowestRated;
        this.getPcGames = getPcGames;
        this.favouriteGames=favouriteGames;
    }

    public String getFavouriteGames() {
        return favouriteGames;
    }

    public void setFavouriteGames(String favouriteGames) {
        this.favouriteGames = favouriteGames;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTotalHoursPlayed() {
        return totalHoursPlayed;
    }

    public void setTotalHoursPlayed(long totalHoursPlayed) {
        this.totalHoursPlayed = totalHoursPlayed;
    }

    public long getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(long totalGames) {
        this.totalGames = totalGames;
    }

    public double getAveragePercentage() {
        return averagePercentage;
    }

    public void setAveragePercentage(double averagePercentage) {
        this.averagePercentage = averagePercentage;
    }

    public String getMostTimeSpend() {
        return mostTimeSpend;
    }

    public void setMostTimeSpend(String mostTimeSpend) {
        this.mostTimeSpend = mostTimeSpend;
    }

    public String getHighestRated() {
        return highestRated;
    }

    public void setHighestRated(String highestRated) {
        this.highestRated = highestRated;
    }

    public String getLowestRated() {
        return lowestRated;
    }

    public void setLowestRated(String lowestRated) {
        this.lowestRated = lowestRated;
    }

    public String getGetPcGames() {
        return getPcGames;
    }

    public void setGetPcGames(String getPcGames) {
        this.getPcGames = getPcGames;
    }
}
