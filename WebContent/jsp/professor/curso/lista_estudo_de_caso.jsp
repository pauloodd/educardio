<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>


  <jsp:include page="../../inc_header.jsp"  flush="true"/>
  
      <script language="JavaScript" type="text/javascript" src="js/popup.js" ></script>
      <link rel="stylesheet" href="css/popup.css" type="text/css" media="screen" />	
     
  <script type="text/javascript" src="js/table.js"></script>
  <link media="all" href="css/table2.css" type="text/css" rel="stylesheet" />
  
  <script type="text/javascript">
		   
  			function selecionarArcoMaguerez(idArco, tituloEc, aluno){
					 var form = document.forms[0];
					 form.idArcoMaguerez.value = idArco;
					 
					 var div = document.getElementById('dadosArcoEscolhido');
					 div.innerHTML = 'EC: ' + tituloEc + ' <br /> Aluno:' + aluno;
					 
			 		centerPopup();
			 		loadPopup();
  			}
     </script>   
</head>
<body>

<div id="container">

	  <jsp:include page="../../inc_topo.jsp"  flush="true"/>
    
    <div id="middle">    
		<div id="middle_align">

            <div id="wrapper" class="logado caso">
            
        	  <h3 class="bread">CR<c:out value="${cursoId}"></c:out> > Estudo de Casos</h3>

				<table align='center' style='width:95% !important;' class='example table-autosort table-autofilter table-autopage:20 table-stripeclass:alternate table-page-number:t1page table-page-count:t1pages table-filtered-rowcount:t1filtercount table-rowcount:t1allcount'>
	                    <thead>
			            	<tr>
			                	<th class='table-sortable:default table-sortable'>Cód</th>
			                    <th>Estudo de Caso</th>
			                    <th class='table-sortable:default table-sortable' >Aluno</th>
			                    <th>Professor Responsável</th>
			                    <th>Fase do Arco</th>
			                </tr>
			                <tr>
								<th class='table-filterable' style="width: 40px !important;">
									
								</th>
								<th>
									
								</th>
								<th class=''>  
									<input name="filter" width="50" size="12" onkeyup="Table.filter(this,this)" />
								</th>
								<th class='table-filterable' style="width: 40px !important;">
								</th>
								<th style="width: 180px;">
								</th>
							</tr>
                		</thead>
                		<tbody>
                		
                <c:forEach items="${arcosMaguerezAlunos}" var="arco" varStatus="index">
                	  
	            	<tr>
	                	<td><a href="#" class="arco${ arco.id}">EC<c:out value="${arco.estudoDeCaso.id}"></c:out></a></td>
	                    <td><a href="#" class="arco${ arco.id}"><c:out value="${arco.estudoDeCaso.titulo}"></c:out></a></td>
	                    <td><a href="#" class="arco${ arco.id}"><c:out value="${arco.matriculaAluno.aluno.nome}"></c:out></a></td>
	                    <td><a href="#" class="arco${ arco.id}"><c:out value="${arco.matriculaAluno.curso.professor.nome}"></c:out></a></td>
	                    <td>
	                    	 <c:if test="${arco.faseDoArco == 0}">
						        <img src="imagens/icons/Play-1-Normal-Red-icon.png" />
					        </c:if>
					         <c:if test="${arco.faseDoArco > 0}">
						        <img src="imagens/icons/Actions-dialog-ok-apply-icon.png" />
					        </c:if>
	                    	<c:if test="${arco.faseDoArco < 1}">
						        <img src="imagens/icons/Play-1-Disabled-icon.png" />
					        </c:if>
					        <c:if test="${arco.faseDoArco == 1}">
						        <img src="imagens/icons/Play-1-Normal-Red-icon.png" />
					        </c:if>
					        <c:if test="${arco.faseDoArco > 1}">
						        <img src="imagens/icons/Actions-dialog-ok-apply-icon.png" />
					       </c:if>
					       <c:if test="${arco.faseDoArco < 2}">
						        <img src="imagens/icons/Play-1-Disabled-icon.png" />
					       </c:if>
					        <c:if test="${arco.faseDoArco == 2}">
						     	 <img src="imagens/icons/Play-1-Normal-Red-icon.png" />
					        </c:if>
					        <c:if test="${arco.faseDoArco > 2}">
						        <img src="imagens/icons/Actions-dialog-ok-apply-icon.png" />
					       </c:if>
					       <c:if test="${arco.faseDoArco < 3}">
						        <img src="imagens/icons/Play-1-Disabled-icon.png" />
					       </c:if>
					        <c:if test="${arco.faseDoArco == 3}">
						  	    <img src="imagens/icons/Play-1-Normal-Red-icon.png" />
					        </c:if>
					        <c:if test="${arco.faseDoArco > 3}">
						        <img src="imagens/icons/Actions-dialog-ok-apply-icon.png" />
					       </c:if>
					         <c:if test="${arco.faseDoArco < 4}">
						        <img src="imagens/icons/Play-1-Disabled-icon.png" />
					       </c:if>
					        <c:if test="${arco.faseDoArco == 4}">
						        <img src="imagens/icons/Play-1-Normal-Red-icon.png" />
					        </c:if>
					        <c:if test="${arco.faseDoArco > 4}">
						        <img src="imagens/icons/Actions-dialog-ok-apply-icon.png" />
					       </c:if>
	                    </td>
	             	</tr>
	             	<script type="text/javascript">
						     $('.arco<c:out value="${arco.id}"></c:out>').click(function(){
						 		
					    		   $("#pontos-chave-comentarios").val('<c:out value="${arco.pontosChave.avaliacaoProfessor.comentario}"></c:out>');
					    		   $("#pontos-chave-nota").val('<c:out value="${arco.pontosChave.avaliacaoProfessor.nota}"></c:out>');
					    		   
					    		   $("#teorizacao-comentarios").val('<c:out value="${arco.teorizacao.avaliacaoProfessor.comentario}"></c:out>');
					    		   $("#teorizacao-nota").val('<c:out value="${arco.teorizacao.avaliacaoProfessor.nota}"></c:out>');
					    		   
					    		   $("#hipoteses-comentarios").val('<c:out value="${arco.hipotesesDeSolucao.avaliacaoProfessor.comentario}"></c:out>');
					    		   $("#hipoteses-nota").val('<c:out value="${arco.hipotesesDeSolucao.avaliacaoProfessor.nota}"></c:out>');
					    		   
					    		   $("#dadosArcoEscolhido").html('EC: <c:out value="${arco.estudoDeCaso.titulo}"></c:out> <br /> Aluno: <c:out value="${arco.matriculaAluno.aluno.nome}"></c:out>');
					    		   $("#idArcoMaguerez").val('<c:out value="${arco.id}"></c:out>');
					    		   
							 		centerPopup();
							 		loadPopup();
						    	
						 	});
				     </script>   
		        </c:forEach>
				</tbody>
				<tfoot>
							
							<tr>
								<td style="cursor:pointer;" class="table-page:previous">&lt; &lt; Anterior</td>
								<td style="text-align:center;" colspan="3">Pag <span id="t1page">1</span>&nbsp;de <span id="t1pages">11</span></td>
								<td style="cursor:pointer;" class="table-page:next">Próximo &gt; &gt;</td>
							</tr>
							<tr>
								<td colspan="5"><span id="t1filtercount">105</span>&nbsp;de <span id="t1allcount">105</span>&nbsp;linhas encontradas</td>
						</tr>
						</tfoot>
            </table>
                
            </div><!-- /#wrapper -->

    	</div><!-- /#middle_align -->
    		<div style="width: 100%; height: 350px;"></div>
    </div><!-- /#middle -->    
    
	<jsp:include page="../../inc_rodape.jsp"  flush="true"/>
  
    
</div><!-- /#container -->

<div id="popupContact" style="position: absolute; top: 184.167px; left: 0px; display: none; height: auto !important;">
		<a id="popupContactClose">sair</a>
		<h1 style="margin-bottom: 0px !important;">Avaliação!</h1>
		<p id="contactArea">
		<div id="dadosArcoEscolhido"></div>
		<h:form action="adicionarMencaoArcoMaguerezProf" >
					<h:hidden property="method" value="adicionarMencaoArcoMaguerez"/>
					<input type="hidden" name="idArcoMaguerez" id="idArcoMaguerez"  value=""/>
				<b>Pontos-Chaves:</b><br />
				<textarea name="pontos-chave-comentarios" id="pontos-chave-comentarios" style="width: 300px !important;"></textarea><br />
				Menção:
				<select name="pontos-chave-nota" id="pontos-chave-nota" style="width:300px !important;">
					<option value=""></option>
					<option value="Atingiu o objetivo (A)">Atingiu o objetivo (A)</option>
					<option value="Atingiu parcialmente o objetivo (AP)">Atingiu parcialmente o objetivo (AP)</option>
					<option value="Não atingiu o objetivo (NA)">Não atingiu o objetivo (NA)</option>
				</select><br />
				
				<b>Teorização:</b><br />
				<textarea name="teorizacao-comentarios" id="teorizacao-comentarios" style="width: 300px !important;"></textarea><br />
				Menção:
				<select name="teorizacao-nota" id="teorizacao-nota" style="width:300px !important;">
					<option value=""></option>
					<option value="Atingiu o objetivo (A)">Atingiu o objetivo (A)</option>
					<option value="Atingiu parcialmente o objetivo (AP)">Atingiu parcialmente o objetivo (AP)</option>
					<option value="Não atingiu o objetivo (NA)">Não atingiu o objetivo (NA)</option>
				</select><br />
				
				<b>Hipóteses de Solução:</b><br />
				<textarea name="hipoteses-comentarios" id="hipoteses-comentarios" style="width: 300px !important;"></textarea><br />
				Menção:
				<select name="hipoteses-nota" id="hipoteses-nota" style="width:300px !important;">
					<option value=""></option>
					<option value="Atingiu o objetivo (A)">Atingiu o objetivo (A)</option>
					<option value="Atingiu parcialmente o objetivo (AP)">Atingiu parcialmente o objetivo (AP)</option>
					<option value="Não atingiu o objetivo (NA)">Não atingiu o objetivo (NA)</option>
				</select>
				<div style="margin-left: 550px;">
					<input type="submit" value="Salvar" />
				</div>
			</h:form>
		</p>
</div>
<div id="backgroundPopup"></div>
</body>
</html>    