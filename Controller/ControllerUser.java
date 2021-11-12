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
import java.util.Date;

public class ControllerUser {
    
    static DBHandler conn = new DBHandler();
    
    public static boolean addDokter(User user){
        conn.connect();
        String query = "INSERT INTO user VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setObject(3, user.getPassword());
            stmt.setString(4, user.getIdCategory());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
//    public static User getDokter(String nik){
//        conn.connect();
//        User user = new User();
//        String query = "SELECT * FROM user WHERE nid='" + nik + "'";
//        try {
//            Statement stmt = conn.con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                dokter.setNIK(rs.getString("NIK"));
//                dokter.setNama(rs.getString("Nama"));
//                dokter.setTglLahir((Date)rs.getObject("Tgl_lahir"));
//                dokter.setGolDar(rs.getString("Goldar"));
//                dokter.setGender(rs.getString("Gender"));
//                dokter.setNID(rs.getString("NID"));
//                dokter.setPoliklinik(rs.getString("Poliklinik"));
//                dokter.setTelepon(rs.getString("No_Telepon"));
//                dokter.setAbsen(getAllAbsen(rs.getString("NID")));
//                dokter.setAlamat(rs.getString("Alamat"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return (dokter);
//    }
    
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
        }
        return (user);
    }
}
