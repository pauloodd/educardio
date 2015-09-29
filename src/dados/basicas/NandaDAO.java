package dados.basicas;

import java.util.List;

import model.Nanda;
import dados.DAOGenerico;

public interface NandaDAO extends DAOGenerico<Nanda, Integer> {

	List<Nanda> pesquisarCipe(String query, String eixo);
}
