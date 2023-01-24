import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class searchrooms extends JFrame implements ActionListener {
    JTable t1;
    JButton b1,b2;
    JComboBox bedtype;
    JCheckBox avail;
    searchrooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

       JLabel text=new JLabel("SEARCH ROOMS");
       text.setFont(new Font("Tahoma",Font.ITALIC,20));
       text.setBounds(400,30,200,30);
       add(text);

       JLabel lbbed=new JLabel("BED TYPE");
       lbbed.setBounds(50,100,100,20);
       add(lbbed);

       bedtype=new JComboBox<>(new String[]{"Single","Double"});
       bedtype.setBounds(150,100,150,25);
       bedtype.setBackground(Color.WHITE);
       add(bedtype);

        JLabel l1=new JLabel("ROOM NO");
        l1.setBounds(00,170,100,20);
        add(l1);

        avail=new JCheckBox("Only diplay available");
        avail.setBounds(650,100,150,25);
        avail.setBackground(Color.WHITE);
        add(avail);


        JLabel l2=new JLabel("AVAILABILITY");
        l2.setBounds(200,170,100,20);
        add(l2);

        JLabel l3 =new JLabel("CLEAN STATUS");
        l3.setBounds(400,170,100,20);
        add(l3);

        JLabel l4 =new JLabel("PRICE");
        l4.setBounds(600,170,100,20);
        add(l4);


        JLabel l5 =new JLabel("BED TYPE");
        l5.setBounds(800,170,100,20);
        add(l5);


        t1=new JTable();
        t1.setBounds(0,200,1000,300);
        add(t1);
        try{
            conn c=new conn();
            ResultSet rs =c.s.executeQuery("select * from rooms");
            t1.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }

        b1 =new JButton("SUBMIT");
        b1.addActionListener(this::actionPerformed);
        b1.setBounds(300,500,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 =new JButton("BACK");
        b2.addActionListener(this::actionPerformed);
        b2.setBounds(600,500,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);




        setBounds(300,200,1050,600);
        setVisible(true);


    }
    public static void  main(String[] args){
        new searchrooms();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==b1){
            try{
                String q1="select * from rooms where bed_type='"+bedtype.getSelectedItem()+"'";
                String q2="select * from rooms where availability ='Available' and bed_type='"+bedtype.getSelectedItem()+"'";
                conn conn=new conn();
                ResultSet rs;
                if (avail.isSelected()){
                    rs=conn.s.executeQuery(q2);

                }else {
                     rs=conn.s.executeQuery(q1);

                }
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==b2){
        setVisible(false);
        new reception();}

    }
}