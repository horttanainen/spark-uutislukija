import domain.Uutinen;
import java.util.HashMap;
import java.util.Map;
import static jdk.nashorn.internal.objects.NativeDebug.map;
import services.HackerNewsService;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.TemplateViewRoute;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author santeri
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HackerNewsService service = new HackerNewsService();
        port(getHerokuAssignedPort());
        
        get("/", (request, response) -> {
            response.redirect("/main");
            return null;
        });
        
         get("/main", (request, response) -> {
             Map<String, Uutinen> model = new HashMap<>();
            return new ModelAndView(model, "main");
        }, new ThymeleafTemplateEngine());
        
        get("/suosituin", (request, response) -> {
            Map<String, Uutinen> model = new HashMap<>();
            model.put("suosituin", service.haeSuosituinUutinen());

            return new ModelAndView(model, "suosituin");
        }, new ThymeleafTemplateEngine());
        
        get("/viimeisin", (request, response) -> {
            Map<String, Uutinen> model = new HashMap<>();
            model.put("viimeisin", service.haeViimeisinUutinen());

            return new ModelAndView(model, "viimeisin");
        }, new ThymeleafTemplateEngine());
    }
    

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    }
