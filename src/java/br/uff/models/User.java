/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.models;

import java.sql.Connection;

/**
 *
 * @author felipe
 */
public class User extends BaseModel {    
    public static void connect() {
        connect("users");
    }
}
