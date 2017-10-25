package com.creat.building.po;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/6.
 */
public class HarmRank implements Serializable{
    public static final String rankOne = "一级";
    public static final String rankTwo = "二级";
    public static final String rankThree = "三级";
    public static final String rankNo = "无伤害";
    public static final String expressionOne = "大型钢架结构、防震钢筋混凝土破坏，砖墙倒塌";
    public static final String expressionTwo = "木建筑厂房房柱折断，房架松动，墙裂缝、屋瓦掉下";
    public static final String expressionThree = "窗框损坏，受压面的门窗玻璃部分破碎";
    public static final String expressionNo = "正常";
    private String rank;
    private String expression;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
