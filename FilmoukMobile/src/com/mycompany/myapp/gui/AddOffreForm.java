/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Offre;
import com.mycompany.myapp.entities.Task;
import com.mycompany.myapp.services.ServiceOffre;
import com.mycompany.myapp.services.ServiceTask;

/**
 *
 * @author nassim
 */
public class AddOffreForm extends Form{
    public static int UserId =10;
     public AddOffreForm(Form previous) {
         
         setTitle("Add a new Offre");
        setLayout(BoxLayout.y());
        
        TextField tfTitre= new TextField("","Titre");
        TextField tfDescription= new TextField("", "Description");
        TextField tfImage = new TextField("","Offre Image");
        Button btnValider = new Button("Add Offre");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfTitre.getText().length()==0)||(tfDescription.getText().length()==0)||(tfImage.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Offre t = new Offre(UserId,tfTitre.getText(),tfDescription.getText(),tfImage.getText());
                        if( ServiceOffre.getInstance().addOffre(t))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfTitre,tfDescription,tfImage,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente
         
         
     }
    
}
