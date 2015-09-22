<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

  <jsp:include page="../../../inc_header.jsp"  flush="true"/>
 	

	 <script type="text/javascript">
		function avancarAplicacao(){
			
			var form = document.forms[0];
			form.action = "/isa/avancarAplicacao.do";
			form.method.value = "avancarAplicacao";
			form.submit();
		}
	</script>
	
</head>
<body>

<div id="container">

	  <jsp:include page="../inc_topo_curso.jsp"  flush="true"/>
    
    <div id="middle">    
		<div id="middle_align">

          	<h:form action="salvarAplicacao" method="post" >
            <div id="wrapper" class='logado caso'>
        	  <h3 class="bread">CR<c:out value="${matricula.curso.id}"></c:out> > EC<c:out value="${arcoMaguerez.estudoDeCaso.id}"></c:out> > Avaliação</h3>

               <jsp:include page="inc_topo_estudo_caso.jsp"  flush="true"/>  
            <c:if test="${arcoMaguerez.faseDoArco > 4}"><div class="desabilitar-form" style="height:100%;"></div>	</c:if>
           
               		 <div class="help">
                                <h3 class="arco aplicacao"> Avaliação</h3>
                               Esta quinta e última etapa do Método do Arco ("Aplicação à Realidade") compreende a implementação ou encaminhamento das soluções do problema, por meio de uma prática autônoma e transformadora. Supondo que você tenha aplicado o Plano de Cuidados de Enfermagem, como você avaliaria os resultados? 
	                	 
                    </div>
                    
					<h:hidden property="method" value="salvarAplicacao"/>
					<br /><br />
					Comparar os resultados esperados à situação de saúde e a capacidade funcional do RN: 
					<textarea id="texto"  name="texto" style="width: 600px; height: 150px; "><c:out value="${arcoMaguerez.aplicacao.texto}"></c:out></textarea><br />
	           		<br />
        		
                
            </div><!-- /#wrapper -->
        		<table class="navegacao" style="position: relative; z-index:2;">
	            	<tr>
		             	 <td style="vertical-align: top;">
		               		<input type="button" value="Voltar" onclick="window.location.href = 'hipoteses.do?method=mostrarTelaHipoteses';" class="bt_voltar" />
		                </td>
		                <td class="space"></td>
		            	<td class="left">    
		                	<input type="button" value="Cancelar" onclick="window.location.href = 'aplicacao.do?method=mostrarTelaAplicacao';" class="bt_cancelar" class="left" />
		                </td>
		               <td class="right">
		                	<input type="submit"  value="Salvar Dados" class="bt_salvar" class="right" />
	               		 </td>
		                <td class="space"></td>
		                 <td style="vertical-align: top;">
		        			<input type="button"  value="Avançar Fase" onclick="avancarAplicacao();" style="display: none;" class="bt_avancar" class="left" />
		                </td>
	              </tr>
	            </table>
          	</h:form>

    	</div><!-- /#middle_align -->
    		<div style="width: 100%; height: 300px;"></div>
    </div><!-- /#middle -->    
    
	<jsp:include page="../../../inc_rodape.jsp"  flush="true"/>
  
    
</div><!-- /#container -->
</body>
</html>    