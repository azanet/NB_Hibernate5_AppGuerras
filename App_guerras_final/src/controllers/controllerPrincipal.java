/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Views.ViewPrincipal;
import java.awt.event.MouseAdapter;

/**
 *
 * @author davidf
 */
public class controllerPrincipal extends MouseAdapter implements ActionListener {

    
    private ViewPrincipal viewPrincipal;

    
    public controllerPrincipal() {
        
        this.viewPrincipal = new ViewPrincipal();

        initComponents();

        viewPrincipal.setVisible(true);
        
    }//Fin constructor

    
    
    private void initComponents() {
        
        viewPrincipal.getLblPreviewGuerras().setVisible(false);

        //jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guerrasPreview.png"))); 
        initEvents();

    }//Fin initComponents

    
    
    private void initEvents() {

        viewPrincipal.getBtnWars().addActionListener(this);
        viewPrincipal.getBtnContender().addActionListener(this);
        viewPrincipal.getBtnCountry().addActionListener(this);
        viewPrincipal.getBtnConsult().addActionListener(this);
        viewPrincipal.getBtnExit().addActionListener(this);

        //EVENTOS DE BOTON GUERRAS
        viewPrincipal.getBtnWars().addMouseListener(this);

        //EVENTOS DE BOTON PAISES
        viewPrincipal.getBtnCountry().addMouseListener(this);

        //EVENTOS DE BOTON CONTENDIENTES
        viewPrincipal.getBtnContender().addMouseListener(this);

        //EVENTOS DE BOTON CONSULTAS          
        viewPrincipal.getBtnConsult().addMouseListener(this);

    }//Fin de initEvents

    
    
    @Override
    public void actionPerformed(ActionEvent ae) {

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

        } else if (ae.getSource() == viewPrincipal.getBtnExit()) {

            System.exit(0);
        }

    }//Fin de ActionPerformed       

    
    
    @Override
    public void mouseEntered(java.awt.event.MouseEvent evt) {

        if (evt.getSource().equals(viewPrincipal.getBtnWars())) {
            
            viewPrincipal.getLblPreviewGuerras().setVisible(true);

        } else if (evt.getSource().equals(viewPrincipal.getBtnCountry())) {
            
            viewPrincipal.getLblPreviewGuerras().setVisible(true);

        } else if (evt.getSource().equals(viewPrincipal.getBtnContender())) {
            
            viewPrincipal.getLblPreviewGuerras().setVisible(true);

        } else if (evt.getSource().equals(viewPrincipal.getBtnConsult())) {
            
            viewPrincipal.getLblPreviewGuerras().setVisible(true);

        }

    }

    
    @Override
    public void mouseExited(java.awt.event.MouseEvent evt) {

        if (evt.getSource().equals(viewPrincipal.getBtnWars())) {
            
            viewPrincipal.getLblPreviewGuerras().setVisible(false);

        } else if (evt.getSource().equals(viewPrincipal.getBtnCountry())) {
            
            viewPrincipal.getLblPreviewGuerras().setVisible(false);

        } else if (evt.getSource().equals(viewPrincipal.getBtnContender())) {
            
            viewPrincipal.getLblPreviewGuerras().setVisible(false);

        } else if (evt.getSource().equals(viewPrincipal.getBtnConsult())) {
            
            viewPrincipal.getLblPreviewGuerras().setVisible(false);

        }

    }

}//Fin de la clase principal

