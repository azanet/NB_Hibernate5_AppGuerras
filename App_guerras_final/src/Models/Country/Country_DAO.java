package Models.Country;


import Models.HibernateUtil_SessionFactory;
import Models.POJOs.Pais;
import Models.POJOs.PeriodoIndependecia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Sonia Castro Martel
 */
public class Country_DAO {

    private List<Pais> PaisesList;

            
    public Country_DAO() throws ClassNotFoundException, SQLException {

    }
    
    
    
    public void queriesI() {

     Session session= HibernateUtil_SessionFactory.getCurrentSession();
        
        Query q=session.createQuery("from Pais");
        PaisesList = new ArrayList<>(q.list());
     
    }

    
    
    //Obtener el objeto
    public Pais getCountryDTO(int indice) {

        Pais country = PaisesList.get(indice);
        return country;
    }

    
    
      
    //Obtener la "dimension" del ArrayList de guerras
    public int getSizeList() {   
        return PaisesList.size();
    }
    
 

    public void lightSearch(String nombre) {

        Session session = HibernateUtil_SessionFactory.getCurrentSession(); 
        nombre="%"+nombre+"%";
            
        Query query=session.createQuery("FROM Pais p WHERE p.nombre LIKE :nombre");           
        query.setParameter("nombre", nombre);
        PaisesList = new ArrayList<> (query.list());
    }
    

    //insertar registro
    public void insert(Pais country){

     try (Session session = HibernateUtil_SessionFactory.getCurrentSession()) {
           session.beginTransaction();
           session.save(country);
           session.getTransaction().commit();
           session.close();
       }    
        
    }
    

    //borrar registro
    public void delete(Pais country)  {

            int id=country.getIdPais();
           
           Session session = HibernateUtil_SessionFactory.getCurrentSession();
           
            //Recogiendo Guerra de la BBDD, utilizando su ID, para su eliminación
            Pais country_aux = session.get(Pais.class, id);         
            
            session.beginTransaction();
            session.delete(country_aux);
            session.getTransaction().commit();
            session.close();        
    }

       
    //actualizar registro
    public void update(Pais country) {

            int id=country.getIdPais();
           
            try (Session session = HibernateUtil_SessionFactory.getCurrentSession()) {
            //Recogiendo objeto de la BBDD
            Pais country_aux = session.get(Pais.class, id);
           
           //Seteando valores del Jtable al objeto recogido de la BBDD
           country_aux.setNombre(country.getNombre());

           session.beginTransaction();          
           session.save(country_aux);
           session.getTransaction().commit();
           session.close();
       }   
        
    }
    
    
  
 ////////////////////////////////////////////////////////7    



    public void updateIndependencePeriod(Pais country) throws SQLException {

             Session session = HibernateUtil_SessionFactory.getCurrentSession(); 

                session.beginTransaction();  
                Query query=session.createQuery("from Pais p where p.idPais = :id");           
        query.setParameter("id", country.getIdPais());
        Pais p = (Pais) query.uniqueResult();
        
        //Cogiendo la lista DEL OBJETO RESCATADO DE LA BBDD y lo SETEAMOS con el que viene del controlador
        List<PeriodoIndependecia> pi = new ArrayList<>(p.getPeriodoIndependecias());
        
        if (pi.size() > 0) {
            
            Integer anio_inicio=null;
            Integer anio_fin=null;
            
            List<PeriodoIndependecia> pi_aux = new ArrayList<>(country.getPeriodoIndependecias());
            for (PeriodoIndependecia periodoIndependecia : pi_aux) {
                anio_inicio = periodoIndependecia.getAnioInicio();
                anio_fin = periodoIndependecia.getAnioFin();
                break;
            }
            
        
            for (PeriodoIndependecia periodoIndependecia : pi) {
                periodoIndependecia.setAnioInicio(anio_inicio);
                periodoIndependecia.setAnioFin(anio_fin);
                session.save(periodoIndependecia);
                break;
            }
        
           session.getTransaction().commit();
           session.close();
            
            
            
        } else {
            insertIndependencePeriod(country);

        }

    }
    
    
    
    
    public void insertIndependencePeriod(Pais country) {
    
        Session session = HibernateUtil_SessionFactory.getCurrentSession(); 

        
        Query query=session.createQuery("from Pais p where p.nombre = :nombre");           
        query.setParameter("nombre", country.getNombre());
        Pais p = (Pais) query.uniqueResult();
        List<PeriodoIndependecia> pi = new ArrayList<>(country.getPeriodoIndependecias());
        for (PeriodoIndependecia periodoIndependecia : pi) {
           periodoIndependecia.setPais(p);
           session.save(periodoIndependecia);
           break;
        }
        session.close();
    

    }

    
    
    public void deleteIndependencePeriod(Pais country) throws SQLException {
 
        Session session = HibernateUtil_SessionFactory.getCurrentSession(); 
        
        session.beginTransaction();       
        Query query=session.createQuery("from Pais p where p.nombre = :nombre");           
        query.setParameter("nombre", country.getNombre());
        Pais p = (Pais) query.uniqueResult();
        
        List<PeriodoIndependecia> pi = new ArrayList<>(p.getPeriodoIndependecias());   
        
        for (PeriodoIndependecia periodoIndependecia : pi) {
           session.delete(periodoIndependecia);
           break;
        }
     
        session.getTransaction().commit();
            session.close(); 
        
  
        

    }


}
