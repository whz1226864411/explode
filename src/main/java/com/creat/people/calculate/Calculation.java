package com.creat.people.calculate;

import com.creat.people.po.EnergyParams;
import com.creat.people.po.HarmRank;

/**
 * Created by Administrator on 2017/8/31.
 */
public class Calculation {
    //kj
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

//    public static void main(String args[]){
//        EnergyParams energyParams = new EnergyParams();
//        energyParams.setP0(101325);
//        energyParams.setGasAdiabat(1.4);
//        energyParams.setD(1.422);
//        energyParams.setH(0.0214);
//        energyParams.setCorrectionFactor(0.85);
//        energyParams.setL2(10);
//        energyParams.setL1(2);
//        energyParams.setSoilDensity(1800);
//        energyParams.setH2(5);
//        energyParams.setH1(2.5);
//        energyParams.setP1(13300000);
//        int el = Calculation.calculateEnergy(energyParams);
//        double p = Calculation.calculateP(el,8);
//        System.out.println(p);
//    }
    //kpa
    public static double calculateP(int el,double distance){
        double temp = Math.pow((double) el,1/3.0)/distance;
        return 17.879*temp-4.926*temp*temp+0.675*temp*temp*temp;
    }

    public static HarmRank calculateHarmRank(double p, double safeCoefficient){
        HarmRank harmRank = new HarmRank();
        p /= 1000;
        if(p > 0.1*safeCoefficient){
            harmRank.setRank(HarmRank.rankOne);
            harmRank.setExpression(HarmRank.expressionOne);
        }else if (p > 0.05*safeCoefficient && p <= 0.1*safeCoefficient){
            harmRank.setRank(HarmRank.rankTwo);
            harmRank.setExpression(HarmRank.expressionTwo);
        }else if (p > 0.03*safeCoefficient && p <= 0.05*safeCoefficient){
            harmRank.setRank(HarmRank.rankThree);
            harmRank.setExpression(HarmRank.expressionThree);
        }else if (p > 0.02*safeCoefficient && p <= 0.03*safeCoefficient){
            harmRank.setRank(HarmRank.rankFour);
            harmRank.setExpression(HarmRank.expressionFour);
        }else {
            harmRank.setRank(HarmRank.rankNo);
            harmRank.setExpression(HarmRank.expressionNo);
        }
        return harmRank;
    }

}
