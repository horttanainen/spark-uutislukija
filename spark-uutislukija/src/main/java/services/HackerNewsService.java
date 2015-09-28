/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import com.mycompany.hackernewsuutiset.HTTPClient;
import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;
import domain.Uutinen;


/**
 *
 * @author santeri
 */
public class HackerNewsService {
    private static Gson gson = new Gson();
    private String url = "https://hacker-news.firebaseio.com";
    
    public Uutinen haeSuosituinUutinen() {
        String suosituimmat = HTTPClient.callURL(url +"/v0/topstories.json");
        suosituimmat = suosituimmat.replace("[", "");
        suosituimmat = suosituimmat.replace("]", "");
        String[] array = suosituimmat.split(",");
        int suosituin = Integer.parseInt(array[0]);
        String vastaus = HTTPClient.callURL(url +"/v0/item/" + suosituin + ".json?print=pretty");
        return gson.fromJson(vastaus, Uutinen.class);

    }

    public Uutinen haeViimeisinUutinen() {
        String uusimmat = HTTPClient.callURL(url +"/v0/newstories.json");
        uusimmat = uusimmat.replace("[", "");
        uusimmat = uusimmat.replace("]", "");
        String[] array = uusimmat.split(",");
        int viimeisin = Integer.parseInt(array[0]);
        String vastaus = HTTPClient.callURL(url +"/v0/item/" + viimeisin + ".json?print=pretty");
        return gson.fromJson(vastaus, Uutinen.class);
        
    }
}
