<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>
<spring:url value="/branch/create" var="createUrl" />

<div class="main">
	<div class="container">
		<div class="card">
			<h5 class="card-header">Sauvegarde branche</h5>
			<div class="card-body">
				<h5 class="card-title">Infos branche</h5>
				<form:form action="${createUrl}" method="post" modelAttribute="branch">
					<div class="form-group">
						<label for="bName">Nom</label>
						<form:input id="bName" class="form-control"	path="name" />
					</div>
					<form:hidden id="bId" class="form-control"	path="branchId" />
					<input type="submit" class="btn btn-primary" value="Valider" />
				</form:form>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>