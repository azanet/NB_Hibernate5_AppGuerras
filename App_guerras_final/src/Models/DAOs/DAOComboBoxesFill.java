/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAOs;

import Models.POJOs.Contendiente;
import Models.POJOs.Guerra;
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
    
    
    
    
    
    //DEFAULTCOMBOBOXMODELS
    public DefaultComboBoxModel fillComboBoxModelWar() {
	
        DefaultComboBoxModel comboBoxModelWar = new DefaultComboBoxModel();      
        comboBoxModelWar.addElement("Seleccione una guerra...");
        
        //Abriendo sesion, creando QUERY de la consulta y cargando el ComboBox con la lista recibida al realizar la consulta
        Session session = HibernateUtil_SessionFactory.getCurrentSession(); 
        Query query=session.createQuery("Select g.nombre from Guerra g order by g.nombre");        
             
        comboBoxModelWar.addAll(query.list());
        
        session.close();
        return comboBoxModelWar;	
    }


    public DefaultComboBoxModel fillComboBoxContender(String nombre)  {

        DefaultComboBoxModel comboBoxModelContender = new DefaultComboBoxModel();      
        comboBoxModelContender.addElement("Seleccione un Contendiente...");
        
        //Abriendo sesion, creando QUERY de la consulta y cargando el ComboBox con la lista recibida al realizar la consulta
        Session session = HibernateUtil_SessionFactory.getCurrentSession(); 
        Query query=session.createQuery("SELECT g From Guerra g WHERE g.nombre = :nombre");        
        query.setParameter("nombre", nombre);
        
        //Recuperando Guerra
        Guerra guerra= (Guerra) query.uniqueResult();
        
        if(guerra != null){
        //Obteniendo Los contendientes y agregandolos al comboBox
        List<Contendiente> contendientes = new ArrayList<>(guerra.getContendientes());
        
        for (Contendiente contendiente : contendientes) {
            comboBoxModelContender.addElement(contendiente.getNombre());
        }
        }
        session.close();
       ///////////////////////////////////////////////////////////////////////////7 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        return comboBoxModelContender;
    }

    
    
     
    
    public DefaultComboBoxModel fillComboBoxCountry(String nombre) {
     
        DefaultComboBoxModel comboBoxModelCountry = new DefaultComboBoxModel();
	        
        comboBoxModelCountry.addElement("Seleccione un PAÍS Contendiente...");
        
        //Abriendo sesion, creando QUERY de la consulta y cargando el ComboBox con la lista recibida al realizar la consulta
        Session session = HibernateUtil_SessionFactory.getCurrentSession(); 
        Query query=session.createQuery("SELECT c From Contendiente c WHERE c.nombre = :nombre");        
        query.setParameter("nombre", nombre);
        
        //Recuperando Guerra
        Contendiente contendiente= (Contendiente) query.uniqueResult();
        
        //Obteniendo los Paises contendientes y agregandolos al comboBox
        if (contendiente != null){
        List<UnionBandos> unionBandos = new ArrayList<>(contendiente.getUnionBandoses());
        
        
            for (UnionBandos unionBando : unionBandos) {
                Pais pais= unionBando.getPais();
                comboBoxModelCountry.addElement(pais.getNombre());
            }
        }
        
        session.close(); 
        
        return comboBoxModelCountry;    
    }

    
    
    public DefaultComboBoxModel fillAllCountriesCombobox() {

        DefaultComboBoxModel comboBoxModelCountries = new DefaultComboBoxModel();
        comboBoxModelCountries.addElement("Seleccione un País...");
        
        Session session = HibernateUtil_SessionFactory.getCurrentSession();
        Query query=session.createQuery("Select p.nombre from Pais p order by p.nombre");
            
        comboBoxModelCountries.addAll(query.list());
        session.close();
        
        return comboBoxModelCountries;     
    }

    
    
    
}
