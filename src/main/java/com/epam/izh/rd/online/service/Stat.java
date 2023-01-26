package com.epam.izh.rd.online.service;

public class Stat {
    private short baseStat;
    private short effort;
    private String name;
    private String url;

    public short getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(short baseStat) {
        this.baseStat = baseStat;
    }

    public short getEffort() {
        return effort;
    }

    public void setEffort(short effort) {
        this.effort = effort;
    }

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
}
