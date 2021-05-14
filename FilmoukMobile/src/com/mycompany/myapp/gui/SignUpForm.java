/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Task;
import com.mycompany.myapp.services.ServiceTask;
import com.mycompany.myapp.services.ServiceUser;
import com.mycompany.myapp.utils.Statics;

/**
 *
 * @author Wissem
 */
public class SignUpForm extends Form  {
       public SignUpForm() {
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
        setTitle("Sign Up");
        setLayout(BoxLayout.y());
        
        TextField tfName = new TextField("","Username");
        TextField tfPassword= new TextField("", "Password",1,TextField.PASSWORD);
        Button btnValider = new Button("Sign In"+"");
        Label l = new Label("Already Have an account ?");
        Button btnSignup= new Button("Sign in");
        btnSignup.addActionListener(e -> new SignInForm().show());
        Container c2 =new Container(new BoxLayout(BoxLayout.X_AXIS));
        c2.add(l);
        c2.add(btnSignup);
        
       btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              
               {
                if ((tfName.getText().length()==0)||(tfPassword.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                
                       
                         ServiceUser.getInstance().SignIn(tfName.getText().toString(),tfPassword.getText().toString());
                        
                      
                   
                    
                }
                
               }
           
            }
        });
   
        
        addAll(tfName,tfPassword,btnValider,c2);
     
                
    
       
                
    }
    
    
}
