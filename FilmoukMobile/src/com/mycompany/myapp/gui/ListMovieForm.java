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
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.mycompany.myapp.entities.Movie;
import com.mycompany.myapp.services.ServiceMovie;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.concurrent.ThreadLocalRandom.current;





/**
 *
 * @author elyes
 */
public class ListMovieForm extends Form {
   Form current;
   static Movie activeMovie=null;
     public ListMovieForm(Form previous) {
         current = this;
         
         ArrayList<Movie> movies;
         Movie movie = new Movie();
         ServiceMovie sm= new ServiceMovie();
          ImageViewer img = null;
          Image image;
          Label label;
         
         movies=ServiceMovie.getInstance().getAllMovies();
         System.out.println("TESTING --------------------------------------------------------");
         System.out.println(movies);
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
         
         
         
         
         
         System.out.println("****************");
         System.out.println(i);
         add(c);
         
        
       
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
}
