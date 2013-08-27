<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Saisie voiture</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<fmt:setBundle basename="messages" />
	
	

	<h1><fmt:message key="saisie-voiture.titre"/></h1>
	<br />

	<form:form action="voiture.do" commandName="voiture" method="POST">
	


		<table>
		
			<tr>
				<td>Marque :</td>
				<td> <form:input path="marque"/> <form:errors path="marque"/> </td>
			</tr>
			<tr>
				<td>Modele :</td>
				<td> <form:input path="modele"/> <form:errors path="modele"/> </td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="Valider"> </td>
			</tr>
		</table>

	</form:form>
<%@ include file="footer.jsp" %>
</body>
</html>