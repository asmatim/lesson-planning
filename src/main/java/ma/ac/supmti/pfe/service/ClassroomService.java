package ma.ac.supmti.pfe.service;

import ma.ac.supmti.pfe.model.ClassModel;
import ma.ac.supmti.pfe.model.ClassroomModel;

import java.util.List;

public interface ClassroomService {

    ClassroomModel save(ClassroomModel classroomModel);
    void delete(ClassroomModel classroomModel);
    void delete(Long classroomId);
    List<ClassroomModel> findAllClasses();
    ClassroomModel getClassroom(Long classroomId);
}
