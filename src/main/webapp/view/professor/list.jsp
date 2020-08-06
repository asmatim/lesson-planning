<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>
<spring:url value="/professor/create" var="createUrl" />
<spring:url value="/professor/detail" var="detailUrl" />

<div class="main">
	<div class="container">
			<c:forEach items="${professors}" var="professor">
				<div class="card mb-3">
					<h3 class="card-header">${professor.firstName} - ${professor.lastName}</h3>
						<div class="card-body">
							<h5 class="card-title">${professor.firstName} - ${professor.lastName}</h5>
							<div class="card-text">
								<p><span class="font-weight-bold">Nom: </span>${professor.lastName}</p>
								<p><span class="font-weight-bold">Prénom: </span>${professor.firstName}</p>
								<p><span class="font-weight-bold">Cin: </span>${professor.cin}</p>
								<p><span class="font-weight-bold">Email: </span>${professor.email}</p>
								<p><span class="font-weight-bold">Date de naissance: </span>${professor.birthdate}</p>
								<p><span class="font-weight-bold">numéro de téléphone: </span>${professor.phone}</p>
							</div>
					    </div>
					<div class="card-footer">
						<div class="text-right"><a href="${detailUrl}/${professor.id}" class="btn btn-primary">Afficher</a></div>
					</div>
				</div>
			</c:forEach>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>