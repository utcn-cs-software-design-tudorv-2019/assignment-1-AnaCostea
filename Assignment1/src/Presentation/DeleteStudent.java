package Presentation;

import Business.UserOperations;
import Model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStudent {
    private JFrame jFrame;
    private JTextField group;
    private JTextField nrIdentificare;
    private JTextField enrolment;
    private JTextField grades;

    private JButton ok;
    private JButton cancel;

    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;


    public DeleteStudent() {
        ok = new JButton("Ok");
        cancel = new JButton("Cancel");
        nrIdentificare = new JTextField();
        group = new JTextField();
        enrolment = new JTextField();
        grades = new JTextField();

    }

    private void addComponents() {
        l1= new JLabel("Insert number of identification");
        l1.setForeground(Color.BLUE);
        l1.setBounds(20, 20, 170, 25);
        jFrame.add(l1);


        /*l2 = new JLabel("Insert group : ");
        l2.setForeground(Color.BLUE);
        l2.setBounds(20, 60, 190, 50);
        jFrame.add(l2);

        l3 = new JLabel("Insert enrolment : ");
        l3.setForeground(Color.BLUE);
        l3.setBounds(20, 100, 230, 75);
        jFrame.add(l3);

        l4 = new JLabel("Insert grades : ");
        l4.setForeground(Color.BLUE);
        l4.setBounds(20, 145, 270, 100);
        jFrame.add(l4);*/

        nrIdentificare.setBounds(40, 40, 200, 30);
        jFrame.add(nrIdentificare);
        nrIdentificare.setColumns(30);

       /* group.setBounds(40, 95, 200, 30);
        jFrame.add(group);
        group.setColumns(30);

        enrolment.setBounds(40, 150, 200, 30);
        jFrame.add(enrolment);
        enrolment.setColumns(30);

        grades.setBounds(40, 205, 200, 30);
        jFrame.add(grades);
        grades.setColumns(30);*/


        ok.setBounds(100, 120, 100, 40);
        jFrame.getContentPane().add(ok);
        cancel.setBounds(100, 170, 100, 40);
        jFrame.getContentPane().add(cancel);

        jFrame.setBounds(300, 300, 350, 300);
        jFrame.getContentPane().setLayout(null);
        jFrame.setVisible(true);
    }

    public void setDeleteStudent() {
        jFrame = new JFrame("Remove Client");
        addComponents();
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isStringOk(nrIdentificare.getText())) {
                    assert isStringOk(nrIdentificare.getText());
                    assert isNumber(nrIdentificare.getText());
                    Student student = new Student();
                    student.setNrIdentificare(Integer.valueOf(nrIdentificare.getText()));
                    UserOperations.deleteStudent(student);
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
