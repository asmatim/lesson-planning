package ma.ac.supmti.pfe.facade.impl;

import ma.ac.supmti.pfe.dto.SubjectDto;
import ma.ac.supmti.pfe.facade.SubjectFacade;
import ma.ac.supmti.pfe.model.ModuleModel;
import ma.ac.supmti.pfe.model.SubjectModel;
import ma.ac.supmti.pfe.service.ModuleService;
import ma.ac.supmti.pfe.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SubjectFacadeImpl  implements SubjectFacade {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ModuleService moduleService;

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

    @Override
    public List<SubjectModel> findAllSubjects() {
        return subjectService.findAllSubjects();
    }

    private SubjectModel convertSubject(SubjectDto subjectDto){
        final SubjectModel subjectModel = new SubjectModel();
        final ModuleModel moduleModel = moduleService.getOne(subjectDto.getModuleId());
        subjectModel.setName(subjectDto.getName());
        subjectModel.setVolume(subjectDto.getVolume());
        subjectModel.setModule(moduleModel);
        return subjectModel;
    }
}