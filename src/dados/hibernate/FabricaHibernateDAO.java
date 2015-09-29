package dados.hibernate;

import org.hibernate.Session;

import dados.FabricaDAO;
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
import dados.hibernate.conteudo.AdministradorHibernateDAO;
import dados.hibernate.conteudo.AlunoHibernateDAO;
import dados.hibernate.conteudo.ArcoMaguerezHibernateDAO;
import dados.hibernate.conteudo.ArquivoHibernateDAO;
import dados.hibernate.conteudo.AvaliacaoHibernateDAO;
import dados.hibernate.conteudo.AvaliacaoProfessorHibernateDAO;
import dados.hibernate.conteudo.CursoHibernateDAO;
import dados.hibernate.conteudo.DiagnosticoHibernateDAO;
import dados.hibernate.conteudo.EnderecoHibernateDAO;
import dados.hibernate.conteudo.ErroHibernateDAO;
import dados.hibernate.conteudo.EstudoDeCasoHibernateDAO;
import dados.hibernate.conteudo.ImplementacaoHibernateDAO;
import dados.hibernate.conteudo.MatriculaAlunoCursoHibernateDAO;
import dados.hibernate.conteudo.NandaHibernateDAO;
import dados.hibernate.conteudo.PlanejamentoHibernateDAO;
import dados.hibernate.conteudo.ProfessorHibernateDAO;
import dados.hibernate.conteudo.ResultadosEsperadosHibernateDAO;
import dados.hibernate.conteudo.UsuarioHibernateDAO;

public class FabricaHibernateDAO extends FabricaDAO{
	
	public static FabricaHibernateDAO instancia;
	
	public static FabricaHibernateDAO getInstancia(){
		if(FabricaHibernateDAO.instancia == null){
			FabricaHibernateDAO.instancia = new FabricaHibernateDAO();
		}
		return FabricaHibernateDAO.instancia;
	}
	
	@SuppressWarnings("unchecked")
    private DAOGenericoHibernate instanciarDAO(Class daoClass) {
        try {
        	DAOGenericoHibernate dao = (DAOGenericoHibernate) daoClass.newInstance();
            dao.setSession(getCurrentSession());
            return dao;
        } catch (Exception ex) {
            throw new RuntimeException("Não foi possível instanciar o DAO: " + daoClass, ex);
        }
	}
	
	protected Session getCurrentSession() {
        return HibernateUtil.getFabricaDeSessao().getCurrentSession();
    }
	
	@Override
	public EnderecoDAO getEnderecoDAO() {
		return (EnderecoDAO) this.instanciarDAO(EnderecoHibernateDAO.class);
	}

	@Override
	public AlunoDAO getAlunoDAO() {
		return (AlunoDAO) this.instanciarDAO(AlunoHibernateDAO.class);
	}
	
	@Override
	public AdministradorDAO getAdministradorDAO() {
		return (AdministradorDAO) this.instanciarDAO(AdministradorHibernateDAO.class);
	}
	
	@Override
	public ProfessorDAO getProfessorDAO() {
		return (ProfessorDAO) this.instanciarDAO(ProfessorHibernateDAO.class);
	}
	
	@Override
	public UsuarioDAO getUsuarioDAO() {
		return (UsuarioDAO) this.instanciarDAO(UsuarioHibernateDAO.class);
	}
	
	@Override
	public CursoDAO getCursoDAO() {
		return (CursoDAO) this.instanciarDAO(CursoHibernateDAO.class);
	}

	@Override
	public ErroDAO getErroDAO() {
		return (ErroDAO) this.instanciarDAO(ErroHibernateDAO.class);
	}

	@Override
	public MatriculaCursoAlunoDAO getMatriculaCursoAlunoDAO() {
		return (MatriculaCursoAlunoDAO) this.instanciarDAO(MatriculaAlunoCursoHibernateDAO.class);
	}

	@Override
	public ArquivoDAO getArquivoDAO() {
		return (ArquivoDAO) this.instanciarDAO(ArquivoHibernateDAO.class);
	}

	@Override
	public EstudoDeCasoDAO getEstudoDeCasoDAO() {
		return (EstudoDeCasoDAO) this.instanciarDAO(EstudoDeCasoHibernateDAO.class);
	}

	@Override
	public ArcoMaguerezDAO getArcoMaguerezDAO() {
		return (ArcoMaguerezDAO) this.instanciarDAO(ArcoMaguerezHibernateDAO.class);
	}

	@Override
	public PlanejamentoDAO getPontosChaveDAO() {
		return (PlanejamentoDAO) this.instanciarDAO(PlanejamentoHibernateDAO.class);
	}

	@Override
	public ImplementacaoDAO getTeorizacaoDAO() {
		return (ImplementacaoDAO) this.instanciarDAO(ImplementacaoHibernateDAO.class);
	}

	@Override
	public NandaDAO getCipeDAO() {
		return (NandaDAO) this.instanciarDAO(NandaHibernateDAO.class);
	}

	@Override
	public DiagnosticoDAO getDiagnosticoDAO() {
		return (DiagnosticoDAO) this.instanciarDAO(DiagnosticoHibernateDAO.class);
	}

	@Override
	public AvaliacaoDAO getAplicacaoDAO() {
		return (AvaliacaoDAO) this.instanciarDAO(AvaliacaoHibernateDAO.class);
	}

	@Override
	public ResultadosEsperadosDAO getHipotesesDeSolucaoDAO() {
		return (ResultadosEsperadosDAO) this.instanciarDAO(ResultadosEsperadosHibernateDAO.class);
	}

	@Override
	public AvaliacaoProfessorDAO getAvaliacaoProfessorDAO() {
		return (AvaliacaoProfessorDAO) this.instanciarDAO(AvaliacaoProfessorHibernateDAO.class);
	}
		
}
