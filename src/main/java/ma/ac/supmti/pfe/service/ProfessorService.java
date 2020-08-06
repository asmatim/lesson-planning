package ma.ac.supmti.pfe.service;

import ma.ac.supmti.pfe.model.ProfessorModel;

import java.util.List;

public interface ProfessorService {

    ProfessorModel save(ProfessorModel professorModel);
    void delete(ProfessorModel professorModel);
    void delete(Long professorId);
    ProfessorModel getProfessor(Long professorId);
    List<ProfessorModel> findAllProfessors();
}
