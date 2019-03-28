package Presentation;

import Business.ClassEnrolment;
import Business.UserOperations;
import Model.Enrolment;
import Model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCourse {

    private JFrame jFrame;
    private JTextField nrIdentificare;
    private JTextField courseId;
    private JTextField exam;
    private JTextField grade;


    private JButton ok;
    private JButton cancel;

    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;


    public AddCourse() {
        ok = new JButton("Ok");
        cancel = new JButton("Cancel");
        nrIdentificare = new JTextField();
        courseId = new JTextField();
        grade = new JTextField();
        exam = new JTextField();
    }

    private void addComponents() {
        l1= new JLabel("Insert number of identification :");
        l1.setForeground(Color.BLUE);
        l1.setBounds(20, 20, 210, 25);
        jFrame.add(l1);


        l2 = new JLabel("Insert course ID : ");
        l2.setForeground(Color.BLUE);
        l2.setBounds(20, 60, 190, 50);
        jFrame.add(l2);

        l3 = new JLabel("Insert course : ");
        l3.setForeground(Color.BLUE);
        l3.setBounds(20, 100, 190, 75);
        jFrame.add(l3);

        l4 = new JLabel("Insert grade : ");
        l4.setForeground(Color.BLUE);
        l4.setBounds(20, 145, 190, 100);
        jFrame.add(l4);

        nrIdentificare.setBounds(40, 40, 200, 30);
        jFrame.add(nrIdentificare);
        nrIdentificare.setColumns(30);

        courseId.setBounds(40, 95, 200, 30);
        jFrame.add(courseId);
        courseId.setColumns(30);

        exam.setBounds(40, 150, 200, 30);
        jFrame.add(exam);
        exam.setColumns(30);

        grade.setBounds(40, 205, 200, 30);
        jFrame.add(grade);
        grade.setColumns(30);

        ok.setBounds(300, 120, 100, 40);
        jFrame.getContentPane().add(ok);
        cancel.setBounds(300, 170, 100, 40);
        jFrame.getContentPane().add(cancel);

        jFrame.setBounds(300, 300, 500, 400);
        jFrame.getContentPane().setLayout(null);
        jFrame.setVisible(true);
    }

    public void setAddCourse() {
        jFrame = new JFrame("Add Course");
        addComponents();
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isStringOk(nrIdentificare.getText())) {
                    assert isStringOk(courseId.getText());
                    assert isNumber(nrIdentificare.getText());
                    assert isStringOk(exam.getText());
                    assert isNumber(grade.getText());
                    Enrolment coursee = new Enrolment();
                    coursee.setIdStudent(Integer.valueOf(nrIdentificare.getText()));
                    coursee.setId(Integer.valueOf(courseId.getText()));
                    coursee.setExams(exam.getText());
                    coursee.setGrades(Integer.valueOf(grade.getText()));
                    ClassEnrolment.addCourse(coursee);
                }
            }
        });
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
            }
        });
    }

    private boolean isStringOk(String text) {
        if (text.length() == 0)
            return false;
        return true;
    }

    private boolean isNumber(String string) {
        if (string.length() == 0)
            return false;
        for (int i = 0 ; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
