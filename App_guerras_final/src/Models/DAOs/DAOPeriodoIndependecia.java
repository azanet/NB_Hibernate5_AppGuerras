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
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author davidf
 */
public class DAOPeriodoIndependecia {

    public DAOPeriodoIndependecia() {
    }
    

       ////////////////////////////////////////////////////////7    
    public void updateIndependencePeriod(Pais country) {

        Session session = HibernateUtil_SessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM Pais p WHERE p.nombre =:nombre");
        query.setParameter("nombre", country.getNombre());
        Pais p = (Pais) query.uniqueResult();

        //Cogiendo la lista DEL OBJETO RESCATADO DE LA BBDD
         System.out.println(p.getNombre());

        if (p.getPeriodoIndependecias().size() > 0) {
            //Insertando MODIFICACIONES EN EL periodoIndependencia del PAIS existente en la BBDD
            session.beginTransaction();
            //Recogemos el PeriodoInd del PAIS recuperado de la BBDD
            PeriodoIndependecia pi = (PeriodoIndependecia) (new ArrayList<>(p.getPeriodoIndependecias())).get(0);

            //Recogiendo PeriodoInd. del PAIS que viene DEL CONTROLADOR
            PeriodoIndependecia pi_aux = (PeriodoIndependecia) (new ArrayList<>(country.getPeriodoIndependecias())).get(0);

            

                pi.setAnioInicio(pi_aux.getAnioInicio());
                pi.setAnioFin(pi_aux.getAnioFin());
                
                session.save(pi);
          

            session.getTransaction().commit();
            session.close();

        } else {
            insertIndependencePeriod(country);

            session.close();
        }

    }

    public void insertIndependencePeriod(Pais country) {

        Session session = HibernateUtil_SessionFactory.getCurrentSession();

       
        Query query = session.createQuery("FROM Pais p WHERE p.nombre = :nombre");
        query.setParameter("nombre", country.getNombre());
        //Obteniendo objeto PAIS de la BBDD, para poder insertarselo a PeriodoInd
        Pais p = (Pais) query.uniqueResult();
        
        //Obteniendo PeriodoInd. del objeto PAIS que hemos mandado DESDE EL CONTROLADOR
        PeriodoIndependecia periodoIndependencia =(PeriodoIndependecia) (new ArrayList<>(country.getPeriodoIndependecias())).get(0);
        session.beginTransaction();
        //Indertando PAIS (que es la clave primaria [PK] de nuestro objeto ==>) a PeriodoInd. 
        periodoIndependencia.setPais(p);

        session.save(periodoIndependencia);
        session.getTransaction().commit();

        session.close();
    }

    
    
    public void deleteIndependencePeriod(Pais country) {

        Session session = HibernateUtil_SessionFactory.getCurrentSession();

        session.beginTransaction();
        Query query = session.createQuery("FROM Pais p WHERE p.nombre = :nombre");
        query.setParameter("nombre", country.getNombre());
        
        Pais p = (Pais) query.uniqueResult();

        List<PeriodoIndependecia> pi = new ArrayList<>(p.getPeriodoIndependecias());
        if(pi.size()>0){
        for (PeriodoIndependecia periodoIndependecia : pi) {
            session.delete(periodoIndependecia);
            break;
        }
        }
        
        session.getTransaction().commit();
        session.close();
    }
    
    
}
