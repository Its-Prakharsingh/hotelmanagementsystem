import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class coustomerinfo extends JFrame implements ActionListener {
    JTable t1;
    JButton b1;
    coustomerinfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);



        JLabel l1=new JLabel("NAME");
        l1.setBounds(10,10,100,20);
        add(l1);


        JLabel l2=new JLabel("GENDER");
        l2.setBounds(140,10,100,20);
        add(l2);

        JLabel l3 =new JLabel("ID TYPE");
        l3.setBounds(300,10,100,20);
        add(l3);

        JLabel l4 =new JLabel("PHONE NUMBER");
        l4.setBounds(420,10,100,20);
        add(l4);


        JLabel l5 =new JLabel("CITY");
        l5.setBounds(600,10,100,20);
        add(l5);



        t1=new JTable();
        t1.setBounds(0,50,700,350);
        add(t1);
        try{
            conn c=new conn();
            ResultSet rs =c.s.executeQuery("select * from coustomer");
            t1.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }

        b1 =new JButton("BACK");
        b1.addActionListener(this::actionPerformed);
        b1.setBounds(200,400,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);




        setBounds(400,200,750,480);
        setVisible(true);


    }
    public static void  main(String[] args){
        new coustomerinfo();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new reception();

    }
}
