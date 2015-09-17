package dados.hibernate.conteudo;

import model.usuario.Administrador;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import dados.basicas.AdministradorDAO;
import dados.hibernate.DAOGenericoHibernate;

public class AdministradorHibernateDAO extends
		DAOGenericoHibernate<Administrador, Integer> implements AdministradorDAO {

	public Administrador getAdministradorPorLogin(String login) {

		Administrador retorno = null;

		Criteria crit = getSession().createCriteria(Administrador.class);
		crit.add(Restrictions.eq("login", login));
		retorno = (Administrador) crit.uniqueResult();

		return retorno;
	}

}
