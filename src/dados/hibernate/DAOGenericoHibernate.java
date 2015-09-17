package dados.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import dados.DAOGenerico;


public abstract class DAOGenericoHibernate<T, ID extends Serializable>
		implements DAOGenerico<T, ID> {

	private Class<T> classPersistente;

	private Session sessao;

	@SuppressWarnings("unchecked")
	public DAOGenericoHibernate() {
		this.classPersistente = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void setSession(Session s) {
		this.sessao = s;
	}

	protected Session getSession() {
		if (sessao == null)
			throw new IllegalStateException(
					"A sessão não foi inicializada no DAO antes do uso.");
		return sessao;
	}

	public Class<T> getPersistentClass() {
		return classPersistente;
	}

	@SuppressWarnings("unchecked")
	public T getPorId(ID id, boolean lock) {
		T entity;
		;
		if (lock)
			entity = (T) getSession().load(getPersistentClass(), id,
					LockMode.UPGRADE);
		else
			entity = (T) getSession().load(getPersistentClass(), id);

		return entity;
	}

	public List<T> getTodos() {
		return getPorConsulta();
	}

	public T persistir(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	public void atualizar() {
		getSession().flush();
	}
	
	public void commit() {
		getSession().getTransaction().commit();
	}

	public void limpar() {
		getSession().clear();
	}

	@SuppressWarnings("unchecked")
	protected List<T> getPorConsulta(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}

		Class<T> type = getPersistentClass();
//		if(!type.isInstance(new Usuario()) && !type.isInstance(new Atendimento()) && !type.isInstance(new Endereco())){
//			crit.addOrder(Order.desc("id"));
//		}
		
		List<T> results = crit.list();
		return results;
	}

	public void remover(T entity) {
		getSession().delete(entity);
	}

}
