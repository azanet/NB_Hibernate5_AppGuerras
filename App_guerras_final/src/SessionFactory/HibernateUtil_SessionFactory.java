/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionFactory;

import static java.lang.System.currentTimeMillis;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * HibernateUtil_Tunning
 *
 * Utilizando las LIBRERIAS de HIBERNATE 5.4.31
 *
 * @author davidf https://github.com/azanet/
 *
 *
 * DESCRIPCION: Clase para crear la "Session" de Hibernate
 *
 * ## MODO DE USO ##
 * #############################################################################
 * Solo tiene 3 metodos PUBLICOS y ESTÁTICOS (el resto son Private):
 *
 * 1)-- isConnected() = Utilizar este método directamente para Crear la factoria
 * de sesiones Lanza un Thread para la creación de esta Comprueba si la conexión
 * es correcta, y si no lo es, se encarga de TODA la RECONEXIóN Retorna un
 * BOOLEAN (Para que pueda ser utilizado en cualquier lugar de nuestro código)
 *
 * 2)-- getCurrentSession() = Devuelve el objeto "Session" listo para ser
 * utilizado
 *
 * 3)-- closeSessionFactory() = Cierra la session y la factorySession
 * #############################################################################
 *
 */
public class HibernateUtil_SessionFactory {

    private static SessionFactory sessionFactory;
    private static Session session;
    private static boolean statusBBDD = false;

    //Variables para controlar la creacion de sesiones
    private static long flagTimeOut; //Almacenará el tiempo den milisegundos, de la ultima vez que se creó una factoría de sesiones
    private final static long TIMEOUT = 30000L;//Nuestro tiempo ESTIMADO es de 30segundos

    //Fabricando la sesionFactory
    /**
     * Se ha creado un "Thread" para crear la Factoría de sesiones y de esta
     * manera evitar se interrumpa el flujo del programa en caso de quedarse
     * esperando la conexión.
     */
    private static void buildSessionFactory() {

        if (sessionFactory == null) {

            new Thread(new Runnable() {
                public void run() {

                    statusBBDD = false;
                    sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
                    statusBBDD = true;
                    flagTimeOut = 0;// ponemos el tiempo a 0, porque ya la sesion existe y debe estar preparado para poder volver a intentar iniciarse en caso de perdida de conexion

                }
            }).start();

        }
    }// Fin del método BuildFactory

    /**
     * Abre una nueva sesión
     */
    private static void openSession() {
try{
        session = sessionFactory.openSession();
}catch(Exception e){
  //  session.flush();
}
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
     * (Y ya sabremos que tenemos conexión) en caso contrario, cerrará todo y
     * tratará de RECONECTAR.
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
     * -Si existe, ejecutará una consulta a ver si la BBDD contesta, -En caso de
     * error, cerrará la FactorySession, la pondrá a NULL
     *
     * -En caso de la SessionFactory ser NULL, Tratará de iniciar una nueva
     * factoría. -Cuenta con un temporizador, que evitará que se creen factorias
     * nuevas antes de 35 segundos para respetar su tiempo de escucha a alguna
     * conexion.
     */
    private static void checkConn() {

        if (sessionFactory != null) {

            try {
                session = getCurrentSession();
                //Query que determinará si la conexión es correcta o no, Se ha utilizado esta porque valdría en teoria para cualquiera de mis BBDD
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

            //Creando "timer personalizado Haciendo uso de Millis, para controlar que no se pueda volver a iniciar la factoría de sesiones antes del tiempo ESTIMADO"
            long actualtime = currentTimeMillis();
            if ((actualtime - flagTimeOut) > TIMEOUT) {

                System.out.println("han pasado 35 segundoas");
                flagTimeOut = actualtime;

                //Creando la FactorySession
                buildSessionFactory();
            }

        }

    }//Fin de CheckConn

}//Fin de la clase
