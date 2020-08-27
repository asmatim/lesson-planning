package ma.ac.supmti.pfe.dao;

import ma.ac.supmti.pfe.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LessonDao extends JpaRepository<LessonModel, Long> {

    @Query("SELECT count(les)<1 " +
            "FROM lesson les " +
            "WHERE les.classroom = :classroom " +
            "AND les <> :currentLesson " +
            "AND ( " +
            "        (:lessonStartsAt > les.startDate AND :lessonStartsAt < les.endDate) " +
            "        OR " +
            "        (:lessonEndsAt > les.startDate AND :lessonEndsAt < les.endDate)" +
            "        OR" +
            "        (les.startDate > :lessonStartsAt  AND les.startDate < :lessonEndsAt ) " +
            "        OR " +
            "        (les.endDate > :lessonStartsAt AND les.endDate < :lessonEndsAt)" +
            "        OR" +
            "        (les.startDate = :lessonStartsAt AND les.endDate = :lessonEndsAt)" +
            "    )")
    Boolean isClassroomFree(@Param("classroom") ClassroomModel classroom,@Param("lessonStartsAt") Date lessonStartsAt,@Param("lessonEndsAt") Date lessonEndsAt, @Param("currentLesson") LessonModel lessonModel);

    @Query("SELECT count(les)<1 " +
            "FROM lesson les " +
            "WHERE les.classModel = :class " +
            "AND les <> :currentLesson " +
            "AND ( " +
            "        (:lessonStartsAt > les.startDate AND :lessonStartsAt < les.endDate) " +
            "        OR " +
            "        (:lessonEndsAt > les.startDate AND :lessonEndsAt < les.endDate)" +
            "        OR" +
            "        (les.startDate > :lessonStartsAt  AND les.startDate < :lessonEndsAt ) " +
            "        OR " +
            "        (les.endDate > :lessonStartsAt AND les.endDate < :lessonEndsAt)" +
            "        OR" +
            "        (les.startDate = :lessonStartsAt AND les.endDate = :lessonEndsAt)" +
            "    )")
    Boolean isClassFree(@Param("class") ClassModel classModel,@Param("lessonStartsAt") Date lessonStartsAt,@Param("lessonEndsAt") Date lessonEndsAt, @Param("currentLesson") LessonModel lessonModel);

    @Query("SELECT count(les)<1 " +
            "FROM lesson les " +
            "WHERE les.professor = :professor " +
            "AND les <> :currentLesson " +
            "AND ( " +
            "        (:lessonStartsAt > les.startDate AND :lessonStartsAt < les.endDate) " +
            "        OR " +
            "        (:lessonEndsAt > les.startDate AND :lessonEndsAt < les.endDate)" +
            "        OR" +
            "        (les.startDate > :lessonStartsAt  AND les.startDate < :lessonEndsAt ) " +
            "        OR " +
            "        (les.endDate > :lessonStartsAt AND les.endDate < :lessonEndsAt)" +
            "        OR" +
            "        (les.startDate = :lessonStartsAt AND les.endDate = :lessonEndsAt)" +
            "    )")
    Boolean isProfessorFree(@Param("professor") ProfessorModel professor,@Param("lessonStartsAt") Date lessonStartsAt,@Param("lessonEndsAt") Date lessonEndsAt, @Param("currentLesson") LessonModel lessonModel);

    @Query("SELECT count(les)<1 " +
            "FROM lesson les " +
            "WHERE les.classroom = :classroom " +
            "AND ( " +
            "        (:lessonStartsAt > les.startDate AND :lessonStartsAt < les.endDate) " +
            "        OR " +
            "        (:lessonEndsAt > les.startDate AND :lessonEndsAt < les.endDate)" +
            "        OR" +
            "        (les.startDate > :lessonStartsAt  AND les.startDate < :lessonEndsAt ) " +
            "        OR " +
            "        (les.endDate > :lessonStartsAt AND les.endDate < :lessonEndsAt)" +
            "        OR" +
            "        (les.startDate = :lessonStartsAt AND les.endDate = :lessonEndsAt)" +
            "    )")
    Boolean isClassroomFree(@Param("classroom") ClassroomModel classroom,@Param("lessonStartsAt") Date lessonStartsAt,@Param("lessonEndsAt") Date lessonEndsAt);

    @Query("SELECT count(les)<1 " +
            "FROM lesson les " +
            "WHERE les.classModel = :class " +
            "AND ( " +
            "        (:lessonStartsAt > les.startDate AND :lessonStartsAt < les.endDate) " +
            "        OR " +
            "        (:lessonEndsAt > les.startDate AND :lessonEndsAt < les.endDate)" +
            "        OR" +
            "        (les.startDate > :lessonStartsAt  AND les.startDate < :lessonEndsAt ) " +
            "        OR " +
            "        (les.endDate > :lessonStartsAt AND les.endDate < :lessonEndsAt)" +
            "        OR" +
            "        (les.startDate = :lessonStartsAt AND les.endDate = :lessonEndsAt)" +
            "    )")
    Boolean isClassFree(@Param("class") ClassModel classModel,@Param("lessonStartsAt") Date lessonStartsAt,@Param("lessonEndsAt") Date lessonEndsAt);

    @Query("SELECT count(les)<1 " +
            "FROM lesson les " +
            "WHERE les.professor = :professor " +
            "AND ( " +
            "        (:lessonStartsAt > les.startDate AND :lessonStartsAt < les.endDate) " +
            "        OR " +
            "        (:lessonEndsAt > les.startDate AND :lessonEndsAt < les.endDate)" +
            "        OR" +
            "        (les.startDate > :lessonStartsAt  AND les.startDate < :lessonEndsAt ) " +
            "        OR " +
            "        (les.endDate > :lessonStartsAt AND les.endDate < :lessonEndsAt)" +
            "        OR" +
            "        (les.startDate = :lessonStartsAt AND les.endDate = :lessonEndsAt)" +
            "    )")
    Boolean isProfessorFree(@Param("professor") ProfessorModel professor,@Param("lessonStartsAt") Date lessonStartsAt,@Param("lessonEndsAt") Date lessonEndsAt);

    List<LessonModel> findByClassModel(ClassModel classModel);

    List<LessonModel> findByClassModelAndProfessor(ClassModel classModel, ProfessorModel professorModel);

    List<LessonModel> findByClassModelAndProfessorAndEndDateLessThan(ClassModel classModel, ProfessorModel professorModel, Date currentDate);

    List<LessonModel> findByClassModelAndSubjectAndProfessorAndStartDateBetween(ClassModel classModel, SubjectModel subject, ProfessorModel professor, Date startDate, Date rangeEndDate);
}
