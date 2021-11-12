/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import Controller.*;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author valentinus
 */
public class Registrasi implements ActionListener{
    JFrame frame = new JFrame("REGISTRASI");
    JPanel menu = new JPanel();
    
    JLabel labEmail = new JLabel("Email");
    JLabel labNama = new JLabel("Nama");
    JComboBox kategori = new JComboBox();
    JLabel labPassword = new JLabel("Password");
    JTextField textEmail = new JTextField();
    JTextField textNama = new JTextField();
    JPasswordField textPassword = new JPasswordField();
    JButton registrasi = new JButton("REGISTRASI");
    JButton back = new JButton("BACK");
    
    public Registrasi(){
        
        frame.setLayout(null);
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        menu.setLayout(null);
        menu.setBounds(10,10,360,530);
        menu.setBackground(Color.ORANGE);
        labEmail.setBounds(50, 150, 100, 30);
        labNama.setBounds(50,170,100,30);
        labPassword.setBounds(50, 250, 150, 30);
        textEmail.setBounds(150, 150, 150, 30);
        textNama.setBounds(150, 170, 150, 30);
        textPassword.setBounds(150, 250, 150, 30);
      //  kategori.setBounds();
        registrasi.setBounds(250,300,120,50);
        back.setBounds(100,300,100,30);
        ArrayList<CategoryUser> listCategoryUser = ControllerCategoryUser.getAllCategoryUser();

        
//        menu.add(kategori);
//        menu.add(registrasi);
//        menu.add(labEmail);
//        menu.add(labNama);
//        menu.add(labPassword);
//        menu.add(textEmail);
//        menu.add(textPassword);

       // registrasi.addActionListener((ActionListener) this);
        
        frame.add(menu);
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    

    @Override
    public void actionPerformed(ActionEvent ae){
        String command = ae.getActionCommand();
       
    }

  
}
