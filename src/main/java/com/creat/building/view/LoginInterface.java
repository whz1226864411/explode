package com.creat.building.view;

import com.creat.building.controller.LoginController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2017/8/31.
 */
public class LoginInterface extends JFrame{

    private ImageIcon background;
    private JLabel backgroundLabel;
    private JLabel accountLabel;
    private JLabel passwordLabel;
    private JTextField accountText;
    private JPasswordField passwordField;
    private JPanel imagePanel;
    private JButton loginButton;
    public LoginInterface(){
        this("");
    }

    public LoginInterface(String title){
        super(title);
        init();
        setSize(background.getIconWidth(), background.getIconHeight());
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init(){
        background = new ImageIcon(getClass().getClassLoader().getResource("pic/trq.jpg"));
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0,0,background.getIconWidth(), background.getIconHeight());
        getLayeredPane().add(backgroundLabel,new Integer(Integer.MIN_VALUE));
        imagePanel = (JPanel) getContentPane();
        imagePanel.setOpaque(false);
        imagePanel.setLayout(null);
        accountLabel = new JLabel("账号:");
        accountLabel.setBounds(180,180,50,50);
        accountLabel.setFont(new Font("宋体",Font.BOLD,16));
        imagePanel.add(accountLabel);
        accountText = new JTextField();
        accountText.setBounds(230,192,120,25);
        imagePanel.add(accountText);
        passwordLabel = new JLabel("密码:");
        passwordLabel.setBounds(180,220,50,50);
        passwordLabel.setFont(new Font("宋体",Font.BOLD,16));
        imagePanel.add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setBounds(230,232,120,25);
        imagePanel.add(passwordField);
        loginButton = new JButton("登录");
        loginButton.setFont(new Font("宋体",Font.BOLD,16));
        loginButton.setBounds(250,265,70,40);
        loginButton.addActionListener(new LoginController(this,accountText,passwordField));
        imagePanel.add(loginButton);
    }
}
