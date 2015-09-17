package dados.hibernate.conteudo;

import org.hibernate.SQLQuery;

import model.curso.matricula.arcomaguerez.Diagnostico;
import model.curso.matricula.arcomaguerez.Intervencao;
import model.curso.matricula.arcomaguerez.Meta;
import dados.basicas.IntervencaoDAO;
import dados.hibernate.DAOGenericoHibernate;

public class IntervencaoHibernateDAO extends DAOGenericoHibernate<Intervencao, Integer>
		implements IntervencaoDAO {

	@Override
	public void removerIntervencao(Intervencao intervencao) {
		SQLQuery query = getSession().createSQLQuery("DELETE FROM intervencao WHERE id = "+intervencao.getId());
		query.executeUpdate();
	}

	@Override
	public void removerIntervencoesDiagnostico(Diagnostico diagnostico) {
		SQLQuery query = getSession().createSQLQuery("delete inter.* from intervencao inter " +
				"inner join meta meta on meta.id = inter.fk_idMeta " +
				"inner join diagnostico dig on dig.id = meta.fk_idDiagnostico where fk_idDiagnostico = "+diagnostico.getId());
		query.executeUpdate();
	}

	@Override
	public void removerIntervencoesMeta(Meta meta) {
		SQLQuery query = getSession().createSQLQuery("delete from intervencao where fk_idMeta  = "+meta.getId());
		query.executeUpdate();
	}

	
	
		
}
