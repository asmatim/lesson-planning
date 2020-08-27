package ma.ac.supmti.pfe.dto;

import java.util.Date;
import java.util.List;

public class LessonDto {

    private Long lessonId;
    private Long professorId;
    private Long classroomId;
    private Long classId;
    private Long subjectId;
    private String subjectName;
    private Date startDate;
    private Date endDate;
    private Boolean isRange;
    private Date rangeEndDate;

    private List<String> lessonErrors;

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

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

    public Boolean getIsRange() {
        return isRange;
    }

    public void setIsRange(Boolean isRange) {
        this.isRange = isRange;
    }

    public Date getRangeEndDate() {
        return rangeEndDate;
    }

    public void setRangeEndDate(Date rangeEndDate) {
        this.rangeEndDate = rangeEndDate;
    }
}
