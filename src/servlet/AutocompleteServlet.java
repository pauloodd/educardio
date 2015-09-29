package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Nanda;
import fachada.Fachada;

public class AutocompleteServlet extends HttpServlet{

	private Fachada fachada = Fachada.getInstancia();
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String valor = req.getParameter("q");
		String eixo = req.getParameter("eixo");
		List<Nanda> cipes = fachada.pesquisarCipe(valor, eixo);
		PrintWriter print = resp.getWriter();
		for (Nanda cipe : cipes) {
			print.println(cipe.getTermo().trim()+"["+cipe.getId()+"]");
		}
		
	}
}
