package dados.hibernate.conteudo;

import model.Endereco;
import dados.basicas.EnderecoDAO;
import dados.hibernate.DAOGenericoHibernate;

public class EnderecoHibernateDAO extends
		DAOGenericoHibernate<Endereco, Integer> implements EnderecoDAO {

}
