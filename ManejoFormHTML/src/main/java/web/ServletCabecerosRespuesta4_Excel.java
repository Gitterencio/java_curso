package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletCRExcel")
public class ServletCabecerosRespuesta4_Excel extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/vnd.ms-excel");
        resp.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");
//no guardar cache
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-control", "no-store");
        resp.setDateHeader("Expires", -1);
//

//desplegar info al cliente \t es un tabuldaro para avanzar en las seldas
//\t -> siguiente celda
PrintWriter out = resp.getWriter();
out.println("\tValores");
out.println("\t1");
out.println("\t2");
out.println("Total\t=SUMA(b2:b3)");
out.close();
    }
}
