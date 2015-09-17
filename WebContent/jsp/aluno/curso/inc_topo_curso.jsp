<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
	<div id="header">
    	<div id="header_width">
            <div id="header_l">
                <p class="logo"><a href="sistema.do?method=mostrarTelaLogon">PenSAE</a></p>
	            <h1>
	            	<a href="detalheCurso.do?method=mostrarTelaDetalheCurso&idMatricula=${matricula.id }">CURSO: CR<c:out value="${matricula.curso.id}"></c:out> <c:out value="${matricula.curso.titulo}"></c:out>
    	        	<br/>
	            	<span>Período: De <c:out value="${matricula.curso.dataInicioFormatada}"></c:out> até <c:out value="${matricula.curso.dataFimFormatada}"></c:out></span></a>
           		</h1>                
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
                            	<li><a href="listarCursos.do?method=mostrarTelaListarCursos">Cursos</a></li>
                                <li class="linha"></li>
                            	<li><a href="#">Sobre</a></li>
                            	<li><a href="baixarArquivo.do?method=baixarArquivo&idArquivo=62">Tutorial</a></li>
                            	<li><a href="#">Mapa do Site</a></li>
                            	<!-- <li><a href="#">Ajuda</a></li> -->
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
                                
            <div id="nav">
                <ul>	
                		<li><a href="detalheCurso.do?method=mostrarTelaDetalheCurso&idMatricula=${matricula.id }" title="curso">Curso: CR<c:out value="${matricula.curso.id}"></c:out></a></li>
                        <!-- <li><a href="ambulatorio.do?method=mostrarTelaAmbulatorio&idMatricula=${matricula.id }" title="Organizar Ambulatorio">Organizar Ambulatório</a> --!>
                        </li>
                        <li><a href="detalheEstudoCaso.do?method=mostrarTelaListaEstudosDeCaso" title="Estudo de Casos">Estudos de Casos</a>
                        </li>
                        <li><a href="#" title="">Avaliação</a>
                        	<span style="margin-top:-10px;"></span>
                            <ul style="margin-top:-10px;">
                                <li><a href="mostrarTelaOpniaoSobreCurso.do?method=mostrarTelaOpniaoSobreCurso">Minha opinião sobre o curso</a></li>
                                <li><a href="mostrarTelaFeedbackCurso.do?method=mostrarTelaFeedbackCurso">Feedback por estudo de caso</a></li>
                            </ul>
                        </li>
                        <!--  -->
                        <!-- <li><a href="#" title="">Ferramentas</a>
                        	<span></span>
                            <ul>
                                <li><a href="#">Material Pedagógico</a></li>
                                <li><a href="#">Busca</a></li>
                                <li><a href="#">Glossário</a></li>
                            </ul>
                        </li>
                        <li><a href="#" title="Comunicacao">Comunicação</a>
                        	<span></span>
                            <ul>
                                <li><a href="#">Fórum</a></li>
                                <li><a href="#">Construção compartilhada</a></li>
                            </ul>
                        </li> -->
                </ul>
            </div> <!-- /#nav -->
               
		</div>
    </div><!-- /#header -->



