package com.example.step4;

import java.io.Serializable;

public class Trails implements Serializable {

    String name, ease, difficulty, features;
    int length;
    double lat, lon, review;
    boolean favorite;

    public Trails() {

        name = "null";
        ease = "null";
        difficulty = "null";
        features = "null";
        favorite = false;
        length = 0;
        review = 0;

    }

    public Trails(String name, String ease, String difficulty, String features, double review, int length, double lat, double lon) {


        this.name = name;
        this.ease = ease;
        this.difficulty = difficulty;
        this.features = features;
        this.favorite = false;
        this.review = review;
        this.length = length;
        this.lat = lat;
        this.lon=lon;


    }
    public String getName() {
        return name;
    }

    public double getLat() {
        return lat;
    }
    public double getLon() {
        return lon;
    }



}
