/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.models;

import br.uff.imodels.IBaseModel;
import java.util.Map;

/**
 *
 * @author felipe
 */
public class User extends BaseModel implements IBaseModel {
    public int id;
    private String name;
    
    public User(Map<String, Object> attrs) {
        super();
        this.evaluator.initialize(attrs);
    }

    public static void connect() {
        connect(User.class);
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
