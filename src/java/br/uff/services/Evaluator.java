/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author felipe
 */
public class Evaluator {
    Object obj;
    Class klass;
    
    public Evaluator(Object obj) {
        this.obj = obj;
        this.klass = obj.getClass();
    }
    
    public Method getMethod(String name, Class... types) throws NoSuchMethodException {
        return klass.getDeclaredMethod(name, types);
    }
    
    public Method[] getMethods() {
        return klass.getDeclaredMethods();
    }
    
    public Object invokeMethod(Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object o = method.invoke(this.obj);
        return o;
    }
}
