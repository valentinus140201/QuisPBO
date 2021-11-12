/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.User;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author valentinus
 */
public class LihatData implements ActionListener {
    JFrame frame = new JFrame("LIHAT DATA");
    JPanel isi = new JPanel();
    JTable table;
    JScrollPane scroll;
    JButton back = new JButton("BACK");
    
    public LihatData(ArrayList<User> listUser) {
        
        frame.setSize(950, 750);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        isi.setLayout(null);
        
        isi.setBounds(10,20,900,750);

        back.setBounds(400,600,120,50);
        
        isi.add(back);
        
        back.addActionListener((ActionListener) this);
        
        String[] header = {"Nama", "Email", "Category"};
        
        String[][] isitable = new String[listUser.size()][3];
        
        for(int i = 0; i < listUser.size(); i++){
            User user = listUser.get(i);
            isitable[i][0] = user.getName();
            isitable[i][1] = user.getEmail();
            isitable[i][2] = user.getIdCategory();
        }
        
        table = new JTable(isitable, header);
        scroll = new JScrollPane(table);
        scroll.setBounds(50, 50, 800, 500);
        isi.add(scroll);
        
        frame.add(isi);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "BACK": 
                new MainMenu();
                frame.setVisible(false);
                break;
            default: 
                break;
        }
    }
    
}
