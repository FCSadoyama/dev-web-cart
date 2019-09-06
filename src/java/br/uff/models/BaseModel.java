/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipe
 */
public class BaseModel {
    private static Connection connection = null;
    private static String table_name = null;
    
    public static Connection connect(String table) {
        if (connection != null) return connection;
        try {
            table_name = table;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart_development", "root", "");
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String find(int id) throws SQLException {
        ResultSet result = null;
        
        try {
            PreparedStatement sql = connection.prepareStatement("select * from " + table_name + " where id = " + String.valueOf(id));
            result = sql.executeQuery();
            result.next();
            return result.getString("name");
        } catch (SQLException ex) {
            Logger.getLogger(BaseModel.class.getName()).log(Level.SEVERE, null, ex);
            return table_name;
        }
    }
}
