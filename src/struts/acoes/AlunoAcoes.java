package struts.acoes;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import fachada.Fachada;
import model.Nanda;
import model.curso.Curso;
import model.curso.EstudoDeCaso;
import model.curso.matricula.MatriculaCursoAluno;
import model.curso.matricula.arcomaguerez.ArcoMaguerezEstudoDeCaso;
import model.curso.matricula.arcomaguerez.Avaliacao;
import model.curso.matricula.arcomaguerez.DiagnosticosImplementacoes;
import model.curso.matricula.arcomaguerez.Implementacao;
import model.curso.matricula.arcomaguerez.Planejamento;
import model.curso.matricula.arcomaguerez.ResultadosEsperados;
import model.sistema.Arquivo;
import model.usuario.Aluno;
import util.FileUploadForm;

public class AlunoAcoes extends DispatchAction {

	
	private static final String fALUNOLISTARCURSOS = "fAlunoListarCursos";
	private static final String fALUNODETALHECURSO = "fAlunoDetalheCurso";
	private static final String fALUNOORGANIZARAMBULATORIO = "fAlunoOrganizarAmbulatorio";
	private static final String fALUNOLISTAESTUDODECASO = "fAlunoListaEstudoDeCaso";
	private static final String fALUNOESTUDOCASOINVESTIGACAO = "fAlunoEstudoDeCasoInvestigacao";
	private static final String fALUNOESTUDOCASOPLANEJAMENTO= "fAlunoEstudoDeCasoPlanejamento";
	private static final String fALUNOESTUDOCASOIMPLEMENTACAO= "fAlunoEstudoDeCasoImplementacao";
	private static final String fALUNOESTUDOCASORESULTADOS= "fAlunoEstudoDeCasoResultados";
	private static final String fALUNOESTUDOCASOHIPOTESESREFRESH = "fAlunoEstudoDeCasoHipotesesRefresh";
	private static final String fALUNOESTUDOCASOAVALIACAO= "fAlunoEstudoDeCasoAvaliacao";
	private static final String fALUNOESTUDOCASOPROCURARTERMO= "fAlunoEstudoDeCasoProcurarTermo";
	private static final String fALUNOOPNIAOCURSO = "fAlunoOpniaoCurso";
	private static final String fALUNOFEEDBACKCURSO = "fAlunoFeedBackCurso";
	private static final String fALUNOMATERIALPEDAGOGICO = "fAlunoMateriaPedagogico";
	private static final String fALUNOHYPERLINK = "fAlunoHyperLink";

	private Fachada fachada;
	
	public AlunoAcoes(){
		fachada = Fachada.getInstancia();
	}
	

	public ActionForward mostrarTelaHyperLink(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
				String idHyperLink = request.getParameter("idHyperLink");
			  return map.findForward(fALUNOHYPERLINK);
	}
	
	public ActionForward mostrarTelaListarCursos(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("matriculas");

		Aluno aluno = (Aluno)request.getSession().getAttribute("usuario");
		List<MatriculaCursoAluno> matriculas = fachada.getTodasMatriculasAluno(aluno);
		request.getSession().setAttribute("matriculas", matriculas);
		
		List<Curso> cursosParaNovaMatricula = fachada.getTodosCursosDisponiveisEAndamentoDiferentesDeMatriculado(matriculas);
		request.getSession().setAttribute("cursosNovaMatricula", cursosParaNovaMatricula);
		
		return map.findForward(fALUNOLISTARCURSOS);
	}
	
	public ActionForward matricularNovoCurso(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{
			request.getSession().removeAttribute("matriculas");
			Aluno aluno = (Aluno)request.getSession().getAttribute("usuario");

			String cursoSelecionado = request.getParameter("cursoId");
			List<Curso> cursosList = new ArrayList<Curso>();
			cursosList.add(new Curso(Integer.parseInt(cursoSelecionado)));
			fachada.matricularAlunoCursos(aluno, cursosList);
			
			Curso cursoRetornoBD = fachada.getCursoPorId(Integer.parseInt(cursoSelecionado));
			List<MatriculaCursoAluno> matriculas = fachada.getTodasMatriculasAluno(aluno);
			for (MatriculaCursoAluno matriculaCursoAluno : matriculas) {
				if(matriculaCursoAluno.getCurso().getId() == cursoRetornoBD.getId()){
					matriculaCursoAluno.setCurso(cursoRetornoBD);
				}
			}
			request.getSession().setAttribute("matriculas", matriculas);
			
			List<Curso> cursosParaNovaMatricula = fachada.getTodosCursosDisponiveisEAndamentoDiferentesDeMatriculado(matriculas);
			request.getSession().setAttribute("cursosNovaMatricula", cursosParaNovaMatricula);
			
			request.setAttribute("mensagem", "Curso Matriculado com Sucesso!");
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("mensagem", "Erro ao matricular aluno, tente novamente mais tarde!");
		}
		
		return map.findForward(fALUNOLISTARCURSOS);
	}
	
	public ActionForward mostrarTelaDetalheCurso(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{
			String id = ((DynaActionForm)form).getString("idMatricula");
			MatriculaCursoAluno matricula = fachada.getMatriculaAlunoCursoPorId(Integer.parseInt(id));
			request.getSession().setAttribute("matricula", matricula);
			request.getSession().removeAttribute("matriculas");
			request.getSession().setAttribute("cursosNovaMatricula", null);
			
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
		
		return map.findForward(fALUNODETALHECURSO);
	}
	
	public ActionForward mostrarTelaListaEstudosDeCaso(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{
			
			MatriculaCursoAluno matricula = (MatriculaCursoAluno)request.getSession().getAttribute("matricula");
			List<EstudoDeCaso> estudosCasos = fachada.listarEstudosDeCasosPorCurso(matricula.getCurso());
			request.getSession().setAttribute("estudosDeCasos", estudosCasos);
			
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
		
		return map.findForward(fALUNOLISTAESTUDODECASO);
	}
	
	public ActionForward mostrarTelaAmbulatorio(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{
			carregarMateriaisAmbulatorio(request);
			
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
		
		return map.findForward(fALUNOORGANIZARAMBULATORIO);
	}

	public ActionForward organizarAmbulatorio(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		try{
			String[]  materiaisGeral = ((DynaActionForm)form).getStrings("mobilia");
			String[]  materiaisClinico = ((DynaActionForm)form).getStrings("corrente");
			String[]  materiaisConcorrente = ((DynaActionForm)form).getStrings("clinico");
			
//			List<Material> materiaisAmbulatorio = new ArrayList<Material>();
//			for (int i = 0; i < materiaisGeral.length; i++) {
//				materiaisAmbulatorio.add(new Material(Integer.parseInt(materiaisGeral[i])));
//			}
//			for (int i = 0; i < materiaisClinico.length; i++) {
//				materiaisAmbulatorio.add(new Material(Integer.parseInt(materiaisClinico[i])));
//			}
//			for (int i = 0; i < materiaisConcorrente.length; i++) {
//				materiaisAmbulatorio.add(new Material(Integer.parseInt(materiaisConcorrente[i])));
//			}
//			
//			MatriculaCursoAluno matricula = (MatriculaCursoAluno) request.getSession().getAttribute("matricula");
//			Ambulatorio ambulatorio = matricula.getAmbulatorio();
//			ambulatorio.setMateriais(materiaisAmbulatorio);
//			fachada.organizarAmbulatorioAluno(ambulatorio);
			
			request.setAttribute("mensagem", "Ambulatório salvo com sucesso");
			
			carregarMateriaisAmbulatorio(request);
			
			
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
		
		return map.findForward(fALUNOORGANIZARAMBULATORIO);
		
	}
	
	public ActionForward  mostrarTelaInvestigacao(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{
			String idEstudoCaso = ((DynaActionForm)form).getString("idEstudoCaso");
			List<EstudoDeCaso> estudosCasos = (List<EstudoDeCaso>) request.getSession().getAttribute("estudosDeCasos");
			MatriculaCursoAluno matricula = (MatriculaCursoAluno) request.getSession().getAttribute("matricula");
			EstudoDeCaso estudoEscolhido = null;
			for (EstudoDeCaso estudoDeCaso : estudosCasos) {
				if(estudoDeCaso.getId() == Integer.parseInt(idEstudoCaso)){
					estudoEscolhido = estudoDeCaso;
				}
			}
			ArcoMaguerezEstudoDeCaso arcoMaguerez = fachada.getArcoMaguerezPorMatriculaCursoEstudoCaso(matricula, estudoEscolhido);
			if(arcoMaguerez == null){
				arcoMaguerez = new ArcoMaguerezEstudoDeCaso(ArcoMaguerezEstudoDeCaso.INVESTIGACAO, matricula, estudoEscolhido, new Planejamento(), new Implementacao(), new ResultadosEsperados(), new Avaliacao());
				arcoMaguerez = fachada.inserirArcoMaguerez(arcoMaguerez);
			}
			request.getSession().setAttribute("arcoMaguerez", arcoMaguerez);
			request.getSession().setAttribute("estudoDeCaso", estudoEscolhido);
			
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
		
		return map.findForward(fALUNOESTUDOCASOINVESTIGACAO);
	}
	
	public ActionForward  avancarInvestigacao(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{
			
			ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
			if(arcoMaguerez.getFaseDoArco() < ArcoMaguerezEstudoDeCaso.PLANEJAMENTO){
				arcoMaguerez.setFaseDoArco(ArcoMaguerezEstudoDeCaso.PLANEJAMENTO);
				arcoMaguerez = fachada.atualizarArcoMaguerez(arcoMaguerez);
				request.setAttribute("mensagem", "Fase Investigação concluída com sucesso!");
			}
//			List<Determinante> determinantes = fachada.buscarDeterminantePorPontoChave(arcoMaguerez.getPlanejamento());
			
			request.getSession().setAttribute("arcoMaguerez", arcoMaguerez);
//			request.getSession().setAttribute("determinantes", determinantes);
			
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
		
		return map.findForward(fALUNOESTUDOCASOPLANEJAMENTO);
	}
	
	public ActionForward mostrarTelaPlanejamento(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward retorno = null;
		try{
			
			ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
			
			if(arcoMaguerez.getFaseDoArco() >= ArcoMaguerezEstudoDeCaso.PLANEJAMENTO){
//				List<Determinante> determinantes = fachada.buscarDeterminantePorPontoChave(arcoMaguerez.getPlanejamento());
//				request.getSession().setAttribute("determinantes", determinantes);
				retorno =  map.findForward(fALUNOESTUDOCASOPLANEJAMENTO);
			}else{
				request.setAttribute("mensagem", "Você ainda não finalizou a fase Investigação para visualizar esta Fase do Arco");
				retorno =  map.findForward(fALUNOESTUDOCASOINVESTIGACAO);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}	
		
		return retorno;
	}
	
	public ActionForward salvarPlanejamento(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{
			ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
			
			if(arcoMaguerez.getFaseDoArco() <= ArcoMaguerezEstudoDeCaso.PLANEJAMENTO){
				String[]  determinantes = ((DynaActionForm)form).getStrings("determinantes");
//				List<Determinante> listDeterminantes= new ArrayList<Determinante>();
				
				for (String determ : determinantes) {
					String determinanteTemp = determ.split("##")[0];
					String justificativaTemp = determ.split("##")[1];
//					Determinante determinanteAdd = new Determinante(determinanteTemp, justificativaTemp, arcoMaguerez.getPlanejamento());
//					listDeterminantes.add(determinanteAdd);
				}
				
//				List<Determinante> determinantesAdicionados = fachada.inserirDeterminantePontosChave(listDeterminantes, arcoMaguerez.getPlanejamento());
//				request.getSession().setAttribute("determinantes", determinantesAdicionados);
				
				arcoMaguerez = fachada.atualizarArcoMaguerez(arcoMaguerez);
				
				request.setAttribute("mensagem", "Dados salvos com Sucesso!");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
		
		return map.findForward(fALUNOESTUDOCASOPLANEJAMENTO);
	}
	
	
	public ActionForward avancarPlanejamento(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward retorno = map.findForward(fALUNOESTUDOCASOPLANEJAMENTO);
		
		try{
			ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
	
			if(arcoMaguerez.getFaseDoArco() <= ArcoMaguerezEstudoDeCaso.PLANEJAMENTO){
				String[]  determinantes = ((DynaActionForm)form).getStrings("determinantes");
//				List<Determinante> listDeterminantes= new ArrayList<Determinante>();
				
				for (String determ : determinantes) {
					String determinanteTemp  = "";
					if(determ.split("##")[0] != null){
						determinanteTemp = determ.split("##")[0];
					}
					String justificativaTemp = "";
					if(determ.split("##").length == 2){
						justificativaTemp = determ.split("##")[1];
					}
					
					if(!determinanteTemp.equals("")){
//						Determinante determinanteAdd = new Determinante(determinanteTemp, justificativaTemp, arcoMaguerez.getPlanejamento());
//						listDeterminantes.add(determinanteAdd);
					}
				}
				
//				List<Determinante> determinantesAdicionados = fachada.inserirDeterminantePontosChave(listDeterminantes, arcoMaguerez.getPlanejamento());
//				request.getSession().setAttribute("determinantes", determinantesAdicionados);
				
					arcoMaguerez.setFaseDoArco(ArcoMaguerezEstudoDeCaso.IMPLEMENTACAO);
					arcoMaguerez = fachada.atualizarArcoMaguerez(arcoMaguerez);
				
				request.setAttribute("mensagem", "Fase Planejamento concluída com sucesso!");
			}
			retorno = map.findForward(fALUNOESTUDOCASOIMPLEMENTACAO);
			
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
		
		return retorno;
	}
	
	public ActionForward mostrarTelaImplementacao(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward retorno = null;
		try{
			
			ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
//			List<DeterminanteHipoteses> determinantesHipoteses = fachada.buscarDeterminantesHipotesesPorEstudoCaso(arcoMaguerez.getEstudoDeCaso());
//			request.getSession().setAttribute("determinantesHipoteses", determinantesHipoteses);
			
			if(arcoMaguerez.getFaseDoArco() >= ArcoMaguerezEstudoDeCaso.IMPLEMENTACAO){
				retorno =  map.findForward(fALUNOESTUDOCASOIMPLEMENTACAO);
			}else{
				request.setAttribute("mensagem", "Você ainda não finalizou a fase anterior para visualizar esta Fase do Arco");
				if(arcoMaguerez.getFaseDoArco() == ArcoMaguerezEstudoDeCaso.INVESTIGACAO){
					retorno =  map.findForward(fALUNOESTUDOCASOINVESTIGACAO);
				}else{
					retorno =  map.findForward(fALUNOESTUDOCASOPLANEJAMENTO);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}	
		
		return retorno;
	}
	
	public ActionForward salvarImplementacao(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward retorno = null;
		try{
			
			ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
			Implementacao teorizacao = arcoMaguerez.getImplementacao(); 
			
			if(arcoMaguerez.getFaseDoArco() >= ArcoMaguerezEstudoDeCaso.RESULTADOS_ESPERADOS){
//				retorno = map.findForward(fALUNOESTUDOCASOTEORIZACAO);
				retorno = map.findForward(fALUNOESTUDOCASOIMPLEMENTACAO);
			}else{
				FileUploadForm fileUploadForm = (FileUploadForm)form;
				 
			    FormFile file = fileUploadForm.getFile();
			   
			   if(file != null  && file.getFileName() != null && !file.getFileName().equals("")){
				   if(validarArquivo(file.getFileName())){
					   if( file.getFileSize() < 16777216){
						   Arquivo arquivo = new Arquivo();
						   arquivo.setDadosArqv(file.getFileData());
						   arquivo.setExtensao(file.getContentType());
						   arquivo.setNomeArqv(file.getFileName());
						   
						   List<Arquivo> arquivos = new ArrayList<Arquivo>();
						   arquivos.add(arquivo);
						   
//						   teorizacao.setArquivos(arquivos);
						   teorizacao = fachada.atualizarTeorizacao(teorizacao);
						   arcoMaguerez.setImplementacao(teorizacao);
						   
						   arcoMaguerez = fachada.atualizarArcoMaguerez(arcoMaguerez);
						   
						   request.getSession().setAttribute("arcoMaguerez", arcoMaguerez);
						   request.setAttribute("mensagem", "Dados salvos com sucesso!");
					   }else{
						   request.setAttribute("mensagem", "Tamanho do arquivo maior que 16Mb! ");
					   }
				   }else{
					   request.setAttribute("mensagem", "Tipo de arquivo inválido! Escolha apenas .doc, .docx ou .pdf");
				   }
			    }else{
			    	request.setAttribute("mensagem", "Dados Salvos com sucesso!");
			    }
				retorno = map.findForward(fALUNOESTUDOCASOIMPLEMENTACAO);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
		return retorno;
	}
	
	public ActionForward avancarImplementacao(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward retorno = null;
		try{
			
			ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
			Implementacao teorizacao = arcoMaguerez.getImplementacao(); 
			
			if(arcoMaguerez.getFaseDoArco() >= ArcoMaguerezEstudoDeCaso.RESULTADOS_ESPERADOS){
				retorno = map.findForward(fALUNOESTUDOCASORESULTADOS);
			}else{
//				FileUploadForm fileUploadForm = (FileUploadForm)form;
//				 
//			    FormFile file = fileUploadForm.getFile();
//			   
//			   if(file.getFileName() != null && !file.getFileName().equals("")){
//				   if(validarArquivo(file.getFileName())){
//					   if( file.getFileSize() < 16777216){
//						   Arquivo arquivo = new Arquivo();
//						   arquivo.setDadosArqv(file.getFileData());
//						   arquivo.setExtensao(file.getContentType());
//						   arquivo.setNomeArqv(file.getFileName());
//						   
//						   List<Arquivo> arquivos = new ArrayList<Arquivo>();
//						   arquivos.add(arquivo);
//						   
//						   resultadosEsperados.setArquivos(arquivos);
//						   resultadosEsperados = fachada.atualizarTeorizacao(resultadosEsperados);
//						   arcoMaguerez.setTeorizacao(resultadosEsperados);
//						   
//						   arcoMaguerez.setFaseDoArco(ArcoMaguerezEstudoDeCaso.RESULTADOS_ESPERADOS);
//						   arcoMaguerez = fachada.atualizarArcoMaguerez(arcoMaguerez);
//						   
//						   request.getSession().setAttribute("arcoMaguerez", arcoMaguerez);
//						   request.setAttribute("mensagem", "Fase Teorização concluída com sucesso!");
//					   }else{
//						   request.setAttribute("mensagem", "Tamanho do arquivo maior que 16Mb! ");
//					   }
//				   }else{
//					   request.setAttribute("mensagem", "Tipo de arquivo inválido! Escolha apenas .doc, .docx ou .pdf");
//				   }
//			    }else if(file.getFileName().equals("") && (resultadosEsperados.getArquivos() == null || resultadosEsperados.getArquivos().isEmpty())){
//			    	request.setAttribute("mensagem", "Nenhum arquivo foi selecionado!");
//			    }
//			   if(arcoMaguerez.getTeorizacao().getArquivos() == null || arcoMaguerez.getTeorizacao().getArquivos().isEmpty()){
//				   request.setAttribute("mensagem", "Você não selecionou nenhum arquivo para avançar na fase");
//				   retorno = map.findForward(fALUNOESTUDOCASOTEORIZACAO);
//			   }else{
//				   if(arcoMaguerez.getFaseDoArco() == ArcoMaguerezEstudoDeCaso.IMPLEMENTACAO){
//					   arcoMaguerez.setFaseDoArco(ArcoMaguerezEstudoDeCaso.RESULTADOS_ESPERADOS);
//					   arcoMaguerez = fachada.atualizarArcoMaguerez(arcoMaguerez);
//					   request.setAttribute("mensagem", "Fase Teorização concluída com sucesso!");
//				   }
				 	arcoMaguerez.setFaseDoArco(ArcoMaguerezEstudoDeCaso.RESULTADOS_ESPERADOS);
				   arcoMaguerez = fachada.atualizarArcoMaguerez(arcoMaguerez);
					request.setAttribute("mensagem", "Fase Implementação concluída com sucesso!");
				   retorno = map.findForward(fALUNOESTUDOCASOHIPOTESESREFRESH);
//			   }
			}
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
		return retorno;
	}
	
	public ActionForward mostrarTelaResultados(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward retorno = null;
		try{
			
			ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
//			List<DeterminanteHipoteses> determinantesHipoteses = fachada.buscarDeterminantesHipotesesPorEstudoCaso(arcoMaguerez.getEstudoDeCaso());
//			request.getSession().setAttribute("determinantesHipoteses", determinantesHipoteses);
			
			List<DiagnosticosImplementacoes> diagnosticos = fachada.buscarDiagnosticoPorHipotesesDeSolucao(arcoMaguerez.getResultadosEsperados());
			request.getSession().setAttribute("diagnosticos", diagnosticos);
			
			if(arcoMaguerez.getFaseDoArco() >= ArcoMaguerezEstudoDeCaso.RESULTADOS_ESPERADOS){
				retorno =  map.findForward(fALUNOESTUDOCASORESULTADOS);
			}else{
				request.setAttribute("mensagem", "Você ainda não finalizou a fase anterior para visualizar esta Fase do Arco");
				if(arcoMaguerez.getFaseDoArco() == ArcoMaguerezEstudoDeCaso.INVESTIGACAO){
					retorno =  map.findForward(fALUNOESTUDOCASOINVESTIGACAO);
				}else if(arcoMaguerez.getFaseDoArco() == ArcoMaguerezEstudoDeCaso.PLANEJAMENTO){
					retorno =  map.findForward(fALUNOESTUDOCASOPLANEJAMENTO);
				}else{
					retorno = map.findForward(fALUNOESTUDOCASOIMPLEMENTACAO);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}	
		
		return retorno;
	}
	
	public ActionForward salvarResultadosEsperados(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward retorno = null;
		try{
			
			ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
//			List<DeterminanteHipoteses> determinantesHipoteses = fachada.buscarDeterminantesHipotesesPorEstudoCaso(arcoMaguerez.getEstudoDeCaso());
//			request.getSession().setAttribute("determinantesHipoteses", determinantesHipoteses);
			
			List<DiagnosticosImplementacoes> diagnosticos = fachada.buscarDiagnosticoPorHipotesesDeSolucao(arcoMaguerez.getResultadosEsperados());
			request.getSession().setAttribute("diagnosticos", diagnosticos);
			
			if(arcoMaguerez.getFaseDoArco() >= ArcoMaguerezEstudoDeCaso.RESULTADOS_ESPERADOS){
				retorno =  map.findForward(fALUNOESTUDOCASORESULTADOS);
				request.setAttribute("mensagem", "Dados salvos com sucesso!");
			}else{
				request.setAttribute("mensagem", "Você ainda não finalizou a fase anterior para visualizar esta Fase do Arco");
				if(arcoMaguerez.getFaseDoArco() == ArcoMaguerezEstudoDeCaso.INVESTIGACAO){
					retorno =  map.findForward(fALUNOESTUDOCASOINVESTIGACAO);
				}else if(arcoMaguerez.getFaseDoArco() == ArcoMaguerezEstudoDeCaso.PLANEJAMENTO){
					retorno =  map.findForward(fALUNOESTUDOCASOPLANEJAMENTO);
				}else{
					retorno = map.findForward(fALUNOESTUDOCASOIMPLEMENTACAO);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}	
		
		return retorno;
	}
	
	public ActionForward avancarResultadosEsperados(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward retorno = null;
		try{
			
			ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
//			List<DeterminanteHipoteses> determinantesHipoteses = fachada.buscarDeterminantesHipotesesPorEstudoCaso(arcoMaguerez.getEstudoDeCaso());
//			request.getSession().setAttribute("determinantesHipoteses", determinantesHipoteses);
			
			List<DiagnosticosImplementacoes> diagnosticos = fachada.buscarDiagnosticoPorHipotesesDeSolucao(arcoMaguerez.getResultadosEsperados());
			request.getSession().setAttribute("diagnosticos", diagnosticos);
			
			if(arcoMaguerez.getFaseDoArco() == ArcoMaguerezEstudoDeCaso.RESULTADOS_ESPERADOS){
				arcoMaguerez.setFaseDoArco(ArcoMaguerezEstudoDeCaso.AVALIACAO);
			    arcoMaguerez = fachada.atualizarArcoMaguerez(arcoMaguerez);
				
			    request.setAttribute("mensagem", "Fase Resultados Esperados concluída com sucesso!");
			    retorno =  map.findForward(fALUNOESTUDOCASOAVALIACAO);
			}else if(arcoMaguerez.getFaseDoArco() > ArcoMaguerezEstudoDeCaso.RESULTADOS_ESPERADOS){
				retorno =  map.findForward(fALUNOESTUDOCASOAVALIACAO);
			}else{
				request.setAttribute("mensagem", "Você ainda não finalizou a fase anterior para visualizar esta Fase do Arco");
				if(arcoMaguerez.getFaseDoArco() == ArcoMaguerezEstudoDeCaso.INVESTIGACAO){
					retorno =  map.findForward(fALUNOESTUDOCASOINVESTIGACAO);
				}else if(arcoMaguerez.getFaseDoArco() == ArcoMaguerezEstudoDeCaso.PLANEJAMENTO){
					retorno =  map.findForward(fALUNOESTUDOCASOPLANEJAMENTO);
				}else{
					retorno = map.findForward(fALUNOESTUDOCASOIMPLEMENTACAO);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}	
		
		return retorno;
	}
	
	public ActionForward adicionarDiagnostico(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		try {
				
			String determinante = ((DynaActionForm)form).getString("determinante");
			String termoautocomplete = ((DynaActionForm)form).getString("termoautocomplete");
			String idtermoautocomplete = ((DynaActionForm)form).getString("idtermoautocomplete");
			String texto = ((DynaActionForm)form).getString("texto");
			
			if(determinante != null && !determinante.equals("")){
//				DeterminanteHipoteses determinanteHipoteses = new DeterminanteHipoteses(Integer.parseInt(determinante));
				if(idtermoautocomplete != null && !idtermoautocomplete.equals("")){
					ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
					Nanda cipe = new Nanda(Integer.parseInt(idtermoautocomplete));
					
//					DiagnosticosImplementacoes diagnosticoAdd = new DiagnosticosImplementacoes(cipe, texto, determinanteHipoteses, arcoMaguerez.getResultadosEsperados());
//					diagnosticoAdd = fachada.adicionarDiagnostico(diagnosticoAdd);
					
					fachada.limparSessaoHibernate();
					List<DiagnosticosImplementacoes> diagnosticos = fachada.buscarDiagnosticoPorHipotesesDeSolucao(arcoMaguerez.getResultadosEsperados());
					request.getSession().setAttribute("diagnosticos", diagnosticos);
					
					 request.setAttribute("mensagem", "Diagnóstico inserido com sucesso!");
				}else{
					request.setAttribute("mensagem", "Você não selecionou o Termo do Eixo Foco adequadamente");
				}
			}else{
				request.setAttribute("mensagem", "Você deve esperar o processo de Regulaçao da aprendizagem onde o professor irá cadastrar o determinantes selecionados");
			}
			
		 }catch(Exception ex){
			 ex.printStackTrace();
			 request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
    	  return  map.findForward(fALUNOESTUDOCASORESULTADOS);
	}
	
	public ActionForward editarDiagnostico(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		try {
			
			String idDiagnostico = ((DynaActionForm)form).getString("idDiagnostico");
			String determinante = ((DynaActionForm)form).getString("determinante");
			String termoautocomplete = ((DynaActionForm)form).getString("termo2autocomplete");
			String idtermoautocomplete = ((DynaActionForm)form).getString("idtermo2autocomplete");
			String texto = ((DynaActionForm)form).getString("texto");
			
			if(determinante != null && !determinante.equals("") && idDiagnostico != null && !idDiagnostico.equals("")){
//				DeterminanteHipoteses determinanteHipoteses = new DeterminanteHipoteses(Integer.parseInt(determinante));
				if(idtermoautocomplete != null && !idtermoautocomplete.equals("")){
					Nanda cipe = new Nanda(Integer.parseInt(idtermoautocomplete));
					ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
					
////					DiagnosticosImplementacoes diagnosticoEdit = new DiagnosticosImplementacoes(cipe, texto, determinanteHipoteses, arcoMaguerez.getResultadosEsperados());
//					diagnosticoEdit.setId(Integer.parseInt(idDiagnostico));
//					diagnosticoEdit = fachada.editarDiagnostico(diagnosticoEdit);

					fachada.atualizar();
					fachada.limparSessaoHibernate();
					List<DiagnosticosImplementacoes> diagnosticos = fachada.buscarDiagnosticoPorHipotesesDeSolucao(arcoMaguerez.getResultadosEsperados());
					request.getSession().setAttribute("diagnosticos", diagnosticos);
					
					 request.setAttribute("mensagem", "Diagnóstico editado com sucesso!");
				}else{
					request.setAttribute("mensagem", "Você não selecionou o Termo do Eixo Foco adequadamente");
				}
			}else{
				request.setAttribute("mensagem", "Você deve esperar o processo de Regulaçao da aprendizagem onde o professor irá cadastrar o determinantes selecionados");
			}
			
		 }catch(Exception ex){
			 ex.printStackTrace();
			 request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
    	  return  map.findForward(fALUNOESTUDOCASORESULTADOS);
	}
	
	public ActionForward removerDiagnostico(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		try {
			String idDiagnostico = ((DynaActionForm)form).getString("idDiagnostico");
			if(idDiagnostico != null  && !idDiagnostico.equals("")){
				DiagnosticosImplementacoes diagnosticoRemover = new DiagnosticosImplementacoes(Integer.parseInt(idDiagnostico));
//				fachada.removerDiagnostico(diagnosticoRemover);
				
				fachada.atualizar();
				request.setAttribute("mensagem", "Diagnóstico removido com sucesso!");
			}
		
		}catch(Exception ex){
			 ex.printStackTrace();
			 request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
    	  return  map.findForward(fALUNOESTUDOCASOHIPOTESESREFRESH);
	}
	
	public ActionForward adicionarMetaDiagnostico(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		try {
			String idDiagnostico = ((DynaActionForm)form).getString("idDiagnostico");
			if(idDiagnostico != null && !idDiagnostico.equals("")){
				DiagnosticosImplementacoes diagnostico = new DiagnosticosImplementacoes(Integer.parseInt(idDiagnostico));
				String meta = ((DynaActionForm)form).getString("meta");
				
//				Meta metaAdd = new Meta(diagnostico, meta);
//				fachada.inserirMeta(metaAdd);
				
				fachada.atualizar();
				fachada.limparSessaoHibernate();
				ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
				List<DiagnosticosImplementacoes> diagnosticos = fachada.buscarDiagnosticoPorHipotesesDeSolucao(arcoMaguerez.getResultadosEsperados());
				request.getSession().setAttribute("diagnosticos", diagnosticos);
    			request.setAttribute("mensagem", "Meta adicionada com sucesso!");
			}
		
		}catch(Exception ex){
			 ex.printStackTrace();
			 request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
    	  return  map.findForward(fALUNOESTUDOCASOHIPOTESESREFRESH);
	}
	
	public ActionForward editarMetaDiagnostico(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		try {
			
			String idMetaDiagnostico = ((DynaActionForm)form).getString("idMetaDiagnostico");
			String idDiagnostico = ((DynaActionForm)form).getString("idDiagnostico");
			String meta = ((DynaActionForm)form).getString("meta");
			
			if(idMetaDiagnostico != null && !idMetaDiagnostico.equals("") && idDiagnostico != null && !idDiagnostico.equals("")){
				DiagnosticosImplementacoes diagnostico = new DiagnosticosImplementacoes(Integer.parseInt(idDiagnostico));
//				Meta metaEdit = new Meta(Integer.parseInt(idMetaDiagnostico), diagnostico, meta);
//				fachada.editarMeta(metaEdit);
				
				fachada.atualizar();
				fachada.limparSessaoHibernate();
				ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
				List<DiagnosticosImplementacoes> diagnosticos = fachada.buscarDiagnosticoPorHipotesesDeSolucao(arcoMaguerez.getResultadosEsperados());
				request.getSession().setAttribute("diagnosticos", diagnosticos);
				
				request.setAttribute("mensagem", "Meta editada com sucesso!");
			}else{
				request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
			}
			
		 }catch(Exception ex){
			 ex.printStackTrace();
			 request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
    	  return  map.findForward(fALUNOESTUDOCASORESULTADOS);
	}
	
	public ActionForward removerMetaDiagnostico(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		try {
			String idMetaDiagnostico = ((DynaActionForm)form).getString("idMetaDiagnostico");
			if(idMetaDiagnostico != null  && !idMetaDiagnostico.equals("")){
//				Meta metaRemover = new Meta(Integer.parseInt(idMetaDiagnostico));
//				fachada.removerMetaDiagnostico(metaRemover);
				
				fachada.atualizar();
				request.setAttribute("mensagem", "Meta removida com sucesso!");
			}
		
		}catch(Exception ex){
			 ex.printStackTrace();
			 request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
    	  return  map.findForward(fALUNOESTUDOCASOHIPOTESESREFRESH);
	}
	
	public ActionForward adicionarIntervencaoDiagnostico(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		try {
				
			String idMetaDiagnostico = ((DynaActionForm)form).getString("idMetaDiagnostico");
			String idDiagnostico = ((DynaActionForm)form).getString("idDiagnostico");
			String termo3autocomplete = ((DynaActionForm)form).getString("termo3autocomplete");
			String idtermo3autocomplete = ((DynaActionForm)form).getString("idtermo3autocomplete");
			String texto = ((DynaActionForm)form).getString("texto");
			
			if(idMetaDiagnostico != null && !idMetaDiagnostico.equals("")){
//				Meta meta = new Meta(Integer.parseInt(idMetaDiagnostico));
				if(idtermo3autocomplete != null && !idtermo3autocomplete.equals("")){
					Nanda cipe = new Nanda(Integer.parseInt(idtermo3autocomplete));
					
//					Intervencao intervencaoAdd = new Intervencao(meta, cipe, texto);
//					intervencaoAdd = fachada.adicionarIntervencaoMetaDiagnostico(intervencaoAdd);
					
					fachada.limparSessaoHibernate();
					ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
					List<DiagnosticosImplementacoes> diagnosticos = fachada.buscarDiagnosticoPorHipotesesDeSolucao(arcoMaguerez.getResultadosEsperados());
					request.getSession().setAttribute("diagnosticos", diagnosticos);
					
					 request.setAttribute("mensagem", "Intervenção inserida com sucesso!");
				}else{
					request.setAttribute("mensagem", "Você não selecionou o Termo do Eixo Foco adequadamente");
				}
			}
			
		 }catch(Exception ex){
			 ex.printStackTrace();
			 request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
    	  return  map.findForward(fALUNOESTUDOCASORESULTADOS);
	}
	
	public ActionForward editarIntervencaoDiagnostico(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		try {
			String idIntervencaoDiagnostico = ((DynaActionForm)form).getString("idIntervencaoDiagnostico");	
			String idMetaDiagnostico = ((DynaActionForm)form).getString("idMetaDiagnostico");
			String idDiagnostico = ((DynaActionForm)form).getString("idDiagnostico");
			String termo4autocomplete = ((DynaActionForm)form).getString("termo4autocomplete");
			String idtermo4autocomplete = ((DynaActionForm)form).getString("idtermo4autocomplete");
			String texto = ((DynaActionForm)form).getString("texto");
			
			if(idIntervencaoDiagnostico != null && !idIntervencaoDiagnostico.equals("")){
//				Meta meta = new Meta(Integer.parseInt(idMetaDiagnostico));
				if(idtermo4autocomplete != null && !idtermo4autocomplete.equals("")){
					Nanda cipe = new Nanda(Integer.parseInt(idtermo4autocomplete));
					
//					Intervencao intervencaoEdit = new Intervencao(Integer.parseInt(idIntervencaoDiagnostico), meta, cipe, texto);
//					intervencaoEdit = fachada.editarIntervencaoMetaDiagnostico(intervencaoEdit);
					
					fachada.atualizar();
					fachada.limparSessaoHibernate();
					ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
					List<DiagnosticosImplementacoes> diagnosticos = fachada.buscarDiagnosticoPorHipotesesDeSolucao(arcoMaguerez.getResultadosEsperados());
					request.getSession().setAttribute("diagnosticos", diagnosticos);
					
					 request.setAttribute("mensagem", "Intervenção editada com sucesso!");
				}else{
					request.setAttribute("mensagem", "Você não selecionou o Termo do Eixo Foco adequadamente");
				}
			}
			
		 }catch(Exception ex){
			 ex.printStackTrace();
			 request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
    	  return  map.findForward(fALUNOESTUDOCASORESULTADOS);
	}
	
	public ActionForward removerIntervencaoDiagnostico(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		try {
			String idIntervencaoDiagnostico = ((DynaActionForm)form).getString("idIntervencaoDiagnostico");
			if(idIntervencaoDiagnostico != null  && !idIntervencaoDiagnostico.equals("")){
//				Intervencao intervencaoRemover = new Intervencao(Integer.parseInt(idIntervencaoDiagnostico));
//				fachada.removerIntervencaoDiagnostico(intervencaoRemover);
				
				fachada.atualizar();
				request.setAttribute("mensagem", "Intervenção removida com sucesso!");
			}
		
		}catch(Exception ex){
			 ex.printStackTrace();
			 request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
    	  return  map.findForward(fALUNOESTUDOCASOHIPOTESESREFRESH);
	}
	
	public ActionForward mostrarTelaAvaliacao(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward retorno = null;
		try{
			
			ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
			if(arcoMaguerez.getAvaliacao() == null){
				arcoMaguerez.setAvaliacao(new Avaliacao(""));
				arcoMaguerez = fachada.atualizarArcoMaguerez(arcoMaguerez);
				request.getSession().setAttribute("arcoMaguerez", arcoMaguerez);
			}
			
			if(arcoMaguerez.getFaseDoArco() >= ArcoMaguerezEstudoDeCaso.AVALIACAO){
				retorno =  map.findForward(fALUNOESTUDOCASOAVALIACAO);
			}else{
				request.setAttribute("mensagem", "Você ainda não finalizou a fase anterior para visualizar esta Fase do Arco");
				if(arcoMaguerez.getFaseDoArco() == ArcoMaguerezEstudoDeCaso.INVESTIGACAO){
					retorno =  map.findForward(fALUNOESTUDOCASOINVESTIGACAO);
				}else if(arcoMaguerez.getFaseDoArco() == ArcoMaguerezEstudoDeCaso.PLANEJAMENTO){
					retorno =  map.findForward(fALUNOESTUDOCASOPLANEJAMENTO);
				}else if(arcoMaguerez.getFaseDoArco() == ArcoMaguerezEstudoDeCaso.IMPLEMENTACAO){
					retorno =  map.findForward(fALUNOESTUDOCASOIMPLEMENTACAO);
				}else{
					retorno = map.findForward(fALUNOESTUDOCASORESULTADOS);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}	
		
		return retorno;
	}
	
	public ActionForward salvarAvaliacao(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward retorno = map.findForward(fALUNOESTUDOCASOAVALIACAO);
		try{
			String texto = ((DynaActionForm)form).getString("texto");
			if(texto != null && !texto.equals("")){
				
				ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
				arcoMaguerez.getAvaliacao().setTexto(texto);
				Avaliacao aplicacao = fachada.atualizarAplicacao(arcoMaguerez.getAvaliacao());
				arcoMaguerez.setAvaliacao(aplicacao);
				arcoMaguerez = fachada.atualizarArcoMaguerez(arcoMaguerez);
				request.getSession().setAttribute("arcoMaguerez", arcoMaguerez);
			}
			
			request.setAttribute("mensagem", "Dados salvos com sucesso!");
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}	
		
		return retorno;
	}
	
	public ActionForward avancarAvaliacao(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward retorno = map.findForward(fALUNOESTUDOCASOAVALIACAO);
		try{
			String texto = ((DynaActionForm)form).getString("texto");
			if(texto != null && !texto.equals("")){
				
				ArcoMaguerezEstudoDeCaso arcoMaguerez = (ArcoMaguerezEstudoDeCaso)  request.getSession().getAttribute("arcoMaguerez");
				arcoMaguerez.setFaseDoArco(ArcoMaguerezEstudoDeCaso.FINALIZADO);
				arcoMaguerez.getAvaliacao().setTexto(texto);
				Avaliacao aplicacao = fachada.atualizarAplicacao(arcoMaguerez.getAvaliacao());
				arcoMaguerez.setAvaliacao(aplicacao);
				arcoMaguerez = fachada.atualizarArcoMaguerez(arcoMaguerez);
				request.getSession().setAttribute("arcoMaguerez", arcoMaguerez);
			}
			
			request.setAttribute("mensagem", "Fase Avaliação concluída com sucesso!");
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}	
		
		return retorno;
	}
	
	public ActionForward baixarArquivo(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
			try 
			{
				String id = ((DynaActionForm)form).getString("idArquivo");
				ServletOutputStream out = response.getOutputStream();
				
				Arquivo download = fachada.getArquivoPorId(Integer.parseInt(id));
				
				response.setContentType(download.getExtensao());
				response.setHeader("Content-Disposition","attachment;filename="+download.getNomeArqv());
				out.write(download.getDadosArqv());
				out.flush();
				out.close();
		  }catch(Exception ex){
			  ex.printStackTrace();
			 request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		  }
			  return null;
	}
	
	public ActionForward mostrarTelaOpniaoSobreCurso(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		return map.findForward(fALUNOOPNIAOCURSO);
	}
	
	public ActionForward salvarOpniaoSobreCurso(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
			try 
			{
				String idMatriculaCursoAluno = ((DynaActionForm)form).getString("idMatriculaCursoAluno");
				String pergunta1 = ((DynaActionForm)form).getString("pergunta1");
				String pergunta2 = ((DynaActionForm)form).getString("pergunta2");
				String pergunta3 = ((DynaActionForm)form).getString("pergunta3");
				String pergunta4 = ((DynaActionForm)form).getString("pergunta4");
				
				MatriculaCursoAluno matricula = (MatriculaCursoAluno) request.getSession().getAttribute("matricula");
				if(idMatriculaCursoAluno != null && !idMatriculaCursoAluno.equals("") && 
						matricula.getId() == Integer.parseInt(idMatriculaCursoAluno)){
					if(pergunta1 != null && !pergunta1.equals("")){
						matricula.setPergunta1(pergunta1);
					}
					if(pergunta2 != null && !pergunta2.equals("")){
						matricula.setPergunta2(pergunta2);
					}
					if(pergunta3 != null && !pergunta3.equals("")){
						matricula.setPergunta3(pergunta3);
					}
					if(pergunta4 != null && !pergunta4.equals("")){
						matricula.setPergunta4(pergunta4);
					}
					fachada.atualizarMatriculaCursoAluno(matricula);
					request.setAttribute("matricula", matricula);
				}
				
				request.setAttribute("mensagem", "Opnião Salva com sucesso!");
		  }catch(Exception ex){
			  ex.printStackTrace();
			 request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		  }
			  return map.findForward(fALUNOOPNIAOCURSO);
	}
	
	public ActionForward mostrarTelaFeedbackCurso(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		try{
			
			MatriculaCursoAluno matricula = (MatriculaCursoAluno)request.getSession().getAttribute("matricula");
			List<ArcoMaguerezEstudoDeCaso> arcosMaguerez = fachada.buscarArcosMaguerezPorCursoEAluno(matricula, matricula.getCurso());
			request.getSession().setAttribute("arcosMaguerez", arcosMaguerez);
			
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
			  return map.findForward(fALUNOFEEDBACKCURSO);
	}
	
	public ActionForward pesquisarFeedBackEstudoCaso(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		try{
			
			String idEstudoCaso = ((DynaActionForm)form).getString("idEstudoCaso");
			List<EstudoDeCaso> estudosCasos = (List<EstudoDeCaso>) request.getSession().getAttribute("estudosDeCasos");
			MatriculaCursoAluno matricula = (MatriculaCursoAluno) request.getSession().getAttribute("matricula");
			EstudoDeCaso estudoEscolhido = null;
			for (EstudoDeCaso estudoDeCaso : estudosCasos) {
				if(estudoDeCaso.getId() == Integer.parseInt(idEstudoCaso)){
					estudoEscolhido = estudoDeCaso;
				}
			}
			ArcoMaguerezEstudoDeCaso arcoMaguerez = fachada.getArcoMaguerezPorMatriculaCursoEstudoCaso(matricula, estudoEscolhido);
			
			PrintWriter print = response.getWriter();
			print.println("<b>Pontos-Chaves:</b>");
			print.println("<br />");
			print.println("Comentários:");
			print.println("<br />");
			if(arcoMaguerez != null && arcoMaguerez.getPlanejamento() != null && arcoMaguerez.getPlanejamento().getAvaliacaoProfessor() != null){
				print.println(arcoMaguerez.getPlanejamento().getAvaliacaoProfessor().getComentario());
				print.println("<br />");
				print.println("Nota:");
				print.println("<br />");
				print.println(arcoMaguerez.getPlanejamento().getAvaliacaoProfessor().getNota());
			}else{
				print.println("");
				print.println("<br />");
				print.println("Nota:");
				print.println("<br />");
				print.println("");
			}
			print.println("<br />");
			print.println("<b>Teorização:</b>");
			print.println("<br />");
			print.println("Comentários:");
			print.println("<br />");
			if(arcoMaguerez != null && arcoMaguerez.getImplementacao() != null &&  arcoMaguerez.getImplementacao().getAvaliacaoProfessor() != null){
				print.println(arcoMaguerez.getImplementacao().getAvaliacaoProfessor().getComentario());
				print.println("<br />");
				print.println("Nota:");
				print.println("<br />");
				print.println(arcoMaguerez.getImplementacao().getAvaliacaoProfessor().getNota());
			}else{
				print.println("");
				print.println("<br />");
				print.println("Nota:");
				print.println("<br />");
				print.println("");
			}
			print.println("<br />");
			print.println("<b>Hipóteses de Solução:</b>");
			print.println("<br />");
			print.println("Comentários:");
			print.println("<br />");
			if(arcoMaguerez != null && arcoMaguerez.getResultadosEsperados() != null &&  arcoMaguerez.getResultadosEsperados().getAvaliacaoProfessor() != null){
				print.println(arcoMaguerez.getResultadosEsperados().getAvaliacaoProfessor().getComentario());
				print.println("<br />");
				print.println("Nota:");
				print.println("<br />");
				print.println(arcoMaguerez.getResultadosEsperados().getAvaliacaoProfessor().getNota());
			}else{
				print.println("");
				print.println("<br />");
				print.println("Nota:");
				print.println("<br />");
				print.println("");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
			  return null;
	}
	
	
	public ActionForward mostrarTelaMaterialPedagogico(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
			  return map.findForward(fALUNOMATERIALPEDAGOGICO);
	}
	
	public ActionForward mostrarTelaProcurarTermo(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{	
			String eixo = request.getParameter("eixo");
			String retorno = request.getParameter("retorno");
			String termoBuscar = request.getParameter("termo-buscar");
			
			
			List<Nanda> cipes = null;
			if(eixo != null){
				if(termoBuscar != null){
					cipes = fachada.pesquisarCipe(termoBuscar, eixo);
				}else{
					cipes = fachada.pesquisarCipe("", eixo);
				}
			}
			
			if(cipes != null){
				request.getSession().setAttribute("cipes", cipes);
			}
			if(retorno != null && !retorno.equals("")){
				request.getSession().setAttribute("retorno", retorno);
			}
			
			request.getSession().setAttribute("eixo", eixo);
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("mensagem", "Erro de conexão com o Banco de Dados!");
		}
			  return map.findForward(fALUNOESTUDOCASOPROCURARTERMO);
	}
	
	
	
	private void carregarMateriaisAmbulatorio(HttpServletRequest request) {
//		List<Material> materiaisGeral = fachada.getTodosMateriaisPorTipo(Material.GERAL);
//		List<Material> materiaisClinico = fachada.getTodosMateriaisPorTipo(Material.USO_CLINICO);
//		List<Material> materiaisConcorrente = fachada.getTodosMateriaisPorTipo(Material.USO_CORRENTE);
//		
//		MatriculaCursoAluno matricula = (MatriculaCursoAluno) request.getSession().getAttribute("matricula");
//		Ambulatorio ambulatorio = matricula.getAmbulatorio();
//		
//		
//		List<Material> matGeralAdd = ambulatorio.getTodosMateriaisPorTipo(TipoMaterialEnum.GERAL);
//		List<Material> matUsoClinicoAdd = ambulatorio.getTodosMateriaisPorTipo(TipoMaterialEnum.USO_CLINICO);
//		List<Material> matUsoCorrenteAdd = ambulatorio.getTodosMateriaisPorTipo(TipoMaterialEnum.USO_CORRENTE);
//		materiaisGeral.removeAll(matGeralAdd);
//		materiaisClinico.removeAll(matUsoClinicoAdd);
//		materiaisConcorrente.removeAll(matUsoCorrenteAdd);
//		
//		request.getSession().setAttribute("materiaisGeral", materiaisGeral);
//		request.getSession().setAttribute("materiaisClinico", materiaisClinico);
//		request.getSession().setAttribute("materiaisConcorrente", materiaisConcorrente);
//		
//		request.getSession().setAttribute("matGeralAdd", matGeralAdd);
//		request.getSession().setAttribute("matUsoClinicoAdd", matUsoClinicoAdd);
//		request.getSession().setAttribute("matUsoCorrenteAdd", matUsoCorrenteAdd);
	}
	
	private boolean validarArquivo(String titulo){
		boolean retorno = false;
		
		if(titulo.toUpperCase().endsWith(".PDF")){
			retorno = true;
		}else if(titulo.toUpperCase().endsWith(".DOC")){
			retorno = true;
		}else if(titulo.toUpperCase().endsWith(".DOCX")){
			retorno = true;
		}
		
		return retorno;
	}
		
}
