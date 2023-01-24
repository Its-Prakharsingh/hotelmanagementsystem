import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class addcoustomer extends JFrame implements ActionListener {

    JComboBox cbid,cbgen;
    JTextField tfid,tfname,tfaddress,tfdiposie;
    JButton jbsub,jbcancle;
    Choice croom;
    addcoustomer(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text=new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);

        JLabel id =new JLabel("ID");
        id.setBounds(35,90,100,20);
        id.setFont(new Font("Raleway",Font.PLAIN,20));
        add(id);

        String option[]={"PASSPORT","ADDHAR CARD","DRIVING LICENSE","RATION CARD"};
        cbid=new JComboBox(option);
        cbid.setBackground(Color.WHITE);
        cbid.setBounds(200,90,150,20);
      //  cbid.addActionListener(this::actionPerformed);
        add(cbid);

        JLabel idnum =new JLabel("ID NUMBER");
        idnum.setBounds(35,140,150,20);
        idnum.setFont(new Font("Raleway",Font.PLAIN,20));
        add(idnum);

        tfid=new JTextField();
        tfid.setBounds(200,140,200,20);
        tfid.addActionListener(this::actionPerformed);
        add(tfid);

        JLabel lbname =new JLabel("NAME");
        lbname.setBounds(35,190,150,20);
        lbname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbname);

        tfname=new JTextField();
        tfname.setBounds(200,190,200,20);
        tfname.addActionListener(this::actionPerformed);
        add(tfname);

        JLabel lbgender =new JLabel("GENDER");
        lbgender.setBounds(35,240,120,30);
        lbgender.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbgender);


        String str[]={"MALE","FEMALE"};
        cbgen =new JComboBox<>(str);
        cbgen.setBounds(200,240,120,30);
        cbgen.addActionListener(this::actionPerformed);
        cbgen.setBackground(Color.WHITE);
        add(cbgen);

        JLabel lbaddress =new JLabel("ADDRESS");
        lbaddress.setBounds(35,300,150,20);
        lbaddress.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbaddress);

        tfaddress=new JTextField();
        tfaddress.setBounds(200,300,200,20);
        tfaddress.addActionListener(this::actionPerformed);
        add(tfaddress);


        JLabel lbprice =new JLabel("DIPOSITE");
        lbprice.setBounds(35,350,150,20);
        lbprice.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbprice);

        tfdiposie=new JTextField();
        tfdiposie.setBounds(200,350,200,20);
        tfdiposie.addActionListener(this::actionPerformed);
        add(tfdiposie);

        JLabel lbroomno =new JLabel("ROOM NO.");
        lbroomno.setBounds(35,400,150,20);
        lbroomno.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbroomno);

        croom =new Choice();
        try{
            conn conn=new conn();
            String query="select * from rooms";
            ResultSet rs= conn.s.executeQuery(query);
            while (rs.next()){
                croom.add(rs.getString("roomno"));
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        croom.setBounds(200,400,150,20);
        add(croom);






        jbsub=new JButton("SUBMIT");
        jbsub.setBounds(45,500,150,30);
        jbsub.setBackground(Color.BLACK);
        jbsub.setForeground(Color.WHITE);
        jbsub.addActionListener(this);
        add(jbsub);

        jbcancle=new JButton("CANCLE");
        jbcancle.setBounds(200,500,150,30);
        jbcancle.setBackground(Color.BLACK);
        jbcancle.setForeground(Color.WHITE);
        jbcancle.addActionListener(this);
        add(jbcancle);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(280,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(100,100,900,400);
        add(image);




        setBounds(350,200,800,600);
        setVisible(true);
    }

    public static void main(String [] args){
        new addcoustomer();

    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        String name=tfname.getText();
        String idnum=tfid.getText();
        String Address=tfaddress.getText();
        String diposite=tfdiposie.getText();
        String room=croom.getSelectedItem();

        String gender=(String) cbgen.getSelectedItem();
        String ID_type=(String) cbid.getSelectedItem();


        if (ae.getSource()==jbcancle) {
            setVisible(false);
            new reception();
        } else if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "NAME SHOULD NOT BE EMPTY");
            return;
        } else if (ae.getSource()==jbsub) {


             try {
                 conn c = new conn();
                 String query = "insert into coustomer values('" + name + "','" + gender + "','" + ID_type + "','" + idnum + "','" + Address + "','" + diposite + "','" + room + "')";
                 String query2 = "update rooms set availability = 'Occupied' where roomno ='" + room + "'";


                 c.s.executeUpdate(query);
                 c.s.executeUpdate(query2);


                 JOptionPane.showMessageDialog(null, "COUSTOMER ADDED SUCCESFULLY");
                 setVisible(false);
                 new reception();

             } catch (Exception e) {
                 e.printStackTrace();
             }
         }




    }
}
