<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

  <jsp:include page="../../../inc_header.jsp"  flush="true"/>
 	  
    <script language="JavaScript" type="text/javascript" src="js/popup.js" ></script>
	
        <link rel="stylesheet" href="css/popup.css" type="text/css" media="screen" />	

	 <script type="text/javascript">
	 function avancarHipoteses(){
			
			var form = document.forms[0];
			form.action = "/isa/salvarHipoteses.do";
			form.method.value = "avancarHipoteses";
			form.submit();
		}
	</script>
	
  <script type="text/javascript">
	  function adicionarDeterminante(){
				
			
			var determinante = document.getElementById("determinante");
			var justificativa = document.getElementById("justificativa");
			
			var tbody = document.getElementById('determinantes-tbody');
			
			var row = document.createElement("tr");
		 	var cell1 = document.createElement("td");    
		 	var cell2 = document.createElement("td");  
		 	var cell3 = document.createElement("td");   
          
		 	var index = tbody.getElementsByTagName('tr').length;
		 	cell1.innerHTML = determinante.value;  
		 	cell2.innerHTML = justificativa.value;  
            var a = document.createElement('input');
            a.type = "button";
            a.value = "Remover";
            row.id = "row-"+index;
            a.setAttribute("onclick","removerDeterminante("+index+");");
            var hidden = document.createElement('input');
            hidden.type ="hidden";
            hidden.name ="determinantes";
            hidden.value=determinante.value+"##"+justificativa.value;
            cell3.setAttribute("align","center");
            cell3.appendChild(a);
            cell3.appendChild(hidden);
            
            row.appendChild(cell1);
            row.appendChild(cell2);
            row.appendChild(cell3);
   			
            tbody.appendChild(row);
            
            disablePopup();
            
            determinante.value = "";
            justificativa.value = "";
	}
		
	
		function apagarProcurarTermo(retorno){
			
			var inputTermo = document.getElementById(retorno+"-termo");
			var inputIdTermo = document.getElementById(retorno+"-id-termo");
        	var inputDescricao = document.getElementById(retorno+"-descricao");
        	inputTermo.value = "";
        	inputIdTermo.value = "";
        	inputDescricao.innerHTML = "";
		}
		
		function procurarTermo(retorno , eixo){
			
			var url ="mostrarTelaProcurarTermo.do?method=mostrarTelaProcurarTermo&retorno="+retorno+"&eixo="+eixo;
			var newwindow= window.open(url,'Procurar Termo','height=700,width=750');
			if (window.focus) {newwindow.focus()}
			return false;
			
		}
	</script>
	
</head>
<body>

<div id="container">

	  <jsp:include page="../inc_topo_curso.jsp"  flush="true"/>
    
    <div id="middle">    
		<div id="middle_align">

          	<h:form action="salvarHipoteses" method="post" enctype="multipart/form-data">
          						<h:hidden property="method" value="salvarHipoteses"/>
          	
            <div id="wrapper" class='logado caso'>
        	  <h3 class="bread">CR<c:out value="${matricula.curso.id}"></c:out> > EC<c:out value="${arcoMaguerez.estudoDeCaso.id}"></c:out> > Implementação</h3>

               <jsp:include page="inc_topo_estudo_caso.jsp"  flush="true"/>  
            <c:if test="${arcoMaguerez.faseDoArco > 3}"><div class="desabilitar-form" style="height:100%;"></div>	</c:if>    
            	
                	
                	<div class="help">
                                <h3 class="arco hipotese"> Implementação</h3>
                               Nesta terceira etapa do Método do Arco ("Implementação") você deverá estudar os pontos-chaves em artigos científicos, livros, anais de congresso, vídeos educativos, entre outros materiais de aprendizagem. Podendo também participar de palestras, encontros e reuniões científicas. Anexe abaixo um documento com o resumo do conteúdo pesquisado e as referências relacionadas. Atente-se para não desviar do tema proposto!
                               </div>
                    
                	 
					<br /><br />
					<table >
	              		<thead>
			            	<tr>
			            		<th>index</th>
			                	<th>Diagnóstico</th>
			                    <th>Implementação</th>
			                    <th>Ação</th>
			                </tr>
		                </thead>
		                <tbody id="determinantes-tbody">
		                	
	   				
		                 	<c:forEach items="${determinantesHipoteses}" var="determinante" varStatus="index">
				            	<tr id='row-<c:out value="${index.index}"/>'>
				            		<td>${index.index+1}</td>
				                	<td><c:out value="${determinante.titulo}"></c:out></td>
				                	<td></td>
				                	 <td align="center">
				                	 		 <input type="button" value="Adicionar Implementação" id="button"/>
				                	 		<h:hidden property="determinantes" value='${determinante.id}##${determinante.titulo}' ></h:hidden>
				                	 </td>
				                </tr>
		                	</c:forEach>
		                </tbody>
	                </table>
					
					<br />
        				
                
            </div><!-- /#wrapper -->
        		<table class="navegacao" style="position: relative; z-index:2;">
	            	<tr>
		             	 <td style="vertical-align: top;">
		               		<input type="button" value="Voltar" onclick="window.location.href = 'ptsChave.do?method=mostrarTelaPontosChave';" class="bt_voltar" >
		                </td>
		                <td class="space"></td>
		            	<td class="left">    
		                	<input type="button" value="Cancelar" onclick="window.location.href = 'hipoteses.do?method=mostrarTelaHipoteses';" class="bt_cancelar" class="left">
		                </td>
		               <td class="right">
		                	<input type="submit"  value="Salvar Dados" class="bt_salvar" class="right">
	               		 </td>
		                <td class="space"></td>
		                 <td style="vertical-align: top;">
		        			<input type="button"  value="Avançar Fase" onclick="avancarHipoteses();"  class="bt_avancar" class="left">
		                </td>
	              </tr>
	            </table>
          	</h:form>

    	</div><!-- /#middle_align -->
    		<div style="width: 100%; height: 300px;"></div>
    </div><!-- /#middle -->    
    
	<jsp:include page="../../../inc_rodape.jsp"  flush="true"/>
  
    
</div><!-- /#container -->

<div id="popupContact" style="position: absolute; top: 184.167px; left: 0px; display: none;">
		<a id="popupContactClose">sair</a>
		<h1>Adicionar Implementação!</h1>
		<p id="contactArea">
			<table border='0' style="border:none !important; font-size: 13px !important; color: black !important;">
						<tr style="border:none !important;">
							<td align="left" style="text-align:justify;">
								Implementação:<br />
							</td>
						</tr>
						<tr style="border:none !important;">
							<td>
								<input id="determinante4-termo" disabled="disabled" name="termo4autocomplete" style="width: 546px;"  /> <br />
								<input type="hidden"id="determinante4-id-termo"  name="idtermo4autocomplete" value="" />
							</td>
							<td>
								<img style="margin-left: 10px; cursor:pointer;" onclick="procurarTermo('determinante4', 'Acao')" src="imagens/procurar.png" width="16px" height="16px" />
							</td>
						</tr>
						<tr style="border:none !important;">
							<td align="left"  style="background: #E8F2EB; " id="determinante4-descricao" >
								
							</td>
							<td>
								<img style="margin-left: 10px; cursor:pointer;" onclick="apagarProcurarTermo('determinante4')" src="imagens/trash.png" width="16px" height="16px" />
							</td>
						</tr>
					</table>
			<br />
			
			<input type="button" value="Adicionar Implementação" onclick="adicionarDeterminante();"/>
		</p>
	</div>
	<div id="backgroundPopup"></div>
</body>
</html>    