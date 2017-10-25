package com.creat.people.po;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/6.
 */
public class HarmRank implements Serializable{
    public static final String rankOne = "一级";
    public static final String rankTwo = "二级";
    public static final String rankThree = "三级";
    public static final String rankFour = "四级";
    public static final String rankNo = "无伤害";
    public static final String expressionOne = "大部分人员死亡";
    public static final String expressionTwo = "内脏严重损伤或死亡";
    public static final String expressionThree = "听觉器官损伤或骨折";
    public static final String expressionFour = "轻微损伤";
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
