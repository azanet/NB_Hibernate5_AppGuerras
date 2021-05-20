/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS_A_MANO;


import Models.POJOs.Contendiente;
import Models.POJOs.Guerra;
import Models.HibernateUtil_SessionFactory;
import Models.POJOs.Pais;
import Models.POJOs.PeriodoIndependecia;
import Models.POJOs.UnionBandos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
 import org.hibernate.query.Query;

/**
 *
 * @author davidf
 */
public class Ejemplos_Chatarreo_DAO {
   
    private Session session; 
    
    
    public Ejemplos_Chatarreo_DAO() {
        
            session=HibernateUtil_SessionFactory.getCurrentSession();      
            System.out.println(session);
    }

    
    public void listar(){

        Query query = session.createQuery("FROM Guerra");
        List<Guerra> guerras = (ArrayList<Guerra>) query.list();
        
        for (Guerra guerra : guerras) {
            System.out.println(guerra.getNombre());
            System.out.println(guerra.getIdGuerra());
            System.out.println(guerra.getAnioInicio());
            System.out.println(guerra.getAnioFin());
            
            List<Contendiente> con = new ArrayList<>(guerra.getContendientes());
            
            for (Contendiente contendiente : con) {
                
                System.out.println(contendiente.getNombre());
                
                List<UnionBandos> ub = new ArrayList<>(contendiente.getUnionBandoses());
                
                for (UnionBandos unionBandos : ub) {
                    
               
                    Pais p=unionBandos.getPais();
                    System.out.println(p.getNombre());
                    
                    List<PeriodoIndependecia> piList = new ArrayList<>(p.getPeriodoIndependecias());

                    for (PeriodoIndependecia periodoIndependecia : piList) {
                        System.out.println("\nPERIODO DE INDEPENDENCIAAAA!!!\n");
                        System.out.println(periodoIndependecia.getIdPeriodo());
                    }
                
                }
            }
            
            
            System.out.println("\n\nOTRA GUERRA\n");
        }
        
           
        System.out.println("");
        
      
      

        query = session.createQuery("FROM Pais");
       List<Pais>pais = (ArrayList<Pais>) query.list();
        
        for (Pais p : pais) {
            System.out.println(p.getNombre());
            System.out.println(p.getIdPais());
            if (p.getIdPais().toString().equalsIgnoreCase("23")){
                p.setNombre("Unión Sudáfricana");
               session.beginTransaction();
                session.save(p);
 //               session.getTransaction().commit();
  //              session.close();
            }
                
        }
           
        System.out.println("");
        
        
        
        session.close();
        
        session= HibernateUtil_SessionFactory.getCurrentSession();
        
          query = session.createQuery("FROM Pais");
        System.out.println(session);
        List<Pais> guerrasa =(ArrayList<Pais>) query.list(); 
//            
//    
        for (Pais guerraa: guerrasa) {
//            
           System.out.println(guerraa.getNombre());
           
//            
        }
//    
    }
    
}
