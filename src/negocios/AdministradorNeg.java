package negocios;

import java.util.Date;
import java.util.List;

import model.Endereco;
import model.usuario.Administrador;
import dados.FabricaDAO;
import dados.basicas.EnderecoDAO;
import dados.basicas.AdministradorDAO;
import dados.hibernate.FabricaHibernateDAO;

public class AdministradorNeg {

	private FabricaDAO fabrica = new FabricaHibernateDAO();
	public static AdministradorNeg instancia;

	public AdministradorNeg() {
		fabrica = FabricaHibernateDAO.getInstancia();
	}

	public static AdministradorNeg getInstancia() {
		if (AdministradorNeg.instancia == null) {
			AdministradorNeg.instancia = new AdministradorNeg();
		}
		return AdministradorNeg.instancia;
	}

	public Administrador criarUsuarioAdministrador(Administrador enfer) {
		Endereco endereco = enfer.getEndereco();
		endereco = criarEndereco(endereco);
		enfer.setDataCriacao(new Date());
		enfer.setDataCriacao(new Date());

		enfer.setEndereco(endereco);

		AdministradorDAO dao = this.fabrica.getAdministradorDAO();

		enfer = dao.persistir(enfer);
		if (enfer == null) {
			removerEndereco(endereco);
		}
		return enfer;
	}

	public void removerAdministrador(Administrador administrador) {
		AdministradorDAO dao = this.fabrica.getAdministradorDAO();
		dao.remover(administrador);
	}

	public Administrador buscarPorId(int id, boolean lock) {
		AdministradorDAO dao = this.fabrica.getAdministradorDAO();
		return dao.getPorId(id, lock);
	}

	public List<Administrador> getTodos() {
		AdministradorDAO dao = this.fabrica.getAdministradorDAO();
		return dao.getTodos();
	}
	
	/** M�todos Privados */
	private Endereco criarEndereco(Endereco end) {

		EnderecoDAO dao = this.fabrica.getEnderecoDAO();
		return dao.persistir(end);
	}

	private void removerEndereco(Endereco end) {

		EnderecoDAO dao = this.fabrica.getEnderecoDAO();
		dao.remover(end);
	}
}
