package ma.ac.supmti.pfe.service.impl;

import ma.ac.supmti.pfe.dao.ClassDao;
import ma.ac.supmti.pfe.model.ClassModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.ac.supmti.pfe.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    @Override
    public ClassModel save(ClassModel classModel) {
        return classDao.save(classModel);
    }

    @Override
    public void delete(ClassModel classModel) {
        classDao.delete(classModel);
    }
}
