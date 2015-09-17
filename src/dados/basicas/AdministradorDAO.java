package dados.basicas;

import model.usuario.Administrador;
import dados.DAOGenerico;

public interface AdministradorDAO extends DAOGenerico<Administrador, Integer> {

	Administrador getAdministradorPorLogin(String login);

}
