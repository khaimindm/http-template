package com.epam.izh.rd.online.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Stat {
    public int getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  int baseStat;
    private String name;


    /*@JsonCreator
    public Stat(
            @JsonProperty("base_stat") int baseStat,
            @JsonProperty("name") String name) {
        this.baseStat = baseStat;
        this.name = name;
    }*/
}
