package com.bc291.database.jsons;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class MyJsonParser {




    public String parseJson(String golUrl)
    {
        String jsonAsString="";

        try {
            Document doc = Jsoup.connect(golUrl).get();
            Element paragraphs = doc.select("script").first();
            jsonAsString = paragraphs.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        jsonAsString=jsonAsString.substring(jsonAsString.indexOf('\n')+1);
        jsonAsString = jsonAsString.substring(0, jsonAsString.length()-10);

  //      TetJson tetJson = new TetJson();
      //  tetJson.parseJson(jsonAsString);
            return jsonAsString;
    }
}
