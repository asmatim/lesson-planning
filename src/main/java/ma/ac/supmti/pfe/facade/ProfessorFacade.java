package ma.ac.supmti.pfe.facade;

import ma.ac.supmti.pfe.dto.ProfessorDto;
import ma.ac.supmti.pfe.model.ProfessorModel;

public interface ProfessorFacade {

    void delete(Long professorId);

    ProfessorModel save(ProfessorDto professorDto);

    ProfessorModel getProfessor(Long professorId);
}
