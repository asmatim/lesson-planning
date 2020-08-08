<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>
<spring:url value="/subject/edit" var="editUrl" />
<spring:url value="/subject/delete" var="deleteUrl" />

<div class="main">
	<div class="container">
		<div class="card mb-3">
			<h3 class="card-header">${subject.name} </h3>
			<div class="card-body">
				<h5 class="card-title">${subject.name} </h5>
				<div class="card-text">
					<p><span class="font-weight-bold">Nom: </span>${subject.name}</p>
					<p><span class="font-weight-bold">Volume: </span>${subject.volume}</p>
				</div>
				<div class="card-footer">
					<div class="text-right">
						<a href="${deleteUrl}/${subject.id}" class="btn btn-danger">Supprimer</a>
						<a href="${editUrl}/${subject.id}" class="btn btn-primary">Modifier</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>