package com.epam.izh.rd.online.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StatInner {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

    /*@JsonCreator
    public StatInner(
            @JsonProperty("name") String name,
            @JsonProperty("url") String url) {
        this.name = name;
        this.url = url;
    }*/
}
