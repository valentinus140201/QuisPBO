/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author valentinus
 */
import Controller.ControllerUser;
import Model.Singleton;
import Model.User;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;

public class MenuUser implements ActionListener{
    JFrame frame = new JFrame("Menu User");
    
    JButton updateProfil = new JButton("UPDATE PROFILE");
    JButton hapusData = new JButton("HAPUS DATA");
   
    JPanel menu = new JPanel();
    
    JLabel nama, email ;
    
    public MenuUser(){
        
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        menu.setLayout(null);
        
        menu.setBounds(10,20,600,450);

        updateProfil.setBounds(250,100,120,50);
        hapusData.setBounds(250,170,120,50);

        menu.add(updateProfil);
        menu.add(hapusData);

        updateProfil.addActionListener((ActionListener) this);
        hapusData.addActionListener((ActionListener) this);

        nama = new JLabel(Singleton.getInstance().getUser().getName());
        email = new JLabel(Singleton.getInstance().getUser().getEmail());
        
        nama.setBounds(100,20,200,50);
        email.setBounds(100,60,200,50);
        
        menu.add(nama);
        menu.add(email);
        
        frame.add(menu);
        
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "UPDATE PROFILE": 
                new UpdateProfil();
                frame.setVisible(false);
                break;
            case "HAPUS DATA":
                boolean isDeleted = ControllerUser.deleteUser(Singleton.getInstance().getUser());
                if(isDeleted){
                    JOptionPane.showMessageDialog(null,"Data Sudah Di Hapus");
                }else{
                    JOptionPane.showMessageDialog(null,"ERROR");
                }
                Singleton.getInstance().setUser(null);
                new MainMenu();
                frame.setVisible(false);
                break;
            default: 
                break;
        }
    }
}