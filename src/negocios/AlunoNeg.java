package negocios;

import java.util.Date;
import java.util.List;

import dados.FabricaDAO;
import dados.basicas.AlunoDAO;
import dados.basicas.EnderecoDAO;
import dados.basicas.MatriculaCursoAlunoDAO;
import dados.hibernate.FabricaHibernateDAO;
import model.Endereco;
import model.curso.Curso;
import model.curso.matricula.MatriculaCursoAluno;
import model.usuario.Aluno;

public class AlunoNeg {
	
	private FabricaDAO fabrica;
	public static AlunoNeg instancia;
	
	public AlunoNeg() {
		fabrica = FabricaHibernateDAO.getInstancia();
	}
	
	public static AlunoNeg getInstancia(){
		if(AlunoNeg.instancia == null){
			AlunoNeg.instancia = new AlunoNeg();
		}
		return AlunoNeg.instancia;
	}
	

	public Aluno criarUsuarioAluno(Aluno aluno) {
		Endereco endereco = aluno.getEndereco();
		endereco = criarEndereco(endereco);
		aluno.setDataCriacao(new Date());
		
		aluno.setEndereco(endereco);
		
		AlunoDAO dao = this.fabrica.getAlunoDAO();
		
		aluno = dao.persistir(aluno);
		if(aluno == null) {
			removerEndereco(endereco);
		}
		return aluno;
	}
	
	public void removerAluno(Aluno aluno) {
		AlunoDAO dao = this.fabrica.getAlunoDAO();
		dao.remover(aluno);
	}
	
	public Aluno buscarPorId(int id, boolean lock){
		AlunoDAO dao = this.fabrica.getAlunoDAO();
		return dao.getPorId(id, lock);
	}
	
	public List<Aluno> getTodos(){
		AlunoDAO dao = this.fabrica.getAlunoDAO(); 
		return dao.getTodos();
	}
	
	public void matricularAlunoCursos(Aluno aluno, List<Curso> cursos){
		for (Curso curso : cursos) {
			MatriculaCursoAluno matricula = new MatriculaCursoAluno();
			matricula.setAluno(aluno);
			matricula.setCurso(curso);
			matricula.setDataMatricula(new Date());
			persistirMatriculaCursoALuno(matricula);
		}
		
	}
	
	/** M�todos Privados	 */
	private Endereco criarEndereco(Endereco end) {
		EnderecoDAO dao = this.fabrica.getEnderecoDAO();
		return dao.persistir(end);
	}
	
	private void removerEndereco(Endereco end) {
		EnderecoDAO dao = this.fabrica.getEnderecoDAO();
		dao.remover(end);
	}
	
	private void persistirMatriculaCursoALuno(MatriculaCursoAluno matricula) {
		MatriculaCursoAlunoDAO dao = this.fabrica.getMatriculaCursoAlunoDAO();
		dao.persistir(matricula);
	}
	
}
