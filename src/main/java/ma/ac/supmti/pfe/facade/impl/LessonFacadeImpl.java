package ma.ac.supmti.pfe.facade.impl;

import ma.ac.supmti.pfe.dto.LessonDto;
import ma.ac.supmti.pfe.exception.InvalidLessonModelException;
import ma.ac.supmti.pfe.facade.LessonFacade;
import ma.ac.supmti.pfe.model.*;
import ma.ac.supmti.pfe.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class LessonFacadeImpl implements LessonFacade {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private ClassService classService;

    @Autowired
    private LessonService lessonService;

    @Override
    public LessonDto save(LessonDto lessonDto) {
        final LessonDto savedLessonDto;
        LessonModel lessonModel = convertLesson(lessonDto);
        final LessonModel savedLesson;
        try {
            if(Boolean.TRUE.equals(lessonDto.getIsRange())) {
                List<LessonModel> savedLessons = lessonService.saveRange(lessonModel, lessonDto.getRangeEndDate());
                savedLesson = savedLessons.get(0);
            }
            else {
                savedLesson = lessonService.save(lessonModel);
            }
            savedLessonDto = reverseConvert(savedLesson);
        } catch (InvalidLessonModelException invalidLessonModelException) {
            lessonDto.setLessonErrors(invalidLessonModelException.getLessonErrors());
            return lessonDto;
        }

        return savedLessonDto;
    }

    @Override
    public List<LessonDto> getAllLessonDtos(Long classId) {
        ClassModel classModel = classService.getOneClass(classId);
        List<LessonModel> lessonModels = lessonService.getLessonsByClass(classModel);
        return reverseConvertAll(lessonModels);
    }

    @Override
    public LessonDto getLesson(Long lessonId) {
        LessonModel lessonModel = lessonService.getLesson(lessonId);
        return reverseConvert(lessonModel);
    }

    @Override
    public LessonDto deleteLesson(Long lessonId) {
        LessonModel lessonModel = lessonService.getLesson(lessonId);
        LessonDto lessonDto = reverseConvert(lessonModel);
        try {
            lessonService.delete(lessonModel);
        }
        catch (Exception exception) {
            List<String> errors = new ArrayList<>();
            errors.add("Erreur de suppression.");
            lessonDto.setLessonErrors(errors);
        }
        return lessonDto;
    }

    @Override
    public LessonDto deleteLesson(LessonDto lessonDto) {
        if(lessonDto.getIsRange()) {
            LessonModel lessonModel = lessonService.getLesson(lessonDto.getLessonId());
            lessonModel.setStartDate(lessonDto.getStartDate());
            LessonDto removedLessonDto = reverseConvert(lessonModel);
            lessonService.deleteRange(lessonModel, lessonDto.getRangeEndDate());
            return removedLessonDto;
        }
        else {
            return deleteLesson(lessonDto.getLessonId());
        }
    }

    private List<LessonDto> reverseConvertAll(List<LessonModel> lessonModels) {
        List<LessonDto> lessonDtos = new ArrayList<>();
        for (LessonModel lessonModel: lessonModels) {
            lessonDtos.add(reverseConvert(lessonModel));
        }
        return lessonDtos;
    }

    private LessonModel convertLesson(LessonDto lessonDto) {
        LessonModel lessonModel;
        if(Objects.nonNull(lessonDto.getLessonId()) && lessonDto.getLessonId() > 0) {
            lessonModel = lessonService.getLesson(lessonDto.getLessonId());
        }
        else {
            lessonModel = new LessonModel();
        }

        ProfessorModel professorModel = professorService.getProfessor(lessonDto.getProfessorId());
        SubjectModel subjectModel = subjectService.getSubject(lessonDto.getSubjectId());
        ClassModel classModel = classService.getOneClass(lessonDto.getClassId());
        ClassroomModel classroomModel = classroomService.getClassroom(lessonDto.getClassroomId());

        lessonModel.setProfessor(professorModel);
        lessonModel.setSubject(subjectModel);
        lessonModel.setClassModel(classModel);
        lessonModel.setClassroom(classroomModel);
        lessonModel.setStartDate(lessonDto.getStartDate());
        lessonModel.setEndDate(lessonDto.getEndDate());

        return lessonModel;
    }

    private LessonDto reverseConvert(LessonModel lessonModel) {
        LessonDto lessonDto = new LessonDto();
        lessonDto.setLessonId(lessonModel.getId());
        lessonDto.setProfessorId(lessonModel.getProfessor().getId());
        lessonDto.setSubjectId(lessonModel.getSubject().getId());
        lessonDto.setClassId(lessonModel.getClassModel().getId());
        lessonDto.setClassroomId(lessonModel.getClassroom().getId());
        lessonDto.setStartDate(lessonModel.getStartDate());
        lessonDto.setEndDate(lessonModel.getEndDate());
        lessonDto.setSubjectName(lessonModel.getSubject().getName());
        return lessonDto;
    }

}
