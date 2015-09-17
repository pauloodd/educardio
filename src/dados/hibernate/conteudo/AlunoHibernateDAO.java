package dados.hibernate.conteudo;

import model.usuario.Aluno;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import dados.basicas.AlunoDAO;
import dados.hibernate.DAOGenericoHibernate;

public class AlunoHibernateDAO extends DAOGenericoHibernate<Aluno, Integer>
		implements AlunoDAO {

	public Aluno getAlunoPorLogin(String login) {
		
		Aluno retorno = null;

		Criteria crit = getSession().createCriteria(Aluno.class);
		crit.add(Restrictions.eq("login", login));
		retorno = (Aluno) crit.uniqueResult();

		return retorno;
	}
	
}
