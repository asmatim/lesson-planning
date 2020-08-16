package ma.ac.supmti.pfe.dto;

import java.util.Date;
import java.util.List;

public class LessonDto {

    private Long professorId;
    private Long classroomId;
    private Long classId;
    private Long subjectId;
    private Date startDate;
    private Date endDate;

    private List<String> lessonErrors;

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public Long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setLessonErrors(List<String> lessonErrors) {
        this.lessonErrors = lessonErrors;
    }

    public List<String> getLessonErrors() {
        return lessonErrors;
    }
}
