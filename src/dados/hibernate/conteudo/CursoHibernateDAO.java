package dados.hibernate.conteudo;

import java.util.List;

import model.curso.Curso;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import dados.basicas.CursoDAO;
import dados.hibernate.DAOGenericoHibernate;

public class CursoHibernateDAO extends
		DAOGenericoHibernate<Curso, Integer> implements CursoDAO {

	@Override
	public List<Curso> getTodosCursosPorStatus(int ... status) {
		List<Curso>  retorno = null;

		Criteria crit = getSession().createCriteria(Curso.class);
		
		 Disjunction disjunction = Restrictions.disjunction();
		 for (int i = 0; i < status.length; i++) {
			 disjunction.add(Restrictions.eq("status", status[i]));
		}
		 if(disjunction != null){
			 crit.add(disjunction);
		 }
		retorno =  crit.list();

		return retorno;
	}

}
