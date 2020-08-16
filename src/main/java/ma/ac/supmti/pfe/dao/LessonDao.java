package ma.ac.supmti.pfe.dao;

import ma.ac.supmti.pfe.model.ClassModel;
import ma.ac.supmti.pfe.model.ClassroomModel;
import ma.ac.supmti.pfe.model.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.ac.supmti.pfe.model.LessonModel;

import java.util.Date;

@Repository
public interface LessonDao extends JpaRepository<LessonModel, Long> {

    @Query("SELECT count(les)<1 FROM lesson les WHERE les.classroom = :classroom AND (:lessonStartsAt BETWEEN les.startDate AND les.endDate OR :lessonEndsAt BETWEEN les.startDate AND les.endDate)")
    Boolean isClassroomFree(@Param("classroom") ClassroomModel classroom,@Param("lessonStartsAt") Date lessonStartsAt,@Param("lessonEndsAt") Date lessonEndsAt);

    @Query("SELECT count(les)<1 FROM lesson les WHERE les.classModel = :class AND (:lessonStartsAt BETWEEN les.startDate AND les.endDate OR :lessonEndsAt BETWEEN les.startDate AND les.endDate)")
    Boolean isClassFree(@Param("class") ClassModel classModel,@Param("lessonStartsAt") Date lessonStartsAt,@Param("lessonEndsAt") Date lessonEndsAt);

    @Query("SELECT count(les)<1 FROM lesson les WHERE les.professor = :professor AND (:lessonStartsAt BETWEEN les.startDate AND les.endDate OR :lessonEndsAt BETWEEN les.startDate AND les.endDate)")
    Boolean isProfessorFree(@Param("professor") ProfessorModel professor,@Param("lessonStartsAt") Date lessonStartsAt,@Param("lessonEndsAt") Date lessonEndsAt);
}
