package dados.basicas;

import model.curso.matricula.arcomaguerez.Diagnostico;
import model.curso.matricula.arcomaguerez.Intervencao;
import model.curso.matricula.arcomaguerez.Meta;
import dados.DAOGenerico;

public interface IntervencaoDAO extends DAOGenerico<Intervencao, Integer> {

	public void removerIntervencao(Intervencao intervencao);
	public void removerIntervencoesDiagnostico(Diagnostico diagnostico);
	public void removerIntervencoesMeta(Meta meta);
}
