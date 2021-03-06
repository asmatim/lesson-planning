<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/js/planing.js" var="planingJsResource" />

<footer class="footer fixed-bottom">
	<div class="container">
		<span class="text-muted float-left">Réalisé par Asma TIMZIT</span>
		<span class="text-muted float-right">SupMTI 2019-2020</span>
	</div>
</footer>

<!-- JS, Popper.js, and jQuery -->
<script
      src="https://code.jquery.com/jquery-3.5.1.min.js"
      integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
      crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/dayjs@1.8.34/dayjs.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.3.0/main.min.js"></script>
<script src="${planingJsResource}"></script>
</body>
</html>