/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.viewPrincipal;

/**
 *
 * @author grupo1
 */
public class controllerPrincipal implements ActionListener{
    
    
    viewPrincipal viewPpal;
    controllerPais ctrlCountry;
    controllerGuerra ctrlWar;
    controllerContendientes ctrlContender;
    controllerConsultas ctrlConsult;
    
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
            ctrlWar= new controllerGuerra(viewPpal);  
            
        }else if(ae.getSource()==viewPpal.getBtnContender()){

		ctrlContender= new controllerContendientes(viewPpal);
	
            
        }else if(ae.getSource()==viewPpal.getBtnCountry()){
	
		ctrlCountry= new controllerPais(viewPpal);
	  
            
        }else if(ae.getSource()==viewPpal.getBtnConsult()){
            ctrlConsult= new controllerConsultas(viewPpal);
        
        }else if(ae.getSource()==viewPpal.getBtnExit()){
            System.exit(0);
        }
          
    }//Fin de ActionPerformed
            
                        
            
            
            
       
          
    
}//Fin de la clase principal


