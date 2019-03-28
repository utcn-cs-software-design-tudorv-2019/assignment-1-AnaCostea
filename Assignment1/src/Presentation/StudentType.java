package Presentation;

import Business.UserOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentType implements ActionListener {
    private JFrame studentFrame;
    private static JButton clientInfo;
    private static JButton studentInfo;
    private static JButton enrolmentInfo;
    private static JLabel hellouser;

    public StudentType(){
        clientInfo = new JButton("Clients Information");
        studentInfo = new JButton("Students Profiles");
        enrolmentInfo = new JButton("Process Class Enrolment");
        hellouser = new JLabel("Hello, student user!");
    }

    public void setStudentType(){
        studentFrame = new JFrame("Student Account");

        hellouser.setForeground(Color.black);
        hellouser.setFont(new Font("Serif", Font.BOLD, 20));
        hellouser.setBounds(40, 30, 400, 30);
        studentFrame.getContentPane().add(hellouser);


        clientInfo.setBounds(150, 100, 170, 40);
        studentFrame.getContentPane().add(clientInfo);
        clientInfo.addActionListener(this);

        studentInfo.setBounds(160, 170, 150, 40);
        studentFrame.getContentPane().add(studentInfo);
        studentInfo.addActionListener(this);

        enrolmentInfo.setBounds(140, 240, 200, 40);
        studentFrame.getContentPane().add(enrolmentInfo);
        enrolmentInfo.addActionListener(this);

       // studentFrame.getContentPane().setBackground(Color.GRAY);
        studentFrame.setSize(500, 450);
        studentFrame.setLayout(null);
        studentFrame.setVisible(true);
        studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private ViewTable viewEnrolments;

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == clientInfo){
            ClientOperations nou = new ClientOperations();
            nou.setClientOperations();
        } else if(source == studentInfo) {
            StudentOperations nou = new StudentOperations();
            nou.setStudentOperations();
        }else if(source == enrolmentInfo){
            //viewEnrolments = new ViewTable(UserOperations.getAllEnrolments(), 4);
            EnrolmentOperations nou = new EnrolmentOperations();
            nou.setEnrolmentOperations();
        }
    }
}
