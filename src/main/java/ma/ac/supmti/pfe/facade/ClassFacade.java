package ma.ac.supmti.pfe.facade;

import ma.ac.supmti.pfe.dto.ClassDto;
import ma.ac.supmti.pfe.model.ClassModel;

import java.util.List;

public interface ClassFacade {
    ClassModel save(ClassDto classDto);
    void delete(Long classId);

    ClassModel getOneClass(Long classId);

    List<ClassModel> saveAllClasses();
}

