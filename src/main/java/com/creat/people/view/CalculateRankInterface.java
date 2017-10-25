package com.creat.people.view;

import com.creat.people.calculate.Calculation;
import com.creat.people.controller.BackController;
import com.creat.people.controller.HistoryController;
import com.creat.people.po.EnergyParams;
import com.creat.people.po.HarmRank;
import com.creat.people.po.PeopleHarmHistory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;

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
    private JButton saveButton;
    private EnergyParams energyParams;
    private int el;
    private JTextField fieldSafe;
    private double p;
    private HarmRank harmRank;

    private CalculateRankInterface(){
    }

    public CalculateRankInterface(String title, JFrame parent,EnergyParams energyParams,int el,double p){
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
        saveButton = new JButton("保存记录");
        saveButton.setBounds(width-830,height-520,110,30);
        saveButton.setFont(new Font("宋体",Font.BOLD,16));
        saveButton.setEnabled(false);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    PeopleHarmHistory peopleHarmHistory = new PeopleHarmHistory();
                    peopleHarmHistory.setEnergyParams(energyParams);
                    peopleHarmHistory.setEl(el);
                    peopleHarmHistory.setP(p);
                    peopleHarmHistory.setHarmRank(harmRank);
                    peopleHarmHistory.setDate(new Date());
                    HistoryController<PeopleHarmHistory> historyController = new HistoryController<PeopleHarmHistory>();
                    historyController.saveHistory(peopleHarmHistory,"data/PeopleHarmHistory.dat");
                    JOptionPane.showMessageDialog(CalculateRankInterface.this, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(CalculateRankInterface.this, "保存失败！", "提示", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                }
            }
        });
        main.add(saveButton);
        calculateButton = new JButton("确认计算");
        calculateButton.setBounds(width-830,height-560,110,30);
        calculateButton.setFont(new Font("宋体",Font.BOLD,16));
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String r = CalculateRankInterface.this.fieldSafe.getText();
                if(r == null || r.isEmpty()){
                    JOptionPane.showMessageDialog(CalculateRankInterface.this, "所有参数必须填写！", "提示", JOptionPane.ERROR_MESSAGE);
                }else {
                    harmRank = Calculation.calculateHarmRank(p, Double.valueOf(r));
                    result.setText(harmRank.getRank());
                    resultExpression.setText(harmRank.getExpression());
                    saveButton.setEnabled(true);
                }
            }
        });
        main.add(calculateButton);
        JLabel jPanelTip = new JLabel("请输入安全系数:");
        jPanelTip.setBounds(10,40,200,30);
        jPanelTip.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jPanelTip);
        fieldSafe = new JTextField();
        fieldSafe.setBounds(140,40,50,30);
        main.add(fieldSafe);
        JLabel resultLabel = new JLabel("伤害等级:");
        resultLabel.setBounds(380,40,200,30);
        resultLabel.setFont(new Font("宋体",Font.BOLD,16));
        main.add(resultLabel);
        result = new JLabel();
        result.setBounds(460,40,200,30);
        result.setFont(new Font("宋体",Font.BOLD,16));
        main.add(result);
        JLabel expressionLabel = new JLabel("临床表现:");
        expressionLabel.setBounds(380,80,200,30);
        expressionLabel.setFont(new Font("宋体",Font.BOLD,16));
        main.add(expressionLabel);
        resultExpression = new JLabel();
        resultExpression.setBounds(460,80,200,30);
        resultExpression.setFont(new Font("宋体",Font.BOLD,16));
        main.add(resultExpression);
        JLabel jPanelTitle = new JLabel("模块3:伤害等级计算");
        jPanelTitle.setBounds(250,8,200,30);
        jPanelTitle.setFont(new Font("宋体",Font.BOLD,18));
        main.add(jPanelTitle);
    }
}
