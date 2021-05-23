/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAOs;

import Models.POJOs.Contendiente;
import Models.POJOs.Pais;
import Models.POJOs.UnionBandos;
import SessionFactory.HibernateUtil_SessionFactory;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author davidf
 */
public class DAOComboBoxesFill {

    public DAOComboBoxesFill() {
    }
    

    //Rellenar ComboBOX de GUERRAS
    public DefaultComboBoxModel fillComboBoxModelWar() {

        DefaultComboBoxModel comboBoxModelWar = new DefaultComboBoxModel();
        comboBoxModelWar.addElement("Seleccione una guerra...");

        //Abriendo sesion, creando QUERY de la consulta y cargando el ComboBox con la lista recibida al realizar la consulta
        Session session = HibernateUtil_SessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT g.nombre FROM Guerra g ORDER BY g.nombre");

        comboBoxModelWar.addAll(query.list()); //INSERTANDO la lista entera recibida en el combobox

        session.close();
        return comboBoxModelWar;
    }

    
    //Rellenar ComboBOX de CONTENDIENTES de una GUERRA CONCRETA
    public DefaultComboBoxModel fillComboBoxContender(String nombre) {

        DefaultComboBoxModel comboBoxModelContender = new DefaultComboBoxModel();
        comboBoxModelContender.addElement("Seleccione un Contendiente...");

        //Abriendo sesion, creando QUERY de la consulta y cargando el ComboBox con la lista recibida al realizar la consulta
        Session session = HibernateUtil_SessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT c FROM Contendiente c WHERE c.guerra=(SELECT g FROM Guerra g WHERE g.nombre = :nombre) ORDER BY c.nombre");
        query.setParameter("nombre", nombre);

        //Recuperando LISTA de CONTENDIENTES
        List<Contendiente> contendientes = new ArrayList<>(query.list());

        for (Contendiente contendiente : contendientes) {
            comboBoxModelContender.addElement(contendiente.getNombre());//Insertando NOMBRE de CONTENDIENTE en el combobox
        }
        session.close();

        return comboBoxModelContender;
    }

    
    //Rellenar ComboBOX de PAISES que PERTENECEN a UN CONTENDIENTE 
    public DefaultComboBoxModel fillComboBoxCountry(String nombre) {

        DefaultComboBoxModel comboBoxModelCountry = new DefaultComboBoxModel();
        comboBoxModelCountry.addElement("Seleccione un PAÍS Contendiente...");

        //Abriendo sesion, creando QUERY de la consulta y cargando el ComboBox con la lista recibida al realizar la consulta
        Session session = HibernateUtil_SessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT u FROM UnionBandos u WHERE u.contendiente=(SELECT c FROM Contendiente c WHERE c.nombre = :nombre)");
        query.setParameter("nombre", nombre);
        
        //Recuperando LISTA de UNION BANDOS, que tienen el CONTENDIENTE en COMUN 
        List<UnionBandos> unionBandos = new ArrayList<>(query.list());
 
        //RECORRIENDO LA LISTA e INSERTANDO el NOMBRE de cada PAIS incluido en el OBJETO UNION BANDOS recuperado al COMBOBOX.        
        for (UnionBandos unionBando : unionBandos) {
            Pais pais = unionBando.getPais();
            comboBoxModelCountry.addElement(pais.getNombre()); //Insertando nombre de PAIS en el COMBOBOX
        }
        session.close();

        return comboBoxModelCountry;
    }
    
    
   //Rellenar ComboBOX de PAISES con TODOS LOS PAISES EXISTENTES
    public DefaultComboBoxModel fillAllCountriesCombobox() {

        DefaultComboBoxModel comboBoxModelCountries = new DefaultComboBoxModel();
        comboBoxModelCountries.addElement("Seleccione un País...");

        Session session = HibernateUtil_SessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT p.nombre FROM Pais p ORDER BY p.nombre");

        comboBoxModelCountries.addAll(query.list()); //Insertando la LISTA en el COMBOBOX
        session.close();

        return comboBoxModelCountries;
    }
    
    

}
