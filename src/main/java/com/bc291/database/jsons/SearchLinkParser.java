package com.bc291.database.jsons;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SearchLinkParser {


    public String parse(String gameTitle)
    {

        String golUrl="";
        String url = gameTitle.replaceAll(" ","+");
        url = "https://www.google.pl/search?q="+url;

        try {
            Document doc = Jsoup.connect(url).get();
            Element paragraphs =  doc.selectFirst("h3");

            Elements links = paragraphs.getElementsByTag("a");
            Element firstEntry = links.get(0);
            golUrl = firstEntry.attr("href");
          //  System.out.println(golUrl);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return golUrl;

    }

}
