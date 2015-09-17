<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

  <jsp:include page="../inc_header.jsp"  flush="true"/>
    <script language="JavaScript" type="text/javascript" src="js/popup.js" ></script>
	
        <link rel="stylesheet" href="css/popup.css" type="text/css" media="screen" />	
 		 
    
</head>
<body>

<div id="container">

	  <jsp:include page="../inc_topo.jsp"  flush="true"/>
    
    <div id="middle">    
		<div id="middle_align">

            <div id="wrapper" class="logado aluno">
            
            <div class="col w90 p0_5">
                <h3>Seja bem-vindo ao seu espaço!</h3>
                <p>Veja os cursos em que você está matriculado:</p>
                <p>&nbsp;</p>           <input type="button" value="Matricular-se em novos cursos" id="button"/>
            </div>
			<br clear="all" />

			<table >
            	<tr>
                	<th>Cód</th>
                    <th>Curso</th>
                    <th>Período</th>
                    <th>Professor Responsável</th>
                    <th>Status</th>
                </tr>
                
                <c:forEach items="${matriculas}" var="matricula" varStatus="index">
	            	<tr>
	                	<td><a href="detalheCurso.do?method=mostrarTelaDetalheCurso&idMatricula=${ matricula.id}">CR<c:out value="${matricula.curso.id}"></c:out></a></td>
	                    <td><a href="detalheCurso.do?method=mostrarTelaDetalheCurso&idMatricula=${ matricula.id}"><c:out value="${matricula.curso.titulo}"></c:out></a></td>
	                    <td><a href="detalheCurso.do?method=mostrarTelaDetalheCurso&idMatricula=${ matricula.id}">De <c:out value="${matricula.curso.dataInicioFormatada}"></c:out> até <c:out value="${matricula.curso.dataFimFormatada}"></c:out></a></td>
	                    <td><a href="detalheCurso.do?method=mostrarTelaDetalheCurso&idMatricula=${ matricula.id}"><c:out value="${matricula.curso.professor.nome}"></c:out></a></td>
	                    
	                    <c:if test="${matricula.curso.statusDescricao == 'em andamentos'}">
		                    <td><a href="detalheCurso.do?method=mostrarTelaDetalheCurso&idMatricula=${ matricula.id}"><img src="imagens/icons/Play-1-Normal-Red-icon.png" title="Curso em andamento" /></a></td>
	                    </c:if>
                        <c:if test="${matricula.curso.statusDescricao == 'em pausa ou suspenso'}">
		                    <td><a href="detalheCurso.do?method=mostrarTelaDetalheCurso&idMatricula=${ matricula.id}"><img src="imagens/icons/Pause-Normal-Red-icon.png" title="Curso em pausa ou suspenso" /></a></td>
	                    </c:if>
	    				<c:if test="${matricula.curso.statusDescricao == 'previsto'}">
		                    <td><a href="detalheCurso.do?method=mostrarTelaDetalheCurso&idMatricula=${ matricula.id}"><img src="imagens/icons/Play-1-Disabled-icon.png" title="Curso Previsto" /></a></td>
	                    </c:if>
	                    <c:if test="${matricula.curso.statusDescricao == 'bloqueado'}">
		                    <td><a href="detalheCurso.do?method=mostrarTelaDetalheCurso&idMatricula=${ matricula.id}"><img src="imagens/icons/restrict.gif" title="Curso bloqueado" /></a></td>
	                    </c:if>
       		            <c:if test="${matricula.curso.statusDescricao == 'concluído'}">
		                    <td><a href="detalheCurso.do?method=mostrarTelaDetalheCurso&idMatricula=${ matricula.id}"><img src="imagens/icons/Actions-dialog-ok-apply-icon.png" title="Curso concluído" /></a></td>
	                    </c:if>
	             	</tr>
		        </c:forEach>
            	
            	

            </table>
                
            </div><!-- /#wrapper -->

    	</div><!-- /#middle_align -->
    		<div style="width: 100%; height: 200px;"></div>
    </div><!-- /#middle -->    
    
	<jsp:include page="../inc_rodape.jsp"  flush="true"/>
  
    
</div><!-- /#container -->

<div id="popupContact" style="position: absolute; top: 184.167px; left: 0px; display: none;">
		<a id="popupContactClose">sair</a>
		<h1>Matricular-se em Novo Curso!</h1>
		<p id="contactArea">
			 <table >
            	<tr>
                	<th>Curso</th>
                    <th>Período</th>
                    <th>Adicionar</th>
                </tr>
                
                <c:forEach items="${cursosNovaMatricula}" var="curso" varStatus="index">
	            	<tr>
	                    <td><c:out value="${curso.titulo}"></c:out></td>
	                    <td>De <c:out value="${curso.dataInicioFormatada}"></c:out> até <c:out value="${curso.dataFimFormatada}"></c:out></td>
	                    <td>
	                    	<form name="matricularNovoCurso" method="post" action="matricularNovoCurso.do" >
									<h:hidden property="method" value="matricularNovoCurso"/>
									<input type="hidden" name="cursoId" value="${curso.id }" />
				                    <input type="submit" name="Adicionar" value="Adicionar" />
				                </form>  
                    	</td>
	                    
	             	</tr>
		        </c:forEach>
            	

            </table>
		</p>
	</div>
	<div id="backgroundPopup"></div>
</body>
</html>    