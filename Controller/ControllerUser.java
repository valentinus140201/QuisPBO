/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author valentinus
 */

import Model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ControllerUser {
    
    static DBHandler conn = new DBHandler();

    public static ArrayList<User> getAllUserbyCategory(String idCategory) {
        ArrayList<User> listUser = new ArrayList<User>();
        conn.connect();
        String query = "SELECT * FROM User WHERE idCategory = '" + idCategory + " '" ;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("Id"));
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setIdCategory(rs.getString("idCategory"));
                listUser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listUser);
    }
    
    public static User login(String email){
        conn.connect();
        User user = new User();
        String query = "SELECT * FROM user WHERE email='" + email + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setIdCategory(rs.getString("idCategory"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return (user);
    }
    
    public static boolean registerUser(User user){
        conn.connect();
        String query = "INSERT INTO user(name, email, password, idCategory) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setObject(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getIdCategory());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }        
    }
    public static boolean updateProfil(User user, String emailLama){
        conn.connect();
        String query = "UPDATE user SET name='" + user.getName()+ "', "
                + "email='" + user.getEmail() + "', "
                + "password='" + user.getPassword() + "', "
                + "idCategory='" + user.getIdCategory() + "' "
                + "WHERE email='" + emailLama + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }      
    }
    public static boolean deleteUser(User user){
        conn.connect();

        String query = "DELETE FROM user WHERE email='" + user.getEmail() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
