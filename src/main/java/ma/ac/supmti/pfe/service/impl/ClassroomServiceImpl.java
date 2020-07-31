package ma.ac.supmti.pfe.service.impl;

import ma.ac.supmti.pfe.dao.ClassroomDao;
import ma.ac.supmti.pfe.model.ClassroomModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.ac.supmti.pfe.service.ClassroomService;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomDao classroomDao;

    @Override
    public ClassroomModel save(ClassroomModel classroomModel) {
        return classroomDao.save(classroomModel);
    }

    @Override
    public void delete(ClassroomModel classroomModel) {
        classroomDao.delete(classroomModel);
    }
}
