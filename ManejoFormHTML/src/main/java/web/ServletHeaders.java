package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletHeaders")
public class ServletHeaders extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset-UTF-8");
        PrintWriter out = resp.getWriter();
        String methodHttp = req.getMethod();

        out.print("<html>");
        out.print("<head>");
        out.print("<title> Headers HTTP </title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1> method: " + methodHttp + "</h1>");
       
        String uri = req.getRequestURI();
        out.print("<h1> URI: " + uri + "</h1><br/>");
//Todos los cabecerso disponibles
Enumeration cabeceros = req.getHeaderNames();
while(cabeceros.hasMoreElements()){
String nombreCab =(String)cabeceros.nextElement();
out.print("<b>" + nombreCab + "</b>:");
out.print(req.getHeader(nombreCab)+"<br/>");
};

        out.print("</body>");
        out.print("</html>");
        out.close();
    }
}
