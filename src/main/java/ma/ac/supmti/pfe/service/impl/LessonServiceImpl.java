package ma.ac.supmti.pfe.service.impl;

import ma.ac.supmti.pfe.dao.LessonDao;
import ma.ac.supmti.pfe.exception.InvalidLessonModelException;
import ma.ac.supmti.pfe.model.ClassModel;
import ma.ac.supmti.pfe.model.ClassroomModel;
import ma.ac.supmti.pfe.model.LessonModel;
import ma.ac.supmti.pfe.model.ProfessorModel;
import ma.ac.supmti.pfe.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.ac.supmti.pfe.service.LessonService;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonDao lessonDao;


    @Override
    public LessonModel save(LessonModel lessonModel) {
        validateLesson(lessonModel);
        return lessonDao.save(lessonModel);
    }

    @Override
    public void delete(LessonModel lessonModel) {
        lessonDao.delete(lessonModel);
    }

    private void validateLesson(LessonModel lessonModel) {
        final List<String> errors = new ArrayList<>();

        if (Boolean.FALSE.equals(checkClassroomIsFree(lessonModel))) {
            errors.add("La salle est occuppée durant ce créneau.");
        }

        if (Boolean.FALSE.equals(checkClassIsFree(lessonModel))) {
            errors.add("La classe a déjà une séance durant ce créneau.");
        }

        if (Boolean.FALSE.equals(checkProfessorIsFree(lessonModel))) {
            errors.add("Le professeur a déjà une séance durant ce créneau.");
        }

        if (!CollectionUtils.isEmpty(errors)) {
            throw new InvalidLessonModelException(errors);
        }
    }

    private Boolean checkClassroomIsFree(LessonModel lessonModel) {
        final ClassroomModel classroomModel = lessonModel.getClassroom();
        final Date lessonStartsAt = lessonModel.getStartDate();
        final Date lessonEndsAt = lessonModel.getEndDate();
        return lessonDao.isClassroomFree(classroomModel, lessonStartsAt, lessonEndsAt);
    }

    private Boolean checkClassIsFree(LessonModel lessonModel) {
        final ClassModel classModel = lessonModel.getClassModel();
        final Date lessonStartsAt = lessonModel.getStartDate();
        final Date lessonEndsAt = lessonModel.getEndDate();
        return lessonDao.isClassFree(classModel, lessonStartsAt, lessonEndsAt);
    }

    private Boolean checkProfessorIsFree(LessonModel lessonModel) {
        final ProfessorModel professorModel = lessonModel.getProfessor();
        final Date lessonStartsAt = lessonModel.getStartDate();
        final Date lessonEndsAt = lessonModel.getEndDate();
        return lessonDao.isProfessorFree(professorModel, lessonStartsAt, lessonEndsAt);
    }
}
