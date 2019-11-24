/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.servletdemo;

/**
 *
 * @author yurii
 */
public class Order {
    
    private static Integer lastId = 0;
    
    public Integer id;
    public String name;
    public Double amount;

    public Order(String name, Double amount) {
        
        this.id = ++lastId;
        this.name = name;
        this.amount = amount;
    }
    
    
}
