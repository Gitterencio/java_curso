/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloques_inicializacion;

/**
 *
 * @author tmatamoros
 */
public class iniciar {
    static{
        System.out.println("estatico");
    }
    
    {
        System.out.println("no estatico");
    }
    public iniciar() {
        
        System.out.println("constructor");
    }
    
   
}
