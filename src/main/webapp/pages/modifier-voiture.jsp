<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Saisie voiture</title>
</head>
<body>
<%@ include file="header.jsp" %>

	<h1>Modifier une voiture</h1>
	<br />
	<form:form action="modifier.do" commandName="voiture" method="POST">
	
	<form:hidden path="id"/>

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