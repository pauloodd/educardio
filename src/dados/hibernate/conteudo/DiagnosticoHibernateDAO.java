package dados.hibernate.conteudo;

import java.util.ArrayList;
import java.util.List;

import model.curso.EstudoDeCaso;
import model.curso.matricula.arcomaguerez.Diagnostico;
import model.curso.matricula.arcomaguerez.HipotesesDeSolucao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import dados.basicas.DiagnosticoDAO;
import dados.hibernate.DAOGenericoHibernate;

public class DiagnosticoHibernateDAO extends DAOGenericoHibernate<Diagnostico, Integer>
		implements DiagnosticoDAO {

	@Override
	public List<Diagnostico> buscarDiagnosticoPorEstudoDeCaso(
			EstudoDeCaso estudoDeCaso) {
		List<Diagnostico>  retorno = new ArrayList<Diagnostico>();

		Criteria crit = getSession().createCriteria(Diagnostico.class).createAlias("determinante", "det");
		crit.add(Restrictions.eq("det.estudoDeCaso", estudoDeCaso));
		crit.addOrder(Order.desc("id"));
		retorno = crit.list();

		return retorno;
	}

	@Override
	public List<Diagnostico> buscarDiagnosticoPorHipotesesDeSolucao(
			HipotesesDeSolucao hipotesesDeSolucao) {
		
		List<Diagnostico>  retorno = new ArrayList<Diagnostico>();
		Criteria crit = getSession().createCriteria(Diagnostico.class);
		crit.add(Restrictions.eq("hipotesesDeSolucao", hipotesesDeSolucao));
		crit.addOrder(Order.desc("id"));
		retorno = crit.list();

		return retorno;
	}

}
