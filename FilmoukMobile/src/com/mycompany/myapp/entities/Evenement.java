/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;



/**
 *
 * @author ilyes
 */
public class Evenement {
    private int id_evenement,id_cat_evenement,id_user,validate,duree_evenement;
    private String nom_evenement,date_evenement,image_evnement,description;

    public Evenement(int id_evenement, int id_cat_evenement, int id_user, int validate, String nom_evenement, String date_evenement,int duree_evenement, String image_evnement, String description) {
        this.id_evenement = id_evenement;
        this.id_cat_evenement = id_cat_evenement;
        this.id_user = id_user;
        this.validate = validate;
        this.nom_evenement = nom_evenement;
        this.date_evenement = date_evenement;
        this.duree_evenement = duree_evenement;
        this.image_evnement = image_evnement;
        this.description = description;
    }

    public Evenement(int id_cat_evenement, int id_user, String nom_evenement, String date_evenement, int id_evenement, int duree_evenement, String image_evenement, String description, int validate) {
        this.id_cat_evenement = id_cat_evenement;
        this.id_user = id_user;
        this.validate = validate;
        this.nom_evenement = nom_evenement;
        this.date_evenement = date_evenement;
        this.duree_evenement = duree_evenement;
        this.image_evnement = image_evnement;
        this.description = description;
    }

    public Evenement() {
      
    }

   

   

    public int getId_evenement() {
        return id_evenement;
    }

    public int getId_cat_evenement() {
        return id_cat_evenement;
    }

    public int getId_user() {
        return id_user;
    }

    public int getValidate() {
        return validate;
    }

    public String getNom_evenement() {
        return nom_evenement;
    }

    public String getDate_evenement() {
        return date_evenement;
    }

    public int getDuree_evenement() {
        return duree_evenement;
    }

    public String getImage_evnement() {
        return image_evnement;
    }

    public String getDescription() {
        return description;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public void setId_cat_evenement(int id_cat_evenement) {
        this.id_cat_evenement = id_cat_evenement;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setValidate(int validate) {
        this.validate = validate;
    }

    public void setNom_evenement(String nom_evenement) {
        this.nom_evenement = nom_evenement;
    }

    public void setDate_evenement(String date_evenement) {
        this.date_evenement = date_evenement;
    }

    public void setDuree_evenement(int duree_evenement) {
        this.duree_evenement = duree_evenement;
    }

    public void setImage_evnement(String image_evnement) {
        this.image_evnement = image_evnement;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Evenement{" + "nom_evenement=" + nom_evenement + ", date_evenement=" + date_evenement + ", image_evnement=" + image_evnement + ", description=" + description + '}';
    }

   
    
}
