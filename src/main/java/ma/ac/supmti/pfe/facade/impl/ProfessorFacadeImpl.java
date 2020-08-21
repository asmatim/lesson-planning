package ma.ac.supmti.pfe.facade.impl;

import ma.ac.supmti.pfe.dto.ClassDto;
import ma.ac.supmti.pfe.dto.ProfessorDto;
import ma.ac.supmti.pfe.facade.ProfessorFacade;
import ma.ac.supmti.pfe.model.ProfessorModel;
import ma.ac.supmti.pfe.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<ProfessorModel> getAllProfessors() {
        return professorService.findAllProfessors();
    }

    @Override
    public List<ProfessorDto> getAllProfessorsDtos() {
        List<ProfessorModel> professors = professorService.findAllProfessors();
        return reverseConvertAll(professors);
    }

    private List<ProfessorDto> reverseConvertAll(List<ProfessorModel> professors) {
        List<ProfessorDto> professorDtos = new ArrayList<>();
        for (ProfessorModel professorModel : professors) {
            professorDtos.add(reverseConvert(professorModel));
        }
        return professorDtos;
    }

    private ProfessorDto reverseConvert(ProfessorModel professorModel) {
        ProfessorDto professorDto = new ProfessorDto();
        professorDto.setProfessorId(professorModel.getId());
        professorDto.setFirstName(professorModel.getFirstName());
        professorDto.setLastName(professorModel.getLastName());
        return professorDto;
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
