package dados.basicas;

import model.usuario.Professor;
import dados.DAOGenerico;

public interface ProfessorDAO extends DAOGenerico<Professor, Integer> {

	Professor getProfessorPorLogin(String login);

}
