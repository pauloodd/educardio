package dados;

import java.io.Serializable;
import java.util.List;

public interface DAOGenerico<T, ID extends Serializable> {

	T getPorId(ID id, boolean lock);
	
	List<T> getTodos();
	
	T persistir(T entity);
	
	void remover(T entity);
	
	void atualizar();
	
	void commit();
}
