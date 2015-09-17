<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="model.curso.matricula.ambulatorio.TipoMaterialEnum"%>
<%@page import="model.curso.matricula.ambulatorio.Ambulatorio"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@page import="model.curso.matricula.*"%>
<%@page import="java.util.List"%>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>

  <jsp:include page="../../inc_header.jsp"  flush="true"/>
  
 	 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
  
	<!-- REMOVE THIS if you're using jQuery UI. -->
	<script type="text/javascript" src="js/jquery.ui.widget.js"></script>
  

	<script type="text/javascript" src="js/jquery-picklist.js"></script>
	<script type="text/javascript">
		$(function()
		{
			$("#mobilia").pickList(
			{
				sourceListLabel:	"Não Adicionados",
				targetListLabel:	"Adicionados",
				addAllLabel:		"Adicionar Todos",
				addLabel:			"Adicionar",
				removeAllLabel:		"Remover Todos",
				removeLabel:		"Remover",
				listItemValueAttribute: "mobilia",
				sortAttribute:		"value"
				
			});

			$("#corrente").pickList(
					{
						sourceListLabel:	"Não Adicionados",
						targetListLabel:	"Adicionados",
						addAllLabel:		"Adicionar Todos",
						addLabel:			"Adicionar",
						removeAllLabel:		"Remover Todos",
						removeLabel:		"Remover",
						listItemValueAttribute: "corrente",
						sortAttribute:		"value"
						
			});
			
			$("#clinico").pickList(
					{
						sourceListLabel:	"Não Adicionados",
						targetListLabel:	"Adicionados",
						addAllLabel:		"Adicionar Todos",
						addLabel:			"Adicionar",
						removeAllLabel:		"Remover Todos",
						removeLabel:		"Remover",
						listItemValueAttribute: "clinico",
						sortAttribute:		"value"
						
			});
			
			<c:forEach items="${matGeralAdd}" var="materialGeral" varStatus="index">
					$("#mobilia").pickList("insert",
					{
						value: <c:out value="${materialGeral.id}"></c:out>,
						label: "<c:out value="${materialGeral.descricao}"></c:out>",
						selected: true
					});
			</c:forEach>
			
			<c:forEach items="${matUsoClinicoAdd}" var="materialClinicoAdd" varStatus="index">
					$("#corrente").pickList("insert",
					{
						value: <c:out value="${materialClinicoAdd.id}"></c:out>,
						label: "<c:out value="${materialClinicoAdd.descricao}"></c:out>",
						selected: true
					});
			</c:forEach>
	
			<c:forEach items="${matUsoCorrenteAdd}" var="materialUsoCorrenteAdd" varStatus="index">
					$("#clinico").pickList("insert",
					{
						value: <c:out value="${materialUsoCorrenteAdd.id}"></c:out>,
						label: "<c:out value="${materialUsoCorrenteAdd.descricao}"></c:out>",
						selected: true
					});
			</c:forEach>
			
		});
	</script>
	
	<link type="text/css" href="css/jquery-picklist.css" rel="stylesheet" />
 		 
    
</head>
<body>

<div id="container">

	  <jsp:include page="inc_topo_curso.jsp"  flush="true"/>
    
    <div id="middle">    
		<div id="middle_align">

            <div id="wrapper" class="logado ambulatorio">
            	<h:form action="organizarAmbulatorio" >
				<h:hidden property="method" value="organizarAmbulatorio"/>
												
		          <h3 class="bread">CR<c:out value="${matricula.curso.id}"></c:out> > Organizar Ambulatório</h3>
		            <p>ATENÇÃO! Os dados precisam ser salvos ao final do preenchimento dos campos.</p>
          			<div style='color:red;font-size: 20px;font-weight: bold; font-size: 14px;'><br />${mensagem}</div>
          		
		            <p>Organizar Ambulatório</p>
		            <div>
		            	<p>Selecionar mobília/ equipamentos de informática e eletroeletrônico</p>
						<select id="mobilia" name="mobilia" multiple="multiple">
							<c:forEach items="${materiaisGeral}" var="materialGeral" varStatus="index">
	            					<option value="${materialGeral.id }">${materialGeral.descricao }</option>
	            			</c:forEach>
						</select>
					</div>
					 <div>
		            	<p>Selecionar equipamentos de uso clínico </p>
						<select id="corrente" name="corrente" multiple="multiple">
							<c:forEach items="${materiaisClinico}" var="materialClinico" varStatus="index">
	            					<option value="${materialClinico.id }">${materialClinico.descricao }</option>
	            			</c:forEach>
						</select>
					</div>
					 <div>
		            	<p>Selecionar materiais de uso corrente </p>
						<select id="clinico" name="clinico" multiple="multiple">
							<c:forEach items="${materiaisConcorrente}" var="materialConcorrente" varStatus="index">
	            					<option value="${materialConcorrente.id }">${materialConcorrente.descricao }</option>
	            			</c:forEach>
						</select>
					</div>
		          
					<br clear="all" />
					<input type="submit" value="Salvar" onclick="" />
                </h:form>
            </div><!-- /#wrapper -->

    	</div><!-- /#middle_align -->
    		<div style="width: 100%; height: 200px;"></div>
    </div><!-- /#middle -->    
    
	<jsp:include page="../../inc_rodape.jsp"  flush="true"/>
  
    
</div><!-- /#container -->
</body>
</html>    