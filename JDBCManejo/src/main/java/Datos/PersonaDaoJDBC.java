
package Datos;


import Domain.PersonaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaDaoJDBC implements PersonaDao{
    
    private Connection conexionTrasaccional; 
    
    private static final String SQL_SELECT ="SELECT id,nombre,edad FROM tabla_1";
     private static final String SQL_INSERT="INSERT INTO tabla_1(nombre,edad) VALUES (?,?)"; 
     private static final String SQL_UPDATE="UPDATE tabla_1 SET nombre=?,edad=? WHERE id = ?";
     private static final String SQL_DELETE="DELETE FROM tabla_1 WHERE id = ?";
   
     public PersonaDaoJDBC(){}
     public PersonaDaoJDBC(Connection conexionTransaccional){
         this.conexionTrasaccional = conexionTransaccional;
     }
     
    @Override
     public List<PersonaDTO> select(){
        Connection conn = null;
        PreparedStatement stmt= null;
        ResultSet rs= null;
        PersonaDTO p = null;
        
        List<PersonaDTO> personas = new ArrayList();
        
        try {
            
            
            conn = this.conexionTrasaccional != null ? this.conexionTrasaccional : Conexion.conectar();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                p = new PersonaDTO(rs.getInt("id"), rs.getString(2), rs.getInt("edad"));
                personas.add(p);
            }
            
        } catch (SQLException ex) {
          //  Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                if(this.conexionTrasaccional == null){
                Conexion.close(conn);
                }
            } catch (SQLException ex) {
               // Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return personas;
    }
    
    @Override
    public int insert(PersonaDTO person){
        Connection conn = null;
        PreparedStatement stmt= null;
        int registros =0;
        
        try {
                   conn = this.conexionTrasaccional != null ? this.conexionTrasaccional : Conexion.conectar();
             stmt = conn.prepareStatement(SQL_INSERT);
             stmt.setString(1,person.getNombre());
             stmt.setInt(2, person.getEdad());
             
             registros = stmt.executeUpdate();
             
        } catch (SQLException ex) {
           // Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally{
      
            try {
                Conexion.close(stmt);
                  if(this.conexionTrasaccional == null){
                Conexion.close(conn);
                }
            } catch (SQLException ex) {
             //   Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
        
        
        return registros;
    }
    
    @Override
     public int update(PersonaDTO person){
        Connection conn = null;
        PreparedStatement stmt= null;
        int registros =0;
        
        try {
                  conn = this.conexionTrasaccional != null ? this.conexionTrasaccional : Conexion.conectar();
             stmt = conn.prepareStatement(SQL_UPDATE);
             stmt.setString(1,person.getNombre());
             stmt.setInt(2, person.getEdad());
             stmt.setInt(3,person.getId());
             
             registros = stmt.executeUpdate();
             
        } catch (SQLException ex) {
         // Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally{
      
            try {
                Conexion.close(stmt);
                 if(this.conexionTrasaccional == null){
                Conexion.close(conn);
                }
            } catch (SQLException ex) {
               // Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
        
        
        return registros;
    }
     
    @Override
      public int delete(PersonaDTO person){
        Connection conn = null;
        PreparedStatement stmt= null;
        int registros =0;
        
        try {
             conn = this.conexionTrasaccional != null ? this.conexionTrasaccional : Conexion.conectar();
             stmt = conn.prepareStatement(SQL_DELETE);
  
             stmt.setInt(1,person.getId());
             
             registros = stmt.executeUpdate();
             
        } catch (SQLException ex) {
          //  Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally{
      
            try {
                Conexion.close(stmt);
                  if(this.conexionTrasaccional == null){
                Conexion.close(conn);
                }
            } catch (SQLException ex) {
                //Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
        
        
        return registros;
    }
}
