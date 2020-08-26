package ma.ac.supmti.pfe.service;

import ma.ac.supmti.pfe.model.ClassModel;
import ma.ac.supmti.pfe.model.ProfessorModel;
import ma.ac.supmti.pfe.model.SubjectModel;

import java.util.List;
import java.util.Map;

public interface ProfessorService {

    ProfessorModel save(ProfessorModel professorModel);
    void delete(ProfessorModel professorModel);
    void delete(Long professorId);
    ProfessorModel getProfessor(Long professorId);
    List<ProfessorModel> findAllProfessors();
    Map<SubjectModel, Long> getStatsFor(ProfessorModel professorModel, ClassModel classModel);
}
