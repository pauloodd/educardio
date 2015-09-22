<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

 	<link rel="stylesheet" type="text/css" href="css/jTPS.css" />

  <jsp:include page="../../../inc_header.jsp"  flush="true"/>
 	
      
        <script language="JavaScript" type="text/javascript" src="js/jTPS.js"></script>
	<script>
                $(document).ready(function () {
                        $('#demoTable').jTPS( {perPages:[5,10,15],scrollStep:1,scrollDelay:30,
                                clickCallback:function () {     
                                        // target table selector
                                        var table = '#demoTable';
                                        // store pagination + sort in cookie 
                                        document.cookie = 'jTPS=sortasc:' + $(table + ' .sortableHeader').index($(table + ' .sortAsc')) + ',' +
                                                'sortdesc:' + $(table + ' .sortableHeader').index($(table + ' .sortDesc')) + ',' +
                                                'page:' + $(table + ' .pageSelector').index($(table + ' .hilightPageSelector')) + ';';
                                }
                        });
                        // reinstate sort and pagination if cookie exists
                        var cookies = document.cookie.split(';');
                        for (var ci = 0, cie = cookies.length; ci < cie; ci++) {
                                var cookie = cookies[ci].split('=');
                                if (cookie[0] == 'jTPS') {
                                        var commands = cookie[1].split(',');
                                        for (var cm = 0, cme = commands.length; cm < cme; cm++) {
                                                var command = commands[cm].split(':');
                                                if (command[0] == 'sortasc' && parseInt(command[1]) >= 0) {
                                                        $('#demoTable .sortableHeader:eq(' + parseInt(command[1]) + ')').click();
                                                } else if (command[0] == 'sortdesc' && parseInt(command[1]) >= 0) {
                                                        $('#demoTable .sortableHeader:eq(' + parseInt(command[1]) + ')').click().click();
                                                } else if (command[0] == 'page' && parseInt(command[1]) >= 0) {
                                                        $('#demoTable .pageSelector:eq(' + parseInt(command[1]) + ')').click();
                                                }
                                        }
                                }
                        }
                        // bind mouseover for each tbody row and change cell (td) hover style
                        $('#demoTable tbody tr:not(.stubCell)').bind('mouseover mouseout',
                                function (e) {
                                        // hilight the row
                                        e.type == 'mouseover' ? $(this).children('td').addClass('hilightRow') : $(this).children('td').removeClass('hilightRow');
                                }
                        );
                });
                
                function resetarForm(){
                	document.getElementById("tfBusca").value = "";
                }
                
                function selecionarTermo(id,termo,descricao, retorno){
                	
                	var inputTermo = opener.document.getElementById(retorno+"-termo");
                	var inputIdTermo = opener.document.getElementById(retorno+"-id-termo");
                	var inputDescricao = opener.document.getElementById(retorno+"-descricao");
                	inputTermo.value = termo;
                	inputIdTermo.value = id;
                	inputDescricao.innerHTML = descricao;
                	
                	window.close();
                }
        </script>
	<style>
                body {
                        font-family: Tahoma;
                        font-size: 9pt;
                }
                #demoTable thead th {
                        white-space: nowrap;
                        overflow-x:hidden;
                        padding: 3px;
                }
                #demoTable tbody td {
                        padding: 3px;
                }
        </style>
</head>
<body>

<div id="middle">    
		<div id="middle_align">
				<br />
				 <h3 class="">Procurar Termo do Eixo <c:out value="${eixo}"></c:out></h3>
				<form action="mostrarTelaProcurarTermo.do" method="get">
					<input type="hidden" name="method" value="mostrarTelaProcurarTermo"/>
					<input type="hidden" name="eixo" value="${eixo}"/>
					<input type="hidden" name="retorno" value="${retorno}"/>
					
					<input type="text" name="termo-buscar" id="termo-buscar" style="float:left;" /> 
					<input type="submit" value="Pesquisar" style="margin-top:0px;" />
				</form>
				<br /><br />
				<div>
				
 				<table id="demoTable" style="border: 1px solid #ccc;" cellspacing="0" width="700">
	                    <thead>
	               			 <tr>
		                        <th sort="index">Termo</th>
		                        <th >Descrição</th>
		                        <th>Selecionar</th>
	               			 </tr>
	       					 </thead>
	       					 <tbody>
	       					<c:forEach items="${cipes}" var="cipe" varStatus="index">
	                        <tr>
	                            <td align="center">
	                                ${cipe.termoTruncado}
	                            </td>
	                            <td align="center">
	                                ${cipe.descricaoTruncado}
	                            </td>
	                           
	                            <td align="center">
	                               <input type="button" style="cursor:pointer;" value="Selecionar" onclick="selecionarTermo('${cipe.id }','${cipe.termoTruncado }','${cipe.descricaoTruncado }','${retorno}')"/>
							    </td>
	                        </tr>
	                      </c:forEach>
	                     </tbody>
	                      <tfoot class="nav">
	               		 <tr>
	                        <td colspan=7>
	                                <div class="pagination"></div>
	                                <div class="paginationTitle">P&aacute;gina</div>
	                                <div class="selectPerPage"></div>
	                                <div class="status"></div>
	                        </td>
	                	</tr>
	       				 </tfoot>
	                    </table>
                    </div>
         </div>
    </div>
</body>
</html>