package dados.hibernate.conteudo;

import java.util.List;

import model.curso.Curso;
import model.curso.DeterminanteHipoteses;
import model.curso.EstudoDeCaso;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import dados.basicas.EstudoDeCasoDAO;
import dados.hibernate.DAOGenericoHibernate;

public class EstudoDeCasoHibernateDAO extends DAOGenericoHibernate<EstudoDeCaso, Integer>
		implements EstudoDeCasoDAO {

	@Override
	public List<EstudoDeCaso> listarEstudosDeCasosPorCurso(Curso curso) {
		List<EstudoDeCaso>  retorno = null;

		Criteria crit = getSession().createCriteria(EstudoDeCaso.class);
		crit.add(Restrictions.eq("curso", curso));
		
		retorno =  crit.list();

		return retorno;
	}

	@Override
	public List<DeterminanteHipoteses> buscarDeterminantesHipotesesPorEstudoCaso(
			EstudoDeCaso estudoDeCaso) {
		List<DeterminanteHipoteses> retorno = null;
		
		Criteria crit = getSession().createCriteria(DeterminanteHipoteses.class);
		crit.add(Restrictions.eq("estudoDeCaso", estudoDeCaso));
		
		retorno =  crit.list();
		
		
		return retorno;
	}

	
	
		
}
