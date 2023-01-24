import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addemployee extends JFrame implements ActionListener {
    JTextField tfname, tfphone, tfage,tfsalary;
    JRadioButton rbmale,rbfemale;
    JComboBox cbjob;
    JButton jbsub;

    addemployee(){
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

         rbmale=new JRadioButton("MALE");
        rbmale.setBounds(200,130,70,30);
        rbmale.setBackground(Color.WHITE);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(rbmale);


        rbfemale =new JRadioButton("FEMALE");
        rbfemale.setBounds(280,130,80,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);


        JLabel lbjob =new JLabel("JOB");
        lbjob.setBounds(60,180,120,30);
        lbjob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbjob);

        String str[]={"FRONT DESK","POTTERS","HOUESKEEPING","KITCHEN STAFF","MANAGER","chefs"};
         cbjob=new JComboBox<>(str);
        cbjob.setBounds(200,180,120,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);

        JLabel lbsalary =new JLabel("SALARY");
        lbsalary.setBounds(60,230,120,30);
        lbsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbsalary);

         tfsalary =new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);

        JLabel lbphone =new JLabel("PHONE");
        lbphone.setBounds(60,280,120,30);
        lbphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbphone);

         tfphone =new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);


         jbsub=new JButton("SUBMIT");
        jbsub.setBounds(200,330,150,30);
        jbsub.setBackground(Color.BLACK);
        jbsub.setForeground(Color.WHITE);
        jbsub.addActionListener(this);
        add(jbsub);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 =i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);





        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();

        String gender = null;
        if (rbfemale.isSelected()) {
            gender = "female";
        } else if (rbmale.isSelected()) {
            gender = "male";
        }

        String job = (String) cbjob.getSelectedItem();
        if (name.equals("")){
            JOptionPane.showMessageDialog(null,"NAME SHOULD NOT BE EMPTY");
            return;
        }

        try {
            conn conn = new conn();
            String query = "insert into employees values('" + name + "','" + age + "','" + salary + "','" + phone + "','" + gender + "','" + job + "')";
            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "EMPLOYEE ADDED SUCCESFULLY");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] arg){

        new  addemployee();
    }
}
