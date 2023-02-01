package com.epam.izh.rd.online.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Stat {
    private  int baseStat;
    private  int effort;
    private String name;
    private String url;

    @JsonCreator
    public Stat(
            @JsonProperty("base_stat") int baseStat,
            @JsonProperty("effort") int effort,
            @JsonProperty("name") String name,
            @JsonProperty("url") String url) {
        this.baseStat = baseStat;
        this.effort = effort;
        this.name = name;
        this.url = url;
    }
}
