<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>
<spring:url value="/subject/create" var="createrUrl" />

<div class="main">
	<div class="container">
		<div class="card">
			<h5 class="card-header">Nouvelle matière</h5>
			<div class="card-body">
				<h5 class="card-title">Créer une nouvelle matière</h5>
				<form:form action="${createUrl}" method="post" modelAttribute="subject">
					<div class="form-group">
						<label for="sName">Nom</label>
						    <form:input id="sName" class="form-control"	path="name" />
						<label for="sVolume">Volume</label>
						    <form:input id="sVolume" class="form-control"	path="volume" />
					</div>
					<input type="submit" class="btn btn-primary" value="Valider" />
				</form:form>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>