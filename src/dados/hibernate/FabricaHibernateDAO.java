package dados.hibernate;

import org.hibernate.Session;

import dados.FabricaDAO;
import dados.basicas.AdministradorDAO;
import dados.basicas.AlunoDAO;
import dados.basicas.AmbulatorioDAO;
import dados.basicas.AplicacaoDAO;
import dados.basicas.ArcoMaguerezDAO;
import dados.basicas.ArquivoDAO;
import dados.basicas.AvaliacaoProfessorDAO;
import dados.basicas.CipeDAO;
import dados.basicas.CursoDAO;
import dados.basicas.DeterminanteDAO;
import dados.basicas.DeterminanteHipotesesDAO;
import dados.basicas.DiagnosticoDAO;
import dados.basicas.EnderecoDAO;
import dados.basicas.ErroDAO;
import dados.basicas.EstudoDeCasoDAO;
import dados.basicas.HipotesesDeSolucaoDAO;
import dados.basicas.IntervencaoDAO;
import dados.basicas.MaterialDAO;
import dados.basicas.MatriculaCursoAlunoDAO;
import dados.basicas.MetaDAO;
import dados.basicas.PontosChaveDAO;
import dados.basicas.ProfessorDAO;
import dados.basicas.TeorizacaoDAO;
import dados.basicas.UsuarioDAO;
import dados.hibernate.conteudo.AdministradorHibernateDAO;
import dados.hibernate.conteudo.AlunoHibernateDAO;
import dados.hibernate.conteudo.AmbulatorioHibernateDAO;
import dados.hibernate.conteudo.AplicacaoHibernateDAO;
import dados.hibernate.conteudo.ArcoMaguerezHibernateDAO;
import dados.hibernate.conteudo.ArquivoHibernateDAO;
import dados.hibernate.conteudo.AvaliacaoProfessorHibernateDAO;
import dados.hibernate.conteudo.CipeHibernateDAO;
import dados.hibernate.conteudo.CursoHibernateDAO;
import dados.hibernate.conteudo.DeterminanteHibernateDAO;
import dados.hibernate.conteudo.DeterminanteHipotesesHibernateDAO;
import dados.hibernate.conteudo.DiagnosticoHibernateDAO;
import dados.hibernate.conteudo.EnderecoHibernateDAO;
import dados.hibernate.conteudo.ErroHibernateDAO;
import dados.hibernate.conteudo.EstudoDeCasoHibernateDAO;
import dados.hibernate.conteudo.HipotesesDeSolucaoHibernateDAO;
import dados.hibernate.conteudo.IntervencaoHibernateDAO;
import dados.hibernate.conteudo.MaterialHibernateDAO;
import dados.hibernate.conteudo.MatriculaAlunoCursoHibernateDAO;
import dados.hibernate.conteudo.MetaHibernateDAO;
import dados.hibernate.conteudo.PontosChaveHibernateDAO;
import dados.hibernate.conteudo.ProfessorHibernateDAO;
import dados.hibernate.conteudo.TeorizacaoHibernateDAO;
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
	public AmbulatorioDAO getAmbulatorioDAO() {
		return (AmbulatorioDAO) this.instanciarDAO(AmbulatorioHibernateDAO.class);
	}

	@Override
	public MaterialDAO getMaterialDAO() {
		return (MaterialDAO) this.instanciarDAO(MaterialHibernateDAO.class);
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
	public PontosChaveDAO getPontosChaveDAO() {
		return (PontosChaveDAO) this.instanciarDAO(PontosChaveHibernateDAO.class);
	}

	@Override
	public TeorizacaoDAO getTeorizacaoDAO() {
		return (TeorizacaoDAO) this.instanciarDAO(TeorizacaoHibernateDAO.class);
	}

	@Override
	public DeterminanteDAO getDeterminanteDAO() {
		return (DeterminanteDAO) this.instanciarDAO(DeterminanteHibernateDAO.class);
	}

	@Override
	public CipeDAO getCipeDAO() {
		return (CipeDAO) this.instanciarDAO(CipeHibernateDAO.class);
	}

	@Override
	public DiagnosticoDAO getDiagnosticoDAO() {
		return (DiagnosticoDAO) this.instanciarDAO(DiagnosticoHibernateDAO.class);
	}

	@Override
	public DeterminanteHipotesesDAO getDeterminanteHipotesesDAO() {
		return (DeterminanteHipotesesDAO) this.instanciarDAO(DeterminanteHipotesesHibernateDAO.class);
	}

	@Override
	public MetaDAO getMetaDAO() {
		return (MetaDAO) this.instanciarDAO(MetaHibernateDAO.class);
	}

	@Override
	public IntervencaoDAO getIntervencaoDAO() {
		return (IntervencaoDAO) this.instanciarDAO(IntervencaoHibernateDAO.class);
	}

	@Override
	public AplicacaoDAO getAplicacaoDAO() {
		return (AplicacaoDAO) this.instanciarDAO(AplicacaoHibernateDAO.class);
	}

	@Override
	public HipotesesDeSolucaoDAO getHipotesesDeSolucaoDAO() {
		return (HipotesesDeSolucaoDAO) this.instanciarDAO(HipotesesDeSolucaoHibernateDAO.class);
	}

	@Override
	public AvaliacaoProfessorDAO getAvaliacaoProfessorDAO() {
		return (AvaliacaoProfessorDAO) this.instanciarDAO(AvaliacaoProfessorHibernateDAO.class);
	}
		
}
