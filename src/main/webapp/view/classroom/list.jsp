<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>
<spring:url value="/classroom/create" var="createUrl" />
<spring:url value="/classroom/detail" var="detailUrl" />

<div class="main">
	<div class="container">
			<c:forEach items="${classrooms}" var="classroom">
				<div class="card mb-3">
					<h3 class="card-header">${classroom.name}</h3>
						<div class="card-body">
							<h5 class="card-title">${classroom.name}</h5>
							<div class="card-text">
								<p><span class="font-weight-bold">Nom: </span>${classroom.name}</p>
							</div>
					    </div>
					<div class="card-footer">
						<div class="text-right"><a href="${detailUrl}/${classroom.id}" class="btn btn-primary">Afficher</a></div>
					</div>
				</div>
			</c:forEach>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>