package dados.basicas;

import java.util.List;

import model.curso.matricula.ambulatorio.Material;
import dados.DAOGenerico;

public interface  MaterialDAO extends DAOGenerico<Material, Integer>{

	public List<Material> getTodosMateriaisPorTipo(int ... tipos);
}
