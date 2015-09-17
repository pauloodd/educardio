package dados.basicas;

import java.util.List;

import model.curso.matricula.arcomaguerez.Determinante;
import model.curso.matricula.arcomaguerez.PontosChave;
import dados.DAOGenerico;

public interface DeterminanteDAO extends DAOGenerico<Determinante, Integer> {

	public List<Determinante> buscarDeterminantePorPontoChave(PontosChave pontosChave);
	public void removerDeterminantesPontosChave(PontosChave ptsChave);
}
