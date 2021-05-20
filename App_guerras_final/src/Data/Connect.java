package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author grupo1
 */
public class Connect {

    private static Connection conn;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "tuyptgSniE";
    private static final String PASSWD = "GHrdqaczZx";
    private static final String URL = "jdbc:mysql://remotemysql.com:3306/tuyptgSniE?zeroDateTimeBehavior=ROUND&autoReconnect=true&serverTimezone=UTC";
    ResultSet rs;

    public Connect() throws ClassNotFoundException, SQLException {
        conn = null;
        setConnection();

    }

    public static void setConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);

            conn = DriverManager.getConnection(URL, USER, PASSWD);
//            JOptionPane.showMessageDialog(null, "Conexión correcta");
        } catch (SQLException ex) {
            conn = null;
            throw new RuntimeException("Error con la conexión");
        }

    }

    public Connection getConnection() {
        return conn;
    }

    public void desconectar() {
        conn = null;

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Conexión terminada.");

        }
    }

    public void crearConsulta(String sql) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = stmt.executeQuery(sql);
        rs.next();

    }

    public PreparedStatement crearPrepareStatement(String sql) throws SQLException{
        return this.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
    }
    
    public int actualizarBaseDatos(PreparedStatement stmt) {
        int i;
        try {
            
            i = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registros actualizados: " + i);
        } catch (SQLException e) {
            throw new RuntimeException("No se ha podido actualizar");
        }catch(Exception e){
            System.out.println("ERROR en clase connect: "+e.getMessage());
            return -1; //error
        }
        return i;

    }

    public ResultSet getRs() {
        return rs;
    }

    

}
