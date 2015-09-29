<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

  <jsp:include page="../../../inc_header.jsp"  flush="true"/>
 		 
    
</head>
<body>

<div id="container">

	  <jsp:include page="../inc_topo_curso.jsp"  flush="true"/>
    
    <div id="middle">    
		<div id="middle_align">

            <div id="wrapper" class="logado caso">
            
        	  <h3 class="bread">CR<c:out value="${matricula.curso.id}"></c:out> > Estudo de Casos</h3>

			<table >
            	<tr>
                	<th>Cód</th>
                    <th>Caso</th>
                    <th>Descrição</th>
                    <th>Status</th>
                </tr>
            	
            	
                 <c:forEach items="${estudosDeCasos}" var="estudo" varStatus="index">
	            	<tr>
	            		<td><a href="estudoCaso.do?method=mostrarTelaInvestigacao&idEstudoCaso=${ estudo.id}">EC<c:out value="${estudo.id}"></c:out></a></td>
	                    <td><a href="estudoCaso.do?method=mostrarTelaInvestigacao&idEstudoCaso=${ estudo.id}"><c:out value="${estudo.titulo}"></c:out></a></td>
	                    <td><a href="estudoCaso.do?method=mostrarTelaInvestigacao&idEstudoCaso=${ estudo.id}">${estudo.descricaoResumida}...</a></td>
	                    
	                    <td align="right">
	                    	<a href="estudoCaso.do?method=mostrarTelaInvestigacao&idEstudoCaso=${ estudo.id}">
			                    <c:if test="${estudo.statusDescricao == 'em andamentos'}">
				                   <img src="imagens/icons/Play-1-Normal-Red-icon.png" title="Estudo de Caso em andamento" />
			                    </c:if>
		                        <c:if test="${estudo.statusDescricao == 'em pausa ou suspenso'}">
				                   <img src="imagens/icons/Pause-Normal-Red-icon.png" title="Estudo de Caso em pausa ou suspenso" />
			                    </c:if>
			    				<c:if test="${estudo.statusDescricao == 'previsto'}">
				                   <img src="imagens/icons/Play-1-Disabled-icon.png" title="Estudo de Caso Previsto" />
			                    </c:if>
			                    <c:if test="${estudo.statusDescricao == 'bloqueado'}">
				                   <img src="imagens/icons/restrict.gif" title="Estudo de Caso bloqueado" />
			                    </c:if>
		       		            <c:if test="${estudo.statusDescricao == 'concluído'}">
				                   <img src="imagens/icons/Actions-dialog-ok-apply-icon.png" title="Estudo de Caso concluído" />
			                    </c:if>
	                    	</a>
	                    </td>
	            	</tr>
	            </c:forEach>


            </table>
                
            </div><!-- /#wrapper -->

    	</div><!-- /#middle_align -->
    		<div style="width: 100%; height: 350px;"></div>
    </div><!-- /#middle -->    
    
	<jsp:include page="../../../inc_rodape.jsp"  flush="true"/>
  
    
</div><!-- /#container -->
</body>
</html>    