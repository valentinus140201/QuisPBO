/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerCategoryUser;
import Controller.ControllerUser;
import Model.Singleton;
import Model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import Model.*;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author valentinus
 */
public class UpdateProfil implements ActionListener{
    JFrame frame = new JFrame("UPDATE PROFIL");
    JPanel menu = new JPanel();
    
    JLabel labNama = new JLabel("Nama");
    JLabel labEmail = new JLabel("Email");
    JLabel labPassword = new JLabel("Password");
    
    JTextField textNama = new JTextField();
    JTextField textEmail = new JTextField();
    JPasswordField textPassword = new JPasswordField();
    
    JButton login = new JButton("SIMPAN");
    JButton back = new JButton("BACK");
    
    JComboBox kategori;
    
    public UpdateProfil(){
        
        frame.setLayout(null);
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        menu.setLayout(null);
        menu.setBounds(10,10,450,550);

        labNama.setBounds(50, 80, 150,30);
        labEmail.setBounds(50, 150, 150, 30);
        labPassword.setBounds(50, 220, 150, 30);
        textNama.setBounds(150,80,150,30);
        textEmail.setBounds(150, 150, 150, 30);
        textPassword.setBounds(150, 220, 150, 30);
        login.setBounds(10,300,120,50);
        back.setBounds(150,300,120,50);
        
        ArrayList<CategoryUser> listCategoryUser = ControllerCategoryUser.getAllCategoryUser();
        String[] listCategory = new String[listCategoryUser.size()];
        
        for (int i = 0; i < listCategoryUser.size(); i++) {
            CategoryUser cat = listCategoryUser.get(i);
            listCategory[i] = cat.getName();
        }
        
        kategori = new JComboBox(listCategory);
        kategori.setBounds(100, 260, 150, 20);
        
        menu.add(kategori);
        menu.add(back);
        menu.add(login);
        menu.add(labNama);
        menu.add(labEmail);
        menu.add(labPassword);
        menu.add(textNama);
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
            case "SIMPAN":
                String namaBaru = textNama.getText();
                String emailBaru = textEmail.getText();
                String passBaru = textPassword.getText();
                String idCategoryBaru = (String) kategori.getItemAt(kategori.getSelectedIndex());
                User user = new User();
                user.setEmail(emailBaru);
                user.setName(namaBaru);
                user.setPassword(passBaru);
                user.setIdCategory(idCategoryBaru);
                boolean isUpdated = ControllerUser.updateProfil(user, Singleton.getInstance().getUser().getEmail());
                if(isUpdated){
                    JOptionPane.showMessageDialog(null,"Data Sudah Di Ubah");
                }else{
                    JOptionPane.showMessageDialog(null,"ERROR");
                }
                Singleton.getInstance().setUser(user);
                new MenuUser();
                frame.setVisible(false);
                break;
            
        }
    }
}
