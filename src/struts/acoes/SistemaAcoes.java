package struts.acoes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.curso.Curso;
import model.sistema.Erro;
import model.usuario.Administrador;
import model.usuario.Aluno;
import model.usuario.Professor;
import model.usuario.TipoUsuario;
import model.usuario.Usuario;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import util.MainPopulaBD;
import fachada.Fachada;

public class SistemaAcoes extends DispatchAction {

	
	private static final String fHOME = "fLogon";
	private static final String fINDEXALUNO = "fIndexAluno";
	private static final String fINDEXADMIN = "fIndexAdmin";
	private static final String fINDEXPROFESSOR = "fIndexProfessor";
	private static final String fERROR = "fError";

	private Fachada fachada;
	
	public SistemaAcoes(){
		fachada = Fachada.getInstancia();
	}
	
	public ActionForward logon(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionMessages errors = new ActionMessages();
		ActionForward retorno = null;
		
		String login = ((DynaActionForm)form).getString("loginUsuario");
		String senha = ((DynaActionForm)form).getString("senhaUsuario");
		
		try{
			Object objUsuario = fachada.autenticar(login);
			
			Usuario usuario = (Usuario) objUsuario;
			
			boolean valida = true;
			
			if(usuario!= null && (usuario.getTipoUsuario().equals(TipoUsuario.ALUNO))){
				if(usuario.getSenha().equals(senha)){
					retorno = map.findForward(fINDEXALUNO);
					Aluno aluno = (Aluno) objUsuario;
					request.getSession().setAttribute("usuario", aluno);
				}else{
					valida = false;
				}
			}else if(usuario!= null && usuario.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR)){
				if(usuario.getSenha().equals(senha)){
					retorno = map.findForward(fINDEXADMIN);
					Administrador admin = (Administrador) objUsuario;
					request.getSession().setAttribute("usuario", admin);
				}else{
					valida = false;
				}
			}else if(usuario!= null && usuario.getTipoUsuario().equals(TipoUsuario.PROFESSOR)){
				if(usuario.getSenha().equals(senha)){
					retorno = map.findForward(fINDEXPROFESSOR);
					Professor professor = (Professor) objUsuario;
					request.getSession().setAttribute("usuario", professor);
				}else{
					valida = false;
				}
			}
			
			if(!valida || usuario == null){
				request.setAttribute("mensagem", "Login ou senha inválido");
				retorno = map.findForward(fHOME);
			}
		}catch (Exception e) {
			e.printStackTrace();
			errors.add("AuthenticationException", new ActionMessage("erro.autenticacao"));
			this.saveErrors(request, errors);
			retorno = map.findForward(fHOME);
		}
		
		return retorno;
	}
	
	public ActionForward mostrarTelaLogon(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		return map.findForward(fHOME);
	}
	
	public ActionForward logoff(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("usuario", null);
		return map.findForward(fHOME);
	}
	
	public ActionForward error(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("usuario", null);
		return map.findForward(fERROR);
	}
	
	public ActionForward reportarBug(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getSession().getAttribute("erroMsg") != null){
			Erro erro = new Erro();
			erro.setStackTrace((String) request.getSession().getAttribute("erroMsg"));
			fachada.reportarBug(erro);
			request.getSession().setAttribute("erroMsg", "Bug reportado com sucesso!");
		}
		request.getSession().setAttribute("usuario", null);
		return map.findForward(fERROR);
		
	}
	
	public ActionForward gerarbd(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		Configuration cfg = new AnnotationConfiguration().configure();
		SchemaExport schemaExport = new SchemaExport(cfg);
		schemaExport.create(true,true);
		
		MainPopulaBD.execMainPopulaBD();
		MainPopulaBD.execPopulaMateriais();
		MainPopulaBD.execCriarArqvsCurso();
		MainPopulaBD.execCadastrarEstudosDeCasos();
		MainPopulaBD.execCadastrarDeterminateHiposteses();
		
		ActionMessages errors = new ActionMessages();
		errors.add("AuthenticationException", new ActionMessage("gerar.bd"));
		this.saveErrors(request, errors);
		
		return map.findForward(fHOME);
	}
	
	
	
	
}
