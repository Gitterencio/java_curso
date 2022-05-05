/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletCodEstado")
public class ServletCodEstado3 extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String UsuarioOk = "des";
        String PassOk = "123";

        String us = req.getParameter("usuario");
        String pass = req.getParameter("password");

        PrintWriter out = resp.getWriter();
        if (UsuarioOk.equals(us) && PassOk.equals(pass)) {
            out.print("<h1> Datos Correctos</h1>");
            out.print("<br/><h2>Usuario: " + us + "</h2>");
            out.print("<br/><h2>Password: " + pass + "</h2>");
        }else{
resp.sendError(resp.SC_UNAUTHORIZED,"las credenciales son incorrectas");
}

        out.close();
    }

}
