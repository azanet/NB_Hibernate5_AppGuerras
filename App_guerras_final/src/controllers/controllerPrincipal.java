/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Views.ViewPrincipal;

/**
 *
 * @author davidf
 */
public class controllerPrincipal implements ActionListener{
    
    
    private ViewPrincipal viewPrincipal;


    public controllerPrincipal() {
        this.viewPrincipal =  new ViewPrincipal();
              
        initComponents();
        viewPrincipal.setVisible(true);
    }//Fin constructor

    
    
    
    private void initComponents() {
        viewPrincipal.getBtnWars().addActionListener(this);
        viewPrincipal.getBtnContender().addActionListener(this);
        viewPrincipal.getBtnCountry().addActionListener(this);
        viewPrincipal.getBtnConsult().addActionListener(this);
        viewPrincipal.getBtnExit().addActionListener(this);
        
    }//Fin initComponents

    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource()==viewPrincipal.getBtnWars()){

           controllerGuerra ctrlGuerra= new controllerGuerra(viewPrincipal);  
           
           
        }else if(ae.getSource()==viewPrincipal.getBtnContender()){

           controllerContendientes ctrlContendientes= new controllerContendientes(viewPrincipal);
	
            
        }else if(ae.getSource()==viewPrincipal.getBtnCountry()){
	
            controllerPais ctrlPais = new controllerPais(viewPrincipal);
	  
            
        }else if(ae.getSource()==viewPrincipal.getBtnConsult()){
             
            controllerConsultas ctrlConsultas = new controllerConsultas(viewPrincipal);
        
            
        }else if(ae.getSource()==viewPrincipal.getBtnExit()){
            
            System.exit(0);
        }
          
    }//Fin de ActionPerformed        
    
}//Fin de la clase principal


