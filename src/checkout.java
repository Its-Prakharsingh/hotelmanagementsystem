import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class checkout extends JFrame implements ActionListener {
    Choice ccid;
    JLabel lblroom,lblcheck;
    JButton jbcheck,jbback;
    checkout() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text=new JLabel("CHECK OUT");
        text.setBounds(100,20,150,30);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        setForeground(Color.BLACK);
        add(text);

        JLabel lbid =new JLabel("ID NUMBER");
        lbid.setBounds(30,80,100,30);
        add(lbid);

        ccid=new Choice();
        ccid.setBounds(150,80,150,25);
        add(ccid);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel tick=new JLabel(i3);
        tick.setBounds(310,80,20,20);
        add(tick);

        JLabel lbroom =new JLabel("ROOM NO");
        lbroom.setBounds(30,130,100,30);
        add(lbroom);

         lblroom =new JLabel();
        lblroom.setBounds(200,130,100,30);
        add(lblroom);

        JLabel lbcheckout =new JLabel("CHECKOUT TIME");
        lbcheckout.setBounds(30,180,140,30);
        add(lbcheckout);
        Date date=new Date();
        lblcheck =new JLabel(""+date);
        lblcheck.setBounds(150,180,140,30);
        add(lblcheck);


        jbcheck=new JButton("CHECKOUT");
        jbcheck.setBackground(Color.BLACK);
        jbcheck.setForeground(Color.WHITE);
        jbcheck.addActionListener(this::actionPerformed);
        jbcheck.setBounds(30,280,120,30);
        add(jbcheck);

        jbback=new JButton("BACK");
        jbback.setBackground(Color.BLACK);
        jbback.setForeground(Color.WHITE);
        jbback.addActionListener(this::actionPerformed);
        jbback.setBounds(200,280,120,30);
        add(jbback);
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5=i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image =new JLabel(i6);
        image.setBounds(350,50,400,250);
        add(image);

        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from coustomer");

            while (rs.next()){
                ccid.add(rs.getString("id"));
                lblroom.setText(rs.getString("roomno"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }


        setBounds(300,200,800,400);
        setVisible(true);
    }
    public static void main(String[]args){
        new checkout();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==jbcheck){
            String query1="delete from coustomer where id ='"+ccid+"'";
            String query2="update rooms set availability = 'Available' where roomno = '"+lblroom.getText()+"'";
            try {
                conn c=new conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"CHECKOUT DONE");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
