/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAOs;

import Models.POJOs.Pais;
import Models.POJOs.PeriodoIndependecia;
import SessionFactory.HibernateUtil_SessionFactory;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author davidf
 */
public class DAOPeriodoIndependecia {
    
    

    public DAOPeriodoIndependecia() {
    }
    
    
        
    public void insertPeriodoIndependencia(Pais pais) {

        Session session = HibernateUtil_SessionFactory.getCurrentSession();

        Query query = session.createQuery("SELECT p FROM Pais p WHERE p.nombre = :nombre");
        query.setParameter("nombre", pais.getNombre());
        //Obteniendo objeto PAIS de la BBDD, para poder insertarselo a PeriodoInd
        Pais paisBBDD = (Pais) query.uniqueResult();

        //Obteniendo PeriodoInd. del objeto PAIS que hemos mandado DESDE EL CONTROLADOR
        PeriodoIndependecia periodoIndependencia = (PeriodoIndependecia) (new ArrayList<>(pais.getPeriodoIndependecias())).get(0);
        session.beginTransaction();
        //Indertando PAIS (que es la clave primaria [PK] de nuestro objeto ==>) a PeriodoInd. 
        periodoIndependencia.setPais(paisBBDD);

        session.save(periodoIndependencia);
        session.getTransaction().commit();

        session.close();
    }

    
    

    public void updatePeriodoIndependencia(Pais pais) {

        Session session = HibernateUtil_SessionFactory.getCurrentSession();

        Query query = session.createQuery("SELECT p FROM Pais p WHERE p.nombre =:nombre");
        query.setParameter("nombre", pais.getNombre());
        Pais paisBBDD = (Pais) query.uniqueResult();

        //Cogiendo la lista DEL "Pais" RESCATADO DE LA BBDD para ocmprobar si existe registro o no.
        if (paisBBDD.getPeriodoIndependecias().size() > 0) {
            //Insertando MODIFICACIONES EN EL periodoIndependencia del PAIS existente en la BBDD
            
            session.beginTransaction();
            
            //Recogemos el PeriodoInd del PAIS recuperado de la BBDD
            PeriodoIndependecia periodoIndependenciaBBDD = (PeriodoIndependecia) (new ArrayList<>(paisBBDD.getPeriodoIndependecias())).get(0);

            //Seteamos las Fechas del PAIS RECOGIDO DE LA BBDD con las fechas que vienen de Country DEL CONTROLADOR
            periodoIndependenciaBBDD.setAnioInicio(((PeriodoIndependecia) (new ArrayList<>(pais.getPeriodoIndependecias())).get(0)).getAnioInicio());
            periodoIndependenciaBBDD.setAnioFin(((PeriodoIndependecia) (new ArrayList<>(pais.getPeriodoIndependecias())).get(0)).getAnioFin());

            session.save(periodoIndependenciaBBDD);

            session.getTransaction().commit();
            session.close();

            //En caso de NO EXISTIR REGISTRO EN LA BBDD, se procederá a INSERTAR uno.
        } else {

            insertPeriodoIndependencia(pais);

            session.close();
        }

    }

    

    
    public void deletePeriodoIndependencia(Pais pais) {

        Session session = HibernateUtil_SessionFactory.getCurrentSession();

        session.beginTransaction();
        Query query = session.createQuery("SELECT p FROM Pais p WHERE p.nombre = :nombre");
        query.setParameter("nombre", pais.getNombre());

        Pais paisBBDD = (Pais) query.uniqueResult();

        if (paisBBDD.getPeriodoIndependecias().size() > 0) {

            //Eliminando periodo de INDEPENDENCIA que esta CONTENIDO EN EL PAIS
            session.delete((PeriodoIndependecia) (new ArrayList<>(paisBBDD.getPeriodoIndependecias())).get(0));

        }

        session.getTransaction().commit();
        session.close();
    }

}
