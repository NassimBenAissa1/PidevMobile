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
import com.mycompany.myapp.entities.Task;
import com.mycompany.myapp.services.ServiceTask;
import com.mycompany.myapp.services.ServiceUser;

/**
 *
 * @author Wissem
 */
public class SignInForm extends Form  {
       public SignInForm() {
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
        setTitle("Sign In");
        setLayout(BoxLayout.y());
        
        TextField tfName = new TextField("","Username");
        TextField tfPassword= new TextField("", "Password");
        Button btnValider = new Button("Sing In"
                + "");
        
        btnValider.addActionListener(e -> 
        { System.out.print("aa");
            ServiceUser.getInstance().SignIn(tfName.getText().toString(),tfPassword.getText().toString());
        });
           
        
        addAll(tfName,tfPassword,btnValider);
       
                
    }
    
    
}
