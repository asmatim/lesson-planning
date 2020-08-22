package ma.ac.supmti.pfe.service;

import ma.ac.supmti.pfe.model.ClassModel;
import ma.ac.supmti.pfe.model.LessonModel;

import java.util.List;

public interface LessonService {

    LessonModel save(LessonModel lessonModel);
    void delete(LessonModel lessonModel);

    List<LessonModel> getLessonsByClass(ClassModel classModel);
}
