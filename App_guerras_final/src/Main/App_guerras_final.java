/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Models.DAOs.HibernateUtil_SessionFactory;
import controllers.controllerPrincipal;

/**
 *
 * @author davidf
 */
public class App_guerras_final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         //////////////////////////////////////////////////  
        //CREANDO LA FACTORIA DE SESIONES

       
        controllerPrincipal ctrlWar= new controllerPrincipal();  
        
        
        HibernateUtil_SessionFactory.buildSessionFactory();
      

    }
    
}
