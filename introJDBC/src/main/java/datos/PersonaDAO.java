
package datos;

import introJDBC.persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaDAO {
    private Connection conexionTrasaccional; 
    
    private static final String SQL_SELECT ="SELECT id,nombre,edad FROM tabla_1";
     private static final String SQL_INSERT="INSERT INTO tabla_1(nombre,edad) VALUES (?,?)"; 
     private static final String SQL_UPDATE="UPDATE tabla_1 SET nombre=?,edad=? WHERE id = ?";
     private static final String SQL_DELETE="DELETE FROM tabla_1 WHERE id = ?";
   
     public PersonaDAO(){}
     public PersonaDAO(Connection conexionTransaccional){
         this.conexionTrasaccional = conexionTransaccional;
     }
     
     public List<persona> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt= null;
        ResultSet rs= null;
        persona p = null;
        
        List<persona> personas = new ArrayList();
        
        try {
            
            
            conn = this.conexionTrasaccional != null ? this.conexionTrasaccional : conexion.conectar();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                p = new persona(rs.getInt("id"), rs.getString(2), rs.getInt("edad"));
                personas.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            try {
                conexion.close(rs);
                conexion.close(stmt);
                if(this.conexionTrasaccional == null){
                conexion.close(conn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return personas;
    }
    
    public int insertar(persona person){
        Connection conn = null;
        PreparedStatement stmt= null;
        int registros =0;
        
        try {
                   conn = this.conexionTrasaccional != null ? this.conexionTrasaccional : conexion.conectar();
             stmt = conn.prepareStatement(SQL_INSERT);
             stmt.setString(1,person.getNombre());
             stmt.setInt(2, person.getEdad());
             
             registros = stmt.executeUpdate();
             
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally{
      
            try {
                conexion.close(stmt);
                  if(this.conexionTrasaccional == null){
                conexion.close(conn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
        
        
        return registros;
    }
    
     public int actualizar(persona person){
        Connection conn = null;
        PreparedStatement stmt= null;
        int registros =0;
        
        try {
                  conn = this.conexionTrasaccional != null ? this.conexionTrasaccional : conexion.conectar();
             stmt = conn.prepareStatement(SQL_UPDATE);
             stmt.setString(1,person.getNombre());
             stmt.setInt(2, person.getEdad());
             stmt.setInt(3,person.getId());
             
             registros = stmt.executeUpdate();
             
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally{
      
            try {
                conexion.close(stmt);
                 if(this.conexionTrasaccional == null){
                conexion.close(conn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
        
        
        return registros;
    }
     
      public int eliminar(persona person){
        Connection conn = null;
        PreparedStatement stmt= null;
        int registros =0;
        
        try {
             conn = this.conexionTrasaccional != null ? this.conexionTrasaccional : conexion.conectar();
             stmt = conn.prepareStatement(SQL_DELETE);
  
             stmt.setInt(1,person.getId());
             
             registros = stmt.executeUpdate();
             
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally{
      
            try {
                conexion.close(stmt);
                  if(this.conexionTrasaccional == null){
                conexion.close(conn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
        
        
        return registros;
    }
}
