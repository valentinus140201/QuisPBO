/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerUser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import Model.*;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author valentinus
 */
public class Login implements ActionListener{
    JFrame frame = new JFrame("LOGIN");
    JPanel menu = new JPanel();
    
    JLabel labEmail = new JLabel("Email");
    JLabel labPassword = new JLabel("Password");
    JTextField textEmail = new JTextField();
    JPasswordField textPassword = new JPasswordField();
    JButton login = new JButton("LOGIN");
    JButton back = new JButton("BACK");
    JFrame icon = new JFrame();
    
    String path = "E:\\Semester 5\\Prak PBO\\Quiz2\\src\\View\\a.jpg";
    public Login(){
        
        frame.setLayout(null);
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        menu.setLayout(null);
        menu.setBounds(10,10,600,600);

        labEmail.setBounds(50, 150, 100, 30);
        labPassword.setBounds(50, 220, 150, 30);
        textEmail.setBounds(150, 150, 150, 30);
        textPassword.setBounds(150, 220, 150, 30);
        login.setBounds(10,300,120,50);
        back.setBounds(170,300,120,50);
        
        JLabel labFoto = new JLabel();
        labFoto.setBounds(400, 70, 200, 240);
        
        labFoto.setIcon(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(200, 240, Image.SCALE_DEFAULT)));

        menu.add(labFoto);
        menu.add(back);
        menu.add(login);
        menu.add(labEmail);
        menu.add(labPassword);
        menu.add(textEmail);
        menu.add(textPassword);

        login.addActionListener((ActionListener) this);
        back.addActionListener((ActionListener) this);
        
        frame.add(menu);
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    

    @Override
    public void actionPerformed(ActionEvent ae){
        String command = ae.getActionCommand();
        switch(command){
            case "BACK":
                new MainMenu();
                frame.setVisible(false);
                break;
            case "LOGIN":
                String email = textEmail.getText();
                String password = textPassword.getText();
                User user = ControllerUser.login(email);
                if(email.equals(user.getEmail())){
                    if(password.endsWith(user.getPassword())){
                        Singleton.getInstance().setUser(user);
                        frame.setVisible(false);
                        new MenuUser();
                        break;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Email Atau Password Salah");
                        new Login();
                        frame.setVisible(false);
                        break;
                    }
                }
                
                else{
                    JOptionPane.showMessageDialog(null, "Email Atau Password Salah");
                    new Login();
                    frame.setVisible(false);
                    break;
                 
                }
                
                
        }
            
    }
}

