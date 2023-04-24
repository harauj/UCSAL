package aula;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Q1")
public class Q1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String infoPes = request.getParameter("infoPes");
		String infoAcad = request.getParameter("infoAcad");
		String infoProf = request.getParameter("infoProf");
		PrintWriter writer = response.getWriter();			

		Cookie c1 = new Cookie("infoPes", infoPes);
		Cookie c2 = new Cookie("infoPes", infoAcad);
		Cookie c3 = new Cookie("infoPes", infoPes);
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		
		writer.append("<H1> Informações pessoais: " + infoPes + "</H1>");
		writer.append("<H2> Informações academicas: " + infoAcad + "</H2>");
		writer.append("<H3> Informações profissionais: " + infoProf + "</H3>");

	}
}