<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>
<spring:url value="/professor/create" var="createUrl" />

<div class="main">
	<div class="container">
		<div class="card">
			<h5 class="card-header">Informations voiture</h5>
			<div class="card-body">
				<h5 class="card-title">Informations voiture</h5>
				<form:form action="${createUrl}" method="POST" modelAttribute="professor">

					<div class="form-group">
						<label for="pFirstName">Prénom</label>
						<form:input id="pFirstName" class="form-control" path="firstName" />
					</div>

					<div class="form-group">
						<label for="pLastName">Nom</label>
						<form:input id="pLastName" class="form-control"
							path="lastName" />
					</div>

					<div class="form-group">
						<label for="pCin">CIN</label>
						<form:input id="pCin" class="form-control" path="cin" />
					</div>

					<div class="form-group">
						<label for="pEmail">Email</label>
						<form:input id="pEmail" class="form-control" path="email" />
					</div>

                    <div class="form-group">
                        <label for="pPhone">Numéro de telephone</label>
                        <form:input id="pPhone" class="form-control" path="phone" />
                    </div>
					
					<c:if test="${not empty professorId}">
						<form:hidden id="pId" path="professorId" />
					</c:if>
					<input type="submit" class="btn btn-primary" value="Valider" />
				</form:form>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>