<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>EduCardio</title>
</head>

<meta name="title" content="Educardio" />
<meta name="description" content="Intervenção educacional sobre cardiopatias congênitas para graduandos em Enfermagem: uma abordagem de métodos mistos" />
<meta name="keywords" content="Enfermagem, Educação, Cardiopatia" />
<meta name="language" content="pt-BR" />
<meta name="robots" content="All" />
<meta name="revisit" content="7 days" />
<meta name="author" content="" />
   <link href="icones/favicon.png" rel="shortcut icon"/>
<link href="css/screen.css" type="text/css" rel="stylesheet" media="screen" />

<script src="js/flash.js" type="text/javascript" ></script>
<script src="js/jquery.js" type="text/javascript"></script>



<script type="text/javascript">
            
            function blockHistoryNavegation(){
            	
            	console.log(history.forward());
		        window.history.forward();
		 //       blockHistoryNavegation();
            }
            blockHistoryNavegation();
    </script>

<%
	if(request.getAttribute("mensagem") != null && !request.getAttribute("mensagem").equals("")){
%>
		 <link rel="stylesheet" href="css/jquery-ui-1.10.1.custom.css" />
		  <script src="js/jquery-1.3.2.js"></script>
		  <script src="js/jquery-ui-1.7.2.custom.js"></script>
		<script>
		 $(document).ready(function () {
			 
			 var p = document.createElement ('p');
			 p.innerHTML = '<span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 110px 0;"></span><%=request.getAttribute("mensagem")%>' ;
			 
			 var div = document.createElement ('div');
			 div.setAttribute ('id', "dialog-message");
			 div.setAttribute ('title', "Mensagem Alerta");
			 
			 div.appendChild(p);
			 document.body.appendChild(div);	
			 
		    $( "#dialog-message" ).dialog({
		      modal: true,
		      buttons: {
		        Ok: function() {
		          $( this ).dialog( "close" );
		        }
		      }
		    });
		  });
		 
		  </script>
		  
	<% } %>