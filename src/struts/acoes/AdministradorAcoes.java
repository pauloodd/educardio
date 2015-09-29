package struts.acoes;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Nanda;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

import fachada.Fachada;

public class AdministradorAcoes extends DispatchAction {

	
	private static final String fADMINISTRADORLISTARCIPES = "fAdministradorListarCipes";

	private Fachada fachada;
	
	public AdministradorAcoes(){
		fachada = Fachada.getInstancia();
	}
	
	
	public ActionForward mostrarTelaListarCipes(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{
			List<Nanda> cipes = null;
			String acao = request.getParameter("acao");
			String foco = request.getParameter("foco");
			String termo = request.getParameter("termo-buscar");
			
			if(acao != null && !acao.equals("") && foco != null && !foco.equals("")){
				if(termo != null && !termo.equals("")){
					cipes = fachada.pesquisarCipe(termo ,null);
				}else{
					cipes = fachada.pesquisarCipe(null ,null);
				}
			}else if(acao != null && !acao.equals("") ){
				if(termo != null && !termo.equals("")){
					cipes = fachada.pesquisarCipe(termo ,"Acao");
				}else{
					cipes = fachada.pesquisarCipe(null ,"Acao");
				}
			}else if(foco != null && !foco.equals("")){
				if(termo != null && !termo.equals("")){
					cipes = fachada.pesquisarCipe(termo ,"Foco");
				}else{
					cipes = fachada.pesquisarCipe(null ,"Foco");
				}
			}else{
				cipes = fachada.pesquisarCipe(null ,null);
			}
			
			request.getSession().setAttribute("cipes", cipes);
			
		}catch(Exception ex){
			ex.printStackTrace();
			 request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
		return map.findForward(fADMINISTRADORLISTARCIPES);
	}
	
	public ActionForward adicionarCipe(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			
			String codigo = ((DynaActionForm)form).getString("codigo");
			String eixo = ((DynaActionForm)form).getString("eixo");
			String termo = ((DynaActionForm)form).getString("termo");
			String descricao = ((DynaActionForm)form).getString("descricao");
			String versao = ((DynaActionForm)form).getString("versao");
			
			Nanda cipeCadastrar = new Nanda(Integer.parseInt(codigo),termo, descricao,eixo,versao);
			Nanda cipe = fachada.cadastrarCipe(cipeCadastrar);
			
			 request.setAttribute("mensagem", "Nanda cadastrada com sucesso!");
			 
			 List<Nanda> cipes = fachada.pesquisarCipe(null ,null);
			 request.getSession().setAttribute("cipes", cipes);
		 }catch(Exception ex){
			 ex.printStackTrace();
			 request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
		return map.findForward(fADMINISTRADORLISTARCIPES);
	}
	
	public ActionForward editarCipe(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			
			String codigo = ((DynaActionForm)form).getString("codigo");
			String idCipe = ((DynaActionForm)form).getString("idCipe");
			String eixo = ((DynaActionForm)form).getString("eixo");
			String termo = ((DynaActionForm)form).getString("termo");
			String descricao = ((DynaActionForm)form).getString("descricao");
			String versao = ((DynaActionForm)form).getString("versao");
			
			Nanda cipeCadastrar = new Nanda(Integer.parseInt(idCipe), Integer.parseInt(codigo),termo, descricao,eixo,versao);
			Nanda cipe = fachada.editarCipe(cipeCadastrar);
			
			 request.setAttribute("mensagem", "Nanda editada com sucesso!");
			 
			 List<Nanda> cipes = fachada.pesquisarCipe(null ,null);
			 request.getSession().setAttribute("cipes", cipes);
		 }catch(Exception ex){
			 ex.printStackTrace();
			 request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
		return map.findForward(fADMINISTRADORLISTARCIPES);
	}
	
	public ActionForward removerCipe(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			
			String idCipe = request.getParameter("idCipe");
			if(idCipe != null && !idCipe.equals("")){
				Nanda cipe = new Nanda(Integer.parseInt(idCipe));
				fachada.removerCipe(cipe);
				request.setAttribute("mensagem", "Nanda removida com sucesso!");
				List<Nanda> cipes = fachada.pesquisarCipe(null ,null);
				request.getSession().setAttribute("cipes", cipes);
			}
			
		 }catch(Exception ex){
			 ex.printStackTrace();
			 request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
		return map.findForward(fADMINISTRADORLISTARCIPES);
	}
	
	
	
}
