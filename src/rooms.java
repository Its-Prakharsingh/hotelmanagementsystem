import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class rooms extends JFrame implements ActionListener {
    JTable t1;
    JButton b1;
    rooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);

        JLabel l1=new JLabel("ROOM NO");
        l1.setBounds(00,10,100,20);
        add(l1);


        JLabel l2=new JLabel("AVAILABILITY");
        l2.setBounds(100,10,100,20);
        add(l2);

        JLabel l3 =new JLabel("CLEAN STATUS");
        l3.setBounds(200,10,100,20);
        add(l3);

        JLabel l4 =new JLabel("PRICE");
        l4.setBounds(300,10,100,20);
        add(l4);


        JLabel l5 =new JLabel("BED TYPE");
        l5.setBounds(400,10,100,20);
        add(l5);


         t1=new JTable();
         t1.setBounds(0,40,500,400);
         add(t1);
         try{
             conn c=new conn();
            ResultSet rs =c.s.executeQuery("select * from rooms");
            t1.setModel(DbUtils.resultSetToTableModel(rs));

         }catch (Exception e){
             e.printStackTrace();
         }

         b1 =new JButton("BACK");
         b1.addActionListener(this::actionPerformed);
         b1.setBounds(200,500,120,30);
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         add(b1);




        setBounds(300,200,1050,600);
        setVisible(true);


    }
    public static void  main(String[] args){
        new rooms();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new reception();

    }
}
