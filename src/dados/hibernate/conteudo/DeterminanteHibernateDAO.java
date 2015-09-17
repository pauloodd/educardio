package dados.hibernate.conteudo;

import java.util.ArrayList;
import java.util.List;

import model.curso.matricula.arcomaguerez.Determinante;
import model.curso.matricula.arcomaguerez.PontosChave;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;

import dados.basicas.DeterminanteDAO;
import dados.hibernate.DAOGenericoHibernate;

public class DeterminanteHibernateDAO extends DAOGenericoHibernate<Determinante, Integer>
		implements DeterminanteDAO {

	@Override
	public List<Determinante> buscarDeterminantePorPontoChave(
			PontosChave pontosChave) {

		List<Determinante>  retorno = new ArrayList<Determinante>();

		Criteria crit = getSession().createCriteria(Determinante.class);
		crit.add(Restrictions.eq("pontosChave", pontosChave));
		retorno = crit.list();

		return retorno;
	}

	@Override
	public void removerDeterminantesPontosChave(PontosChave ptsChave) {
		SQLQuery query = getSession().createSQLQuery("DELETE FROM determinante WHERE fk_idPontosChave = "+ptsChave.getId());
		query.executeUpdate();
	}

	
	
		
}
