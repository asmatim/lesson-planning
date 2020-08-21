package ma.ac.supmti.pfe.service.impl;

import ma.ac.supmti.pfe.dao.SubjectDao;
import ma.ac.supmti.pfe.model.ClassModel;
import ma.ac.supmti.pfe.model.SubjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.ac.supmti.pfe.service.SubjectService;

import java.util.List;

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

    @Override
    public void delete(Long subjectId) {
        subjectDao.deleteById(subjectId);
    }

    @Override
    public SubjectModel getSubject(Long subjectId) {
        return subjectDao.getOne(subjectId);
    }

    @Override
    public List<SubjectModel> findAllSubjects() {
        return subjectDao.findAll();
    }

    @Override
    public List<SubjectModel> findSubjectsByClass(ClassModel classModel) {
        return subjectDao.findByClass(classModel);
    }
}
