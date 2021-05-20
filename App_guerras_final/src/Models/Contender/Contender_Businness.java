package Models.Contender;

import Data.Connect;
import CONVERT_a_POJOS.AllyDTO;
import Models.HibernateUtil_SessionFactory;
import Models.POJOs.Contendiente;
import Models.POJOs.Guerra;
import Models.POJOs.Pais;
import Models.POJOs.UnionBandos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Sonia Castro (soniacastromartel@gmail.com)
 */
public class Contender_Businness {

    Connect conn;
    String sql;
    ResultSet rs = null;
    AllyDTO allyDTO;
//    ContenderDTO contender;
    Connection conexion;
    PreparedStatement sentencia;
    
    
    
    
    
    

    public Contender_Businness() throws ClassNotFoundException, SQLException {
	if (conn == null) {
	    conn = new Connect();

	}
    }
    
    
    
//
//    public AllyDTO getAllyDTO() {
//	try {
//	    allyDTO = new AllyDTO();
//	    allyDTO.setId_contendiente(rs.getInt("id_continente"));
//	    allyDTO.setId_pais(rs.getInt("id_pais"));
//	    allyDTO.setFecha_union(rs.getString("fecha_union"));
//	    allyDTO.setFecha_abandono(rs.getString("fecha_abandono"));
//	} catch (SQLException e) {
//	}
//	return allyDTO;
//
//    }


    //buscart objeto
//    public void queries() throws SQLException {
//	conn.crearConsulta("select * from union_bandos");
//	rs = conn.getRs();
//    }

    
        
//    //Método que devuelve un arraylist con todos los objetos de las tablas
//    public ArrayList<Object> fillAllCombobox() throws SQLException {
//	ArrayList<Object> list = new ArrayList<>();
//	sql = "select * from guerra g, contendiente c, union_bandos u, pais p where g.id_guerra= c.id_guerra and c.id_contendiente= u.id_contendiente and u.id_pais= p.id_pais";
//	sentencia = conn.crearPrepareStatement(sql);
//	rs = sentencia.executeQuery();
//
//	while (rs.next()) {
////	    list.add(rs.getObject("nombre"));
//
//	}
//
//	return list;
//    }
    
    
    
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
            System.out.println(contendiente.getNombre());
            comboBoxModelContender.addElement(contendiente.getNombre());
        }
        }
        session.close();
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

    

    public void insert(Contendiente contender, String nombreGuerra)  {

        Session session = HibernateUtil_SessionFactory.getCurrentSession();
            Query query=session.createQuery("SELECT g From Guerra g WHERE g.nombre = :nombre");
            query.setParameter("nombre", nombreGuerra);
            
            //Recuperando Guerra
            Guerra guerra= (Guerra) query.uniqueResult();
            contender.setGuerra(guerra);
            
            session.beginTransaction();
            session.save(contender);
            session.getTransaction().commit();
            session.close();

    }
 
    

    //UPDATE CONTENDIENTE      
    public void update(Contendiente contendiente, String oldName)  {

       Session session = HibernateUtil_SessionFactory.getCurrentSession();
           
           Query query=session.createQuery("SELECT c From Contendiente c WHERE c.nombre = :nombre");        
           query.setParameter("nombre", oldName);
                    
           //Recuperando Guerra
           Contendiente contendiente_hib= (Contendiente) query.uniqueResult();
           
          
           contendiente_hib.setGanador(contendiente.getGanador());
           contendiente_hib.setNombre(contendiente.getNombre());
                 
           session.beginTransaction();
           session.save(contendiente_hib);
           session.getTransaction().commit();
           session.close();
 
    }

    
    
        //Obtener ganador
    public int select_Winner(String nombreContendiente) throws SQLException {
	
        int winner = 0;
           Session session = HibernateUtil_SessionFactory.getCurrentSession();
           
           Query query=session.createQuery("SELECT c From Contendiente c WHERE c.nombre = :nombre");        
           query.setParameter("nombre", nombreContendiente);
                    
           //Recuperando Guerra
           Contendiente contendiente_hib= (Contendiente) query.uniqueResult();
           winner = contendiente_hib.getGanador();
           session.close();
        
	return winner;
    }

    




    //DELETE CONTENDIENTE
    public void delete(Contendiente contendiente) throws SQLException {

        String nombreContendiente= contendiente.getNombre();
         Session session = HibernateUtil_SessionFactory.getCurrentSession();
           
           Query query=session.createQuery("SELECT c From Contendiente c WHERE c.nombre = :nombre");        
           query.setParameter("nombre", nombreContendiente);
                    
           //Recuperando Guerra
           Contendiente contendiente_hib= (Contendiente) query.uniqueResult();
           session.beginTransaction();
           session.delete(contendiente_hib);
           session.getTransaction().commit();
           session.close();
        
    }



    
    
//    //PAISES ALIADOS A LOS CONTENDIENTES
//    //OBTENER ID_PAIS
//    public int select_idPais(String pais) throws SQLException {
//	int idPais = 0;
//	sql = "SELECT id_pais FROM pais WHERE nombre = ?";
//	sentencia = conn.crearPrepareStatement(sql);
//	sentencia.setString(1, pais);
//	rs = sentencia.executeQuery();
//	while (rs.next()) {
//	    idPais = rs.getInt("id_pais");
//	}
//	return idPais;
//    }

//    //OBTENER ID_CONTENDIENTE
//    public int select_idContendiente(String contendiente) throws SQLException {
//	int idContendiente = 0;
//	sql = "SELECT id_contendiente FROM contendiente WHERE nombre = ?";
//	sentencia = conn.crearPrepareStatement(sql);
//	sentencia.setString(1, contendiente);
//	rs = sentencia.executeQuery();
//	while (rs.next()) {
//	    idContendiente = rs.getInt("id_contendiente");
//	}
//	return idContendiente;
//    }

    
    
    
    
    //INSERT PAIS
    public void insert_country(UnionBandos unionBandos,String nContendiente, String nPais) throws SQLException {
   
        //Crear metodos para recuperar LOS objetos por el nombre y setearselos al UNION BANDOS
        
        
        
            Session session = HibernateUtil_SessionFactory.getCurrentSession();
            Query query=session.createQuery("SELECT p From Pais p WHERE p.nombre = :nombre");
            query.setParameter("nombre", nPais);
            
            Pais pais= (Pais) query.uniqueResult();
            
            query=session.createQuery("SELECT c From Contendiente c WHERE c.nombre = :nombre");
            query.setParameter("nombre", nContendiente);
            
            Contendiente contendiente = (Contendiente) query.uniqueResult();
            
            //Recuperando Guerra
            unionBandos.setPais(pais);
            unionBandos.setContendiente(contendiente);
            
            session.beginTransaction();
            session.save(unionBandos);
            session.getTransaction().commit();
            session.close();
    }
    
    
    
    
    
    
        
        

  
    //Obtener fechas
    public String select_BeginDate(String nombreContendiente, String nombrePais) throws SQLException {
       
	String beginDate = "";

        Session session = HibernateUtil_SessionFactory.getCurrentSession();
            //REALIZANDO CONSULTA con 2 SUBCONSULTAS en las que le pasamos OBJETOS para COMPARAR y obtener de una los objetos necesatios, para determinar que tabla UNION es la nuestra
           Query query=session.createQuery("SELECT u From UnionBandos u WHERE u.contendiente = (SELECT c From Contendiente c WHERE c.nombre = :contendiente) and u.pais = (SELECT p From Pais p WHERE p.nombre = :pais)");
            query.setParameter("contendiente", nombreContendiente);
            query.setParameter("pais", nombrePais);

            UnionBandos unionB = (UnionBandos)query.uniqueResult();
//            
//            System.out.println(unionB.getIdUnionBandos());
//            System.out.println(unionB.getFechaAbandono());
//            System.out.println(unionB.getFechaUnion());
//            
            beginDate = unionB.getFechaUnion();

            session.close();
     
        return beginDate;   
    }

    
    
    
    
    public String select_EndDate(String nombreContendiente, String nombrePais) throws SQLException {
	String endDate = "";
        Session session = HibernateUtil_SessionFactory.getCurrentSession();

           Query query=session.createQuery("SELECT u From UnionBandos u WHERE u.contendiente = (SELECT c From Contendiente c WHERE c.nombre = :contendiente) and u.pais = (SELECT p From Pais p WHERE p.nombre = :pais)");
            query.setParameter("contendiente", nombreContendiente);
            query.setParameter("pais", nombrePais);

            UnionBandos unionB = (UnionBandos)query.uniqueResult();
//            
//            System.out.println(unionB.getIdUnionBandos());
//            System.out.println(unionB.getFechaAbandono());
//            System.out.println(unionB.getFechaUnion());
//            
            endDate = unionB.getFechaAbandono();

            session.close();
	return endDate;

    }

    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
//######################################################################################################################//     
//################### - PARTE INFERIOR - FALTA POR PREPARAR - ##########################################################//     
//######################################################################################################################//   
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
  
    
    
    
    
    


    //ELIMINAR PAIS
    public void delete_country(AllyDTO allyDTO) throws SQLException {
	sql = "DELETE FROM union_bandos WHERE id_contendiente = ? AND id_pais = ?";

	sentencia = conn.crearPrepareStatement(sql);
	sentencia.setInt(1, allyDTO.getId_contendiente());
	sentencia.setInt(2, allyDTO.getId_pais());
	conn.actualizarBaseDatos(sentencia);
    }

    //ACTUALIZAS PAIS
    public void update_country(AllyDTO allyDTO) throws SQLException {
	sql = "UPDATE union_bandos SET fecha_union = ?, fecha_abandono = ? WHERE id_contendiente = ? AND id_pais = ?";

	sentencia = conn.crearPrepareStatement(sql);
	sentencia.setString(1, allyDTO.getFecha_union());
	sentencia.setString(2, allyDTO.getFecha_abandono());
	sentencia.setInt(3, allyDTO.getId_contendiente());
	sentencia.setInt(4, allyDTO.getId_pais());

	conn.actualizarBaseDatos(sentencia);
    }

    

}
