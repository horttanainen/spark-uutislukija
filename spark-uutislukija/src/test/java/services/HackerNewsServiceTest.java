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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author santeri
 */
public class HackerNewsServiceTest {
    
    private HackerNewsService service;
    private static Gson gson = new Gson();
    private String url = "https://hacker-news.firebaseio.com";
    
    @Before
    public void setUp() {
        service = new HackerNewsService();
    }
    
    @Test
    public void servicePalauttaaOikeanUutisen(){
        Uutinen suosituinU = service.haeSuosituinUutinen();
        Uutinen viimeisinU = service.haeViimeisinUutinen();
        
        String suosituimmat = HTTPClient.callURL(url + "/v0/topstories.json");
        suosituimmat = suosituimmat.replace("[", "");
        suosituimmat = suosituimmat.replace("]", "");
        String[] array = suosituimmat.split(",");
        int suosituin = Integer.parseInt(array[0]);
        String vastaus = HTTPClient.callURL(url + "/v0/item/" + suosituin + ".json?print=pretty");
        Uutinen suosituinT = gson.fromJson(vastaus, Uutinen.class);
        
        String uusimmat = HTTPClient.callURL(url +"/v0/newstories.json");
        uusimmat = uusimmat.replace("[", "");
        uusimmat = uusimmat.replace("]", "");
        String[] array2 = uusimmat.split(",");
        int viimeisin = Integer.parseInt(array2[0]);
        String vastaus2 = HTTPClient.callURL(url +"/v0/item/" + viimeisin + ".json?print=pretty");
        Uutinen viimeisinT = gson.fromJson(vastaus2, Uutinen.class);
        
        assertEquals(suosituinU.getTitle(), suosituinT.getTitle());
        assertEquals(viimeisinU.getTitle(), viimeisinT.getTitle());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
