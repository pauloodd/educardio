<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

  <jsp:include page="../../inc_header.jsp"  flush="true"/>
 		 
    
</head>
<body>

<div id="container">

	  <jsp:include page="inc_topo_curso.jsp"  flush="true"/>
    
    <div id="middle">    
		<div id="middle_align">

            <div id="wrapper" class="logado aluno">
            
		          <h3 class="bread">CR<c:out value="${matricula.curso.id}"></c:out> > Sobre o curso</h3>
		            
		            <p>Informações sobre o curso</p>
		            
		            Arquivos Disponíveis:<br />
	                <c:forEach items="${matricula.curso.arquivos}" var="arquivo" varStatus="index">
	           				<a href="baixarArquivo.do?method=baixarArquivo&idArquivo=${arquivo.id}"><c:out value="${arquivo.nomeArqv}"></c:out></a><br />
	           		</c:forEach>
		            <p>Ementa:<br/><c:out value="${matricula.curso.ementa}"></c:out></p>
		            <p>Objetivos:<br/><c:out value="${matricula.curso.objetivos}"></c:out></p>
                    <p>Professor Responsável:<br/><c:out value="${matricula.curso.professor.nome}"></c:out></p>
					<br clear="all" />

                
            </div><!-- /#wrapper -->

    	</div><!-- /#middle_align -->
    		<div style="width: 100%; height: 200px;"></div>
    </div><!-- /#middle -->    
    
	<jsp:include page="../../inc_rodape.jsp"  flush="true"/>
  
    
</div><!-- /#container -->
</body>
</html>    