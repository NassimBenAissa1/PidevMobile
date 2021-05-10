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
import com.mycompany.myapp.entities.Offre;
import com.mycompany.myapp.entities.Task;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author nassim
 */
public class ServiceOffre {
    public ArrayList<Offre> offres;
    
    public static ServiceOffre instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceOffre() {
         req = new ConnectionRequest();
    }

    public static ServiceOffre getInstance() {
        if (instance == null) {
            instance = new ServiceOffre();
        }
        return instance;
    }

    public boolean addOffre(Offre t) {
        String url = Statics.BASE_URL + "/offre/addOffreJSON?idUser=" + t.getId_user() + "&offreimgpath=" + t.getOffreimgpath() +"&description="+ t.getDescription() +"&titre="+t.getTitre(); //création de l'URL
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

    
    
    public ArrayList<Offre> parseOffres(String jsonText){
       try {
           offres = new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
            Map<String,Object> offresListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)offresListJson.get("root");
            System.out.println(list);
            //Parcourir la liste des tâches Json
           for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
               Offre t = new Offre();
               float idOffre = Float.parseFloat(obj.get("idOffre").toString());
               float idUser = Float.parseFloat(obj.get("idUser").toString());
                t.setId_offre((int)idOffre);
                t.setId_user((int)idUser);
                t.setTitre(obj.get("titre").toString());
                t.setDescription((obj.get("description").toString()));
                try{
                t.setOffreimgpath(obj.get("offreimgpath").toString());
                }catch(Exception e){
                    
                }
                //Ajouter la tâche extraite de la réponse Json à la liste
                System.out.println(t);
                offres.add(t);
           }
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return offres;
   }
    
    public ArrayList<Offre> getAllOffres(){
        offres = new ArrayList<>();
        String url = Statics.BASE_URL+"/offre/displayOffre";
        req.setUrl(url);
        req.setPost(false);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
              offres = parseOffres(new String(req.getResponseData()));
                req.removeResponseListener(this);
           //     System.out.println(offres);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return offres;
    }

}
