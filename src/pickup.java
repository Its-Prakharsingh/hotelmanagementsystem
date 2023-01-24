import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class pickup extends JFrame implements ActionListener {
    JTable t1;
    JButton b1,b2;
    Choice ccar;

    pickup(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text=new JLabel("PICK UP SERVICE");
        text.setFont(new Font("Tahoma",Font.ITALIC,20));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel lbbed=new JLabel("TYPE OF CAR");
        lbbed.setBounds(50,100,100,20);
        add(lbbed);

        ccar=new Choice();
        ccar.setBounds(150,100,250,25);
        add(ccar);



        JLabel l1=new JLabel("NAME");
        l1.setBounds(00,170,100,20);
        add(l1);


        JLabel l2=new JLabel("AGE");
        l2.setBounds(200,170,100,20);
        add(l2);

        JLabel l3 =new JLabel("CAR NO");
        l3.setBounds(400,170,100,20);
        add(l3);

        JLabel l4 =new JLabel("SALARY");
        l4.setBounds(600,170,100,20);
        add(l4);


        JLabel l5 =new JLabel("PHONE NO");
        l5.setBounds(800,170,100,20);
        add(l5);

        JLabel l7 =new JLabel("CAR MODEL");
        l7.setBounds(900,170,100,20);
        add(l7);


        t1=new JTable();
        t1.setBounds(0,200,1000,300);
        add(t1);
        try{
            conn c=new conn();
            ResultSet rs =c.s.executeQuery("select * from driver");
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

        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while (rs.next()){
                ccar.add(rs.getString("carmodel"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }




        setBounds(300,200,1050,600);
        setVisible(true);


    }
    public static void  main(String[] args){
        new pickup();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==b1){
            try{
                String q1="select * from driver where carmodel='"+ccar.getSelectedItem()+"'";

                conn conn=new conn();
                ResultSet rs;

                rs=conn.s.executeQuery(q1);


                t1.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==b2){
            setVisible(false);
            new reception();}

    }
}
