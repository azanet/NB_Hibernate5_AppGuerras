package Models.Contender;

import Data.Connect;
import CONVERT_a_POJOS.AllyDTO;
import CONVERT_a_POJOS.ContenderDTO;
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
    public DefaultComboBoxModel fillComboBoxModelWar() throws SQLException {
	
        DefaultComboBoxModel comboBoxModelWar = new DefaultComboBoxModel();      
        comboBoxModelWar.addElement("Seleccione una guerra...");
        
        //Abriendo sesion, creando QUERY de la consulta y cargando el ComboBox con la lista recibida al realizar la consulta
        Session session = HibernateUtil_SessionFactory.getCurrentSession(); 
        Query query=session.createQuery("Select g.nombre from Guerra g order by g.nombre");        
      
        
        comboBoxModelWar.addAll(query.list());
        
        session.close();
        return comboBoxModelWar;	
    }


    public DefaultComboBoxModel fillComboBoxContender(String nombre) throws SQLException {

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

    
    
     
    
    public DefaultComboBoxModel fillComboBoxCountry(String nombre) throws SQLException {
    
        
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

    
    
    public DefaultComboBoxModel fillAllCountriesCombobox() throws SQLException {

        DefaultComboBoxModel comboBoxModelCountries = new DefaultComboBoxModel();
        comboBoxModelCountries.addElement("Seleccione un País...");
        
        Session session = HibernateUtil_SessionFactory.getCurrentSession(); 
        Query query=session.createQuery("Select p.nombre from Pais p order by p.nombre");        
      
        comboBoxModelCountries.addAll(query.list());
        
        session.close();
        
        return comboBoxModelCountries;     
    }

    
    
    
       ////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    
    
    //MÉTODOS CRUD
    //INSERT CONTENDIENTE
    public int select_idguerra(String war) throws SQLException {
	int idwar = 0;
	sql = "SELECT id_guerra FROM guerra WHERE nombre = ?";
	sentencia = conn.crearPrepareStatement(sql);
	sentencia.setString(1, war);
	rs = sentencia.executeQuery();
	while (rs.next()) {
	    idwar = rs.getInt("id_guerra");
	}
	return idwar;
    }

    public void insert(ContenderDTO contender) throws SQLException {
//	int idwar = select_idguerra(war);
	sql = "INSERT INTO contendiente (ganador,nombre,id_guerra) VALUES (?,?,?)";
	sentencia = conn.crearPrepareStatement(sql);
	sentencia.setInt(1, contender.getGanador());
	sentencia.setString(2, contender.getNombre());
	sentencia.setInt(3, contender.getId_guerra());
	conn.actualizarBaseDatos(sentencia);
    }

    //DELETE CONTENDIENTE
    public void delete(ContenderDTO contenderDTO) throws SQLException {
	sql = "DELETE FROM contendiente WHERE nombre = ?";
	sentencia = conn.crearPrepareStatement(sql);
	sentencia.setString(1, contenderDTO.getNombre());
	conn.actualizarBaseDatos(sentencia);
    }

    //UPDATE CONTENDIENTE      
    public void update(ContenderDTO contender, String oldName) throws SQLException {
	sql = "UPDATE contendiente SET nombre = ?, ganador = ? WHERE nombre = ?";

	sentencia = conn.crearPrepareStatement(sql);
	sentencia.setString(1, contender.getNombre());
	sentencia.setInt(2, contender.getGanador());
	sentencia.setString(3, oldName);

	conn.actualizarBaseDatos(sentencia);
    }

    //PAISES ALIADOS A LOS CONTENDIENTES
    //OBTENER ID_PAIS
    public int select_idPais(String pais) throws SQLException {
	int idPais = 0;
	sql = "SELECT id_pais FROM pais WHERE nombre = ?";
	sentencia = conn.crearPrepareStatement(sql);
	sentencia.setString(1, pais);
	rs = sentencia.executeQuery();
	while (rs.next()) {
	    idPais = rs.getInt("id_pais");
	}
	return idPais;
    }

    //OBTENER ID_CONTENDIENTE
    public int select_idContendiente(String contendiente) throws SQLException {
	int idContendiente = 0;
	sql = "SELECT id_contendiente FROM contendiente WHERE nombre = ?";
	sentencia = conn.crearPrepareStatement(sql);
	sentencia.setString(1, contendiente);
	rs = sentencia.executeQuery();
	while (rs.next()) {
	    idContendiente = rs.getInt("id_contendiente");
	}
	return idContendiente;
    }

    //Obtener fechas
    public String select_BeginDate(String nombreContendiente, String nombrePais) throws SQLException {
	String beginDate = "";
	int idContendiente = select_idContendiente(nombreContendiente);
	int idpais = select_idPais(nombrePais);
	sql = "SELECT fecha_union from union_bandos where id_contendiente=? and id_pais=?";
	sentencia = conn.crearPrepareStatement(sql);
	sentencia.setInt(1, idContendiente);
	sentencia.setInt(2, idpais);
	rs = sentencia.executeQuery();
	while (rs.next()) {
	    beginDate = rs.getString("fecha_union");
	}

	return beginDate;

    }

    public String select_EndDate(String nombreContendiente, String nombrePais) throws SQLException {
	String endDate = "";
	int idContendiente = select_idContendiente(nombreContendiente);
	int idpais = select_idPais(nombrePais);
	sql = "SELECT fecha_abandono from union_bandos where id_contendiente=? and id_pais=?";
	sentencia = conn.crearPrepareStatement(sql);
	sentencia.setInt(1, idContendiente);
	sentencia.setInt(2, idpais);
	rs = sentencia.executeQuery();
	while (rs.next()) {
	    endDate = rs.getString("fecha_abandono");
	}

	return endDate;

    }

    //Obtener ganador
    public int select_Winner(String contendiente) throws SQLException {
	int winner = 0;
	sql = "SELECT ganador FROM contendiente WHERE nombre = ?";
	sentencia = conn.crearPrepareStatement(sql);
	sentencia.setString(1, contendiente);
	rs = sentencia.executeQuery();
	while (rs.next()) {
	    winner = rs.getInt("ganador");
	}
	return winner;
    }

    //INSERT PAIS
    public void insert_country(AllyDTO allyDTO) throws SQLException {
	sql = "INSERT INTO union_bandos (id_contendiente, id_pais, fecha_union, fecha_abandono) VALUES (?,?,?,?)";

	sentencia = conn.crearPrepareStatement(sql);
	sentencia.setInt(1, allyDTO.getId_contendiente());
	sentencia.setInt(2, allyDTO.getId_pais());
	sentencia.setString(3, allyDTO.getFecha_union());
	sentencia.setString(4, allyDTO.getFecha_abandono());
	conn.actualizarBaseDatos(sentencia);
    }

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
