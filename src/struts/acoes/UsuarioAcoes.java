package struts.acoes;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Endereco;
import model.curso.Curso;
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

import fachada.Fachada;

public class UsuarioAcoes extends DispatchAction {
	
	private static final String fUSUARIOADD = "fUsuarioAdd";
	private static final String fUSUARIOEXTERNOADD = "fUsuarioExternoAdd";
	private static final String fUSUARIOEDIT = "fUsuarioEdit";
	private static final String fUSUARIOBUSCA = "fUsuarioBusca";
	private static final String fUSUARIOALTERARSENHA = "fUsuarioAlterarSenha";
	
	
	private Fachada fachada;
	
	public UsuarioAcoes(){
		fachada = Fachada.getInstancia();
	}
	
	public ActionForward mostrarTelaUsuarioAdd(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward retorno = map.findForward(fUSUARIOADD);
		return retorno;
	}
	
	public ActionForward mostrarTelaUsuarioExternoAdd(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward retorno = map.findForward(fUSUARIOEXTERNOADD);
		
		List<Curso> cursos = fachada.getTodosCursosPorStatus(Curso.PREVISTO, Curso.ANDAMENTO);
		request.getSession().setAttribute("cursos", cursos);
		
		return retorno;
	}
	
	public ActionForward mostrarTelaUsuarioEdit(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward retorno = map.findForward(fUSUARIOEDIT);
		String id = ((DynaActionForm)form).getString("id");
		Usuario usuarioEdit = fachada.getUsuarioPorId(Integer.parseInt(id));
		
		if(usuarioEdit instanceof Professor){
			Professor professor = (Professor) usuarioEdit;
			professor.setTipoUsuario(TipoUsuario.PROFESSOR);
			request.getSession().setAttribute("usuarioEdit", professor);
		}else if(usuarioEdit instanceof Administrador){
			Administrador admin = (Administrador) usuarioEdit;
			admin.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
			request.getSession().setAttribute("usuarioEdit", admin);
		}else if(usuarioEdit instanceof Aluno){
			Aluno aluno = (Aluno) usuarioEdit;
			aluno.setTipoUsuario(TipoUsuario.ALUNO);
			request.getSession().setAttribute("usuarioEdit", aluno);
		}
		
		return retorno;
	}
	
	public ActionForward mostrarTelaUsuarioBuscar(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward retorno = map.findForward(fUSUARIOBUSCA);
		ActionMessages errors = new ActionMessages();
		try{
			List<Usuario> usuarios = fachada.getTodosUsuarios();
			for (Usuario usuario : usuarios) {
				if(usuario instanceof Professor){
					usuario.setTipoUsuario(TipoUsuario.PROFESSOR);
				}else if(usuario instanceof Administrador){
					usuario.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
				}else if(usuario instanceof Aluno){
					usuario.setTipoUsuario(TipoUsuario.ALUNO);
				}
			}
			
			request.getSession().setAttribute("usuarios", usuarios);
		}catch (Exception e) {
			e.printStackTrace();
			errors.add("ConexaoBDException", new ActionMessage("erro.sistema"));
			this.saveErrors(request, errors);
		}
		return retorno;
	}
	
	public ActionForward buscarUsuarios(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward retorno = map.findForward(fUSUARIOBUSCA);
		ActionMessages errors = new ActionMessages();
		try{
			String tipo = ((DynaActionForm)form).getString("tipoDeBusca");
			String valor = ((DynaActionForm)form).getString("tfBusca");
		
			List<Usuario> usuarios = fachada.getUsuariosPorConsulta(tipo, valor);
			request.getSession().setAttribute("usuarios", usuarios);
		}catch (Exception e) {
			e.printStackTrace();
			errors.add("ConexaoBDException", new ActionMessage("erro.sistema"));
			this.saveErrors(request, errors);
		}
		return retorno;
	}
	
	public ActionForward usuarioAdd(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward retorno = null;
		
		String nome = ((DynaActionForm)form).getString("nome");
		String cpf = ((DynaActionForm)form).getString("cpf");
		String endereco = ((DynaActionForm)form).getString("endereco");
		String numero = ((DynaActionForm)form).getString("numero");
		String bairro = ((DynaActionForm)form).getString("bairro");
		String email = ((DynaActionForm)form).getString("email");
		String cep = ((DynaActionForm)form).getString("cep");
		String cidade = ((DynaActionForm)form).getString("cidade");
		String federacao = ((DynaActionForm)form).getString("federacao");
		String sexo = ((DynaActionForm)form).getString("sexo");
		String pto_referencia = ((DynaActionForm)form).getString("pto_referencia");
		String tipoUsuario = ((DynaActionForm)form).getString("restricaoAcesso");
		String login = ((DynaActionForm)form).getString("login");
		String senha = ((DynaActionForm)form).getString("senha");
		String confirmasenha = ((DynaActionForm)form).getString("confirmasenha");
		String acao = ((DynaActionForm)form).getString("acao");

		String cursos = ((DynaActionForm)form).getString("cursos");
		
		String erro = validarCampos(endereco, numero, bairro, cep, cidade, federacao, pto_referencia, nome, cpf, tipoUsuario, login, senha, confirmasenha,cursos, acao);
		
		if(erro.equals("")){
			if(acao.equals("usuarioAdd")){
				Endereco end = new Endereco(endereco, numero, bairro, cep, cidade, federacao, pto_referencia);
				try{
					if(tipoUsuario.equals(TipoUsuario.ALUNO.toString())){
						Aluno aluno = new Aluno();
						aluno.setEndereco(end);
						aluno.setNome(nome);
						aluno.setCpf(cpf);
						aluno.setLogin(login);
						aluno.setSenha(senha);
						aluno.setEmail(email);
						aluno.setSexo(sexo);
						aluno = fachada.criarUsuarioAluno(aluno);
						request.getSession().setAttribute("usuarioRet", aluno);
					}else if(tipoUsuario.equals(TipoUsuario.ADMINISTRADOR.toString())){
						Administrador admin = new Administrador();
						admin.setEndereco(end);
						admin.setCpf(cpf);
						admin.setNome(nome);
						admin.setLogin(login);
						admin.setSenha(senha);
						admin.setEmail(email);
						admin.setSexo(sexo);
						admin = fachada.criarUsuarioAdministrador(admin);
						request.getSession().setAttribute("usuarioRet", admin);
					}else if(tipoUsuario.equals(TipoUsuario.PROFESSOR.toString())){
						Professor professor = new Professor();
						professor.setEndereco(end);
						professor.setCpf(cpf);
						professor.setNome(nome);
						professor.setLogin(login);
						professor.setSenha(senha);
						professor.setEmail(email);
						professor.setSexo(sexo);
						professor = fachada.criarUsuarioProfessor(professor);
						request.getSession().setAttribute("usuarioRet", professor);
					}
					request.setAttribute("mensagem", "Usuário adicionado com sucesso!");
					
				}catch (Exception e) {
					request.setAttribute("mensagem", "Erro ao conectar com o banco de dados!");
				}
			}else{
				Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioEdit");
				Endereco end = new Endereco(endereco, numero, bairro, cep, cidade, federacao, pto_referencia);
				end.setId(usuario.getEndereco().getId());
				
				if(usuario.getClass() == Professor.class){
					Professor professor = (Professor) usuario;
					professor.setEndereco(end);
					professor.setCpf(cpf);
					professor.setNome(nome);
					professor.setEmail(email);
					professor.setSexo(sexo);
					fachada.criarUsuarioProfessor(professor);
					request.getSession().setAttribute("usuarioEdit", professor);
				}else if(usuario.getClass() == Administrador.class){
					Administrador admin = (Administrador) usuario;
					admin.setEndereco(end);
					admin.setCpf(cpf);
					admin.setNome(nome);
					admin.setEmail(email);
					admin.setSexo(sexo);
					fachada.criarUsuarioAdministrador(admin);
					request.getSession().setAttribute("usuarioEdit", admin);
				}else if(usuario.getClass() == Aluno.class){
					Aluno aluno = (Aluno) usuario;
					aluno.setEndereco(end);
					aluno.setNome(nome);
					aluno.setCpf(cpf);
					aluno.setEmail(email);
					aluno.setSexo(sexo);
					fachada.criarUsuarioAluno(aluno);
					request.getSession().setAttribute("usuarioEdit", aluno);
				}
				
				request.setAttribute("mensagem", "Usuário editado com sucesso!");
			}
			
		}else{
			request.setAttribute("mensagem", erro);
		}

		if(acao.equals("usuarioAdd")){
			retorno = map.findForward(fUSUARIOADD);
		}else{
			retorno = map.findForward(fUSUARIOEDIT);
		}
		
		return retorno;
	}
	
	public ActionForward usuarioExternoAdd(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward retorno = null;
		
		String nome = ((DynaActionForm)form).getString("nome");
		String cpf = ((DynaActionForm)form).getString("cpf");
		String endereco = ((DynaActionForm)form).getString("endereco");
		String numero = ((DynaActionForm)form).getString("numero");
		String bairro = ((DynaActionForm)form).getString("bairro");
		String email = ((DynaActionForm)form).getString("email");
		String cep = ((DynaActionForm)form).getString("cep");
		String cidade = ((DynaActionForm)form).getString("cidade");
		String federacao = ((DynaActionForm)form).getString("federacao");
		String sexo = ((DynaActionForm)form).getString("sexo");
		String pto_referencia = ((DynaActionForm)form).getString("pto_referencia");
		String tipoUsuario = ((DynaActionForm)form).getString("restricaoAcesso");
		String login = ((DynaActionForm)form).getString("login");
		String instituicaoOrigem = ((DynaActionForm)form).getString("instituicaoOrigem");
		String senha = ((DynaActionForm)form).getString("senha");
		String confirmasenha = ((DynaActionForm)form).getString("confirmasenha");
		String acao = ((DynaActionForm)form).getString("acao");
		
		String cursos = "";
		if(tipoUsuario.equals(TipoUsuario.ALUNO.toString())){
			cursos = ((DynaActionForm)form).getString("cursos");
		}
			
		
		String erro = validarCamposAddExterno(endereco, numero, bairro, cep, cidade, federacao, pto_referencia, nome, cpf, tipoUsuario, login, senha, confirmasenha,cursos,instituicaoOrigem, acao);
		
		if(erro.equals("")){
			if(acao.equals("usuarioExternoAdd")){
				Endereco end = new Endereco(endereco, numero, bairro, cep, cidade, federacao, pto_referencia);
				try{
					if(tipoUsuario.equals(TipoUsuario.ALUNO.toString())){

						Aluno aluno = new Aluno();
						aluno.setEndereco(end);
						aluno.setNome(nome);
						aluno.setCpf(cpf);
						aluno.setLogin(login);
						aluno.setSenha(senha);
						aluno.setEmail(email);
						aluno.setSexo(sexo);
						aluno.setInstituicaoOrigem(instituicaoOrigem);
						aluno = fachada.criarUsuarioAluno(aluno);
						aluno.setTipoUsuario(TipoUsuario.ALUNO);

						String[] cursosArray = cursos.split(",");
						List<Curso> listaCursos = new ArrayList<Curso>();
						for (int i = 0; i < cursosArray.length; i++) {
							String cursoSelecionado = cursosArray[i];
							Curso curso = new Curso(Integer.parseInt(cursoSelecionado));
							listaCursos.add(curso);
						}
						request.getSession().setAttribute("listaCursos", listaCursos);
						request.getSession().setAttribute("usuarioRet", aluno);

						fachada.matricularAlunoCursos(aluno, listaCursos);
						
					}else if(tipoUsuario.equals(TipoUsuario.PROFESSOR.toString())){
						Professor prof = new Professor();
						prof.setEndereco(end);
						prof.setNome(nome);
						prof.setCpf(cpf);
						prof.setLogin(login);
						prof.setSenha(senha);
						prof.setEmail(email);
						prof.setSexo(sexo);
						prof.setInstituicaoOrigem(instituicaoOrigem);
						prof = fachada.criarUsuarioProfessor(prof);
						prof.setTipoUsuario(TipoUsuario.PROFESSOR);
						request.getSession().setAttribute("usuarioRet", prof);
						request.getSession().setAttribute("listaCursos", null);
					}
					request.setAttribute("mensagem", "Usuário adicionado com sucesso!");
					
				}catch (Exception e) {
					request.setAttribute("mensagem", "Erro ao conectar com o banco de dados!");
				}
			}
			
		}else{
			request.setAttribute("mensagem", erro);

			Usuario user = carregarCamposForm(endereco, numero, bairro, cep, cidade, federacao, pto_referencia, nome, cpf, tipoUsuario, login, instituicaoOrigem, email);
			List<Curso> listaCursos = new ArrayList<Curso>();
			String listaCursosString = "";
			if(!cursos.equals("") && (tipoUsuario.equals(TipoUsuario.ALUNO.toString()) )){
				String[] cursosArray = cursos.split(",");
				for (int i = 0; i < cursosArray.length; i++) {
					String cursoSelecionado = cursosArray[i];
					Curso curso = new Curso(Integer.parseInt(cursoSelecionado));
					listaCursos.add(curso);
					if(i == 0){
						listaCursosString += cursoSelecionado;
					}else{
						listaCursosString += ","+cursoSelecionado;
					}
				}
			}
			request.getSession().setAttribute("usuarioRet", user);
			request.getSession().setAttribute("listaCursosString", listaCursosString);
			request.getSession().setAttribute("listaCursos", listaCursos);
		}

		if(acao.equals("usuarioExternoAdd")){
			retorno = map.findForward(fUSUARIOEXTERNOADD);
		}
		
		return retorno;
	}
	
	public ActionForward mostrarUsuarioAlterarSenha(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward retorno =  map.findForward(fUSUARIOALTERARSENHA);
		return retorno;
	}
	
	public ActionForward usuarioAlterarSenha(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		String senhaAntiga = ((DynaActionForm)form).getString("senhaAntiga");
		String senhaNova = ((DynaActionForm)form).getString("senhaNova");
		String senhaConfirmar = ((DynaActionForm)form).getString("senhaConfirmar");
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioEdit");
		String erro = validarAlterarSenhaCampos(usuario.getSenha(), senhaAntiga, senhaNova, senhaConfirmar);
		
		if(erro.equals("")){
			usuario.setSenha(senhaNova);
			fachada.saveOrUpdateUsuario(usuario);
			request.getSession().setAttribute("usuarioEdit", usuario);
			request.setAttribute("mensagem", "Senha alterada com sucesso!");
		}else{
			request.setAttribute("mensagem", erro);
		}
		
		ActionForward retorno =  map.findForward(fUSUARIOALTERARSENHA);
		return retorno;
	}
	
	/**Métodos Privados*/
	private String validarAlterarSenhaCampos(String senhaUsuario, String senhaAntiga, String senhaNova, String senhaConfirmar){
		String erro = "";
		
		if(!senhaAntiga.equals(senhaUsuario)){
			erro += "Senha antiga do usuário inválida, ";
		}
		if(!senhaNova.equals(senhaConfirmar)){
			erro += "Confirmar Senha não confere com Senha Nova!";
		}
		
		return erro;
	}
	
	
	private String validarCampos(String endereco, String numero, String bairro,
			String cep, String cidade, String federacao, String pto_referencia,
			String nome, String cpf, String tipoUsuario,
			String login, String senha, String confirmasenha, String cursos, String acao) {
		String erro = "";
		
		if(endereco.equals("")){
			erro += " Endereço inválido ";
		}if(numero.equals("")){
			erro += " Número inválido ";
		}if(bairro.equals("")){
			erro += " Bairro inválido ";
		}if(cep.equals("")){
			erro += " CEP inválido ";
		}if(cidade.equals("")){
			erro += " Cidade inválida ";
		}if(federacao.equals("")){
			erro += " Estado inválido ";
		}if(nome.equals("")){
			erro += " Nome inválido ";
		}if(cpf.equals("")  && !acao.equals("usuarioAlunoAdd")){
			erro += " CPF inválido ";
		}if(login.equals("") && acao.equals("usuarioAdd")){
			erro += " Login inválido ";
		}if(numero.equals("")){
			erro += " Número inválido ";
		}if(senha.equals("") && acao.equals("usuarioAdd")){
			erro += " Senha inválida ";
		}if(!senha.equals(confirmasenha) && acao.equals("usuarioAdd")){
			erro += " Senhas não conferem ";
		}if(!senha.equals(confirmasenha) && acao.equals("usuarioAlunoAdd")){
			erro += " Senhas não conferem ";
		}if(cursos.equals("") && (tipoUsuario.equals(TipoUsuario.ALUNO.toString()) )){
			erro += " Selecione um Curso ";
		}
		
		return erro;
	}
	
	private String validarCamposAddExterno(String endereco, String numero, String bairro,
			String cep, String cidade, String federacao, String pto_referencia,
			String nome, String cpf, String tipoUsuario,
			String login, String senha, String confirmasenha, String cursos, String instituicaoOrigem, String acao) {
		String erro = "";
		
		if(endereco.equals("")){
			erro += " Endereço inválido <br /> ";
		}if(numero.equals("")){
			erro += " Número inválido   <br /> ";
		}if(bairro.equals("")){
			erro += " Bairro inválido <br />";
		}if(cep.equals("")){
			erro += " CEP inválido <br />";
		}if(cidade.equals("")){
			erro += " Cidade inválida <br />";
		}if(federacao.equals("")){
			erro += " Estado inválido <br />";
		}if(nome.equals("")){
			erro += " Nome inválido <br />";
		}if(cpf.equals("") ){
			erro += " CPF inválido <br />";
		}if(login.equals("")){
			erro += " Login inválido  <br />";
		}if(!login.equals("")){
			if(Fachada.getInstancia().getUsuariosPorConsulta("login", login) != null && !Fachada.getInstancia().getUsuariosPorConsulta("login", login).isEmpty() ){
				erro += " Login já em uso <br />";
			}
		}if(senha.equals("") ){
			erro += " Senha inválida  <br />";
		}if(instituicaoOrigem.equals("") ){
			erro += " Instituiçao de Origem inválida  <br />";
		}if(!senha.equals(confirmasenha)){
			erro += " Senhas não conferem <br />";
		}if(cursos.equals("") && (tipoUsuario.equals(TipoUsuario.ALUNO.toString()) )){
			erro += " Selecione um Curso <br />";
		}
		
		return erro;
	}
	
	private Usuario carregarCamposForm(String endereco, String numero, String bairro,
			String cep, String cidade, String federacao, String pto_referencia,
			String nome, String cpf, String tipoUsuario,
			String login, String instituicaoOrigem, String email) {
		Usuario user = null;
		if(tipoUsuario.equals(TipoUsuario.ALUNO.toString())){
			user = new Aluno();
		}else{
			user= new Professor();
		}
		Endereco end = new Endereco();
		
		if(!endereco.equals("")){
			end.setReferencia(endereco);
		}if(!numero.equals("")){
			end.setNumero(numero);
		}if(!bairro.equals("")){
			end.setBairro(bairro);
		}if(!cep.equals("")){
			end.setCep(cep);
		}if(!cidade.equals("")){
			end.setCidade(cidade);
		}if(!federacao.equals("")){
			end.setEstado(federacao);
		}if(!nome.equals("")){
			user.setNome(nome);
		}if(!cpf.equals("") ){
			user.setCpf(cpf);
		}if(!login.equals("")){
			user.setLogin(login);
		}if(!email.equals("")){
			user.setEmail(email);
		}if(!instituicaoOrigem.equals("")){
			if(user instanceof Aluno){
				((Aluno) user).setInstituicaoOrigem(instituicaoOrigem);
			}else{
				((Professor) user).setInstituicaoOrigem(instituicaoOrigem);
			}
		}if(!tipoUsuario.equals("") && tipoUsuario.equals(TipoUsuario.ALUNO.toString()) ){
			user.setTipoUsuario(TipoUsuario.ALUNO);
		}if(!tipoUsuario.equals("") && tipoUsuario.equals(TipoUsuario.PROFESSOR.toString()) ){
			user.setTipoUsuario(TipoUsuario.PROFESSOR);
		}
		
		user.setEndereco(end);
		
		return user;
	}

}
