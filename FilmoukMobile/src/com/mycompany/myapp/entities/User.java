/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author nassim
 */
public class User {
    
     private int id;
        private String username ;
        private String password ;
        private String email ;
        private String fname,lname,idcard,phone;

    public User(int id) {
        this.id = id;
    }
    public User(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
