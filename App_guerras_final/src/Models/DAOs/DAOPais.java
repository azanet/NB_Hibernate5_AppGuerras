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

        Session session = HibernateUtil_SessionFactory.getCurrentSession();

        List<Pais> PaisesList = new ArrayList<>(query.list());

        //Volviendo a crear una lista nueva PAISES-DETAILS para RELLENARLA
        paisesDetails = new ArrayList<>();

        //Recorriendo la lista de PAISES devuelta por la "query" para SOLICITAR su OBJETO 
        //PERIODO INDEPENDENCIA y almacenarlo todo junto en la LISTA que utilizará nuestra Jtable
        for (Pais pais : PaisesList) {

            //Creando ARRAY que aliviará la BBDD
            String[] paisDetails_aux = new String[5];

            paisDetails_aux[0] = Integer.toString(pais.getIdPais());
            paisDetails_aux[1] = pais.getNombre();

            List<PeriodoIndependecia> pi = new ArrayList<>(pais.getPeriodoIndependecias());

            for (PeriodoIndependecia periodoIndependecia : pi) {

                paisDetails_aux[2] = Integer.toString(periodoIndependecia.getIdPeriodo());
                paisDetails_aux[3] = Integer.toString(periodoIndependecia.getAnioInicio());
                try {
                    paisDetails_aux[4] = Integer.toString(periodoIndependecia.getAnioFin());
                } catch (Exception nfe) {
                    paisDetails_aux[4] = null;
                }
            }

            //Agregamos el ARRAY que HEMOS MONTADO con los DATOS NECESARIOS a la LISTA PAISES-DETAILS
            paisesDetails.add(paisDetails_aux);

        }//Fin del FOR "PAIS"

        session.close();
    }

    
    
    public void selectAllPaises() {

        Session session = HibernateUtil_SessionFactory.getCurrentSession();

        Query query = session.createQuery("SELECT p FROM Pais p");

        chargePaisDetailsList(query);

        session.close();

    }
    
    

    //BUSQUEDA "SUAVE" por nombre de PAIS o FECHAS DE INDEPENDENCIA
    public void lightSearchPaises(String nombre) {

        Session session = HibernateUtil_SessionFactory.getCurrentSession();

        nombre = "%" + nombre + "%";
        Query query = session.createQuery("SELECT p FROM Pais p LEFT JOIN PeriodoIndependecia pi ON pi.pais = p WHERE p.nombre LIKE :nombre OR pi.anioInicio LIKE :nombre OR pi.anioFin LIKE :nombre");
        query.setParameter("nombre", nombre);

        chargePaisDetailsList(query);

        session.close();
    }

    
    
    //insertar registro
    public void insertPais(Pais country) {

        try (Session session = HibernateUtil_SessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(country);
            session.getTransaction().commit();
            session.close();
        }

    }
    
    

    //borrar registro
    public void deletePais(Pais country) {

        int id = country.getIdPais();

        Session session = HibernateUtil_SessionFactory.getCurrentSession();

        //Recogiendo Guerra de la BBDD, utilizando su ID, para su eliminación
        Pais paisBBDD = session.get(Pais.class, id);

        session.beginTransaction();
        session.delete(paisBBDD);
        session.getTransaction().commit();
        session.close();
    }

    
    
    //actualizar registro
    public void updatePais(Pais country) {

        int id = country.getIdPais();

        Session session = HibernateUtil_SessionFactory.getCurrentSession();
        //Recogiendo objeto de la BBDD
        Pais paisBBDD = session.get(Pais.class, id);

        //Seteando valores del Jtable al objeto recogido de la BBDD
        paisBBDD.setNombre(country.getNombre());

        session.beginTransaction();
        session.save(paisBBDD);
        session.getTransaction().commit();
        session.close();

    }

    
    
/////////////METODOS UTILIZADOS POR LA JTABLE   ////////////////////////////////// 
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
