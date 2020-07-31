package ma.ac.supmti.pfe.service;

import ma.ac.supmti.pfe.model.ClassModel;

public interface ClassService {

    ClassModel save(ClassModel classModel);
    void delete(ClassModel classModel);

}
