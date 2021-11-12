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
import javax.swing.JOptionPane;
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
    JComboBox kategori;
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
        menu.setBounds(10,10,450,550);
        
        labNama.setBounds(50,80,150,30);
        labEmail.setBounds(50, 150, 150, 30);
        labPassword.setBounds(50, 220, 150, 30);
        textNama.setBounds(150, 80, 150, 30);
        textEmail.setBounds(150, 150, 150, 30);
        textPassword.setBounds(150, 220, 150, 30);
        
        registrasi.setBounds(10,300,120,50);
        back.setBounds(150,300,120,50);
        ArrayList<CategoryUser> listCategoryUser = ControllerCategoryUser.getAllCategoryUser();
        String[] listCategory = new String[listCategoryUser.size()];
        
        for (int i = 0; i < listCategoryUser.size(); i++) {
            CategoryUser cat = listCategoryUser.get(i);
            listCategory[i] = cat.getName();
        }
        
        kategori = new JComboBox(listCategory);
        kategori.setBounds(100, 260, 150, 20);
        

        menu.add(back);
        menu.add(kategori);
        menu.add(registrasi);
        menu.add(labEmail);
        menu.add(labNama);
        menu.add(labPassword);
        menu.add(textNama);
        menu.add(textEmail);
        menu.add(textPassword);

        registrasi.addActionListener((ActionListener) this);
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
            case "REGISTRASI":
                String email = textEmail.getText();
                String name = textNama.getText();
                String password = textPassword.getText();
                String kat = (String) kategori.getItemAt(kategori.getSelectedIndex());
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setPassword(password);
                user.setIdCategory(kat);
                User coba = ControllerUser.login(email);
                
                if(password.length() < 8){
                    JOptionPane.showMessageDialog(null, "Password Harus Lebih Dari 8 Digit");
                    new Registrasi();
                    break;
                }
                if(email.equals(user.getEmail())){}
                else{
                    JOptionPane.showMessageDialog(null, "Email Sudah Terdaftar");
                    new Registrasi();
                    break;
                }
                ControllerUser.registerUser(user);
                JOptionPane.showMessageDialog(null, "Berhasil Di Registrasi");
                new MainMenu();
                
                frame.setVisible(false);
                break;
        }
    }

  
}
