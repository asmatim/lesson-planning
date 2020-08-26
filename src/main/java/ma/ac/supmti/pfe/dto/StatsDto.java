package ma.ac.supmti.pfe.dto;

import ma.ac.supmti.pfe.model.SubjectModel;

import java.util.Map;

public class StatsDto {

    private Long professorId;
    private Long classId;
    private Map<SubjectModel, String> totals;

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public void setTotals(Map<SubjectModel, String> totals) {
        this.totals = totals;
    }

    public Map<SubjectModel, String> getTotals() {
        return totals;
    }
}
