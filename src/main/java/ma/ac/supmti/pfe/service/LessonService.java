package ma.ac.supmti.pfe.service;

import ma.ac.supmti.pfe.model.LessonModel;

public interface LessonService {

    LessonModel save(LessonModel lessonModel);
    void delete(LessonModel lessonModel);

}
