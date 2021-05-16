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
import com.mycompany.myapp.entities.Salle;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Wissem
 */
public class ServiceSalle {
     public static ServiceSalle instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    private Salle salle;
      public ArrayList<Salle> salles;
         public ServiceSalle() {
         req = new ConnectionRequest();
    }

    public static ServiceSalle getInstance() {
        if (instance == null) {
            instance = new ServiceSalle();
        }
        return instance;
    }
      
      
           public ArrayList<Salle> parseSalles(String jsonText){
       try {
           salles = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> offresListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)offresListJson.get("root");
            System.out.println(list);
        
           for(Map<String,Object> obj : list){
             
               Salle s = new Salle();
               float idSalle = Float.parseFloat(obj.get("idSalle").toString());
                s.setIdSalle((int)idSalle);
                
               
                s.setName((obj.get("fname").toString()));
                s.setAdress((obj.get("idcard").toString()));
                s.setGovernorate((obj.get("lname").toString()));
                s.setEmail((obj.get("email").toString()));
                s.setPhone((obj.get("phone").toString()));
                s.setImg((obj.get("username").toString()));
                
         
              
                salles.add(s);
           }
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
            
        }
       
        return salles;
   }

        public ArrayList<Salle> getAllSalles(){
        salles = new ArrayList<>();
        String url = Statics.BASE_URL+"/salle/allsallesmobile";
        req.setUrl(url);
        req.setPost(false);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                    salles = parseSalles(new String(req.getResponseData()));
            req.removeResponseListener(this);
           //     System.out.println(offres);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return salles;
    }

    
}
