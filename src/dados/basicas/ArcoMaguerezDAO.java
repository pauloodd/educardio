package dados.basicas;

import java.util.List;

import model.curso.Curso;
import model.curso.EstudoDeCaso;
import model.curso.matricula.MatriculaCursoAluno;
import model.curso.matricula.arcomaguerez.ArcoMaguerezEstudoDeCaso;
import dados.DAOGenerico;

public interface ArcoMaguerezDAO extends DAOGenerico<ArcoMaguerezEstudoDeCaso, Integer> {

	public ArcoMaguerezEstudoDeCaso getArcoMaguerezPorMatriculaCursoEstudoCaso(MatriculaCursoAluno matricula, EstudoDeCaso estudo);
	public List<ArcoMaguerezEstudoDeCaso> buscarArcosMaguerezPorCursoEAluno(MatriculaCursoAluno matricula, Curso Curso);
}
