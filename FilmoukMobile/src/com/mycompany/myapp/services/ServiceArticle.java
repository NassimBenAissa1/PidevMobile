/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;

import com.mycompany.myapp.entities.Article;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ilyes
 */
public class ServiceArticle {
    
    public ArrayList<Article> articles;
    
    public static ServiceArticle instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceArticle() {
         req = new ConnectionRequest();
    }

    public static ServiceArticle getInstance() {
        if (instance == null) {
            instance = new ServiceArticle();
        }
        return instance;
    }

    public boolean addArticle(Article t) {
        String url = Statics.BASE_URL + "/addarticleJSON?idEvenement=" + t.getId_evenement()+ "&titre=" + t.getTitre()+"&contenu="+ t.getContenu(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
   
    
    
    public ArrayList<Article> parseArticles(String jsonText){
       try {
           articles = new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
            Map<String,Object> articlesListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)articlesListJson.get("root");
            System.out.println(list);
            //Parcourir la liste des tâches Json
           for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs 
                      
                Article t = new Article();
                
               float id_article = Float.parseFloat(obj.get("idArticle").toString());
               float id_evenement = Float.parseFloat(obj.get("idEvenement").toString());
               t.setId_article((int)id_article);
               t.setId_evenement((int)id_evenement);
               t.setTitre(obj.get("titre").toString());
                t.setContenu(obj.get("contenu").toString());
               
                
                //Ajouter la tâche extraite de la réponse Json à la liste
                System.out.println(t);
               articles.add(t);
                System.out.println("ghhh");
           }
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
            
        }
        
        return articles;
   }
    
    public ArrayList<Article> getAllArticles(){
        articles = new ArrayList<>();
        String url = Statics.BASE_URL+"/articleee";
        req.setUrl(url);
        req.setPost(false);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
              articles = parseArticles(new String(req.getResponseData()));
                req.removeResponseListener(this);
           //     System.out.println(offres);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return articles;
    }

    

}