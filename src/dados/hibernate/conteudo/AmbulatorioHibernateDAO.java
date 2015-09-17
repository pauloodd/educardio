package dados.hibernate.conteudo;

import model.curso.matricula.ambulatorio.Ambulatorio;

import org.hibernate.SQLQuery;

import dados.basicas.AmbulatorioDAO;
import dados.hibernate.DAOGenericoHibernate;

public class AmbulatorioHibernateDAO extends
		DAOGenericoHibernate<Ambulatorio, Integer> implements AmbulatorioDAO {

	@Override
	public void removerTodosMateriasAmbulatorio(Ambulatorio ambulatorio) {
		
		
		SQLQuery query = getSession().createSQLQuery("DELETE FROM materiais_ambulatorio WHERE ambulatorioId = "+ambulatorio.getId());
		query.executeUpdate();
		
	}


}
