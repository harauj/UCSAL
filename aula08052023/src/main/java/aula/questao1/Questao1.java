package aula.questao1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Questao1
 */
@WebServlet("/Questao1")
public class Questao1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession(true);
		PrintWriter writer = response.getWriter();

		Integer acessos = (Integer) sessao.getAttribute("Numero_acessos");
		if (acessos == null) {
			acessos = 1;
		} else {
			acessos = acessos + 1;
		}

		sessao.setAttribute("Numero_acessos", acessos);
		sessao.setAttribute("loginSession", request.getParameter("login"));
		sessao.setAttribute("infoPesSession", request.getParameter("infoPes"));
		sessao.setAttribute("infoAcadSession", request.getParameter("infoAcad"));
		sessao.setAttribute("infoProfSession", request.getParameter("infoProf"));

		writer.append((String) sessao.getAttribute("loginSession") + '\n');
		writer.append((String) sessao.getAttribute("infoPesSession") + '\n');
		writer.append((String) sessao.getAttribute("infoAcadSession") + '\n');
		writer.append((String) sessao.getAttribute("infoProfSession") + '\n');
		
		if (acessos >= 3) {
			writer.append("Redirecionando para: Excedidos");
			response.sendRedirect("Excedidos");
		}

	}

}
