package struts.acoes;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.curso.Curso;
import model.curso.EstudoDeCaso;
import model.curso.matricula.AvaliacaoProfessor;
import model.curso.matricula.arcomaguerez.ArcoMaguerezEstudoDeCaso;
import model.curso.matricula.arcomaguerez.ResultadosEsperados;
import model.curso.matricula.arcomaguerez.Planejamento;
import model.curso.matricula.arcomaguerez.Implementacao;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

import fachada.Fachada;

public class ProfessorAcoes extends DispatchAction {

	
	private static final String fPROFESSORLISTARCURSOS = "fProfessorListarCursos";
	private static final String fPROFESSORLISTARESTUDOSCASOS = "fProfessorListarEstudosCasos";

	private Fachada fachada;
	
	public ProfessorAcoes(){
		fachada = Fachada.getInstancia();
	}
	
	
	
	public ActionForward mostrarTelaListarCursos(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		List<Curso> cursos = fachada.getTodosCursos();
		request.getSession().setAttribute("cursos", cursos);
		
		return map.findForward(fPROFESSORLISTARCURSOS);
	}
	
	public ActionForward mostrarTelaListaEstudosDeCaso(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{
			String id = ((DynaActionForm)form).getString("idCurso");
			Curso curso = new Curso(Integer.parseInt(id));
			List<ArcoMaguerezEstudoDeCaso> arcosMaguerezAlunos = fachada.getTodasArcoMaguerezEstudoDeCasoPorCurso(curso);
			request.getSession().setAttribute("arcosMaguerezAlunos", arcosMaguerezAlunos);
			
			request.getSession().setAttribute("cursoId",id);
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
		
		return map.findForward(fPROFESSORLISTARESTUDOSCASOS);
	}
	
	public ActionForward adicionarMencaoArcoMaguerez(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			String idArcoMaguerez = ((DynaActionForm)form).getString("idArcoMaguerez");
			String pontosChaveComentarios = ((DynaActionForm)form).getString("pontos-chave-comentarios");
			String pontosChaveNota = ((DynaActionForm)form).getString("pontos-chave-nota");
			String teorizacaoComentarios = ((DynaActionForm)form).getString("resultadosEsperados-comentarios");
			String teorizacaoNota = ((DynaActionForm)form).getString("resultadosEsperados-nota");
			String hipotesesComentarios = ((DynaActionForm)form).getString("hipoteses-comentarios");
			String hipotesesNota = ((DynaActionForm)form).getString("hipoteses-nota");
			
			ArcoMaguerezEstudoDeCaso arcoMaguerez = fachada.getArcoMaguerezId(Integer.parseInt(idArcoMaguerez));
			Planejamento pontos = arcoMaguerez.getPlanejamento();
			AvaliacaoProfessor avaliacao = new AvaliacaoProfessor(pontosChaveNota, pontosChaveComentarios);
			if(arcoMaguerez.getPlanejamento().getAvaliacaoProfessor() != null){
				avaliacao = arcoMaguerez.getPlanejamento().getAvaliacaoProfessor();
				avaliacao.setComentario(pontosChaveComentarios);
				avaliacao.setNota(pontosChaveNota);
			}
			pontos.setAvaliacaoProfessor(avaliacao);
			
			AvaliacaoProfessor avaliacao2 = new AvaliacaoProfessor(teorizacaoNota, teorizacaoComentarios);
			if(arcoMaguerez.getImplementacao().getAvaliacaoProfessor() != null){
				avaliacao2 = arcoMaguerez.getImplementacao().getAvaliacaoProfessor();
				avaliacao2.setComentario(teorizacaoComentarios);
				avaliacao2.setNota(teorizacaoNota);
			}
			Implementacao teorizacao = arcoMaguerez.getImplementacao();
			teorizacao.setAvaliacaoProfessor(avaliacao2);
			
			AvaliacaoProfessor avaliacao3 = new AvaliacaoProfessor(hipotesesNota, hipotesesComentarios);
			if(arcoMaguerez.getResultadosEsperados().getAvaliacaoProfessor() != null){
				avaliacao3 = arcoMaguerez.getResultadosEsperados().getAvaliacaoProfessor();
				avaliacao3.setComentario(hipotesesComentarios);
				avaliacao3.setNota(hipotesesNota);
			}
			ResultadosEsperados hipoteses = arcoMaguerez.getResultadosEsperados();
			hipoteses.setAvaliacaoProfessor(avaliacao3);
			
			fachada.inserirAvaliacaoProfessor(avaliacao);
			fachada.inserirAvaliacaoProfessor(avaliacao2);
			fachada.inserirAvaliacaoProfessor(avaliacao3);
			fachada.atualizarPontosChave(pontos);
			fachada.atualizarTeorizacao(teorizacao);
			fachada.atualizarHipotesesDeSolucao(hipoteses);
			
			fachada.atualizar();
			fachada.limparSessaoHibernate();
			
			List<ArcoMaguerezEstudoDeCaso> arcosMaguerezAlunos = fachada.getTodasArcoMaguerezEstudoDeCasoPorCurso(arcoMaguerez.getEstudoDeCaso().getCurso());
			request.getSession().setAttribute("arcosMaguerezAlunos", arcosMaguerezAlunos);
			
			request.setAttribute("mensagem", "Menção adicionada com sucesso!");
			
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
		
		return map.findForward(fPROFESSORLISTARESTUDOSCASOS);
	}
	
	public ActionForward teste2(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{
	
		}catch(Exception x){
			
		}
		return map.findForward("");
	}
	
}
