package dados.basicas;

import java.util.List;

import model.curso.EstudoDeCaso;
import model.curso.matricula.arcomaguerez.Diagnostico;
import model.curso.matricula.arcomaguerez.HipotesesDeSolucao;
import dados.DAOGenerico;

public interface DiagnosticoDAO extends DAOGenerico<Diagnostico, Integer> {

	public List<Diagnostico> buscarDiagnosticoPorEstudoDeCaso(EstudoDeCaso estudoDeCaso);
	public List<Diagnostico> buscarDiagnosticoPorHipotesesDeSolucao(HipotesesDeSolucao hipotesesDeSolucao);
}
