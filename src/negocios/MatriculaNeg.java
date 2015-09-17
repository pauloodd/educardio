package negocios;

import java.util.ArrayList;
import java.util.List;

import model.curso.Curso;
import model.curso.DeterminanteHipoteses;
import model.curso.EstudoDeCaso;
import model.curso.matricula.AvaliacaoProfessor;
import model.curso.matricula.MatriculaCursoAluno;
import model.curso.matricula.arcomaguerez.Aplicacao;
import model.curso.matricula.arcomaguerez.ArcoMaguerezEstudoDeCaso;
import model.curso.matricula.arcomaguerez.Determinante;
import model.curso.matricula.arcomaguerez.Diagnostico;
import model.curso.matricula.arcomaguerez.HipotesesDeSolucao;
import model.curso.matricula.arcomaguerez.Intervencao;
import model.curso.matricula.arcomaguerez.Meta;
import model.curso.matricula.arcomaguerez.PontosChave;
import model.curso.matricula.arcomaguerez.Teorizacao;
import model.sistema.Arquivo;
import model.usuario.Aluno;
import dados.FabricaDAO;
import dados.basicas.AplicacaoDAO;
import dados.basicas.ArcoMaguerezDAO;
import dados.basicas.ArquivoDAO;
import dados.basicas.AvaliacaoProfessorDAO;
import dados.basicas.DeterminanteDAO;
import dados.basicas.DeterminanteHipotesesDAO;
import dados.basicas.DiagnosticoDAO;
import dados.basicas.EstudoDeCasoDAO;
import dados.basicas.HipotesesDeSolucaoDAO;
import dados.basicas.IntervencaoDAO;
import dados.basicas.MatriculaCursoAlunoDAO;
import dados.basicas.MetaDAO;
import dados.basicas.PontosChaveDAO;
import dados.basicas.TeorizacaoDAO;
import dados.hibernate.FabricaHibernateDAO;

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
		PontosChaveDAO daoPts = fabrica.getPontosChaveDAO();
		TeorizacaoDAO daoTeorizacao = fabrica.getTeorizacaoDAO();
		HipotesesDeSolucaoDAO daoHipoteses = fabrica.getHipotesesDeSolucaoDAO();
		AplicacaoDAO daoApp = fabrica.getAplicacaoDAO();
		PontosChave pontosChave = daoPts.persistir(arcoMaguerez.getPontosChave());
		Teorizacao teorizacao = daoTeorizacao.persistir(arcoMaguerez.getTeorizacao());
		HipotesesDeSolucao hipoteses = daoHipoteses.persistir(arcoMaguerez.getHipotesesDeSolucao());
		Aplicacao aplicacao = daoApp.persistir(arcoMaguerez.getAplicacao());
		arcoMaguerez.setPontosChave(pontosChave);
		arcoMaguerez.setTeorizacao(teorizacao);
		arcoMaguerez.setHipotesesDeSolucao(hipoteses);
		arcoMaguerez.setAplicacao(aplicacao);
		return daoArco.persistir(arcoMaguerez);
	}
	
	public ArcoMaguerezEstudoDeCaso atualizarArcoMaguerez(ArcoMaguerezEstudoDeCaso arcoMaguerez){
		ArcoMaguerezDAO daoArco = fabrica.getArcoMaguerezDAO();
		return daoArco.persistir(arcoMaguerez);
	}
	
	public List<Determinante> buscarDeterminantePorPontoChave(
			PontosChave pontosChave) {
		DeterminanteDAO dao = fabrica.getDeterminanteDAO();
		return dao.buscarDeterminantePorPontoChave(pontosChave);
	}
	
	public List<Determinante> inserirDeterminantePontosChave(List<Determinante> listaDeterminantes, PontosChave pontosChave){
		List<Determinante> retorno = new ArrayList<Determinante>();
		DeterminanteDAO dao = fabrica.getDeterminanteDAO();
		dao.removerDeterminantesPontosChave(pontosChave);

		if(listaDeterminantes != null && !listaDeterminantes.isEmpty()){
			for (Determinante determinante : listaDeterminantes) {
				Determinante determAdd = dao.persistir(determinante);
				retorno.add(determAdd);
			}
		}
		
		return retorno;
	}
	
	public List<Arquivo> inserirArquivosTeorizacao(List<Arquivo> arquivos, Teorizacao teorizacao){
		ArquivoDAO arqDao = fabrica.getArquivoDAO();
		List<Arquivo> retorno = new ArrayList<Arquivo>();
		for (Arquivo arquivo : arquivos) {
			Arquivo temp = arqDao.persistir(arquivo);
			retorno.add(temp);
		}
		return retorno;
	}
	
	public PontosChave atualizarPontosChave(PontosChave pontosChave){
		PontosChaveDAO dao = fabrica.getPontosChaveDAO();
		return dao.persistir(pontosChave);
	}
	
	public HipotesesDeSolucao atualizarHipotesesDeSolucao(HipotesesDeSolucao hipotesesDeSolucao){
		HipotesesDeSolucaoDAO dao = fabrica.getHipotesesDeSolucaoDAO();
		return dao.persistir(hipotesesDeSolucao);
	}
	
	public Teorizacao atualizarTeorizacao(Teorizacao teorizacao){
		TeorizacaoDAO dao = fabrica.getTeorizacaoDAO();
		return dao.persistir(teorizacao);
	}
	
	public List<DeterminanteHipoteses> buscarDeterminantesHipotesesPorEstudoCaso(
			EstudoDeCaso estudoDeCaso) {
		EstudoDeCasoDAO dao = fabrica.getEstudoDeCasoDAO();
		return dao.buscarDeterminantesHipotesesPorEstudoCaso(estudoDeCaso);
	}
	
	public Diagnostico adicionarDiagnostico(Diagnostico diagnostico){
		DiagnosticoDAO dao = fabrica.getDiagnosticoDAO();
		return dao.persistir(diagnostico);
	}
	
	public Diagnostico editarDiagnostico(Diagnostico diagnostico){
		DiagnosticoDAO dao = fabrica.getDiagnosticoDAO();
		return dao.persistir(diagnostico);
	}
	
	public DeterminanteHipoteses adicionarDeterminanteHipoteses(DeterminanteHipoteses determinanteHipoteses){
		DeterminanteHipotesesDAO dao = fabrica.getDeterminanteHipotesesDAO();
		DeterminanteHipoteses retorno = dao.persistir(determinanteHipoteses);
		return retorno;
	}
	
	public List<Diagnostico> buscarDiagnosticoPorEstudoDeCaso(
			EstudoDeCaso estudoDeCaso) {
		DiagnosticoDAO dao = fabrica.getDiagnosticoDAO();
		return dao.buscarDiagnosticoPorEstudoDeCaso(estudoDeCaso);
	}
	
	public void removerDiagnostico(Diagnostico diagnostico){
		IntervencaoDAO daoInter = fabrica.getIntervencaoDAO();
		daoInter.removerIntervencoesDiagnostico(diagnostico);
		MetaDAO daoMeta = fabrica.getMetaDAO();
		daoMeta.removerMetasDeDiagnostico(diagnostico);
		DiagnosticoDAO dao = fabrica.getDiagnosticoDAO();
		dao.remover(diagnostico);
	}
	
	public Meta inserirMeta(Meta meta){
		MetaDAO dao = fabrica.getMetaDAO();
		return dao.persistir(meta);
	}
	
	public Meta editarMeta(Meta meta){
		MetaDAO dao = fabrica.getMetaDAO();
		return dao.persistir(meta);
	}
	
	public void removerMetaDiagnostico(Meta meta){
		IntervencaoDAO daoInter = fabrica.getIntervencaoDAO();
		daoInter.removerIntervencoesMeta(meta);
		MetaDAO daoMeta = fabrica.getMetaDAO();
		daoMeta.removerMeta(meta);
	}
	
	public Intervencao adicionarIntervencaoMetaDiagnostico(Intervencao intervencao){
		IntervencaoDAO dao = fabrica.getIntervencaoDAO();
		return dao.persistir(intervencao);
	}
	
	public Intervencao editarIntervencaoMetaDiagnostico(Intervencao intervencao){
		IntervencaoDAO dao = fabrica.getIntervencaoDAO();
		return dao.persistir(intervencao);
	}
	
	public void removerIntervencaoDiagnostico(Intervencao intervencao){
		IntervencaoDAO dao = fabrica.getIntervencaoDAO();
		dao.removerIntervencao(intervencao);
	}
	
	public List<Diagnostico> buscarDiagnosticoPorHipotesesDeSolucao(
			HipotesesDeSolucao hipotesesDeSolucao) {
		DiagnosticoDAO dao = fabrica.getDiagnosticoDAO();
		return dao.buscarDiagnosticoPorHipotesesDeSolucao(hipotesesDeSolucao);
	}
	
	public Aplicacao atualizarAplicacao(Aplicacao aplicacao){
		AplicacaoDAO dao = fabrica.getAplicacaoDAO();
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
