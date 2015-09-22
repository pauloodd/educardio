<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ include file="/jsp/inc_header.jsp" %>

    
        <script language="JavaScript" type="text/javascript" src="js/MascaraValidacao.js"></script>  
		<script type="text/javascript" src="js/getCep.js"></script>
       
       <script type="text/javascript">
       		function adicionarCurso(){
       			
       			var cursoSelect = document.getElementById('curso');
				var tituloCurso = cursoSelect.options[cursoSelect.selectedIndex].text;
				
				var cursos = document.getElementById('cursos');
				var tbody = document.getElementById('cursos-tbody');
				
				var cursoJahCadastrado = false;
				var cursosArray = cursos.value.split(',');
				for(var i = 0; i < cursosArray.length; i++){
					if(cursosArray[i] == cursoSelect.options[cursoSelect.selectedIndex].value){
						cursoJahCadastrado = true;	
					}
				}
				
				
				if(cursoJahCadastrado){
					alert("Curso já cadastrado! Selecione outro");
				}else{
					if(cursos.value == ""){
						cursos.value = cursoSelect.options[cursoSelect.selectedIndex].value;
					}else{
						cursos.value += ","+ cursoSelect.options[cursoSelect.selectedIndex].value;	
					}
					
					var row = document.createElement("tr");
				 	var cell1 = document.createElement("td");    
				 	var cell2 = document.createElement("td");    
	              
				 	cell1.innerHTML = tituloCurso;  
	                var a = document.createElement('input');
	                a.type = "button";
	                a.value = "Remover";
	                row.id = "row-"+cursoSelect.options[cursoSelect.selectedIndex].value;
	                a.setAttribute("onclick","removerCurso("+cursoSelect.options[cursoSelect.selectedIndex].value+");");
	                cell2.appendChild(a);
	                
	                row.appendChild(cell1);
	                row.appendChild(cell2);
	       			
	                tbody.appendChild(row);
				}
				
				
       		}
       		
       		function removerCurso(index){
       			
       			var cursoSelect = document.getElementById('curso');
       			var cursos = document.getElementById('cursos');
				var novosCursos = "";
				
				if(cursos.value.indexOf(',') != -1){
					var cursosArray = cursos.value.split(',');
					for(var i = 0; i < cursosArray.length; i++){
						if(cursosArray[i] == cursoSelect.options[cursoSelect.selectedIndex].value){
							var row = document.getElementById("row-"+index);
							row.parentNode.removeChild(row);
						}else{
							if(novosCursos == ""){
								novosCursos += cursosArray[i];
							}else{
								novosCursos += ","+ cursosArray[i];
							}
						}
					}
					cursos.value = novosCursos;
				}else{
					var row = document.getElementById("row-"+index);
					row.parentNode.removeChild(row);
					cursos.value = novosCursos;
				}
       		}
       		
       		function trocouUsuario(){
       			
       			var restricao = document.getElementById('restricaoAcesso');
				var indice = restricao.selectedIndex;
       			var divcursos = document.getElementById('div-cursos');
				
				
				if(indice == 0){
					divcursos.style.display = "block";
				}else if(indice == 1){
					divcursos.style.display = "none";
				}
       			
       		}
       		
       		function removerTodosCursos(){
       			var cursos = document.getElementById('cursos');
       			var cursosArray = cursos.value.split(',');
				for(var i = 0; i < cursosArray.length; i++){
					var row = document.getElementById("row-"+cursosArray[i]);
					row.parentNode.removeChild(row);
				}
				var cursos = document.getElementById('cursos');
				cursos.value = "";
       		}
       </script>

		
</head>
	
    <body>
    	
			<%@ include file="/jsp/inc_topo.jsp"%>
			
			
			<div align='center' id="main-content" style="background: #FFFFFF !important;" >
				
				
				 <div id="conteudo" align="center" style="height:700px;"><br /><br /><br />
       		<div id="erroMsg">
               <font color="red"> <h:errors/></font>
          		<div style='margin-top:30px;color:red;width:700px'>${mensagem}</div>
                <br /><br />
            </div>
            
			<h:form action="usuarioExternoAdd" style=" width:80%;" >
                 <h:hidden property="method" value="usuarioExternoAdd"/>   
                 <input type="hidden" value="usuarioExternoAdd" name="acao"></input>
         			<p id="titulo-verm" style='margin-left:30px; width: 700px;' align="left">Cadastro de Usu&aacute;rio</p>
                    <table style="margin-left:30px; width: 700px; border: 0; text-align: left !important;">
                        <tr style="border: 0;">
                            <td width="900" style="width:900px;">
                                <div style="float:left;">
                                    <font face="Arial">
                                        Nome
                                        <font color="red">
                                            *
                                        </font>
                                    </font>
                                    <input size="110" style="width:450px;" name="nome" type="text" maxlength="150" value="<c:out value="${usuarioRet.nome}"></c:out>" />
                                </div>
                            </td>
                        </tr>
                        <tr  style="border: 0;">
                            <td style="width:900px;padding-top:10px;">
                                <div style="display:inline-block !important;margin-right: 10px;">
                                    <font face="Arial">
                                        CPF
                                        <font color="red">
	                                            *
	                                        </font>
                                        <input size="15" id="cpf" style="width: 100px;" type="text" name="cpf" maxlength="14" value="<c:out value="${usuarioRet.cpf}"></c:out>" onblur="validarCampo(this);" onkeypress=" return keyPress(event, this);"/>
                                    </font>
                                </div>
								<div style="display:inline-block !important;">
                                    <font face="Arial">
                                        Email
										<input id="telefone" style="width: 150px;" type="text" name="email" size="38" value="<c:out value="${usuarioRet.email}"></c:out>" maxlength="70"  />
                                    </font>
                                </div>
                                <div style="display:inline-block !important;margin-left: 10px; vertical-align: bottom;">
                                    <font face="Arial">
                                        Sexo
                                        <font color="red">
                                            *
                                        </font>
										<select id="sexo" name="sexo" style="width: 100px; ">
											<option value="Feminino" <c:if test="${usuarioRet.sexo == 'Feminino'}">selected="selected"</c:if>>Feminino</option>
                                            <option value="Masculino" <c:if test="${usuarioRet.sexo == 'Masculino'}">selected="selected"</c:if>>Masculino</option>
										</select>
                                    </font>
                                </div>
                            </td>
                        </tr>
                       
                        <tr  style="border: 0;">
                            <td style="padding-top:10px;">
                                <div style="float:left;margin-right: 10px;">
                                    <font face="Arial">
                                        Endere&ccedil;o
                                        <font color="red">
                                            *
                                        </font>
                                        <input id="rua"  style="width: 250px;" size="45" type="text" name="endereco" value="<c:out value="${usuarioRet.endereco.referencia}"></c:out>" />
                                    </font>
                                </div>
                                <div style="float:left;margin-right: 10px;">
                                    <font face="Arial">
                                        N&uacute;mero
                                        <font color="red">
                                            *
                                        </font>
                                        <input size="7" name="numero"  style="width: 50px;" type="text" value="<c:out value="${usuarioRet.endereco.numero}"></c:out>" />
                                    </font>
                                </div>
                                <div style="float:left;">
                                    <font face="Arial">
                                        Bairro
                                        <font color="red">
                                            *
                                        </font>
                                        <input id="bairro" type="text"  style="width: 200px;" name="bairro" size="21" value="<c:out value="${usuarioRet.endereco.bairro}"></c:out>" />
                                    </font>
                                </div>
                            </td>
                        </tr>
                        <tr  style="border: 0;">
                            <td style="padding-top:10px;">
                                <div style="display:inline-block !important;;margin-right: 10px;">
                                    <font face="Arial">
                                        CEP
                                        <input onblur="getEndereco();" style="width: 100px;"  type="text"  id="cep" maxlength="9" size="20" name="cep" value="<c:out value="${usuarioRet.endereco.cep}"></c:out>" />
                                    </font>
                                </div>
								<div style="display:inline-block !important;margin-right: 10px;vertical-align: bottom;">
									<input type="button" value="Verificar" />
								</div>
								<div style="display:inline-block !important;margin-right: 10px;vertical-align: bottom;">
									<a href="http://www.correios.com.br/" target="_blank"><u>N&atilde;o sabe o seu CEP? Consulte aqui</u></a>  
								</div>
							</td>
						</tr>
						<tr  style="border: 0;">
							<td style="padding-top:10px;">
                                <div style="display:inline-block !important;margin-right: 10px;">
                                    <font face="Arial">
                                        Cidade
                                        <font color="red">
                                            *
                                        </font>
                                        <input style="width: 200px;"  id="cidade" size="15"  type="text" name="cidade" value="<c:out value="${usuarioRet.endereco.cidade}"></c:out>" />
                                    </font>
                                </div>
                                <div style="display:inline-block !important;margin-right: 10px;vertical-align: bottom;">
                                    <font face="Arial">
                                        Estado
                                        <font color="red">
                                            *
                                        </font>
                                        <select id="federacao" name="federacao" style="width: 100px;" >
                                            <option value="AC" <c:if test="${usuarioRet.endereco.estado == 'AC'}">selected="selected"</c:if>>AC</option>
                                            <option value="AL" <c:if test="${usuarioRet.endereco.estado == 'AL'}">selected="selected"</c:if>>AL</option>
                                            <option value="AM" <c:if test="${usuarioRet.endereco.estado == 'AM'}">selected="selected"</c:if>>AM</option>
                                            <option value="AP" <c:if test="${usuarioRet.endereco.estado == 'AP'}">selected="selected"</c:if>>AP</option>
                                            <option value="BA" <c:if test="${usuarioRet.endereco.estado == 'BA'}">selected="selected"</c:if>>BA</option>
                                            <option value="CE" <c:if test="${usuarioRet.endereco.estado == 'CE'}">selected="selected"</c:if>>CE</option>
                                            <option value="DF" <c:if test="${usuarioRet.endereco.estado == 'DF'}">selected="selected"</c:if>>DF</option>
                                            <option value="ES" <c:if test="${usuarioRet.endereco.estado == 'ES'}">selected="selected"</c:if>>ES</option>
                                            <option value="GO" <c:if test="${usuarioRet.endereco.estado == 'GO'}">selected="selected"</c:if>>GO</option>
                                            <option value="MA" <c:if test="${usuarioRet.endereco.estado == 'MA'}">selected="selected"</c:if>>MA</option>
                                            <option value="MG" <c:if test="${usuarioRet.endereco.estado == 'MG'}">selected="selected"</c:if>>MG</option>
                                            <option value="MS" <c:if test="${usuarioRet.endereco.estado == 'MS'}">selected="selected"</c:if>>MS</option>
                                            <option value="MT" <c:if test="${usuarioRet.endereco.estado == 'MT'}">selected="selected"</c:if>>MT</option>
                                            <option value="PA" <c:if test="${usuarioRet.endereco.estado == 'PA'}">selected="selected"</c:if>>PA</option>
                                            <option value="PB" <c:if test="${usuarioRet.endereco.estado == 'PB'}">selected="selected"</c:if>>PB</option>
                                            <option value="PE" <c:if test="${usuarioRet.endereco.estado == 'PE' || usuarioRet eq null}">selected="selected"</c:if>>PE</option>
                                            <option value="PI" <c:if test="${usuarioRet.endereco.estado == 'PI'}">selected="selected"</c:if>>PI</option>
                                            <option value="PR" <c:if test="${usuarioRet.endereco.estado == 'PR'}">selected="selected"</c:if>>PR</option>
                                            <option value="RJ" <c:if test="${usuarioRet.endereco.estado == 'RJ'}">selected="selected"</c:if>>RJ</option>
                                            <option value="RN" <c:if test="${usuarioRet.endereco.estado == 'RN'}">selected="selected"</c:if>>RN</option>
                                            <option value="RO" <c:if test="${usuarioRet.endereco.estado == 'RO'}">selected="selected"</c:if>>RO</option>
                                            <option value="RR" <c:if test="${usuarioRet.endereco.estado == 'RR'}">selected="selected"</c:if>>RR</option>
                                            <option value="RS" <c:if test="${usuarioRet.endereco.estado == 'RS'}">selected="selected"</c:if>>RS</option>
                                            <option value="SC" <c:if test="${usuarioRet.endereco.estado == 'SC'}">selected="selected"</c:if>>SC</option>
                                            <option value="SE" <c:if test="${usuarioRet.endereco.estado == 'SE'}">selected="selected"</c:if>>SE</option>
                                            <option value="SP" <c:if test="${usuarioRet.endereco.estado == 'SP'}">selected="selected"</c:if>>SP</option>
                                            <option value="TO" <c:if test="${usuarioRet.endereco.estado == 'TO'}">selected="selected"</c:if>>TO</option>											
                                        </select>
                                    </font>
                                </div>
                               	
                            </td>
                        </tr>
                        <tr  style="border: 0;">
                            <td style="padding-top:10px;">
                                <div>
                                    <font face="Arial">
                                        Ponto de 
                                        refer&ecirc;ncia
                                        <input size="94" name="pto_referencia" type="text" value="<c:out value="${usuarioRet.endereco.referencia}"></c:out>" />
                                    </font>
                                </div>
                            </td>
                        </tr>
                        <tr  style="border: 0;">
                            <td style="padding-top:10px;">
                               	<div style="display: inline-block;margin-right: 10px;">
                                    <font face="Arial">
                                        Tipo do Usu&aacute;rio
                                        <font color="red">
                                            *
                                        </font>
                                        <select name="restricaoAcesso" id="restricaoAcesso" style="width: 2	00px;"  onchange="trocouUsuario();">
                                            <option value="aluno" <c:if test="${usuarioRet.tipoUsuario == 'ALUNO'}">selected="selected" </c:if>>Aluno</option>
                                            <option disabled="disabled" value="professor" <c:if test="${usuarioRet.tipoUsuario == 'PROFESSOR'}">selected="selected" </c:if>>Professor</option>
                                        </select>
                                    </font>
                                </div>
                               	<div style="display: inline-block;margin-right: 10px;">
                                	 <font face="Arial">
                                        Instituição de Origem
                                        <font color="red">
                                            *
                                        </font>
                                       <input size="94" name="instituicaoOrigem" type="text" value="<c:out value="${usuarioRet.instituicaoOrigem}"></c:out>" />
                                </div>
                            </td>
                        </tr>
                        <tr  style="border: 0;">
							<td>
								<div style="display: inline-block;margin-right: 10px;">
									Login 
									<font color="red">
		                                *
		                            </font>
		                            <input type="text" style="width: 100px" size="10" maxlength="10" name="login" value="<c:out value="${usuarioRet.login}"></c:out>" /> 
								</div>
								<div style="display: inline-block;margin-right: 10px;">
									Senha
									<font color="red">
		                                *
		                            </font>
		                            <input type="password" style="width: 100px" size="10" name="senha" />
								</div>
								<div style="display: inline-block;margin-right: 10px;">
									Confirmar Senha
									<font color="red">
		                                *
		                            </font>
		                            <input type="password" size="10" style="width: 100px" name="confirmasenha" />
								</div>
							</td>
						</tr>
                        <tr  style="border: 0;">
                            <td style="padding-top:10px;">
                            
                            	<div id="div-cursos" 	<c:if test="${usuarioRet.tipoUsuario == 'PROFESSOR'}">style="display:none;"</c:if>>
	                                <div style="display:inline-block !important;margin-right: 10px;">
	                                    <font face="Arial">
	                                      Curso
	                                        <font color="red">
	                                            *
	                                        </font>
	                                        <select name="curso" id="curso" style="width: 400px;" >
	                                        
	                                        	<c:forEach items="${cursos}" var="curso" varStatus="index">
		                                            <option value="${curso.id}" <c:if test="${usuarioRet.tipoUsuario == 'ALUNO'}">selected="selected" </c:if>> ${curso.titulo}</option>
	                                        	</c:forEach>
	                                        </select>
	                                    </font>
	                                </div>
	                                <div id="" style="display:inline-block !important;vertical-align: bottom;">
	                                	<input type="button" value="Matricular-se" onclick="adicionarCurso()" />
	                                	<input type="hidden" name="cursos" id="cursos" value="<c:out value="${listaCursosString}"></c:out>" />
	                                </div>
	                                <br />
	                                <div style="">
	                                	<table id="cursos-selecionados">
	                                		<thead>
	                                			<th>Curso</th>
	                                			<th>Ação</th>
	                                		</thead>
	                                		<tbody id="cursos-tbody" align="center">
	                                			<c:forEach items="${cursos}" var="curso" varStatus="index">
		                                			<c:forEach items="${listaCursos}" var="cursoTmp" varStatus="index">
		                                				<c:if test="${cursoTmp.id == curso.id}">
			                                				<tr id="row-<c:out value="${curso.id}"></c:out>">
						                                            <td>${curso.titulo}</td>
						                                             <td><input type="button" value="Remover" onclick="removerCurso(${curso.id});"></input></td>
		        	                        				</tr>
	                                					</c:if>	
	            	                            	</c:forEach>
	                                        	</c:forEach>
	                                		</tbody>
	                                	</table>
	                                </div>
                            	</div>
                            </td>
                        </tr>
						<tr  style="border: 0;">
                            <td>
                                <font color="red" size="1">
                                    *Campos obrigat&oacute;rios
                                </font>
                            </td>
                        </tr>
						<tr  style="border: 0;">
                            <td align="center">
                            		<table>
                            			<tr style="border: 0;">
											<td style="width: 70%;">
								            	<input type="button" onclick="window.location.href = '/isa';" value="Voltar" />
											</td>
											<td style="width: 15%;" align="right">
												<h:reset onclick="removerTodosCursos();" value="Limpar"/>
											</td>
											<td style="width: 15%;">
												<h:submit value="Salvar"/> 	
											</td>
                            			</tr>
                            		</table>
                            </td>
                        </tr>
                    </table>
                    
                </h:form>
            </div>
            	<div style="widht:100%; height: 250px;">
            	
            	</div>
					<br /><br /><br /><br />
					
					
			</div>
			
			
			
			<%@ include file="/jsp/inc_rodape.jsp"%>
    	
    	
    	
    </body>
</html>
