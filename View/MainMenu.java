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

public class MainMenu implements ActionListener{
    JFrame frame = new JFrame("MAIN MENU");
    
    JButton login = new JButton("LOGIN");
    JButton registrasi = new JButton("REGISTRASI");
    JButton lihatData = new JButton("LIHAT DATA");
    JPanel menu = new JPanel();
    
    public MainMenu(){
        
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        menu.setLayout(null);
        
        menu.setBounds(10,20,600,450);

        login.setBounds(250,100,120,50);
        registrasi.setBounds(250,170,120,50);
        lihatData.setBounds(250,250,120,50);
        
        menu.add(login);
        menu.add(registrasi);
        menu.add(lihatData);

        login.addActionListener((ActionListener) this);
        registrasi.addActionListener((ActionListener) this);
        lihatData.addActionListener((ActionListener) this);
        
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
            case "LOGIN": 
                new Login();
                frame.setVisible(false);
                break;
            case "REGISTRASI":
                
                frame.setVisible(false);
                break;
            case "LIHAT DATA":
                
                frame.setVisible(false);
                break;
            default: 
                break;
        }
    }
}