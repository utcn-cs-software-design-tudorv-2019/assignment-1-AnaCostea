package Presentation;

import Business.UserOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentOperations implements ActionListener {
    private JFrame studentFrame;
    private static JButton addClientInfo;
    private static JButton updateClientInfo;
    private static JButton viewClientInfo;
    private static JButton createStudentProfile;
    private static JButton updateStudentProfile;
    private static JButton deleteStudentProfile;
    private static JButton viewStudentProfile;
    private static JLabel hellouser;

    public StudentOperations(){
        createStudentProfile = new JButton("Create Student Profile");
        updateStudentProfile = new JButton("Update Student Profile");
        deleteStudentProfile = new JButton("Delete Student Profile");
        viewStudentProfile = new JButton("View Student Profile");
        hellouser = new JLabel("Welcome to Students Accounts !");
    }

    public void setStudentOperations(){
        studentFrame = new JFrame("STUDENTS INFO");

        hellouser.setForeground(Color.black);
        hellouser.setFont(new Font("Serif", Font.BOLD, 20));
        hellouser.setBounds(90, 30, 400, 30);
        studentFrame.getContentPane().add(hellouser);


        createStudentProfile.setBounds(165, 100, 160, 40);
        studentFrame.getContentPane().add(createStudentProfile);
        createStudentProfile.addActionListener(this);

        updateStudentProfile.setBounds(160, 170, 170, 40);
        studentFrame.getContentPane().add(updateStudentProfile);
        updateStudentProfile.addActionListener(this);

        deleteStudentProfile.setBounds(165, 240, 160, 40);
        studentFrame.getContentPane().add(deleteStudentProfile);
        deleteStudentProfile.addActionListener(this);

        viewStudentProfile.setBounds(170, 310, 150, 40);
        studentFrame.getContentPane().add(viewStudentProfile);
        viewStudentProfile.addActionListener(this);


       // studentFrame.getContentPane().setBackground(Color.GRAY);
        studentFrame.setSize(500, 450);
        studentFrame.setLayout(null);
        studentFrame.setVisible(true);
    }

    private ViewTable viewStudents;

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == createStudentProfile){
            AddStudent nou = new AddStudent();
            nou.setAddStudent();
        } else if(source == viewStudentProfile) {
            viewStudents = new ViewTable(UserOperations.getAllStudents(), 4);
        }else if(source == updateStudentProfile){
            EditStudent nou = new EditStudent();
            nou.setEditStudent();
        } else if(source == deleteStudentProfile){
            DeleteStudent nou = new DeleteStudent();
            nou.setDeleteStudent();
        }
    }
}
