package com.creat.building.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2017/8/31.
 */
public class MenuInterface extends JFrame{

    private JLabel menuLabel;
    private JPanel main;
    private JButton calculate;
    private JButton history;

    public MenuInterface(){
        this("");
    }

    public MenuInterface(String title){
        super(title);
        init();
        setSize(1000,600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init(){
        main = (JPanel) getContentPane();
        main.setLayout(null);
        menuLabel = new JLabel("大口径高压天然气管道物理爆炸对周边建筑物损坏范围的综合估算系统");
        menuLabel.setBounds(5,30,1000,50);
        menuLabel.setFont(new Font("宋体",Font.BOLD,30));
        menuLabel.setForeground(new Color(255, 255, 255));
        main.add(menuLabel);
        main.setBackground(new Color(38, 187, 193));
        calculate = new JButton("分析计算");
        calculate.setBounds(200,200,150,150);
        calculate.setFont(new Font("宋体",Font.BOLD,25));
        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuInterface.this.setVisible(false);
                CalculateEnergyInterface calculationInterface = new CalculateEnergyInterface("大口径高压天然气管道物理爆炸对周边建筑物损坏范围的综合估算系统", MenuInterface.this);
            }
        });
        main.add(calculate);
        history = new JButton("历史记录");
        history.setBounds(600,200,150,150);
        history.setFont(new Font("宋体",Font.BOLD,25));
        history.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuInterface.this.setVisible(false);
                HistoryInterface historyInterface = new HistoryInterface("大口径高压天然气管道物理爆炸对周边建筑物损坏范围的综合估算系统", MenuInterface.this);
            }
        });
        main.add(history);
    }
}
