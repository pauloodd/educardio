package dados.basicas;

import java.util.List;

import model.usuario.Usuario;
import dados.DAOGenerico;

public interface UsuarioDAO extends DAOGenerico<Usuario, Integer> {

	public List<Usuario> getUsuariosPorConsulta(String tipo, String valor);
}
