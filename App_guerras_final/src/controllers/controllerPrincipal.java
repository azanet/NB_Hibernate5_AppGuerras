/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.viewPrincipal;

/**
 *
 * @author grupo1
 */
public class controllerPrincipal implements ActionListener{
    
    
    viewPrincipal viewPpal;
    controllerCountry ctrlCountry;
    controllerWar ctrlWar;
    controllerContender ctrlContender;
    controllerConsult ctrlConsult;
    
    public controllerPrincipal() {
        this.viewPpal =  new viewPrincipal();
              
        initComponents();
        viewPpal.setVisible(true);
    }//Fin constructor

    
    
    
    private void initComponents() {
        viewPpal.getBtnWars().addActionListener(this);
        viewPpal.getBtnContender().addActionListener(this);
        viewPpal.getBtnCountry().addActionListener(this);
        viewPpal.getBtnConsult().addActionListener(this);
        viewPpal.getBtnExit().addActionListener(this);
        
    }//Fin initComponents

    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource()==viewPpal.getBtnWars()){
            ctrlWar= new controllerWar(viewPpal);  
            
        }else if(ae.getSource()==viewPpal.getBtnContender()){
	    try {  
		ctrlContender= new controllerContender(viewPpal);
	    } catch (ClassNotFoundException | SQLException ex) {
		Logger.getLogger(controllerPrincipal.class.getName()).log(Level.SEVERE, null, ex);
	    }
            
        }else if(ae.getSource()==viewPpal.getBtnCountry()){
	    try {  
		ctrlCountry= new controllerCountry(viewPpal);
	    } catch (ClassNotFoundException | SQLException ex) {
		Logger.getLogger(controllerPrincipal.class.getName()).log(Level.SEVERE, null, ex);
	    }
            
        }else if(ae.getSource()==viewPpal.getBtnConsult()){
            ctrlConsult= new controllerConsult(viewPpal);
        
        }else if(ae.getSource()==viewPpal.getBtnExit()){
            System.exit(0);
        }
          
    }//Fin de ActionPerformed
            
                        
            
            
            
       
          
    
}//Fin de la clase principal


