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
<<<<<<< HEAD
    
     private int id,blocked;
        private String username ;
        private String password ;
        private String email ;
        private String fname,lname,idcard,phone,role;

    public User(int id, String username, String password, String email, String fname, String lname, String idcard, String phone, String role, int blocked) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.idcard = idcard;
        this.phone = phone;
        this.role = role;
        this.blocked = blocked;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getIdcard() {
        return idcard;
    }

    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }

    public int getBlocked() {
        return blocked;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", fname=" + fname + ", lname=" + lname + ", idcard=" + idcard + ", phone=" + phone + ", role=" + role + ", blocked=" + blocked + '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setBlocked(int blocked) {
        this.blocked = blocked;
    }

   
=======
        private int id;
        private String username ;
        private String password ;
        private String email ;
        private String fname,lname,idcard,phone;
>>>>>>> main
    
    
}
