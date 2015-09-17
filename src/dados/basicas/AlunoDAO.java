package dados.basicas;

import model.usuario.Aluno;
import dados.DAOGenerico;

public interface AlunoDAO extends DAOGenerico<Aluno, Integer> {

	Aluno getAlunoPorLogin(String login);

}
