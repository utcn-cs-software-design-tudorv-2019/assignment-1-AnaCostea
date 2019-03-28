package Presentation;

import Business.ClassEnrolment;
import Business.UserOperations;
import Model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnrolmentOperations implements ActionListener {
    private JFrame clientFrame;
    private static JButton addCourse;
    private static JButton viewGrades;
    private static JLabel hellouser;


    public EnrolmentOperations() {
        addCourse = new JButton("Enroll to New Course");
        viewGrades = new JButton("View All Grades");
        hellouser = new JLabel("Welcome to Enrolment !");
    }

    public void setEnrolmentOperations() {
        clientFrame = new JFrame("COURSES INFO");

        hellouser.setForeground(Color.black);
        hellouser.setFont(new Font("Serif", Font.BOLD, 20));
        hellouser.setBounds(80, 30, 400, 30);
        clientFrame.getContentPane().add(hellouser);


        addCourse.setBounds(150, 100, 170, 40);
        clientFrame.getContentPane().add(addCourse);
        addCourse.addActionListener(this);


        viewGrades.setBounds(160, 190, 150, 40);
        clientFrame.getContentPane().add(viewGrades);
        viewGrades.addActionListener(this);

        //clientFrame.getContentPane().setBackground(Color.GRAY);
        clientFrame.setSize(500, 450);
        clientFrame.setLayout(null);
        clientFrame.setVisible(true);
    }

    private ViewTable viewStudents;
    /*Student student = new Student();
    int id = student.getNrIdentificare();
*/
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == addCourse) {
            AddCourse nou = new AddCourse();
            nou.setAddCourse();
        } else if (source == viewGrades) {
            viewStudents = new ViewTable(ClassEnrolment.getAllGrades(), 4);
        }
    }
}
