package dados.hibernate.conteudo;

import java.util.ArrayList;
import java.util.List;

import model.curso.Curso;
import model.curso.EstudoDeCaso;
import model.curso.matricula.MatriculaCursoAluno;
import model.curso.matricula.arcomaguerez.ArcoMaguerezEstudoDeCaso;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import dados.basicas.ArcoMaguerezDAO;
import dados.hibernate.DAOGenericoHibernate;

public class ArcoMaguerezHibernateDAO extends DAOGenericoHibernate<ArcoMaguerezEstudoDeCaso, Integer>
		implements ArcoMaguerezDAO {

	@Override
	public ArcoMaguerezEstudoDeCaso getArcoMaguerezPorMatriculaCursoEstudoCaso(
			MatriculaCursoAluno matricula, EstudoDeCaso estudo) {
		ArcoMaguerezEstudoDeCaso  retorno = null;

		Criteria crit = getSession().createCriteria(ArcoMaguerezEstudoDeCaso.class).createAlias("matriculaAluno", "mat");
		crit.add(Restrictions.eq("mat.id", matricula.getId()));
		crit.add(Restrictions.eq("mat.aluno", matricula.getAluno()));
		crit.add(Restrictions.eq("estudoDeCaso", estudo));
		
		retorno =  (ArcoMaguerezEstudoDeCaso) crit.uniqueResult();

		return retorno;
	}

	@Override
	public List<ArcoMaguerezEstudoDeCaso> buscarArcosMaguerezPorCursoEAluno(MatriculaCursoAluno matricula, Curso curso) {
		List<ArcoMaguerezEstudoDeCaso>  retorno = new ArrayList<ArcoMaguerezEstudoDeCaso>();

		Criteria crit = getSession().createCriteria(ArcoMaguerezEstudoDeCaso.class).createAlias("estudoDeCaso", "ec").createAlias("matriculaAluno", "mat");
		crit.add(Restrictions.eq("ec.curso", curso));
		
		crit.add(Restrictions.eq("mat.id", matricula.getId()));
		crit.add(Restrictions.eq("mat.aluno", matricula.getAluno()));
		
		crit.addOrder(Order.desc("id"));
		retorno = crit.list();

		return retorno;
	}
		
}
