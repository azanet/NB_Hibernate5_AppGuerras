/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAOs;

import Models.POJOs.Contendiente;
import Models.POJOs.Pais;
import Models.POJOs.UnionBandos;
import SessionFactory.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author davidf
 */
public class DAOUnionBandos {

    //PONER AQUI LOS METODOS DE UNION BANDOS QUE ESTAN EN CONTENDIENTES+
    public DAOUnionBandos() {
    }

    
    
    ////////////////CRUD DE - UNION BANDOS///////////////////////////////////////////////  
    
    //Obtener UnionBandos
    public UnionBandos selectUnionBandos(String nombreContendiente, String nombrePais) {

        Session session = HibernateUtil.getCurrentSession();
        //REALIZANDO CONSULTA con 2 SUBCONSULTAS en las que le pasamos OBJETOS para COMPARAR y obtener de una los objetos necesatios, para determinar que tabla UNION es la nuestra
        Query query = session.createQuery("SELECT u FROM UnionBandos u WHERE u.contendiente = (SELECT c FROM Contendiente c WHERE c.nombre = :contendiente) AND u.pais = (SELECT p FROM Pais p WHERE p.nombre = :pais)");
        query.setParameter("contendiente", nombreContendiente);
        query.setParameter("pais", nombrePais);

        UnionBandos unionBandosBBDD = (UnionBandos) query.uniqueResult();

        session.close();

        return unionBandosBBDD;
    }

    
    
    //INSERT UnionBandos
    public void insertUnionBandos(UnionBandos unionBandos, String nombreContendiente, String nombrePais) {
        //Crear metodos para recuperar LOS objetos por el nombre y setearselos al UNION BANDOS

        Session session = HibernateUtil.getCurrentSession();
        Query query = session.createQuery("SELECT p FROM Pais p WHERE p.nombre = :nombre");
        query.setParameter("nombre", nombrePais);

        Pais paisBBDD = (Pais) query.uniqueResult();

        query = session.createQuery("SELECT c FROM Contendiente c WHERE c.nombre = :nombre");
        query.setParameter("nombre", nombreContendiente);

        Contendiente contendienteBBDD = (Contendiente) query.uniqueResult();

        //Recuperando Guerra
        unionBandos.setPais(paisBBDD);
        unionBandos.setContendiente(contendienteBBDD);

        session.beginTransaction();
        session.save(unionBandos);
        session.getTransaction().commit();
        session.close();
    }

    
        
    
    //ACTUALIZAR UnionBandos
    public void updateUnionBandos(UnionBandos unionBandos, String nombreContendiente, String nombrePais) {

        Session session = HibernateUtil.getCurrentSession();

        Query query = session.createQuery("SELECT u FROM UnionBandos u WHERE u.contendiente = (SELECT c FROM Contendiente c WHERE c.nombre = :contendiente) AND u.pais = (SELECT p FROM Pais p WHERE p.nombre = :pais)");
        query.setParameter("contendiente", nombreContendiente);
        query.setParameter("pais", nombrePais);

        UnionBandos unionBandosBBDD = (UnionBandos) query.uniqueResult();

        unionBandosBBDD.setFechaUnion(unionBandos.getFechaUnion());
        unionBandosBBDD.setFechaAbandono(unionBandos.getFechaAbandono());

        session.beginTransaction();
        session.save(unionBandosBBDD);
        session.getTransaction().commit();
        session.close();

    }
    
    
    //ELIMINAR UnionBandos
    public void deleteUnionBandos(String nombreContendiente, String nombrePais) {

        Session session = HibernateUtil.getCurrentSession();

        Query query = session.createQuery("SELECT u FROM UnionBandos u WHERE u.contendiente = (SELECT c FROM Contendiente c WHERE c.nombre = :contendiente) AND u.pais = (SELECT p FROM Pais p WHERE p.nombre = :pais)");
        query.setParameter("contendiente", nombreContendiente);
        query.setParameter("pais", nombrePais);

        UnionBandos unionBandosBBDD = (UnionBandos) query.uniqueResult();

        session.beginTransaction();
        session.delete(unionBandosBBDD);
        session.getTransaction().commit();
        session.close();

    }



}
