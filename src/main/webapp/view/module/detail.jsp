<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>
<spring:url value="/module/edit" var="editUrl" />
<spring:url value="/module/delete" var="deleteUrl" />

<div class="main">
	<div class="container">
		<div class="card mb-3">
			<h3 class="card-header">${module.name} </h3>
			<div class="card-body">
				<h5 class="card-title">${module.name} </h5>
				<div class="card-text">
					<p><span class="font-weight-bold">Nom: </span>${module.name}</p>
					<p><span class="font-weight-bold">Branche: </span>${module.branch.name}</p>
				</div>
				<div class="card-footer">
					<div class="text-right">
						<a href="${deleteUrl}/${module.id}" class="btn btn-danger">Supprimer</a>
						<a href="${editUrl}/${module.id}" class="btn btn-primary">Modifier</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>