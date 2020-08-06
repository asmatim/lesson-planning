package ma.ac.supmti.pfe.service;

import ma.ac.supmti.pfe.model.ClassModel;

import java.util.List;

public interface ClassService {

    ClassModel save(ClassModel classModel);
    void delete(ClassModel classModel);
    void delete(Long classId);

    ClassModel getOneClass(Long classId);

    List<ClassModel> findAllClasses();
}
