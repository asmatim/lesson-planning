<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>
<spring:url value="/classroom/create" var="createrUrl" />

<div class="main">
	<div class="container">
		<div class="card">
			<h5 class="card-header">Nouvelle salle</h5>
			<div class="card-body">
				<h5 class="card-title">Créer une nouvelle salle</h5>
				<form:form action="${createUrl}" method="post" modelAttribute="classroom">
					<div class="form-group">
						<label for="cName">Nom</label>
						    <form:input id="cName" class="form-control"	path="name" />
						<label for="cCapacity">Capacité</label>
						    <form:input id="cCapacity" class="form-control"	path="capacity" />
					</div>
					<input type="submit" class="btn btn-primary" value="Valider" />
				</form:form>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>