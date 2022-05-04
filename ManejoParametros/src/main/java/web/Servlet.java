
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Servlet", urlPatterns={"/Servlet"})
public class Servlet extends HttpServlet
{  

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//leer los parametros del formulario html
String usuario = req.getParameter("usuario");
String pass = req.getParameter("pass");
      System.out.println("usuario:"+usuario);
      System.out.println("pass:"+pass);

      PrintWriter out = resp.getWriter();
      out.print("<html>");
      out.print("<body>");
      out.print("<h1>Hola mundo</h1><br/>");
      out.print("<h2>Us: "+usuario+"</h2><br/>");
      out.print("<h3>Pass: "+pass+"</h3><br/>");
      out.print("</body>");
      out.print("</html>");
      out.close();
}
  
}
