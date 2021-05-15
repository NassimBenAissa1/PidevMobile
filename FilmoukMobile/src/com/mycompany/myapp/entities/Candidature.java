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
public class Candidature {
  private int id_candidature;
  private int id_user;
  private int id_offre;
  private Date date;
  private String description;
  private String cvpath;
  private String etatCandidature;

    public String getEtatCandidature() {
        return etatCandidature;
    }

    public void setEtatCandidature(String etatCandidature) {
        this.etatCandidature = etatCandidature;
    }

    public String getCvpath() {
        return cvpath;
    }

    public void setCvpath(String cvpath) {
        this.cvpath = cvpath;
    }
    public Candidature() {
    }

    public Candidature(int id_offre, Date date, String description, String cvpath) {
        this.id_offre = id_offre;
        this.date = date;
        this.description = description;
        this.cvpath = cvpath;
    }
    
    

    public Candidature(Date date, String description) {
        this.date = date;
        this.description = description;
    }
    

    public Candidature(int id_candidature, int id_user, int id_offre, Date date, String description) {
        this.id_candidature = id_candidature;
        this.id_user = id_user;
        this.id_offre = id_offre;
        this.date = date;
        this.description = description;
    }

    public Candidature(int id_candidature, int id_user, int id_offre,String cvpath, Date date, String description ) {
        this.id_candidature = id_candidature;
        this.id_user = id_user;
        this.id_offre = id_offre;
        this.date = date;
        this.description = description;
        this.cvpath = cvpath;
    }

    public Candidature(Date date, String description, String cvpath) {
        this.date = date;
        this.description = description;
        this.cvpath = cvpath;
    }

    public Candidature(int id_candidature, int id_user, int id_offre, Date date, String description, String cvpath, String etatCandidature) {
        this.id_candidature = id_candidature;
        this.id_user = id_user;
        this.id_offre = id_offre;
        this.date = date;
        this.description = description;
        this.cvpath = cvpath;
        this.etatCandidature = etatCandidature;
    }

    public Candidature(int id_user, int id_offre, String cvpath ,String description) {
        this.id_user = id_user;
        this.id_offre = id_offre;
        this.description = description;
        this.cvpath = cvpath;
    }
  
    
 
    
    
    
    

    public int getId_candidature() {
        return id_candidature;
    }

    public void setId_candidature(int id_candidature) {
        this.id_candidature = id_candidature;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Candidature{" + "id_candidature=" + id_candidature + ", id_user=" + id_user + ", id_offre=" + id_offre + ", date=" + date + ", description=" + description + ", cvpath=" + cvpath + '}';
    }



     
    
     
}
