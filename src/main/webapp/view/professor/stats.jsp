<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>
<spring:url value="/professor/stats" var="statsUrl" />

<div class="main">
	<div class="container">
		<div class="card">
			<h5 class="card-header">Avancement professeur</h5>
			<div class="card-body">
				<h5 class="card-title">Statistiques</h5>
				<form:form action="${statsUrl}" method="POST" modelAttribute="stats">

					<div class="form-group">
                        <label for="lClass">Classe</label>
                        <form:select id="lClass" class="form-control" path="classId">
                            <option></option>
                            <form:options items="${classes}" itemLabel="name" itemValue="classId" />
                        </form:select>
                    </div>
					<form:hidden id="pProfessorId" class="form-control" path="professorId" />
					<input type="submit" class="btn btn-primary" value="Valider" />
				</form:form>

				<c:if test="${not empty stats.totals}">
                    <hr/>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>Matière</th>
                                <th>Nombre d'heure réalisées</th>
                                <th>Total prévu</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${stats.totals}" var="entry">
                                <tr>
                                    <td>${entry.key.name}</td>
                                    <td>${entry.value}</td>
                                    <td>${entry.key.volume}h</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>