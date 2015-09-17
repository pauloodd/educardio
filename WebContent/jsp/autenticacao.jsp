
<% String urlBase = request.getContextPath(); %>

<%
	if(session.getAttribute("usuario") == null){
%>
	<script type="text/javascript">
		window.top.location.href = "educardio/";
	</script>
<%
	}else{
	}
%>

