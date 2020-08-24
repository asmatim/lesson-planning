<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>
<spring:url value="/branch/edit" var="editUrl" />
<spring:url value="/branch/delete" var="deleteUrl" />

<div class="main">
	<div class="container">
		<div class="card mb-3">
			<h3 class="card-header">${branch.name} </h3>
			<div class="card-body">
				<h5 class="card-title">${branch.name} </h5>
				<div class="card-text">
					<p><span class="font-weight-bold">Nom: </span>${branch.name}</p>
				</div>
				<div class="card-footer">
					<div class="text-right">
						<a href="${deleteUrl}/${branch.id}" class="btn btn-danger">Supprimer</a>
						<a href="${editUrl}/${branch.id}" class="btn btn-primary">Modifier</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>