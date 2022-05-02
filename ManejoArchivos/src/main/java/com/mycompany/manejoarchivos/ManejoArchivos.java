

package com.mycompany.manejoarchivos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ManejoArchivos {

    public static void main(String[] args) {
        archivo a = new archivo();
        //a.crearArchivo();
        a.escribirArchivo();
        try {
            a.anexarInfo();
        } catch (IOException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        a.leerInfo();
    }
}
