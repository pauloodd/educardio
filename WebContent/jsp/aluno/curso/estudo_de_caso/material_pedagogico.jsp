<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

  <jsp:include page="../../../inc_header.jsp"  flush="true"/>
 	

	 <script type="text/javascript">
		function avancarAvaliacao(){
			
			var form = document.forms[0];
			form.action = "/isa/avancarAvaliacao.do";
			form.method.value = "avancarAvaliacao";
			form.submit();
		}
	</script>
	
</head>
<body>

<div id="container">

	  <jsp:include page="../inc_topo_curso.jsp"  flush="true"/>
    
    <div id="middle">    
		<div id="middle_align">

             <div id="wrapper" class='logado caso'>
        	  <h3 class="bread">CR<c:out value="${matricula.curso.id}"></c:out> > EC<c:out value="${arcoMaguerez.estudoDeCaso.id}"></c:out> > Material Pedagógico</h3>

               <jsp:include page="inc_topo_estudo_caso.jsp"  flush="true"/>  
              		
                    <h3>Material Pedagógico</h3>
				<c:out value="${arcoMaguerez.estudoDeCaso.titulo}"></c:out><br/><br/>
        		<c:if test="${matricula.curso.id == 1}">
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/Comuns%20aos%203%20estudos%20de%20caso/caderneta_saude_crianca.pdf">caderneta_saude_crianca.pdf</a><br/>
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/Comuns%20aos%203%20estudos%20de%20caso/caderneta_saude_crianca_menina.pdf">caderneta_saude_crianca_menina.pdf</a><br/>
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/Comuns%20aos%203%20estudos%20de%20caso/caderneta_saude_crianca_menino.pdf">caderneta_saude_crianca_menino.pdf</a><br/>
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/Comuns%20aos%203%20estudos%20de%20caso/caderno_de_atencao_basica_crescimento_e_desenvolvimento_infantil.pdf">caderno_de_atencao_basica_crescimento_e_desenvolvimento_infantil.pdf</a><br/>
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/Comuns%20aos%203%20estudos%20de%20caso/curvas_oms_2006_2007.pdf">curvas_oms_2006_2007.pdf</a><br/>
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/Comuns%20aos%203%20estudos%20de%20caso/estatuto_crianca_adolescente_10ed.pdf">estatuto_crianca_adolescente_10ed.pdf</a><br/>
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/Comuns%20aos%203%20estudos%20de%20caso/Links_para_videos.docx">Links_para_videos.docx</a><br/>
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/Comuns%20aos%203%20estudos%20de%20caso/Organizacao_dos_cuidados_e_a_parceria_com_os_pais_em_pediatria_2012.pdf">Organizacao_dos_cuidados_e_a_parceria_com_os_pais_em_pediatria_2012.pdf</a><br/>
        		</c:if>
                <br/>
                <c:if test="${arcoMaguerez.estudoDeCaso.id == 1}">
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%201/Barbosa et at_2012.pdf">Barbosa et at_2012.pdf</a><br/>
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%201/calendário vacinal_2013.pdf">calendário vacinal_2013.pdf</a><br/>
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%201/Collet_2003.pdf">Collet_2003.pdf</a><br/>
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%201/Figueiredo et al_2011.pdf">Figueiredo et al_2011.pdf</a><br/>
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%201/Goulart_2010.pdf">Goulart_2010.pdf</a><br/>
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%201/Homma_2011.PDF">Homma_2011.PDF</a><br/>
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%201/Links para texto_imagem.docx">Links para texto_imagem.docx</a><br/>
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%201/Links para vídeos.docx">Links para vídeos.docx</a><br/>
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%201/Vasconcelos et al_2009.pdf">Vasconcelos et al_2009.pdf</a><br/>
        	</c:if>
                
                
                <c:if test="${arcoMaguerez.estudoDeCaso.id == 2}">
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%202/apoio_mulher_trabalhadora_amamentacao.pdf">apoio_mulher_trabalhadora_amamentacao.pdf</a><br/>
					<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%202/cartilha_mae_trabalhadora_amamenta.pdf">cartilha_mae_trabalhadora_amamenta.pdf</a><br/>
					<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%202/Monteiro et al_2011.PDF">Monteiro et al_2011.PDF</a><br/>
					<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%202/Piccinini_2009.PDF">Piccinini_2009.PDF</a><br/>
					<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%202/Pinto_2010.pdf">Pinto_2010.pdf</a><br/>
					<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%202/saude_crianca_nutricao_aleitamento_alimentacao.pdf">saude_crianca_nutricao_aleitamento_alimentacao.pdf</a><br/>
        		</c:if>
                
                
                <c:if test="${arcoMaguerez.estudoDeCaso.id == 3}">
        			<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%203/Brito et al_2005.pdf">Brito et al_2005.pdf</a><br/>
					<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%203/Brito_2005.pdf">Brito_2005.pdf</a><br/>
					<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%203/Ferreira_2005 ok.pdf">Ferreira_2005 ok.pdf</a><br/>
					<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%203/Lise_Motta_2012 ok.pdf">Lise_Motta_2012 ok.pdf</a><br/>
					<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%203/notificacao_maustratos_criancas_adolescentes.pdf">notificacao_maustratos_criancas_adolescentes.pdf</a><br/>
					<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%203/Silva et al_2011.pdf">Silva et al_2011.pdf</a><br/>
 					<a target="_blank" href="http://www.ideias.ufpe.br/isa/estudo%20de%20caso%203/Silva_2002.pdf">Silva_2002.pdf</a><br/>
        		</c:if>
                
            </div><!-- /#wrapper -->
        
    	</div><!-- /#middle_align -->
    		<div style="width: 100%; height: 300px;"></div>
    </div><!-- /#middle -->    
    
	<jsp:include page="../../../inc_rodape.jsp"  flush="true"/>
  
    
</div><!-- /#container -->
</body>
</html>    