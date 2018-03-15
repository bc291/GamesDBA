package com.bc291.database.controller;

import com.bc291.database.jsons.jsonFromGol;
import com.bc291.database.model.Game;
import com.bc291.database.database.DatabaseHelper;
import com.bc291.database.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/games")
    public List<Game> getGames()
    {
        return gameRepository.findAll();
    }

    @GetMapping("/games/{id}")
    public Game getGameById(@PathVariable Long id)
    {
        return gameRepository.getOne(id);
    }


    @PostMapping("/games")
    public String creatGame(@Valid @RequestBody Game game)
    {
        System.out.println(gameRepository);
        if(gameRepository.findAll().contains(game)) return "already exist";
        else { gameRepository.save(game);
        return "added";}

    }

    @DeleteMapping("/games/{id}")
    public boolean deleteGame(@PathVariable Long id)
    {
        gameRepository.deleteById(id);
        return true;
    }


    @PutMapping("/games")
    public Game updateGame(@Valid @RequestBody Game game)
    {
        return gameRepository.save(game);
    }


    @PostMapping("/searchgame")
    public String searchGame(@RequestBody String test) {
        DatabaseHelper databaseHelper = new DatabaseHelper();
        String test2 = test.substring(14, test.length() - 2);

        jsonFromGol testdsfsfsdf = databaseHelper.resolveJson(test2);
        Game game = databaseHelper.addToDatabase(testdsfsfsdf);

        if (gameRepository.findAll().contains(game)) return "false";
        else {
            gameRepository.save(game);
            return "true";
        }
    }

    @GetMapping("/totalHoursPlayed")
    public long getTotalHoursPlayer()
    {
        long totalHoursePlayed=0;
        List<Game> gry = gameRepository.findAll();
        Iterator<Game> iterator = gry.iterator();

        while(iterator.hasNext())
        {
            Game gra = iterator.next();
            totalHoursePlayed+=gra.getHoursPlayed();
        }

        return totalHoursePlayed;
    }


    @GetMapping("/totalgames")
    public long getTotalGames()
    {
        return gameRepository.count();
    }

    @GetMapping("/averagePercentage")
    public double getAveragePercentage()
    {
        double averagePercentage=0;
        List<Game> gry = gameRepository.findAll();
        Iterator<Game> iterator = gry.iterator();

        while(iterator.hasNext())
        {
            Game gra = iterator.next();
            averagePercentage+=gra.getPercentageCompleted();
        }
        averagePercentage=averagePercentage/gameRepository.count();
        System.out.println(averagePercentage);
        return averagePercentage;
    }


    @GetMapping("/mosttimespend")
    public String getMostTimeSpend()
    {
        long totalHoursePlayed=0;
        long temp;
        int indexofGame=0;
        List<Game> gry = gameRepository.findAll();
        Iterator<Game> iterator = gry.iterator();
        temp=gry.get(0).getHoursPlayed();


        while(iterator.hasNext())
        {
            Game gra = iterator.next();

            if(gra.getHoursPlayed()>temp) {
                temp = gra.getHoursPlayed();
                indexofGame=gry.indexOf(gra);
            }
        }

        return gameRepository.findAll().get(indexofGame).getTitle();
    }


    @GetMapping("/highestrated")
    public String getHighestRated()
    {
        double rating=0;
        double temp;
        int indexofGame=0;
        List<Game> gry = gameRepository.findAll();
        Iterator<Game> iterator = gry.iterator();
        temp=Double.parseDouble(gry.get(0).getRating());


        while(iterator.hasNext())
        {
            Game gra = iterator.next();

            if(Double.parseDouble(gra.getRating())>temp) {
                temp = Double.parseDouble(gra.getRating());
                indexofGame=gry.indexOf(gra);
                System.out.println(gra);
            }
        }

        return gameRepository.findAll().get(indexofGame).getTitle();
    }


    @GetMapping("/lowestrated")
    public String getLowestRated()
    {
        double rating=0;
        double temp;
        int indexofGame=0;
        List<Game> gry = gameRepository.findAll();
        Iterator<Game> iterator = gry.iterator();
        temp=Double.parseDouble(gry.get(0).getRating());


        while(iterator.hasNext())
        {
            Game gra = iterator.next();

            if(Double.parseDouble(gra.getRating())<temp) {
                temp = Double.parseDouble(gra.getRating());
                indexofGame=gry.indexOf(gra);
                System.out.println(gra);
            }

        }

        return gameRepository.findAll().get(indexofGame).getTitle();
    }


    @GetMapping("/getpcgames")
    public String getPcGames()
    {
        List<Game> gry = gameRepository.findAll();
        Iterator<Game> iterator = gry.iterator();
        int pcGamesAmout=0;
        int ps3GamesAmout=0;
        String temp;

for(Game game : gry)
{
    if(game.getGamePlatform().contains("[PC]")) pcGamesAmout++;
    else if (game.getGamePlatform().contains("[PS3]")) ps3GamesAmout++;

}
        System.out.println(pcGamesAmout+"PCCCCCCCCCCC");
        System.out.println(ps3GamesAmout+"PS333333333333333333");
        return Integer.toString(pcGamesAmout);
    }



}
