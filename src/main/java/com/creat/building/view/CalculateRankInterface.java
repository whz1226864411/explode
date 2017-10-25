package com.creat.building.view;

import com.creat.building.calculate.Calculation;
import com.creat.building.controller.BackController;
import com.creat.building.po.EnergyParams;
import com.creat.building.po.HarmRank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2017/9/2.
 */
public class CalculateRankInterface extends JFrame{
    private int width;
    private int height;
    private JButton back;
    private JPanel main;
    private JFrame parent;
    private JButton calculateButton;
    private JLabel result;
    private JLabel resultExpression;
    private JButton nextButton;
    private EnergyParams energyParams;
    private int el;
    private double p;
    private HarmRank harmRank;

    private CalculateRankInterface(){
    }

    public CalculateRankInterface(String title, JFrame parent, EnergyParams energyParams, int el, double p){
        super(title);
        this.parent = parent;
        this.energyParams = energyParams;
        this.p = p;
        this.el = el;
        init();
        setSize(width-700,height-400);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int)screenSize.getWidth();
        height = (int)screenSize.getHeight();
        main = (JPanel) getContentPane();
        main.setLayout(null);
        back = new JButton("返回菜单");
        back.setBounds(width-830,height-470,110,30);
        back.setFont(new Font("宋体",Font.BOLD,16));
        back.addActionListener(new BackController(this.parent,this));
        main.add(back);
        nextButton = new JButton("下一步");
        nextButton.setBounds(width-830,height-520,110,30);
        nextButton.setFont(new Font("宋体",Font.BOLD,16));
        nextButton.setEnabled(false);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CalculateRankInterface.this.dispose();
                new RangeInterface("大口径高压天然气管道物理爆炸对周边建筑物损坏范围的综合估算系统",parent,energyParams,
                        el,p,harmRank);
            }
        });
        main.add(nextButton);
//        saveButton = new JButton("保存记录");
//        saveButton.setBounds(width-830,height-520,110,30);
//        saveButton.setFont(new Font("宋体",Font.BOLD,16));
//        saveButton.setEnabled(false);
//        saveButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    PeopleHarmHistory peopleHarmHistory = new PeopleHarmHistory();
//                    peopleHarmHistory.setEnergyParams(energyParams);
//                    peopleHarmHistory.setEl(el);
//                    peopleHarmHistory.setP(p);
//                    peopleHarmHistory.setHarmRank(harmRank);
//                    peopleHarmHistory.setDate(new Date());
//                    HistoryController<PeopleHarmHistory> historyController = new HistoryController<PeopleHarmHistory>();
//                    historyController.saveHistory(peopleHarmHistory,"data/BuildingHarmHistory.dat");
//                    JOptionPane.showMessageDialog(CalculateRankInterface.this, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
//                } catch (IOException e1) {
//                    JOptionPane.showMessageDialog(CalculateRankInterface.this, "保存失败！", "提示", JOptionPane.ERROR_MESSAGE);
//                    e1.printStackTrace();
//                }
//            }
//        });
//        main.add(saveButton);
        calculateButton = new JButton("确认计算");
        calculateButton.setBounds(width-830,height-560,110,30);
        calculateButton.setFont(new Font("宋体",Font.BOLD,16));
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                harmRank = Calculation.calculateHarmRank(p, 1);
                result.setText(harmRank.getRank());
                resultExpression.setText(harmRank.getExpression());
                nextButton.setEnabled(true);
            }
        });
        main.add(calculateButton);
        JLabel resultLabel = new JLabel("伤害等级:");
        resultLabel.setBounds(180,40,200,30);
        resultLabel.setFont(new Font("宋体",Font.BOLD,16));
        main.add(resultLabel);
        result = new JLabel();
        result.setBounds(260,40,200,30);
        result.setFont(new Font("宋体",Font.BOLD,16));
        main.add(result);
        JLabel expressionLabel = new JLabel("破坏作用:");
        expressionLabel.setBounds(180,80,200,30);
        expressionLabel.setFont(new Font("宋体",Font.BOLD,16));
        main.add(expressionLabel);
        resultExpression = new JLabel();
        resultExpression.setBounds(260,80,1000,30);
        resultExpression.setFont(new Font("宋体",Font.BOLD,16));
        main.add(resultExpression);
        JLabel jPanelTitle = new JLabel("模块3:伤害等级计算");
        jPanelTitle.setBounds(250,8,200,30);
        jPanelTitle.setFont(new Font("宋体",Font.BOLD,18));
        main.add(jPanelTitle);
    }
}
