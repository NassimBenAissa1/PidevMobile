/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Movie;
import com.mycompany.myapp.entities.Salle;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.services.ServiceMovie;
import com.mycompany.myapp.services.ServiceSalle;
import com.mycompany.myapp.services.ServiceUser;
import java.util.ArrayList;

/**
 *
 * @author Wissem
 */
public class ListRoomsForm extends Form {
    Form current;
   static Salle activeSalle=null;
   
   
    public ListRoomsForm(Form previous) {
         current = this;
         
         ArrayList<Salle> salles;
         Movie movie = new Movie();
         ServiceUser su= new ServiceUser();
          ImageViewer img = null;
          Image image;
          Label label;
         
         salles=ServiceSalle.getInstance().getAllSalles();
         int i;
         
         Container c =new Container(new BoxLayout(BoxLayout.Y_AXIS));
         c.addPointerPressedListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            
                                            }
                    });
         
        
          
         
      //   Image placeholder = Image.createImage(label.getIcon().getWidth(), label.getIcon().getWidth(), 0xbfc9d2);
//EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
         int deviceWidth = Display.getInstance().getDisplayWidth();
         Image placeholder = Image.createImage(deviceWidth/5, deviceWidth /5, 0xbfc9d2); 
         EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
        String urlimg="";
         for (i = 0; i < salles.size(); i++) {
             Container c2 =new Container(new BoxLayout(BoxLayout.X_AXIS));
             Label name=new Label(salles.get(i).getName());
             Label adress=new Label(salles.get(i).getAdress());
             Label gov=new Label(salles.get(i).getGovernorate());
             Label phone=new Label(salles.get(i).getPhone());
            
             
             final Salle s=salles.get(i);
            
            Button btnt = new Button("");
            btnt.addActionListener( e -> new ListRoomsForm(current).show());
                                  
                    
                                   
          
            c2.setLeadComponent(btnt);
             urlimg="http://127.0.0.1/pidev-web/Nouveau%20dossier/public/images/users/"+salles.get(i).getImg();
             c2.add(URLImage.createToStorage(encImage, "Large_" + urlimg, urlimg, URLImage.RESIZE_SCALE));
             c2.add(name);
             c2.add(adress);
             c2.add(gov);
             c2.add(phone);
             
             c.add(c2);
             
           
         }
         
         System.out.println("****************");
         System.out.println(i);
         add(c);
         
        
       
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
}
