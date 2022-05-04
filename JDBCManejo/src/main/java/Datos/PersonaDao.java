/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;

import Domain.PersonaDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tmatamoros
 */
public interface PersonaDao {
    
         
    public List<PersonaDTO> select() throws SQLException;
    
    public int insert(PersonaDTO persona)throws SQLException;
    
    public int update(PersonaDTO persona)throws SQLException;
    
    public int delete(PersonaDTO persona)throws SQLException;
}
