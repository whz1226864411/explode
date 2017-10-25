package com.creat.people.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2017/8/31.
 */
public class BackController implements ActionListener{

    private JFrame last;
    private JFrame now;

    private BackController(){

    }
    public BackController(JFrame last,JFrame now){
        this.last = last;
        this.now = now;
    }
    public void actionPerformed(ActionEvent e) {
        now.dispose();
        last.setVisible(true);
    }
}
