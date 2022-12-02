package com.example.step4;

import java.io.Serializable;

public class Trails implements Serializable {
    String name;

    public Trails(){
        name = "no name";
    }

    public Trails(String name){
        this.name = name;
    }

}
