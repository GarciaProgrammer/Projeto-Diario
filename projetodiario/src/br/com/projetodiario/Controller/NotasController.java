package br.com.projetodiario.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetodiario.bean.Nota;
import br.com.projetodiario.model.NotasModel;

@WebServlet("/notas")
public class NotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "list":
			listAction(request, response);
			break;

		case "cad":
			cadAction(request, response);
		default:
			notFoundAction(request, response);

			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String assunto = request.getParameter("assunto");
		String dtNota = request.getParameter("dt");
		String texto = request.getParameter("texto");

		int id = 0;
		id = (request.getParameter("id") != null) ? Integer.parseInt(request.getParameter("id")) : 0;
		int retorno = 0;
		
		if (id > 0) {
			//editar
		}else {
			retorno = NotasModel.cadNota(assunto, dtNota, texto);
		}
		
	}

	private void notFoundAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html> <body> ");
		out.println("<h1> Pagina não encontrada </h1>");
		out.println("</html> </body> ");

	}


	private void cadAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("cadNotasAction.jsp");
		rd.forward(request, response);
	}

	private void listAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Nota> listaNotas = NotasModel.getListaNotas();
		request.setAttribute("listaNotas", listaNotas);
		RequestDispatcher rd = request.getRequestDispatcher("listNotasAction.jsp");
		rd.forward(request, response);
	}
}
