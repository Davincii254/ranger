package models;

import java.net.HttpRetryException;
import java.util.ArrayList;
import java.util.List;

public class Squad {

    private String squadName;
    private int squadId;
    private String cause;
    private int squadSize;
    private ArrayList<Hero>  squadMembers = new ArrayList<>();
    private static ArrayList<Squad> instances = new ArrayList<>();


    public Squad(String name, int size, String cause ){
        squadName = name;
        this.cause = cause;
        squadSize = size;
        this.squadMembers = new ArrayList<>();
        instances.add(this);
        this.squadId = instances.size();

    }
    public int getSquadId(){
        return squadId;}
    public static Squad findBySquadId(int id) {return instances.get(id-1);}
    public String getSquadName() {return squadName;}
    public String getCause() {return this.cause;}
    public int getSize() {return squadSize;}
    public static ArrayList<Squad> getInstances(){return instances;}
    public ArrayList<Hero> getSquadMembers(){
        return squadMembers;
    }
    public void setSquadMembers(Hero newMember) {
        squadMembers.add(newMember);
    }
    public static void clearAllSquads(){ instances.clear(); }
    public void clearAllSquadMembers(){ getSquadMembers().clear(); }

    public static Squad setUpNewSquad(){return new Squad("Kushman",7,"Revenge Wrong doings");}
    public static Squad setUpNewSquad1(){return new Squad("Justice Seekers",7,"Seek Justice");}
    public static Squad setUpNewSquad2(){return new Squad("Corruption Seekers",7,"Remove Corruption");}
    public static Squad setUpNewSquad3(){return new Squad("Children Protectors",7,"Protect the Children");}

}
