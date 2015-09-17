<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

  <jsp:include page="../inc_header.jsp"  flush="true"/>
    
</head>
<body>

<div id="container">

	  <jsp:include page="../inc_topo.jsp"  flush="true"/>
    
    <div id="middle">    
		<div id="middle_align">

            <div id="wrapper" class="logado professor">
            
            <div class="col w90 p0_5">
                <h3>Seja bem-vindo ao seu espaço!</h3>
                <p>&nbsp;</p>          
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
                
                <c:forEach items="${cursos}" var="curso" varStatus="index">
	            	<tr>
	                	<td><a href="estudosCasosProf.do?method=mostrarTelaListaEstudosDeCaso&idCurso=${ curso.id}">CR<c:out value="${curso.id}"></c:out></a></td>
	                    <td><a href="estudosCasosProf.do?method=mostrarTelaListaEstudosDeCaso&idCurso=${ curso.id}"><c:out value="${curso.titulo}"></c:out></a></td>
	                    <td><a href="estudosCasosProf.do?method=mostrarTelaListaEstudosDeCaso&idCurso=${ curso.id}">De <c:out value="${curso.dataInicioFormatada}"></c:out> até <c:out value="${curso.dataFimFormatada}"></c:out></a></td>
	                    <td><a href="estudosCasosProf.do?method=mostrarTelaListaEstudosDeCaso&idCurso=${ curso.id}"><c:out value="${curso.professor.nome}"></c:out></a></td>
	                    
	                    <c:if test="${curso.statusDescricao == 'em andamentos'}">
		                    <td><a href="estudosCasosProf.do?method=mostrarTelaListaEstudosDeCaso&idCurso=${ curso.id}"><img src="imagens/icons/Play-1-Normal-Red-icon.png" title="Curso em andamento" /></a></td>
	                    </c:if>
                        <c:if test="${curso.statusDescricao == 'em pausa ou suspenso'}">
		                    <td><a href="estudosCasosProf.do?method=mostrarTelaListaEstudosDeCaso&idCurso=${ curso.id}"><img src="imagens/icons/Pause-Normal-Red-icon.png" title="Curso em pausa ou suspenso" /></a></td>
	                    </c:if>
	    				<c:if test="${curso.statusDescricao == 'previsto'}">
		                    <td><a href="estudosCasosProf.do?method=mostrarTelaListaEstudosDeCaso&idCurso=${ curso.id}"><img src="imagens/icons/Play-1-Disabled-icon.png" title="Curso Previsto" /></a></td>
	                    </c:if>
	                    <c:if test="${curso.statusDescricao == 'bloqueado'}">
		                    <td><a href="estudosCasosProf.do?method=mostrarTelaListaEstudosDeCaso&idCurso=${ curso.id}"><img src="imagens/icons/restrict.gif" title="Curso bloqueado" /></a></td>
	                    </c:if>
       		            <c:if test="${curso.statusDescricao == 'concluído'}">
		                    <td><a href="estudosCasosProf.do?method=mostrarTelaListaEstudosDeCaso&idCurso=${ curso.id}"><img src="imagens/icons/Actions-dialog-ok-apply-icon.png" title="Curso concluído" /></a></td>
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

</body>
</html>    