package ma.ac.supmti.pfe.facade;

import ma.ac.supmti.pfe.dto.SubjectDto;
import ma.ac.supmti.pfe.model.SubjectModel;

import java.util.List;

public interface SubjectFacade {

    SubjectModel save(SubjectDto subjectDto);
    void delete(SubjectDto subjectDto);
    void delete(Long subjectId);
    SubjectModel getSubject(Long subjectId);
    List<SubjectModel> getAllSubjects();

    List<SubjectDto> getAllSubjectsDtos(Long classId);
}
