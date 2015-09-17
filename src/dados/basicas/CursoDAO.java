package dados.basicas;

import java.util.List;

import model.curso.Curso;
import dados.DAOGenerico;

public interface CursoDAO extends DAOGenerico<Curso, Integer> {


	public List<Curso> getTodosCursosPorStatus(int ... status);
	
}
