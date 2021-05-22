package Models.DAOs;


import SessionFactory.HibernateUtil_SessionFactory;
import Models.POJOs.Contendiente;
import Models.POJOs.Guerra;
import Models.POJOs.Pais;
import Models.POJOs.UnionBandos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
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

    public void insert(Contendiente contender, String nombreGuerra)  {

        Session session = HibernateUtil_SessionFactory.getCurrentSession();
            Query query=session.createQuery("SELECT g From Guerra g WHERE g.nombre = :nombre");
            query.setParameter("nombre", nombreGuerra);
            
            //Recuperando Guerra
            Guerra guerra= (Guerra) query.uniqueResult();
            contender.setGuerra(guerra);
            
            session.beginTransaction();
            session.save(contender);
            session.getTransaction().commit();
            session.close();
    }
 
    

    //UPDATE CONTENDIENTE      
    public void update(Contendiente contendiente, String oldName)  {

       Session session = HibernateUtil_SessionFactory.getCurrentSession();
           
           Query query=session.createQuery("SELECT c From Contendiente c WHERE c.nombre = :nombre");        
           query.setParameter("nombre", oldName);
                    
           //Recuperando Guerra
           Contendiente contendiente_hib= (Contendiente) query.uniqueResult();

           contendiente_hib.setGanador(contendiente.getGanador());
           contendiente_hib.setNombre(contendiente.getNombre());
                 
           session.beginTransaction();
           session.save(contendiente_hib);
           session.getTransaction().commit();
           session.close();
 
    }

    
    
        //Obtener ganador
    public int select_Winner(String nombreContendiente) {
	
        Integer winner;
           Session session = HibernateUtil_SessionFactory.getCurrentSession();
           
           Query query=session.createQuery("SELECT c From Contendiente c WHERE c.nombre = :nombre");        
           query.setParameter("nombre", nombreContendiente);
                    
           //Recuperando Guerra
           Contendiente contendiente_hib= (Contendiente) query.uniqueResult();
           
           try{
           
               winner = contendiente_hib.getGanador();
        
           }catch (Exception e){
                winner=0;
           }
           session.close();
                   
	return winner;
    }

    




    //DELETE CONTENDIENTE
    public void delete(Contendiente contendiente) {

        String nombreContendiente= contendiente.getNombre();
         Session session = HibernateUtil_SessionFactory.getCurrentSession();
           
           Query query=session.createQuery("SELECT c From Contendiente c WHERE c.nombre = :nombre");        
           query.setParameter("nombre", nombreContendiente);
                    
           //Recuperando Guerra
           Contendiente contendiente_hib= (Contendiente) query.uniqueResult();
           session.beginTransaction();
           session.delete(contendiente_hib);
           session.getTransaction().commit();
           session.close();
        
    }


}
