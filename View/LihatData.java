/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
import javax.swing.JTextField;

/**
 *
 * @author valentinus
 */
public class LihatData implements ActionListener {
    JFrame frame = new JFrame("Lihat Data Pengguna Berdasarkan Kategori Dipilih");
    JPanel menu = new JPanel();

    JComboBox kategori = new JComboBox();
    JButton search= new JButton("SEARCH");
    JButton back = new JButton("BACK");
    
    public LihatData(){
        
        frame.setLayout(null);
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        menu.setLayout(null);
        menu.setBounds(10,10,360,530);
        menu.setBackground(Color.ORANGE);
        search.setBounds(250,300,120,50);
        back.setBounds(100,300,100,30);
        
        menu.add(search);


        //registrasi.addActionListener((ActionListener) this);
        
        frame.add(menu);
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    

    @Override
    public void actionPerformed(ActionEvent ae){
//        String command = ae.getActionCommand();
//        if(command == "LOGIN"){
//            Staff staff = control.getStaff(textEmail.getText());
//            if(textEmail.getText().equals(staff.getUsername())){
//                if(textPassword.getText().equals(staff.getPassword())){
//                    Singleton.getInstance().setStaff(staff);
//                    Singleton.getInstance().setCabang(control.getCabang(staff.getIdCabang()));
//                    frame.setVisible(false);
//                    MainMenu mainMenu = new MainMenu();
//                }else{
//                    JOptionPane.showMessageDialog(null,"Username Atau Password Salah");
//                }
//            }
//            
//            if(textEmail.getText().equals("") || textPassword.getText().equals("")){
//                JOptionPane.showMessageDialog(null,"Username Atau Password Harus Di isi");
//            }
//        }     
    }
}
