import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args){

        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        }else {
            port = 4567;
        }
        port(port);

        staticFileLocation("/public");
        Hero.setUpNewHero();
        Hero.setUpNewHero1();
        Squad.setUpNewSquad();


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        // hero form
        get("/hero",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> hero = Hero.getAllInstances();
            model.put("hero",hero);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());


        //
        get("/new/:id",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            int idOfHero = Integer.parseInt(req.params(":id"));
            Hero foundHero = Hero.findById(idOfHero);
            model.put("hero",foundHero);
            return new ModelAndView(model, "more.hbs");
        }, new HandlebarsTemplateEngine());


        //hero-form
        get("/hero-form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());


        //squad-form
        get("/squad-form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());


        //squad
        get("/squad",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getInstances();
            model.put("squads",squads);
            ArrayList<Hero> members = Hero.getAllInstances();
            model.put("heroes",members);
            Squad newSquad = Squad.findBySquadId(1);
            model.put("allSquadMembers", newSquad.getSquadMembers());
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());


        //new hero
        post("/new/hero",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            Integer age = Integer.parseInt(req.queryParams("age"));
            String power = req.queryParams("power");
            String weakness = req.queryParams("weakness");
            Hero newHero = new Hero(name,weakness,power,age);
            req.session().attribute("item",name);
            model.put("item",req.session().attribute("item"));
            model.put("newHero",newHero);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        //new squad
        post("/squad/new",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String squadName = req.queryParams("squadName");
            Integer size = Integer.parseInt(req.queryParams("size"));
            String cause = req.queryParams("cause");
            Squad newSquad = new Squad(squadName,size,cause);
            req.session().attribute("item",squadName);
            model.put("item",req.session().attribute("item"));
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());


        //find squad
        get("/squad/new/:id",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            int id= Integer.parseInt(req.params(":id"));
            Hero newMember = Hero.findById(id);
            Squad newSquad = Squad.findBySquadId(1);
            newSquad.setSquadMembers(newMember);
            model.put("item", newMember.getName());
            model.put("newHero",newSquad.getSquadName());
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        //new-member
        get("/new/member/:squadId",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            req.session().attribute("selectedSquad",req.params("squadId"));
            model.put("selectedSquad", req.session().attribute("selectedSquad"));
            model.put("item",1);
            return new ModelAndView(model, "success.hbs");
        },new HandlebarsTemplateEngine());






    }
}
