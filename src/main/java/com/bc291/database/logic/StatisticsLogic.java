//package com.example.easynotes.logic;
//
//import Game;
//import GameRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Iterator;
//import java.util.List;
//
//
//public class StatisticsLogic {
//
//
//    public StatisticsLogic(GameRepository gameRepository) {
//        this.gameRepository = gameRepository;
//    }
//
//    public long getTotalHoursPlayer()
//    {
//        long totalHoursePlayed=0;
//        List<Game> gry = gameRepository.findAll();
//        Iterator<Game> iterator = gry.iterator();
//
//        while(iterator.hasNext())
//        {
//            Game gra = iterator.next();
//            totalHoursePlayed+=gra.getHoursPlayed();
//        }
//
//        return totalHoursePlayed;
//    }
//
//
//
//    public long getTotalGames()
//    {
//        return gameRepository.count();
//    }
//
//    public double getAveragePercentage()
//    {
//        double averagePercentage=0;
//        List<Game> gry = gameRepository.findAll();
//        Iterator<Game> iterator = gry.iterator();
//
//        while(iterator.hasNext())
//        {
//            Game gra = iterator.next();
//            averagePercentage+=gra.getPercentageCompleted();
//        }
//        averagePercentage=averagePercentage/gameRepository.count();
//        System.out.println(averagePercentage);
//        return averagePercentage;
//    }
//
//
//    public String getMostTimeSpend()
//    {
//        long totalHoursePlayed=0;
//        long temp;
//        int indexofGame=0;
//        List<Game> gry = gameRepository.findAll();
//        Iterator<Game> iterator = gry.iterator();
//        temp=gry.get(0).getHoursPlayed();
//
//
//        while(iterator.hasNext())
//        {
//            Game gra = iterator.next();
//
//            if(gra.getHoursPlayed()>temp) {
//                temp = gra.getHoursPlayed();
//                indexofGame=gry.indexOf(gra);
//            }
//        }
//
//        return gameRepository.findAll().get(indexofGame).getTitle();
//    }
//
//
//    public String getHighestRated()
//    {
//        double rating=0;
//        double temp;
//        int indexofGame=0;
//        List<Game> gry = gameRepository.findAll();
//        Iterator<Game> iterator = gry.iterator();
//        temp=Double.parseDouble(gry.get(0).getRating());
//
//
//        while(iterator.hasNext())
//        {
//            Game gra = iterator.next();
//
//            if(Double.parseDouble(gra.getRating())>temp) {
//                temp = Double.parseDouble(gra.getRating());
//                indexofGame=gry.indexOf(gra);
//                System.out.println(gra);
//            }
//        }
//
//        return gameRepository.findAll().get(indexofGame).getTitle();
//    }
//
//
//    public String getLowestRated()
//    {
//        double rating=0;
//        double temp;
//        int indexofGame=0;
//        List<Game> gry = gameRepository.findAll();
//        Iterator<Game> iterator = gry.iterator();
//        temp=Double.parseDouble(gry.get(0).getRating());
//
//
//        while(iterator.hasNext())
//        {
//            Game gra = iterator.next();
//
//            if(Double.parseDouble(gra.getRating())<temp) {
//                temp = Double.parseDouble(gra.getRating());
//                indexofGame=gry.indexOf(gra);
//                System.out.println(gra);
//            }
//
//        }
//
//        return gameRepository.findAll().get(indexofGame).getTitle();
//    }
//
//
//    public String getPcGames()
//    {
//        List<Game> gry = gameRepository.findAll();
//        Iterator<Game> iterator = gry.iterator();
//        int pcGamesAmout=0;
//        int ps3GamesAmout=0;
//        String temp;
//
//        for(Game game : gry)
//        {
//            if(game.getGamePlatform().contains("[PC]")) pcGamesAmout++;
//            else if (game.getGamePlatform().contains("[PS3]")) ps3GamesAmout++;
//
//        }
//        System.out.println(pcGamesAmout+"PCCCCCCCCCCC");
//        System.out.println(ps3GamesAmout+"PS333333333333333333");
//        return Integer.toString(pcGamesAmout);
//    }
//}
