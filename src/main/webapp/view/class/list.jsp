<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>
<spring:url value="/class/create" var="createUrl" />
<spring:url value="/class/detail" var="detailUrl" />

<div class="main">
	<div class="container">
			<c:forEach items="${classes}" var="class">
				<div class="card mb-3">
					<h3 class="card-header">${class.name}</h3>
						<div class="card-body">
							<h5 class="card-title">${class.name}</h5>
							<div class="card-text">
								<p><span class="font-weight-bold">Nom: </span>${class.name}</p>
							</div>
					    </div>
					<div class="card-footer">
						<div class="text-right"><a href="${detailUrl}/${class.id}" class="btn btn-primary">Afficher</a></div>
					</div>
				</div>
			</c:forEach>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>