package dados.basicas;

import java.util.List;

import model.curso.Curso;
import model.curso.matricula.MatriculaCursoAluno;
import model.curso.matricula.arcomaguerez.ArcoMaguerezEstudoDeCaso;
import model.usuario.Aluno;
import dados.DAOGenerico;

public interface  MatriculaCursoAlunoDAO extends DAOGenerico<MatriculaCursoAluno, Integer>{
	
	public List<MatriculaCursoAluno> getTodasMatriculasAluno(Aluno aluno);
	
	public List<ArcoMaguerezEstudoDeCaso> getTodasArcoMaguerezEstudoDeCasoPorCurso(Curso curso);
	
	public List<Curso> getTodosCursosDisponiveisEAndamentoDiferentesDeMatriculado(List<MatriculaCursoAluno> matriculas);
	
}
