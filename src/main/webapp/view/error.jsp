<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/css/style.css" var="cssResource" />
<spring:url value="/lesson/show" var="homeUrl" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Planification et Suivi des Cours</title>
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet" href="${cssResource}">
</head>
<body>
	<section class="jumbotron text-center" style="margin-bottom: 0;">
		<div class="container">
			<h1>Planification et Suivi des Cours</h1>
			<p class="lead text-muted">Bienvenue à la palteforme de gestion des cours de SupMTI.</p>
		</div>
	</section>

	<div class="container">
		<p>Ouuups! une erreur est produite ou vous pouvez pas accéder à cette page.</p>
		<p><a href="${homeUrl}">Retourner à l'accueil.</a></p>
		
	</div>


</body>
</html>