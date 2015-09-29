package dados.hibernate.conteudo;

import java.util.ArrayList;
import java.util.List;

import model.curso.EstudoDeCaso;
import model.curso.matricula.arcomaguerez.DiagnosticosImplementacoes;
import model.curso.matricula.arcomaguerez.ResultadosEsperados;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import dados.basicas.DiagnosticoDAO;
import dados.hibernate.DAOGenericoHibernate;

public class DiagnosticoHibernateDAO extends DAOGenericoHibernate<DiagnosticosImplementacoes, Integer>
		implements DiagnosticoDAO {

	@Override
	public List<DiagnosticosImplementacoes> buscarDiagnosticoPorEstudoDeCaso(
			EstudoDeCaso estudoDeCaso) {
		List<DiagnosticosImplementacoes>  retorno = new ArrayList<DiagnosticosImplementacoes>();

		Criteria crit = getSession().createCriteria(DiagnosticosImplementacoes.class).createAlias("determinante", "det");
		crit.add(Restrictions.eq("det.estudoDeCaso", estudoDeCaso));
		crit.addOrder(Order.desc("id"));
		retorno = crit.list();

		return retorno;
	}

	@Override
	public List<DiagnosticosImplementacoes> buscarDiagnosticoPorHipotesesDeSolucao(
			ResultadosEsperados hipotesesDeSolucao) {
		
		List<DiagnosticosImplementacoes>  retorno = new ArrayList<DiagnosticosImplementacoes>();
		Criteria crit = getSession().createCriteria(DiagnosticosImplementacoes.class);
		crit.add(Restrictions.eq("resultadosEsperados", hipotesesDeSolucao));
		crit.addOrder(Order.desc("id"));
		retorno = crit.list();

		return retorno;
	}

}
