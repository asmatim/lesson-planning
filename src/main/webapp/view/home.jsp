<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/css/style.css" var="cssResource" />
<spring:url value="/login" var="loginUrl" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Planification et suivi des cours</title>
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

		<form action="${loginUrl}" method="POST" class="form-signin">
			<h3 class="form-signin-heading">Login</h3>
			<br /> <input type="text" id="username" name="username"
				placeholder="User Name" class="form-control" /> <br /> <input
				type="password" placeholder="Password" id="password" name="password"
				class="form-control" /> <br />

			<c:if test="${not empty param.error}">
				<div align="center">
					<p style="font-size: 20; color: #FF1C19;">Nom d'utilisateur ou mot de passe incorrect.</p>
				</div>
			</c:if>
			<button class="btn btn-lg btn-success btn-block" name="Submit"
				value="Login" type="Submit">Login</button>
		</form>
	</div>


</body>
</html>