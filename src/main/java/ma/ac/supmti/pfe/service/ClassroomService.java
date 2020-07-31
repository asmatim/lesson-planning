package ma.ac.supmti.pfe.service;

import ma.ac.supmti.pfe.model.ClassroomModel;

public interface ClassroomService {

    ClassroomModel save(ClassroomModel classroomModel);
    void delete(ClassroomModel classroomModel);

}
