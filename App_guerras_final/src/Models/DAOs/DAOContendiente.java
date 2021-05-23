package Models.DAOs;

import SessionFactory.HibernateUtil_SessionFactory;
import Models.POJOs.Contendiente;
import Models.POJOs.Guerra;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author davidf
 */
public class DAOContendiente {

    public DAOContendiente() {

    }

    
//////////////////CRUD DE CONTENDIENTES/////////////////////////////////////////
    
    
        //Obtener Si El CONTENDIENTE solicitado ES ganador o no
    public int isWinnerContender(String nombreContendiente) {

        Integer winner;
        Session session = HibernateUtil_SessionFactory.getCurrentSession();

        Query query = session.createQuery("SELECT c.ganador FROM Contendiente c WHERE c.nombre = :nombre");
        query.setParameter("nombre", nombreContendiente);
        
        try {
            winner = (Integer) query.getSingleResult();
        } catch (Exception e) {
            winner = 0;
        }
        
        session.close();

        return winner;
    }
    
    
    
    
    //Insertar CONTENDIENTE
    public void insertContendiente(Contendiente contendiente, String nombreGuerra) {

        Session session = HibernateUtil_SessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT g FROM Guerra g WHERE g.nombre = :nombre");
        query.setParameter("nombre", nombreGuerra);

        //Recuperando Guerra
        Guerra guerraBBDD = (Guerra) query.uniqueResult();
        contendiente.setGuerra(guerraBBDD);

        session.beginTransaction();
        session.save(contendiente);
        session.getTransaction().commit();
        session.close();
    }

    
    
    //UPDATE CONTENDIENTE      
    public void updateContendiente(Contendiente contendiente, String oldName) {

        Session session = HibernateUtil_SessionFactory.getCurrentSession();

        Query query = session.createQuery("SELECT c From Contendiente c WHERE c.nombre = :nombre");
        query.setParameter("nombre", oldName);

        //Recuperando Guerra
        Contendiente contendienteBBDD = (Contendiente) query.uniqueResult();

        contendienteBBDD.setGanador(contendiente.getGanador());
        contendienteBBDD.setNombre(contendiente.getNombre());

        session.beginTransaction();
        session.save(contendienteBBDD);
        session.getTransaction().commit();
        session.close();
    }
    
    

        
    //DELETE CONTENDIENTE
    public void deleteContendiente(Contendiente contendiente) {

        String nombreContendiente = contendiente.getNombre();
        Session session = HibernateUtil_SessionFactory.getCurrentSession();

        Query query = session.createQuery("SELECT c FROM Contendiente c WHERE c.nombre = :nombre");
        query.setParameter("nombre", nombreContendiente);

        //Recuperando Guerra
        Contendiente contendienteBBDD = (Contendiente) query.uniqueResult();
        session.beginTransaction();
        session.delete(contendienteBBDD);
        session.getTransaction().commit();
        session.close();

    }
    
    
    


    


}
