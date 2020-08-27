package ma.ac.supmti.pfe.service.impl;

import ma.ac.supmti.pfe.dao.LessonDao;
import ma.ac.supmti.pfe.exception.InvalidLessonModelException;
import ma.ac.supmti.pfe.model.ClassModel;
import ma.ac.supmti.pfe.model.ClassroomModel;
import ma.ac.supmti.pfe.model.LessonModel;
import ma.ac.supmti.pfe.model.ProfessorModel;
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

    @Override
    public List<LessonModel> getLessonsByClass(ClassModel classModel) {
        return lessonDao.findByClassModel(classModel);
    }

    @Override
    public LessonModel getLesson(Long lessonId) {
        return lessonDao.getOne(lessonId);
    }

    @Override
    public List<LessonModel> getLessonsByClassAndProfessor(ClassModel classModel, ProfessorModel professorModel) {
        return lessonDao.findByClassModelAndProfessorAndEndDateLessThan(classModel, professorModel, new Date());
    }

    @Override
    public List<LessonModel> saveRange(LessonModel lessonModel, Date rangeEndDate) {
        List<LessonModel> lessonModels = createRange(lessonModel, rangeEndDate);
        validateLessons(lessonModels);
        return lessonDao.saveAll(lessonModels);
    }

    @Override
    public void deleteRange(LessonModel lessonModel, Date rangeEndDate) {
        List<LessonModel> lessonModels = lessonDao.findByClassModelAndSubjectAndProfessorAndStartDateBetween(
                lessonModel.getClassModel(), lessonModel.getSubject(), lessonModel.getProfessor(),
                lessonModel.getStartDate(), rangeEndDate);

        lessonDao.deleteAll(lessonModels);
    }

    private void validateLessons(List<LessonModel> lessonModels) {
        for (LessonModel lessonModel : lessonModels) {
            // will throw exception in case of invalid
            validateLesson(lessonModel);
        }
    }

    private List<LessonModel> createRange(LessonModel lessonModel, Date rangeEndDate) {
        final List<LessonModel> lessonModels = new ArrayList<>();
        LessonModel lessonToAdd = lessonModel;
        while (lessonToAdd.getStartDate().before(rangeEndDate)) {
            lessonModels.add(lessonToAdd);
            lessonToAdd = new LessonModel(lessonToAdd); // clone the object and set a new object with new date
            lessonToAdd.setStartDate(getNextWeekDate(lessonToAdd.getStartDate()));
            lessonToAdd.setEndDate(getNextWeekDate(lessonToAdd.getEndDate()));
        }
        return lessonModels;
    }

    private Date getNextWeekDate(Date dateToChange) {
        Date newDate = new Date(dateToChange.getTime());
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(newDate);
        calendar.add(Calendar.DATE, 7);
        newDate.setTime(calendar.getTime().getTime());

        return newDate;
    }

    private void validateLesson(LessonModel lessonModel) {
        final List<String> errors = new ArrayList<>();

        if (Boolean.FALSE.equals(checkDatesOrder(lessonModel))) {
            errors.add("La date/heure de début de la séance doit être antérieure à la date de fin.");
        }

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

    private Boolean checkDatesOrder(LessonModel lessonModel) {
        final Date lessonStartsAt = lessonModel.getStartDate();
        final Date lessonEndsAt = lessonModel.getEndDate();
        return lessonStartsAt.before(lessonEndsAt);
    }

    private Boolean checkClassroomIsFree(LessonModel lessonModel) {
        final ClassroomModel classroomModel = lessonModel.getClassroom();
        final Date lessonStartsAt = lessonModel.getStartDate();
        final Date lessonEndsAt = lessonModel.getEndDate();
        if (Objects.nonNull(lessonModel.getId())) {
            return lessonDao.isClassroomFree(classroomModel, lessonStartsAt, lessonEndsAt, lessonModel);
        } else {
            return lessonDao.isClassroomFree(classroomModel, lessonStartsAt, lessonEndsAt);
        }

    }

    private Boolean checkClassIsFree(LessonModel lessonModel) {
        final ClassModel classModel = lessonModel.getClassModel();
        final Date lessonStartsAt = lessonModel.getStartDate();
        final Date lessonEndsAt = lessonModel.getEndDate();
        if (Objects.nonNull(lessonModel.getId())) {
            return lessonDao.isClassFree(classModel, lessonStartsAt, lessonEndsAt, lessonModel);
        } else {
            return lessonDao.isClassFree(classModel, lessonStartsAt, lessonEndsAt);
        }
    }

    private Boolean checkProfessorIsFree(LessonModel lessonModel) {
        final ProfessorModel professorModel = lessonModel.getProfessor();
        final Date lessonStartsAt = lessonModel.getStartDate();
        final Date lessonEndsAt = lessonModel.getEndDate();
        if (Objects.nonNull(lessonModel.getId())) {
            return lessonDao.isProfessorFree(professorModel, lessonStartsAt, lessonEndsAt, lessonModel);
        } else {
            return lessonDao.isProfessorFree(professorModel, lessonStartsAt, lessonEndsAt);
        }
    }
}
