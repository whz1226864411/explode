package com.creat.people.view;

import com.creat.people.calculate.Calculation;
import com.creat.people.controller.BackController;
import com.creat.people.po.EnergyParams;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2017/9/1.
 */
public class CalculatePeekInterface extends JFrame{
    private int width;
    private int height;
    private JButton back;
    private JPanel main;
    private JFrame parent;
    private JButton calculateButton;
    private JLabel result;
    private JButton nextButton;
    private EnergyParams energyParams;
    private int el;
    private JTextField fieldDistance;
    private JLabel distanceDw;

    private CalculatePeekInterface(){
    }

    public CalculatePeekInterface(String title, JFrame parent,EnergyParams energyParams,int el){
        super(title);
        this.parent = parent;
        this.energyParams = energyParams;
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
                CalculatePeekInterface.this.dispose();
                CalculateRankInterface calculateRankInterface =
                        new CalculateRankInterface("大口径高压天然气管道物理爆炸冲击波对人员伤害范围的计算系统",
                                parent,energyParams,el,Double.valueOf(result.getText()));
            }
        });
        main.add(nextButton);
        calculateButton = new JButton("确认计算");
        calculateButton.setBounds(width-830,height-560,110,30);
        calculateButton.setFont(new Font("宋体",Font.BOLD,16));
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String r = CalculatePeekInterface.this.fieldDistance.getText();
                if(r == null || r.isEmpty()){
                    JOptionPane.showMessageDialog(CalculatePeekInterface.this, "所有参数必须填写！", "提示", JOptionPane.ERROR_MESSAGE);
                }else {
                    double resultP = Calculation.calculateP(el,Double.valueOf(r));
                    result.setText(String.valueOf(resultP));
                    nextButton.setEnabled(true);
                }
            }
        });
        main.add(calculateButton);
        JLabel jPanelTip = new JLabel("请输入距离:");
        jPanelTip.setBounds(10,40,200,30);
        jPanelTip.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jPanelTip);
        fieldDistance = new JTextField();
        fieldDistance.setBounds(110,40,50,30);
        main.add(fieldDistance);
        distanceDw = new JLabel("m");
        distanceDw.setBounds(170,40,200,30);
        distanceDw.setFont(new Font("宋体",Font.BOLD,16));
        main.add(distanceDw);
        JLabel resultLabel = new JLabel("计算结果:");
        resultLabel.setBounds(380,40,200,30);
        resultLabel.setFont(new Font("宋体",Font.BOLD,16));
        main.add(resultLabel);
        result = new JLabel();
        result.setBounds(460,40,200,30);
        result.setFont(new Font("宋体",Font.BOLD,16));
        main.add(result);
        JLabel jPanelTitle = new JLabel("模块2:峰值超压计算");
        jPanelTitle.setBounds(250,8,200,30);
        jPanelTitle.setFont(new Font("宋体",Font.BOLD,18));
        main.add(jPanelTitle);
    }

}
