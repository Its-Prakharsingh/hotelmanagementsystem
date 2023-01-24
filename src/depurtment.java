import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class depurtment extends JFrame implements ActionListener {
    JTable t1;
    JButton b1;
    depurtment(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);



        JLabel l1=new JLabel("DEPURTMENT");
        l1.setBounds(10,10,100,20);
        add(l1);


        JLabel l2=new JLabel("BUDGET");
        l2.setBounds(120,10,100,20);
        add(l2);


        t1=new JTable();
        t1.setBounds(0,50,700,350);
        add(t1);
        try{
            conn c=new conn();
            ResultSet rs =c.s.executeQuery("select * from depurtment");
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
        new depurtment();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new reception();

    }
}
