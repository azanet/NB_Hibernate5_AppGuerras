/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DAOS_A_MANO.Ejemplos_Chatarreo_DAO;
import Models.HibernateUtil_SessionFactory;
import controllers.controllerPrincipal;
import org.hibernate.Hibernate;

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
        
        controllerPrincipal ctrlWar= new controllerPrincipal();  
         
         
         
    //////////////////////////////////////////////////  
    //CREANDO LA FACTORIA DE SESIONES
        HibernateUtil_SessionFactory.buildSessionFactory();
       
//        Ejemplos_Chatarreo_DAO gd = new Ejemplos_Chatarreo_DAO();
//        
//        gd.listar();

    
    }
    
}
