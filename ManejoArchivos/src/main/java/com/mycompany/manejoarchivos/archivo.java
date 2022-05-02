
package com.mycompany.manejoarchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class archivo {
    
    public void crearArchivo(){
        
        File archivo = new File("C:\\Users\\tmatamoros\\Desktop\\asignaciones 2022\\NuevoArchivo.txt");
        try {
            System.out.println("crear");
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribirArchivo(){
        
          File archivo = new File("C:\\Users\\tmatamoros\\Desktop\\asignaciones 2022\\NuevoArchivo.txt");
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.println("buena suerte charlie");
            salida.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void anexarInfo() throws IOException{
        System.out.println("anexar");
           File archivo = new File("C:\\Users\\tmatamoros\\Desktop\\asignaciones 2022\\NuevoArchivo.txt");
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo,true));
            salida.println("buena suerte carol");
            salida.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void leerInfo(){

    File archivo = new File("C:\\Users\\tmatamoros\\Desktop\\asignaciones 2022\\NuevoArchivo.txt");
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lector = entrada.readLine();
            while(lector != null){
                System.out.println(lector);
                lector = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(archivo.class.getName()).log(Level.SEVERE, null, ex);
        }

}

}
