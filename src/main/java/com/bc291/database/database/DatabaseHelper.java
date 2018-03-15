package com.bc291.database.database;


import com.bc291.database.jsons.MyJsonParser;
import com.bc291.database.jsons.SearchLinkParser;
import com.bc291.database.jsons.jsonFromGol;
import com.bc291.database.model.Game;
import com.bc291.database.jsons.TetJson;


public class DatabaseHelper {
private MyJsonParser myJsonParser;
private SearchLinkParser searchLinkParser;
private TetJson tetJson;




    public DatabaseHelper() {
        this.myJsonParser = new MyJsonParser();
        this.searchLinkParser = new SearchLinkParser();
        this.tetJson = new TetJson();
    }

    public jsonFromGol resolveJson(String input)
    {
        String gameTitle=input+" Gry online S016";



        String golUrl = searchLinkParser.parse(gameTitle);


        String jsonAsString = myJsonParser.parseJson(golUrl);

        jsonFromGol jsonProvider = tetJson.parseJson(jsonAsString);


        return jsonProvider;
    }

    public Game addToDatabase(jsonFromGol jsonGame)
    {

        Game game1 = new Game(jsonGame.getName(), jsonGame.getAuthor().getName(), jsonGame.getAggregateRating().getRatingValue(), jsonGame.getGenre().toString(), jsonGame.getGamePlatform().toString(), jsonGame.getImage(), 0, 0.0, 2.5);

           //System.out.println(game1);


return game1;

    }




}
