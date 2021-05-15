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
import com.mycompany.myapp.entities.Candidature;
import com.mycompany.myapp.services.ServiceCandidature;

/**
 *
 * @author nassim
 */
public class AddCandidatureForm extends Form {
    public static int UserId =10;
    public static int idOffre=100;
     public AddCandidatureForm(Form previous) {
     
                  setTitle("Add a new Candidature");
        setLayout(BoxLayout.y());
        
        TextField tfCv= new TextField("","CV");
        TextField tfDescription= new TextField("", "Description");
       
        Button btnValider = new Button("Add Candidature");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfCv.getText().length()==0)||(tfDescription.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Candidature t = new Candidature(UserId,idOffre,tfCv.getText(),tfDescription.getText());
                        if( ServiceCandidature.getInstance().addCandidature(t))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfCv,tfDescription,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente
     }
}
