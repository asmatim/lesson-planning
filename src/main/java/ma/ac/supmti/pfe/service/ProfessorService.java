package ma.ac.supmti.pfe.service;

import ma.ac.supmti.pfe.model.ProfessorModel;

public interface ProfessorService {

    ProfessorModel save(ProfessorModel professorModel);
    void delete(ProfessorModel professorModel);
    void delete(Long professorId);
    ProfessorModel getProfessor(Long professorId);
}
