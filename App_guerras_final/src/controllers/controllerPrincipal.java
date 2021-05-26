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
import javax.swing.JOptionPane;
import javax.swing.Timer;


/**
 *
 * @author davidf
 */
public class controllerPrincipal extends MouseAdapter implements ActionListener {

    
    private ViewPrincipal viewPrincipal;
    
    //Variables para el TIMER de la Conexion/Reconexion
    private static final int CHECKTIME = 5000;
    private Timer timerbuscar;
    private int pBarValue=0;
    //Variable del estado de la BBDD
    private boolean statusBBDD=false;
    private int countTryConnect=1;
    
    public controllerPrincipal() {

        this.viewPrincipal = new ViewPrincipal();

        initComponents();

        viewPrincipal.setVisible(true);
        
        checkBBDDStatus();
    }//Fin constructor

    
    
    private void initComponents() {
        
        viewPrincipal.getBtnWars().setEnabled(statusBBDD);
        viewPrincipal.getBtnCountry().setEnabled(statusBBDD);
        viewPrincipal.getBtnContender().setEnabled(statusBBDD);
        viewPrincipal.getBtnConsult().setEnabled(statusBBDD);

        viewPrincipal.getpBarIntentandoConn().setStringPainted(true);
        viewPrincipal.getLblPreview().setVisible(false);
        viewPrincipal.getpBarIntentandoConn().setValue(pBarValue);
        initEvents();
    
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
            HibernateUtil_SessionFactory.closeSessionFactory();
            System.exit(0);
        }
 
        ///Comprobando CONEXION
        checkBBDDStatus();
        
        //Si el ESTADo de la CONEXION es CORRECTO, se abrirá la ventana solicitada
        //En caso contrario, mostrará un JDialog con un mensaje de error
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
        
        }//Fin del IF StatusBBDD
          
        //Comprobando de una (si viene de este controlador, o de algún otro) si 
        //Tenemos que lanzar el mensaje de error
        if(!statusBBDD){
            JOptionPane.showMessageDialog(viewPrincipal, "Se ha producido un error en la conexíon", "CONNECTION ERROR", JOptionPane.ERROR_MESSAGE);
           
        }
        
        
    }//Fin de ActionPerformed       

    
    
    /**
     * En este METODO DE EVENTO y el SIGUIENTE se DETECTA el MOUSSE 
     * cuando ENTRA (metodo " mouseEntered ") o SALE (metodo " mouseExited ")
     * de los BOTONES
     * 
     * Depende cual sea el botón se establecerá una etiqueta, otra o ninguna.
     * @param evt 
     */
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
            
            viewPrincipal.getLblPreview().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guerrasPreview.png"))); 
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

    
  //////////////////////////////////////////////////////////////////////////  
  //////////////////////////////////////////////////////////////////////////  
    /**
     * Este METODO, es el que COMPRUEBA la CONEXIÓN 
     * y ACTIVA EL TIMER de RECONEXION (que llamará a este método otra vez)
     * En caso de NO Existir CONEXION
     */
    private void checkBBDDStatus(){
        

       
        viewPrincipal.getpBarIntentandoConn().setValue(pBarValue);
        //Este METODO es el que comprueba y REALIZA LA RECONEXIÓN EN CASO de ERROR de CONEXIÓN
        statusBBDD= HibernateUtil_SessionFactory.isConnected();

        viewPrincipal.getBtnWars().setEnabled(statusBBDD);
        viewPrincipal.getBtnCountry().setEnabled(statusBBDD);
        viewPrincipal.getBtnContender().setEnabled(statusBBDD);
        viewPrincipal.getBtnConsult().setEnabled(statusBBDD);
        viewPrincipal.getLblIntentandoConectar().setVisible(!statusBBDD);
        viewPrincipal.getpBarIntentandoConn().setVisible(!statusBBDD);
        
        //Seteando la lblIntentandoConectar y la pBar
        if (countTryConnect==0){
            viewPrincipal.getLblIntentandoConectar().setText("Reiniciando ...");
            viewPrincipal.getpBarIntentandoConn().setBackground(Color.red);
        }else{
            viewPrincipal.getLblIntentandoConectar().setText("Conectando ...");
            viewPrincipal.getpBarIntentandoConn().setBackground(Color.white);
        }
        

        //Si la BBDD está desconectada, Activo el TIMER, para que compruebe periodicamente la conexion
        if(!statusBBDD){        

            reconnectTimer();
           
            viewPrincipal.getLblStatusBBDD().setText("NO CONECTADO");
            viewPrincipal.getLblStatusBBDD().setForeground(Color.red);

        
        }else{       
            viewPrincipal.getLblStatusBBDD().setText("CONECTADO");
            viewPrincipal.getLblStatusBBDD().setForeground(Color.green);
            pBarValue=0;
            countTryConnect=0;
        }
     
    }
    
    
    
    
       
    //Timer que DISPARA "LA RECONEXION" en caso de NO TENER CONEXION
    private void reconnectTimer() {

            timerbuscar = new Timer(CHECKTIME, (ActionEvent evt) -> {
                
                System.out.println("Comprobando conexion"); 
                
                ///Seteando la pBAR haciendo uso del contador para controlar los 30 segundos
                pBarValue +=12;
                countTryConnect++;
                if (countTryConnect==6){
                    viewPrincipal.getpBarIntentandoConn().setValue(pBarValue);
                    
                    countTryConnect=0;
                    pBarValue=0;
                }else{
                    viewPrincipal.getpBarIntentandoConn().setValue(pBarValue);
                }
                
                
                    checkBBDDStatus();
            
               
            });
            
            timerbuscar.setRepeats(false);
            timerbuscar.start();

    }//Fin del TIMER reconnectTimer
    
    
}//Fin de la clase principal

