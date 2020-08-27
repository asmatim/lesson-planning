package ma.ac.supmti.pfe.service;

import ma.ac.supmti.pfe.model.ClassModel;
import ma.ac.supmti.pfe.model.LessonModel;
import ma.ac.supmti.pfe.model.ProfessorModel;

import java.util.Date;
import java.util.List;

public interface LessonService {

    LessonModel save(LessonModel lessonModel);
    void delete(LessonModel lessonModel);
    List<LessonModel> getLessonsByClass(ClassModel classModel);
    LessonModel getLesson(Long lessonId);
    List<LessonModel> getLessonsByClassAndProfessor(ClassModel classModel, ProfessorModel professorModel);
    List<LessonModel> saveRange(LessonModel lessonModel, Date rangeEndDate);

    void deleteRange(LessonModel lessonModel, Date rangeEndDate);
}
