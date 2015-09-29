package dados;

import dados.basicas.AdministradorDAO;
import dados.basicas.AlunoDAO;
import dados.basicas.ArcoMaguerezDAO;
import dados.basicas.ArquivoDAO;
import dados.basicas.AvaliacaoDAO;
import dados.basicas.AvaliacaoProfessorDAO;
import dados.basicas.CursoDAO;
import dados.basicas.DiagnosticoDAO;
import dados.basicas.EnderecoDAO;
import dados.basicas.ErroDAO;
import dados.basicas.EstudoDeCasoDAO;
import dados.basicas.ImplementacaoDAO;
import dados.basicas.MatriculaCursoAlunoDAO;
import dados.basicas.NandaDAO;
import dados.basicas.PlanejamentoDAO;
import dados.basicas.ProfessorDAO;
import dados.basicas.ResultadosEsperadosDAO;
import dados.basicas.UsuarioDAO;

public abstract class FabricaDAO {

	 @SuppressWarnings("unchecked")
		public static final Class HIBERNATE = dados.hibernate.FabricaHibernateDAO.class;

	    @SuppressWarnings("unchecked")
		public static FabricaDAO instance(Class factory) {
	        try {
	            return (FabricaDAO)factory.newInstance();
	        } catch (Exception ex) {
	            throw new RuntimeException("Não foi possível criar a fábrica DAO: " + factory);
	        }
	    }
	    
	    public abstract AlunoDAO getAlunoDAO();
	    public abstract AdministradorDAO getAdministradorDAO();
	    public abstract ProfessorDAO getProfessorDAO();
	    public abstract EnderecoDAO getEnderecoDAO();
	    public abstract NandaDAO getCipeDAO();
	    public abstract UsuarioDAO getUsuarioDAO();
	    public abstract CursoDAO getCursoDAO();
		public abstract ErroDAO getErroDAO();
		public abstract MatriculaCursoAlunoDAO getMatriculaCursoAlunoDAO();
		public abstract ArquivoDAO getArquivoDAO();
		public abstract EstudoDeCasoDAO getEstudoDeCasoDAO();
		public abstract ArcoMaguerezDAO getArcoMaguerezDAO();
		public abstract PlanejamentoDAO getPontosChaveDAO();
		public abstract ImplementacaoDAO getTeorizacaoDAO();
		public abstract DiagnosticoDAO getDiagnosticoDAO();
		public abstract AvaliacaoDAO getAplicacaoDAO();
		public abstract ResultadosEsperadosDAO getHipotesesDeSolucaoDAO();
		public abstract AvaliacaoProfessorDAO getAvaliacaoProfessorDAO();
}
