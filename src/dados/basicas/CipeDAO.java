package dados.basicas;

import java.util.List;

import model.Cipe;
import dados.DAOGenerico;

public interface CipeDAO extends DAOGenerico<Cipe, Integer> {

	List<Cipe> pesquisarCipe(String query, String eixo);
}
