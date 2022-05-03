/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.PersonaDAO;
import introJDBC.persona;
import java.util.List;

/**
 *
 * @author tmatamoros
 */
public class testPersona {
    
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        //ELIMINAR
        persona personEliminar = new persona(1);
        personaDao.eliminar(personEliminar);
        
        List<persona> personas =  personaDao.seleccionar();
        
        personas.forEach(person -> {
            System.out.println(person);
        });
        
        //insert
       /* persona person = new persona("jose", 20);
        personaDao.insertar(person);*/
       
       //actualizar
      /*  persona personUP = new persona(2,"mario", 20);
       personaDao.actualizar(personUP);*/
       
    }
    
}
