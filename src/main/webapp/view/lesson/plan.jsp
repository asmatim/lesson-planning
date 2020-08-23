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
				<form:form modelAttribute="dummy" id="plan-lesson-form">
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
                            <label for="lSubject">Matière</label>
                            <select id="lSubject" class="form-control" name="subjectId">
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="lStartDate">Date de début</label>
                            <input id="lStartDate" class="form-control" name="lStartDate" type="datetime-local" />
                        </div>
                        <div class="form-group">
                            <label for="lEndDate">Date de fin</label>
                            <input id="lEndDate" class="form-control" name="lEndDate" type="datetime-local" />
                        </div>
					</div>
					<input type="button" class="btn btn-primary" value="Valider" id="btn-add-lesson" />
                    <div class="form-errors mt-1"></div>
				</form:form>
				<div id="calendar"></div>
			</div>
		</div>
		<div class="modal fade" id="lesson-update-modal" tabindex="-1" aria-labelledby="lesson-update-modal-label" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="lesson-update-modal-label">Mettre à jour la séance</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Fermer">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
              <form:form modelAttribute="dummy" id="modal-plan-lesson-form">
                <div class="form-group">
                    <label for="modal-lClass">Classe</label>
                     <form:select id="modal-lClass" class="form-control" path="classId" disabled="disabled">
                        <option></option>
                        <form:options items="${classes}" itemLabel="name" itemValue="classId" />
                    </form:select>
                </div>
                <div class="form-group">
                    <label for="modal-lProfessor">Professeur</label>
                     <form:select id="modal-lProfessor" class="form-control" path="professorId">
                        <form:options items="${professors}" itemLabel="lastName" itemValue="professorId" />
                    </form:select>
                </div>
                <div class="form-group">
                    <label for="modal-lClassroom">Salle</label>
                     <form:select id="modal-lClassroom" class="form-control" path="classroomId">
                        <form:options items="${classrooms}" itemLabel="name" itemValue="classroomId" />
                    </form:select>
                </div>
                <div class="form-group">
                    <label for="modal-lSubject">Matière</label>
                    <select id="modal-lSubject" class="form-control" name="subjectId">
                    </select>
                </div>
                <div class="form-group">
                    <label for="modal-lStartDate">Date de début</label>
                    <input id="modal-lStartDate" class="form-control" name="lStartDate" type="datetime-local" />
                </div>
                <div class="form-group">
                    <label for="modal-lEndDate">Date de fin</label>
                    <input id="modal-lEndDate" class="form-control" name="lEndDate" type="datetime-local" />
                </div>
                <div class="modal-form-errors mt-1"></div>
              </form:form>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
                <button type="button" class="btn btn-primary" id="modal-btn-add-lesson">Valider</button>
              </div>
            </div>
          </div>
        </div>
	</div>
</div>

<jsp:include page="footer-lesson.jsp"></jsp:include>