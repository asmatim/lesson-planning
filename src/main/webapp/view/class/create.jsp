<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>
<spring:url value="/class/create" var="createrUrl" />

<div class="main">
	<div class="container">
		<div class="card">
			<h5 class="card-header">Nouvelle classe</h5>
			<div class="card-body">
				<h5 class="card-title">Créer une nouvelle classe</h5>
				<form:form action="${createUrl}" method="post" modelAttribute="classe">
					<div class="form-group">
						<label for="cName">Nom</label>
						    <form:input id="cName" class="form-control"	path="name" />
						<label for="cYear">Année</label>
						    <form:input id="cYear" class="form-control"	path="year" />
					</div>
					<input type="submit" class="btn btn-primary" value="Valider" />
				</form:form>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>