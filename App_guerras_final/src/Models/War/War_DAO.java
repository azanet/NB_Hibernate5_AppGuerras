package Models.War;


import Models.POJOs.Contendiente;
import Models.DetailsWarDTO;
import Models.POJOs.Guerra;
import Models.HibernateUtil_SessionFactory;
import Models.POJOs.Pais;
import Models.POJOs.PeriodoIndependecia;
import Models.POJOs.UnionBandos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author davidf
 */
public class War_DAO {
    
    private List<Guerra> GuerrasList;
    private DetailsWarDTO detailsWar;


    public War_DAO() throws ClassNotFoundException, SQLException {
      
    }
    

  //Consulta que obtiene toda la lista de Guerras contenidas en la bbdd
    public void queriesI() {
        Session session= HibernateUtil_SessionFactory.getCurrentSession();
        
        Query q=session.createQuery("from Guerra");
        GuerrasList=new ArrayList<>(q.list());
        
        session.close();
    }
    
    
    //Obtener el objeto
    public Guerra getWarDTO(int indice) {
        
        Guerra g=GuerrasList.get(indice);      
        return g;       
    }


    
  
    //Obtener la "dimension" del ArrayList de guerras
    public int getSizeList() {   
        return GuerrasList.size();
    }
    
    

    //Busqueda Suave, por nombre, año inicio, o año fin (todo junto)
    public void lightSearch(String nombre) {
           
        try (Session session = HibernateUtil_SessionFactory.getCurrentSession()) {
            nombre="%"+nombre+"%";
            
            Query query=session.createQuery("FROM Guerra g WHERE g.nombre like :nombre or g.anioInicio like :nombre or g.anioFin like :nombre");              
            query.setParameter("nombre", nombre);
            
            GuerrasList = new ArrayList<> (query.list());
        }
    }

    
    

    
    public Guerra findById(int id) throws SQLException {
         
        Guerra war;
       try (Session session = HibernateUtil_SessionFactory.getCurrentSession()) {
           war = session.get(Guerra.class, id);
           session.close();
       }
        return war;
    }

    
    //insertar registro
    public void insert(Guerra war)  {
  
       try (Session session = HibernateUtil_SessionFactory.getCurrentSession()) {
           session.beginTransaction();
           session.save(war);
           session.getTransaction().commit();
           session.close();
       }     
    }

    
    //borrar registro
    public void delete(Guerra war) throws SQLException {

           int id=war.getIdGuerra();
           
           //Recogiendo Guerra de la BBDD, utilizando su ID, para su eliminación
           Guerra war_aux= findById(id);
          
        try (Session session = HibernateUtil_SessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.delete(war_aux);
            session.getTransaction().commit();
        }
    }

    //actualizar registro
    public void update(Guerra war) throws SQLException {

           int id=war.getIdGuerra();
           
            try (Session session = HibernateUtil_SessionFactory.getCurrentSession()) {
            //Recogiendo objeto de la BBDD
            Guerra war_aux = session.get(Guerra.class, id);
           
           //Seteando valores del Jtable al objeto recogido de la BBDD
           war_aux.setNombre(war.getNombre());
           war_aux.setAnioInicio(war.getAnioInicio());
           war_aux.setAnioFin(war.getAnioFin());
           
          
           session.beginTransaction();          
           session.save(war_aux);
           session.getTransaction().commit();
           session.close();
       }     

    }

    //PARA EL APARTADO DE CONSULTAS!!
    public ArrayList returnDetails(Guerra war) throws SQLException{
        
        ArrayList<DetailsWarDTO> detailsWarList = new ArrayList<>();
            String nombre_guerra, inicio_guerra, fin_guerra;
            String nombre_contendiente, ganador_contendiente;
            String nombre_pais;
            String inicio_independiente="", fin_independiente="";
            String inicio_unioncont, abandono_unioncont;
            
            int id=war.getIdGuerra();
        
        try (Session session = HibernateUtil_SessionFactory.getCurrentSession()) {
            
            //Solicitando la guerra con la ID ESPECIFICADA, utilizaré el objeto con la sesion en el mismo método, 
            //para que funcione la conexion LAZY (automaticamente me recupere los datos de las tablas relacionadas con este objeto en caso de solcitarselos)
            Guerra war_aux = session.get(Guerra.class, id);
            
            //Almacenando Datos de la GUERRA (Será el mismo para todos)
            nombre_guerra= war_aux.getNombre();
            inicio_guerra= war_aux.getAnioInicio();
            fin_guerra= war_aux.getAnioFin();
            //Obteniendo el SET de "contendiente" que nos trae la "guerra" (corresponde a su tabla relacionada en la BBDD)
            List<Contendiente> contendientes = new ArrayList<>(war_aux.getContendientes());
            //Iteramos por cada CONTENDIENTE, para recuperar los objetos de PAISES que contiene y seguir obteniendo la informacion
            for (Contendiente contendiente : contendientes) {
                
                //Almacenando Datos del contendiente (Será el mismo para todos los PAISES pretenecientes a EL MISMO 'bando')
                nombre_contendiente= contendiente.getNombre();
                ganador_contendiente = Integer.toString(contendiente.getGanador());
                
                //Obteniendo el SET de "UnionBandos" que nos trae "Contendiente" (corresponde a su tabla relacionada en la BBDD)
                List<UnionBandos> ub= new ArrayList<>(contendiente.getUnionBandoses());
                
                //Iteramos por cada BANDO, para obtener sus datos
                for (UnionBandos unionBandos : ub) {
                    inicio_unioncont = unionBandos.getFechaUnion();
                    abandono_unioncont = unionBandos.getFechaAbandono();
                    
                    //Obteniendo PAIS relacionado con este 'BANDO, extraeremos sus datos'
                    Pais pais= unionBandos.getPais();
                    nombre_pais = pais.getNombre();
                    
                    //Recogiendo SET (aunque solo hay uno) de las fechas de independencia, en caso de tener RELACION con esta tabla
                    List<PeriodoIndependecia> pi = new ArrayList<>(pais.getPeriodoIndependecias());
                    
                    //Recodierndo el SET de independencia(aunque en teoria solo deberia tener uno, lo iré pisando y me quedaré con el ultimo, aunque solo deberia haber uno)
                    for (PeriodoIndependecia periodoIndependecia : pi) {
                        inicio_independiente = Integer.toString(periodoIndependecia.getAnioInicio());
                        fin_independiente = Integer.toString(periodoIndependecia.getAnioFin());
                    }
                    
                    
                //Y AQUÍ ES DONDE POR FIN ALMACENAREMOS EL OBJETO,
                //YA CONTENDRÁ TODA LA INFORMACION NECESARIA PARA PODER ESCRIBIR NUESTRA "DESCRIPCION DE LA GUERRA"
                    detailsWar= new DetailsWarDTO(nombre_guerra, inicio_guerra,fin_guerra,nombre_contendiente,ganador_contendiente, nombre_pais, inicio_independiente,fin_independiente,inicio_unioncont,abandono_unioncont);
                    detailsWarList.add(detailsWar);
                /////////////////////////////////////////////////        
                    
                }//Fin FOR UnionBandos
                
                
                
            }//Fin FOR Contendientes
            
        }//Find el try que contiene la SESSION y todo el proceso de recopilacion e inserciond e datos

        //Retornamos el ArrayList con todo el contenido a mostrar
        return detailsWarList;
        
    }//Fin de returnDetails

  
}//Find e clase principal
