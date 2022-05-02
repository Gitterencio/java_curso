/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.primer;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author tmatamoros
 */
public class Primer {

    public static void main(String[] args) {
      /*  Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese un numero:");
        var d = sc.nextInt();
        System.out.println(d);*/
        
        String i = JOptionPane.showInputDialog(null,"ingrese un numero");
                System.out.println(i);
    }
}
