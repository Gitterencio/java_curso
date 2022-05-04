/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Datos.Conexion;
import Datos.PersonaDao;
import Datos.PersonaDaoJDBC;
import Domain.PersonaDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tmatamoros
 */
public class ManejoPersonas {
    
       public static void main(String[] args) throws SQLException {

           
     Connection conn= null;
    
           try {
               conn = Conexion.conectar();
               if(conn.getAutoCommit()){
         conn.setAutoCommit(false);
                }
      
               PersonaDao personaDAO = new PersonaDaoJDBC(conn);
               List<PersonaDTO> personas = personaDAO.select();
               
               personas.forEach(person ->{
                   System.out.println(person);
               });
               
               conn.commit();
           } catch (SQLException ex) {
               
               conn.rollback();
               Logger.getLogger(ManejoPersonas.class.getName()).log(Level.SEVERE, null, ex);
           }
     
     
    

    }
}
