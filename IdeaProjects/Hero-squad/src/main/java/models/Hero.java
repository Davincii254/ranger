package models;

import java.util.ArrayList;

public class Hero {

    private String name;
    private String weakness;
    private String power;
    private int age;
    private int id;
    private static ArrayList<Hero> instances = new ArrayList<>();

    public Hero(String name, String weakness, String power, int age) {
        this.name = name;
        this.weakness = weakness;
        this.power = power;
        this.age = age;
        instances.add(this);
        this.id = instances.size();
    }

    public String getName() {return this.name;}
    public String getWeakness() {return this.weakness;}
    public String getPower() {return this.power;}
    public int getAge() {return this.age;}
    public static ArrayList<Hero> getAllInstances() {return instances;}
    public static void clearAllHeroes(){instances.clear();}
    public int getId(){return id;}
    public static Hero findById(int id) {return instances.get(id-1);}

    public static Hero setUpNewHero(){
        return new Hero("kushman","the wife","Fighting",46);
    }
    public static Hero setUpNewHero1(){
        return new Hero("Flash","Quantum Change","Fastest man on earth",31);
    }
    public static Hero setUpNewHero2(){
        return new Hero("Superman","kryptonian stones","strongest man",38);
    }
    public static Hero setUpNewHero3(){
        return new Hero("Spiderman","Calast Stone","Strong and flexible",25);
    }
    public static Hero setUpNewHero4(){
        return new Hero("Deadpool","radiation","Unbeatable",36);
    }
    public static Hero setUpNewHero5(){
        return new Hero("kushman","gamma","Stop time",27);
    }
}
