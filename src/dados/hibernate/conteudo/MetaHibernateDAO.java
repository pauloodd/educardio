package dados.hibernate.conteudo;

import org.hibernate.SQLQuery;

import model.curso.matricula.arcomaguerez.Diagnostico;
import model.curso.matricula.arcomaguerez.Meta;
import dados.basicas.MetaDAO;
import dados.hibernate.DAOGenericoHibernate;

public class MetaHibernateDAO extends DAOGenericoHibernate<Meta, Integer>
		implements MetaDAO {

	@Override
	public void removerMetasDeDiagnostico(Diagnostico diagnostico) {
		SQLQuery query = getSession().createSQLQuery("DELETE FROM meta WHERE fk_idDiagnostico= "+diagnostico.getId());
		query.executeUpdate();
	}

	@Override
	public void removerMeta(Meta meta) {
		SQLQuery query = getSession().createSQLQuery("DELETE FROM meta WHERE id = "+meta.getId());
		query.executeUpdate();
	}


}
