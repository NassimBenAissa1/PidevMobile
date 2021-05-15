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
import com.mycompany.myapp.entities.Candidature;
import com.mycompany.myapp.utils.Statics;
import static com.mycompany.myapp.utils.Statics.user;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nassim
 */
public class ServiceCandidature {
    
    public ArrayList<Candidature> candidatures;
    
    public static ServiceCandidature instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceCandidature() {
         req = new ConnectionRequest();
    }

    public static ServiceCandidature getInstance() {
        if (instance == null) {
            instance = new ServiceCandidature();
        }
        return instance;
    }

    public boolean addCandidature(Candidature t) {
     
        String url = Statics.BASE_URL + "/candidature/addCandidatureJSON?idUser=" + t.getId_user() +"&idOffre="+ t.getId_offre()+"&cvpath="+ t.getCvpath() +"&description="+ t.getDescription(); //création de l'URL
     
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

    
    
    public ArrayList<Candidature> parseCandidatures(String jsonText){
       try {
           candidatures = new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
            Map<String,Object> candidaturesListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)candidaturesListJson.get("root");
            System.out.println(list);
            //Parcourir la liste des tâches Json
           for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
               Candidature t = new Candidature();
               float idOffre = Float.parseFloat(obj.get("idOffre").toString());
               float idUser = Float.parseFloat(obj.get("idUser").toString());
                t.setId_offre((int)idOffre);
                t.setId_user((int)idUser);
               
                t.setDescription((obj.get("description").toString()));
                try{
                t.setCvpath(obj.get("cvpath").toString());
                }catch(Exception e){
                    
                }
                //Ajouter la tâche extraite de la réponse Json à la liste
                System.out.println(t);
                candidatures.add(t);
           }
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return candidatures;
   }
    
    public ArrayList<Candidature> getAllCandidatures(){
        candidatures = new ArrayList<>();
        String url = Statics.BASE_URL+"/candidature/displayCandidature";
        req.setUrl(url);
        req.setPost(false);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
              candidatures = parseCandidatures(new String(req.getResponseData()));
                req.removeResponseListener(this);
           //     System.out.println(offres);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return candidatures;
    }

}
