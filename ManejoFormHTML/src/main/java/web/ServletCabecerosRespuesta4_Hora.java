package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletCRHora")
public class ServletCabecerosRespuesta4_Hora extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
resp.setHeader("refresh", "1");
Date fecha = new Date();
SimpleDateFormat format = new SimpleDateFormat("'Hora Actual' HH:mm:ss");
String horaFormat = format.format(fecha);

PrintWriter out = resp.getWriter();
out.print("Hora Actualizada" +horaFormat);
out.close();
   }
}
