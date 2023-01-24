import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dashbord extends JFrame implements ActionListener {
    dashbord(){
        setBounds(0, 0, 1550,1000);
        setLayout(null);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2= i1.getImage().getScaledInstance(1500,1000, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(00,00,1550,1000);
        add(image);


        JLabel text=new JLabel("THE TAJ GRUOP WELCOMES YOU ");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.ITALIC,46));
        text.setForeground(Color.WHITE);
        image.add(text);


        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);

        JMenu hotel=new JMenu("HOTEL MANAGEMENET");
        mb.add(hotel);


        JMenu admin=new JMenu("ADMIN");
        admin.setForeground(Color.RED);
        mb.add(admin);


        JMenuItem reception=new JMenuItem("RECEPTION");
        reception.addActionListener(this::actionPerformed);
        hotel.add(reception);


        JMenuItem addemployee1=new JMenuItem("ADD EMPLOYEE");
        addemployee1.addActionListener(this::actionPerformed);
        admin.add(addemployee1);


        JMenuItem addrooms =new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this::actionPerformed);
        admin.add(addrooms);

        JMenuItem adddrie =new JMenuItem("ADD DRIVER");
        adddrie.addActionListener(this::actionPerformed);
        admin.add(adddrie);

        setVisible(true);


    }

    public static void main(String[] args){
        new dashbord();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("ADD EMPLOYEE")){
            new  addemployee();
        }
        else if (ae.getActionCommand().equals("ADD ROOMS")) {
            new addrooms();
        } else if (ae.getActionCommand().equals("ADD DRIVER")) {
            new adddriver();
        } else if (ae.getActionCommand().equals("RECEPTION")) {
            new reception();
        }

    }
}
