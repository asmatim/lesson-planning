package ma.ac.supmti.pfe.facade.impl;

import ma.ac.supmti.pfe.dto.ProfessorDto;
import ma.ac.supmti.pfe.facade.ProfessorFacade;
import ma.ac.supmti.pfe.model.ProfessorModel;
import ma.ac.supmti.pfe.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfessorFacadeImpl implements ProfessorFacade {

    @Autowired
    private ProfessorService professorService;

    @Override
    public void delete(Long professorId) {
        professorService.delete(professorId);
    }

    @Override
    public ProfessorModel save(ProfessorDto professorDto) {
        ProfessorModel professorModel = convertProfessor(professorDto);
        return professorService.save(professorModel);
    }

    @Override
    public ProfessorModel getProfessor(Long professorId) {
        return professorService.getProfessor(professorId);
    }

    private ProfessorModel convertProfessor(ProfessorDto professorDto) {
        final ProfessorModel professorModel = new ProfessorModel();
        professorModel.setFirstName(professorDto.getFirstName());
        professorModel.setLastName(professorDto.getLastName());
        professorModel.setCin(professorDto.getCin());
        professorModel.setEmail(professorDto.getEmail());
        professorModel.setBirthdate(professorDto.getBirthdate());
        professorModel.setPhone(professorDto.getPhone());
        return professorModel;
    }
}
