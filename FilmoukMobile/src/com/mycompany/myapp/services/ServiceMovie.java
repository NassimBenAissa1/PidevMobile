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
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Movie;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 *
 * @author elyes
 */
public class ServiceMovie {
    
    public ArrayList<Movie> movies;
    
    public static ServiceMovie instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceMovie() {
         req = new ConnectionRequest();
    }

    public static ServiceMovie getInstance() {
        if (instance == null) {
            instance = new ServiceMovie();
        }
        return instance; 
    }
    
    
    
      public ArrayList<Movie> parseOffres(String jsonText) {
      
        try {
            movies = new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
            Map<String,Object> offresListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)offresListJson.get("root");
            System.out.println(list);
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Movie m = new Movie();
                float idMovie = Float.parseFloat(obj.get("idFilm").toString());               
                m.setIdFilm((int)idMovie);
                float idCat = Float.parseFloat(obj.get("idFilm").toString());               
                m.setIdCat((int)idCat);
                float duree = Float.parseFloat(obj.get("dureeFilm").toString());               
                m.setDuree((int)duree);
                float rate = Float.parseFloat(obj.get("rated").toString());               
                m.setRated((int)rate);
                
                m.setLang(obj.get("language").toString());
                m.setNom(obj.get("nomFilm").toString());
                m.setDate(obj.get("date").toString());
                m.setUtube(obj.get("utube").toString());        
                m.setDesc((obj.get("description").toString()));
               
                m.setImgUrl(obj.get("image").toString());
                
                //Ajouter la tâche extraite de la réponse Json à la liste
                System.out.println(m);
                movies.add(m);
            }
            
            
            
            
            
            /*
            A ce niveau on a pu récupérer une liste des tâches à partir
            de la base de données à travers un service web
            
            */
            
       
   }    catch (IOException ex) {
           
        }
        return movies;
      }
      
      
      
      
    
    public ArrayList<Movie> getAllMovies(){
        movies = new ArrayList<>();
        String url = Statics.BASE_URL+"/films/showmobile";
        req.setUrl(url);
        req.setPost(false);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                    movies = parseOffres(new String(req.getResponseData()));
            req.removeResponseListener(this);
           //     System.out.println(offres);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return movies;
    }
    
    public ArrayList<Movie> Suggestions(Movie m){
         String url = Statics.BASE_URL + "/films/suggest?idFilm="+m.getIdFilm();
         movies = new ArrayList<>();
         req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                movies = parseOffres(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
       // Dialog.show("success","rate created",new Command("OK"));
        return movies;
    }
    
    public ArrayList<Movie> SearchMovie(String s){
         String url = Statics.BASE_URL + "/films/searchmobile?search=" +s;
         
         req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                movies = parseOffres(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        Dialog.show("success","movie found",new Command("OK"));
        return movies;
        //new SignInForm().show();
    }
    
    public void SaveRate(Movie m){
         String url = Statics.BASE_URL + "/films/saveratemob?note=" + m.getRated()+"&idm="+m.getIdFilm()+"&id="+1;
         
         req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; 
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        Dialog.show("success","rate created",new Command("OK"));
        //new SignInForm().show();
    }
}
