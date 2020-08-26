package ma.ac.supmti.pfe.facade.impl;

import ma.ac.supmti.pfe.dto.ClassDto;
import ma.ac.supmti.pfe.dto.ProfessorDto;
import ma.ac.supmti.pfe.dto.StatsDto;
import ma.ac.supmti.pfe.facade.ProfessorFacade;
import ma.ac.supmti.pfe.model.ClassModel;
import ma.ac.supmti.pfe.model.ProfessorModel;
import ma.ac.supmti.pfe.model.SubjectModel;
import ma.ac.supmti.pfe.service.ClassService;
import ma.ac.supmti.pfe.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProfessorFacadeImpl implements ProfessorFacade {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private ClassService classService;

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

    @Override
    public ProfessorDto getProfessorDto(Long professorId) {
        ProfessorModel professorModel = professorService.getProfessor(professorId);
        return reverseConvert(professorModel);
    }

    @Override
    public StatsDto getStatsFor(Long professorId, Long classId) {
        final ProfessorModel professorModel = professorService.getProfessor(professorId);
        final ClassModel classModel = classService.getOneClass(classId);

        final Map<SubjectModel, Long> totalsBySubject = professorService.getStatsFor(professorModel, classModel);

        StatsDto statsDto = new StatsDto();
        statsDto.setProfessorId(professorId);
        statsDto.setClassId(classId);

        return populateStats(statsDto, totalsBySubject);
    }

    private StatsDto populateStats(StatsDto statsDto, Map<SubjectModel, Long> totalsBySubject) {
        Map<SubjectModel, String> totalsDisplay = new LinkedHashMap<>();
        for (Map.Entry<SubjectModel, Long> entry : totalsBySubject.entrySet()) {
            totalsDisplay.put(entry.getKey(), formatMinutesForDisplay(entry.getValue()));
        }
        statsDto.setTotals(totalsDisplay);
        return statsDto;
    }

    private String formatMinutesForDisplay(Long minutes) {
        long hours = minutes / 60; //since both are ints, you get an int
        long minutesExtra = minutes % 60;
        if(minutesExtra>0) {
            return String.format("%dh%02dm", hours, minutesExtra);
        }
        return String.format("%dh", hours);
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
        professorDto.setBirthdate(professorModel.getBirthdate());
        professorDto.setEmail(professorModel.getEmail());
        professorDto.setCin(professorModel.getCin());
        professorDto.setPhone(professorModel.getPhone());
        return professorDto;
    }

    private ProfessorModel convertProfessor(ProfessorDto professorDto) {
        final ProfessorModel professorModel = new ProfessorModel();
        professorModel.setId(professorDto.getProfessorId());
        professorModel.setFirstName(professorDto.getFirstName());
        professorModel.setLastName(professorDto.getLastName());
        professorModel.setCin(professorDto.getCin());
        professorModel.setEmail(professorDto.getEmail());
        professorModel.setBirthdate(professorDto.getBirthdate());
        professorModel.setPhone(professorDto.getPhone());
        return professorModel;
    }

}
