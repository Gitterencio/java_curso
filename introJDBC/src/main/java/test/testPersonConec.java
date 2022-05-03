/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.PersonaDAO;
import datos.conexion;
import introJDBC.persona;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tmatamoros
 */
public class testPersonConec {
    public static void main(String[] args) {
       
          Connection conn = null;
        try {
          conn = conexion.conectar();
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            
        PersonaDAO personaDao = new PersonaDAO(conn);
        persona personUP = new persona(2,"rafael", 20); 
        personaDao.actualizar(personUP);
        persona personIN = new persona("Mascaro", 20);
        personaDao.insertar(personIN);
        
        conn.commit();
              
        } catch (SQLException ex) {
              try {
                  conn.rollback();
              } catch (SQLException ex1) {
                  Logger.getLogger(testPersonConec.class.getName()).log(Level.SEVERE, null, ex1);
              }
            Logger.getLogger(testPersonConec.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
