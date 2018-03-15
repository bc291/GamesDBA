package com.bc291.database.controller;

import com.bc291.database.model.Game;
import com.bc291.database.model.Statistics;
import com.bc291.database.repository.StatisticsRepository;
import com.bc291.database.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StatisticsController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    StatisticsRepository statisticsRepository;

    @GetMapping("/statistics")
    public List<Statistics> getStatistics()
    {
        statisticsRepository.deleteAll();
        Statistics statistics = new Statistics(getTotalHoursPlayer(), getTotalGames(),getAveragePercentage(), getMostTimeSpend(), getHighestRated(),getLowestRated(),getPcGames(), getFavouriteGames());
        statisticsRepository.save(statistics);
        return statisticsRepository.findAll();
    }


    public long getTotalGames()
    {
        return gameRepository.count();
    }

    public double getAveragePercentage()
    {
        double averagePercentage=0;
        Iterator<Game> iterator = getGamesIterator();

        while(iterator.hasNext())
        {
            Game gra = iterator.next();
            averagePercentage+=gra.getPercentageCompleted();
        }
        return averagePercentage/gameRepository.count();
    }


    public String getMostTimeSpend()
    {
        long temp;
        int indexofGame=0;
        Iterator<Game> iterator = getGamesIterator();
        temp=getGamesList().get(0).getHoursPlayed();


        while(iterator.hasNext())
        {
            Game gra = iterator.next();

            if(gra.getHoursPlayed()>temp) {
                temp = gra.getHoursPlayed();
                indexofGame=getGamesList().indexOf(gra);
            }
        }

        return getGamesList().get(indexofGame).getTitle();
    }

    private Iterator<Game> getGamesIterator() {

        List<Game> gry = getGamesList();
        Iterator<Game> iterator = gry.iterator();
        return iterator;
    }

    private List<Game> getGamesList() {

        List<Game> gry = gameRepository.findAll();
        return gry;
    }


    public String getHighestRated()
    {
        double temp;
        int indexofGame=0;
        Iterator<Game> iterator = getGamesIterator();
        temp=Double.parseDouble(getGamesList().get(0).getRating());


        while(iterator.hasNext())
        {
            Game gra = iterator.next();

            if(Double.parseDouble(gra.getRating())>temp) {
                temp = Double.parseDouble(gra.getRating());
                indexofGame=getGamesList().indexOf(gra);
            }
        }

        return getGamesList().get(indexofGame).getTitle();
    }


    public String getLowestRated()
    {
        double temp;
        int indexofGame=0;
        Iterator<Game> iterator = getGamesIterator();
        temp=Double.parseDouble(getGamesList().get(0).getRating());


        while(iterator.hasNext())
        {
            Game gra = iterator.next();

            if(Double.parseDouble(gra.getRating())<temp) {
                temp = Double.parseDouble(gra.getRating());
                indexofGame=getGamesList().indexOf(gra);
            }
        }

        return getGamesList().get(indexofGame).getTitle();
    }


    public String getPcGames()
    {
        List<Game> gry = getGamesList();
        int pcGamesAmout=0;

        for(Game game : gry)
        {
            if(game.getGamePlatform().contains("[PC]")) pcGamesAmout++;
        }
        return Integer.toString(pcGamesAmout);
    }


    public long getTotalHoursPlayer()
    {
        long totalHoursePlayed=0;
        Iterator<Game> iterator = getGamesIterator();

        while(iterator.hasNext())
        {
            totalHoursePlayed+= iterator.next().getHoursPlayed();
        }

        return totalHoursePlayed;
    }

    public String getFavouriteGames()
    {
        String favouriteGames="";
        Iterator<Game> iterator = getGamesIterator();

        while(iterator.hasNext())
        {
            Game game = iterator.next();
            if(game.getPlayersRating()==5) favouriteGames+=game.getTitle()+", ";
        }

        return favouriteGames.substring(0, favouriteGames.length()-2);
    }

}
