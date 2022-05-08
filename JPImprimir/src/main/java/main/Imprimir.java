/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Imprimir {

    public Imprimir() throws JRException, SQLException, ClassNotFoundException{
    
    
            Connection conn = Conexion.conectar();
       
        JasperReport jrp = null;
        
        jrp = (JasperReport) JRLoader.loadObjectFromFile("src\\main\\java\\Reportes\\report1.jasper");
        
        JasperPrint jprint = JasperFillManager.fillReport("src\\main\\java\\Reportes\\report1.jasper",null,conn);
        
        JasperViewer view = new JasperViewer(jprint,false);
        view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        view.setVisible(true);
        
    }
public static void main(String[] args) throws ClassNotFoundException{

        try {
            Imprimir ip = new Imprimir();
        } catch (JRException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        }
}

}
