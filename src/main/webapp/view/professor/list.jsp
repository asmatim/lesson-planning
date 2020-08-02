<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../company-header.jsp"></jsp:include>
<spring:url value="/company/car/create" var="createCarUrl" />
<spring:url value="/company/car/detail" var="detailCarUrl" />
<spring:url value="/resources/upload/" var="uploadUrl" />

<div class="main">
	<div class="container">
			<c:forEach items="${cars}" var="car">
				<div class="card mb-3">
					<h3 class="card-header">${car.brand} - ${car.model}</h3>
						<div class="card-body">
							<h5 class="card-title">${car.brand}- ${car.model}</h5>
							<div class="card-text">
								<p><span class="font-weight-bold">Matricule: </span>${car.matricule}</p>
								<p><span class="font-weight-bold">Marque: </span>${car.brand}</p>
								<p><span class="font-weight-bold">Mod�le: </span>${car.model}</p>
								<p><span class="font-weight-bold">Ann�e: </span>${car.brand}</p>
								<p><img class="photo" alt="" src="${uploadUrl}${car.image}"></p>
							</div>
					</div>
					<div class="card-footer">
						<div class="text-right"><a href="${detailCarUrl}/${car.id}" class="btn btn-primary">Afficher</a></div>
					</div>
				</div>
			</c:forEach>
	</div>
</div>
<jsp:include page="../company-footer.jsp"></jsp:include>