package servlet;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.sistema.Arquivo;
import fachada.Fachada;

public class PhotoServlet extends HttpServlet{

	private Fachada fachada = Fachada.getInstancia();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			  throws ServletException, IOException {


		  try {
			  String id = request.getParameter("id");
		      
		      Arquivo arquivo = fachada.getArquivoPorId(Integer.parseInt(id));
		      
		      OutputStream output = response.getOutputStream();
		      response.setContentType(arquivo.getExtensao());

		      try {

		      output = new BufferedOutputStream(response.getOutputStream());

	          output.write(arquivo.getDadosArqv());

		      } finally {
		          output.close();
		      }

		  } catch (Exception e) {
		      e.printStackTrace();
		  }

		}
}
