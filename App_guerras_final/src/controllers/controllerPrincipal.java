/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import SessionFactory.HibernateUtil_SessionFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Views.ViewPrincipal;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.Timer;


/**
 *
 * @author davidf
 */
public class controllerPrincipal extends MouseAdapter implements ActionListener {

    
    private ViewPrincipal viewPrincipal;
    private static final int CHECKTIME = 5000;
    private Timer timerbuscar;
    private boolean statusBBDD;
    
    public controllerPrincipal() {
        
        this.viewPrincipal = new ViewPrincipal();

        initComponents();

        viewPrincipal.setVisible(true);
        
    }//Fin constructor

    
    
    private void initComponents() {
        
        viewPrincipal.getLblPreview().setVisible(false);

        viewPrincipal.getLblPreview().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guerrasPreview.png"))); 
        initEvents();
        
       checkBBDDStatus();

    }//Fin initComponents

    
    
    private void initEvents() {
 
        //EVENTOS DEL BOTON SALIR
        viewPrincipal.getBtnExit().addMouseListener(this);
        viewPrincipal.getBtnExit().addActionListener(this);
        
        //EVENTOS DE BOTON GUERRAS
        viewPrincipal.getBtnWars().addMouseListener(this);
        viewPrincipal.getBtnWars().addActionListener(this);
        
        
        //EVENTOS DE BOTON PAISES
        viewPrincipal.getBtnCountry().addMouseListener(this);
        viewPrincipal.getBtnCountry().addActionListener(this);
 
        //EVENTOS DE BOTON CONTENDIENTES
        viewPrincipal.getBtnContender().addMouseListener(this);
        viewPrincipal.getBtnContender().addActionListener(this);
        
        //EVENTOS DE BOTON CONSULTAS          
        viewPrincipal.getBtnConsult().addMouseListener(this);
        viewPrincipal.getBtnConsult().addActionListener(this);
        
    }//Fin de initEvents

    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == viewPrincipal.getBtnExit()) {

            System.exit(0);
        }
 
        ///Comprobando CONEXION ANTES de ABRIR ninguna Ventana
        checkBBDDStatus();
        
        
        if(statusBBDD){
        
     
        if (ae.getSource() == viewPrincipal.getBtnWars()) {

            viewPrincipal.setVisible(false);
            controllerGuerra ctrlGuerra = new controllerGuerra(viewPrincipal);
            viewPrincipal.setVisible(true);

        } else if (ae.getSource() == viewPrincipal.getBtnContender()) {

            viewPrincipal.setVisible(false);
            controllerContendientes ctrlContendientes = new controllerContendientes(viewPrincipal);
            viewPrincipal.setVisible(true);

        } else if (ae.getSource() == viewPrincipal.getBtnCountry()) {

            viewPrincipal.setVisible(false);
            controllerPais ctrlPais = new controllerPais(viewPrincipal);
            viewPrincipal.setVisible(true);

        } else if (ae.getSource() == viewPrincipal.getBtnConsult()) {

            viewPrincipal.setVisible(false);
            controllerConsultas ctrlConsultas = new controllerConsultas(viewPrincipal);
            viewPrincipal.setVisible(true);

        }//Fin de ElseIf GetSOURCE
        
        checkBBDDStatus();
      
        }//Find e StatusBBDD
        
    }//Fin de ActionPerformed       

    
    
    @Override
    public void mouseEntered(java.awt.event.MouseEvent evt) {

        if (evt.getSource().equals(viewPrincipal.getBtnWars())) {
            
            viewPrincipal.getLblPreview().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guerrasPreview.png"))); 
            viewPrincipal.getLblPreview().setVisible(true);

        } else if (evt.getSource().equals(viewPrincipal.getBtnCountry())) {
            
            viewPrincipal.getLblPreview().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guerrasPreview.png"))); 
            viewPrincipal.getLblPreview().setVisible(true);

        } else if (evt.getSource().equals(viewPrincipal.getBtnContender())) {
            
            viewPrincipal.getLblPreview().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guerrasPreview.png"))); 
            viewPrincipal.getLblPreview().setVisible(true);

        } else if (evt.getSource().equals(viewPrincipal.getBtnConsult())) {
            
            viewPrincipal.getLblPreview().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/previewExit.png"))); 
            viewPrincipal.getLblPreview().setVisible(true);

        }else if (evt.getSource().equals(viewPrincipal.getBtnExit())) {
            
            viewPrincipal.getLblPreview().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/previewExit.png"))); 
            viewPrincipal.getLblPreview().setVisible(true);

        }

    }

    
    @Override
    public void mouseExited(java.awt.event.MouseEvent evt) {

            viewPrincipal.getLblPreview().setVisible(false);
    }

    
    
    
    
    private void checkBBDDStatus(){

        statusBBDD= HibernateUtil_SessionFactory.isConnected();
        viewPrincipal.getBtnWars().setEnabled(statusBBDD);
        viewPrincipal.getBtnCountry().setEnabled(statusBBDD);
        viewPrincipal.getBtnContender().setEnabled(statusBBDD);
        viewPrincipal.getBtnConsult().setEnabled(statusBBDD);
      
        //Si la BBDD está desconectada, Activo el TIMER, para que compruebe periodicamente la conexion
        if(!statusBBDD){          
            reconnectTimer();
            
            viewPrincipal.getLblStatusBBDD().setText("NOT CONNECTED");
            viewPrincipal.getLblStatusBBDD().setForeground(Color.red);
        
        }else{       
            viewPrincipal.getLblStatusBBDD().setText("CONNECTED");
            viewPrincipal.getLblStatusBBDD().setForeground(Color.green);
        }
     
    }
    
    
    
    
    
       
    //Timer que DISPARA "LA RECONEXION" en caso de NO TENER CONEXION
    private void reconnectTimer() {

            timerbuscar = new Timer(CHECKTIME, (ActionEvent evt) -> {
                
                System.out.println("Comprobando conexion");
                checkBBDDStatus();
            });
            
            timerbuscar.setRepeats(false);
            timerbuscar.start();

    }//Fin del TIMER reconnectTimer
    
    
}//Fin de la clase principal

