package ma.ac.supmti.pfe.facade;

import ma.ac.supmti.pfe.dto.ClassroomDto;
import ma.ac.supmti.pfe.model.ClassroomModel;

import java.util.List;

public interface ClassroomFacade {

    ClassroomModel save(ClassroomDto classroomDto);
    void delete(ClassroomDto classroomDto);
    void delete(Long classroomId);
    List<ClassroomModel> findAllClasses();
    ClassroomModel getClassroom(Long classroomId);
}
