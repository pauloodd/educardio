<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt-br" lang="pt-br"> 
<head> 
		<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
		<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
		<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
		
  <script src="jscripts/jquery-latest.js"></script>
  <link rel="stylesheet" href="Css/jquery.autocomplete.css" type="text/css" />
  
  <script type="text/javascript" src="jscripts/jquery.bgiframe.min.js"></script>
  <script type="text/javascript" src="jscripts/jquery.autocomplete.js"></script>
  <script>
  $(document).ready(function(){
     	$("#autocomplete").autocomplete("http://localhost:8080/isa/autocomplete.txt",
     			{
     		delay:10,
     		minChars:2,
     		matchSubset:1,
     		matchContains:1,
     		cacheLength:10,
     		autoFill:true
	  });
  });
  </script>
  <script language="JavaScript" type="text/javascript" >
  	function submeter(){
	  document.forms["autocomplete"].submit();
	 }
  </script>
</head>
<body>
<form name="autocomplete" method="get" action="autocomplete.do" onsubmit="return false;" >
<h:hidden property="method" value="autocomplete"/>  
  Autocomplete: <input id="autocomplete" name="autocomplete" size="100"  /> 
</form>
</body>
</html>
