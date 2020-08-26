package ma.ac.supmti.pfe.service.impl;

import ma.ac.supmti.pfe.dao.ProfessorDao;
import ma.ac.supmti.pfe.model.ClassModel;
import ma.ac.supmti.pfe.model.LessonModel;
import ma.ac.supmti.pfe.model.ProfessorModel;
import ma.ac.supmti.pfe.model.SubjectModel;
import ma.ac.supmti.pfe.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.ac.supmti.pfe.service.ProfessorService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorDao professorDao;

    @Autowired
    private LessonService lessonService;

    @Override
    public ProfessorModel save(ProfessorModel professorModel) {
        return professorDao.save(professorModel);
    }

    @Override
    public void delete(ProfessorModel professorModel) {
        professorDao.delete(professorModel);
    }

    @Override
    public void delete(Long professorId) {
        professorDao.deleteById(professorId);
    }

    @Override
    public ProfessorModel getProfessor(Long professorId) {
//        Optional<ProfessorModel> professorModel = professorDao.findById(professorId);
//        if(professorModel.isPresent()) {
//            return professorModel.get();
//        }
//        System.out.println("Professor id " + professorId + " not found in DB!");
//        return null;
        return professorDao.getOne(professorId);
    }

    @Override
    public List<ProfessorModel> findAllProfessors() {
        return professorDao.findAll();
    }

    @Override
    public Map<SubjectModel, Long> getStatsFor(ProfessorModel professorModel, ClassModel classModel) {
        List<LessonModel> lessonModels = lessonService.getLessonsByClassAndProfessor(classModel, professorModel);
        Map<SubjectModel, Long> totalMinutesBySubject = new LinkedHashMap<>();
        for (LessonModel lessonModel: lessonModels) {
            Long lessonDuration = calculateLessonDurationInMunutes(lessonModel);
            Long newDuration = calculateLessonDurationInMunutes(lessonModel);
            if(totalMinutesBySubject.containsKey(lessonModel.getSubject())) {
                Long lastDuration = totalMinutesBySubject.get(lessonModel.getSubject());
                totalMinutesBySubject.replace(lessonModel.getSubject(), lastDuration + newDuration);
            }
            else {
                totalMinutesBySubject.put(lessonModel.getSubject(), newDuration);
            }
        }
        return totalMinutesBySubject;
    }

    private Long calculateLessonDurationInMunutes(LessonModel lessonModel) {
        long diffInMillis = Math.abs(lessonModel.getEndDate().getTime() - lessonModel.getStartDate().getTime());
        long diffInMutes = TimeUnit.MINUTES.convert(diffInMillis, TimeUnit.MILLISECONDS);
        return diffInMutes;
    }
}
