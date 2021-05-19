/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.services.ServiceUser;
import com.mycompany.myapp.utils.Statics;

/**
 *
 * @author Wissem
 */
public class ForgetPasswordForm extends Form {
     Form current;
       public ForgetPasswordForm() {
         current = this;
         setTitle("Forget Password");
        setLayout(BoxLayout.y());
        Label l= new Label("enter your Reset code");
        Label l1= new Label("enter your new password");
        Label l2= new Label("confirm your new password");
        TextField tfold= new TextField("","Reset code");
        TextField tfnew= new TextField("", "New password",1,TextField.PASSWORD);
        TextField tfconfirm = new TextField("","Confirm password",1,TextField.PASSWORD);
        Button btnValider = new Button("Confirm");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfold.getText().length()==0)||(tfnew.getText().length()==0)||(tfconfirm.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {  if (!tfold.getText().equals(Statics.user.getPassword()))
                    {
                                          Dialog.show("Alert", "Reset code is incorrect", new Command("OK"));

                     }
                else{ if (!tfnew.getText().equals(tfconfirm.getText()))
                         {
                           Dialog.show("Alert", "Password Confirmation is incorrect", new Command("OK"));
                         }
                   else
                {
                   
                        Statics.user.setPassword(tfconfirm.getText());
                        ServiceUser.getInstance().ChangePassword();
                            new SignInForm().show();
                        
                            
                   
                }
                }
                    
                }
                
                
            }
        });
        
        addAll(l,tfold,l1,tfnew,l2,tfconfirm,btnValider);
        
         
         
     }
}
