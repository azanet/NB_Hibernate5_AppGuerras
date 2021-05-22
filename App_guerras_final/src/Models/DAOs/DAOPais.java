package Models.DAOs;

import SessionFactory.HibernateUtil_SessionFactory;
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
public class DAOPais {
    
   //Lista en la que se almacenan los PAISES con sus FECHAS para no estar masacrando la BBDD a peticiones
    private List<String[]> paisesDetails; 

    //Constructor
    public DAOPais() {
    
    }
    
    

    /**
     * ESTE METODO, RECIBE UN OBJETO DE TIPO "Query" LA CUAL TRAE CONFIGURADA LA CONSULTA REALIZAR
     * POSTERIORMENTE CARGARÁ LA LISTA DE "paisesDetails" QUE UTILIZAREMOS PARA ESTÁR MOSITRANDO
     * LOS DATOS DE ESTA EN NUESTRO jtable.
     * 
     * EL MÉTODO FUE REALIZADO PARA REUTILIZAR LA OPERACION DE CARGAR YA QUE ES UTILIZADA MÁS DE UN MÉTODO
     * @param query 
     * 
     * Es llamado por:
     * -queriesI()
     * -lightSearch(String nombre) 
     */
    private void chargePaisDetailsList(Query query){
        
        Session session = HibernateUtil_SessionFactory.getCurrentSession();
        
        List<Pais> PaisesList = new ArrayList<>(query.list());

        //Volviendo a crear una lista nueva PAISES-DETAILS para RELLENARLA
        paisesDetails= new ArrayList<>();  
        
        //Recorriendo la lista de PAISES devuelta por la "query" para SOLICITAR su OBJETO 
        //PERIODO INDEPENDENCIA y almacenarlo todo junto en la LISTA que utilizará nuestra Jtable
        for (Pais pais : PaisesList) {
            
            //Creando ARRAY que aliviará la BBDD
            String[]  paisDetails_aux= new String[5];   
            
            paisDetails_aux[0]= Integer.toString(pais.getIdPais());
            paisDetails_aux[1]= pais.getNombre();
   
            List<PeriodoIndependecia> pi= new ArrayList<>(pais.getPeriodoIndependecias());

            for (PeriodoIndependecia periodoIndependecia : pi) {
                
                paisDetails_aux[2]=Integer.toString(periodoIndependecia.getIdPeriodo());
                paisDetails_aux[3]=Integer.toString(periodoIndependecia.getAnioInicio());
                try{
                    paisDetails_aux[4]=Integer.toString(periodoIndependecia.getAnioFin());
                }catch(Exception nfe){
                    paisDetails_aux[4]=null;
                }
            }
            
           //Agregamos el ARRAY que HEMOS MONTADO con los DATOS NECESARIOS a la LISTA PAISES-DETAILS
           paisesDetails.add(paisDetails_aux);
           
        }//Fin del FOR "PAIS"
        
         session.close();     
    }
    
    
    public void queriesI() {

        Session session = HibernateUtil_SessionFactory.getCurrentSession();
        
        Query query = session.createQuery("FROM Pais p");
        
        chargePaisDetailsList(query);
        //La sesion cierra en el metodo anteriormente llamado
        session.close();
        
    }

    
        //BUSQUEDA "SUAVE" por nombre
    public void lightSearch(String nombre) {

        Session session = HibernateUtil_SessionFactory.getCurrentSession();
        
        nombre = "%" + nombre + "%";
        Query query = session.createQuery("FROM Pais p WHERE p.nombre LIKE :nombre");
        query.setParameter("nombre", nombre);
        
         chargePaisDetailsList(query);
        //La sesion cierra en el metodo anteriormente llamado
        
       session.close();
    }



    //insertar registro
    public void insert(Pais country) {

        try (Session session = HibernateUtil_SessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(country);
            session.getTransaction().commit();
            session.close();
        }

    }

    //borrar registro
    public void delete(Pais country) {

        int id = country.getIdPais();

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

        int id = country.getIdPais();

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
//    public void updateIndependencePeriod(Pais country) {
//
//        Session session = HibernateUtil_SessionFactory.getCurrentSession();
//
//        Query query = session.createQuery("FROM Pais p WHERE p.idPais = :id");
//        query.setParameter("id", country.getIdPais());
//        Pais p = (Pais) query.uniqueResult();
//
//        //Cogiendo la lista DEL OBJETO RESCATADO DE LA BBDD
//         
//
//        if (p.getPeriodoIndependecias().size() > 0) {
//            //Insertando MODIFICACIONES EN EL periodoIndependencia del PAIS existente en la BBDD
//            session.beginTransaction();
//            //Recogemos el PeriodoInd del PAIS recuperado de la BBDD
//            PeriodoIndependecia pi = (PeriodoIndependecia) (new ArrayList<>(p.getPeriodoIndependecias())).get(0);
//
//            //Recogiendo PeriodoInd. del PAIS que viene DEL CONTROLADOR
//            PeriodoIndependecia pi_aux = (PeriodoIndependecia) (new ArrayList<>(country.getPeriodoIndependecias())).get(0);
//
//            
//
//                pi.setAnioInicio(pi_aux.getAnioInicio());
//                pi.setAnioFin(pi_aux.getAnioFin());
//                session.save(pi);
//          
//
//            session.getTransaction().commit();
//            session.close();
//
//        } else {
//            insertIndependencePeriod(country);
//
//            session.close();
//        }
//
//    }
//
//    public void insertIndependencePeriod(Pais country) {
//
//        Session session = HibernateUtil_SessionFactory.getCurrentSession();
//
//        session.beginTransaction();
//        Query query = session.createQuery("FROM Pais p WHERE p.nombre = :nombre");
//        query.setParameter("nombre", country.getNombre());
//        //Obteniendo objeto PAIS de la BBDD, para poder insertarselo a PeriodoInd
//        Pais p = (Pais) query.uniqueResult();
//        
//        //Obteniendo PeriodoInd. del objeto PAIS que hemos mandado DESDE EL CONTROLADOR
//        PeriodoIndependecia periodoIndependencia =(PeriodoIndependecia) (new ArrayList<>(country.getPeriodoIndependecias())).get(0);
//
//        //Indertando PAIS (que es la clave primaria [PK] de nuestro objeto ==>) a PeriodoInd. 
//        periodoIndependencia.setPais(p);
//
//        session.save(periodoIndependencia);
//        session.getTransaction().commit();
//
//        session.close();
//    }
//
//    
//    
//    public void deleteIndependencePeriod(Pais country) {
//
//        Session session = HibernateUtil_SessionFactory.getCurrentSession();
//
//        session.beginTransaction();
//        Query query = session.createQuery("FROM Pais p WHERE p.nombre = :nombre");
//        query.setParameter("nombre", country.getNombre());
//        
//        Pais p = (Pais) query.uniqueResult();
//
//        List<PeriodoIndependecia> pi = new ArrayList<>(p.getPeriodoIndependecias());
//
//        for (PeriodoIndependecia periodoIndependecia : pi) {
//            session.delete(periodoIndependecia);
//            break;
//        }
//
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    
//    
//        
   ////METODOS UTILIZADOS POR LA JTABLE 
    
    //Obtener el objeto
    public Object[] getCountryData(int indice) {

        Object[] values = paisesDetails.get(indice);
        return values;
    }
    
    

    //Obtener la "dimension" del ArrayList de guerras
    public int getSizeList() {
        return paisesDetails.size();
    }

    
}//FIN DE LA CLASE
