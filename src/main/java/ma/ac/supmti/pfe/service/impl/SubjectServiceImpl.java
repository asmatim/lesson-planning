package ma.ac.supmti.pfe.service.impl;

import ma.ac.supmti.pfe.dao.SubjectDao;
import ma.ac.supmti.pfe.model.SubjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.ac.supmti.pfe.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public SubjectModel save(SubjectModel subjectModel) {
        return subjectDao.save(subjectModel);
    }

    @Override
    public void delete(SubjectModel subjectModel) {
        subjectDao.delete(subjectModel);
    }
}
