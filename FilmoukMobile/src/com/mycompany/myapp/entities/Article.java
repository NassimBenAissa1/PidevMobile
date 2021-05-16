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
public class Article {
    private int id_article,id_evenement;
    private String titre, contenu; 

    public Article(int id_article, int id_evenement, String titre, String contenu) {
        this.id_article = id_article;
        this.id_evenement = id_evenement;
        this.titre = titre;
        this.contenu = contenu;
    }

    public Article() {
    }

    public Article(int id_evenement, String titre, String contenu) {
        this.id_evenement = id_evenement;
        this.titre = titre;
        this.contenu = contenu;
    }

    
    public int getId_article() {
        return id_article;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public String getTitre() {
        return titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Article{" + "id_article=" + id_article + ", id_evenement=" + id_evenement + ", titre=" + titre + ", contenu=" + contenu + '}';
    }
    
    
    
}
