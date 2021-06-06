package Models.DAOs;

import SessionFactory.HibernateUtil;
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
    private List<String[]> paisesAllData;

    
    //Constructor
    public DAOPais() {

    }

    
        
    public void selectAllPaises() {

        Session session = HibernateUtil.getCurrentSession();

        Query query = session.createQuery("SELECT p FROM Pais p");

        chargePaisDetailsList(query);

        session.close();

    }
    
    

    //BUSQUEDA "SUAVE" por nombre de PAIS o FECHAS DE INDEPENDENCIA
    public void lightSearchPaises(String nombre) {

        Session session = HibernateUtil.getCurrentSession();

        nombre = "%" + nombre + "%";
        Query query = session.createQuery("SELECT p FROM Pais p LEFT JOIN PeriodoIndependecia pi ON pi.pais = p WHERE p.nombre LIKE :nombre OR pi.anioInicio LIKE :nombre OR pi.anioFin LIKE :nombre");
        query.setParameter("nombre", nombre);

        chargePaisDetailsList(query);

        session.close();
    }
    
    
    /**
     * ESTE METODO, RECIBE UN OBJETO DE TIPO "Query" LA CUAL TRAE CONFIGURADA LA
     * CONSULTA REALIZAR POSTERIORMENTE CARGARÁ LA LISTA DE "paisesDetails" QUE
     * UTILIZAREMOS PARA ESTÁR MOSITRANDO LOS DATOS DE ESTA EN NUESTRO jtable.
     *
     * EL MÉTODO FUE REALIZADO PARA REUTILIZAR LA OPERACION DE CARGAR YA QUE ES
     * UTILIZADA MÁS DE UN MÉTODO
     *
     * @param query
     *
     *
     * Es llamado por:
     *
     * -selectAllPaises() -lightSearchPaises(String nombre)
     *
     */
    private void chargePaisDetailsList(Query query) {

        Session session = HibernateUtil.getCurrentSession();

        List<Pais> paisesBBDDList = new ArrayList<>(query.list());

        //Volviendo a crear una lista nueva PAISES-DETAILS para RELLENARLA
        paisesAllData = new ArrayList<>();

        //Recorriendo la lista de PAISES devuelta por la "query" para SOLICITAR su OBJETO 
        //PERIODO INDEPENDENCIA y almacenarlo todo junto en la LISTA que utilizará nuestra Jtable
        for (Pais paisBBDD : paisesBBDDList) {

            //Creando ARRAY que aliviará la BBDD
            String[] paisAllData = new String[5];

            paisAllData[0] = Integer.toString(paisBBDD.getIdPais());
            paisAllData[1] = paisBBDD.getNombre();

            List<PeriodoIndependecia> pi = new ArrayList<>(paisBBDD.getPeriodoIndependecias());

            for (PeriodoIndependecia periodoIndependecia : pi) {

                paisAllData[2] = Integer.toString(periodoIndependecia.getIdPeriodo());
                paisAllData[3] = Integer.toString(periodoIndependecia.getAnioInicio());
                try {
                    paisAllData[4] = Integer.toString(periodoIndependecia.getAnioFin());
                } catch (Exception nfe) {
                    paisAllData[4] = null;
                }
            }

            //Agregamos el ARRAY que HEMOS MONTADO con los DATOS NECESARIOS a la LISTA PAISES-DETAILS
            paisesAllData.add(paisAllData);

        }//Fin del FOR "PAIS"

        session.close();
    }

    

    
    ////////////////////CRUD///////////////////////////////////////
    
    //insertar registro
    public void insertPais(Pais pais) {

        try (Session session = HibernateUtil.getCurrentSession()) {
            session.beginTransaction();
            session.save(pais);
            session.getTransaction().commit();
            session.close();
        }

    }
    
    
    //actualizar registro
    public void updatePais(Pais pais) {

        int id = pais.getIdPais();

        Session session = HibernateUtil.getCurrentSession();
        //Recogiendo objeto de la BBDD
        Pais paisBBDD = session.get(Pais.class, id);

        //Seteando valores del Jtable al objeto recogido de la BBDD
        paisBBDD.setNombre(pais.getNombre());

        session.beginTransaction();
        session.save(paisBBDD);
        session.getTransaction().commit();
        session.close();

    }
    

    //borrar registro
    public void deletePais(Pais pais) {

        int id = pais.getIdPais();

        Session session = HibernateUtil.getCurrentSession();

        //Recogiendo Guerra de la BBDD, utilizando su ID, para su eliminación
        Pais paisBBDD = session.get(Pais.class, id);

        session.beginTransaction();
        session.delete(paisBBDD);
        session.getTransaction().commit();
        session.close();
    }

    
    


    
    
/////////////METODOS UTILIZADOS POR LA JTABLE   ////////////////////////////////// 
    //Obtener el objeto
    public Object[] getPaisAllData(int indice) {

        Object[] values = paisesAllData.get(indice);
        return values;
    }

    
    
    //Obtener la "dimension" del ArrayList de guerras
    public int getPaisAllDataSizeList() {
        
        try{       
            return paisesAllData.size();
        }catch(NullPointerException npe){
            return 0;
        }
        
    }

}//FIN DE LA CLASE
