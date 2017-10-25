package com.creat.building.calculate;

import com.creat.building.po.EnergyParams;
import com.creat.building.po.HarmRank;

/**
 * Created by Administrator on 2017/8/31.
 */
public class Calculation {

    public static int calculateEnergy(EnergyParams energyParams){
        //修正系数
        double correctionFactor = energyParams.getCorrectionFactor();
        //初始压力
        double P1 = energyParams.getP1();
        //管道外径
        double d = energyParams.getD();
        //管道壁厚
        double h = energyParams.getH();
        //气体绝热指数
        double gasAdiabat = energyParams.getGasAdiabat();
        //大气压力
        double P0 = energyParams.getP0();
        //土壤密度
        double soilDensity = energyParams.getSoilDensity();
        //管体埋深
        double H1 = energyParams.getH1();
        //覆土抛掷高度
        double H2 = energyParams.getH2();
        //管道敷设沟下开口
        double L1 = energyParams.getL1();
        //管道敷设沟上开口
        double L2 = energyParams.getL2();
        double eli = Math.PI*P1*(d-2*h)*(d-2*h)*(1-Math.pow(P0/P1,(gasAdiabat-1)/gasAdiabat))/(4*(gasAdiabat-1));
        double es = soilDensity*9.8*H2*(2*H1-d)*(L1+L2)/4;
        double el = correctionFactor*(eli-es)/1000.0;
        return (int)el;
    }

    public static double calculateP(int el,double distance){
        double temp = Math.pow((double) el,1/3.0)/distance;
        return 17.879*temp-4.926*temp*temp+0.675*temp*temp*temp;
    }

    public static HarmRank calculateHarmRank(double p, double safeCoefficient){
        HarmRank harmRank = new HarmRank();
        p /= 1000;
        if(p > 0.0245*safeCoefficient && p < 0.1050*safeCoefficient){
            harmRank.setRank(HarmRank.rankOne);
            harmRank.setExpression(HarmRank.expressionOne);
        }else if (p > 0.0070*safeCoefficient && p <= 0.0245*safeCoefficient){
            harmRank.setRank(HarmRank.rankTwo);
            harmRank.setExpression(HarmRank.expressionTwo);
        }else if (p > 0.0021*safeCoefficient && p <= 0.0070*safeCoefficient){
            harmRank.setRank(HarmRank.rankThree);
            harmRank.setExpression(HarmRank.expressionThree);
        }else {
            harmRank.setRank(HarmRank.rankNo);
            harmRank.setExpression(HarmRank.expressionNo);
        }
        return harmRank;
    }

//    public static void main(String args[]){
//        System.out.println(Calculation.calculateRv(31153500,170,1.55,2));
//    }

    //Rs的计算
    public static int calculateRs(double el){
        double divP = 7.0;
        double m = 0.675*el;
        double n = -4.926*Math.pow(el,2/3.0);
        double t = 17.879*Math.pow(el,1/3.0);
        double s = -divP;
        double a = n / m;
        double b = t / m;
        double c = s / m;
        double q = (a * a - 3 * b) / 9;
        double r = (2 * a * a * a - 9 * a * b + 27 * c) / 54;
        int sgn = (r >= 0) ? 1 : -1;
        double u = -sgn * Math.pow((Math.abs(r) + Math.sqrt(r * r - q * q * q)), 1. / 3);
        double v = (u != 0) ? q / u : 0;
        double x1 = u + v - a / 3;
        return (int)(1.0/x1);
    }
    //计算rv
    public static int calculateRv(double el,double k,double arf,double v){
        //换算系数
        double hsxs = 4.0514E-7;
        System.out.println(hsxs);
        System.out.println(Math.pow(hsxs*el,1.0/3));
        System.out.println(Math.pow(k/v,1.0/arf));
        return (int)(Math.pow(hsxs*el,1.0/3)*Math.pow(k/v,1.0/arf));
    }
}
