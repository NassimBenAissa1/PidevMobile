/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.mycompany.myapp.services.ServiceUser;






/**
 *
 * @author Wissem
 */
public class ListUsers extends Form {
        public ListUsers() {
        setTitle("List tasks");
        
        SpanLabel sp = new SpanLabel();
     //   sp.setText(ServiceUser.getInstance().getAllUsers("admin","admin").toString());
        add(sp);
      
    }
    
}
