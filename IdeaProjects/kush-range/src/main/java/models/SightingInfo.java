package models;
import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;
import static models.DB.sql2o;

public class SightingInfo {
    private int id;
    private String animal_name;
    private String ranger_name;
    private String health;
    private String age;
    private String location;

    public SightingInfo(String animal_name,String ranger_name,String health,String age,String location){
        this.animal_name = animal_name;
        this.location = location;
        this.ranger_name = ranger_name;
        this.health = health;
        this.age = age;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SightingInfo(String animal_name, String ranger_name, String location){
        this.animal_name = animal_name;
        this.location = location;
        this.ranger_name = ranger_name;
        this.health = "";
        this.age = "";


    }

    public String getAnimal_name() {
        return animal_name;
    }

    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    public String getRanger_name() {
        return ranger_name;
    }

    public void setRanger_name(String ranger_name) {
        this.ranger_name = ranger_name;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SightingInfo that = (SightingInfo) o;
        return animal_name.equals(that.animal_name) &&
                ranger_name.equals(that.ranger_name) &&
                getHealth().equals(that.getHealth()) &&
                getAge().equals(that.getAge()) &&
                getLocation().equals(that.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(animal_name, ranger_name, getHealth(), getAge(), getLocation());
    }


    public static List<SightingInfo> all() {
        String sql = "SELECT * FROM sightinginfo;";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(SightingInfo.class);
        }
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightinginfo (animal_name, ranger_name,health, age,location) VALUES (:animal_name,:ranger_name,:health,:age,:location)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animal_name", this.animal_name)
                    .addParameter("ranger_name", this.ranger_name)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .addParameter("location", this.location)
                    .executeUpdate()
                    .getKey();
        }
    }

}
