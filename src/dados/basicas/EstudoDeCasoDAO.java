package dados.basicas;

import java.util.List;

import dados.DAOGenerico;
import model.curso.Curso;
import model.curso.EstudoDeCaso;

public interface EstudoDeCasoDAO extends DAOGenerico<EstudoDeCaso, Integer> {

	public List<EstudoDeCaso> listarEstudosDeCasosPorCurso(Curso curso);
}
