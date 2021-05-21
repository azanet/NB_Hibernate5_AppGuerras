package Models.DAOs;


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
 * @author Davidf
 */
public class Contender_DAO {



    public Contender_DAO() {

    }
    

    //DEFAULTCOMBOBOXMODELS
    public DefaultComboBoxModel fillComboBoxModelWar() {
	
        DefaultComboBoxModel comboBoxModelWar = new DefaultComboBoxModel();      
        comboBoxModelWar.addElement("Seleccione una guerra...");
        
        //Abriendo sesion, creando QUERY de la consulta y cargando el ComboBox con la lista recibida al realizar la consulta
        Session session = HibernateUtil_SessionFactory.getCurrentSession(); 
        Query query=session.createQuery("Select g.nombre from Guerra g order by g.nombre");        
             
        comboBoxModelWar.addAll(query.list());
        
        session.close();
        return comboBoxModelWar;	
    }


    public DefaultComboBoxModel fillComboBoxContender(String nombre)  {

        DefaultComboBoxModel comboBoxModelContender = new DefaultComboBoxModel();      
        comboBoxModelContender.addElement("Seleccione un Contendiente...");
        
        //Abriendo sesion, creando QUERY de la consulta y cargando el ComboBox con la lista recibida al realizar la consulta
        Session session = HibernateUtil_SessionFactory.getCurrentSession(); 
        Query query=session.createQuery("SELECT g From Guerra g WHERE g.nombre = :nombre");        
        query.setParameter("nombre", nombre);
        
        //Recuperando Guerra
        Guerra guerra= (Guerra) query.uniqueResult();
        
        if(guerra != null){
        //Obteniendo Los contendientes y agregandolos al comboBox
        List<Contendiente> contendientes = new ArrayList<>(guerra.getContendientes());
        
        for (Contendiente contendiente : contendientes) {
            comboBoxModelContender.addElement(contendiente.getNombre());
        }
        }
        session.close();
        return comboBoxModelContender;
    }

    
    
     
    
    public DefaultComboBoxModel fillComboBoxCountry(String nombre) {
     
        DefaultComboBoxModel comboBoxModelCountry = new DefaultComboBoxModel();
	        
        comboBoxModelCountry.addElement("Seleccione un PAÍS Contendiente...");
        
        //Abriendo sesion, creando QUERY de la consulta y cargando el ComboBox con la lista recibida al realizar la consulta
        Session session = HibernateUtil_SessionFactory.getCurrentSession(); 
        Query query=session.createQuery("SELECT c From Contendiente c WHERE c.nombre = :nombre");        
        query.setParameter("nombre", nombre);
        
        //Recuperando Guerra
        Contendiente contendiente= (Contendiente) query.uniqueResult();
        
        //Obteniendo los Paises contendientes y agregandolos al comboBox
        if (contendiente != null){
        List<UnionBandos> unionBandos = new ArrayList<>(contendiente.getUnionBandoses());
        
        
            for (UnionBandos unionBando : unionBandos) {
                Pais pais= unionBando.getPais();
                comboBoxModelCountry.addElement(pais.getNombre());
            }
        }
        
        session.close(); 
        
        return comboBoxModelCountry;    
    }

    
    
    public DefaultComboBoxModel fillAllCountriesCombobox() {

        DefaultComboBoxModel comboBoxModelCountries = new DefaultComboBoxModel();
        comboBoxModelCountries.addElement("Seleccione un País...");
        
        Session session = HibernateUtil_SessionFactory.getCurrentSession();
        Query query=session.createQuery("Select p.nombre from Pais p order by p.nombre");
            
        comboBoxModelCountries.addAll(query.list());
        session.close();
        
        return comboBoxModelCountries;     
    }

    

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
           winner = contendiente_hib.getGanador();
           session.close();
        
           if (winner == null){
                winner=0;
           }
               
           
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


    
    
    //INSERT PAIS
    public void insert_country(UnionBandos unionBandos,String nContendiente, String nPais){
   
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
//            
//            System.out.println(unionB.getIdUnionBandos());
//            System.out.println(unionB.getFechaAbandono());
//            System.out.println(unionB.getFechaUnion());
//            
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
