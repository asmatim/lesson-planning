package ma.ac.supmti.pfe.facade;

import ma.ac.supmti.pfe.dto.ProfessorDto;
import ma.ac.supmti.pfe.model.ProfessorModel;

import java.util.List;

public interface ProfessorFacade {

    void delete(Long professorId);

    ProfessorModel save(ProfessorDto professorDto);

    ProfessorModel getProfessor(Long professorId);

    List<ProfessorModel> getAllProfessors();

    List<ProfessorDto> getAllProfessorsDtos();

    ProfessorDto getProfessorDto(Long professorId);
}
