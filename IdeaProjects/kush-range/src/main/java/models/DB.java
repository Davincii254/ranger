package models;

import org.sql2o.Sql2o;

public class DB {

    public static   String connectionString = "jdbc:postgresql://ec2-54-224-124-241.compute-1.amazonaws.com:5432/d5j2hvlid2h80o";
       public static Sql2o sql2o = new Sql2o(connectionString, "ccyhkvpngqxwcm", "af5165dab09e5f69612f4deab9afaeaa6f3dfe868081c3b0c5b27f385c3179f6");

}

