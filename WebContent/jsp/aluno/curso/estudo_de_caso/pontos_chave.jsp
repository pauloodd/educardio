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
			
		function removerDeterminante(index){
				
			var row = document.getElementById("row-"+index);
			row.parentNode.removeChild(row);
		}
		
		function avancarPtsChave(){
			
			var form = document.forms[0];
			form.action = "/isa/salvarPontosChaves.do";
			form.method.value = "avancarPontosChaves";
			form.submit();
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

            <div id="wrapper" class='logado caso'>
        	  <h3 class="bread">CR<c:out value="${matricula.curso.id}"></c:out> > EC<c:out value="${arcoMaguerez.estudoDeCaso.id}"></c:out> > Diagnósticos</h3>

               <jsp:include page="inc_topo_estudo_caso.jsp"  flush="true"/>  
                
            	<c:if test="${arcoMaguerez.faseDoArco > 1}"><div class="desabilitar-form" style="height:100%;"></div>	</c:if>
					<br />
				
                	
                	 <div class="help">
                                <h3 class="arco pontos"> Diagnósticos</h3>
                               A partir das informações presentes no estudo de caso, formule diagnósticos de Enfermagem, a fim de prestar a melhor assistência possível. 
                    </div>
                    
                	<br />
				 <input type="button" value="Adicionar Diagnóstico" id="button"/>
				<h:form action="salvarPontosChaves" >
					<h:hidden property="method" value="salvarPontosChaves"/>
	              	<table >
	              		<thead>
			            	<tr>
			                	<th>Nomenclatura</th>
			                    <th>Etiologia</th>
			                    <th>Sinais e Sintomas</th>
			                    <th>Ação</th>
			                </tr>
		                </thead>
		                <tbody id="determinantes-tbody">
		                 	<c:forEach items="${determinantes}" var="determinante" varStatus="index">
				            	<tr id='row-<c:out value="${index.index}"/>'>
				                	<td><c:out value="${determinante.determinante}"></c:out></td>
				                	<td><c:out value="${determinante.justificativa}"></c:out></td>
				                	<td><c:out value="${determinante.justificativa}"></c:out></td>
				                	 <td align="center">
				                	 		<input type="button" value="Remover" onclick="removerDeterminante(<c:out value="${index.index}"/>);"></input>
				                	 		<h:hidden property="determinantes" value='${determinante.determinante}##${determinante.justificativa}' ></h:hidden>
				                	 </td>
				                </tr>
		                	</c:forEach>
		                </tbody>
	                </table>
        		
        		<table class="navegacao" style="position: relative; z-index:2;">
	            	<tr>
		             	 <td style="vertical-align: top;">
		               		<input type="button" value="Voltar"  onclick="window.location.href = 'estudoCaso.do?method=mostrarTelaObservacaoRealidade&idEstudoCaso=${ estudoDeCaso.id}';" class="bt_voltar" >
		                </td>
		                <td class="space"></td>
		            	<td class="left">    
		                	<input type="button" value="Cancelar" onclick="window.location.href = 'ptsChave.do?method=mostrarTelaPontosChave';" class="bt_cancelar" class="left">
		                </td>
		               <td class="right">
		                	<input type="submit" value="Salvar Dados" class="bt_salvar" class="right">
	               		 </td>
		                <td class="space"></td>
		                 <td style="vertical-align: top;">
		        			<input type="button"  value="Avançar Fase" onclick="avancarPtsChave();" class="bt_avancar" class="left">
		                </td>
	              </tr>
	            </table>
				 </h:form>
                
            </div><!-- /#wrapper -->

    	</div><!-- /#middle_align -->
    		<div style="width: 100%; height: 300px;"></div>
    </div><!-- /#middle -->    
    
	<jsp:include page="../../../inc_rodape.jsp"  flush="true"/>
  
    
</div><!-- /#container -->

<div id="popupContact" style="position: absolute; top: 184.167px; left: 0px; display: none;">
		<a id="popupContactClose">sair</a>
		<h1>Adicionar Diagnóstico!</h1>
		<p id="contactArea">
			<table border='0' style="border:none !important; font-size: 13px !important; color: black !important;">
						<tr style="border:none !important;">
							<td align="left" style="text-align:justify;">
								Nomenclatura:<br />
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
			Etiologia:
			<input type="text" id="determinante" /><br />
			Sinais e Sintomas:
			<input type="text" id="determinante" /><br />
			<input type="button" value="Adicionar Diagnóstico" onclick="adicionarDeterminante();"/>
		</p>
	</div>
	<div id="backgroundPopup"></div>
</body>
</html>    