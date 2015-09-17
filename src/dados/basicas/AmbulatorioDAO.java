package dados.basicas;

import model.curso.matricula.ambulatorio.Ambulatorio;
import dados.DAOGenerico;

public interface  AmbulatorioDAO extends DAOGenerico<Ambulatorio, Integer>{

	public void removerTodosMateriasAmbulatorio(Ambulatorio ambulatorio);
}
