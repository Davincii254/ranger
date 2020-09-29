import models.Animal;
import models.Endangered;

import models.SightingInfo;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;
import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);
        staticFileLocation("/public");

        get("/", (req, res) -> {
            Map<String,Object> model=new HashMap<>();
         return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());



        get("/rangers", (req, res) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model,"rangers.hbs");
        }, new HandlebarsTemplateEngine());



        get("/sightings", (req, res) -> {
            Map<String,Object> model=new HashMap<>();
            model.put("sightings",SightingInfo.all());
            model.put("animals",Animal.all());
            model.put("endangeredanimals", Endangered.all());
            return new ModelAndView(model,"sighted.hbs");
        }, new HandlebarsTemplateEngine());




        get("/endangered", (req, res) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model,"sighting-form.hbs");
        }, new HandlebarsTemplateEngine());


        post("/endangered/new", (request, response)->{
            Map<String, Object> model = new HashMap<>();
            String animalName = request.queryParams("animalName");
            String animalAge = request.queryParams("animalAge");
            String animalHealth = request.queryParams("animalHealth");
            String Location = request.queryParams("Location");
            String Ranger_name = request.queryParams("Ranger_name");
            Endangered newEndangered = new Endangered(animalName, animalAge, animalHealth, Location, Ranger_name);
            newEndangered.save();
            model.put("newEndangered", newEndangered);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());



        get("/non-endangered", (req, res) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model,"sightnonendangered-form.hbs");
        }, new HandlebarsTemplateEngine());


        post("/new/non-endangered", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
             Animal animal = new Animal(name);
             animal.save();

            model.put("sightings",SightingInfo.all());
            model.put("animals",Animal.all());
            model.put("endangered", Endangered.all());
           String ranger_name = request.queryParams("ranger_name");

            String location = request.queryParams("location");

            SightingInfo newSightingInfo = new SightingInfo(name,ranger_name,location);
             animal.save();
             newSightingInfo.save();
            model.put("sightings", SightingInfo.all());
             model.put("animals", Animal.all());
            model.put("endangered", Endangered.all());
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());
    }
}
