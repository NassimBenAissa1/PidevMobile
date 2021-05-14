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
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Task;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.gui.HomeForm;
import com.mycompany.myapp.gui.ListUsers;
import com.mycompany.myapp.gui.SignInForm;
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
    public boolean resultOK;
    private ConnectionRequest req;
    private User user;
      public ArrayList<User> users;

    private ServiceUser() {
         req = new ConnectionRequest();
    }

    public static ServiceUser getInstance() {
        if (instance == null) {
            instance = new ServiceUser();
        }
        return instance;
    }
    
     public ArrayList<User> parseUsers(String jsonText){
       try {
           users = new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
            Map<String,Object> offresListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)offresListJson.get("root");
            System.out.println(list);
            //Parcourir la liste des tâches Json
           for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
               User t = new User();
               float idUser = Float.parseFloat(obj.get("idUser").toString());
                t.setId((int)idUser);
                
                float blocked = Float.parseFloat(obj.get("blocked").toString());
                t.setBlocked((int)blocked);
                t.setUsername((obj.get("username").toString()));
                t.setPassword((obj.get("password").toString()));
                t.setEmail((obj.get("email").toString()));
                t.setRole((obj.get("role").toString()));
                
                //Ajouter la tâche extraite de la réponse Json à la liste
                System.out.println(t);
                users.add(t);
           }
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return users;
   }
  
    
        public void  SignIn(String username , String password){
        String url = Statics.BASE_URL+"/users/allusersmobile";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                users = parseUsers(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
       
        NetworkManager.getInstance().addToQueueAndWait(req);
        
    
        int test=0;
         for (int i = 0; i < users.size(); i++) {
            if((username.equals(users.get(i).getUsername()))&&(password.equals(users.get(i).getPassword())))
            {
            
          
            if((users.get(i).getBlocked()==1))
            {
                Dialog.show("Error","account blocked",new Command("OK"));
                test++;
                break ;
            }
            else
            { if(!("salle".equals(users.get(i).getRole()))) 
            { Statics.user.setUsername(users.get(i).getUsername()); 
               test++;
               new HomeForm().show();
               }
            else
            {
               Dialog.show("Error","Sorry you can't use a Room account",new Command("OK"));
               test++;
              
            }
            }
            }
            
        }
         if (test==0)
         {
             Dialog.show("Error","invalid data",new Command("OK"));
           
         }
        System.out.print(Statics.user+"this is the static var");
   
    }
}
