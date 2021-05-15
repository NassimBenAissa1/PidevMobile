/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author Wissem
 */
public class Salle {
    private int idSalle;
        private String name,adress,governorate ;
        private String email,phone,img ;

    public Salle(int idSalle, String name, String adress, String governorate, String email, String phone, String img) {
        this.idSalle = idSalle;
        this.name = name;
        this.adress = adress;
        this.governorate = governorate;
        this.email = email;
        this.phone = phone;
        this.img = img;
    }

    public Salle() {
    }

    @Override
    public String toString() {
        return "Salle{" + "idSalle=" + idSalle + ", name=" + name + ", adress=" + adress + ", governorate=" + governorate + ", email=" + email + ", phone=" + phone + ", img=" + img + '}';
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getGovernorate() {
        return governorate;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getImg() {
        return img;
    }
    
}
