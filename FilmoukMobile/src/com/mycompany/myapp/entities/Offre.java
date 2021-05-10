/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;

/**
 *
 * @author nassim
 */
public class Offre {

  
     private int id_offre;
     private int id_user;
     private  Date date;
     private String description;
     private String offreimgpath;
     private String titre;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getOffreimgpath() {
        return offreimgpath;
    }

    public void setOffreimgpath(String offreimgpath) {
        this.offreimgpath = offreimgpath;
    }

    public Offre() {
    }

    public Offre(Date date, String description) {
        this.date = date;
        this.description = description;
    }

    public Offre(Date date, String description, String offreimgpath) {
        this.date = date;
        this.description = description;
        this.offreimgpath = offreimgpath;
    }
    
    

    public Offre(int id_offre, int id_user, Date date, String description) {
        this.id_offre = id_offre;
        this.id_user = id_user;
        this.date = date;
        this.description = description;
    }

    public Offre(int id_offre, int id_user, String offreimgpath, Date date, String description) {
        this.id_offre = id_offre;
        this.id_user = id_user;
        this.date = date;
        this.description = description;
        this.offreimgpath = offreimgpath;
    }

    public Offre(int id_offre, int id_user,String offreimgpath, Date date, String description, String titre) {
        this.id_offre = id_offre;
        this.id_user = id_user;
        this.date = date;
        this.description = description;
        this.offreimgpath = offreimgpath;
        this.titre = titre;
    }

    public Offre(Date date, String description, String offreimgpath, String titre) {
        this.date = date;
        this.description = description;
        this.offreimgpath = offreimgpath;
        this.titre = titre;
    }

    public Offre(int id_user, String titre,String description, String offreimgpath) {
        this.id_user = id_user;
        this.description = description;
        this.offreimgpath = offreimgpath;
        this.titre = titre;
    }
    
    
    
    



    public int getId_offre() {
        return id_offre;
    }
    
    public int getId_user() {
        return id_user;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Offre{" + "id_offre=" + id_offre + ", id_user=" + id_user + ", date=" + date + ", description=" + description + ", offreimgpath=" + offreimgpath + ", titre=" + titre + '}';
    }

  


    
}
