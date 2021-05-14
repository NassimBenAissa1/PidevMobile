/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.mycompany.myapp.entities.Movie;
import com.mycompany.myapp.services.ServiceMovie;
import java.util.ArrayList;

/**
 *
 * @author elyes
 */
public class SingleMovie extends Form {
     public SingleMovie(Form previous,Movie movie) {
    ArrayList<Movie> movies;
         
         ServiceMovie sm= new ServiceMovie();
         Label label;
         
         Label name=new Label(movie.toString());
         
         
         add(name);
         
         
    
}

    
}
