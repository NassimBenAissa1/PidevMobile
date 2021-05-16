/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;
import com.codename1.ui.Form;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Container;
import com.codename1.ui.Toolbar;
import com.codename1.ui.util.UIBuilder;
import java.io.IOException;

import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Evenement;
import com.mycompany.myapp.services.ServiceEvenement;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 *
 * @author ilyes
 */
public class ListEvenementForm extends Form{
    Form current;
   static Evenement activeMovie=null;
     public ListEvenementForm(Form previous) {
         current = this;
         
         ArrayList<Evenement> evenements;
         Evenement evenement = new Evenement();
         ServiceEvenement sm= new ServiceEvenement();
          ImageViewer img = null;
          Image image;
          Image imagee;
          
          Label label;
         
         evenements=ServiceEvenement.getInstance().getAllEvenements();
         System.out.println("TESTING --------------------------------------------------------");
         System.out.println(evenements);
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
        String url="";
         for (i = 0; i < evenements.size(); i++) {
             Container c2 =new Container(new BoxLayout(BoxLayout.X_AXIS));
             Label name=new Label(evenements.get(i).getNom_evenement());
             Label description=new Label(evenements.get(i).getDescription());
             Label date=new Label(evenements.get(i).getDate_evenement());
             //Label btnimgg = new Label();
             //Label utube=new Label(movies.get(i).getUtube());
            
             
             final Evenement m=evenements.get(i);
            
            Button btnt = new Button("");
            
            c2.setLeadComponent(btnt);
             url="file:///C:/Users/ilyes/Desktop/Nouveau dossier/public/img/"+evenements.get(i).getImage_evnement();
             
             c2.add(URLImage.createToStorage(encImage, "Large_" + url, url, URLImage.RESIZE_SCALE));
             c2.add(name);
             c2.add(description);
             c2.add(date);
             //c2.add(utube);
             
             c.add(c2);
             
           
         }
         
         System.out.println("****************");
         System.out.println(i);
         add(c);
         
        
       
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
}
