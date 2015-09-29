package dados.hibernate.conteudo;

import java.util.ArrayList;
import java.util.List;

import model.Nanda;
import model.curso.Curso;
import model.curso.matricula.MatriculaCursoAluno;
import model.curso.matricula.arcomaguerez.ArcoMaguerezEstudoDeCaso;
import model.usuario.Aluno;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import dados.basicas.MatriculaCursoAlunoDAO;
import dados.hibernate.DAOGenericoHibernate;

public class MatriculaAlunoCursoHibernateDAO extends
		DAOGenericoHibernate<MatriculaCursoAluno, Integer> implements MatriculaCursoAlunoDAO {
	
	@Override
	public List<MatriculaCursoAluno> getTodasMatriculasAluno(Aluno aluno) {
		List<MatriculaCursoAluno>  retorno = null;

		Query query = getSession().createQuery("FROM MatriculaCursoAluno WHERE aluno.id = :alunoId ")
			    .setParameter("alunoId", aluno.getId());
		
		retorno = query.list();
//		crit.setProjection(Projections.groupProperty("curso.id"));
		
		return retorno;
	}

	@Override
	public List<Curso> getTodosCursosDisponiveisEAndamentoDiferentesDeMatriculado(List<MatriculaCursoAluno> matriculas) {
		List<Curso>  retorno = null;

		List<Integer> listIds = new ArrayList<Integer>();
		for (MatriculaCursoAluno matric : matriculas) {
			listIds.add(matric.getCurso().getId());
		}

		Query query = getSession().createQuery("FROM Curso WHERE id not in (:list) and (status = :disponivel OR status = :andamento)")
			    .setParameterList("list", listIds)
			    .setParameter("disponivel", Curso.PREVISTO)
			    .setParameter("andamento", Curso.ANDAMENTO);
		
		retorno = query.list();
		
		return retorno;
	}

	@Override
	public List<ArcoMaguerezEstudoDeCaso> getTodasArcoMaguerezEstudoDeCasoPorCurso(Curso curso) {
		List<ArcoMaguerezEstudoDeCaso>  retorno = null;

		Criteria crit = getSession().createCriteria(ArcoMaguerezEstudoDeCaso.class).createAlias("estudoDeCaso", "estudo");
		crit.add(Restrictions.eq("estudo.curso", curso));
		
		retorno = crit.list();
		
		return retorno;
	}
	
	//
	
	

}
