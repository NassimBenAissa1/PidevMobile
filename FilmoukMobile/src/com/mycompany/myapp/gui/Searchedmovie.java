/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Movie;
import java.util.ArrayList;

/**
 *
 * @author elyes
 */
public class Searchedmovie extends Form {
    Form current;
    
    public Searchedmovie(Form previous,ArrayList<Movie> movies){
    
    
    
    int deviceWidth = Display.getInstance().getDisplayWidth();
         Image placeholder = Image.createImage(deviceWidth/5, deviceWidth /5, 0xbfc9d2); 
         EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
        int i;
         
         
         
        Container c =new Container(new BoxLayout(BoxLayout.Y_AXIS));
         for (i = 0; i < movies.size(); i++) {
             
             
             
             
             Container c2 =new Container(new BoxLayout(BoxLayout.X_AXIS));
             Label name=new Label(movies.get(i).getNom());
             Label lang=new Label(movies.get(i).getLang());
             Label desc=new Label(movies.get(i).getDesc());
             Label utube=new Label(movies.get(i).getUtube());
            
             
             final Movie m=movies.get(i);
            
            Button btnt = new Button("");
            btnt.addActionListener(e -> new SingleMovie(current,m).show());
                                  
                    
                    
                    
                                   
          
            c2.setLeadComponent(btnt);
             
             c2.add(URLImage.createToStorage(encImage, "Large_" + movies.get(i).getImgUrl(), movies.get(i).getImgUrl(), URLImage.RESIZE_SCALE));
             c2.add(name);
             c2.add(lang);
             c2.add(desc);
             c2.add(utube);
             
             c.add(c2);
             
             
         }
         
         add(c);
    
     getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    
    }  
           
}
