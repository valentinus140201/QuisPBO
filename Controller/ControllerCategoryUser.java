/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author valentinus
 */
public class ControllerCategoryUser {
    
    static DBHandler conn = new DBHandler();
    
    public static ArrayList<CategoryUser> getAllCategoryUser(){
        conn.connect();
        ArrayList<CategoryUser> listCategoryUser = new ArrayList<CategoryUser>();
        String query = "SELECT * FROM category_user";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CategoryUser cat = new CategoryUser();
                cat.setId(rs.getInt("id"));
                cat.setName(rs.getString("name"));
                listCategoryUser.add(cat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCategoryUser;
    }
}
