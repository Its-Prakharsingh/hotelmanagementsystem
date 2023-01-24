import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adddriver extends JFrame implements ActionListener {
    JTextField tfname, tfphone, tfage,tfsalary, tfcar,tfcarmodel;

    JComboBox cbgen;
    JButton jbsub,jbcancle;
    adddriver(){
        setLayout(null);

        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);

        JLabel lblage =new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblage);

        tfage =new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);

        JLabel lbgender =new JLabel("GENDER");
        lbgender.setBounds(60,130,120,30);
        lbgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbgender);


        String str[]={"MALE","FEMALE"};
        cbgen =new JComboBox<>(str);
        cbgen.setBounds(200,130,120,30);
        cbgen.setBackground(Color.WHITE);
        add(cbgen);

        JLabel lbcar=new JLabel("CAR NO ");
        lbcar.setBounds(60,190,120,30);
        lbcar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbcar);

         tfcar=new JTextField();
        tfcar.setBounds(200,190,120,30);
        add(tfcar);


        JLabel lbsalary =new JLabel("SALARY");
        lbsalary.setBounds(60,240,120,30);
        lbsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbsalary);

        tfsalary =new JTextField();
        tfsalary.setBounds(200,240,150,30);
        add(tfsalary);

        JLabel lbphone =new JLabel("PHONE");
        lbphone.setBounds(60,290,120,30);
        lbphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbphone);

        tfphone =new JTextField();
        tfphone.setBounds(200,290,150,30);
        add(tfphone);

        JLabel lbcarmodel =new JLabel("CAR MODEL");
        lbcarmodel.setBounds(60,340,120,30);
        lbcarmodel.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbcarmodel);

        tfcarmodel =new JTextField();
        tfcarmodel.setBounds(200,340,150,30);
        add(tfcarmodel);


        jbsub=new JButton("SUBMIT");
        jbsub.setBounds(45,400,150,30);
        jbsub.setBackground(Color.BLACK);
        jbsub.setForeground(Color.WHITE);
        jbsub.addActionListener(this);
        add(jbsub);

        jbcancle=new JButton("CANCLE");
        jbcancle.setBounds(200,400,150,30);
        jbcancle.setBackground(Color.BLACK);
        jbcancle.setForeground(Color.WHITE);
        jbcancle.addActionListener(this);
        add(jbcancle);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 =i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);





        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true);


    }




    public static void main(String []args){
        new adddriver();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String carno =tfcar.getText();
        String carmodel=tfcarmodel.getText();



        String gender = (String) cbgen.getSelectedItem();

         if (ae.getSource()==jbcancle) {
            setVisible(false);
        } else if (name.equals("")){
            JOptionPane.showMessageDialog(null,"NAME SHOULD NOT BE EMPTY");
            return;
        }
        try {
            conn conn = new conn();
            String query = "insert into driver values('" + name + "','" + age + "','" + gender + "','" + carno + "','" + salary + "','" + phone + "','"+carmodel+"')";
            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "EMPLOYEE ADDED SUCCESFULLY");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}


