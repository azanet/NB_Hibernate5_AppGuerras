package Models.DAOs;


import Models.POJOs.Pais;
import Models.POJOs.PeriodoIndependecia;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author davidf
 */
public class Pais_DAO {

    private List<Pais> PaisesList;

            
    public Pais_DAO() {

    }
    
    
    
    public void queriesI() {

     Session session= HibernateUtil_SessionFactory.getCurrentSession();
        
        Query q=session.createQuery("from Pais");
        PaisesList = new ArrayList<>(q.list());
     session.close();
    }

    
    
    //Obtener el objeto
    public Object[] getCountryData(int indice) {

         Session session = HibernateUtil_SessionFactory.getCurrentSession(); 
         Pais p = PaisesList.get(indice);
           
         Pais p_aux = session.get(Pais.class, p.getIdPais());         
            
        
           List<PeriodoIndependecia> piList = new ArrayList<>(p_aux.getPeriodoIndependecias());
            PeriodoIndependecia pi = new PeriodoIndependecia();
            for (PeriodoIndependecia periodoIndependecia : piList) {
                pi= periodoIndependecia;
                break;
            }
            
            Object[] values=new Object[]{p_aux.getIdPais(), p_aux.getNombre(),pi.getIdPeriodo(),pi.getAnioInicio(),pi.getAnioFin()};
            session.close();
        return values;
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
        
        session.close();
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
           
            Session session = HibernateUtil_SessionFactory.getCurrentSession();
            //Recogiendo objeto de la BBDD
            Pais country_aux = session.get(Pais.class, id);
           
           //Seteando valores del Jtable al objeto recogido de la BBDD
           country_aux.setNombre(country.getNombre());

           session.beginTransaction();          
           session.save(country_aux);
           session.getTransaction().commit();
           session.close();
          
        
    }
    
    
  
 ////////////////////////////////////////////////////////7    



    public void updateIndependencePeriod(Pais country) {

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
        
             session.close();
        }

    }
    
    
    
    
    public void insertIndependencePeriod(Pais country) {
    
        Session session = HibernateUtil_SessionFactory.getCurrentSession(); 
     
        
        Query query=session.createQuery("from Pais p where p.nombre = :nombre");           
        query.setParameter("nombre", country.getNombre());
        Pais p = (Pais) query.uniqueResult();
        
 
        PeriodoIndependecia periodoIndependencia=new PeriodoIndependecia();
        
        List<PeriodoIndependecia> pi = new ArrayList<>(country.getPeriodoIndependecias());
        
        for (PeriodoIndependecia perInd : pi) {
           
            periodoIndependencia=perInd;
      
           break;
        }      
       
         periodoIndependencia.setPais(p);
         
        session.save(periodoIndependencia);
        session.getTransaction().commit();
         
        session.close();
 

    }

    
    
    public void deleteIndependencePeriod(Pais country){
 
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
