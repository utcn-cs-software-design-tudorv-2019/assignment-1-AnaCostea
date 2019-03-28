package Presentation;

import Business.UserOperations;
import Model.Client;
import Model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClient {
    private JFrame jFrame;
    private JTextField id;
    private JTextField name;
    private JTextField CNP;
    private JTextField address;

    private JButton ok;
    private JButton cancel;

    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;


    public AddClient() {
        ok = new JButton("Ok");
        cancel = new JButton("Cancel");
        id = new JTextField();
        name = new JTextField();
        CNP = new JTextField();
        address = new JTextField();

    }

    private void addComponents() {
        l1= new JLabel("Insert client ID :");
        l1.setForeground(Color.BLUE);
        l1.setBounds(20, 20, 170, 25);
        jFrame.add(l1);


        l2 = new JLabel("Insert name of client : ");
        l2.setForeground(Color.BLUE);
        l2.setBounds(20, 60, 190, 50);
        jFrame.add(l2);

        l3 = new JLabel("Insert CNP : ");
        l3.setForeground(Color.BLUE);
        l3.setBounds(20, 100, 230, 75);
        jFrame.add(l3);

        l4 = new JLabel("Insert address : ");
        l4.setForeground(Color.BLUE);
        l4.setBounds(20, 145, 270, 100);
        jFrame.add(l4);

        id.setBounds(40, 40, 200, 30);
        jFrame.add(id);
        id.setColumns(30);

        name.setBounds(40, 95, 200, 30);
        jFrame.add(name);
        name.setColumns(30);

        CNP.setBounds(40, 150, 200, 30);
        jFrame.add(CNP);
        CNP.setColumns(30);

        address.setBounds(40, 205, 200, 30);
        jFrame.add(address);
        address.setColumns(30);


        ok.setBounds(300, 120, 100, 40);
        jFrame.getContentPane().add(ok);
        cancel.setBounds(300, 170, 100, 40);
        jFrame.getContentPane().add(cancel);

        jFrame.setBounds(300, 300, 500, 400);
        jFrame.getContentPane().setLayout(null);
        jFrame.setVisible(true);
    }

    public void setAddClient() {
        jFrame = new JFrame("Add Student");
        addComponents();
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isStringOk(id.getText()) && isStringOk(name.getText())) {
                    assert isNumber(id.getText());
                    assert isStringOk(name.getText());
                    assert isNumber(CNP.getText());
                    assert isStringOk(address.getText());
                    Client client = new Client();
                    client.setId(Integer.valueOf(id.getText()));
                    client.setName(name.getText());
                    client.setCNP(CNP.getText());
                    client.setAddress(address.getText());
                    UserOperations.addClient(client);
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
