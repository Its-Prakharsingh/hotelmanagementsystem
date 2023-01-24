import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updatestatus extends JFrame implements ActionListener {
    Choice cid;
    JTextField tfroom,tfname,tfpaid,tfpending;
    JButton jbcheck,update,back;
    updatestatus(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text=new JLabel("UPDATE STATUS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(90,20,200,30);
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

        JLabel lbname =new JLabel("NAME");
        lbname.setBounds(30,160,100,30);
        add(lbname);

        tfname =new JTextField();
        tfname.setBounds(200,160,200,30);
        add(tfname);

        JLabel lbamount =new JLabel("AMOUNT PAID");
        lbamount.setBounds(30,200,100,30);
        add(lbamount);

        tfpaid =new JTextField();
        tfpaid.setBounds(200,200,200,30);
        add(tfpaid);

        JLabel lbPENDING =new JLabel("PENDING AMOUNT");
        lbPENDING.setBounds(30,240,150,30);
        add(lbPENDING);

        tfpending =new JTextField();
        tfpending.setBounds(200,240,200,30);
        add(tfpending);

        jbcheck=new JButton("CHECK");
        jbcheck.setForeground(Color.WHITE);
        jbcheck.setBackground(Color.BLACK);
        jbcheck.setBounds(30,350,150,30);
        jbcheck.addActionListener(this::actionPerformed);
        add(jbcheck);

        update=new  JButton("UPDATE");
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setBounds(200,350,150,30);
        update.addActionListener(this::actionPerformed);
        add(update);

        back=new JButton("BACK");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(370,350,150,30);
        back.addActionListener(this::actionPerformed);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);

        setBounds(300,200,980,450);
        setVisible(true);
    }
    public static void main(String[] args){
        new updatestatus();
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
                    tfname.setText(rs.getString("name"));
                    tfroom.setText(rs.getString("roomno"));
                    tfpaid.setText(rs.getString("diposite"));
                }
                ResultSet rs2=c.s.executeQuery("select * from rooms where roomno = '"+tfroom.getText()+"' ");
                while (rs2.next()){
                    String price=rs2.getString("price");
                    int amountpaid=Integer.parseInt(price)-Integer.parseInt(tfpaid.getText());
                    tfpending.setText(" " + amountpaid);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==update) {
            String number=cid.getSelectedItem();
            String room=tfroom.getText();
            String name=tfname.getText();
            String diposite=tfpaid.getText();

            try {
                conn c=new conn();
                c.s.executeUpdate("update coustomer set roomno = '"+room+"',diposite = '"+diposite+"',name = '"+name+"'");

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