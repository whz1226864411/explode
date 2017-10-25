package com.creat.building.view;

import com.creat.building.calculate.Calculation;
import com.creat.building.controller.BackController;
import com.creat.building.controller.HistoryController;
import com.creat.building.po.BuildingHarmHistory;
import com.creat.building.po.EnergyParams;
import com.creat.building.po.HarmRank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/17.
 */
public class RangeInterface extends JFrame {

    private int width;
    private int height;

    //组件
    private JButton back;
    private JPanel main;
    private JFrame parent;
    private JButton calculateButton;
    private JButton saveButton;
    private JTextField fieldA;
    private JTextField fieldK;
    private JTextField fieldV;

    //参数
    private EnergyParams energyParams;
    private int el;
    private double p;
    private HarmRank harmRank;

    private RangeInterface(){
    }

    public RangeInterface(String title, JFrame parent, EnergyParams energyParams, int el, double p, HarmRank harmRank){
        super(title);
        this.parent = parent;
        this.energyParams = energyParams;
        this.p = p;
        this.el = el;
        this.harmRank = harmRank;
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

        JLabel jPanelTip = new JLabel("请输入参数:");
        jPanelTip.setBounds(10,40,200,30);
        jPanelTip.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jPanelTip);

        JLabel jLabelA = new JLabel("衰减指数α:");
        jLabelA.setBounds(110,40,200,30);
        jLabelA.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelA);
        fieldA = new JTextField();
        fieldA.setBounds(250,40,50,30);
        main.add(fieldA);

        JLabel jLabelK = new JLabel("场地系数K:");
        jLabelK.setBounds(110,85,200,30);
        jLabelK.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelK);
        fieldK = new JTextField();
        fieldK.setBounds(250,85,50,30);
        main.add(fieldK);

        JLabel jLabelV = new JLabel("振动安全阈值:");
        jLabelV.setBounds(110,130,200,30);
        jLabelV.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelV);
        fieldV = new JTextField();
        fieldV.setBounds(250,130,50,30);
        main.add(fieldV);
        JLabel jLabelVDw = new JLabel("cm/s");
        jLabelVDw.setBounds(310,130,200,30);
        jLabelVDw.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelVDw);

        JLabel resultLabel = new JLabel("计算结果:");
        resultLabel.setBounds(380,40,200,30);
        resultLabel.setFont(new Font("宋体",Font.BOLD,16));
        main.add(resultLabel);
        final JLabel result = new JLabel();
        result.setBounds(460,40,200,30);
        result.setFont(new Font("宋体",Font.BOLD,16));
        main.add(result);

        back = new JButton("返回菜单");
        back.setBounds(width-830,height-470,110,30);
        back.setFont(new Font("宋体",Font.BOLD,16));
        back.addActionListener(new BackController(this.parent,this));
        main.add(back);

        calculateButton = new JButton("确认计算");
        calculateButton.setBounds(width-830,height-560,110,30);
        calculateButton.setFont(new Font("宋体",Font.BOLD,16));
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean haveParams = verify();
                if(!haveParams){
                    JOptionPane.showMessageDialog(RangeInterface.this, "所有参数必须填写！", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //进行计算
                result.setText(String.valueOf(Calculation.calculateRs(el)));
                saveButton.setEnabled(true);
            }
        });
        main.add(calculateButton);

        saveButton = new JButton("保存记录");
        saveButton.setBounds(width-830,height-520,110,30);
        saveButton.setFont(new Font("宋体",Font.BOLD,16));
        saveButton.setEnabled(false);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    BuildingHarmHistory buildHarmHistory = new BuildingHarmHistory();
                    buildHarmHistory.setEnergyParams(energyParams);
                    buildHarmHistory.setEl(el);
                    buildHarmHistory.setP(p);
                    buildHarmHistory.setHarmRank(harmRank);
                    buildHarmHistory.setDate(new Date());
                    buildHarmHistory.setR(Double.valueOf(result.getText()));
                    HistoryController<BuildingHarmHistory> historyController = new HistoryController<BuildingHarmHistory>();
                    historyController.saveHistory(buildHarmHistory,"data/BuildingHarmHistory.dat");
                    JOptionPane.showMessageDialog(RangeInterface.this, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(RangeInterface.this, "保存失败！", "提示", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                }
            }
        });
        main.add(saveButton);

        JLabel jPanelTitle = new JLabel("模块4:爆炸对建筑物影响范围半径计算");
        jPanelTitle.setBounds(150,8,500,30);
        jPanelTitle.setFont(new Font("宋体",Font.BOLD,18));
        main.add(jPanelTitle);
    }

    private boolean verify(){
        if(fieldA.getText() == null || fieldA.getText().isEmpty()){
            return false;
        }
        if(fieldK.getText() == null || fieldK.getText().isEmpty()){
            return false;
        }
        if(fieldV.getText() == null || fieldV.getText().isEmpty()){
            return false;
        }
        return true;
    }
}
