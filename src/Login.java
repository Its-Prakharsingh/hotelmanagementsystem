import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField username, password;

    JButton Login ,cancel;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        add(user);

         username=new JTextField();
        username.setBounds(150, 20, 150,30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);

         password=new JTextField();
        password.setBounds(150, 70, 150,30);
        add(password);

         Login=new JButton("Login");
        Login.setBounds(40,150,120,30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this::actionPerformed);
        add(Login);

         cancel=new JButton("CANCEL");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this::actionPerformed);
        add(cancel);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2= i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);


        setBounds(500, 200, 600, 300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Login){
           String user= username.getText();
           String pass= password.getText();

           try {
               conn c=new conn();
               String query="select * from loggin where username='"+user+"' and password='"+pass+"'";
              ResultSet rs= c.s.executeQuery(query);
              if (rs.next()){
                  setVisible(false);
                  new dashbord().setVisible(true);
              }else{
                  JOptionPane.showMessageDialog(null,"invalid username or password");
              }

           }catch (Exception e){
               e.printStackTrace();
           }


        } else if (ae.getSource()==cancel) {
            setVisible(false);

        }

    }
    public static void main(String[] arg) {
        new Login();
    }
}
