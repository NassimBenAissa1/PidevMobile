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
import com.mycompany.myapp.entities.Evenement;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 *
 * @author elyes
 */
public class ServiceEvenement {
    
    public ArrayList<Evenement> evenements;
    
    public static ServiceEvenement instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceEvenement() {
         req = new ConnectionRequest();
    }

    public static ServiceEvenement getInstance() {
        if (instance == null) {
            instance = new ServiceEvenement();
        }
        return instance;
    }
    
    
    
      public ArrayList<Evenement> parseEvenements(String jsonText) {
      
        try {
            evenements = new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
            Map<String,Object> offresListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)offresListJson.get("root");
            System.out.println(list);
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Evenement m = new Evenement();
                
                float idEvenement = Float.parseFloat(obj.get("idEvenement").toString());               
                m.setId_evenement((int)idEvenement);
                
                float idUser = Float.parseFloat(obj.get("idUser").toString());               
                m.setId_user((int)idUser);
                
                float idCatEvenement = Float.parseFloat(obj.get("idCatEvenement").toString());               
                m.setId_cat_evenement((int)idCatEvenement);
                
                float duree = Float.parseFloat(obj.get("dureeEvenement").toString());               
                m.setDuree_evenement((int)duree);
                
                float validate = Float.parseFloat(obj.get("validate").toString());               
                m.setValidate((int)validate);
                
                m.setDescription(obj.get("description").toString());
                m.setNom_evenement(obj.get("nomEvenement").toString());
                m.setDate_evenement(obj.get("dateEvenement").toString());
                
              
                m.setImage_evnement(obj.get("imageEvnement").toString());
                
                //Ajouter la tâche extraite de la réponse Json à la liste
               System.out.println(m);
                evenements.add(m);
            }
            
            
            
            
            
            /*
            A ce niveau on a pu récupérer une liste des tâches à partir
            de la base de données à travers un service web
            
            */
            
       
   }    catch (IOException ex) {
           
        }
        return evenements;
      }
      
      
    
    public ArrayList<Evenement> getAllEvenements(){
        evenements = new ArrayList<>();
        String url = Statics.BASE_URL+"/evenementttjs";
        req.setUrl(url);
        req.setPost(false);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                    evenements = parseEvenements(new String(req.getResponseData()));
            req.removeResponseListener(this);
           //     System.out.println(offres);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return evenements;
    }
}
