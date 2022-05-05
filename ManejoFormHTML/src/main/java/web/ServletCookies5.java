/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tmatamoros
 */
@WebServlet(name = "ServletCookies", urlPatterns = {"/ServletCookies"})
public class ServletCookies5 extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//Para usuario que ingresar por primera vez
        boolean nuevoUs = true;
//contador de visitas
        int cont = 0;

//arreglo de cookies
        Cookie cookies[] = req.getCookies();

//buscamos si ya existe cookie creado
//visitante recurrente
        if (cookies != null) {

            for (Cookie c : cookies) {
                if (c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")) {

                    //si ya existe la cookie es un usuario recurrente
                    nuevoUs = false;

                }

                if (c.getName().equals("contadorVisitas")) {
                    cont = Integer.parseInt(c.getValue());

                }
            }

        }

//incrementar cont de visistas
        cont++;
//agregar cookie a la respuesta
        Cookie contadorVisitas = new Cookie("contadorVisitas", Integer.toString(cont));
//cookie tendra duracion de 1hora -3600 seg
        contadorVisitas.setMaxAge(3600);
//agregar a la respuesta
        resp.addCookie(contadorVisitas);

        String msj = null;
        if (nuevoUs) {
            Cookie visitanteCookie = new Cookie("visitanteRecurrente", "si");
            resp.addCookie(visitanteCookie);
            msj = "Gracias por visitar, por primera vez";
        } else {

            msj = "Gracias por visitar nuevamente este sitio";
        }

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCookies5</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Mensaje: " + msj + "</h1>");
            out.println("<h1>Num Visitas: " + cont + "</h1>");
            out.println("</body>");
            out.println("</html>");

            out.close();
        }
    }

}
