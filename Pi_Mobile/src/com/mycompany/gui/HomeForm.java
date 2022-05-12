/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author bhk
 */
public class HomeForm extends Form{
Form current; Resources res;
     public HomeForm() {
        current=this; //Back 
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        
              Button btnAddUser = new Button("Add user");
       // Button btnListTasks = new Button("List Tasks");
        
       // btnAddTask.addActionListener(e-> new AddusersForm(current).show());
              Button btnListUser = new Button("list user");
       //Button btnListTasks = new Button("List Tasks");
        
      //  btnAddTask1.addActionListener(s-> new listuser(current).show());
        
               Button btnMap = new Button("Map");
 
        
        
        
        Button btnAddTask = new Button("Add voyage");
        Button btnListTasks = new Button("List voyages");
             Button btnListVOTasks = new Button("List voyages organisés");
              Button btnStat = new Button("STAT");
        
 
              
              
              
              
                      btnAddUser.addActionListener(e-> new AddusersForm(current).show());
              
                                    btnListUser.addActionListener(e-> new listuser(current).show());

                                    
                btnMap.addActionListener(e->   new MapForm(current));

              
        btnListTasks.addActionListener(e-> new ListVoyagesForm(current).show());
                btnListVOTasks.addActionListener(e-> new ListVoyagesOForm(current).show());

        
                btnAddTask.addActionListener(e-> new VoyageAddGUI(current).show());
               btnStat.addActionListener(e-> new StatistiquePieForm(res).show());

  
               
               
               
               
        addAll(btnAddUser,btnListUser,btnAddTask,btnListTasks,btnListVOTasks,btnStat,btnMap);
        
        
    }
    
    
}
