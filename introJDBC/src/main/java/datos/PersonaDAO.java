
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
    private static final String SQL_SELECT ="SELECT id,nombre,edad FROM tabla_1";
    
    public List<persona> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt= null;
        ResultSet rs= null;
        persona p = null;
        
        List<persona> personas = new ArrayList();
        
        try {
            conn = conexion.conectar();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                p = new persona(rs.getInt("id"), rs.getString(2), rs.getInt("edad"));
                personas.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return personas;
    }
}
