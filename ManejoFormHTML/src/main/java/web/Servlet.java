package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset-UTF-8");
        PrintWriter out = resp.getWriter();
        String usuario = req.getParameter("usuario");
        String pass = req.getParameter("password");
        String tecnologias[] = req.getParameterValues("tecnologia");
        String genero = req.getParameter("genero");
        String ocupacion = req.getParameter("ocupacion");
        String musica[] = req.getParameterValues("musica");
        String comentarios = req.getParameter("comentarios");

        out.print("<html>");
        out.print("<head>");
        out.print("<title> Datos </title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Datos Procesados</h1><br/>");
        out.print("<table border='1'>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Usuario: ");
        out.print("</td>");
        out.print("<td>");
        out.print(usuario);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Password: ");
        out.print("</td>");
        out.print("<td>");
        out.print(pass);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Tecnologia: ");
        out.print("</td>");
        out.print("<td>");
        for (String tecnologia : tecnologias) {

            out.print(tecnologia);
            out.print("/");

        };
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Genero: ");
        out.print("</td>");
        out.print("<td>");
        out.print(genero);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Ocupacion: ");
        out.print("</td>");
        out.print("<td>");
        out.print(ocupacion);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Musica: ");
        out.print("</td>");
        out.print("<td>");
        if (musica != null) {
            for (String m : musica) {
                out.print(m);
                out.print("/");
            };
        } else {
            out.print("no selecionada");
        }
        out.print("</td>");
        out.print("</tr>");

 out.print("<tr>");
        out.print("<td>");
        out.print("Comentarios: ");
        out.print("</td>");
        out.print("<td>");
        out.print(comentarios);
        out.print("</td>");
        out.print("</tr>");

        out.print("</table>");
        out.print("</body>");
        out.print("</html>");
        out.close();
    }

}
