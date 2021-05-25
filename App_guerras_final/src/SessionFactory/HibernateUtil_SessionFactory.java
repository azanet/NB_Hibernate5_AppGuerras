/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionFactory;


import Views.ViewPrincipal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


/**
 *Utilizando las LIBRERIAS de HIBERNATE 5.4.31
 * 
 * @author davidf
 *
 * DESCRIPCION:
 * Esta ES la FORMA CORRECTA para obtener la SESION de HIBERNATE, (Session Factory object)
 *
 * ###############################################################
 * ##############################################################
 * 
 *  //INICIALIZAR LA FACTORIA DE SESIONES ///
 * HibernateUtil.buildSessionFactory()
 * 
 * 
 * ///Utilizar esta forma de inicializar SESION en el DAO CORRESPONDIENTE // 
 * Session sesion = HibernateUtil.getCurrentSession();
 * 
*/

public class HibernateUtil_SessionFactory {

    private static SessionFactory sessionFactory;
    private static Session session;
    public static boolean statusBBDD=false; 
    
    
 
    
    //Fabricando la sesionFactory
    public static void buildSessionFactory() {
        
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        
    }

    
    
    
    /**
   * Abre una nueva sesión
   */
  private static void openSession() {
      
      session = sessionFactory.openSession();
      
    }
 
  /**
   * Devuelve la sesión actual
   * @return
   */
  public static Session getCurrentSession() {

    if ((session == null) || (!session.isOpen() ))
      openSession();

    return session;
  }
 
  /**
   * Cierra Hibernate
   */
  public static void closeSessionFactory() {
 
    if (session != null)
      session.close();
 
    if (sessionFactory != null)
      sessionFactory.close();
  }
    
 
  ///////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////

    /**
     * Devuelve el Valor de la variable "statusBBDD" 
     * despues de ejecutar el metodo PRIVADO "CheckConn"
     * 
     * El metodo "CheckConn" =
     * Lanzará una consulta y SI SE REALIZA CON EXITO la variable "statusBBDD" se pone a TRUE,
     * en caso de LANZAR ERROR la variable "statusBBDD" se pone a FALSE.
     * 
     * Crearemos un TIMER en la CLASE que QUERAMOS comprobar si la conexión es VALIDA, 
     * para que itere y repita la llamada al Metodo "isConnected"
     * en caso de ser FALLIDA la conexión.
     * En el momento que la conexión funcione, 
     * se realizará la consulta y cambiará el estado de 
     * la variable "statusBBDD" (Y ya sabremos que tenemos conexión)
     * 
     * @return
     */
    public static boolean isConnected() {
        
        checkConn(); //Llamada al Metodo privado "checkConn"
        return statusBBDD;
    }

    
    //Cuidao que "SE TENSA LA COSA" 
    private static void checkConn() {
        
         if (sessionFactory != null) { 
             
             statusBBDD=false; 
        try{ 
            session = getCurrentSession();
             
            Query query = session.createSQLQuery("SELECT VERSION() testConnection");
   
             query.list();
            session.close();
            statusBBDD=true; 

        }catch(Exception e){
            
            statusBBDD=false;
            
            buildSessionFactory();
        
            
        }
        
        }
               
    }//Fin de CheckConn
    
 
  }//Fin de la clase
