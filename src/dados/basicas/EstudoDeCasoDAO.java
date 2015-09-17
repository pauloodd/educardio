package dados.basicas;

import java.util.List;

import model.curso.Curso;
import model.curso.DeterminanteHipoteses;
import model.curso.EstudoDeCaso;
import dados.DAOGenerico;

public interface EstudoDeCasoDAO extends DAOGenerico<EstudoDeCaso, Integer> {

	public List<EstudoDeCaso> listarEstudosDeCasosPorCurso(Curso curso);
	public List<DeterminanteHipoteses> buscarDeterminantesHipotesesPorEstudoCaso(EstudoDeCaso estudoDeCaso);
}
