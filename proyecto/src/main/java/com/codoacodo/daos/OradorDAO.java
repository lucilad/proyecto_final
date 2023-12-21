package com.codoacodo.daos;

import static com.codoacodo.connection.AdministradorDeConexiones.*;
import com.codoacodo.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OradorDAO {

    static Logger logger = LoggerFactory.getLogger(OradorDAO.class);

    private static final String SQL_SELECT = "SELECT * FROM oradores";
    private static final String SQL_INSERT = "INSERT INTO oradores(nombre, apellido, mail,tema) VALUES (?, ?, ?,?)";
    private static final String SQL_UPDATE = "UPDATE oradores SET nombre = ?, apellido = ?, mail = ?, tema = ? WHERE ID_ORADOR = ?";
    private static final String SQL_DELETE = "DELETE FROM oradores WHERE ID_ORADOR = ?";
    private static final String SQL_OBTENER_ID = "SELECT * FROM oradores WHERE ID_ORADOR = ?";

    public List<Orador> selectOradores() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Orador> oradores = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT);
            
            while(rs.next()) {
                
                int idOrador = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String mail = rs.getString(4);
                String tema = rs.getString(5);
                Timestamp fechaAlta = rs.getTimestamp(6);

                    Orador orador = new Orador(idOrador, nombre, apellido, mail, tema, fechaAlta);
                    oradores.add(orador);
                }
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
               
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return oradores;
    }

    public int insertarOrador(Orador ora) throws SQLException , NullPointerException , ClassNotFoundException ,
                InstantiationException , IllegalAccessException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, ora.getNombre());
            stmt.setString(2, ora.getApellido());
            stmt.setString(3, ora.getMail());
            stmt.setString(4, ora.getTema());
            
            registros = stmt.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                logger.info("Entro al finally-try");
                close(stmt);
                logger.info("despues de close stmt");
                close(conn);
                logger.info("despues de close conn");
            } catch(SQLException ex) {
                ex.getMessage();
            }
        }
        return registros;
    }

    public int actualizarOrador(Orador ora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, ora.getNombre());
            stmt.setString(2, ora.getApellido());
            stmt.setString(3, ora.getMail());
            stmt.setString(4, ora.getTema());
            stmt.setLong(5, ora.getId());
            registros = stmt.executeUpdate();
        } catch (SQLException | NullPointerException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException | NullPointerException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    public int eliminarOrador(Long id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setLong(1, id);
            registros = stmt.executeUpdate();
        } catch (SQLException | NullPointerException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException | NullPointerException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    public Orador obtenerPorId(Long id) throws SQLException {
      Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        Orador oradFromDb = null;

        //Statement
        try {
                conn = getConnection();
                stmt = conn.prepareStatement(SQL_OBTENER_ID);
                stmt.setLong(1, id);
                ResultSet rs = stmt.executeQuery();
             

                if(rs.next()) {
                     
                        int idOrador = rs.getInt(1);
                        String nombre = rs.getString(2);
                        String apellido = rs.getString(3);
                        String mail = rs.getString(4);
                        String tema = rs.getString(5);
                        Timestamp fechaAlta = rs.getTimestamp(6);

                        
                        oradFromDb = new Orador(idOrador,nombre,apellido,mail,tema,fechaAlta);
                }			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return oradFromDb;
	}
 
}
