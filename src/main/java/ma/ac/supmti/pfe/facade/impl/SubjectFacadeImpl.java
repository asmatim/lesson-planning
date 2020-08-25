package ma.ac.supmti.pfe.facade.impl;

import ma.ac.supmti.pfe.dto.SubjectDto;
import ma.ac.supmti.pfe.facade.SubjectFacade;
import ma.ac.supmti.pfe.model.ClassModel;
import ma.ac.supmti.pfe.model.ModuleModel;
import ma.ac.supmti.pfe.model.ProfessorModel;
import ma.ac.supmti.pfe.model.SubjectModel;
import ma.ac.supmti.pfe.service.ClassService;
import ma.ac.supmti.pfe.service.ModuleService;
import ma.ac.supmti.pfe.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class SubjectFacadeImpl  implements SubjectFacade {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private ClassService classService;

    @Override
    public SubjectModel save(SubjectDto subjectDto) {
        SubjectModel subjectModel = convertSubject(subjectDto);
        return subjectService.save(subjectModel);
    }

    @Override
    public void delete(SubjectDto subjectDto) {

    }

    @Override
    public void delete(Long subjectId) {
        subjectService.delete(subjectId);
    }

    @Override
    public SubjectModel getSubject(Long subjectId) {
        return subjectService.getSubject(subjectId);
    }

    public List<SubjectModel> getAllSubjects() {
        return subjectService.findAllSubjects();
    }

    @Override
    public List<SubjectDto> getAllSubjectsDtos(Long classId) {
        ClassModel classModel = classService.getOneClass(classId);
        List<SubjectModel> subjects = subjectService.findSubjectsByClass(classModel);
        return reverseConvertAll(subjects);
    }

    @Override
    public SubjectDto getSubjectDto(Long subjectId) {
        SubjectModel subjectModel = subjectService.getSubject(subjectId);
        return reverseConvert(subjectModel);
    }

    private List<SubjectDto> reverseConvertAll(List<SubjectModel> subjects) {
        List<SubjectDto> subjectDtos = new ArrayList<>();
        for (SubjectModel subjectModel : subjects) {
            subjectDtos.add(reverseConvert(subjectModel));
        }
        return subjectDtos;
    }

    private SubjectDto reverseConvert(SubjectModel subjectModel) {
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setSubjectId(subjectModel.getId());
        subjectDto.setName(subjectModel.getName());
        subjectDto.setVolume(subjectModel.getVolume());
        return subjectDto;
    }

    private SubjectModel convertSubject(SubjectDto subjectDto){
        final SubjectModel subjectModel = new SubjectModel();
        final ModuleModel moduleModel = moduleService.getOne(subjectDto.getModuleId());
        subjectModel.setId(subjectDto.getSubjectId());
        subjectModel.setName(subjectDto.getName());
        subjectModel.setVolume(subjectDto.getVolume());
        subjectModel.setModule(moduleModel);
        return subjectModel;
    }
}
