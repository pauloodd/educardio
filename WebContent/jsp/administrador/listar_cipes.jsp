<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link rel="stylesheet" type="text/css" href="css/jTPS.css" />
  <jsp:include page="../inc_header.jsp"  flush="true"/>
    <script language="JavaScript" type="text/javascript" src="js/popup.js" ></script>
	
        <link rel="stylesheet" href="css/popup.css" type="text/css" media="screen" />	
 		 
       
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
       </script>
       <script type="text/javascript">
	   
				$(document).ready(function() {
			    var elements = document.getElementsByTagName("INPUT");
			    for (var i = 0; i < elements.length; i++) {
			        elements[i].oninvalid = function(e) {
			            e.target.setCustomValidity("");
			            if (!e.target.validity.valid) {
			                e.target.setCustomValidity("Campo Obrigatório");
			            }
			        };
			        elements[i].oninput = function(e) {
			            e.target.setCustomValidity("");
			        };
			    }
			})
			</script>
       <script language="javascript" type="text/javascript" >
                 
       
    	function editarCipe2(idCipe){
    		
    		var codigo = document.getElementById("cipe-codigo-"+idCipe);
     		var termo = document.getElementById("cipe-termo-"+idCipe);
     		var descricao = document.getElementById("cipe-descricao-"+idCipe);
     		var eixo = document.getElementById("cipe-eixo-"+idCipe);
     		var versao = document.getElementById("cipe-versao-"+idCipe);
     		
     		var form = document.forms['editarCipe'];
     		form.codigo.value = codigo.innerHTML;
     		form.termo.value = termo.innerHTML;
     		form.descricao.value = descricao.innerHTML;
     		form.versao.value = versao.innerHTML;
     		form.eixo.value = eixo.innerHTML;
     		form.idCipe.value = idCipe;
     		
     		centerPopup2();
  			loadPopup2();
    	
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

<div id="container">

	  <jsp:include page="../inc_topo.jsp"  flush="true"/>
    
    <div id="middle">    
		<div id="middle_align">

            <div id="wrapper" class="logado admin">
            
               <input type="button" value="Cadastrar nova Cipe" id="button"/>
			<br /><br />
				<form action="administrador.do" method="get">
					<input type="hidden" name="method" value="mostrarTelaListarCipes"/>
					
					<span style="float:left; ">Termo:</span> 
					<input type="text" name="termo-buscar" id="termo-buscar" style=" margin-left:5px; float:left; width:300px;" /> 
					<span style="float:left; margin-left:20px;">Foco:</span> <input type="checkbox" checked="checked" name="foco" value="true" style="float:left; margin-top: 3px; margin-right:20px;" />
					<span style="float:left;">Ação:</span> <input type="checkbox" name="acao" checked="checked" value="true" style="float:left;margin-top: 3px; margin-right:20px;"/>
					<input type="submit" value="Pesquisar" style="margin-top:0px; float:left;" />
				</form>
				
			<br clear="all" />
	
		<table id="demoTable" style="border: 1px solid #ccc;" cellspacing="0" width="700">
			<thead>
            	<tr>
                	<th>Código</th>
                    <th>Termo</th>
                    <th>Descrição</th>
                    <th>Eixo</th>
                    <th>Versão</th>
                   	<th>Editar</th>
              		<th>Remover</th>
                </tr>
			</thead>
			 <tbody>                
                <c:forEach items="${cipes}" var="cipe" varStatus="index">
	            	<tr>
	            		<td align="center" id="cipe-codigo-${cipe.id}">${cipe.codigo}</td>
	                	 <td align="center" id="cipe-termo-${cipe.id}">${cipe.termo}</td>
                           <td align="center" id="cipe-descricao-${cipe.id}">${cipe.descricao}</td>
                            <td align="center" id="cipe-eixo-${cipe.id}">${cipe.eixo}</td>
                            <td align="center" id="cipe-versao-${cipe.id}">${cipe.versao}</td>
                           <td align="center">
                              <input type="button" onclick="editarCipe2('${cipe.id}');"  value="Editar" />
					    </td>
					    <td align="center">
					    	  <input type="button" onclick="window.location.href = 'removerCipe.do?method=removerCipe&idCipe=${cipe.id}';" value="Remover"/>
					    </td>
	             	</tr>
		        </c:forEach>
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
                
            </div><!-- /#wrapper -->

    	</div><!-- /#middle_align -->
    		<div style="width: 100%; height: 200px;"></div>
    </div><!-- /#middle -->    
    
	<jsp:include page="../inc_rodape.jsp"  flush="true"/>
  
    
</div><!-- /#container -->

<div id="popupContact" style="position: absolute; top: 184.167px; left: 0px; display: none;">
		<form  name="adicionarCipe" method="post" action="adicionarCipe.do"  >
			<h:hidden property="method" value="adicionarCipe"/>
			<a id="popupContactClose">sair</a>
			<h1>Cadastrar nova Cipe!</h1>
			<p id="contactArea">
				Termo:
				<input type="text"  style="width: 300px !important;" name="termo"  required/>
				Descrição:
				<textarea style="width: 300px !important;" name="descricao" required></textarea>
				Código:
				<input type="text" name="codigo" style="width: 300px !important;" required/>
				Eixo:
				<select name="eixo" style="width: 300px !important;">
					<option value="Foco">Foco</option>
					<option value="Ação">Ação</option>
				</select>
				Versão:
				<input type="text" style="width: 300px !important;" name="versao" required/>
				<br />
				<input type="submit" value="Cadastrar"/>
									
			</p>
		</form>
	</div>
	<div id="backgroundPopup"></div>
	
	<div id="popupContact2" style="position: absolute; top: 184.167px; left: 0px; display: none;">
		<form  name="editarCipe" method="post" action="editarCipe.do"  >
			<h:hidden property="method" value="editarCipe"/>
			<a id="popupContactClose2">sair</a>
			<h1>Editar nova Cipe!</h1>
			<p id="contactArea">
				Termo:
				<input type="text"  style="width: 300px !important;" name="termo"  required/>
				Descrição:
				<textarea style="width: 300px !important;" name="descricao" required></textarea>
				Código:
				<input type="text" name="codigo" style="width: 300px !important;" required/>
				Eixo:
				<select name="eixo" style="width: 300px !important;">
					<option value="Foco">Foco</option>
					<option value="Ação">Ação</option>
				</select>
				Versão:
				<input type="text" style="width: 300px !important;" name="versao" required/>
				<input type="hidden" value=""  style="width: 300px !important;" name="idCipe"  />
				<br />
				<input type="submit" value="Editar"/>
									
			</p>
		</form>
	</div>
	<div id="backgroundPopup2"></div>
</body>
</html>    