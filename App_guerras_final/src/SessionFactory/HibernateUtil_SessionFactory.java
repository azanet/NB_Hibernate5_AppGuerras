/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * HibernateUtil_Tunning
 * 
 * Utilizando las LIBRERIAS de HIBERNATE 5.4.31
 *
 * @author davidf
 *
 * 
 * DESCRIPCION: 
 * Clase para crear la "Session" de Hibernate
 * 
 * ## MODO DE USO ##
 * 
 *  Solo tiene 3 metodos PUBLICOS y ESTÁTICOS (el resto son Private):
 *  
 *  1)-- isConnected() = Utilizar este método directamente para Crear la factoria de sesiones
 *                       Lanza un Thread para la creación de esta
 *                       Comprueba si la conexión es correcta, y si no lo es, se encarga de TODA la RECONEXIóN
 *                       Retorna un BOOLEAN (Para que pueda ser utilizado en cualquier lugar de nuestro código)
 * 
 * 2)-- getCurrentSession() = Devuelve el objeto "Session" listo para ser utilizado
 * 
 * 3)-- 
 *
 *
 * 
 */
public class HibernateUtil_SessionFactory {

    private static SessionFactory sessionFactory;
    private static Session session;
    public static boolean statusBBDD = false;

    //Fabricando la sesionFactory
    /**
     * Se ha creado un "Thread" para crear la Factoría de sesiones y de esta manera
     * evitar se interrumpa el flujo del programa en caso de quedarse esperando
     * la conexión.
     */
    private static void buildSessionFactory() {

        if (sessionFactory == null) {

            new Thread(new Runnable() {
                public void run() {

                    statusBBDD = false;
                    sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
                    statusBBDD = true;

                }
            }).start();

        }
    }// Fin del método BuildFactory
    

    /**
     * Abre una nueva sesión
     */
    private static void openSession() {

        session = sessionFactory.openSession();

    }

    /**
     * Devuelve la sesión actual
     *
     * @return
     */
    public static Session getCurrentSession() {

        if ((session == null) || (!session.isOpen())) {
            openSession();
        }

        return session;
    }

    /**
     * Cierra Hibernate
     */
    public static void closeSessionFactory() {

        if (session != null) {
            session.close();
        }

        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    /**
     * Devuelve el Valor de la variable "statusBBDD" despues de ejecutar el
     * metodo PRIVADO "CheckConn"
     *
     * El metodo "CheckConn" = Lanzará una consulta y SI SE REALIZA CON EXITO la
     * variable "statusBBDD" se pone a TRUE, en caso de LANZAR ERROR la variable
     * "statusBBDD" se pone a FALSE.
     *
     * Crearemos un TIMER en la CLASE que QUERAMOS comprobar si la conexión es
     * VALIDA, para que itere y repita la llamada al Metodo "isConnected" en
     * caso de ser FALLIDA la conexión. En el momento que la conexión funcione,
     * se realizará la consulta y cambiará el estado de la variable "statusBBDD"
     * (Y ya sabremos que tenemos conexión) en caso contrario, cerrará todo 
     * y tratará de RECONECTAR.
     *
     * @return
     */
    public static boolean isConnected() {

        checkConn(); //Llamada al Metodo privado "checkConn"
        return statusBBDD;
    }
    

    //Cuidao que "SE TENSA LA COSA" 
        /**
         * Comprobará si existe SessionFactory: 
         * 
         *  -Si existe, ejecutará una consulta a ver si la BBDD contesta, 
         *  -En caso de error, cerrará la FactorySession, la pondrá a NULL
         * 
         *  -En caso de la SessionFactory ser NULL, Tratará de iniciar una nueva factoría.
         */
    private static void checkConn() {
        
        if (sessionFactory != null) {

         
            try {
                session = getCurrentSession();

                Query query = session.createSQLQuery("SELECT VERSION() testConnection");

                query.list();
                session.close();
                statusBBDD = true;

            } catch (Exception e) {

                statusBBDD = false;
                
                //Cerrando la FactorySession y poniendola a NULL si no, no va a llegar nunca a la "reconexión"
                closeSessionFactory();
                sessionFactory = null;

            }

        } else {
            
            //Creando la FactorySession
            buildSessionFactory();
        }

    }//Fin de CheckConn

    
    
    
}//Fin de la clase
