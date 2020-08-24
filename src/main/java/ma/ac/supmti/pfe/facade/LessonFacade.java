package ma.ac.supmti.pfe.facade;

import ma.ac.supmti.pfe.dto.LessonDto;

import java.util.List;

public interface LessonFacade {

    LessonDto save(LessonDto lessonDto);

    List<LessonDto> getAllLessonDtos(Long classId);

    LessonDto getLesson(Long lessonId);

    LessonDto deleteLesson(Long lessonId);
}
