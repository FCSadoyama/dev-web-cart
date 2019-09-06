/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author felipe
 */
public class BaseController extends HttpServlet{
    Connection conn = null;
    
    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart_development", "root", "");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void destroy() {
        try {
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
