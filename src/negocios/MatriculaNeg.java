package negocios;

import java.util.ArrayList;
import java.util.List;

import dados.FabricaDAO;
import dados.basicas.ArcoMaguerezDAO;
import dados.basicas.ArquivoDAO;
import dados.basicas.AvaliacaoDAO;
import dados.basicas.AvaliacaoProfessorDAO;
import dados.basicas.DiagnosticoDAO;
import dados.basicas.ImplementacaoDAO;
import dados.basicas.MatriculaCursoAlunoDAO;
import dados.basicas.PlanejamentoDAO;
import dados.basicas.ResultadosEsperadosDAO;
import dados.hibernate.FabricaHibernateDAO;
import model.curso.Curso;
import model.curso.EstudoDeCaso;
import model.curso.matricula.AvaliacaoProfessor;
import model.curso.matricula.MatriculaCursoAluno;
import model.curso.matricula.arcomaguerez.ArcoMaguerezEstudoDeCaso;
import model.curso.matricula.arcomaguerez.Avaliacao;
import model.curso.matricula.arcomaguerez.DiagnosticosImplementacoes;
import model.curso.matricula.arcomaguerez.Implementacao;
import model.curso.matricula.arcomaguerez.Planejamento;
import model.curso.matricula.arcomaguerez.ResultadosEsperados;
import model.sistema.Arquivo;
import model.usuario.Aluno;

public class MatriculaNeg {

	private static MatriculaNeg instancia;
	private FabricaDAO fabrica;
	
	private MatriculaNeg() {
		fabrica = FabricaHibernateDAO.getInstancia();
	}
	
	public static MatriculaNeg getInstancia(){
		if(MatriculaNeg.instancia == null){
			MatriculaNeg.instancia = new MatriculaNeg();
		}
		return MatriculaNeg.instancia;
	}
	
	
	public MatriculaCursoAluno getPorId(int id){
		MatriculaCursoAlunoDAO dao = fabrica.getMatriculaCursoAlunoDAO();
		
		return dao.getPorId(id, true);
	}
	
	public MatriculaCursoAluno atualizarMatriculaCursoAluno(MatriculaCursoAluno matriculaCursoAluno){
		MatriculaCursoAlunoDAO dao = fabrica.getMatriculaCursoAlunoDAO();
		return dao.persistir(matriculaCursoAluno);
	}
	
	public void removerMatriculaCursoAluno(MatriculaCursoAluno curso) {
		MatriculaCursoAlunoDAO dao = fabrica.getMatriculaCursoAlunoDAO();
		dao.remover(curso);
	}
	
	public List<ArcoMaguerezEstudoDeCaso> getTodasArcoMaguerezEstudoDeCasoPorCurso(Curso curso) {
			MatriculaCursoAlunoDAO dao = fabrica.getMatriculaCursoAlunoDAO();
		return dao.getTodasArcoMaguerezEstudoDeCasoPorCurso(curso);
	}
	
	public List<MatriculaCursoAluno> getTodasMatriculasAluno(Aluno aluno) {
		MatriculaCursoAlunoDAO dao = fabrica.getMatriculaCursoAlunoDAO();
		return dao.getTodasMatriculasAluno(aluno);
	}
	
	public List<Curso> getTodosCursosDisponiveisEAndamentoDiferentesDeMatriculado(List<MatriculaCursoAluno> matriculas){
		MatriculaCursoAlunoDAO dao = fabrica.getMatriculaCursoAlunoDAO();
		return dao.getTodosCursosDisponiveisEAndamentoDiferentesDeMatriculado(matriculas);
	}
	
	public ArcoMaguerezEstudoDeCaso getArcoMaguerezPorMatriculaCursoEstudoCaso(
			MatriculaCursoAluno matricula, EstudoDeCaso estudo){
		ArcoMaguerezDAO dao = fabrica.getArcoMaguerezDAO();
		return dao.getArcoMaguerezPorMatriculaCursoEstudoCaso(matricula, estudo);
	}
	
	public ArcoMaguerezEstudoDeCaso getArcoMaguerezId(int idArco){
		ArcoMaguerezDAO dao = fabrica.getArcoMaguerezDAO();
		return dao.getPorId(idArco, false);
	}
	
	public ArcoMaguerezEstudoDeCaso inserirArcoMaguerez(ArcoMaguerezEstudoDeCaso arcoMaguerez){
		ArcoMaguerezDAO daoArco = fabrica.getArcoMaguerezDAO();
		PlanejamentoDAO daoPts = fabrica.getPontosChaveDAO();
		ImplementacaoDAO daoTeorizacao = fabrica.getTeorizacaoDAO();
		ResultadosEsperadosDAO daoHipoteses = fabrica.getHipotesesDeSolucaoDAO();
		AvaliacaoDAO daoApp = fabrica.getAplicacaoDAO();
		Planejamento planejamento = daoPts.persistir(arcoMaguerez.getPlanejamento());
		Implementacao implementacao = daoTeorizacao.persistir(arcoMaguerez.getImplementacao());
		ResultadosEsperados resultadosEsperados = daoHipoteses.persistir(arcoMaguerez.getResultadosEsperados());
		Avaliacao avaliacao = daoApp.persistir(arcoMaguerez.getAvaliacao());
//		arcoMaguerez.setPontosChave(planejamento);
		arcoMaguerez.setImplementacao(implementacao);
		arcoMaguerez.setResultadosEsperados(resultadosEsperados);
		arcoMaguerez.setAvaliacao(avaliacao);
		return daoArco.persistir(arcoMaguerez);
	}
	
	public ArcoMaguerezEstudoDeCaso atualizarArcoMaguerez(ArcoMaguerezEstudoDeCaso arcoMaguerez){
		ArcoMaguerezDAO daoArco = fabrica.getArcoMaguerezDAO();
		return daoArco.persistir(arcoMaguerez);
	}
	
	public List<Arquivo> inserirArquivosTeorizacao(List<Arquivo> arquivos, Implementacao teorizacao){
		ArquivoDAO arqDao = fabrica.getArquivoDAO();
		List<Arquivo> retorno = new ArrayList<Arquivo>();
		for (Arquivo arquivo : arquivos) {
			Arquivo temp = arqDao.persistir(arquivo);
			retorno.add(temp);
		}
		return retorno;
	}
	
	public Planejamento atualizarPontosChave(Planejamento pontosChave){
		PlanejamentoDAO dao = fabrica.getPontosChaveDAO();
		return dao.persistir(pontosChave);
	}
	
	public ResultadosEsperados atualizarHipotesesDeSolucao(ResultadosEsperados hipotesesDeSolucao){
		ResultadosEsperadosDAO dao = fabrica.getHipotesesDeSolucaoDAO();
		return dao.persistir(hipotesesDeSolucao);
	}
	
	public Implementacao atualizarTeorizacao(Implementacao teorizacao){
		ImplementacaoDAO dao = fabrica.getTeorizacaoDAO();
		return dao.persistir(teorizacao);
	}
	
	public DiagnosticosImplementacoes adicionarDiagnostico(DiagnosticosImplementacoes diagnostico){
		DiagnosticoDAO dao = fabrica.getDiagnosticoDAO();
		return dao.persistir(diagnostico);
	}
	
	public DiagnosticosImplementacoes editarDiagnostico(DiagnosticosImplementacoes diagnostico){
		DiagnosticoDAO dao = fabrica.getDiagnosticoDAO();
		return dao.persistir(diagnostico);
	}
	
	public List<DiagnosticosImplementacoes> buscarDiagnosticoPorEstudoDeCaso(
			EstudoDeCaso estudoDeCaso) {
		DiagnosticoDAO dao = fabrica.getDiagnosticoDAO();
		return dao.buscarDiagnosticoPorEstudoDeCaso(estudoDeCaso);
	}
	
	public List<DiagnosticosImplementacoes> buscarDiagnosticoPorHipotesesDeSolucao(
			ResultadosEsperados hipotesesDeSolucao) {
		DiagnosticoDAO dao = fabrica.getDiagnosticoDAO();
		return dao.buscarDiagnosticoPorHipotesesDeSolucao(hipotesesDeSolucao);
	}
	
	public Avaliacao atualizarAplicacao(Avaliacao aplicacao){
		AvaliacaoDAO dao = fabrica.getAplicacaoDAO();
		return dao.persistir(aplicacao);
	}
	
	public List<ArcoMaguerezEstudoDeCaso> buscarArcosMaguerezPorCursoEAluno(MatriculaCursoAluno matricula,Curso curso) {
		ArcoMaguerezDAO dao = fabrica.getArcoMaguerezDAO();
		return dao.buscarArcosMaguerezPorCursoEAluno(matricula, curso);
	}
	
	public AvaliacaoProfessor inserirAvaliacaoProfessor(AvaliacaoProfessor avaliacao){
		AvaliacaoProfessorDAO dao = fabrica.getAvaliacaoProfessorDAO();
		return dao.persistir(avaliacao);
	}
	
}
