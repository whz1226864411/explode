package com.creat.people.po;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/6.
 */
public class PeopleHarmHistory implements Serializable{
    private EnergyParams energyParams;
    private Integer el;
    private Double p;
    private HarmRank harmRank;
    private Date date;

    public HarmRank getHarmRank() {
        return harmRank;
    }

    public void setHarmRank(HarmRank harmRank) {
        this.harmRank = harmRank;
    }

    public Double getP() {
        return p;
    }

    public void setP(Double p) {
        this.p = p;
    }

    public Integer getEl() {
        return el;
    }

    public void setEl(Integer el) {
        this.el = el;
    }

    public EnergyParams getEnergyParams() {
        return energyParams;
    }

    public void setEnergyParams(EnergyParams energyParams) {
        this.energyParams = energyParams;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
