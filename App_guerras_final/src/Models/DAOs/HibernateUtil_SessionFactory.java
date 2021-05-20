/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAOs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *Utilizando las LIBRERIAS de HIBERNATE 5.4.31
 * 
 * @author davidf
 *
 * DESCRIPCION:
 * Esta ES la FORMA CORRECTA para obtener la SESION de HIBERNATE, (Session Factory object)
 *
 * ###############################################################
 * ##############################################################
 * 
 *  //INICIALIZAR LA FACTORIA DE SESIONES ///
 * HibernateUtil.buildSessionFactory()
 * 
 * 
 * ///Utilizar esta forma de inicializar SESION en el DAO CORRESPONDIENTE // 
 * Session sesion = HibernateUtil.getCurrentSession();
 * 
*/

public class HibernateUtil_SessionFactory {

    private static SessionFactory sessionFactory;
    private static Session session;

    //Fabricando la sesionFactory
    public static void buildSessionFactory() {
        if (sessionFactory == null) {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();
            Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        }
    }

       
  /**
   * Abre una nueva sesión
   */
  public static void openSession() {
    session = sessionFactory.openSession();
  }
 
  /**
   * Devuelve la sesión actual
   * @return
   */
  public static Session getCurrentSession() {
 
    if ((session == null) || (!session.isOpen()))
      openSession();
    return session;
  }
 
  /**
   * Cierra Hibernate
   */
  public static void closeSessionFactory() {
 
    if (session != null)
      session.close();
 
    if (sessionFactory != null)
      sessionFactory.close();
  }
    
    

  
  
  }

/*
  ///////////////////////////////////////////////////////////////
  ////////   EJEMPLOS DE UTILIZACION DE HIBERNATE  //////////////
  //////////////////////////////////////////////////////////////

******************************************************************************
****************************************************************************
##############################################################  
     ### CRUD  
############################################################## 
  
  
  ###REGISTRANDO UN OBJETO 
 ########################################################
        UnaClase unObjeto = new UnaClase();
        . . .
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(unObjeto);
        sesion.getTransaction().commit();
        sesion.close();
   ########################################################
    


    ###MODIFICANDO UN OBJETO 
 ########################################################
        UnaClase unObjeto = new UnaClase();
        . . .
        Session sesion = HibernateUtil.getCurrentSession();

      //  OBTENER EL OBJETO DE LA BBDD (usando por ejemplo el ID)
       int id= 23; //este será el ida, podemos recogerlo como queramos, pero debemos insertar un ENTERO DESPUES en el parámetro ID
       Persona persona = session.get(Persona.class, id);

      //Seteamos los campos que queramos del objeto
        persona.setNombre("la gaviota");
        persona.setApellido("del cielo");

      //y reinsertamos el objeto
        sesion.beginTransaction();
        sesion.save(persona);
        sesion.getTransaction().commit();
        sesion.close();
   ########################################################
  
  
   ###REGISTRANDO UN OBJETO con OBJETOS RELACIONADOS (ejemplo de PEDIDO y DETALLES PEDIDO)
   ########################################################
  . . .
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(unPedido);  //este objeto, contiene un SET de "Detalles pedido" que le indicaremos que tiene que ir añadiendo
  
        for (DetallePedido detallePedido : detallesDelPedido)
                sesion.save(detallePedido);
  
        sesion.getTransaction().commit();
        sesion.close();
        . . .
    ########################################################  
  
  
    
   ### ELIMINANDO UN OBJETO 
   ########################################################
    . . .
    Session sesion = HibernateUtil.getCurrentSession();
 //  OBTENER EL OBJETO DE LA BBDD (usando por ejemplo el ID)
       int id= 23; //este será el ID, podemos recogerlo como queramos, pero debemos insertar un ENTERO DESPUES en el parámetro ID
       Persona persona = session.get(Persona.class, id);
   //Procedemos a su eliminación
    sesion.beginTransaction();
    sesion.delete(persona);
    sesion.getTransaction().commit();
    sesion.close();
    ######################################################## 
  
  
  
******************************************************************************
****************************************************************************
##############################################################  
     ### BUSQUEDAS 
############################################################## 
    
  
    ##Obtener OBJETO por el "id" 
    ########################################################
    int id = . . .;
    Cliente cliente = HibernateUtil.getCurrentSession().get(Cliente.class, id);
    ######################################################## 
    
  
  
    ##Obtener TODOS los OBJETOS de una CLASE 
    ########################################################
    Query query = HibernateUtil.getCurrentSession().createQuery("FROM Cliente");
    ArrayList<Cliente> clientes = (ArrayList<Cliente>) query.list();
    ########################################################  

  
  
  
    ######################################################## 
      ##BUSQUEDAS - AÑADIENDO CRITERIOS DE BUSQUEDA
    ########################################################
  
  
    -##Si el criterio especificado nos devuelve-- UN SOLO OBJETO:
    ########################################################
    . . .
    String nombre = . . .;
    . . .
    Query query = HibernateUtil.getCurrentSession().
    createQuery("FROM Cliente c WHERE c.nombre = :nombre");
    query.setParameter("nombre", nombre);
    Cliente cliente = (Cliente) query.uniqueResult();
    ########################################################  


  
    -##Si el criterio especificado nos puede devolver-- MÁS DE UN OBJETO: 
    ########################################################
    . . .
    String ciudad = . . .;
    . . .
    Query query = HibernateUtil.getCurrentSession().
    createQuery("FROM Cliente c WHERE c.ciudad = :ciudad");
    query.setParameter("ciudad", ciudad);
    ArrayList<Cliente> clientes = (ArrayList<Cliente>) query.list();
    ########################################################  

   
  
    ##Obtener OBJETOS DE UNA CLASE utilizando las RELACIONES entre CLASES
    ########################################################
    . . .
    Query query = HibernateUtil.getCurrentSession().
    createQuery("FROM DetallePedido dp WHERE dp.pedido.numeroPedido = :numeroPedido");
    query.setParameter("numeroPedido", numeroPedido);
    ArrayList<DetallePedido> detalles = (ArrayList<DetallePedido>) query.list();
    ########################################################  
  
    
  
    ##lanzar consultas DIRECTAMENTE en lenguaje SQL, trabajando entonces directamente con las tablas y campos de la base de datos
    ########################################################
    . . .
    SQLQuery sqlQuery = HibernateUtil.getCurrentSession().createSQLQuery("SELECT nombre, apellidos FROM clientes WHERE ciudad = :ciudad");
    query.setParameter("ciudad", ciudad);
    List resultado = query.list();
 
    for (Object objeto : resultado) {
    Map fila = (Map) objeto;
    String nombre = fila.get("nombre"); 
    String apellidos = fila.get("apellidos");
    . . .
    }
    ########################################################  
  
  


    ###CONSULTA A MULTIPLES TABLAS y recogiendo en un MAP
    ########################################################  
    . . .
    String queryHQL="SELECT new Map(p.nombrePagina, ur.id) FROM User_rol as ur
    INNER JOIN Rol_pagina as rp ON rp.id = ur.id 
    INNER JOIN Pagina as p ON p.id = rp.listaWeb_id
    WHERE ur.User_id =:param1 AND p.nombrePagina =:param2 ";

    Session session=sessionFactory.getCurrentSession();

    Query consultaHQL = session.createQuery(queryHQL);
    consultaHQL.setParameter("param1", 1);
    consultaHQL.setParameter("param2","mani.jsp");

    ArrayList<Map> respuestaHQL=(ArrayList<Map>) consultaHQL.list();
    . . .
    ########################################################  

     */

