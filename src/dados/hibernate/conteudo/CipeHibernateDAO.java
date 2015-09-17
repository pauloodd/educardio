package dados.hibernate.conteudo;

import java.util.List;

import model.Cipe;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import dados.basicas.CipeDAO;
import dados.hibernate.DAOGenericoHibernate;

public class CipeHibernateDAO extends DAOGenericoHibernate<Cipe, Integer>
		implements CipeDAO {

	@Override
	public List<Cipe> pesquisarCipe(String query, String eixo) {
		
		Criteria crit = getSession().createCriteria(Cipe.class);
		if(eixo != null && !eixo.equals("")){
			crit.add(Restrictions.eq("eixo", eixo));
		}
		if(query != null && !query.equals("")){
			crit.add(Restrictions.ilike("termo", "%"+query+"%"));		
		}
		crit.addOrder(Order.asc("termo"));

		return crit.list();
	}

	
	
		
}
