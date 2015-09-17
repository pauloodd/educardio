package dados.hibernate.conteudo;

import java.util.List;

import model.curso.matricula.ambulatorio.Material;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import dados.basicas.MaterialDAO;
import dados.hibernate.DAOGenericoHibernate;

public class MaterialHibernateDAO extends
		DAOGenericoHibernate<Material, Integer> implements MaterialDAO {

	@Override
	public List<Material> getTodosMateriaisPorTipo(int... tipos) {
		List<Material>  retorno = null;

		Criteria crit = getSession().createCriteria(Material.class);
		
		 Disjunction disjunction = Restrictions.disjunction();
		 for (int i = 0; i < tipos.length; i++) {
			 disjunction.add(Restrictions.eq("tipoMaterial", tipos[i]));
		}
		 if(disjunction != null){
			 crit.add(disjunction);
		 }
		retorno =  crit.list();

		return retorno;
	}


}
