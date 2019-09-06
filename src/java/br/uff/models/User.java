/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.models;

import br.uff.imodels.IBaseModel;

/**
 *
 * @author felipe
 */
public class User extends BaseModel implements IBaseModel {    
    public static void connect() {
        connect(User.class);
    }
    
    public int id() {
        return 2;
    }
}
