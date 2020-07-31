package ma.ac.supmti.pfe.service;

import ma.ac.supmti.pfe.model.SubjectModel;

public interface SubjectService {

    SubjectModel save(SubjectModel subjectModel);
    void delete(SubjectModel subjectModel);

}
