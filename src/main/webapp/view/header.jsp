<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/css/style.css" var="cssResource" />
<spring:url value="/resources/css/planing.css" var="planingCssResource" />
<spring:url value="/resources" var="urlResource" />

<spring:url value="/professor/list" var="homeUrl" />

<spring:url value="/professor/list"	var="profListUrl" />
<spring:url value="/professor/create" var="profCreateUrl" />

<spring:url value="/branch/list"	var="branchListUrl" />
<spring:url value="/branch/create" var="branchCreateUrl" />

<spring:url value="/logout" var="logoutUrl" />

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>${title}</title>
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet" href="${urlResource}/open-iconic/font/css/open-iconic-bootstrap.css">
<link rel="stylesheet" href="${cssResource}">
<link rel="stylesheet" href="${planingCssResource}">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.3.0/main.min.css">
</head>
<body>
	<header>
		<!-- Fixed navbar -->
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<a class="navbar-brand" href="#"><span class="oi oi-wrench" title="Suivi Cours" aria-hidden="true"></span> Planification de cours</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarCollapse" aria-controls="navbarCollapse"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link"
						href="${homeUrl}"><span class="oi oi-home" title="Home" aria-hidden="true"></span> Home <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownCar"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"><span class="oi oi-puzzle-piece" title="Professeur" aria-hidden="true"></span> Professeur</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdownCar">
							<a class="dropdown-item" href="${profCreateUrl}"><span class="oi oi-plus" title="Ajouter Professeur" aria-hidden="true"></span> Ajouter</a> <a
								class="dropdown-item" href="${profListUrl}"><span class="oi oi-list" title="Professeurs" aria-hidden="true"></span> Liste</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownOffer"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"><span class="oi oi-flag" title="Offre" aria-hidden="true"></span> Branche</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdownOffer">
							<a class="dropdown-item" href="${branchCreateUrl}"><span class="oi oi-plus" title="Ajouter Branche" aria-hidden="true"></span> Ajouter</a> <a
								class="dropdown-item" href="${branchListUrl}"><span class="oi oi-list" title="Liste Branches" aria-hidden="true"></span> Liste</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownReservation"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"><span class="oi oi-book" title="R�s�rvation" aria-hidden="true"></span> Résérvation</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdownReservation">
							<a class="dropdown-item" href="${reservationValidateUrl}"><span class="oi oi-circle-check" title="Validation" aria-hidden="true"></span> Validation</a> <a
								class="dropdown-item" href="${reservationHistoryUrl}"><span class="oi oi-list" title="Historique" aria-hidden="true"></span> Historique</a>
						</div></li>
				</ul>
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="${logoutUrl}"><span class="oi oi-account-logout" title="Logout" aria-hidden="true"></span> Logout</a></li>
				</ul>
			</div>
		</nav>
	</header>