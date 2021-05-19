/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;


import com.codename1.components.Accordion;
import com.codename1.components.ImageViewer;
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
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import java.io.IOException;



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
         Image filmouk;
         
         
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
             
             
             
             
             
             
             
             Image placeholder = Image.createImage(1180 , 1500, 0xff0000);
             //Image hidden = Image.createImage(160, 180, 0xff0000);
             Label hid=new Label("hiddd");
             
             
             Container cont2=new Container(new BoxLayout(BoxLayout.X_AXIS));
             
             Container cont=new Container(new BoxLayout(BoxLayout.Y_AXIS));
             
             
             EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
             
             
             
             //encImage.scale(1200, 1000);
             System.out.println(encImage.getHeight());
             System.out.println(encImage.getWidth());
             
             String path="file///C:/Users/elyes/Pictures/mobile/";
             img=URLImage.createToStorage(encImage, path+movie.getImgUrl(), movie.getImgUrl(),URLImage.RESIZE_SCALE);
             //encImage.scaledLargerRatio(1000, 1200);
             System.out.println(img.getHeight());
             System.out.println(img.getWidth());
             //img.fill(600, 1200);
             //cont2.add(img);
             //img=URLImage.createToStorage(encImage, path+movie.getImgUrl(), movie.getImgUrl());
             cont.add(img);
             
             cont2.add(cont);
             
             System.out.println(img.getHeight());
             
             /***** TITLE*****/
             Label name=new Label(movie.getNom());
             Style n=name.getAllStyles();
             n.setPadding(0, 0, 0, RIGHT);
             n.setMargin(TOP, 0, LEFT, RIGHT);
             Font ttfFont = Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
             name.getAllStyles().setFgColor(0xf9f9f9);
             
             Font myFont = Font.createTrueTypeFont("/bold", "bold.ttf");
             myFont = myFont.derive(55, Font.STYLE_PLAIN);
           
             name.getAllStyles().setFont(myFont);
             n.setFont(myFont);
             
             
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
             st.setFgColor(0xe7e7d2);
             Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, st).toImage();
             initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
             initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
             initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
             initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
             starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
             
             
             /*
             System.out.println("Movie Rateeeeeeee ="+movie.getRated());
             starRank.addActionListener(e -> System.out.println("Current clicked rating"+starRank.getProgress()));
             starRank.addActionListener(e ->{movie.setRated(starRank.getProgress());
             
             System.out.println("Movie NEWWWWWWW Rateeeeeeee ="+movie.getRated());
             ServiceMovie.getInstance().SaveRate(movie);
             
             });
             */
             
             
             /***************** Save rating *************
              * btnValider.addActionListener(new ActionListener() {
              * @Override
              * public void actionPerformed(ActionEvent evt) {
              * if ((tfPassword.getText().length()==0)||(tfName.getText().length()==0)||(tfPhone.getText().length()==0))
              * Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
              * else
              * {
              * try {
              * User u = new User(0,tfName.getText().toString(),tfPassword.getText().toString(),tfEmail.getText().toString(),tfFname.getText().toString()
              * ,tfLname.getText().toString(),tfIdcard.getText().toString(),tfPhone.getText().toString(),"client",0);
              * ServiceUser.getInstance().SignUp(u);
              * 
              * } catch (NumberFormatException e) {
              * Dialog.show("ERROR", "Status must be a number", new Command("OK"));
              * }
              * 
              * }
              * 
              * 
              * }
              * });
              * 
              */
             
             
             /***** DESC comp******/
             SpanLabel desc= new SpanLabel(movie.getDesc());
             Label plot=new Label("Movie plot: ");
             
             /****imdb image + rate ***/
             float amount=movie.getRated();
             String strAmount=String.valueOf(amount);
             
             Label ratevalue=new Label(strAmount);
             Font rfont = Font.createTrueTypeFont("/bold", "bold.ttf");
             rfont = rfont.derive(70, Font.STYLE_PLAIN);           
             name.getAllStyles().setFont(rfont);             
             ratevalue.getAllStyles().setFgColor(0xFFFFFF);
             ratevalue.getAllStyles().setFont(rfont);
             
             
             
             
              Image filmholder = Image.createImage(400 , 226, 0xff0000);
             EncodedImage encfilm = EncodedImage.createFromImage(filmholder, false);           
             String zpath="file///C:/Users/elyes/Documents/GitHub/PidevMobile/FilmoukMobile/src/";
            
             filmouk=URLImage.createToStorage(encfilm, zpath+"https://i.ibb.co/hMvbD2w/logo.png;", "https://i.ibb.co/hMvbD2w/logo.png;",URLImage.RESIZE_SCALE);
             
             Image rimg;
              Image rateholder = Image.createImage(400 , 226, 0xff0000);
             EncodedImage encrate = EncodedImage.createFromImage(rateholder, false);           
             String rpath="file///C:/Users/elyes/Documents/GitHub/PidevMobile/FilmoukMobile/src/";
            
             rimg=URLImage.createToStorage(encrate, rpath+"https://logos-marques.com/wp-content/uploads/2021/03/Imdb-Logo-2016.png", "https://logos-marques.com/wp-content/uploads/2021/03/Imdb-Logo-2016.png",URLImage.RESIZE_SCALE);
             
             
         
             
            
             Container ratecont=new Container(new BoxLayout(BoxLayout.X_AXIS));
             
                         
             ratecont.add(rimg);
             ratecont.add(ratevalue);
             ratecont.add(filmouk);
             
             plot.getAllStyles().setFgColor(0x999999);
             desc.getAllStyles().setPadding(TOP, BOTTOM, 20, RIGHT);
             Container descomp=new Container(new BoxLayout(BoxLayout.Y_AXIS));
             descomp.add(btntest);
          
             descomp.add(ratecont);
             descomp.add(FlowLayout.encloseCenter(starRank));
             descomp.add(plot);            
             descomp.add(desc);
             
             /******** LOCAL FORM*/
                         
             Form SingleForm=new Form(new BorderLayout());
             
             
             
             //SingleForm.add(BorderLayout.WEST,hidden);
             Container namecont=new Container(new BoxLayout(BoxLayout.Y_AXIS));   
             namecont=FlowLayout.encloseCenter(name);
             Container topside=new Container(new FlowLayout(Component.CENTER));   
             topside.add(cont2);
             
         
                     
                     
                     topside.add(namecont);
                     Style namestyle=namecont.getAllStyles();
                     namestyle.setPadding(TOP, BOTTOM, 10, RIGHT);
                     
                     
                     
                     //SingleForm.add(BorderLayout.CENTER_BEHAVIOR_SCALE,btntest);
                     topside.add(descomp);
                     
                     
                     add(topside);
                     
                     Style formstyle2 = topside.getAllStyles();
                     
                     formstyle2.setBorder(Border.createEmpty());
                     formstyle2.setBackgroundType(BACKGROUND_NONE);
                     formstyle2.setBgTransparency(255);
                     formstyle2.setBgColor(0x111111);
                     
                     
                     /******** SUGGESTIONS FORM ****/
                     ArrayList<Movie> suggestions;
                     suggestions=ServiceMovie.getInstance().Suggestions(movie);
                     
                     Container suggestcont=new Container(new BoxLayout(BoxLayout.X_AXIS));
                     
                     int i;
                     for (i = 0; i < suggestions.size(); i++) {
                         Container suggestcont2=new Container(new BoxLayout(BoxLayout.Y_AXIS));
                         //Label suggest=new Label(suggestions.get(i).getNom());
                         //suggestcont.add(suggest);
                         Image img2 = URLImage.createImage(500, 800);
                         
                         
                         Image placeholder2 = Image.createImage(500, 800, 0xff0000);
                         EncodedImage encImg2 = EncodedImage.createFromImage(placeholder2, false);
                         //encImg.scale(800, 500);
                         //System.out.println(encImg2.getHeight());
                         //System.out.println(encImg2.getWidth());
                         
                         String path1="/C:/Users/elyes/Pictures/mobile/";
                         
                         img2=URLImage.createToStorage(encImg2, "Large_"+path1+suggestions.get(i).getImgUrl(), suggestions.get(i).getImgUrl(),URLImage.RESIZE_SCALE_TO_FILL);
                         
                         suggestcont2.add(img2);
                         suggestcont.add(suggestcont2);
                         suggestcont.setScrollableX(true);
                         suggestcont2.setScrollableX(true);
                         
                     }
                     Accordion ac= new Accordion();
                     
                     //add(cont2);
                     add(suggestcont);
                     
                     
                     //cont2.add(hidden);
                     //cont2.add(img);
                     Style formstyle = getAllStyles();
                     
                     formstyle.setBorder(Border.createEmpty());
                     formstyle.setBackgroundType(BACKGROUND_NONE);
                     formstyle.setBgTransparency(255);
                     formstyle.setBgColor(0x333333);
                     
                     //formstyle.setFgColor(0xffff33);
                     //cont.add(cont2);
                     
                     
                     //add(name);
                     //add(cont);
                     
                     //add(desc);
                     
                     //add(btntest);
                     
                     
                     getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
         
        
}

    
}
