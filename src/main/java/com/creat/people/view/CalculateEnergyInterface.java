package com.creat.people.view;

import com.creat.people.calculate.Calculation;
import com.creat.people.controller.BackController;
import com.creat.people.po.EnergyParams;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2017/8/31.
 */
@SuppressWarnings("ALL")
public class CalculateEnergyInterface extends JFrame{

    private int width;
    private int height;
    private JButton back;
    private JPanel main;
    private JFrame parent;
    private JLabel jLabelP1;
    private JTextField fieldP1;
    private JLabel jLabelP1Dw;
    private JLabel jLabelD;
    private JTextField fieldD;
    private JLabel jLabelDDw;
    private JLabel jLabelH;
    private JTextField fieldH;
    private JLabel jLabelHDw;
    private JLabel jLabelGA;
    private JTextField fieldGA;
    private JLabel jLabelP0;
    private JTextField fieldP0;
    private JLabel jLabelP0Dw;
    private JLabel jLabelSD;
    private JTextField fieldSD;
    private JLabel jLabelSDDw;
    private JLabel jLabelH1;
    private JTextField fieldH1;
    private JLabel jLabelH1Dw;
    private JLabel jLabelH2;
    private JTextField fieldH2;
    private JLabel jLabelH2Dw;
    private JLabel jLabelL1;
    private JTextField fieldL1;
    private JLabel jLabelL1Dw;
    private JLabel jLabelL2;
    private JTextField fieldL2;
    private JLabel jLabelL2Dw;
    private JLabel jLabelCF;
    private JTextField fieldCF;
    private JButton calculateButton;
    private JLabel result;
    private JButton nextButton;
    private EnergyParams energyParams;

    private CalculateEnergyInterface(){
    }

    public CalculateEnergyInterface(String title, JFrame parent){
        super(title);
        this.parent = parent;
        init();
        setSize(width-700,height-200);
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
        back.setBounds(width-830,height-270,110,30);
        back.setFont(new Font("宋体",Font.BOLD,16));
        back.addActionListener(new BackController(this.parent,this));
        main.add(back);
        nextButton = new JButton("下一步");
        nextButton.setBounds(width-830,height-320,110,30);
        nextButton.setFont(new Font("宋体",Font.BOLD,16));
        nextButton.setEnabled(false);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CalculateEnergyInterface.this.dispose();
                CalculatePeekInterface calculatePeekInterface = new CalculatePeekInterface("大口径高压天然气管道物理爆炸冲击波对人员伤害范围的计算系统",
                        CalculateEnergyInterface.this.parent,CalculateEnergyInterface.this.energyParams,
                        Integer.valueOf(CalculateEnergyInterface.this.result.getText()));
            }
        });
        main.add(nextButton);
        calculateButton = new JButton("确认计算");
        calculateButton.setBounds(width-830,height-370,110,30);
        calculateButton.setFont(new Font("宋体",Font.BOLD,16));
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CalculateEnergyInterface.this.energyParams = getEnergyParams();
                if(CalculateEnergyInterface.this.energyParams != null){
                    int result = Calculation.calculateEnergy(CalculateEnergyInterface.this.energyParams);
                    CalculateEnergyInterface.this.result.setText(""+result);
                    nextButton.setEnabled(true);
                }else {
                    JOptionPane.showMessageDialog(CalculateEnergyInterface.this, "所有参数必须填写！", "提示", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        main.add(calculateButton);
        JLabel jPanelTip = new JLabel("请输入参数:");
        jPanelTip.setBounds(10,40,200,30);
        jPanelTip.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jPanelTip);
        JLabel resultLabel = new JLabel("计算结果:");
        resultLabel.setBounds(380,40,200,30);
        resultLabel.setFont(new Font("宋体",Font.BOLD,16));
        main.add(resultLabel);
        result = new JLabel();
        result.setBounds(460,40,200,30);
        result.setFont(new Font("宋体",Font.BOLD,16));
        main.add(result);
        JLabel jPanelTitle = new JLabel("模块1:线物理爆炸能量计算");
        jPanelTitle.setBounds(250,8,300,30);
        jPanelTitle.setFont(new Font("宋体",Font.BOLD,18));
        main.add(jPanelTitle);
        jLabelP1 = new JLabel("管内气体初始压力");
        jLabelP1.setBounds(110,40,200,30);
        jLabelP1.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelP1);
        fieldP1 = new JTextField();
        fieldP1.setBounds(250,40,50,30);
        main.add(fieldP1);
        jLabelP1Dw = new JLabel("Pa");
        jLabelP1Dw.setBounds(310,40,200,30);
        jLabelP1Dw.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelP1Dw);
        jLabelL1 = new JLabel("管道敷设沟下开口");
        jLabelL1.setBounds(110,85,200,30);
        jLabelL1.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelL1);
        fieldL1 = new JTextField();
        fieldL1.setBounds(250,85,50,30);
        main.add(fieldL1);
        jLabelL1Dw = new JLabel("m");
        jLabelL1Dw.setBounds(310,85,200,30);
        jLabelL1Dw.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelL1Dw);
        jLabelL2 = new JLabel("管道敷设沟上开口");
        jLabelL2.setBounds(110,130,200,30);
        jLabelL2.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelL2);
        fieldL2 = new JTextField();
        fieldL2.setBounds(250,130,50,30);
        main.add(fieldL2);
        jLabelL2Dw = new JLabel("m");
        jLabelL2Dw.setBounds(310,130,200,30);
        jLabelL2Dw.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelL2Dw);
        jLabelD = new JLabel("管  道   外  径");
        jLabelD.setBounds(110,175,200,30);
        jLabelD.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelD);
        fieldD = new JTextField();
        fieldD.setBounds(250,175,50,30);
        main.add(fieldD);
        jLabelDDw = new JLabel("m");
        jLabelDDw.setBounds(310,175,200,30);
        jLabelDDw.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelDDw);
        jLabelH = new JLabel("管  道   壁  厚");
        jLabelH.setBounds(110,220,200,30);
        jLabelH.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelH);
        fieldH = new JTextField();
        fieldH.setBounds(250,220,50,30);
        main.add(fieldH);
        jLabelHDw = new JLabel("m");
        jLabelHDw.setBounds(310,220,200,30);
        jLabelHDw.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelHDw);
        jLabelP0 = new JLabel("大  气   压  力");
        jLabelP0.setBounds(110,265,200,30);
        jLabelP0.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelP0);
        fieldP0 = new JTextField();
        fieldP0.setBounds(250,265,50,30);
        main.add(fieldP0);
        jLabelP0Dw = new JLabel("Pa");
        jLabelP0Dw.setBounds(310,265,200,30);
        jLabelP0Dw.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelP0Dw);
        jLabelSD = new JLabel("土  壤   密  度");
        jLabelSD.setBounds(110,310,200,30);
        jLabelSD.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelSD);
        fieldSD = new JTextField();
        fieldSD.setBounds(250,310,50,30);
        main.add(fieldSD);
        jLabelSDDw = new JLabel("kg/m^3");
        jLabelSDDw.setBounds(310,310,200,30);
        jLabelSDDw.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelSDDw);
        jLabelH1 = new JLabel("管  体   埋  深");
        jLabelH1.setBounds(110,355,200,30);
        jLabelH1.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelH1);
        fieldH1 = new JTextField();
        fieldH1.setBounds(250,355,50,30);
        main.add(fieldH1);
        jLabelH1Dw = new JLabel("m");
        jLabelH1Dw.setBounds(310,355,200,30);
        jLabelH1Dw.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelH1Dw);
        jLabelCF = new JLabel("修  正   系  数");
        jLabelCF.setBounds(110,400,200,30);
        jLabelCF.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelCF);
        fieldCF = new JTextField();
        fieldCF.setBounds(250,400,50,30);
        main.add(fieldCF);
        jLabelH2 = new JLabel("覆 土 抛掷 高 度");
        jLabelH2.setBounds(110,445,200,30);
        jLabelH2.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelH2);
        fieldH2 = new JTextField();
        fieldH2.setBounds(250,445,50,30);
        main.add(fieldH2);
        jLabelH2Dw = new JLabel("m");
        jLabelH2Dw.setBounds(310,445,200,30);
        jLabelH2Dw.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelH2Dw);
        jLabelGA = new JLabel("气 体 绝热 指 数");
        jLabelGA.setBounds(110,490,200,30);
        jLabelGA.setFont(new Font("宋体",Font.BOLD,16));
        main.add(jLabelGA);
        fieldGA = new JTextField();
        fieldGA.setBounds(250,490,50,30);
        main.add(fieldGA);
    }

    private EnergyParams getEnergyParams(){
        EnergyParams energyParams = new EnergyParams();
        String correctionFactor = fieldCF.getText();
        String P1 = fieldP1.getText();
        String d = fieldD.getText();
        String h = fieldH.getText();
        String gasAdiabat = fieldGA.getText();
        String P0= fieldP0.getText();
        String soilDensity= fieldSD.getText();
        String H1= fieldH1.getText();
        String H2= fieldH2.getText();
        String L1= fieldL1.getText();
        String L2= fieldL2.getText();
        if(correctionFactor != null && !correctionFactor.isEmpty()){
            energyParams.setCorrectionFactor(Double.valueOf(correctionFactor));
        }else {
            return null;
        }
        if(P1 != null && !P1.isEmpty()){
            energyParams.setP1(Double.valueOf(P1));
        }else {
            return null;
        }
        if(d != null && !d.isEmpty()){
            energyParams.setD(Double.valueOf(d));
        }else {
            return null;
        }
        if(h != null && !h.isEmpty()){
            energyParams.setH(Double.valueOf(h));
        }else {
            return null;
        }
        if(gasAdiabat != null && !gasAdiabat.isEmpty()){
            energyParams.setGasAdiabat(Double.valueOf(gasAdiabat));
        }else {
            return null;
        }
        if(P0 != null && !P0.isEmpty()){
            energyParams.setP0(Double.valueOf(P0));
        }else {
            return null;
        }
        if(soilDensity != null && !soilDensity.isEmpty()){
            energyParams.setSoilDensity(Double.valueOf(soilDensity));
        }else {
            return null;
        }
        if(H1 != null && !H1.isEmpty()){
            energyParams.setH1(Double.valueOf(H1));
        }else {
            return null;
        }
        if(H2 != null && !H2.isEmpty()){
            energyParams.setH2(Double.valueOf(H2));
        }else {
            return null;
        }
        if(L1 != null && !L1.isEmpty()){
            energyParams.setL1(Double.valueOf(L1));
        }else {
            return null;
        }
        if(L2 != null && !L2.isEmpty()){
            energyParams.setL2(Double.valueOf(L2));
        }else {
            return null;
        }
        return energyParams;
    }
}
