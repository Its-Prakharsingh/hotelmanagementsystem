import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addrooms extends JFrame implements ActionListener {

    JButton addroom,cancle;
    JTextField tfroomprice,tfroom;
    JComboBox cbbedtype,cbclean,cbavailable;
    addrooms(){
        setLayout(null);
        setBounds(330,200,940,470);
        setBackground(Color.WHITE);

        JLabel heading=new JLabel("ADD ROOMS");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);

        JLabel roomno =new JLabel("ROOM NO:");
        roomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        roomno.setBounds(60,80,120,20);
        add(roomno);

         tfroom=new JTextField();
        tfroom.setBounds(200,80,150,20);
        add(tfroom);

        JLabel lbavailble =new JLabel("AVAILABLE:");
        lbavailble.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbavailble.setBounds(60,130,120,20);
        add(lbavailble);

        String availableoption[]={"Available","occupied"};
         cbavailable=new JComboBox<>(availableoption);
        cbavailable.setBounds(200,130,120,20);
        cbavailable.setBackground(Color.WHITE);
        add(cbavailable);

        JLabel lbclean =new JLabel("CLEAN STATUS:");
        lbclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbclean.setBounds(60,180,120,20);
        add(lbclean);

        String cleanoption[]={"CLEAN","DIRTY"};
         cbclean =new JComboBox<>(cleanoption);
        cbclean.setBounds(200,180,120,20);
        cbclean.setBackground(Color.WHITE);
        add(cbclean);

        JLabel roomprice =new JLabel("ROOM PRICE:");
        roomprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        roomprice.setBounds(60,230,120,20);
        add(roomprice);

         tfroomprice =new JTextField();
        tfroomprice.setBounds(200,230,150,20);
        add(tfroomprice);

        JLabel lbbedype =new JLabel("BED TYPE:");
        lbbedype.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbbedype.setBounds(60,270,120,20);
        add(lbbedype);


        String bedtype[]={"Single","Double"};
         cbbedtype =new JComboBox<>(bedtype);
        cbbedtype.setBounds(200,270,120,20);
        cbbedtype.setBackground(Color.WHITE);
        add(cbbedtype);

         addroom=new JButton("ADD ROOM");
        addroom.setBounds(60,320,120,20);
        addroom.setBackground(Color.BLACK);
        addroom.setForeground(Color.WHITE);
        addroom.addActionListener(this::actionPerformed);
        add(addroom);

         cancle =new JButton("CANCLE");
        cancle.setBounds(200,320,120,20);
        cancle.setBackground(Color.BLACK);
        cancle.setForeground(Color.WHITE);
        cancle.addActionListener(this::actionPerformed);
        add(cancle);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);


        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()== addroom){
            String roomnumber=tfroom.getText();
            String availability=(String) cbavailable.getSelectedItem();
            String status=(String) cbclean.getSelectedItem();
            String price=tfroomprice.getText();
            String size=(String) cbbedtype.getSelectedItem();

            try {
                conn conn=new conn();
                String str="insert into rooms values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+size+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"NEW ROOM ADDED");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==cancle) {
            setVisible(false);
        }

    }

 public static void main(String[] args){
        new addrooms();
 }
}

