<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/css/style.css" var="cssResource" />
<spring:url value="/resources" var="urlResource" />

<spring:url value="/company/reservation/history" var="homeUrl" />

<spring:url value="/company/reservation/history"
	var="reservationHistoryUrl" />
<spring:url value="/company/reservation/list/validate"
	var="reservationValidateUrl" />

<spring:url value="/company/offer/create" var="offerCreateUrl" />
<spring:url value="/company/offer/list" var="offerListUrl" />

<spring:url value="/company/car/create" var="carCreateUrl" />
<spring:url value="/company/car/list" var="carListUrl" />

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
</head>
<body>
	<header>
		<!-- Fixed navbar -->
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<a class="navbar-brand" href="#"><span class="oi oi-wrench" title="Voiture" aria-hidden="true"></span> Espace agence location</a>
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
						aria-expanded="false"><span class="oi oi-puzzle-piece" title="Voiture" aria-hidden="true"></span> Voiture</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdownCar">
							<a class="dropdown-item" href="${carCreateUrl}"><span class="oi oi-plus" title="Ajouter Voiture" aria-hidden="true"></span> Ajouter</a> <a
								class="dropdown-item" href="${carListUrl}"><span class="oi oi-list" title="Voitures" aria-hidden="true"></span> Liste</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownOffer"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"><span class="oi oi-flag" title="Offre" aria-hidden="true"></span> Offre</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdownOffer">
							<a class="dropdown-item" href="${offerCreateUrl}"><span class="oi oi-plus" title="Ajouter" aria-hidden="true"></span> Ajouter</a> <a
								class="dropdown-item" href="${offerListUrl}"><span class="oi oi-list" title="Liste Offres" aria-hidden="true"></span> Liste</a>
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