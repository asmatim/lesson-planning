<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>
<spring:url value="/class/create" var="createUrl" />

<div class="main">
	<div class="container">
		<div class="card">
			<h5 class="card-header">Sauvegarde classe</h5>
			<div class="card-body">
				<h5 class="card-title">Infos classe</h5>
				<form:form action="${createUrl}" method="post" modelAttribute="classe">
					<div class="form-group">
						<label for="cName">Nom</label>
						    <form:input id="cName" class="form-control"	path="name" />
						<label for="cYear">Année</label>
						    <form:input id="cYear" class="form-control"	path="year" />
					</div>
					<div class="form-group">
                        <label for="cBranch">Branche</label>
                        <form:select path="branchId" id="cBranch" class="form-control">
                               <form:options items="${branches}" itemLabel="name" itemValue="id" />
                        </form:select>
                    </div>
                    <form:hidden id="cId" class="form-control"	path="classId" />
					<input type="submit" class="btn btn-primary" value="Valider" />
				</form:form>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>