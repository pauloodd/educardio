package negocios;

import java.util.ArrayList;
import java.util.List;

import dados.FabricaDAO;
import dados.basicas.ArquivoDAO;
import dados.basicas.CursoDAO;
import dados.basicas.EstudoDeCasoDAO;
import dados.basicas.NandaDAO;
import dados.hibernate.FabricaHibernateDAO;
import model.Nanda;
import model.curso.Curso;
import model.curso.EstudoDeCaso;
import model.sistema.Arquivo;

public class CursoNeg {

	private static CursoNeg instancia;
	private FabricaDAO fabrica;
	
	private CursoNeg() {
		fabrica = FabricaHibernateDAO.getInstancia();
	}
	
	public static CursoNeg getInstancia(){
		if(CursoNeg.instancia == null){
			CursoNeg.instancia = new CursoNeg();
		}
		return CursoNeg.instancia;
	}
	
	
	public List<Curso> getTodos(){
		CursoDAO dao = fabrica.getCursoDAO();
		return dao.getTodos();
	}
	
	public Curso getPorId(int id){
		CursoDAO dao = fabrica.getCursoDAO();
		return dao.getPorId(id, true);
	}
	
	public void removerCurso(Curso curso) {
		CursoDAO dao = fabrica.getCursoDAO();
		dao.remover(curso);
	}
	
	public List<Curso> getTodosCursosPorStatus(int ... status) {
		CursoDAO dao = fabrica.getCursoDAO();
		return dao.getTodosCursosPorStatus(status);
	}
	
	public Curso inserirCurso(Curso curso){
		CursoDAO dao = fabrica.getCursoDAO();
		return dao.persistir(curso);
	}
	
	public List<Arquivo> inserirArquivosCurso(List<Arquivo> arquivos){
		ArquivoDAO arqDao = fabrica.getArquivoDAO();
		List<Arquivo> retorno = new ArrayList<Arquivo>();
		for (Arquivo arquivo : arquivos) {
			Arquivo temp = arqDao.persistir(arquivo);
			retorno.add(temp);
		}
		return retorno;
	}
	
	public Arquivo getArquivoPorId(int id){
		ArquivoDAO dao = fabrica.getArquivoDAO();
		return dao.getPorId(id, true);
	}
	
	public EstudoDeCaso cadastrarEstudoDeCaso(EstudoDeCaso estudoDeCaso){
		EstudoDeCasoDAO dao = fabrica.getEstudoDeCasoDAO();
		return dao.persistir(estudoDeCaso);
	}
	
	public List<EstudoDeCaso> listarEstudosDeCasosPorCurso(Curso curso){
		EstudoDeCasoDAO dao = fabrica.getEstudoDeCasoDAO();
		return dao.listarEstudosDeCasosPorCurso(curso);
	}
	
	public List<Nanda> pesquisarCipe(String query, String eixo) {
		NandaDAO dao = fabrica.getCipeDAO();
		return dao.pesquisarCipe(query, eixo);
	}
	
	public Nanda cadastrarCipe(Nanda cipe){
		NandaDAO dao = fabrica.getCipeDAO();
		return dao.persistir(cipe);
	}
	
	public void removerCipe(Nanda cipe){
		NandaDAO dao = fabrica.getCipeDAO();
		dao.remover(cipe);
	}
	
	public Nanda editarCipe(Nanda cipe){
		NandaDAO dao = fabrica.getCipeDAO();
		return dao.persistir(cipe);
	}
	
}
