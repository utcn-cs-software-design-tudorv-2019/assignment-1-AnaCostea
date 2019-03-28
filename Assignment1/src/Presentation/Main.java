package Presentation;

import Business.UserOperations;
import DataAccess.DataRetriever;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class Main{

    private static JButton btn1;
    private static JTextField tf1;
    private static JTextField p1;
    private static JComboBox cmb;


    private static void makeMainWindow() {
        JFrame frame = new JFrame("Students Management");
        JLabel l1, l2, l3;

        l1 = new JLabel("CS Department of TUCN");
        l1.setForeground(Color.black);
        l1.setFont(new Font("Serif", Font.BOLD, 25));

        l2 = new JLabel("Username");
        l2.setForeground(Color.black);
        l3 = new JLabel("Password");
        l3.setForeground(Color.black);
        tf1 = new JTextField();
        p1 = new JPasswordField();
        btn1 = new JButton("Login");

        l1.setBounds(100, 30, 500, 30);
        l2.setBounds(80, 80, 300, 30);
        l3.setBounds(80, 120, 300, 30);
        tf1.setBounds(300, 80, 200, 30);
        p1.setBounds(300, 120, 200, 30);
        btn1.setBounds(200,250,150,30);

        String user[] = {"Student", "Admin"};
        cmb = new JComboBox(user);
        cmb.setBounds(150, 170, 150, 30);

        frame.add(l1);
        frame.add(l2);
        frame.add(tf1);
        frame.add(l3);
        frame.add(p1);
        frame.add(btn1);
        frame.add(cmb);

        actionLogin();

       // frame.getContentPane().setBackground(Color.GRAY);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args){
        makeMainWindow();
    }

    private Map<String,String> users;

    public static void actionLogin(){
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pname = tf1.getText();
                String ppass = p1.getText();
                String selectedUser = (String) cmb.getSelectedItem();

                //if(pname.equals("AndreiR") && ppass.equals("1234")) {
                int haha = new UserOperations().userLogin(pname,ppass);
                if (haha == 1 && selectedUser.equals("Student")) {
                    StudentType btn1 = new StudentType();
                    btn1.setStudentType();
                } else if (haha == 2 && selectedUser.equals("Admin")) {
                    AdminType btn1 = new AdminType();
                    btn1.setAdminType();
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Username / Password");
                    tf1.setText("");
                    p1.setText("");
                }
            }
        });
    }
}


