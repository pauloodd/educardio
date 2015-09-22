<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
	<div id="header">
    	<div id="header_width">
            <div id="header_l">
                <p class="logo"><a href="/isa">ISA</a></p>
	                           
            </div><!-- /#header_l -->
            
            <div id="header_r">
            	<%
					if(session.getAttribute("usuario") != null){
				%>
                <div id="member">
                	<ul>
                    	<li><a href="#" class="logar" title="Menu do usuário"><c:out value="${usuario.nome}"></c:out></a>
                        	<span></span>
                            <ul>
                            	<li><a href="listarCursos.do?method=mostrarTelaListarCursos">Início</a></li>
                            	<li><a href="#">Meu Perfil</a></li>
                            	<c:if test="${usuario.tipoUsuario == 'PROFESSOR' }">
	                            	<li><a href="listarCursosProf.do?method=mostrarTelaListarCursos">Cursos</a></li>
                            	</c:if>
                                <c:if test="${usuario.tipoUsuario == 'ALUNO' }">
	                            	<li><a href="listarCursos.do?method=mostrarTelaListarCursos">Cursos</a></li>
                            	</c:if>
                                <li class="linha"></li>
                            	<li><a href="#">Sobre</a></li>
                            	<li><a href="baixarArquivo.do?method=baixarArquivo&idArquivo=62">Tutorial</a></li>
                            	<li><a href="#">Mapa do Site</a></li>
                            	<li class="linha"></li>
                            	<!-- <li><a href="#">Ajuda</a></li> -->
                            	<li><a target="_blank" href="mailto:roseane_lgv@yahoo.com.br">Contato - Email</a></li>
                            	<li><a target="_blank" href="tel:81-99749525">Contato - Tel.</a></li>
								<li class="linha"></li>
                            	<li><a href="logoff.do?method=logoff">Sair</a></li>
	
                            </ul>
                        </li>
                    </ul>
                </div>
                <%
					}else{
				
				%>
						
                <%
						}
					%>
                
            </div><!-- /#header_r -->
    
		</div>
    </div><!-- /#header -->



