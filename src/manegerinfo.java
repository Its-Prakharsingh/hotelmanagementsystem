import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class manegerinfo extends JFrame implements ActionListener {
    JTable t1;
    JButton b1;
     manegerinfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);



        JLabel l1=new JLabel("NAME");
        l1.setBounds(10,10,100,20);
        add(l1);


        JLabel l2=new JLabel("AGE");
        l2.setBounds(120,10,100,20);
        add(l2);

        JLabel l3 =new JLabel("SALARY");
        l3.setBounds(230,10,100,20);
        add(l3);

        JLabel l4 =new JLabel("PHONE NUMBER");
        l4.setBounds(350,10,100,20);
        add(l4);


        JLabel l5 =new JLabel("GENDER");
        l5.setBounds(480,10,100,20);
        add(l5);

        JLabel l6 =new JLabel("WORK IN");
        l6.setBounds(600,10,100,20);
        add(l6);


        t1=new JTable();
        t1.setBounds(0,50,700,350);
        add(t1);
        try{
            conn c=new conn();
            ResultSet rs =c.s.executeQuery("select * from employees where job ='MANAGER'");
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
        new manegerinfo();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new reception();

    }
}
