/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.services;

import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class Inflector {
    public static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    public static String downsize(String str) {
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }
    
    public static String toSetter(String str) {
        String[] splited = str.split("_");
        String response = "";
        for (String word : splited) {
            response += capitalize(word);
        }
        return response;
    }
    
    public static String toAttribute(String str) {
        return downsize(toSetter(str));
    }
}
