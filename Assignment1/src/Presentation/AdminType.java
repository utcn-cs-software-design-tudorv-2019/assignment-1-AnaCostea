package Presentation;

import Business.UserOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminType implements ActionListener {

    private JFrame adminFrame;

    private static JButton createStudentasAdmin = new JButton("Create Student Profile");
    private static JButton readStudentasAdmin = new JButton("Read Student Profile");
    private static JButton updateStudentasAdmin = new JButton("Update Student Profile");
    private static JButton deleteStudentasAdmin = new JButton("Delete Student Profile");
    private static JLabel helloadmin = new JLabel("Hello, admin user!");


    public void setAdminType() {
        adminFrame = new JFrame("Admin Account");

        helloadmin.setForeground(Color.black);
        helloadmin.setFont(new Font("Serif", Font.BOLD, 20));
        helloadmin.setBounds(145, 30, 400, 30);
        adminFrame.getContentPane().add(helloadmin);


        createStudentasAdmin.setBounds(165, 100, 160, 40);
        adminFrame.getContentPane().add(createStudentasAdmin);
        createStudentasAdmin.addActionListener(this);

        readStudentasAdmin.setBounds(165, 170, 160, 40);
        adminFrame.getContentPane().add(readStudentasAdmin);
        readStudentasAdmin.addActionListener(this);

        updateStudentasAdmin.setBounds(162, 240, 170, 40);
        adminFrame.getContentPane().add(updateStudentasAdmin);
        updateStudentasAdmin.addActionListener(this);

        deleteStudentasAdmin.setBounds(165, 310, 160, 40);
        adminFrame.getContentPane().add(deleteStudentasAdmin);
        deleteStudentasAdmin.addActionListener(this);

       // adminFrame.getContentPane().setBackground(Color.GRAY);
        adminFrame.setSize(500, 450);
        adminFrame.setLayout(null);
        adminFrame.setVisible(true);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private ViewTable viewStudents;

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == createStudentasAdmin){
            AddStudent nou = new AddStudent();
            nou.setAddStudent();
        } else if(source == readStudentasAdmin){
            viewStudents = new ViewTable(UserOperations.getAllStudents(), 4);
        } else if(source == updateStudentasAdmin){
            EditStudent nou = new EditStudent();
            nou.setEditStudent();
        } else if(source == deleteStudentasAdmin){
            DeleteStudent nou = new DeleteStudent();
            nou.setDeleteStudent();
        }
    }
}
