package com.epam.izh.rd.online.service;

import java.util.List;

public class Stats {
    private int baseStat;
    private short effort;
    private Stat stat;
    
    public int getBaseStat() {
        return baseStat;
    }
    public void setBaseStat(int baseStat) {
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
