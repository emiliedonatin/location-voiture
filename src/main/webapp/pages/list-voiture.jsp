<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Saisie voiture</title>
</head>
<body>

	<h1>Liste des voitures</h1>
	<br />
	<a href="voiture.do">Ajouter une voiture</a>
	<br />
	<br />
	<br />
	
	<table border="1">
	
	<tr>
				<th>Id</th>
				<th>Marque</th>
				<th>Modele</th>
				<th>Action</th>
				
				
			</tr>
			
		<!-- on va faire une itération sur la liste des voitures -->
		<c:forEach items="${voitures}" var="v">

			<tr>
				<td>${v.id}</td>
				<td>${v.marque}</td>
				<td>${v.modele}</td>
				<td><a href="modifier.do?id=${v.id}">Modifier</a><br /><a href="delete.do?id=${v.id}">Supprimer</a> </td>
				
			</tr>

		</c:forEach>
	</table>
	
	<br/>
	
	Super Voiture : ${supervoiture.marque}

</body>
</html>