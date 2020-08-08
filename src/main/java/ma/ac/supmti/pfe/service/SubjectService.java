package ma.ac.supmti.pfe.service;

import ma.ac.supmti.pfe.model.ProfessorModel;
import ma.ac.supmti.pfe.model.SubjectModel;

import java.util.List;

public interface SubjectService {

    SubjectModel save(SubjectModel subjectModel);
    void delete(SubjectModel subjectModel);
    void delete(Long subjectId);
    SubjectModel getSubject(Long subjectId);
    List<SubjectModel> findAllSubjects();

}
