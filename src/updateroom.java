import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateroom extends JFrame implements ActionListener {
    Choice cid;
    JTextField tfroom, tfavail,tfclean;
    JButton jbcheck,update,back;
    updateroom(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text=new JLabel("UPDATE ROOM STATUS");
        text.setFont(new Font("Tahoma",Font.BOLD,25));
        text.setBounds(30,20,300,30);
        text.setForeground(Color.BLUE);
        add(text);

        JLabel lbid=new JLabel("ID NUMBER");
        lbid.setBounds(30,80,100,30);
        add(lbid);

        cid=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from coustomer");
            while (rs.next()){
                cid.add(rs.getString("id"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        cid.setBounds(200,80,150,30);
        cid.setBackground(Color.WHITE);
        add(cid);

        JLabel lbroom =new JLabel("ROOM NO");
        lbroom.setBounds(30,120,100,30);
        add(lbroom);

        tfroom =new JTextField();
        tfroom.setBounds(200,120,200,30);
        add(tfroom);

        JLabel lbname =new JLabel("AVAILABILITY");
        lbname.setBounds(30,160,100,30);
        add(lbname);

        tfavail =new JTextField();
        tfavail.setBounds(200,160,200,30);
        add(tfavail);


        JLabel lbclean =new JLabel("CLEAN STATUS");
        lbclean.setBounds(30,210,150,30);
        add(lbclean);

        tfclean =new JTextField();
        tfclean.setBounds(200,210,200,30);
        add(tfclean);

        jbcheck=new JButton("CHECK");
        jbcheck.setForeground(Color.WHITE);
        jbcheck.setBackground(Color.BLACK);
        jbcheck.setBounds(30,270,100,30);
        jbcheck.addActionListener(this::actionPerformed);
        add(jbcheck);

        update=new  JButton("UPDATE");
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setBounds(150,270,100,30);
        update.addActionListener(this::actionPerformed);
        add(update);

        back=new JButton("BACK");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(270,270,100,30);
        back.addActionListener(this::actionPerformed);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        JLabel image=new JLabel(i3);
        image.setBounds(450,45,500,300);
        add(image);

        setBounds(300,200,980,400);
        setVisible(true);
    }
    public static void main(String[] args){
        new updateroom();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==jbcheck){
            String id=cid.getSelectedItem();
            String query="select * from coustomer where id='"+id+"'";
            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()){
                    tfroom.setText(rs.getString("roomno"));

                }
                ResultSet rs2=c.s.executeQuery("select * from rooms where roomno = '"+tfroom.getText()+"' ");
                while (rs2.next()){
                    tfclean.setText(rs2.getString("cleaning_status"));
                    tfavail.setText(rs2.getString("availability"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==update) {
            String availability = tfavail.getText();
            String clean=tfclean.getText();
            String room=tfroom.getText();


            try {
                conn c=new conn();
                c.s.executeUpdate("update rooms set availability = '"+availability+"',cleaning_status = '"+clean+"' where roomno = '"+room+"'");

                JOptionPane.showMessageDialog(null,"DATA UPDATE SUCCESSFULLY");
                setVisible(false);
                new reception();

            }catch (Exception e){
                e.printStackTrace();
            }


        } else if (ae.getSource()==back) {
            setVisible(false);
            new reception();

        }


    }
}
