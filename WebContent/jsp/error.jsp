<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>EduCardio</title>
</head>

<jsp:include page="inc_header.jsp"  flush="true"/>
    
</head>
<body>

<div id="container">

	<jsp:include page="inc_topo.jsp"  flush="true"/>
    
    <div id="middle">    
		<div id="middle_align">
            
            <div id="wrapper">
            
            <div class="col w70 msg error p2">
				<h3>Atenção!</h3>
                <p>Algo inesperado ocorreu no sistema.<br />
				Favor reportar a mensagem abaixo para o administrador e fazer login novamente.</p> 
                
                <input type="button" value="Logar Novamente" onclick="window.location.href = '/educardio';">
                <input type="button" value="Reportar Bug" onclick="document.forms[1].submit();">         
                
            </div>
            <div class="col w25 login">
            	
            	<div class="form bg_shadow_left_green">
                <h2>Área do Cadastrado</h2>
               <h:form action="logon">
				<h:hidden property="method" value="logon"/>
					
                	<label for="user">Usuário</label>
					<h:text property="loginUsuario" styleClass="input-text input-200" value="Usuário" onblur="if (this.value == '') {this.value = 'Usuário';}"  onfocus="if (this.value == 'Usuário') {this.value = '';}"  styleId="user" maxlength="10"/>
                    <label for="pass">Senha</label>
					<h:password styleClass="input-text input-200" styleId="senha" property="senhaUsuario" value="****"  onblur="if (this.value == '') {this.value = '****';}"  onfocus="if (this.value == '****') {this.value = '';}"  maxlength="10"/>
                    <input type="submit" name="Enviar" value="Enviar" />
                </h:form>  
                    <a href="#" onclick="alert('Em construção!')">Esqueci a senha</a><br/>
                    <a href="usuarioExternoAdd.do?method=mostrarTelaUsuarioExternoAdd">Cadastrar-se</a>
                
                </div>
            </div>
           
           <div class="col w100 error">
           		
                <p>PrintStackTrace</p>
                 <form name="error" method="post" action="error.do?method=reportarBug">
    	 			 <input type="hidden" name="method" value="reportarBug"> 
					   <textarea rows="30" cols="100" name="erroMsg"> <c:out value="${erroMsg}" ></c:out></textarea>
				  </form>
                
                
           </div><!-- /#error -->
          
                
            </div><!-- /#wrapper -->
    	</div><!-- /#middle_align -->
    </div><!-- /#middle -->    
    
	    
	<jsp:include page="inc_rodape.jsp"  flush="true"/>
    
</div><!-- /#container -->

</body>
</html>    