<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

  <jsp:include page="../../../inc_header.jsp"  flush="true"/>
 	
 <link href="css/jquery.fancybox-1.3.4.css" type="text/css" rel="stylesheet" media="screen" />
<script language="javascript" type="text/javascript" src="js/jquery.fancybox-1.3.4.pack.js"></script>	
  
		<script type="text/javascript">
        $(document).ready(function(){
            $(".modalPortfolio").fancybox({                    
                'transitionIn'  :   'elastic',
                'transitionOut' :   'elastic',
                'speedIn'       :   600, 
                'speedOut'      :   200, 
                'overlayShow'   :   false,
                'width'             :       900,
                'height'            :       500,
                'hideOnContentClick':       false,
                'autoDimensions'    :       false,
                'showNavArrows'     :       false,
                'overlayShow'       :       true,
                'overlayOpacity'    :       0.8,
                'overlayColor'      :       '#999',
                'type'              :       'iframe'
            });
        });
    </script>
	
</head>
<body>

<div id="container">

	  <jsp:include page="../inc_topo_curso.jsp"  flush="true"/>
    
    <div id="middle">    
		<div id="middle_align">

            <div id="wrapper" class='logado caso'>
        	  <h3 class="bread">CR<c:out value="${matricula.curso.id}"></c:out> > EC<c:out value="${arcoMaguerez.estudoDeCaso.id}"></c:out> > Investigação</h3>

               <jsp:include page="inc_topo_estudo_caso.jsp"  flush="true"/>  
                
            	<c:if test="${arcoMaguerez.faseDoArco != 0}"><div class="desabilitar-form" style="height:100%;"></div>	</c:if>

                <div class="rf-tab-hdr-brd hipotese">
                	
                	 <div class="help">
                                <h3 class="arco obs"> Investigação</h3>
                                Analise o estudo de caso a seguir, observando as informações relevantes ao planejamento da assistência de Enfermagem.  
                    </div>

				 <div class="img_descricao">
				 		
	                	 <c:forEach items="${estudoDeCaso.imagensCaso}" var="imagem" varStatus="index">
	                	 <c:if test="${index.count == 1 }">
	                          <a style="position: relative; z-index:2;" href="photos?id=<c:out value="${imagem.id}"></c:out>" class='modalPortfolio' title="<c:out value="${imagem.nomeArqv}"></c:out>">
	                               	<img src="photos?id=<c:out value="${imagem.id}"></c:out>" width="120" height="120" alt="<c:out value="${imagem.nomeArqv}"></c:out>" />
	                           </a>
	                	 </c:if>
		       			</c:forEach>
                     </div>	
                	
                	<p style="font-size: 16px;"><c:out value="${estudoDeCaso.titulo}"></c:out></p><br />
        			<b>Descrição:</b><br /><div style="text-align: justify;">${estudoDeCaso.descricao}</div><br /><br />
        			<%-- <b>Objetivos Gerais:</b><br /><c:out value="${estudoDeCaso.objetivosGerais}"></c:out><br /><br />
        			<b>Objetivos Específicos:</b><br /><c:out value="${estudoDeCaso.objetivosEspecificos}"></c:out><br /><br /> --%>
        			
        			<br /><br />
        			<b>Imagens Auxiliares:</b><br />
        			<c:forEach items="${estudoDeCaso.imagensAuxiliares}" var="imagem" varStatus="index">
        	        	<a  style="position: relative; z-index:2;" href="photos?id=<c:out value="${imagem.id}"></c:out>" class='modalPortfolio' title="<c:out value="${imagem.nomeArqv}"></c:out>">
        	        		<img src="photos?id=<c:out value="${imagem.id}"></c:out>" width="60" height="60" alt="<c:out value="${imagem.nomeArqv}"></c:out>" />
       	        		</a>
        			</c:forEach>
        			<br />
        		</div>
        		
                
            </div><!-- /#wrapper -->
        		<table class="navegacao" style="position: relative; z-index:2;">
	            	<tr>
		             	 <td style="vertical-align: top;">
		               		<input type="button" value="Voltar" style="color:gray;" disabled="disabled" class="bt_voltar_disabled" >
		                </td>
		                <td class="space"></td>
		            	<td class="left">    
		                	<input type="button" value="Cancelar" class="bt_cancelar" class="left">
		                </td>
		               <td class="right">
		                	<input type="button" onclick="window.location.href = 'avancarObsRealidade.do?method=avancarObservacaoRealidade';" value="Salvar Dados" class="bt_salvar" class="right">
	               		 </td>
		                <td class="space"></td>
		                 <td style="vertical-align: top;">
		        			<input type="button"  value="Avançar Fase" onclick="window.location.href = 'avancarObsRealidade.do?method=avancarObservacaoRealidade';" class="bt_avancar" class="left">
		                </td>
	              </tr>
	            </table>

    	</div><!-- /#middle_align -->
    		<div style="width: 100%; height: 300px;"></div>
    </div><!-- /#middle -->    
    
	<jsp:include page="../../../inc_rodape.jsp"  flush="true"/>
  
    
</div><!-- /#container -->
</body>
</html>    