package ma.ac.supmti.pfe.service.impl;

import ma.ac.supmti.pfe.dao.ProfessorDao;
import ma.ac.supmti.pfe.model.ProfessorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.ac.supmti.pfe.service.ProfessorService;

import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorDao professorDao;

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
}
