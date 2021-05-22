/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAOs;

import Models.POJOs.Contendiente;
import Models.POJOs.Pais;
import Models.POJOs.UnionBandos;
import SessionFactory.HibernateUtil_SessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author davidf
 */
public class DAOUnionBandos {
    
    //PONER AQUI LOS METODOS DE UNION BANDOS QUE ESTAN EN CONTENDIENTES+
    public DAOUnionBandos(){
    }

    //INSERT PAIS
    public void insert_country(UnionBandos unionBandos, String nContendiente, String nPais) {
        //Crear metodos para recuperar LOS objetos por el nombre y setearselos al UNION BANDOS
        
        Session session = HibernateUtil_SessionFactory.getCurrentSession();
        Query query=session.createQuery("SELECT p From Pais p WHERE p.nombre = :nombre");
        query.setParameter("nombre", nPais);
        
        Pais pais= (Pais) query.uniqueResult();
        
        query=session.createQuery("SELECT c From Contendiente c WHERE c.nombre = :nombre");
        query.setParameter("nombre", nContendiente);
        
        Contendiente contendiente = (Contendiente) query.uniqueResult();
        
        //Recuperando Guerra
        unionBandos.setPais(pais);
        unionBandos.setContendiente(contendiente);
        
        session.beginTransaction();
        session.save(unionBandos);
        session.getTransaction().commit();
        session.close();
    }
    
    

  
    //Obtener fechas
    public String select_BeginDate(String nombreContendiente, String nombrePais) {
       
	String beginDate = "";

        Session session = HibernateUtil_SessionFactory.getCurrentSession();
            //REALIZANDO CONSULTA con 2 SUBCONSULTAS en las que le pasamos OBJETOS para COMPARAR y obtener de una los objetos necesatios, para determinar que tabla UNION es la nuestra
           Query query=session.createQuery("SELECT u From UnionBandos u WHERE u.contendiente = (SELECT c From Contendiente c WHERE c.nombre = :contendiente) and u.pais = (SELECT p From Pais p WHERE p.nombre = :pais)");
            query.setParameter("contendiente", nombreContendiente);
            query.setParameter("pais", nombrePais);

            UnionBandos unionB = (UnionBandos)query.uniqueResult();
            
            try{
            beginDate = unionB.getFechaUnion();
            }catch (NullPointerException npe){
                beginDate="";
            }
      
            session.close();
     
        return beginDate;   
    }

    
    
    
    
    public String select_EndDate(String nombreContendiente, String nombrePais){
        
	String endDate = "";
        Session session = HibernateUtil_SessionFactory.getCurrentSession();

           Query query=session.createQuery("SELECT u From UnionBandos u WHERE u.contendiente = (SELECT c From Contendiente c WHERE c.nombre = :contendiente) and u.pais = (SELECT p From Pais p WHERE p.nombre = :pais)");
            query.setParameter("contendiente", nombreContendiente);
            query.setParameter("pais", nombrePais);

            UnionBandos unionB = (UnionBandos)query.uniqueResult();
            try{
            endDate = unionB.getFechaAbandono();
             }catch (NullPointerException npe){
                endDate="";
            }
            session.close();
	return endDate;

    }



    //ELIMINAR PAIS
    public void delete_country(String nombreContendiente, String nombrePais)  {
  
              Session session = HibernateUtil_SessionFactory.getCurrentSession();

           Query query=session.createQuery("SELECT u From UnionBandos u WHERE u.contendiente = (SELECT c From Contendiente c WHERE c.nombre = :contendiente) and u.pais = (SELECT p From Pais p WHERE p.nombre = :pais)");
            query.setParameter("contendiente", nombreContendiente);
            query.setParameter("pais", nombrePais);

            UnionBandos unionB = (UnionBandos)query.uniqueResult();
    
           session.beginTransaction();
           session.delete(unionB);
           session.getTransaction().commit();
           session.close();
  
    }

    
  
    //ACTUALIZAS PAIS
    public void update_country(UnionBandos unionBandos, String nombreContendiente, String nombrePais) {
     
            Session session = HibernateUtil_SessionFactory.getCurrentSession();

            Query query=session.createQuery("SELECT u From UnionBandos u WHERE u.contendiente = (SELECT c From Contendiente c WHERE c.nombre = :contendiente) and u.pais = (SELECT p From Pais p WHERE p.nombre = :pais)");
            query.setParameter("contendiente", nombreContendiente);
            query.setParameter("pais", nombrePais);
            
            UnionBandos unionBandos_aux= (UnionBandos) query.uniqueResult();
            
            unionBandos_aux.setFechaUnion(unionBandos.getFechaUnion());
            unionBandos_aux.setFechaAbandono(unionBandos.getFechaAbandono());
            
            session.beginTransaction();
            session.save(unionBandos_aux);
            session.getTransaction().commit();
            session.close();

    }

    
}
