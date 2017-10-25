package com.creat.people.controller;

import com.creat.people.po.Account;
import com.creat.people.view.MenuInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2017/8/31.
 */
public class LoginController implements ActionListener {

    private JTextField accountText;
    private JPasswordField passwordField;
    private JFrame loginView;
    private Properties properties = new Properties();
    private MenuInterface menuInterface;
    private LoginController(){

    }
    public LoginController(JFrame loginView, JTextField accountText, JPasswordField passwordField){
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("account/account.properties"));
            this.loginView = loginView;
            this.accountText = accountText;
            this.passwordField = passwordField;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent e) {
        Account account = new Account();
        account.setUserName(accountText.getText());
        account.setPassword(new String(passwordField.getPassword()));
        String password = properties.getProperty(account.getUserName());
        if(password != null && password.equals(account.getPassword())){
            loginView.dispose();
            menuInterface = new MenuInterface("大口径高压天然气管道物理爆炸冲击波对人员伤害范围的计算系统");
        }else {
            JOptionPane.showMessageDialog(loginView, "账号或密码错误！", "提示", JOptionPane.ERROR_MESSAGE);
        }
    }
}
