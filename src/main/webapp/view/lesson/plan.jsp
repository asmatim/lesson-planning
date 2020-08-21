<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp"></jsp:include>

<div class="main">
	<div class="container">
		<div class="card">
			<h5 class="card-header">Planification séances</h5>
			<div class="card-body">
				<h5 class="card-title">Gérer l'emploi du temps des classes</h5>
				<form:form modelAttribute="dummy">
					<div class="form-group">
                        <label for="lClass">Classe</label>
                        <form:select id="lClass" class="form-control" path="classId">
                            <option></option>
                            <form:options items="${classes}" itemLabel="name" itemValue="classId" />
                        </form:select>
                    </div>
                    <div id="lesson-fields" class="d-none">
                        <div class="form-group">
                            <label for="lProfessor">Professeur</label>
                            <form:select id="lProfessor" class="form-control" path="professorId">
                                   <form:options items="${professors}" itemLabel="lastName" itemValue="professorId" />
                            </form:select>
                        </div>
                        <div class="form-group">
                            <label for="lClassroom">Salle</label>
                            <form:select id="lClassroom" class="form-control" path="classroomId">
                                   <form:options items="${classrooms}" itemLabel="name" itemValue="classroomId" />
                            </form:select>
                        </div>
                        <div class="form-group">
                            <label for="lSubject">Salle</label>
                            <select id="lSubject" class="form-control" name="subjectId">
                            </select>
                        </div>
					</div>
					<input type="button" class="btn btn-primary" value="Valider" />
				</form:form>
				<div id="calendar"></div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="footer-lesson.jsp"></jsp:include>