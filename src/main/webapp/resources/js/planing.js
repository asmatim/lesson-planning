var lessonsFullCalendar;

$( document ).ready(function() {

    bindClassChange();
    bindAddLesson();
    initFullCalendar();
});

function initFullCalendar() {
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'timeGridWeek',
        locale: 'fr',
        firstDay: 1,
        eventClick: function(info) {
            info.jsEvent.preventDefault(); // don't let the browser navigate

            if (info.event.id) {
              showModalForLesson(info.event.id);
            }
          }
    });
    calendar.render();
    lessonsFullCalendar = calendar;
}

function bindClassChange() {
    $("#lClass").change(function (){
        var selectClass = $(this).children("option:selected").val();
        if(selectClass !== "" && !isNaN(selectClass)) {
            loadSubjectsForSelectedClass(selectClass);
            loadLessonsForSelectedClass(selectClass);
        }
        else {
            $("#lesson-fields").addClass("d-none");
        }
    });
}

function loadSubjectsForSelectedClass(selectClass) {
    $.post( "/subject/get/all", { classId: selectClass })
      .done(function( subjectsResult ) {
        reloadSubjects(subjectsResult);
        $("#lesson-fields").removeClass("d-none");
    });
}

function reloadSubjects(subjectsResult) {
    $("#lSubject option").remove(); // Remove all <option> child tags.
    $("#modal-lSubject option").remove(); // Remove all <option> child tags.
    $.each(subjectsResult, function(index, item) { // Iterates through a collection
        $("#lSubject, #modal-lSubject").append( // Append an object to the inside of the select box
            $("<option></option>") // Create option tag.
                .text(item.name)
                .val(item.subjectId)
        );
    });
}

function loadLessonsForSelectedClass(selectClass) {
    $.post( "/lesson/get/all", { classId: selectClass })
      .done(function( lessonsResult ) {
        reloadLessons(lessonsResult);
    });
}

function reloadLessons(lessonsResult) {
    var allLessons = lessonsFullCalendar.getEvents();
    $.each(allLessons, function(index, item) { // Iterates through a collection
        item.remove();
    });

    $.each(lessonsResult, function(index, item) { // Iterates through a collection
        addLessonToCalendar(item);
    });
}

function bindAddLesson() {
    $("#btn-add-lesson").click(function(){
        var selectedClass = $("#lClass").children("option:selected").val();
        var selectedProfessor = $("#lProfessor").children("option:selected").val();
        var selectedSubject = $("#lSubject").children("option:selected").val();
        var selectedClassroom = $("#lClassroom").children("option:selected").val();
        var lessonStartDate = $("#lStartDate").val();
        var lessonEndDate = $("#lEndDate").val();

        var formattedStartDate = dayjs(lessonStartDate).format("DD/MM/YYYY HH:mm");
        var formattedEndDate = dayjs(lessonEndDate).format("DD/MM/YYYY HH:mm");

//        console.log(formattedStartDate);
//        console.log(formattedEndDate);

        var lessonRequestData = {
            classId: selectedClass,
            professorId: selectedProfessor,
            classroomId: selectedClassroom,
            subjectId: selectedSubject,
            startDate: formattedStartDate,
            endDate: formattedEndDate
        };

//        console.log(lessonRequestData);

        $.post("/lesson/add", lessonRequestData )
          .done(function( lessonResult ) {
            if(lessonResult !== null && lessonResult.lessonErrors == null) {
                addLessonToCalendar(lessonResult);
            }
            else {
                $("#plan-lesson-form .form-errors").empty();

                $.each(lessonResult.lessonErrors, function(index, item) { // Iterates through a collection
                    $("#plan-lesson-form .form-errors").append( // Append an object to the inside of the div
                        $("<div></div>") // Create option tag.
                            .text(item)
                            .addClass("alert alert-danger")
                    );
                });
            }
        });
    });
}

function addLessonToCalendar(lessonToAdd) {
    lessonsFullCalendar.addEvent({
      id: lessonToAdd.lessonId,
      title: lessonToAdd.subjectName,
      start: lessonToAdd.startDate,
      end: lessonToAdd.endDate
    });
}

function showModalForLesson(lessonId) {
    $.get("/lesson/get/" + lessonId)
      .done(function( lessonResult ) {
        if(lessonResult !== null && lessonResult.lessonErrors == null) {
            $("#modal-lClass").val(      lessonResult.classId);
            $("#modal-lProfessor").val(  lessonResult.professorId);
            $("#modal-lSubject").val(    lessonResult.subjectId);
            $("#modal-lClassroom").val(  lessonResult.classroomId);
            $("#modal-lStartDate").val(  dayjs(lessonResult.startDate).format('YYYY-MM-DDThh:mm:ss.SSS'));
            $("#modal-lEndDate").val(    dayjs(lessonResult.endDate).format('YYYY-MM-DDThh:mm:ss.SSS'));
        }
        $('#lesson-update-modal').modal('show');
    });
}

