/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.models;

import br.uff.imodels.IBaseModel;
import br.uff.services.Evaluator;
import br.uff.services.Inflector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
public class BaseModel implements IBaseModel {
    private static Class child = null;
    private static Connection connection = null;
    private static String table_name = null;
    protected final Evaluator evaluator;
    
    public BaseModel(){
        this.evaluator = new Evaluator(this);
    }
    
    public static Connection connect(Class klass) {
        
        if (connection != null) return connection;
        try {
            child = klass;
            table_name = get_table_name();
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart_development", "root", "");
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Object getAttribute(String attr) {
        Method method;
        try {
            String methodName = (String) Inflector.capitalize(attr);
            method = this.evaluator.getMethod("get" + methodName);
            return this.evaluator.invokeMethod(method);
        } catch (IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(BaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static IBaseModel<Class> find(int id) throws SQLException {
        try {
            PreparedStatement sql = connection.prepareStatement("select * from " + table_name + " where id = " + String.valueOf(id));
            ResultSet result = sql.executeQuery();
            result.next();
            return (IBaseModel) child.newInstance();
        } catch (SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(BaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private static String get_table_name() {
        String table = child.getSimpleName();
        table = Character.toLowerCase(table.charAt(0)) + table.substring(1);
        return table + "s";
    }
}
