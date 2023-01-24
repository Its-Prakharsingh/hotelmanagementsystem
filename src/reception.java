import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reception extends JFrame implements ActionListener {

    JButton newcoustomer,rooms,depurtment,allEmployeesyee,managerinfo,coustomer,checkout,updatestatus,searchrooms,pickup,logout,updateroomstatus;
    reception(){
        setLayout(null);

        newcoustomer =new JButton("NEW COUSTOMER");
        newcoustomer.setBounds(10,30,200,30);
        newcoustomer.setForeground(Color.WHITE);
        newcoustomer.setBackground(Color.BLACK);
        newcoustomer.addActionListener(this::actionPerformed);
        add(newcoustomer);

         rooms =new JButton("ROOMS");
        rooms.setBounds(10,70,200,30);
        rooms.setForeground(Color.WHITE);
        rooms.setBackground(Color.BLACK);
        rooms.addActionListener(this::actionPerformed);
        add(rooms);

         depurtment =new JButton("DEPURTMENT");
        depurtment.setBounds(10,110,200,30);
        depurtment.setForeground(Color.WHITE);
        depurtment.setBackground(Color.BLACK);
        depurtment.addActionListener(this::actionPerformed);
        add(depurtment);

         allEmployeesyee =new JButton("ALL EMPLOYEES");
        allEmployeesyee.setBounds(10,150,200,30);
        allEmployeesyee.setForeground(Color.WHITE);
        allEmployeesyee.setBackground(Color.BLACK);
        allEmployeesyee.addActionListener(this::actionPerformed);
        add(allEmployeesyee);


         coustomer =new JButton("COUSTOMER INFO");
        coustomer.setBounds(10,190,200,30);
        coustomer.setForeground(Color.WHITE);
        coustomer.setBackground(Color.BLACK);
        coustomer.addActionListener(this::actionPerformed);
        add(coustomer);

         managerinfo =new JButton("MANEGER INFO");
        managerinfo.setBounds(10,230,200,30);
        managerinfo.setForeground(Color.WHITE);
        managerinfo.setBackground(Color.BLACK);
        managerinfo.addActionListener(this::actionPerformed);
        add(managerinfo);

         updatestatus =new JButton("UPDATE STATUS");
        updatestatus.setBounds(10,270,200,30);
        updatestatus.setForeground(Color.WHITE);
        updatestatus.setBackground(Color.BLACK);
        updatestatus.addActionListener(this::actionPerformed);
        add(updatestatus);

         updateroomstatus =new JButton("UPDATE ROOM STATUS");
        updateroomstatus.setBounds(10,310,200,30);
        updateroomstatus.setForeground(Color.WHITE);
        updateroomstatus.setBackground(Color.BLACK);
        updateroomstatus.addActionListener(this::actionPerformed);
        add(updateroomstatus);

         pickup =new JButton("PICKUP SERVICES");
        pickup.setBounds(10,350,200,30);
        pickup.setForeground(Color.WHITE);
        pickup.setBackground(Color.BLACK);
        pickup.addActionListener(this::actionPerformed);
        add(pickup);

         searchrooms =new JButton("SEARCH ROOMS");
        searchrooms.setBounds(10,390,200,30);
        searchrooms.setForeground(Color.WHITE);
        searchrooms.setBackground(Color.BLACK);
        searchrooms.addActionListener(this::actionPerformed);
        add(searchrooms);

         checkout =new JButton("CHECK OUT");
        checkout.setBounds(10,430,200,30);
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(Color.BLACK);
        checkout.addActionListener(this::actionPerformed);
        add(checkout);

         logout =new JButton("LOG OUT");
        logout.setBounds(10,470,200,30);
        logout.setForeground(Color.WHITE);
        logout.setBackground(Color.BLACK);
        logout.addActionListener(this::actionPerformed);
        add(logout);



        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);


        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,800,570);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==newcoustomer){
            new addcoustomer();
            setVisible(false);
        } else if (ae.getSource()==rooms) {
            setVisible(false);
            new rooms();
        } else if (ae.getSource()==depurtment) {
            setVisible(false);
            new depurtment();
        } else if (ae.getSource()==allEmployeesyee) {
            setVisible(false);
            new allemployees();
        }else if (ae.getSource()==managerinfo) {
            setVisible(false);
            new manegerinfo();
        }else if (ae.getSource()==coustomer) {
            setVisible(false);
            new coustomerinfo();
        } else if (ae.getSource()==updatestatus) {
            setVisible(false);
            new updatestatus();
        } else if (ae.getSource()==updateroomstatus) {
            setVisible(false);
            new updateroom();
        } else if (ae.getSource()==searchrooms) {
            setVisible(false);
            new searchrooms();

        }else if (ae.getSource()==pickup) {
            setVisible(false);
            new pickup();

        }else if (ae.getSource()==checkout) {
            setVisible(false);
            new checkout();
        } else if (ae.getSource()==logout) {
            setVisible(false);
            new Login();
        }

    }

    public static void main(String args[]){
        new reception();
    }
}
