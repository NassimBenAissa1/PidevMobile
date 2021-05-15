/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;


import com.codename1.components.SpanLabel;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.URLImage;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.mycompany.myapp.entities.Movie;
import com.mycompany.myapp.services.ServiceMovie;
import java.util.ArrayList;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;


/**
 *
 * @author elyes
 */
public class SingleMovie extends Form {
     private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star);
    s.setBgTransparency(0);
}
    Form current = new Form(new BorderLayout());
     public SingleMovie(Form previous,Movie movie) {
         
         
         /*TEST LOCAL FORM***********/
        Form trailerForm =new Form(new BorderLayout());
        BrowserComponent br = new BrowserComponent();
        br.setURL(movie.getUtube());
        Button btntest= new Button("Watch Trailer");
        Style s=btntest.getAllStyles();
        s.setPadding(TOP, BOTTOM, 0, RIGHT);
        
        
        
        Label testing = new Label("workingg");
                trailerForm.add(BorderLayout.NORTH,testing);

        trailerForm.add(BorderLayout.OVERLAY,br);
            btntest.addActionListener(e -> trailerForm.show());
       //add(btntest);
       trailerForm.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
     
       /****************************************/
       
             ArrayList<Movie> movies;
             
             ServiceMovie sm= new ServiceMovie();
             Label label;
             Image img;
             
              //BrowserComponent browser = new BrowserComponent();
         
        //current.add(BorderLayout.NORTH, browser);        
          //browser.setURL(movie.getUtube());
          
          
             Button btnt = new Button("TRAILER");
            btnt.addActionListener(e -> new trailer(current,movie).show());
             
        // String integrationCode= "<iframe src=\"https://www.youtube.com/embed/dV9fKsjkJDQ\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
 //player.setPage(integrationCode, null);

             

             
             img=URLImage.createImage(800, 500);
            
             
             Image placeholder = Image.createImage(800, 800, 0xff0000);
             Image hidden = Image.createImage(160, 180, 0xff0000);
             Label hid=new Label("hiddd");
             Container cont=new Container(new BoxLayout(BoxLayout.Y_AXIS));
             
              Container cont2=new Container(new BoxLayout(BoxLayout.X_AXIS));


             
             EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
             encImage.scale(500, 800);
             System.out.println(encImage.getHeight());
             System.out.println(encImage.getWidth());
             
             String path="/C:/Users/elyes/Pictures/mobile/";
             img=URLImage.createToStorage(encImage, path+movie.getImgUrl(), movie.getImgUrl(), URLImage.RESIZE_SCALE);
             //img=URLImage.createToStorage(encImage, path+movie.getImgUrl(), movie.getImgUrl());
             
             
             
             System.out.println(img.getHeight());
             
             /***** TITLE*****/
             Label name=new Label(movie.getNom());
             Style n=name.getAllStyles();
             n.setPadding(0, 0, 20, RIGHT);
             n.setMargin(TOP, 0, LEFT, RIGHT);
             Font ttfFont = Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
             name.getAllStyles().setFgColor(0x3c423b);
             n.setFont(ttfFont);
             
             
             /***star rating***/
             
            
             
             Slider starRank = new Slider();
    starRank.setEditable(true);
    starRank.setMinValue(0);
    starRank.setMaxValue(10);
    Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
            derive(Display.getInstance().convertToPixels(6, true), Font.STYLE_PLAIN);
    Style st = new Style(0xffff33, 0, fnt, (byte)0);
    Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, st).toImage();
    st.setOpacity(100);
    st.setFgColor(0);
    Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, st).toImage();
    initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
    initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
    starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
         
    starRank.addActionListener(e -> System.out.println(starRank.getProgress()));
    
         
    
             
             /***** DESC comp******/
             SpanLabel desc= new SpanLabel(movie.getDesc());
             Label plot=new Label("Movie plot: ");
             
             plot.getAllStyles().setFgColor(0x000000);
             desc.getAllStyles().setPadding(TOP, BOTTOM, 50, RIGHT);
              Container descomp=new Container(new BoxLayout(BoxLayout.Y_AXIS));            
              descomp.add(btntest);
              descomp.add(plot);
              descomp.add(FlowLayout.encloseCenter(starRank));
             descomp.add(desc);
             
             /******** LOCAL FORM*/
                         
             Form SingleForm=new Form(new BorderLayout());
             
             
             SingleForm.add(BorderLayout.NORTH,name);
             SingleForm.add(BorderLayout.WEST,hidden);
             SingleForm.add(BorderLayout.CENTER,img);
             //SingleForm.add(BorderLayout.CENTER_BEHAVIOR_SCALE,btntest);             
             SingleForm.add(BorderLayout.SOUTH,descomp);
             add(SingleForm);
             
             
            
             
             //cont2.add(hidden);
             //cont2.add(img);
             
                  
                  cont.add(cont2);
             
                  
             //add(name);
             //add(cont);
             
             //add(desc);
             
             //add(btntest);
             
             
             getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        
}

    
}
