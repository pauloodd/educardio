package dados.hibernate.conteudo;

import java.util.List;

import model.usuario.Usuario;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import dados.basicas.UsuarioDAO;
import dados.hibernate.DAOGenericoHibernate;

public class UsuarioHibernateDAO extends DAOGenericoHibernate<Usuario, Integer>
		implements UsuarioDAO {

	@Override
	public List<Usuario> getUsuariosPorConsulta(String tipo, String valor) {
		Criteria crit = getSession().createCriteria(Usuario.class);
		if(tipo != null && !valor.equals("")){
				if(tipo.equals("login")){
					crit.add(Restrictions.eq("login", valor));
				}else if(tipo.equals("cpf")){
					crit.add(Restrictions.eq("cpf", valor));
  				}else if(tipo.equals("nome")){
					crit.add(Restrictions.ilike("nome", "%"+valor+"%"));
				} 
				
		}
		return crit.list();
	}
	
		
}
