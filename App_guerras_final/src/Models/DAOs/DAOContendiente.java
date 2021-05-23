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
    public void insert(Contendiente contender, String nombreGuerra) {

        Session session = HibernateUtil_SessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT g FROM Guerra g WHERE g.nombre = :nombre");
        query.setParameter("nombre", nombreGuerra);

        //Recuperando Guerra
        Guerra guerraBBDD = (Guerra) query.uniqueResult();
        contender.setGuerra(guerraBBDD);

        session.beginTransaction();
        session.save(contender);
        session.getTransaction().commit();
        session.close();
    }

    
    
    //UPDATE CONTENDIENTE      
    public void update(Contendiente contendiente, String oldName) {

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
    
    

    //Obtener ganador
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

    
    
    //DELETE CONTENDIENTE
    public void delete(Contendiente contendiente) {

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
