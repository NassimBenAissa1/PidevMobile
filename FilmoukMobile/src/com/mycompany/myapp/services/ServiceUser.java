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
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Task;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.gui.HomeForm;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Wissem
 */
public class ServiceUser {
         public static ServiceUser instance=null;
 User u=new User();
        private ConnectionRequest req;

    private ServiceUser()
     {
           req = new ConnectionRequest();
     }
    public static ServiceUser getInstance() {
        if (instance == null) {
            instance = new ServiceUser();
        }
        return instance;
    }
    
     public User parseUser(String jsonText){
        User u= new User();
         try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
     
            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
              /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche.               
            
            Le format Json impose que l'objet soit définit sous forme
            de clé valeur avec la valeur elle même peut être un objet Json.
            Pour cela on utilise la structure Map comme elle est la structure la
            plus adéquate en Java pour stocker des couples Key/Value.
            
            Pour le cas d'un tableau (Json Array) contenant plusieurs objets
            sa valeur est une liste d'objets Json, donc une liste de Map
            */
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
          
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                
                float id = Float.parseFloat(obj.get("idUser").toString());
                 System.out.println(id);
              u.setId((int)id);
                u.setEmail(obj.get("email").toString());
             //   t.setStatus(((int)Float.parseFloat(obj.get("status").toString())));
               // t.setName(obj.get("name").toString());
                //Ajouter la tâche extraite de la réponse Json à la liste
             //   tasks.add(t);
            }
          
            
        } catch (IOException ex) {
           
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
     //     System.out.println(Statics.user);
   
        return u ;     
    }
    
    public void SignIn(String username , String password) {
      System.out.print(password);
        String url = "http://127.0.0.1:8000/users/authmobile?username=admin&password=admiin";
      
        req.setUrl(url);
         req.addResponseListener( (e)->{
             JSONParser j = new  JSONParser();
             
            String json= new String(req.getResponseData())+"";
            try {
            if ("auth error".equals(json)) {
                Dialog.show("auth mochkla","aa","ok",null);
            }
            else 
            {
                System.out.print("data==="+json);
                 Map<String,Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));

                   if (user.size()>0)
                 {
                     new HomeForm().show();
                 }
            }
            }catch(Exception ex)
            {
                
            }
             
         }
         );
         NetworkManager.getInstance().addToQueueAndWait(req);
         System.out.print(req.getResponseCode());
    }
}
