package com.epam.izh.rd.online.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats {
    private short baseStat;
    private short effort;
    private Stat stat;
    
    @JsonCreator
    public Stats(@JsonProperty("base_stat") short baseStat, @JsonProperty("effort") short effort, @JsonProperty("stat") Stat stat) {
        this.baseStat = baseStat;
        this.effort = effort;
        this.stat = stat;
    }
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
    public Stat getStat() {
        return stat;
    }
    public void setStat(Stat stat) {
        this.stat = stat;
    }    
}
