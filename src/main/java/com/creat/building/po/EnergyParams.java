package com.creat.building.po;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/31.
 */
public class EnergyParams implements Serializable{


    //管内气体初始压力
    private double P1;
    //管道外径
    private double d;
    //管道壁厚
    private double h;
    //气体绝热指数
    private double gasAdiabat;
    //大气压力
    private double P0;
    //土壤密度
    private double soilDensity;
    //管体埋深
    private double H1;
    //覆土抛掷高度
    private double H2;
    //管道敷设沟下开口
    private double L1;
    //管道敷设沟上开口
    private double L2;
    //修正系数
    private double correctionFactor;

    public double getCorrectionFactor() {
        return correctionFactor;
    }

    public void setCorrectionFactor(double correctionFactor) {
        this.correctionFactor = correctionFactor;
    }

    public double getP1() {
        return P1;
    }

    public void setP1(double p1) {
        P1 = p1;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getGasAdiabat() {
        return gasAdiabat;
    }

    public void setGasAdiabat(double gasAdiabat) {
        this.gasAdiabat = gasAdiabat;
    }

    public double getP0() {
        return P0;
    }

    public void setP0(double p0) {
        P0 = p0;
    }

    public double getSoilDensity() {
        return soilDensity;
    }

    public void setSoilDensity(double soilDensity) {
        this.soilDensity = soilDensity;
    }

    public double getH1() {
        return H1;
    }

    public void setH1(double h1) {
        H1 = h1;
    }

    public double getH2() {
        return H2;
    }

    public void setH2(double h2) {
        H2 = h2;
    }

    public double getL1() {
        return L1;
    }

    public void setL1(double l1) {
        L1 = l1;
    }

    public double getL2() {
        return L2;
    }

    public void setL2(double l2) {
        L2 = l2;
    }
}
