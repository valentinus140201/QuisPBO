/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerCategoryUser;
import Controller.ControllerUser;
import Model.CategoryUser;
import Model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author valentinus
 */
public class PreLihatData implements ActionListener{
    JFrame frame = new JFrame("Lihat Data Pengguna Berdasarkan Kategori Dipilih");
    JPanel menu = new JPanel();

    JComboBox kategori ;
    JButton search = new JButton("SEARCH");
    JButton back = new JButton("BACK");
    
    public PreLihatData(){
        
        frame.setLayout(null);
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        menu.setLayout(null);
        menu.setBounds(10,10,450,550);
        
        search.setBounds(10,300,150,50);
        back.setBounds(200,300,150,50);

        back.addActionListener((ActionListener) this);
        search.addActionListener((ActionListener) this);
        
        
         ArrayList<CategoryUser> listCategoryUser = ControllerCategoryUser.getAllCategoryUser();
        String[] listCategory = new String[listCategoryUser.size()];
        
        for (int i = 0; i < listCategoryUser.size(); i++) {
            CategoryUser cat = listCategoryUser.get(i);
            listCategory[i] = cat.getName();
        }
        
        kategori = new JComboBox(listCategory);
        kategori.setBounds(100, 260, 150, 20);
        
        menu.add(kategori);
        menu.add(search);
        menu.add(back);
       
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
            case "SEARCH":
                String kat = (String) kategori.getItemAt(kategori.getSelectedIndex());
                ArrayList<User> listUser = ControllerUser.getAllUserbyCategory(kat);
                new LihatData(listUser);
                frame.setVisible(false);
                break;
        }
    }
}
