package negocios;

import java.util.Date;
import java.util.List;

import model.Endereco;
import model.usuario.Professor;
import dados.FabricaDAO;
import dados.basicas.EnderecoDAO;
import dados.basicas.ProfessorDAO;
import dados.hibernate.FabricaHibernateDAO;

public class ProfessorNeg {

	private FabricaDAO fabrica = new FabricaHibernateDAO();
	public static ProfessorNeg instancia;

	public ProfessorNeg() {
		fabrica = FabricaHibernateDAO.getInstancia();
	}

	public static ProfessorNeg getInstancia() {
		if (ProfessorNeg.instancia == null) {
			ProfessorNeg.instancia = new ProfessorNeg();
		}
		return ProfessorNeg.instancia;
	}

	public Professor criarUsuarioProfessor(Professor prof) {
		Endereco endereco = prof.getEndereco();
		endereco = criarEndereco(endereco);
		prof.setDataCriacao(new Date());
		prof.setDataCriacao(new Date());

		prof.setEndereco(endereco);

		ProfessorDAO dao = this.fabrica.getProfessorDAO();

		prof = dao.persistir(prof);
		if (prof == null) {
			removerEndereco(endereco);
		}
		return prof;
	}

	public void removerProfessor(Professor professor) {
		ProfessorDAO dao = this.fabrica.getProfessorDAO();
		dao.remover(professor);
	}

	public Professor buscarPorId(int id, boolean lock) {
		ProfessorDAO dao = this.fabrica.getProfessorDAO();
		return dao.getPorId(id, lock);
	}

	public List<Professor> getTodos() {
		ProfessorDAO dao = this.fabrica.getProfessorDAO();
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
