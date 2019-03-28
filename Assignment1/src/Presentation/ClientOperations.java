package Presentation;

import Business.UserOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientOperations implements ActionListener {
    private JFrame clientFrame;
    private static JButton addClientInfo;
    private static JButton updateClientInfo;
    private static JButton viewClientInfo;
    private static JButton deleteClientInfo;
    private static JLabel hellouser;


    public ClientOperations() {
        addClientInfo = new JButton("Add Client Info");
        updateClientInfo = new JButton("Update Client Info");
        viewClientInfo = new JButton("View Client Info");
        deleteClientInfo = new JButton("Delete Client");
        hellouser = new JLabel("Welcome to Clients Information !");
    }

    public void setClientOperations() {
        clientFrame = new JFrame("CLIENT INFO");

        hellouser.setForeground(Color.black);
        hellouser.setFont(new Font("Serif", Font.BOLD, 20));
        hellouser.setBounds(80, 30, 400, 30);
        clientFrame.getContentPane().add(hellouser);


        addClientInfo.setBounds(170, 100, 130, 40);
        clientFrame.getContentPane().add(addClientInfo);
        addClientInfo.addActionListener(this);

        updateClientInfo.setBounds(160, 170, 150, 40);
        clientFrame.getContentPane().add(updateClientInfo);
        updateClientInfo.addActionListener(this);

        viewClientInfo.setBounds(160, 240, 150, 40);
        clientFrame.getContentPane().add(viewClientInfo);
        viewClientInfo.addActionListener(this);

        deleteClientInfo.setBounds(160, 310, 150, 40);
        clientFrame.getContentPane().add(deleteClientInfo);
        deleteClientInfo.addActionListener(this);

        //clientFrame.getContentPane().setBackground(Color.GRAY);
        clientFrame.setSize(500, 450);
        clientFrame.setLayout(null);
        clientFrame.setVisible(true);
    }

    private ViewTable viewStudents;

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == addClientInfo) {
            AddClient nou = new AddClient();
            nou.setAddClient();
        } else if (source == viewClientInfo) {
            viewStudents = new ViewTable(UserOperations.getAllClients(), 4);
        } else if (source == updateClientInfo) {
            EditClient nou = new EditClient();
            nou.setEditClient();
        }else if (source == deleteClientInfo) {
            DeleteClient nou = new DeleteClient();
            nou.setDeleteClient();
        }
    }
}
