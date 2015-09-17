package negocios;

import java.util.ArrayList;
import java.util.List;

import model.Cipe;
import model.curso.Curso;
import model.curso.EstudoDeCaso;
import model.curso.matricula.ambulatorio.Ambulatorio;
import model.curso.matricula.ambulatorio.Material;
import model.sistema.Arquivo;
import dados.FabricaDAO;
import dados.basicas.AmbulatorioDAO;
import dados.basicas.ArquivoDAO;
import dados.basicas.CipeDAO;
import dados.basicas.CursoDAO;
import dados.basicas.EstudoDeCasoDAO;
import dados.basicas.MaterialDAO;
import dados.hibernate.FabricaHibernateDAO;

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
	
	public Material cadastrarMaterial(Material material){
		MaterialDAO dao = fabrica.getMaterialDAO();
		return dao.persistir(material);
	}
	
	public List<Material> getTodosMateriaisPorTipo(int... tipos) {
		MaterialDAO dao = fabrica.getMaterialDAO();
		return dao.getTodosMateriaisPorTipo(tipos);
	}
	
	public Ambulatorio organizarAmbulatorioAluno(Ambulatorio ambulatorio){
		MaterialDAO matDao = fabrica.getMaterialDAO();
		List<Material> listMat = ambulatorio.getMateriais();
		for (int i = 0; i < listMat.size(); i++) {
			Material matTemp = matDao.getPorId(listMat.get(i).getId(), true);
			ambulatorio.getMateriais().set(i, matTemp);
		}
		AmbulatorioDAO ambDao = this.fabrica.getAmbulatorioDAO();
		ambDao.removerTodosMateriasAmbulatorio(ambulatorio);
		return ambDao.persistir(ambulatorio);
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
	
	public List<Cipe> pesquisarCipe(String query, String eixo) {
		CipeDAO dao = fabrica.getCipeDAO();
		return dao.pesquisarCipe(query, eixo);
	}
	
	public Cipe cadastrarCipe(Cipe cipe){
		CipeDAO dao = fabrica.getCipeDAO();
		return dao.persistir(cipe);
	}
	
	public void removerCipe(Cipe cipe){
		CipeDAO dao = fabrica.getCipeDAO();
		dao.remover(cipe);
	}
	
	public Cipe editarCipe(Cipe cipe){
		CipeDAO dao = fabrica.getCipeDAO();
		return dao.persistir(cipe);
	}
	
}
