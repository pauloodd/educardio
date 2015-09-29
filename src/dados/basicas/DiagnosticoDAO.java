package dados.basicas;

import java.util.List;

import model.curso.EstudoDeCaso;
import model.curso.matricula.arcomaguerez.DiagnosticosImplementacoes;
import model.curso.matricula.arcomaguerez.ResultadosEsperados;
import dados.DAOGenerico;

public interface DiagnosticoDAO extends DAOGenerico<DiagnosticosImplementacoes, Integer> {

	public List<DiagnosticosImplementacoes> buscarDiagnosticoPorEstudoDeCaso(EstudoDeCaso estudoDeCaso);
	public List<DiagnosticosImplementacoes> buscarDiagnosticoPorHipotesesDeSolucao(ResultadosEsperados hipotesesDeSolucao);
}
