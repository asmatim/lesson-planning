package ma.ac.supmti.pfe.service.impl;

import ma.ac.supmti.pfe.dao.LessonDao;
import ma.ac.supmti.pfe.model.LessonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.ac.supmti.pfe.service.LessonService;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonDao lessonDao;

    @Override
    public LessonModel save(LessonModel lessonModel) {
        return lessonDao.save(lessonModel);
    }

    @Override
    public void delete(LessonModel lessonModel) {
        lessonDao.delete(lessonModel);
    }
}
