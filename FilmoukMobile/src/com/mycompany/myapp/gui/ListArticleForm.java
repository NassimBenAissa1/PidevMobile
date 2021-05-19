/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;
import com.codename1.charts.util.ColorUtil;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.myapp.entities.Article;
import com.mycompany.myapp.services.ServiceArticle;
//import com.mycompany.myapp.utils.MyMenu;

/**
 *
 * @author ilyes
 */
public class ListArticleForm  extends Form {
    public Form instance;
    public ListArticleForm(Form previous){
        this.setLayout(BoxLayout.y());
        instance = this;
        setTitle("List Article");
        
        
        
         add(new Label("Title     content"));
    
        
        
        
        for (Article a : ServiceArticle.getInstance().getAllArticles()) {
            instance.add(generateArticleViewer(a));
        }        
        
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
     //  this.setToolbar(MyMenu.tb);
    }
    
    public Container generateArticleViewer(Article a){
        Container articleViewer = new Container();
        
        
        Label lbTitre = new Label(a.getTitre());
        
        Label lbContenu = new Label(a.getContenu());
        lbTitre.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 0));
        lbContenu.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 0));
     
        articleViewer.add(lbTitre);
        
        articleViewer.add(lbContenu);
        
        return articleViewer;
    }
    
}
