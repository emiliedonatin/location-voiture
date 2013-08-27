<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


	<%!
	int pageCount = 0; void addCount() {pageCount++;}%>
	<%addCount();%>


<head>
<title>The include Directive Example</title>
</head>
<body>
	<center>
		<h2>Bienvenue sur notre site de location de voiture</h2>
		
		<a href="/location-voiture/j_spring_security_logout">Déconnexion</a>
		<p>
			La page a été visitée <%=pageCount%> fois.
		</p>
	</center>
	<br />
	<br />


</body>
</html>


