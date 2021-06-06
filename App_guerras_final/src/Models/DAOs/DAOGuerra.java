package Models.DAOs;

import SessionFactory.HibernateUtil;
import Models.POJOs.Contendiente;
import Models.ConsultFormatTextUtils.DetailsWarDTO;
import Models.POJOs.Guerra;
import Models.POJOs.Pais;
import Models.POJOs.PeriodoIndependecia;
import Models.POJOs.UnionBandos;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author davidf
 */
public class DAOGuerra {

    private List<Guerra> GuerrasList;
    private DetailsWarDTO detailsWar;

    
    public DAOGuerra() {

    }

    
    
    //Consulta que obtiene toda la lista de Guerras contenidas en la bbdd
    public void selectAllGuerras() {
        Session session = HibernateUtil.getCurrentSession();

        Query query = session.createQuery("SELECT g FROM Guerra g ORDER BY g.nombre");
        GuerrasList = new ArrayList<>(query.list());

        session.close();
    }

    
    
    //Busqueda Suave, por nombre, año inicio, o año fin (todo junto)
    public void lightSearchGuerras(String nombre) {

        try (Session session = HibernateUtil.getCurrentSession()) {
            nombre = "%" + nombre + "%";

            Query query = session.createQuery("SELECT g FROM Guerra g WHERE g.nombre LIKE :nombre OR g.anioInicio LIKE :nombre OR g.anioFin LIKE :nombre");
            query.setParameter("nombre", nombre);

            GuerrasList = new ArrayList<>(query.list());
        }
    }

    
    
    //insertar registro
    public void insertGuerras(Guerra guerra)  {

        try (Session session = HibernateUtil.getCurrentSession()) {
            session.beginTransaction();
            session.save(guerra);
            session.getTransaction().commit();
            session.close();
        }
    }

    
    
        
    //actualizar registro
    public void updateGuerras(Guerra guerra) {

        int id = guerra.getIdGuerra();

        try (Session session = HibernateUtil.getCurrentSession()) {
            //Recogiendo objeto de la BBDD
            Guerra guerraBBDD = session.get(Guerra.class, id);

            //Seteando valores del Jtable al objeto recogido de la BBDD
            guerraBBDD.setNombre(guerra.getNombre());
            guerraBBDD.setAnioInicio(guerra.getAnioInicio());
            guerraBBDD.setAnioFin(guerra.getAnioFin());

            session.beginTransaction();
            session.save(guerraBBDD);
            session.getTransaction().commit();
            session.close();
        }

    }

    
    
    
    //borrar registro
    public void deleteGuerras(Guerra guerra) {

        int id = guerra.getIdGuerra();

        try (Session session = HibernateUtil.getCurrentSession()) {
            //Recogiendo Guerra de la BBDD, utilizando su ID, para su eliminación         
            Guerra guerraBBDD = session.get(Guerra.class, id);

            session.beginTransaction();
            session.delete(guerraBBDD);
            session.getTransaction().commit();
        }
    }

    

    
    
/////////////////////////////////////////////////////////////////////////
////////////////METODOS para JTABLE
/////////////////////////////////////////////////////////////////////////    
    //Obtener el objeto según el índice
    public Guerra getGuerraData(int indice) {

        Guerra guerra = GuerrasList.get(indice);
        return guerra;
    }

    
    //Obtener la "dimension" del ArrayList de guerras
    public int getGuerraSizeList() {
        
        try{
        
            return GuerrasList.size();
        
        }catch(NullPointerException e){
             return 0;
        }
        
    }
///////////////////////////////////////////////////////////////////////    

    
    
//////////////////////////////////////////////////////////////////////////////
    //PARA EL APARTADO DE CONSULTAS!!
//////////////////////////////////////////////////////////////////////////////  
    public ArrayList returnDetails(Guerra guerra) {

        ArrayList<DetailsWarDTO> detailsWarList = new ArrayList<>();
        String nombre_guerra, inicio_guerra, fin_guerra;
        String nombre_contendiente, ganador_contendiente;
        String nombre_pais;
        String inicio_independiente = "", fin_independiente = "";
        String inicio_unioncont, abandono_unioncont;

        int id = guerra.getIdGuerra();

        try (Session session = HibernateUtil.getCurrentSession()) {

            //Solicitando la guerra con la ID ESPECIFICADA, utilizaré el objeto con la sesion en el mismo método, 
            //para que funcione la conexion LAZY (automaticamente me recupere los datos de las tablas relacionadas con este objeto en caso de solcitarselos)
            Guerra guerraBBDD = session.get(Guerra.class, id);

            //Almacenando Datos de la GUERRA (Será el mismo para todos)
            nombre_guerra = guerraBBDD.getNombre();
            inicio_guerra = guerraBBDD.getAnioInicio();
            fin_guerra = guerraBBDD.getAnioFin();
            //Obteniendo el SET de "contendiente" que nos trae la "guerra" (corresponde a su tabla relacionada en la BBDD)
            List<Contendiente> contendientes = new ArrayList<>(guerraBBDD.getContendientes());
            //Iteramos por cada CONTENDIENTE, para recuperar los objetos de PAISES que contiene y seguir obteniendo la informacion
            for (Contendiente contendiente : contendientes) {

                //Almacenando Datos del contendiente (Será el mismo para todos los PAISES pretenecientes a EL MISMO 'bando')
                nombre_contendiente = contendiente.getNombre();
                ganador_contendiente = Integer.toString(contendiente.getGanador());

                //Obteniendo el SET de "UnionBandos" que nos trae "Contendiente" (corresponde a su tabla relacionada en la BBDD)
                List<UnionBandos> ub = new ArrayList<>(contendiente.getUnionBandoses());

                //Iteramos por cada BANDO, para obtener sus datos
                for (UnionBandos unionBandos : ub) {
                    inicio_unioncont = unionBandos.getFechaUnion();
                    abandono_unioncont = unionBandos.getFechaAbandono();

                    //Obteniendo PAIS relacionado con este 'BANDO, extraeremos sus datos'
                    Pais pais = unionBandos.getPais();
                    nombre_pais = pais.getNombre();

                    //Recogiendo SET (aunque solo hay uno) de las fechas de independencia, en caso de tener RELACION con esta tabla
                    List<PeriodoIndependecia> pi = new ArrayList<>(pais.getPeriodoIndependecias());

                    //Recodierndo el SET de independencia(aunque en teoria solo deberia tener uno, lo iré pisando y me quedaré con el ultimo, aunque solo deberia haber uno)
                    for (PeriodoIndependecia periodoIndependecia : pi) {
                        try{
                        inicio_independiente = Integer.toString(periodoIndependecia.getAnioInicio());
                        }catch(Exception e){
                            inicio_independiente="";
                        }
                        try{
                        fin_independiente = Integer.toString(periodoIndependecia.getAnioFin());
                        }catch(Exception e){
                            fin_independiente="";
                        }
                    }

                    //Y AQUÍ ES DONDE POR FIN ALMACENAREMOS EL OBJETO,
                    //YA CONTENDRÁ TODA LA INFORMACION NECESARIA PARA PODER ESCRIBIR NUESTRA "DESCRIPCION DE LA GUERRA"
                    detailsWar = new DetailsWarDTO(nombre_guerra, inicio_guerra, fin_guerra, nombre_contendiente, ganador_contendiente, nombre_pais, inicio_independiente, fin_independiente, inicio_unioncont, abandono_unioncont);
                    detailsWarList.add(detailsWar);
                    /////////////////////////////////////////////////        

                }//Fin FOR UnionBandos

            }//Fin FOR Contendientes

        }//Find el try que contiene la SESSION y todo el proceso de recopilacion e inserciond e datos

        //Retornamos el ArrayList con todo el contenido a mostrar
        return detailsWarList;

    }//Fin de returnDetails
///////////////////////////////////////////////////////////////////////////////////////////////

}//Find e clase principal
