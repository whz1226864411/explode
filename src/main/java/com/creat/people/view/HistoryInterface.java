package com.creat.people.view;

import com.creat.people.controller.BackController;
import com.creat.people.controller.HistoryController;
import com.creat.people.po.PeopleHarmHistory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created by whz on 2017/9/10.
 */
public class HistoryInterface extends JFrame{

    private JButton back;
    private JPanel main;
    private JFrame parent;
    private JLabel title;
    private DefaultTableModel model;
    private JTable table;

    private HistoryInterface(){

    }

    public HistoryInterface(String title,JFrame parent){
        super(title);
        this.parent = parent;
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
        back = new JButton("返回菜单");
        back.setBounds(800,500,110,30);
        back.setFont(new Font("宋体",Font.BOLD,16));
        back.addActionListener(new BackController(this.parent,this));
        main.add(back);
        title = new JLabel("历史记录");
        title.setBounds(420,5,150,50);
        title.setFont(new Font("宋体",Font.BOLD,25));
        main.add(title);
        String[][] datas = {};
        String[] titles = { "日期", "爆炸能量","峰值超压","破坏等级","破坏作用" };
        model = new DefaultTableModel(datas, titles);
        HistoryController<PeopleHarmHistory> harm = new HistoryController<PeopleHarmHistory>();
        try {
            List<PeopleHarmHistory> list = harm.readAllHistories("data/PeopleHarmHistory.dat");
            for(PeopleHarmHistory peopleHarmHistory : list){
                System.out.println(peopleHarmHistory.getP());
                model.addRow(new String[] { peopleHarmHistory.getDate().toString(), peopleHarmHistory.getEl().toString(), peopleHarmHistory.getP().toString()
                            ,peopleHarmHistory.getHarmRank().getRank(), peopleHarmHistory.getHarmRank().getExpression()});
            }
        } catch (IOException e) {
           // e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }
        table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(35,60,900,420);
        main.add(pane);
    }
}
