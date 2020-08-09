<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>
<spring:url value="/module/create" var="createrUrl" />

<div class="main">
	<div class="container">
		<div class="card">
			<h5 class="card-header">Nouveau Module</h5>
			<div class="card-body">
				<h5 class="card-title">Créer un nouveau module</h5>
				<form:form action="${createUrl}" method="post" modelAttribute="module">
					<div class="form-group">
						<label for="mName">Nom</label>
						<form:input id="mName" class="form-control"	path="name" />
					</div>
					<div class="form-group">
                        <label for="mBranch">Branche</label>
                        <form:select path="branchId" id="mBranch" class="form-control">
                               <form:options items="${branches}" itemLabel="name" itemValue="id" />
                        </form:select>
                    </div>
					<input type="submit" class="btn btn-primary" value="Valider" />
				</form:form>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>