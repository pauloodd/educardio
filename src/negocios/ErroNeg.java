package negocios;

import java.util.Date;
import java.util.List;

import model.sistema.Erro;
import dados.FabricaDAO;
import dados.basicas.ErroDAO;
import dados.hibernate.FabricaHibernateDAO;

public class ErroNeg {

	private static ErroNeg instancia;
	private FabricaDAO fabrica;
	
	private ErroNeg() {
		fabrica = FabricaHibernateDAO.getInstancia();
	}
	
	public static ErroNeg getInstancia(){
		if(ErroNeg.instancia == null){
			ErroNeg.instancia = new ErroNeg();
		}
		return ErroNeg.instancia;
	}
	
	public List<Erro> getTodos(){
		ErroDAO dao = fabrica.getErroDAO();
		return dao.getTodos();
	}
	
	public Erro getPorId(int id){
		ErroDAO dao = fabrica.getErroDAO();
		return dao.getPorId(id, true);
	}
	
	public void reportarBug(Erro erro){
		
		erro.setDataHora(new Date());
		
		ErroDAO dao = this.fabrica.getErroDAO();
		
		erro = dao.persistir(erro);
	}
	
	
}
