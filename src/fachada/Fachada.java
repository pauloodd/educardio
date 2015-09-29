package fachada;

import java.util.List;

import dados.hibernate.HibernateUtil;
import model.Nanda;
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
import model.sistema.Erro;
import model.usuario.Administrador;
import model.usuario.Aluno;
import model.usuario.Professor;
import model.usuario.Usuario;
import negocios.AdministradorNeg;
import negocios.AlunoNeg;
import negocios.CursoNeg;
import negocios.ErroNeg;
import negocios.MatriculaNeg;
import negocios.ProfessorNeg;
import negocios.UsuarioNeg;


public class Fachada {
	
	private static Fachada instancia;
	private final UsuarioNeg usuarioNeg;
	private final AlunoNeg alunoNeg;
	private final ProfessorNeg professorNeg;
	private final AdministradorNeg adminNeg;
	private final ErroNeg erroNeg;
	private final CursoNeg cursoNeg;
	private final MatriculaNeg matriculaNeg;
	
	public Fachada() {
		usuarioNeg = UsuarioNeg.getInstancia();
		alunoNeg = AlunoNeg.getInstancia();
		professorNeg = ProfessorNeg.getInstancia();
		adminNeg = AdministradorNeg.getInstancia();
		erroNeg = ErroNeg.getInstancia();
		cursoNeg = CursoNeg.getInstancia();
		matriculaNeg = MatriculaNeg.getInstancia();
	}
	
	public static Fachada getInstancia(){
 		if(Fachada.instancia == null){
 			Fachada.instancia = new Fachada();
		}
		return Fachada.instancia;
	}
	
	public void atualizar(){
		HibernateUtil.getFabricaDeSessao().getCurrentSession().flush();
	}
	
	public void limparSessaoHibernate(){
		HibernateUtil.getFabricaDeSessao().getCurrentSession().clear();
	}
	
	/** Métodos ErroNeg	 */
	public void reportarBug(Erro erro){
		this.erroNeg.reportarBug(erro);
	}
	
	/** Métodos UsuarioNeg	 */
	public Object autenticar(String login){
		return this.usuarioNeg.getUsuario(login);
	}
	
	public List<Usuario> getTodosUsuarios(){
		return this.usuarioNeg.getTodos();
	}
	
	public List<Usuario> getUsuariosPorConsulta(String tipo, String valor){
		return this.usuarioNeg.getPorConsulta(tipo, valor);
	}
	
	public Usuario getUsuarioPorId(int id){
		return this.usuarioNeg.getPorId(id);
	}
	
	public void saveOrUpdateUsuario(Usuario usuario){
		this.usuarioNeg.saveOrUpdateUsuario(usuario);
	}
	
	/** Métodos AlunosNeg	 */
	public Aluno criarUsuarioAluno(Aluno aluno) {
		return this.alunoNeg.criarUsuarioAluno(aluno);
	}
	
	public void removerAluno(Aluno aluno) {
		this.alunoNeg.removerAluno(aluno);
	}
	
	public Aluno buscarAlunoPorId(int id, boolean lock){
		return this.alunoNeg.buscarPorId(id, lock);
	}
	
	public List<Aluno> getTodosAlunos(){
		return this.alunoNeg.getTodos();
	}
	
	public void matricularAlunoCursos(Aluno aluno, List<Curso> cursos){
		this.alunoNeg.matricularAlunoCursos(aluno, cursos);
	}
	
	
	/** Métodos AdministradorNeg	 */
	public Administrador criarUsuarioAdministrador(Administrador admin) {
		return this.adminNeg.criarUsuarioAdministrador(admin);
	}
	
	public void removerAdministrador(Administrador admin) {
		this.adminNeg.removerAdministrador(admin);
	}
	
	public Administrador buscarAdministradorPorId(int id, boolean lock){
		return this.adminNeg.buscarPorId(id, lock);
	}
	
	public List<Administrador> getTodosAdministradores(){
		return this.adminNeg.getTodos();
	}
	
	public Nanda cadastrarCipe(Nanda cipe){
		return cursoNeg.cadastrarCipe(cipe);
	}
	
	public void removerCipe(Nanda cipe){
		cursoNeg.removerCipe(cipe);
	}
	
	public Nanda editarCipe(Nanda cipe){
		return cursoNeg.editarCipe(cipe);
	}
	
	/** Métodos ProfessorNeg	 */
	public Professor criarUsuarioProfessor(Professor professor) {
		return this.professorNeg.criarUsuarioProfessor(professor);
	}
	
	public void removerProfessor(Professor professor) {
		this.professorNeg.removerProfessor(professor);
	}
	
	public Professor buscarProfessorPorId(int id, boolean lock){
		return this.professorNeg.buscarPorId(id, lock);
	}
	
	public List<Professor> getTodosProfessores(){
		return this.professorNeg.getTodos();
	}
	
	/** Métodos CursoNeg	  */
	public List<Curso> getTodosCursos(){
		return this.cursoNeg.getTodos();
	}
	
	public Curso getCursoPorId(int id){
		return this.cursoNeg.getPorId(id);
	}
	
	public List<Curso> getTodosCursosPorStatus(int ... status) {
		return this.cursoNeg.getTodosCursosPorStatus(status);
	}
	
	public void removerCurso(Curso curso) {
		 this.cursoNeg.removerCurso(curso);
	}
	
	public Curso inserirCurso(Curso curso){
		 return this.cursoNeg.inserirCurso(curso);
	}
	
	public List<Arquivo> inserirArquivosCurso(List<Arquivo> arquivos){
		return this.cursoNeg.inserirArquivosCurso(arquivos);
	}
	
	public List<EstudoDeCaso> listarEstudosDeCasosPorCurso(Curso curso){
		return this.cursoNeg.listarEstudosDeCasosPorCurso(curso);
	}
	
	public EstudoDeCaso cadastrarEstudoDeCaso(EstudoDeCaso estudoDeCaso){
		return this.cursoNeg.cadastrarEstudoDeCaso(estudoDeCaso);
	}
	
	public Arquivo getArquivoPorId(int id){
		return this.cursoNeg.getArquivoPorId(id);
	}
	
	public List<Nanda> pesquisarCipe(String query, String eixo) {
		return this.cursoNeg.pesquisarCipe(query, eixo);
	}

	/** Métodos MatriculaNeg	  */
	public List<MatriculaCursoAluno> getTodasMatriculasAluno(Aluno aluno) {
		 return this.matriculaNeg.getTodasMatriculasAluno(aluno);
	}
	
	public List<Curso> getTodosCursosDisponiveisEAndamentoDiferentesDeMatriculado(List<MatriculaCursoAluno> matriculas){
		 return this.matriculaNeg.getTodosCursosDisponiveisEAndamentoDiferentesDeMatriculado(matriculas);
	}
	
	public MatriculaCursoAluno getMatriculaAlunoCursoPorId(int id){
		return this.matriculaNeg.getPorId(id);
	}
	
	public void removerMatriculaCursoAluno(MatriculaCursoAluno curso) {
		this.matriculaNeg.removerMatriculaCursoAluno(curso);
	}
	
	public ArcoMaguerezEstudoDeCaso getArcoMaguerezPorMatriculaCursoEstudoCaso(
			MatriculaCursoAluno matricula, EstudoDeCaso estudo){
		return this.matriculaNeg.getArcoMaguerezPorMatriculaCursoEstudoCaso(matricula, estudo);
	}
	
	public ArcoMaguerezEstudoDeCaso inserirArcoMaguerez(ArcoMaguerezEstudoDeCaso arcoMaguerez){
		return this.matriculaNeg.inserirArcoMaguerez(arcoMaguerez);
	}
	
	public ArcoMaguerezEstudoDeCaso atualizarArcoMaguerez(ArcoMaguerezEstudoDeCaso arcoMaguerez){
		return this.matriculaNeg.atualizarArcoMaguerez(arcoMaguerez);
	}
	
	public List<Arquivo> inserirArquivosTeorizacao(List<Arquivo> arquivos, Implementacao teorizacao){
		return this.matriculaNeg.inserirArquivosTeorizacao(arquivos, teorizacao);
	}
	
	public Implementacao atualizarTeorizacao(Implementacao teorizacao){
		return this.matriculaNeg.atualizarTeorizacao(teorizacao);
	}
	
	public DiagnosticosImplementacoes adicionarDiagnostico(DiagnosticosImplementacoes diagnostico){
		return this.matriculaNeg.adicionarDiagnostico(diagnostico);
	}
	
	public List<DiagnosticosImplementacoes> buscarDiagnosticoPorEstudoDeCaso(
			EstudoDeCaso estudoDeCaso) {
		return this.matriculaNeg.buscarDiagnosticoPorEstudoDeCaso(estudoDeCaso);
	}
	
	public DiagnosticosImplementacoes editarDiagnostico(DiagnosticosImplementacoes diagnostico){
		return this.matriculaNeg.editarDiagnostico(diagnostico);
	}
	
	public List<DiagnosticosImplementacoes> buscarDiagnosticoPorHipotesesDeSolucao(ResultadosEsperados hipotesesDeSolucao){
		return this.matriculaNeg.buscarDiagnosticoPorHipotesesDeSolucao(hipotesesDeSolucao);
	}
	
	public Avaliacao atualizarAplicacao(Avaliacao aplicacao){
		return this.matriculaNeg.atualizarAplicacao(aplicacao);
	}
	
	public MatriculaCursoAluno atualizarMatriculaCursoAluno(MatriculaCursoAluno matriculaCursoAluno){
		return this.matriculaNeg.atualizarMatriculaCursoAluno(matriculaCursoAluno);
	}
	
	public List<ArcoMaguerezEstudoDeCaso> buscarArcosMaguerezPorCursoEAluno(MatriculaCursoAluno matricula,Curso curso) {
		return this.matriculaNeg.buscarArcosMaguerezPorCursoEAluno(matricula, curso);
	}
	
	public Planejamento atualizarPontosChave(Planejamento pontosChave){
		return this.matriculaNeg.atualizarPontosChave(pontosChave);
	}
		
	public ResultadosEsperados atualizarHipotesesDeSolucao(ResultadosEsperados hipotesesDeSolucao){
		return this.matriculaNeg.atualizarHipotesesDeSolucao(hipotesesDeSolucao);
	}	
	
	public AvaliacaoProfessor inserirAvaliacaoProfessor(AvaliacaoProfessor avaliacao){
		return this.matriculaNeg.inserirAvaliacaoProfessor(avaliacao);
	}
	
	public List<ArcoMaguerezEstudoDeCaso> getTodasArcoMaguerezEstudoDeCasoPorCurso(Curso curso) {
		return this.matriculaNeg.getTodasArcoMaguerezEstudoDeCasoPorCurso(curso);
	}
	
	public ArcoMaguerezEstudoDeCaso getArcoMaguerezId(int idArco){
		return this.matriculaNeg.getArcoMaguerezId(idArco);
	}
}
